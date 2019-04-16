package services;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import services.*;

import jpa.*;

public class ServiceRegistrar {
	
	public List<Object []> getStudentRequest(int a_year , String t_name)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(student_registration.class).addAnnotatedClass(student.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Query q = session.createQuery("select distinct sr.srid.std_id, sr.registration_date from student_registration sr where sr.approval_status = FALSE and sr.srid.taid.t_name ='"+t_name+"' and sr.srid.taid.a_year="+a_year);
        List<Object []> result = (List<Object []>)q.getResultList();
        List<Object []> ans = new ArrayList<>();
        
        for(Object [] id : result)
        {
        	student s = session.load(student.class, (Integer)id[0]);
        	Object a[] = new Object[2];
        	a[0] = s;
        	a[1] = id[1];
        	ans.add(a);
        }
        tx.commit();
        return ans;
	}
	
	public List<Object []> getStudentRegistered(int a_year , String t_name)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(student_registration.class).addAnnotatedClass(student.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Query q = session.createQuery("select distinct sr.srid.std_id , sr.registration_date from student_registration sr where sr.approval_status = TRUE and sr.srid.taid.t_name ='"+t_name+"' and sr.srid.taid.a_year="+a_year);
        List<Object []> result = (List<Object []>)q.getResultList();
        List<Object []> ans = new ArrayList<>();
        
        for(Object [] id : result)
        {
        	student s = session.load(student.class, (Integer)id[0]);
        	Object a[] = new Object[2];
        	a[0] = s;
        	a[1] = id[1];
        	ans.add(a);
        }
        tx.commit();
        return ans;
	}
	
	public List<Object []> getStudentRegisteredByCourse(int a_year , String t_name , String c_code)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(student_registration.class).addAnnotatedClass(student.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Query q = session.createQuery("select distinct sr.srid.std_id , sr.grade from student_registration sr where sr.approval_status = TRUE and sr.srid.taid.t_name ='"+t_name+"' and sr.srid.taid.a_year="+a_year+" and sr.srid.c_code='"+c_code+"'");
        List<Object []> result = (List<Object []>)q.getResultList();
        List<Object []> ans = new ArrayList<>();
        
        for(Object [] id : result)
        {
        	student s = session.load(student.class, (Integer)id[0]);
        	Object a[] = new Object[2];
        	a[0] = s;
        	a[1] = id[1];
        	ans.add(a);
        }
        tx.commit();
        return ans;
	}
	
	public void conformRegister(List<Integer> sid , String sem , List<String> remark)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(student_registration.class).addAnnotatedClass(student.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        for(int i=0;i<sid.size();i++)
        {
        	List<String> a = new ServiceStudent().getTermAcadFromSemesterAndStdId(sid.get(i),sem) ;
        	int a_year = Integer.parseInt(a.get(1));
        	String t_name = a.get(0);
        	Query q = session.createQuery("update student_registration set remark=:remark , approval_status=:a where std_id ="+sid.get(i)+" and a_year="+a_year+" and t_name='"+t_name+"'");
            q.setParameter("a",true);
            q.setParameter("remark", remark.get(i));
            q.executeUpdate();
        }
        tx.commit();
        return;
	}
	
	public void conformUnRegister(List<Integer> sid , String sem)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(student_registration.class).addAnnotatedClass(student.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        for(int i : sid)
        {
        	List<String> a = new ServiceStudent().getTermAcadFromSemesterAndStdId(i,sem) ;
        	int a_year = Integer.parseInt(a.get(1));
        	String t_name = a.get(0);
        	Query q = session.createQuery("delete from student_registration where approval_status=TRUE and std_id ="+i+" and a_year="+a_year+" and t_name='"+t_name+"'");
            q.executeUpdate();
        }
        tx.commit();
        return;
	}
	
	public void addReminderSchedule(reminder r)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(reminder.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Query q = session.createQuery("select r from reminder r where r.rid.taid.t_name='"+r.getRid().getTaid().getT_name()+"' and r.rid.taid.a_year="+r.getRid().getTaid().getA_year());
        reminder x = (reminder)q.uniqueResult();
        
        if(q.uniqueResult()==null)
        	session.save(r);
        else
        {
        	Query q1 = session.createQuery("update reminder set open_registration=:oa , close_registration=:ca , reminder_date=:rd where t_name='"+r.getRid().getTaid().getT_name()+"' and a_year="+r.getRid().getTaid().getA_year());
            q1.setParameter("oa", r.getOpen_registration());
            q1.setParameter("ca", r.getClose_registration());
            q1.setParameter("rd", r.getReminder_date());
            q1.executeUpdate();
        }

        tx.commit();
		return;
	}
	
	public void updateReminderSchedule(reminder r)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(reminder.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Query q = session.createQuery("update reminder set open_adddrop=:oa , close_adddrop=:ca , reminder_date=:rd where t_name='"+r.getRid().getTaid().getT_name()+"' and a_year="+r.getRid().getTaid().getA_year());
        q.setParameter("oa", r.getOpen_adddrop());
        q.setParameter("ca", r.getClose_adddrop());
        q.setParameter("rd", r.getReminder_date());
        q.executeUpdate();
        tx.commit();
		return;
	}
	
	public List<Object []> getResultAllSemByStd(int std)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(student.class).addAnnotatedClass(student_registration.class).addAnnotatedClass(course.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Query q = session.createQuery("select s , sr , c from student s , student_registration sr , course c where s.std_id = sr.srid.std_id and s.std_id="+std+" and sr.srid.c_code = c.c_code");
        List<Object []> result = (List<Object []>)q.getResultList();
		return result;
	}
	
	public int getSemFromStdAcadTerm(int std , int acad , String t_name)
	{
		int base = std / 100000;
		int diff = acad - base;
		
		int sem = 0;
		
		if(t_name.equals("Autumn"))
		{
			if(diff==0)
				sem=1;
			else if(diff==1)
				sem=3;
			else if(diff==2)
				sem=5;
			else
				sem=7;
		}
		else
		{
			if(diff==0)
				sem=2;
			else if(diff==1)
				sem=4;
			else if(diff==2)
				sem=6;
			else
				sem=8;
		}
		
		return sem;
	}
}

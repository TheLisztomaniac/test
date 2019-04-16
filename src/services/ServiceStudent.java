package services;
import java.time.LocalDate;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jpa.*;

public class ServiceStudent {
	
	public List<String> getTermAcadFromSemesterAndStdId(int stdid , String ss)
	{
		int sid = stdid/100000;
		String s[] = ss.split(" ");
		
		String term = "";
		int acad = 0;
		
		if(s[0].equals("semester"))
		{
			int sem = Integer.parseInt(s[1]);
			if(sem%2==0)
			{
				term = "Winter";
				acad = sid + (sem/2) - 1;
			}
			else
			{
				term = "Autumn";
				acad = sid + sem/2 ;
			}
		}
		else
		{
			int sem = Integer.parseInt(s[1]);
			term = "Summer";
			acad = sid + sem - 1;
		}
		
		List<String> ans = new ArrayList<>();
		ans.add(term);ans.add(Integer.toString(acad));
		
		return ans;
	}
	
	public List<Object []> getCourseResultInTermAcad(int std , int acad , String term)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(student_registration.class).addAnnotatedClass(course.class).addAnnotatedClass(offer.class).addAnnotatedClass(offered_slot.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Query q = session.createQuery("select sr , c , os , o from student_registration sr , course c , offered_slot os , offer o where sr.srid.taid.t_name ='"+term+"' and sr.srid.taid.a_year="+acad+" and sr.srid.std_id ="+std+" and c.c_code = sr.srid.c_code and"
        		+ " o.offer_id=os.osid.offer_id and o.c_code = c.c_code and o.c_code = sr.srid.c_code and o.a_year="+acad+" and o.t_name='"+term+"'");
        List<Object []> result = (List<Object []>)q.getResultList();
        return result;
	}
	
	public List<Object []> getCourseInTermAcad(int std_id , int a_year , String t_name)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(offered_slot.class).addAnnotatedClass(program.class).addAnnotatedClass(offer.class).addAnnotatedClass(course.class).addAnnotatedClass(slot.class).addAnnotatedClass(student.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Query q = session.createQuery("select os,o,p,s,c,std from offered_slot os , offer o, program p , slot s , course c, student std where os.osid.pbid.p_id = std.p_id and"
        			+ " os.osid.offer_id = o.offer_id and o.c_code = c.c_code and o.t_name = '"+t_name+"' and o.a_year = "+a_year+" and p.p_id = std.p_id and std.std_id = "+std_id+" and s.slot_no = os.osid.slot_no");
    
        List<Object []> result = (List<Object []>)q.getResultList();
        return result;
	}
	
	public List<Object []> [] getSoltWiseCourse(List<Object []> ans)
	{
		ServiceSlot ss = new ServiceSlot();
		List<slot> a = ss.getSlot();
		
		List<Object []> result[] = new ArrayList[a.size() + 1];
		
		for(int i=0;i<=a.size();i++)
			result[i] = new ArrayList<>();
		
		for(Object [] i :ans)
		{
			offered_slot os = (offered_slot)i[0];
			course c = (course)i[4];
			
			result[os.getOsid().getSlot_no()].add(i);
		}
		
		return result;
	}
	
	public List<course> getElectives(String type , List<Object []> ans)
	{
		List<course> result = new ArrayList<>();
		
		for(Object [] i : ans)
		{
			offered_slot os = (offered_slot)i[0];
			course c = (course)i[4];
			
			if(os.getC_type().equals(type) && !result.contains(c))
				result.add(c);
		}
		return result;
	}
	
	public find_result getResult(int std_id)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(find_result.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Query q = session.createQuery("select fr from find_result fr where fr.std_id="+std_id);
        find_result result = (find_result)q.uniqueResult();
        return result;
	}
	
	public void addResult(int std_id,int sem,double ccr,double cca,double cgp,double spi,double tcr,double tca,double tgp,double cpi)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(find_result.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Object o = session.load(find_result.class,std_id);
        find_result fr = (find_result)o;
        
        if(sem==1)
        {
        	fr.setS1_cpi(cpi);
        	fr.setS1_credit_achieved(cca);
        	fr.setS1_credit_register(ccr);
        	fr.setS1_grade_point(cgp);
        	fr.setS1_spi(spi);
        	fr.setS1_till_credit_achieved(tca);
        	fr.setS1_till_credit_register(tcr);
        	fr.setS1_till_grade_point(tgp);
        }
        else if(sem==2)
        {
        	fr.setS2_cpi(cpi);
        	fr.setS2_credit_achieved(cca);
        	fr.setS2_credit_register(ccr);
        	fr.setS2_grade_point(cgp);
        	fr.setS2_spi(spi);
        	fr.setS2_till_credit_achieved(tca);
        	fr.setS2_till_credit_register(tcr);
        	fr.setS2_till_grade_point(tgp);
        }
        else if(sem==3)
        {
        	fr.setS3_cpi(cpi);
        	fr.setS3_credit_achieved(cca);
        	fr.setS3_credit_register(ccr);
        	fr.setS3_grade_point(cgp);
        	fr.setS3_spi(spi);
        	fr.setS3_till_credit_achieved(tca);
        	fr.setS3_till_credit_register(tcr);
        	fr.setS3_till_grade_point(tgp);
        }
        else if(sem==4)
        {
        	fr.setS4_cpi(cpi);
        	fr.setS4_credit_achieved(cca);
        	fr.setS4_credit_register(ccr);
        	fr.setS4_grade_point(cgp);
        	fr.setS4_spi(spi);
        	fr.setS4_till_credit_achieved(tca);
        	fr.setS4_till_credit_register(tcr);
        	fr.setS4_till_grade_point(tgp);
        }
        else if(sem==5)
        {
        	fr.setS5_cpi(cpi);
        	fr.setS5_credit_achieved(cca);
        	fr.setS5_credit_register(ccr);
        	fr.setS5_grade_point(cgp);
        	fr.setS5_spi(spi);
        	fr.setS5_till_credit_achieved(tca);
        	fr.setS5_till_credit_register(tcr);
        	fr.setS5_till_grade_point(tgp);
        }
        else if(sem==6)
        {
        	fr.setS6_cpi(cpi);
        	fr.setS6_credit_achieved(cca);
        	fr.setS6_credit_register(ccr);
        	fr.setS6_grade_point(cgp);
        	fr.setS6_spi(spi);
        	fr.setS6_till_credit_achieved(tca);
        	fr.setS6_till_credit_register(tcr);
        	fr.setS6_till_grade_point(tgp);
        }
        else if(sem==7)
        {
        	fr.setS7_cpi(cpi);
        	fr.setS7_credit_achieved(cca);
        	fr.setS7_credit_register(ccr);
        	fr.setS7_grade_point(cgp);
        	fr.setS7_spi(spi);
        	fr.setS7_till_credit_achieved(tca);
        	fr.setS7_till_credit_register(tcr);
        	fr.setS7_till_grade_point(tgp);
        }
        else if(sem==8)
        {
        	fr.setS8_cpi(cpi);
        	fr.setS8_credit_achieved(cca);
        	fr.setS8_credit_register(ccr);
        	fr.setS8_grade_point(cgp);
        	fr.setS8_spi(spi);
        	fr.setS8_till_credit_achieved(tca);
        	fr.setS8_till_credit_register(tcr);
        	fr.setS8_till_grade_point(tgp);
        }
        
        tx.commit();
        
        return;
	}
	
	public requirment getRequirment(int std)
	{
		
		Configuration con = new Configuration().configure().addAnnotatedClass(requirment.class).addAnnotatedClass(student.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Query q1 = session.createQuery("select s from student s where s.std_id="+std);
        student s = (student)q1.uniqueResult();
        
        Query q = session.createQuery("select r from requirment r where r.pbid.batch_name="+s.getBatch_name()+" and r.pbid.p_id = "+s.getP_id());
        requirment result = (requirment)q.uniqueResult();
        
        return result;
	}
	
	public List<Object []> getRegisteredCourse(int std)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(offered_slot.class).addAnnotatedClass(offer.class).addAnnotatedClass(course.class).addAnnotatedClass(student_registration.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Query q = session.createQuery("select sr , os , o , c from student_registration sr , offered_slot os , offer o , course c where sr.srid.std_id ="+std+" and sr.srid.c_code = c.c_code and o.c_code = sr.srid.c_code and o.offer_id = os.osid.offer_id and o.t_name = sr.srid.taid.t_name and o.a_year = sr.srid.taid.a_year");
        List<Object []> result = (List<Object []>)q.getResultList();
        return result;
	}
	
	public int getCurrentCourseNoByType(int std,String sem , String type , List<String> c_code,int all)
	{
		
		int ans = 0;
		
		if(all==0)
		{
			List<String> ta = getTermAcadFromSemesterAndStdId(std, sem);
			List<Object []> r = getCourseInTermAcad(std, Integer.parseInt(ta.get(1)), ta.get(0));
			
			for(Object [] i : r)
			{
				offered_slot os = (offered_slot)i[0];
				course cc = (course)i[4];
				if(os.getC_type().equals(type) && c_code.contains(cc.getC_code()))
					ans++;
			}
		}
		else
		{
			List<Object []> r = getRegisteredCourse(std);
			
			for(Object [] i : r)
			{
				offered_slot os = (offered_slot)i[1];
				if(os.getC_type().equals(type))
					ans++;
			}
		}
		
		return ans;
	}
	
	public List<Object []> getCurrentCourseFromCourseCode(int std,String sem, List<String> c_code)
	{
		List<Object [] > result = new ArrayList<>();
		List<String> ta = getTermAcadFromSemesterAndStdId(std, sem);
		List<Object []> r = getCourseInTermAcad(std, Integer.parseInt(ta.get(1)), ta.get(0));
		
		for(Object [] i : r)
		{
			course cc = (course)i[4];
		
			if(c_code.contains(cc.getC_code()))
				result.add(i);
		}
		
		return result;
	}
	
	public void RegisterStudent(int std , int a_year , String t_name , List<String> c , String remark)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(student_registration.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        for(String i : c)
        {
        	student_registration_id srid = new student_registration_id(t_name, a_year, std, i);
        	student_registration sr = new student_registration();
        	sr.setSrid(srid);
        	sr.setApproval_status(false);
        	sr.setRegistration_date(new Date());
        	sr.setRemark(remark);
        	session.save(sr);
        }
        tx.commit();
        return;
	}
	
	public student getStudent(int std)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(requirment.class).addAnnotatedClass(student.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Query q = session.createQuery("select s from student s where s.std_id="+std);
        student result = (student)q.uniqueResult();
        
        return result;
	}
	
	public void editStudent(student ss)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(student.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Object o = session.load(student.class , ss.getStd_id());
        student s = (student)o;
        s.setStd_id(ss.getStd_id());
        s.setBatch_name(ss.getBatch_name());
        s.setBirth_date(ss.getBirth_date());
        s.setBlood_grp(ss.getBlood_grp());
        s.setContact_number(ss.getContact_number());
        s.setGender(ss.getGender());
        s.setHeight(ss.getHeight());
        s.setId_mark(ss.getId_mark());
        s.setP_id(ss.getP_id());
        s.setStd_name(ss.getStd_name());
        s.setAddress(ss.getAddress());
        tx.commit();
	}
	
	public boolean checkValidity(int a_year,String t_name)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(reminder.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Query q = session.createQuery("select r from reminder r where r.rid.taid.t_name='"+t_name+"' and r.rid.taid.a_year="+a_year);
        reminder s = (reminder)q.uniqueResult();
        
        Date od = s.getOpen_registration();
        Date cd = s.getClose_registration();
        Date ccd = new Date();
        
		return (ccd.compareTo(od)>=0 && cd.compareTo(ccd)>=0) ? true : false;
	}
	
	public boolean checkValidityAddDrop(int a_year,String t_name)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(reminder.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Query q = session.createQuery("select r from reminder r where r.rid.taid.t_name='"+t_name+"' and r.rid.taid.a_year="+a_year);
        reminder s = (reminder)q.uniqueResult();
        
        Date od = s.getOpen_adddrop();
        Date cd = s.getClose_adddrop();
        Date ccd = new Date();
        
		return (ccd.compareTo(od)>=0 && cd.compareTo(ccd)>=0) ? true : false;
	}
	
	public void deleteRegisterCourse(List<String> c_code , int std,String sem)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(student_registration.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        List<String> a = getTermAcadFromSemesterAndStdId(std, sem);
        String term = a.get(0);
        int acad = Integer.parseInt(a.get(1));
        
        for(String i : c_code)
        {
        	Query q = session.createQuery("delete from student_registration where srid.std_id="+std+" and srid.c_code='"+i+"' and srid.taid.t_name='"+term+"' and srid.taid.a_year="+acad);
        	q.executeUpdate();
        }
        tx.commit();
        return;
	}
	
	public void deleteRegisteredStudent(int std , int a_year , String t_name)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(student_registration.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
    	Query q = session.createQuery("delete from student_registration where srid.std_id="+std+" and srid.taid.t_name='"+t_name+"' and srid.taid.a_year="+a_year);
    	q.executeUpdate();
        
        tx.commit();
        return;
	}
	
	public List<student> getStudentListInSem(int p_id,int b_name,String sem)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(student.class).addAnnotatedClass(student_registration.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        List<String> a = getTermAcadFromSemesterAndStdId(Integer.parseInt(b_name+"00000"), sem);
        int a_year = Integer.parseInt(a.get(1));
        String t_name = a.get(0);
        
        Query q = session.createQuery("select s from student s where s.batch_name="+b_name+" and s.p_id="+p_id+" and s.std_id in ( select distinct sr.srid.std_id from student_registration sr where sr.srid.taid.t_name='"+t_name+"' and sr.srid.taid.a_year="+a_year+")");
        List<student> result = (List<student>)q.getResultList();
    
        tx.commit();
        return result;
	}
	
	public List<student> getStudentListNotInSem(int p_id,int b_name,String sem)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(student.class).addAnnotatedClass(student_registration.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        List<String> a = getTermAcadFromSemesterAndStdId(Integer.parseInt(b_name+"00000"), sem);
        int a_year = Integer.parseInt(a.get(1));
        String t_name = a.get(0);
        
        Query q = session.createQuery("select s from student s where s.batch_name="+b_name+" and s.p_id="+p_id+" and s.std_id not in ( select distinct sr.srid.std_id from student_registration sr where sr.srid.taid.t_name='"+t_name+"' and sr.srid.taid.a_year="+a_year+")");
        List<student> result = (List<student>)q.getResultList();
        
        tx.commit();
        return result;
	}
}

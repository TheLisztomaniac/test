package services;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jpa.*;

public class ServiceOffer {

	public List<Object []> getOfferByTermAndYear(String t_name,int a_year)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(offer.class).addAnnotatedClass(faculty.class).addAnnotatedClass(course.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("select o,f,c from offer o,faculty f,course c where o.f_id = f.f_id and o.c_code = c.c_code and "
        		+ "o.t_name='"+t_name+"' and o.a_year="+a_year);
        List<Object []> result = (List<Object []>)q.getResultList();
        return result;
	}
	
	public List<Object []> getSlotOfferByTermAndYear(String t_name,int a_year)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(offer.class).addAnnotatedClass(faculty.class).addAnnotatedClass(course.class).addAnnotatedClass(offered_slot.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("select o,f,c from offer o,faculty f,course c where o.offer_id not in (select a.osid.offer_id from offered_slot a) and o.f_id = f.f_id and o.c_code = c.c_code and "
        		+ "o.t_name='"+t_name+"' and o.a_year="+a_year);
        List<Object []> result = (List<Object []>)q.getResultList();
        return result;
	}
	
	public void addAcadTermCourseOffer(String t_name,int a_year,int f_id,String c_code)
	{
		offer o = new offer();
		o.setA_year(a_year);
		o.setT_name(t_name);
		o.setC_code(c_code);
		o.setF_id(f_id);
		Configuration con = new Configuration().configure().addAnnotatedClass(offer.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(o);
        tx.commit();
        return;
	}
	
	public void editAcadTermCourseOffer(String t_name,int a_year,int f_id,String c_code,int offer_id)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(offer.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("update offer o set t_name=:t_name , a_year=:a_year , f_id=:f_id,c_code=:c_code where o.offer_id = "+offer_id);
        q.setParameter("t_name", t_name);
        q.setParameter("a_year", a_year);
        q.setParameter("f_id", f_id);
        q.setParameter("c_code",c_code);
        q.executeUpdate();
        tx.commit();
		return;
	}
	
	public void deleteAcadTermCourseOffer(String t_name,int a_year,int f_id,String c_code,int offer_id)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(offer.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("select o from offer o where o.c_code ='"+c_code+"' and o.a_year="+a_year+" and o.t_name='"+t_name+"' and o.f_id="+f_id+" and o.offer_id="+offer_id);
        offer result = (offer)q.uniqueResult();
        session.remove(result);
        tx.commit();
        return;
	}
	
	public void addSlotAcadTermCourse(List<Integer> p_id, List<Integer> batch_name, int oi, int si,String type)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(offered_slot.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        for(int pid : p_id)
        {
        	for(int bn : batch_name)
        	{
        		offered_slot_id osid = new offered_slot_id(pid, bn, oi, si);
        		offered_slot os = new offered_slot();
        		os.setOsid(osid);
        		os.setC_type(type);
        		session.save(os);
        	}
        }
        tx.commit();
        return;
	}
}

package services;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jpa.*;

public class ServiceFaculty {
	
	public List<faculty> getFaculty()
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(faculty.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Query q = session.createQuery("select f from faculty f");
        List<faculty> result = (List<faculty>)q.getResultList();
        return result;
	}
	
	public List<Integer> getFacultyId()
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(faculty.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Query q = session.createQuery("select f.f_id from faculty f");
        List<Integer> result = (List<Integer>)q.getResultList();
        return result;
	}
	
	public List<String> getFacultyName()
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(faculty.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Query q = session.createQuery("select f.f_name from faculty f");
        List<String> result = (List<String>)q.getResultList();
        return result;
	}
}

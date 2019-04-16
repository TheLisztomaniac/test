package services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jpa.*;

public class ServiceYear {
	
	public List<acad_year> getYear()
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(acad_year.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Query q = session.createQuery("select a from acad_year a");
        List<acad_year> result = (List<acad_year>)q.getResultList();
        return result;
	}
	
	public void addYear(int year)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(acad_year.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        acad_year temp_year = new acad_year();
        temp_year.setA_year(year);
        session.save(temp_year);
        tx.commit();
	}
	public void deleteYear(int year)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(acad_year.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        acad_year temp_year = new acad_year();
        temp_year.setA_year(year);
        session.remove(temp_year);
        tx.commit();
	}
}

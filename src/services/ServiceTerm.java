package services;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jpa.*;

public class ServiceTerm {
	
	public List<term> getTerm()
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(term.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Query q = session.createQuery("select t from term t");
        List<term> result = (List<term>)q.getResultList();
        return result;
	}
	
	public term getTermByTaid(term_acad_id taid)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(term.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        System.out.println(taid.getT_name());
        Query q = session.createQuery("select t from term t where t.taid.a_year="+taid.getA_year()+" and t.taid.t_name='"+taid.getT_name()+"'");
        List<term> result = (List<term>)q.getResultList();
        System.out.println(result.get(0));
        return result.get(0);
	}
	public List<term> getTermByAcadYear(int a_year)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(term.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Query q = session.createQuery("select t from term t where t.taid.a_year="+a_year);
        List<term> result = (List<term>)q.getResultList();
        return result;
	}
	
	public void addTerm(term T)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(term.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        session.save(T);
        tx.commit();
	}
	
	public void deleteTerm(term_acad_id taid)
	{
		System.out.println(taid);
		Configuration con = new Configuration().configure().addAnnotatedClass(term.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.remove(getTermByTaid(taid));
        tx.commit();
	}
	
	public void editTerm(term_acad_id taid,term t)
	{
		System.out.println(taid);
		Configuration con = new Configuration().configure().addAnnotatedClass(term.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        deleteTerm(taid);
        session.save(t);
        tx.commit();
	}

}

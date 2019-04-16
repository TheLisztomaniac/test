package services;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jpa.*;

public class ServiceProgram {
	
	public List<program> getProgram()
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(program.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("select p from program p");
        List<program> result = (List<program>)q.getResultList();
        return result;
	}
	
	public program getProgramById(int p_id)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(program.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("select p from program p where p.p_id = "+p_id);
        program result = (program)q.uniqueResult();
        return result;
	}
	
	public void editProgram(program p , int p_id)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(program.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("update program set p_name=:p_name , p_code=:p_code , duration=:p_duration , duration_unit=:p_duration_unit,discription=:p_discription, coordinator_id=:p_coordinator_id where p_id="+p_id);
        q.setParameter("p_name",p.getP_name());
        q.setParameter("p_code",p.getP_code());
        q.setParameter("p_duration",p.getDuration());
        q.setParameter("p_duration_unit",p.getDuration_unit());
        q.setParameter("p_discription",p.getDiscription());
        q.setParameter("p_coordinator_id",p.getCoordinator_id());
        q.executeUpdate();
        tx.commit();
		return;
	}
	
	public void deleteProgram(program p)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(program.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.remove(p);
        tx.commit();
        return;
	}
	
	public void addProgram(program p)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(program.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(p);
        tx.commit();
        return;
	}
}

package services;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jpa.*;

public class ServiceCourses {
	
	public List<course> getCourses()
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(course.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Query q = session.createQuery("select c from course c");
        List<course> result = (List<course>)q.getResultList();
        return result;
	}
	
	public List<course_prerequisite> getCoursePreRequisiteListById(String c_code)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(course_prerequisite.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("select c from course_prerequisite c where c.cpid.c_code = '"+c_code+"'");
        List<course_prerequisite> result = (List<course_prerequisite>)q.getResultList();
        return result;
	}
	
	public void addCourse(course c)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(course.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(c);
        tx.commit();
        return;
	}
	
	public void addPreRequisiteCourse(String s , List<String> pre)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(course_prerequisite.class).addAnnotatedClass(course_prerequisite_id.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        for(String i:pre)
        {
        	course_prerequisite_id pr = new course_prerequisite_id(s,i);
        	course_prerequisite p = new course_prerequisite();
        	p.setCpid(pr);
        	session.save(p);
        }
        tx.commit();
        return;
	}
	
	public course getCourseById(String c_code)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(course.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("select c from course c where c.c_code = '"+c_code+"'");
        course result = (course)q.uniqueResult();
        return result;
	}
	
	public void editCourse(course c , String c_code)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(course.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("update course set course_name=:name , description=:description , c_level=:c_level,category=:category, descipline=:descipline,"
        		+ "accessment_type=:accessment_type,L=:L,T=:T,P=:P,C=:C,url=:url where c_code ='"+c_code+"'");
        q.setParameter("name", c.getCourse_name());
        q.setParameter("description", c.getDescription());
        q.setParameter("c_level", c.getC_level());
        q.setParameter("category", c.getCategory());
        q.setParameter("descipline", c.getDescipline());
        q.setParameter("accessment_type", c.getAccessment_type());
        q.setParameter("L", c.getL());
        q.setParameter("T", c.getT());
        q.setParameter("P", c.getP());
        q.setParameter("C", c.getC());
        q.setParameter("url",c.getUrl());
        q.executeUpdate();
        tx.commit();
		return;
	}
	
	public void editPreRequisiteCourse(String c_code,List<String> s)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(course_prerequisite.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        deletePreRequisiteCourse(getCoursePreRequisiteListById(c_code));
        addPreRequisiteCourse(c_code,s);
        tx.commit();
		return;
	}
	
	public void deleteCourse(course c)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(course.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.remove(c);
        tx.commit();
        return;
	}
	
	public void deletePreRequisiteCourse(List<course_prerequisite> cp)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(course_prerequisite.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        for(course_prerequisite i : cp)
        	session.remove(i);
        
        tx.commit();
        return;
	}
}

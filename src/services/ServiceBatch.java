package services;

import java.util.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jpa.*;

public class ServiceBatch {

	public List<batch> getBatch()
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(batch.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Query q = session.createQuery("select b from batch b");
        List<batch> result = (List<batch>)q.getResultList();
        return result;
	}
	
	public List<Integer> getBatchString()
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(batch.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Query q = session.createQuery("select distinct b.pbid.batch_name from batch b");
        List<Integer> result = (List<Integer>)q.getResultList();
        return result;
	}
	
	public void addBatch(batch b)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(batch.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(b);
        tx.commit();
	}
	public byte[] fileDownloadBatch(program_batch_id pbid)
	{
		HttpServletResponse response = ServletActionContext.getResponse();
		
		
		Configuration con = new Configuration().configure().addAnnotatedClass(batch.class);
		SessionFactory sf = con.buildSessionFactory();
        
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        response.setContentType("application/pdf");
        Query q=session.createQuery("select student_file from jpa.batch where p_id="+pbid.getP_id()+" and batch_name="+pbid.getBatch_name());
        //q.setParameter("student_id", student_id);
        
        byte [] data=(byte[])q.uniqueResult();
        
        response.setContentLength(data.length);
        
        //setFileName(this.getStudent_id() + "_synopsis");
        //setInputStream(new ByteArrayInputStream (data));
        tx.commit();
        return data;
	}
}

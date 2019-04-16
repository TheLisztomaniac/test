package services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.opensymphony.xwork2.ActionSupport;

import jpa.*;

public class ServiceSlot{
	
	public List<slot> getSlot()
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(slot.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Query q = session.createQuery("select s from slot s");
        List<slot> result = (List<slot>)q.getResultList();
        return result;
	}
	
	public List<Object []> getSlotQueryResult(String t_name,int a_year,int p_id,int s_no)
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(offered_slot.class).addAnnotatedClass(program.class).addAnnotatedClass(offer.class).addAnnotatedClass(course.class).addAnnotatedClass(slot.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Query q;
        
        if(p_id >0 && s_no > 0)
        {
        	q = session.createQuery("select os,o,p,s,c from offered_slot os , offer o,program p,slot s , course c where os.osid.pbid.p_id = "+p_id+" and os.osid.slot_no = "+s_no+" and"
        			+ " os.osid.offer_id = o.offer_id and o.c_code = c.c_code and o.t_name = '"+t_name+"' and o.a_year = "+a_year+" and s.slot_no ="+s_no+" and p.p_id ="+p_id);
        }
        else if(s_no > 0)
        {
        	q = session.createQuery("select os,o,p,s,c from offered_slot os , offer o,program p,slot s , course c where os.osid.pbid.p_id = p.p_id and os.osid.slot_no = "+s_no+" and"
        			+ " os.osid.offer_id = o.offer_id and o.c_code = c.c_code and o.t_name = '"+t_name+"' and o.a_year = "+a_year +" and s.slot_no = "+s_no);
        }
        else if(p_id > 0)
        {
        	q = session.createQuery("select os,o,p,s,c from offered_slot os , offer o,program p,slot s , course c where os.osid.pbid.p_id = "+p_id+" and os.osid.slot_no = s.slot_no and"
        			+ " os.osid.offer_id = o.offer_id and o.c_code = c.c_code and o.t_name = '"+t_name+"' and o.a_year = "+a_year+" and p.p_id ="+p_id);
        }
        else
        {
        	q = session.createQuery("select os,o,p,s,c from offered_slot os , offer o,program p,slot s , course c where os.osid.pbid.p_id = p.p_id and os.osid.slot_no = s.slot_no and"
        			+ " os.osid.offer_id = o.offer_id and o.c_code = c.c_code and o.t_name = '"+t_name+"' and o.a_year = "+a_year);
        }
        	
        List<Object []> result = (List<Object []>)q.getResultList();
        return result;
	}
}

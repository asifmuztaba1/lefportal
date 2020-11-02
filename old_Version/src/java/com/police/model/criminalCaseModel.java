
package com.police.model;

import com.police.entity.Criminal;
import com.police.entity.Criminalcase;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


public class criminalCaseModel {
    
    
    public void insert_criminalcase(Criminalcase c)     
    {
        Session session=HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.save(c);
            session.getTransaction().commit();
            session.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
            
    }
    
    public List<Criminalcase> searchbyId(String criminal_id)
    {
        List<Criminalcase> list=null;
        
        Session session=HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            String hql="from Criminalcase where criminalId=? " ;
            Query q=session.createQuery(hql);
            q.setString(0, criminal_id);
            session.getTransaction().commit();
            
            list= (List<Criminalcase>)q.list();
        }
        catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return list;
    }
    
    
    public List<String> getRunningCriminal(){
        List<String> running=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
       
        try{
            session.beginTransaction();
            String hql="select cc.criminalId from Criminalcase cc where cc.status='Running' ";
            Query q=session.createQuery(hql);
            session.getTransaction().commit();
            running=q.list();
            
        }catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return running;
    }
    
    public List<String> getCaseList(String criminalId)
    {
        List<String> caseList=null;
        
        Session session=HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            String hql="select cc.caseId from Criminalcase cc where cc.criminalId=? and cc.status=? ";
            Query q=session.createQuery(hql);
            q.setString(0, criminalId);
            q.setString(1, "Running");
            session.getTransaction().commit();
            caseList=q.list();
        }catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return caseList;
    }
}

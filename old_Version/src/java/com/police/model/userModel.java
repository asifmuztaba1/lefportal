package com.police.model;

import com.police.entity.Case;
import com.police.entity.Comments;
import com.police.entity.Criminal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class userModel {

    public List<Criminal> searchbyname(String name) {
        List<Criminal> list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            String hql = "from Criminal where name=?";
            Query q = session.createQuery(hql);
            q.setString(0, name);
            session.getTransaction().commit();

            list = (List<Criminal>) q.list();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return list;

    }

    public Criminal criminalDetails(String criminal_id) {
        Criminal criminal = new Criminal();

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            String hql = "from Criminal where id=?";
            Query q = session.createQuery(hql);
            q.setString(0, criminal_id);
            session.getTransaction().commit();

            criminal = (Criminal) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return criminal;
    }

    public List<Criminal> customSearch(String name, String district, String division) {
        List<Criminal> list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            String hql = "from Criminal where name=? and (district=? and division=?)";
            Query q = session.createQuery(hql);
            q.setString(0, name);
            q.setString(1, district);
            q.setString(2, division);
            session.getTransaction().commit();

            list = (List<Criminal>) q.list();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return list;
    }

    public Criminal getCriminal(String id, String district) {
        Criminal criminal = new Criminal();
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            String hql = "from Criminal where id=? and district=?";
            Query q = session.createQuery(hql);
            q.setString(0, id);
            q.setString(1, district);
            session.getTransaction().commit();
            criminal = (Criminal) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return criminal;
    }
    
    
    public void insert_comments(Comments comments)
    {
        Session session=HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.save(comments);
            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
    }
    
    public Case getCaseDetails(String caseId)
    {
        Case caseDetails=new Case();
        
        Session session=HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            String hql="from Case where id=?";
            Query q=session.createQuery(hql);
            q.setString(0, caseId);
            session.getTransaction().commit();
            caseDetails=(Case)q.uniqueResult();
        }catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return caseDetails;
    }
    
}

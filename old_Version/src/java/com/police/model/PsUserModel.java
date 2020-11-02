
package com.police.model;

import com.police.entity.Comments;
import com.police.entity.PsUser;
import com.police.entity.ahqSearch;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class PsUserModel {

    public boolean login(PsUser user) {
        boolean login = false;

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            String user_name = user.getUsername();
            String user_pass = user.getPassword();

            session.beginTransaction();

            String hql = "from PsUser where username=? and password=?";
            Query q = session.createQuery(hql);
            q.setString(0, user_name);
            q.setString(1, user_pass);
            session.getTransaction().commit();

            List<PsUser> list = q.list();

            if (list != null && list.size() == 1) {
                login = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return login;
    }

    
    public PsUser login_info(PsUser user) {
        PsUser u = new PsUser();
        Session session=HibernateUtil.getSessionFactory().openSession();
        try {
            String user_name=user.getUsername();
            String user_pass=user.getPassword();
            
            session.beginTransaction();
            String hql="from PsUser where username=? and password=?";
            Query q=session.createQuery(hql);
            q.setString(0,user_name );
            q.setString(1,user_pass );
            session.getTransaction().commit();
            
            u=(PsUser) q.uniqueResult();
            

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return u;
    }
    
    
    public List<PsUser> view(ahqSearch search)
    {
        List<PsUser> list=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        
        try{
            String district=search.getDistrict();
            String division=search.getDivision();
            
            String hql="from PsUser where division=? and district=?";
            session.beginTransaction();
            Query q=session.createQuery(hql);
            q.setString(0, division);
            q.setString(1, district);
            session.getTransaction().commit();
            list=q.list();
            session.close();
            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        
        return list;
    }
    
    
    public void insert(PsUser user)
    {
        Session session=HibernateUtil.getSessionFactory().openSession();
        
        try {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            session.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    
    
    
    public PsUser getUser(BigDecimal id)
    {
        PsUser user=new PsUser();
        Session session=HibernateUtil.getSessionFactory().openSession();
        
        try{
            session.beginTransaction();
            user=(PsUser) session.get(PsUser.class, id);
            session.getTransaction().commit();
            session.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return user;
    }
    
    
    public void update(PsUser user)
    {
        Session session=HibernateUtil.getSessionFactory().openSession();
        try
        {
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
            session.close();
            
        }
        catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    
    
    public void delete(PsUser user)
    {
        Session session=HibernateUtil.getSessionFactory().openSession();
        
        try{
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
            session.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        
    }
    
    public List<PsUser> getAll()
    {
        List<PsUser> list=null;
        
        Session session=HibernateUtil.getSessionFactory().openSession();
        
        try{
            session.beginTransaction();
            String hql="from PsUser";
            Query q=session.createQuery(hql);
            session.getTransaction().commit();
            list=q.list();
            
        }
        catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return list;
    }

}

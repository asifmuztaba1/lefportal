
package com.police.model;

import com.police.entity.PUser;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class PUserModel {
    
    public List<PUser> getAll()
    {
        List<PUser> user_list= new ArrayList<PUser>();
        Session session=HibernateUtil.getSessionFactory().openSession();
        
        try {
            session.beginTransaction();
            user_list=session.createCriteria(PUser.class).list();
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        
        return user_list;
    }
    
    public void insert(PUser user)
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
    
    public boolean login(PUser user)
    {
        Session session=HibernateUtil.getSessionFactory().openSession();
        
        boolean login=false;
        
        
        try{
            String user_email=user.getEmail();
            String user_pasw=user.getPassword();
            String hql="from PUser where email=? and password=?";
        
            session.beginTransaction();

            Query q=session.createQuery(hql);
            q.setString(0,user_email);
            q.setString(1,user_pasw);
            session.getTransaction().commit();


            List <PUser> list= (List <PUser>) q.list();
            System.out.println(list.size());
            if(list != null && (list.size() == 1))
                {
                    System.out.println("here...");
                    login=true; 
                }
                session.close();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        System.out.println(login);
        return login;
    }
    
    public PUser login_info(PUser user)
    {
         List <PUser> user_info = null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        PUser u=new PUser();
        try{
            String user_email=user.getEmail();
            String user_pasw=user.getPassword();
            
            String hql="from PUser where email=? and password=?";
            
            session.beginTransaction();
            
            Query q=session.createQuery(hql);
            q.setString(0, user_email);
            q.setString(1, user_pasw);
            session.getTransaction().commit();

            u=(PUser) q.uniqueResult();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return u;
    }
    
}

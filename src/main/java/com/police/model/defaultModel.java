
package com.police.model;

import com.police.entity.PoliceStationUser;
import com.police.entity.PublicUser;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author asifmuztaba
 */
public class defaultModel {
    SessionFactory sf=HibernateUtil.getSessionFactory();
    
    public boolean checkEmail(String email)
    {
        boolean matcheFound=true;
        Session session=sf.openSession();
        try{
            session.beginTransaction();
            Criteria crit=session.createCriteria(PublicUser.class);
            crit.add(Restrictions.eq("email", email));
            List<PublicUser> uList=crit.list();
            
            if(uList.size()<1)
            {
                matcheFound=false;
                System.out.println("List size..."+uList.size());
            }
            System.out.println("List size..."+uList.size());
            
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return matcheFound;
    }
    
    public boolean insertUser(PublicUser user)
    {
        boolean done=false;
        
        Session session=sf.openSession();
        try{
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            
            done=true;
            
        }catch(Exception e)
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return done;
    }
    
    public boolean checkPubllicUser(String email,String Password)
    {
        boolean match=false;
        Session session=sf.openSession();
        
        try{
            session.beginTransaction();
            Criteria crt=session.createCriteria(PublicUser.class);
            crt.add(Restrictions.eq("email", email));
            crt.add(Restrictions.eq("password", Password));
            
            List<PublicUser> uList=crt.list();
            
            if(uList.size()==1)
            {
                match=true;
            }
            
        }catch(Exception e)
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return match;
    }
    
    public boolean checkPoliceStationUser(String userName,String encryptedPassword)
    {
        boolean login=false;
        
        Session session=sf.openSession();
        try{
            session.beginTransaction();
            Criteria crt=session.createCriteria(PoliceStationUser.class);
            
            crt.add(Restrictions.eq("username", userName));
            crt.add(Restrictions.eq("password", encryptedPassword));
            
            List<PoliceStationUser> uList=crt.list();
            
            if(uList.size() == 1)
            {
                login=true;
            }
            
            
        }catch(Exception e)
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return login;
    }
    
    public PoliceStationUser getPoliceStationUserCredential(String userName,String encryptedPassword)
    {
        PoliceStationUser user=new PoliceStationUser();
        
        Session session=sf.openSession();
        try{
            session.beginTransaction();
            
            Criteria crt=session.createCriteria(PoliceStationUser.class);
            crt.add(Restrictions.eq("username", userName));
            crt.add(Restrictions.eq("password", encryptedPassword));
            
            user=(PoliceStationUser)crt.uniqueResult();
            
        }catch(Exception e)
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        
        return user;
    }
}

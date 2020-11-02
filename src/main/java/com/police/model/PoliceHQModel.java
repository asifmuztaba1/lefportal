
package com.police.model;

import com.police.entity.PoliceStationUser;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author asifmuztaba
 */
public class PoliceHQModel {

    SessionFactory sf = HibernateUtil.getSessionFactory();

    public boolean addPS(PoliceStationUser psUser) {
        boolean done = false;
        Session session = sf.openSession();

        try {
            session.beginTransaction();
            session.save(psUser);
            session.getTransaction().commit();

            done = true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return done;
    }

    public List<PoliceStationUser> getAllPS() {
        List<PoliceStationUser> uList = new ArrayList();

        Session session = sf.openSession();
        try {
            session.beginTransaction();
            Criteria crt = session.createCriteria(PoliceStationUser.class);
            crt.addOrder(Order.asc("psName"));
            uList = crt.list();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return uList;
    }

    public PoliceStationUser getUserById(Long ID) {
        PoliceStationUser user = new PoliceStationUser();
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            user = (PoliceStationUser) session.get(PoliceStationUser.class, ID);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return user;
    }

    public boolean updatePS(PoliceStationUser psUser) {
        boolean done = false;

        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.update(psUser);
            session.getTransaction().commit();
            done = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return done;
    }

    public List<PoliceStationUser> getAjaxSearchPSData(String PSName) {
        String ajaxData = "null";
        Session session = sf.openSession();
        List<PoliceStationUser> psList = new ArrayList();
        try {
            session.beginTransaction();
            Criteria crt = session.createCriteria(PoliceStationUser.class);
            crt.add(Restrictions.ilike("psName", PSName + "%"));
            psList = crt.list();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return psList;
    }

    public boolean checkUserName(String username) {
        boolean matcheFound = true;
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            Criteria crit = session.createCriteria(PoliceStationUser.class);
            crit.add(Restrictions.eq("username", username));
            List<PoliceStationUser> uList = crit.list();

            if (uList.size() < 1) {
                matcheFound = false;
                System.out.println("List size..." + uList.size());
            }
            System.out.println("List size..." + uList.size());
            
        } catch (Exception e) {
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
}

package com.police.model;

import com.police.entity.Case;
import com.police.entity.Comments;
import com.police.entity.Criminal;
import com.police.entity.CriminalDocument;
import com.police.entity.Criminalcase;
import com.police.entity.Document;
import com.police.entity.Notification;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class policeStationModel {

    public void insert_case(Case new_case) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.save(new_case);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }

    public BigDecimal get_caseID(Case new_case) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Case temp_case = new Case();
        BigDecimal case_id = null;
        try {
            String hql = "from Case where caseName=? and crimeDate=?";
            String caseName = new_case.getCaseName();
            String crimeDate = new_case.getCrimeDate();
            System.out.println(caseName);
            System.out.println(caseName);
            session.beginTransaction();
            Query q = session.createQuery(hql);
            q.setString(0, caseName);
            q.setString(1, crimeDate);
            session.getTransaction().commit();

            temp_case = (Case) q.uniqueResult();
            case_id = temp_case.getId();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        session.close();

        return case_id;

    }

    public void insert_criminal(Criminal c) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(c);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }

    public BigDecimal get_criminalID(Criminal c) {
        BigDecimal criminal_id = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criminal temp_criminal = new Criminal();

        try {
            session.beginTransaction();
            String hql = "from Criminal where name=? and father=?";

            String name = c.getName();
            String father = c.getFather();

            Query q = session.createQuery(hql);
            q.setString(0, name);
            q.setString(1, father);
            session.getTransaction().commit();

            temp_criminal = (Criminal) q.uniqueResult();
            criminal_id = temp_criminal.getId();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return criminal_id;
    }

    public List<Case> searchbyDate(String date, String district) {
        List<Case> list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            String hql = "from Case where district=? and caseDate=?";
            Query q = session.createQuery(hql);
            q.setString(0, district);
            q.setString(1, date);
            session.getTransaction().commit();

            list = (List<Case>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return list;
    }

    public List<Case> searchbyID(String id, String district) {
        List<Case> list = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            String hql = "from Case where id=? and district=?";
            Query q = session.createQuery(hql);
            q.setString(0, id);
            q.setString(1, district);
            session.getTransaction().commit();
            list = (List<Case>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return list;
    }

    public void insert_documents(Document d) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(d);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public void insert_notification(Notification n) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(n);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }

    public List<Notification> view_notification(String district, String division) {
        List<Notification> list = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            String hql = "from Notification where (district=? or district=?) and (division=? or division=?) order by id DESC";
            Query q = session.createQuery(hql);

            q.setString(0, district);
            q.setString(1, "All");
            q.setString(2, division);
            q.setString(3, "All");

            session.getTransaction().commit();
            list = (List<Notification>) q.list();

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        return list;
    }

    public long ps_viewedNotf(String ps) {
        long count = 0;

        return count;

    }

    public List<Criminalcase> get_crimanalCaseinfo(BigDecimal case_id) {
        List<Criminalcase> list = null;

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            String hql = "from Criminalcase where caseId=?";
            Query q = session.createQuery(hql);
            q.setBigDecimal(0, case_id);
            session.getTransaction().commit();
            list = (List<Criminalcase>) q.list();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return list;
    }

    public Case get_caseinfo(String case_id) {
        Case case_info = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            String hql = "from Case where id=?";
            Query q = session.createQuery(hql);
            q.setString(0, case_id);
            session.getTransaction().commit();
            case_info = (Case) q.uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return case_info;

    }

    public Criminal get_criminalinfo(String criminal_id) {
        Criminal info = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            String hql = "from Criminal where id=?";
            Query q = session.createQuery(hql);
            q.setString(0, criminal_id);
            session.getTransaction().commit();
            info = (Criminal) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        session.close();
        return info;
    }

    public List<Case> searchMissing(String ageStart, String ageEnd) {
        List<Case> list = null;

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {

            session.beginTransaction();
            String hql = "from Case where (victimAge>=? and victimAge<=?) and type='Missing'";
            Query q = session.createQuery(hql);
            q.setString(0, ageStart);
            q.setString(1, ageEnd);

            session.getTransaction().commit();
            list = (List<Case>) q.list();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        session.close();
        return list;
    }

    public List<Case> searchAccident(String ageStart, String ageEnd) {
        List<Case> list = null;

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            String hql = "from Case where (victimAge>=? and victimAge<=?) and type='Accident'";
            Query q = session.createQuery(hql);
            q.setString(0, ageStart);
            q.setString(1, ageEnd);
            session.getTransaction().commit();
            list = (List<Case>) q.list();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return list;
    }

    public List<Criminal> customSearchCriminal(String name, String district, String division) {
        List<Criminal> criminal = null;

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            String hql = "from Criminal where name=? and (district=? and division=?)";
            Query q = session.createQuery(hql);
            q.setString(0, name);
            q.setString(1, district);
            q.setString(2, division);
            session.getTransaction().commit();
            criminal = (List<Criminal>) q.list();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return criminal;
    }

    public List<Criminal> searchCriminal(String name) {
        List<Criminal> criminal = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            String hql = "from Criminal where name=?";
            Query q = session.createQuery(hql);
            q.setString(0, name);
            session.getTransaction().commit();

            criminal = (List<Criminal>) q.list();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return criminal;
    }

    public List<Document> searchDocument(String case_id) {
        List<Document> list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            String hql = "from Document where caseId=?";
            Query q = session.createQuery(hql);
            q.setString(0, case_id);

            list = (List<Document>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return list;
    }

    public void insert_criminalDoc(CriminalDocument doc) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(doc);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public List<CriminalDocument> get_criminalDoc(String criminal_id) {
        List<CriminalDocument> docs = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            String hql = "from CriminalDocument where criminalId=?";
            Query q = session.createQuery(hql);
            q.setString(0, criminal_id);
            session.getTransaction().commit();
            docs = (List<CriminalDocument>) q.list();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return docs;
    }

    public List<Comments> getComments(String policeStation) {
        List<Comments> comments = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            String hql = "from Comments where policeStation=?";
            Query q = session.createQuery(hql);
            q.setString(0, policeStation);
            session.getTransaction().commit();
            comments = (List<Comments>) q.list();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return comments;
    }

}

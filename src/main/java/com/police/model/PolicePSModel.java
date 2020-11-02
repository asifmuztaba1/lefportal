
package com.police.model;

import com.police.entity.CaseDocuments;
import com.police.entity.CaseRecord;
import com.police.entity.CriminalCaseRecord;
import com.police.entity.CriminalDocument;
import com.police.entity.CriminalRecord;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author asifmuztaba
 */
public class PolicePSModel {

    SessionFactory sf = HibernateUtil.getSessionFactory();

    public BigDecimal getCaseRecordMaxId() {
        BigDecimal maxxId = new BigDecimal(0);
        Session session = sf.openSession();

        try {
            session.beginTransaction();
            Criteria crt = session.createCriteria(CaseRecord.class);
            crt.setProjection(Projections.max("id"));
            maxxId = (BigDecimal) crt.uniqueResult();

            if (maxxId.equals(null)) {
                maxxId = BigDecimal.ZERO;
            }

        } catch (Exception e) {
            e.printStackTrace();
            maxxId = BigDecimal.ZERO;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        System.out.println("Max ID : " + maxxId);
        return maxxId;
    }

    public boolean insertNewCase(CaseRecord newCase) {
        boolean done = false;
        Session session = sf.openSession();

        try {
            session.beginTransaction();
            session.save(newCase);
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

    public List<CaseRecord> getPSCaseList(String PSname, Date date) {
        List<CaseRecord> caseList = new ArrayList();
        Session session = sf.openSession();

        try {
            session.beginTransaction();
            Criteria crt = session.createCriteria(CaseRecord.class);
            crt.add(Restrictions.eq("policeStation", PSname));
            crt.add(Restrictions.eq("caseFileDate", date));
            caseList = crt.list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return caseList;
    }

    public CaseRecord getCaseRecordByCaseId(String CaseID) {
        CaseRecord caseObj = new CaseRecord();
        Session session = sf.openSession();
        try {
            Criteria crt = session.createCriteria(CaseRecord.class);
            crt.add(Restrictions.eq("caseId", CaseID));
            caseObj = (CaseRecord) crt.uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return caseObj;
    }

    public List<CaseDocuments> getCaseDocByCaseId(String caseId) {
        List<CaseDocuments> caseDocList = new ArrayList();
        Session session = sf.openSession();
        try {
            Criteria crt = session.createCriteria(CaseDocuments.class);
            crt.add(Restrictions.eq("caseId", caseId));
            caseDocList = crt.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return caseDocList;
    }

    public boolean insertCaseDoc(CaseDocuments newDoc) {
        boolean done = false;

        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.save(newDoc);
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

    public BigDecimal getCriminalMaxId() {
        BigDecimal maxxId = new BigDecimal(0);
        Session session = sf.openSession();

        try {
            session.beginTransaction();
            Criteria crt = session.createCriteria(CriminalRecord.class);
            crt.setProjection(Projections.max("id"));
            maxxId = (BigDecimal) crt.uniqueResult();
            
            if (maxxId.equals(null)) {
                maxxId = BigDecimal.ZERO;
            }
        } catch (Exception e) {
            e.printStackTrace();
            maxxId = BigDecimal.ZERO;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        System.out.println("Max id : "+maxxId);
        return maxxId;
    }
    
    public boolean insertCriminalRec(CriminalRecord criminal)
    {
        boolean insert=false;
        Session session=sf.openSession();
        
        try{
            session.beginTransaction();
            session.save(criminal);
            session.getTransaction().commit();
            insert=true;
        }catch(Exception e)
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return insert;
    }
    
    
    public boolean insertCriminalCaseRec(CriminalCaseRecord criminalCase)
    {
        boolean insert=false;
        Session session=sf.openSession();
        
        try{
            session.beginTransaction();
            session.save(criminalCase);
            session.getTransaction().commit();
            insert=true;
        }catch(Exception e)
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        
        return insert;
    }
    
    
    public List<CriminalCaseRecord> getCriminalByCase(String caseId)
    {
        List<CriminalCaseRecord> ccList=new ArrayList();
        Session session=sf.openSession();
        
        try{
            Criteria crt=session.createCriteria(CriminalCaseRecord.class);
            crt.add(Restrictions.eq("caseId", caseId));
            ccList=crt.list();
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        
        return ccList;
    }
    
    
    public String getCriminalNameById(String criminalId)
    {
        String criminalName=null;
        Session session=sf.openSession();
        try{
            Criteria crt=session.createCriteria(CriminalRecord.class);
            crt.add(Restrictions.eq("criminalId", criminalId));
            crt.setProjection(Projections.property("criminalName"));
            criminalName=(String)crt.uniqueResult();
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return criminalName;
    }
    
    
    public CriminalRecord getCriminalById(String criminalId)
    {
        CriminalRecord criminal=new CriminalRecord();
        Session session=sf.openSession();
        
        try{
            
            Criteria crt=session.createCriteria(CriminalRecord.class);
            crt.add(Restrictions.eq("criminalId", criminalId));
            criminal=(CriminalRecord)crt.uniqueResult();
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return criminal;
    }
    
    
    public List<CriminalCaseRecord> getCaseByCriminalId(String criminalId)
    {
        List<CriminalCaseRecord> crimCase=new ArrayList();
        Session session=sf.openSession();
        
        try{
            Criteria crt=session.createCriteria(CriminalCaseRecord.class);
            crt.add(Restrictions.eq("criminalId", criminalId));
            crimCase=crt.list();
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return crimCase;
    }
    
    
    public List<CriminalDocument> getCriminalDocByCriminalId(String criminalId)
    {
        List<CriminalDocument> crimDocList=new ArrayList();
        Session session=sf.openSession();
        
        try{
            Criteria crt=session.createCriteria(CriminalDocument.class);
            crt.add(Restrictions.eq("criminalId", criminalId));
            crimDocList=crt.list();
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return crimDocList;
    }
    
    
    public boolean insertCriminalDoc(CriminalDocument doc)
    {
        boolean insert=false;
        Session session=sf.openSession();
        
        try{
            session.beginTransaction();
            session.save(doc);
            session.getTransaction().commit();
            insert=true;
        }catch(Exception e)
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return insert;
    }
            
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.DataTreatment;
import pojo.KliinikKecantikanUtil;

/**
 *
 * @author Acer
 */
public class DAOTreatment {
     public List<DataTreatment> retrieveDataTreatment(){
        List treat = new ArrayList();
        DataTreatment treat1 = new DataTreatment();
        Transaction trans = null;
        Session session = KliinikKecantikanUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from DataTreatment");
            treat = query.list();
            treat.add(treat1.getIdTreatment());
            treat.add(treat1.getJenisTreatment());
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return treat;
    }
    
   public List<DataTreatment> getbyID(String idU){
       DataTreatment usr = new DataTreatment();
       List<DataTreatment> iUsr = new ArrayList();
       Transaction trans = null;
       Session session = KliinikKecantikanUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from DataTreatment where ID_Treatment = :id");
            query.setString("id", idU);
            usr = (DataTreatment) query.uniqueResult();
            iUsr = query.list();
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return iUsr;
    }
    public void add_treatment(DataTreatment treatmnt){
        Transaction trans = null;
        Session session = KliinikKecantikanUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(treatmnt);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
}
    public void deleteTreatment(int idT){
        Session session = KliinikKecantikanUtil.getSessionFactory().openSession();
         try {
             System.out.println("id" + idT);
            session.beginTransaction(); 
            Query pass = session.createQuery("delete DataTreatment where ID_Treatment= :id");
            pass.setParameter("id", idT);
            pass.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
                    System.out.println(e);
        }
    }
    public void editTreatment(DataTreatment treat){
        Transaction trans = null;
        Session session = KliinikKecantikanUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.update(treat);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}

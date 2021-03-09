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
import pojo.DataDokter;
import pojo.KliinikKecantikanUtil;

/**
 *
 * @author Acer
 */
public class DAODokter {
     public void addDokter(DataDokter dtr){
        Transaction trans = null;
        Session session = KliinikKecantikanUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            session.save(dtr);
            trans.commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void deleteDokter(int idD){
        Session session = KliinikKecantikanUtil.getSessionFactory().openSession();
        try{
            System.out.println("id" + idD);
            session.beginTransaction();
            Query prd = session.createQuery("delete DataDokter where ID_Dokter= :id");
            prd.setParameter("id", idD);
            prd.executeUpdate();
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    
    public List<DataDokter> getbyID(String idD){
       DataDokter usr = new DataDokter();
       List<DataDokter> iUsr = new ArrayList();
       Transaction trans = null;
       Session session = KliinikKecantikanUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from DataDokter where ID_Dokter = :id");
            query.setString("id", idD);
            usr = (DataDokter) query.uniqueResult();
            iUsr = query.list();
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return iUsr;
    }
    
    public List<DataDokter> retrieveDokter(){
        
        List stud = new ArrayList();
        DataDokter stud1 = new DataDokter();
        Transaction trans = null;
        Session session = KliinikKecantikanUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            Query query = session.createQuery("from DataDokter");
            stud = query.list();
            trans.commit();
        } catch (Exception e){
            
        }
        return stud;
    }
    
    public void updateDokter(DataDokter dtr){
        Transaction trans = null;
        Session session = KliinikKecantikanUtil.getSessionFactory().openSession();
        try{
            System.out.println("dtr" + dtr.getIdDokter());
            trans = session.beginTransaction();
            session.update(dtr);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}

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
import pojo.DataKonsul;
import pojo.KliinikKecantikanUtil;

/**
 *
 * @author Acer
 */
public class DAOKonsul {
     public List<DataKonsul> retrieveDataKonsul(){
        List konss = new ArrayList();
        DataKonsul kons1 = new DataKonsul();
        Transaction trans = null;
        Session session = KliinikKecantikanUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            Query query = session.createQuery("from DataKonsul");
            konss= query.list();
            trans.commit();
        } catch (Exception e){
            
        }
        return konss;
    }
     public void add_konsul(DataKonsul konsul){
        Transaction trans = null;
        Session session = KliinikKecantikanUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(konsul);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
}
    
   public List<DataKonsul> getbyID(String idK){
        DataKonsul konss = new DataKonsul();
        List<DataKonsul> iKonss = new ArrayList();
        Transaction trans = null;
        Session session = KliinikKecantikanUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from DataKonsul where ID_Konsul =:id");
            query.setString("id", idK);
            konss = (DataKonsul)query.uniqueResult();
            iKonss = query.list();
            trans.commit();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return iKonss;
    }
    public void deleteKonsul(int idK){
        Session session = KliinikKecantikanUtil.getSessionFactory().openSession();
         try {
             System.out.println("id" + idK);
            session.beginTransaction(); 
            Query pass = session.createQuery("delete DataKonsul where ID_Konsul= :id");
            pass.setParameter("id", idK);
            pass.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
                    System.out.println(e);
        }
    }
    public void editKonsul(DataKonsul konsul){
        Transaction trans = null;
        Session session = KliinikKecantikanUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.update(konsul);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
}

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
import pojo.DataPasien;
import pojo.KliinikKecantikanUtil;

/**
 *
 * @author Acer
 */
public class DAOPasien {
    public List<DataPasien> retrieveDataPasien(){
        List pass = new ArrayList();
        DataPasien pass1 = new DataPasien();
        Transaction trans = null;
        Session session = KliinikKecantikanUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from DataPasien");
            pass = query.list();
            pass.add(pass1.getIdPasien());
            pass.add(pass1.getNoIdentitas());
            pass.add(pass1.getNamaPasien());
            pass.add(pass1.getEmail());
            pass.add(pass1.getNoHp());
            pass.add(pass1.getAlamat());
            pass.add(pass1.getTglLahir());
            pass.add(pass1.getJenisKelamin());
            pass.add(pass1.getJenisKulit());
            pass.add(pass1.getPekerjaan());
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return pass;
    }
     public void add_pasien(DataPasien pasien){
        Transaction trans = null;
        Session session = KliinikKecantikanUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(pasien);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
}
    
   public List<DataPasien> getbyID(String idP){
       DataPasien usr = new DataPasien();
       List<DataPasien> iUsr = new ArrayList();
       Transaction trans = null;
       Session session = KliinikKecantikanUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from DataPasien where ID_Pasien = :id");
            query.setString("id", idP);
            usr = (DataPasien) query.uniqueResult();
            iUsr = query.list();
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return iUsr;
    }
    public void deletePasien(int idP){
        Session session = KliinikKecantikanUtil.getSessionFactory().openSession();
         try {
             System.out.println("id" + idP);
            session.beginTransaction(); 
            Query pass = session.createQuery("delete DataPasien where ID_Pasien= :id");
            pass.setParameter("id", idP);
            pass.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
                    System.out.println(e);
        }
    }
    public void editPasien(DataPasien pass){
        Transaction trans = null;
        Session session = KliinikKecantikanUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.update(pass);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}

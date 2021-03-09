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

import pojo.KliinikKecantikanUtil;
import pojo.Reservation;

/**
 *
 * @author Acer
 */
public class DAOReservasi {
     public List<Reservation> retrieveDataReservasi(){
        List rsrv = new ArrayList();
        Reservation rsrv1 = new Reservation();
        Transaction trans = null;
        Session session = KliinikKecantikanUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Reservation");
            rsrv = query.list();
            rsrv.add(rsrv1.getNoReservation());
            rsrv.add(rsrv1.getIdPasien());
            rsrv.add(rsrv1.getJenisTreatment());
            rsrv.add(rsrv1.getJumlah());
            rsrv.add(rsrv1.getTanggal());
            rsrv.add(rsrv1.getJam());
            rsrv.add(rsrv1.getKonsul());
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return rsrv;
    }
   public void add_reservasii(Reservation reservasi){
        Transaction trans = null;
        Session session = KliinikKecantikanUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(reservasi);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
}
    
    public List<Reservation> getbyID(String idR){
        Reservation rsrv = new Reservation();
        List<Reservation> iRsrv = new ArrayList();
        Transaction trans = null;
        Session session = KliinikKecantikanUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Reservation where No_Reservation =:id");
            query.setString("id", idR);
            rsrv = (Reservation)query.uniqueResult();
            iRsrv = query.list();
            trans.commit();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return iRsrv;
    }
    public void deleteReservasi(int idR){
        Session session = KliinikKecantikanUtil.getSessionFactory().openSession();
         try {
             System.out.println("id" + idR);
            session.beginTransaction(); 
            Query pass = session.createQuery("delete Reservation where No_Reservation= :id");
            pass.setParameter("id", idR);
            pass.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
                    System.out.println(e);
        }
    }
    public void editReservasi(Reservation rsrv){
        Transaction trans = null;
        Session session = KliinikKecantikanUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.update(rsrv);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}

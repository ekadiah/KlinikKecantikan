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
import pojo.TblAdmin;

/**
 *
 * @author Acer
 */
public class DAOLoginAdmin {
    public List<TblAdmin> getBy(String aName, String aPass){
        Transaction trans = null;
         TblAdmin adm = new TblAdmin();
        List<TblAdmin> admin = new ArrayList();
        Session session = KliinikKecantikanUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblAdmin where usernameAdmin=:aName and passwordAdmin=:aPass");
            query.setString("aName", aName);
            query.setString("aPass", aPass);
            adm =(TblAdmin) query.uniqueResult();
            trans.commit();
            admin = query.list();
        } catch (Exception e) {
            System.out.println(e);
        }
        return admin;
    }
    public void add_admin(TblAdmin admin){
        Transaction trans = null;
        Session session = KliinikKecantikanUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(admin);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}

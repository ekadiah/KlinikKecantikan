package pojo;
// Generated Oct 22, 2020 6:44:34 PM by Hibernate Tools 4.3.1

import DAO.DAOKonsul;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;




/**
 * DataKonsul generated by hbm2java
 */
@ManagedBean
@RequestScoped
public class DataKonsul  implements java.io.Serializable {


     private Integer idKonsul;
     private String idPasien;
     private String idDokter;
     private String tanggal;
     private String jam;
     private String pernahKonsul;

     public String save_konsul(){
         DAOKonsul konss = new DAOKonsul();
         konss.add_konsul(this);
         
         return "DataKonsul";
     }
     public List<DataKonsul> getAllRecords(){
         DAOKonsul konss = new DAOKonsul();
         List<DataKonsul> lKons = konss.retrieveDataKonsul();
         return lKons;
     }
      public String getById(){
         String ID_Konsul = idKonsul.toString();
         DAOKonsul konss = new DAOKonsul();
        List<DataKonsul> lKonss = konss.getbyID(ID_Konsul);
            idDokter = lKonss.get(0).idDokter;
            idPasien = lKonss.get(0).idPasien;
            tanggal = lKonss.get(0).tanggal;
            jam = lKonss.get(0).jam;
            pernahKonsul = lKonss.get(0).pernahKonsul;
            return "EditDataKonsul";
     }
     public String edit(){
         DAOKonsul konss = new DAOKonsul();
         konss.editKonsul(this);
         idDokter="";
         idPasien="";
         tanggal="";
         jam="";
         pernahKonsul="";
         return "DataKonsulAdmin";
     }
     public void delete(int id){
          DAOKonsul konss = new DAOKonsul();
         konss.deleteKonsul(id);
     }
   

    public DataKonsul() {
    }

    public DataKonsul(String idPasien, String idDokter, String tanggal, String jam, String pernahKonsul) {
       this.idPasien = idPasien;
       this.idDokter = idDokter;
       this.tanggal = tanggal;
       this.jam = jam;
       this.pernahKonsul = pernahKonsul;
    }
   
    public Integer getIdKonsul() {
        return this.idKonsul;
    }
    
    public void setIdKonsul(Integer idKonsul) {
        this.idKonsul = idKonsul;
    }
    public String getIdPasien() {
        return this.idPasien;
    }
    
    public void setIdPasien(String idPasien) {
        this.idPasien = idPasien;
    }
    public String getIdDokter() {
        return this.idDokter;
    }
    
    public void setIdDokter(String idDokter) {
        this.idDokter = idDokter;
    }
    public String getTanggal() {
        return this.tanggal;
    }
    
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    public String getJam() {
        return this.jam;
    }
    
    public void setJam(String jam) {
        this.jam = jam;
    }
    public String getPernahKonsul() {
        return this.pernahKonsul;
    }
    
    public void setPernahKonsul(String pernahKonsul) {
        this.pernahKonsul = pernahKonsul;
    }




}



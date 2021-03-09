package pojo;
// Generated Oct 22, 2020 6:44:34 PM by Hibernate Tools 4.3.1

import DAO.DAOTreatment;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;




/**
 * DataTreatment generated by hbm2java
 */
@ManagedBean
public class DataTreatment  implements java.io.Serializable {


     private Integer idTreatment;
     private String jenisTreatment;
     private String harga;

      public String save_treatment(){
        DAOTreatment treat = new DAOTreatment();
        treat.add_treatment(this);
        return "DataTreatmentAdmin";
    }
    
    public void delete(int id){
          DAOTreatment treat = new DAOTreatment();
         treat.deleteTreatment(id);
     }
    
    public String getById(){
         String id_treatment = idTreatment.toString();
         DAOTreatment usr = new DAOTreatment();
         List<DataTreatment> lUsr = usr.getbyID(id_treatment);
         jenisTreatment= lUsr.get(0).jenisTreatment;
         harga = lUsr.get(0).harga;
         
         return "EditDataTreatment";
         
     }
    
    public List<DataTreatment> getAllRecords(){
        DAOTreatment treat = new DAOTreatment();
        List<DataTreatment> lTreat = treat.retrieveDataTreatment();
        return lTreat;
    }
    
    public String update(){
        DAOTreatment usr = new DAOTreatment();
         usr.editTreatment(this);
         jenisTreatment="";
         harga = "";
         FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Berhasil Update Data", null);
         
         return "DataTreatmentAdmin";
    }
    public DataTreatment() {
    }

    public DataTreatment(String jenisTreatment, String harga) {
       this.jenisTreatment = jenisTreatment;
       this.harga = harga;
    }
   
    public Integer getIdTreatment() {
        return this.idTreatment;
    }
    
    public void setIdTreatment(Integer idTreatment) {
        this.idTreatment = idTreatment;
    }
    public String getJenisTreatment() {
        return this.jenisTreatment;
    }
    
    public void setJenisTreatment(String jenisTreatment) {
        this.jenisTreatment = jenisTreatment;
    }
    public String getHarga() {
        return this.harga;
    }
    
    public void setHarga(String harga) {
        this.harga = harga;
    }




}


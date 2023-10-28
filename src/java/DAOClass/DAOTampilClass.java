/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOClass;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Classes;
import util.NewHibernateUtil;

/**
 *
 * @author Nishrina
 */
@ManagedBean
@SessionScoped
public class DAOTampilClass {
    public List<Classes> ambilclass() {

        List<Classes> kar = new ArrayList<>();
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Classes"); // Sesuaikan dengan nama entitas Anda
            kar = query.list();
            trans.commit();
        } catch (Exception e) {
            if (trans != null) {
                trans.rollback(); // Rollback transaksi jika terjadi kesalahan
            }
            e.printStackTrace(); // Cetak kesalahan untuk pemecahan masalah
        } finally {
            session.close(); // Selalu pastikan untuk menutup sesi Hibernate
        }
        return kar;
    }
    public List<Classes> getbyId(int id) {
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        List<Classes> class1 = new ArrayList<>();
        try {
            Classes member = new Classes();
            trans = session.beginTransaction();
            Query query = session.createQuery("Select * from Classes where IdClasses= :id"); // Sesuaikan dengan nama kolom ID yang benar
            query.setInteger("id",member.getIdClasses());
            class1 = query.list();
            trans.commit();
        } catch (Exception e) {
            if (trans != null) {
//                console.log(e);
                trans.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return class1;
    }
    
    
  public void updateClasses(Classes classes)
    {

         Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.update(classes);
            trans.commit();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
  
  public void hapusClasses(int idClasses)
    {
        Transaction trans=null;
        Session session= NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            Classes kar=(Classes)session.load(Classes.class, new Integer(idClasses));
            session.delete(kar);
            trans.commit();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
  

    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
        public void tambah(Classes kel){
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            session.save(kel);
            trans.commit();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
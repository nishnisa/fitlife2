/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOTrainer;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Trainer;
import util.NewHibernateUtil;

/**
 *
 * @author Rima
 */
@ManagedBean
public class DAOTampilTrainer {
        public List<Trainer> ambiltrainer() {

        List<Trainer> kar = new ArrayList<>();
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Trainer"); // Sesuaikan dengan nama entitas Anda
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
        
public void updatetrainer(Trainer trainer)
    {

         Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.update(trainer);
            trans.commit();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }

    public List<Trainer> getbyId(int id) {
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        List<Trainer> trainer1 = new ArrayList<>();
        try {
            Trainer trainer= new Trainer();
            trans = session.beginTransaction();
            Query query = session.createQuery("Select * from Trainer where idTrainer= :id"); // Sesuaikan dengan nama kolom ID yang benar
            query.setInteger("id",trainer.getIdTrainer());
            trainer1 = query.list();
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
        return trainer1;
    }
 public void hapustrainer(int idTrainer)
    {
        Transaction trans=null;
        Session session= NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            Trainer kar=(Trainer)session.load(Trainer.class, new Integer(idTrainer));
            session.delete(kar);
            trans.commit();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

}
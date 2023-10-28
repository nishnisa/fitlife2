/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOTrainer;

import javax.faces.bean.ManagedBean;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Trainer;
import util.NewHibernateUtil;

/**
 *
 * @author Rima
 */
@ManagedBean
public class DAOAddTrainer {
    public void updattrainer(Trainer trainer)
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
 
        public void tambah(Trainer trainer){
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            session.save(trainer);
            trans.commit();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
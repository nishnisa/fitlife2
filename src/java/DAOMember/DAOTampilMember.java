package DAOMember;


import static java.lang.System.console;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import pojo.Member;
import util.NewHibernateUtil;

@ManagedBean
public class DAOTampilMember {
    public List<Member> ambilmember() {

        List<Member> kar = new ArrayList<>();
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Member"); // Sesuaikan dengan nama entitas Anda
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

    
    public List<Member> getbyId(int id) {
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        List<Member> member2 = new ArrayList<>();
        try {
            Member member = new Member();
            trans = session.beginTransaction();
            Query query = session.createQuery("Select * from Member where idMember= :id"); // Sesuaikan dengan nama kolom ID yang benar
            query.setInteger("id",member.getIdMember());
            member2 = query.list();
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
        return member2;
    }
    
    
  public void updatemember(Member member)
    {

         Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.update(member);
            trans.commit();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
  
  public void hapusmember(int idMember)
    {
        Transaction trans=null;
        Session session= NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            Member kar=(Member)session.load(Member.class, new Integer(idMember));
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
  
 
}
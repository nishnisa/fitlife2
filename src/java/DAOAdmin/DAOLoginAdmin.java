/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOAdmin;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Admin;
import util.NewHibernateUtil;
/**
 *
 * @author nishrina
 */
@ManagedBean
public class DAOLoginAdmin {
   
  
        public List<Admin> getBy(String username, String password) {
        Admin u = new Admin();
        List<Admin> user = new ArrayList();

        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Admin where username= :username AND password= :password");
            query.setString("username", username);
            query.setString("password", password);
            u = (Admin) query.uniqueResult();
            user = query.list();

            trans.commit();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return user;
    }
    public DAOLoginAdmin() {
    }
}

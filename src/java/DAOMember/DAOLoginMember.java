/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOMember;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import pojo.Member;

/**
 *
 * @author Nishrina
 */
@ManagedBean
public class DAOLoginMember {
        public List<Member> getBy(String email, String password) {
        Member u = new Member();
        List<Member> user = new ArrayList();

    		Configuration configuration = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Member.class);
     		// Create a SessionFactory
     		SessionFactory sf = configuration.buildSessionFactory();
     	        
     		// Open a session
     		Session session = sf.openSession(); 
        try {
            Transaction trans = session.beginTransaction();
            Query query = session.createQuery("from Member where email= :email AND password= :password");
            query.setString("email", email);
            query.setString("password", password);
            u = (Member) query.uniqueResult();
            user = query.list();

            trans.commit();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return user;
    }
    public DAOLoginMember() {
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOMember;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Member;
import util.NewHibernateUtil;

/**
 *
 * @author Nishrina
 */
public class DAOAddMember {
        public void tambah(Member mem){
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            session.save(mem);
            trans.commit();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

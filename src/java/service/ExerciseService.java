/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Exercise;
import util.NewHibernateUtil;

/**
 *
 * @author Nishrina
 */
@ManagedBean
public class ExerciseService {
    public Exercise getbyId(int id){
        Exercise exercise = null;
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("SELECT e FROM Exercise e WHERE e.idExcercise = :id");
            query.setParameter("id", id);
            exercise = (Exercise) query.list().get(0);
            // System.out.println(exercises);
            trans.commit();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            session.close();
        }
    return exercise;
    }
   
}



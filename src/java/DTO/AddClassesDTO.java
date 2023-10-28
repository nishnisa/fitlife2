/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author Nishrina
 */
@ManagedBean
public class AddClassesDTO {
     private int idClasses;


     private Integer idExercise;
     private String classesName;
     private String duration;
     private int slots;
     private String images;

    @Override
    public String toString() {
        return "AddClassesDTO{" + "idClasses=" + idClasses + ", idExercise=" + idExercise + ", classesName=" + classesName + ", duration=" + duration + ", slots=" + slots + ", images=" + images + '}';
    }

 
    public int getIdClasses() {
        return idClasses;
    }

    public void setIdClasses(int idClasses) {
        this.idClasses = idClasses;
    }
     public Integer getIdExercise() {
        return idExercise;
    }

    public void setIdExercise(Integer idExercise) {
        this.idExercise = idExercise;
    }

    public String getClassesName() {
        return classesName;
    }

    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getSlots() {
        return slots;
    }

    public void setSlots(int slots) {
        this.slots = slots;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}

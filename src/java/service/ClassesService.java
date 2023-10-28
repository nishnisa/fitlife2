/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import DAOClass.DAOTampilClass;
import DTO.AddClassesDTO;
import javax.faces.bean.ManagedBean;
import pojo.Exercise;
import pojo.Classes;


/**
 *
 * @author Nishrina
 */
@ManagedBean
public class ClassesService {
    public void savedata(AddClassesDTO addClassesDTO) { 
        ExerciseService exerciseService = new ExerciseService();
        Exercise exercise = exerciseService.getbyId(addClassesDTO.getIdExercise());
        Classes classes = new Classes();
        classes.setIdClasses(addClassesDTO.getIdClasses());
        classes.setClassesName(addClassesDTO.getClassesName());
        classes.setExercise(exercise);
        classes.setDuration(addClassesDTO.getDuration());
        classes.setSlots(addClassesDTO.getSlots());
        classes.setImages(addClassesDTO.getImages());
        
                
        // DAOTampilClass add = new DAOTampilClass();
        // System.out.println(this);
        
//         System.out.println(type );
//         System.out.println("hai rina");
//         System.out.println(addClassesDTO);
//         System.out.println(exercise);
            DAOTampilClass add = new DAOTampilClass();
        add.tambah(classes);
        // add.tambah(this);
    }

}

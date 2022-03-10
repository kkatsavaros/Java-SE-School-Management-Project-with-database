package DAO;

import MODEL.Trainers;
import MODEL.mTm_Trainers_Courses;
import java.util.List;

public interface TrainersDAOInterface {
    
    //public Trainers fetchCB8Trainers();
    
    public void insertTrainers(Trainers t);
    
    public List<Trainers> getAllTrainers();
    
    
    // Trainers: Ο Trainer με το id 8 είναι ο Kostas.
    public String getTrainerById(int sid);
    
    //CB3->14
    // Courses: Το CB3 έχει CourseID 14
    public int getCourseIdFromString(String abc); // Για να μπει στον πίνακα manyTomany.        
    
    // Η τελευταία εγγραφή στον πίνακα Trainers.
    public int FindLastTrainerIDToPutItToManyToManyTable(); // Για να μπει στον πίνακα manyTomany.  
    
    
    //Εισαγωγή στον πίνακα Many To Many Trainers Courses.
    public void insertTrainersCourses(mTm_Trainers_Courses tc);
    
    
    
}
package DAO;

import MODEL.Assignments;
import MODEL.mTm_Assignments_Courses;
import java.util.List;

public interface AssignmentsDAOInterface {
    
    //public Trainers fetchCB8Trainers();
    
    public void insertAssignments(Assignments as);
    
    public List<Assignments> getAllAssignments();
    
   
    
    // Trainers: Ο Trainer με το id 8 είναι ο Kostas.
    public String getAssignmentById(int sid);
    
    //CB3->14
    // Courses: Το CB3 έχει CourseID 14
    public int getCourseIdFromString(String abc); // Για να μπει στον πίνακα manyTomany.        
    
    // Η τελευταία εγγραφή στον πίνακα Trainers.
    public int FindLastAssignmentIDToPutItToManyToManyTable(); // Για να μπει στον πίνακα manyTomany.  
    
    
    //Εισαγωγή στον πίνακα Many To Many Trainers Assignments.
    public void insertAssignmentCourses(mTm_Assignments_Courses ac);
    
    
    
}

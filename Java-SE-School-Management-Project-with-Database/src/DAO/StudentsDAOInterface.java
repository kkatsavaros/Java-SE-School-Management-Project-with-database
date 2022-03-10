package DAO;

import DTO.AssignmentsPerCoursePerStudentDTO;
import DTO.StudentsInMoreThanOneCourseDTO;
import MODEL.Students;
import MODEL.mTm_Students_Courses;
import java.util.List;

public interface StudentsDAOInterface {
    
    
    public void insertStudents(Students st);
   
    public List<Students> getAllStudents();
    
    
    
    
//    // Trainers: Ο Trainer με το id 8 είναι ο Kostas.
    public String getStudentById(int sid);
    
    //CB3->14
    // Courses: Το CB3 έχει CourseID 14
    public int getCourseIdFromString(String abc); // Για να μπει στον πίνακα manyTomany.        

    
    // Η τελευταία εγγραφή στον πίνακα Trainers.
    public int FindLastStudentIDToPutItToManyToManyTable(); // Για να μπει στον πίνακα manyTomany.  
    
    
    //Εισαγωγή στον πίνακα Many To Many Trainers Courses.
    public void insertStudentsCourses(mTm_Students_Courses sc);    
    
    
    
    
    
    // Assignments per Course per Student - DTO
    public List<AssignmentsPerCoursePerStudentDTO> fetchAssignmentsPerCoursePerStudent();

    
    // Students than belong to more than one courses - DTO
    public List<StudentsInMoreThanOneCourseDTO> fetchStudentsThatBelongToMoreThanOneCourse();
    
}

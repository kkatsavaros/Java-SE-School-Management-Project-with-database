package DAO;

import MODEL.Courses;
import java.util.List;

public interface CoursesDAOInterface {
    
    
    
    
    public void insertCourses(Courses c);
    
    public List<Courses> getAllCourses();
    
    
    //Students Per Course
    public Courses showStudentsPerCourse();
    
    
}

package pkg054.playwithdao;

import DAO.AssignmentsDAOImplementation;
import DAO.AssignmentsDAOInterface;
import DAO.CoursesDAOImplementation;
import DAO.CoursesDAOInterface;
import DAO.StudentsDAOImplementation;
import DAO.StudentsDAOInterface;
import DAO.TrainersDAOImplementation;
import DAO.TrainersDAOInterface;
import MODEL.Assignments;
import MODEL.Courses;
import MODEL.Students;
import MODEL.Trainers;
import java.util.List;

public class UserChoice {
    
    
    public static void UserWantsToSeeAllCourses(){       
        
        // Select All Courses
        System.out.println("--------- All Courses ---------------");
        // Η main ζητάει από το Interface να του φέρει όλα τα courses.
        // Επιστρέφει όλα τα Courses και από εκεί και πέρα αν θέλει τα εκτυπώνει 
        //  ή τα δίνει σε κάποιον άλλον.
        CoursesDAOInterface cDAOCourses=new CoursesDAOImplementation();
        //cdaoAllCourses.getAllCourses();
        
        //Το βάζω σε μία λίστα.
        List<Courses> allCourses2 = cDAOCourses.getAllCourses();
        System.out.println("Πίνακας Courses: ");   
        //System.out.println(allCourses2);
        
        for(Courses element:allCourses2){
            System.out.println(                    
                    element.getCTitle()+"  "+
                    element.getCStream()+"  "+
                    element.getCType()+"  "+
                    element.getCStart_Date()+"  "+
                    element.getCEnd_Date()
            );
        }
        
    }    
    
    
    
    public static void UserWantsToSeeAllTrainers(){ 
        // Select All Trainers
        System.out.println("\n--------- All Trainers ---------------");

        TrainersDAOInterface cDAOTrainers= new TrainersDAOImplementation();
        
        List<Trainers> allTrainers2 = cDAOTrainers.getAllTrainers();    
        //System.out.println(allTrainers2);
        System.out.println("Πίνακας Trainers: ");   

        for(Trainers element:allTrainers2){
            System.out.println(                  
                element.getFirstName()+"  "+
                element.getLastName()+"  "+
                element.getSubject()+"  "+
                element.getTCourseTitle()
            );
        }
        
    }
    
    
    
    
    public static void UserWantsToSeeAllStudents(){        
              
        System.out.println("--------- All Students ---------------");  
        StudentsDAOInterface cDAOStudents= new StudentsDAOImplementation();        
        //cDAOStudents.(getAllStudents());
        List<Students> allStudents7 = cDAOStudents.getAllStudents();
        System.out.println("Πίνακας Students: ");   
        //System.out.println(allCourses2);
        
        for(Students element:allStudents7){
            System.out.println(                    
                    element.getSfirstName()+"  "+
                    element.getSLastName()+"  "+
                    element.getSDateOfBirth()+"  "+
                    element.getSTuitionFees()+"  "+
                    element.getSOralMark()+"  "+
                    element.getSWriteMark()+"  "+
                    element.getSTotalMark()+"  "+
                    element.getSCourseTitle()
            );
        }
        
    }    
    
    
    
    public static void UserWantsToSeeAllAssignments(){        
              
        System.out.println("--------- All Assignemnts ---------------");  
        AssignmentsDAOInterface cDAOAssignments= new AssignmentsDAOImplementation();        
        //cDAOStudents.(getAllStudents());
        List<Assignments> allAssignments = cDAOAssignments.getAllAssignments();
        System.out.println("Πίνακας Assignments: ");   
        //System.out.println(allCourses2);
        
        for(Assignments element:allAssignments){
            System.out.println(                    
                    element.getATitle()+"  "+
                    element.getADescription()+"  "+
                    element.getASubDateTime()+"  "+
                    element.getACourseTitle()
                    
            );
        }
        
        
        
        
    }    
    
    
    
    
    
}// end of:UserChoice

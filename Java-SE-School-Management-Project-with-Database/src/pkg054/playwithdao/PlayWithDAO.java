 package pkg054.playwithdao;

import DAO.StudentsDAOImplementation;
import DAO.StudentsDAOInterface;
import DTO.AssignmentsPerCoursePerStudentDTO;
import DTO.StudentsInMoreThanOneCourseDTO;
import INSERTS.insertAssinments;
import INSERTS.insertCourses;
import INSERTS.insertStudents;
import INSERTS.insertTrainers;
import MODEL.zAssignmentsPerCourse;
import MODEL.zStudentsPerCourse;
import MODEL.zTrainersPerCourse;
import java.util.List;
import java.util.Scanner;


public class PlayWithDAO {
    
    public static void main(String[] args) {
        
        int choiceOfTheUser;
        boolean answer=true;
        
        Scanner inputUser=new Scanner(System.in);  
        
        
        OUTER:
        do {
            System.out.println("\nΑν θέλεις να δεις όλα τα Courses πάτησε το 1.");            
            System.out.println("\nΑν θέλεις Εισαγωγή νέου Course το πάτησε το 2.");
            
            System.out.println("\nΑν θέλεις να δεις όλους τους Trainers πάτησε το 3.");            
            System.out.println("\nΑν θέλεις Εισαγωγή νέου Trainer το πάτησε το 4.");
            
            System.out.println("\nΑν θέλεις να δεις όλους τους Students πάτησε το 5.");            
            System.out.println("\nΑν θέλεις Εισαγωγή νέου Student το πάτησε το 6.");            
            
            System.out.println("\nΑν θέλεις να δεις όλους τα Assignments πάτησε το 7.");            
            System.out.println("\nΑν θέλεις Εισαγωγή νέου Assignment το πάτησε το 8.");
            
            System.out.println("--------------------------------------------------------------");
            System.out.println("\nΑν θέλεις Λίστα Studens per Course πάτησε το 9.");
            
            System.out.println("\nΑν θέλεις Λίστα Trainers per Course πάτησε το 10.");
            
            System.out.println("\nΑν θέλεις Λίστα Assignments per Course πάτησε το 11.");
            
            System.out.println("--------------------------------------------------------------");
            System.out.println("\nAssignments per Course per Student per Course πάτησε το 12.");
            
            System.out.println("\nStudents that belong to more than one courses πάτησε το 13.");
            
            
            
            
            choiceOfTheUser=inputUser.nextInt();
           
            switch (choiceOfTheUser) {
                
                case 1:
                    System.out.println("Πάτησες το 1");
                    answer=true;
                    UserChoice.UserWantsToSeeAllCourses();                    
                    break OUTER;
                    
                case 2:
                    System.out.println("Πάτησες το 2");
                    answer=true;
                    //UserChoice.UserWantsToInsertCourses(); 
                    insertCourses.AddCoursesFromUserInput();
                    break OUTER;
                    
                case 3:
                    System.out.println("Πάτησες το 3");
                    answer=true;
                    UserChoice.UserWantsToSeeAllTrainers();  
                    break OUTER;    
                    
                case 4:
                    System.out.println("Πάτησες το 4");
                    answer=true;
                    insertTrainers.AddTrainersFromUserInput();
                    break OUTER;   
                    
                case 5:
                    System.out.println("Πάτησες το 5");
                    answer=true;
                    UserChoice.UserWantsToSeeAllStudents();  
                    break OUTER;    
                    
                case 6:
                    System.out.println("Πάτησες το 6");
                    answer=true;
                    insertStudents.AddStudentsFromUserInput();
                    break OUTER;
                    
                case 7:
                    System.out.println("Πάτησες το 7");
                    answer=true;
                    UserChoice.UserWantsToSeeAllAssignments();  
                    break OUTER;    
                    
                case 8:
                    System.out.println("Πάτησες το 8");
                    answer=true;
                    insertAssinments.AddAssignmetsFromUserInput();
                    break OUTER;   
                    
                case 9:
                    System.out.println("Πάτησες το 9 - Students Per Course");
                    answer=true;
                    zStudentsPerCourse.StudentsPerCourse();
                    break OUTER;        
                
                case 10:
                    System.out.println("Πάτησες το 10 - Trainers Per Course");
                    answer=true;
                    zTrainersPerCourse.TrainersPerCourse();
                    break OUTER;  
                
                case 11:
                    System.out.println("Πάτησες το 11 - Assignments Per Course");
                    answer=true;
                    zAssignmentsPerCourse.AssignmentsPerCourse();
                    break OUTER;      
                    
               case 12:
                    System.out.println("Πάτησες το 12 - Assignments Per Course Per Student.");
                    answer=true;
                    
                    //DTO
                    StudentsDAOInterface acs=new StudentsDAOImplementation();                    
                    List<AssignmentsPerCoursePerStudentDTO> result=acs.fetchAssignmentsPerCoursePerStudent();
                    
                    
                    for(AssignmentsPerCoursePerStudentDTO element:result){
                        System.out.println(                                
                            element.getStudentName()+"  "+
                            element.getCourseTitle()+" "+
                            element.getAssignmentTitle()                           
                        );                       
                    }           
                    
                    break OUTER;           
                
                    
                case 13:
                    System.out.println("Πάτησες το 13 - Students That Belong To more than one Course.");
                    answer=true;
                    
                    //DTO
                    StudentsDAOInterface smc=new StudentsDAOImplementation();                    
                    List<StudentsInMoreThanOneCourseDTO> result2=smc.fetchStudentsThatBelongToMoreThanOneCourse();                    
                    
                    for(StudentsInMoreThanOneCourseDTO element:result2){
                        System.out.println(                                
                            element.getStudentLastName()+"  "+
                            element.getStudentFirstName()+" "+
                            element.getStudentCourses()                             
                        );                       
                    }    
                    
                    
                    break OUTER;       
                    
                    
                    
                    
                    
                    
                    
                default:
                    answer=false;
                    break;
            }
            
        } while (answer==false);

              
        
        
    
    }
    
}
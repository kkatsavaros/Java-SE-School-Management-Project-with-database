package INSERTS;

import DAO.AssignmentsDAOImplementation;
import DAO.AssignmentsDAOInterface;
import DAO.CoursesDAOImplementation;
import DAO.CoursesDAOInterface;
import MODEL.Assignments;
import MODEL.Courses;
import MODEL.mTm_Assignments_Courses;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class insertAssinments {
    
    
    public static void AddAssignmetsFromUserInput(){  
      
        
        String answer;
        answer="";
        
        Scanner input = new Scanner(System.in);
        
        String titleAssignment;
        String description;
        String SubDateTime;      
        String assignmentCourse;
        
        
        
        System.out.println("Εισαγωγή στοιχείων Assignment: ");
        
do{ // Αυτό είναι του "}while(answer.equalsIgnoreCase("YES"));"
        
        //1. Εισαγωγή τίτλου Assignemnt:   
        //------------------------------------------------------------------------------------------------------------------
        // Ελέγχω αν ο χρήστης δεν πληκτρολόγησε τίποτα χρησιμοποιώντας την μέθοδο CheckIfItIsEmpty της κλάσης CheckUserInputs.
        boolean checkEmpty1=false;       
        do{
            
            System.out.println("\n1. Εισαγωγή τίτλου Assignemnt: ");         
            titleAssignment=input.nextLine();  
            
            checkEmpty1=CheckUserInputs.CheckIfItIsEmpty(titleAssignment);  // Εδώ γίνεται ο έλεγχος.
            //System.out.println(checkEmpty1);
            
            if(checkEmpty1==false){
                System.out.println("Το πεδίο είναι άδειο.");
            }
        }
        while(checkEmpty1==false);
        //------------------------------------------------------------------------------------------------------------------
        
        
        //2. Εισαγωγή description Assignment:
        //------------------------------------------------------------------------------------------------------------------
        // Ελέγχω αν ο χρήστης δεν πληκτρολόγησε τίποτα χρησιμοποιώντας την μέθοδο CheckIfItIsEmpty της κλάσης CheckUserInputs.
        boolean checkEmpty2=false;       
        do{
            
            System.out.println("\n2. Εισαγωγή description Assignment: "); 
            description=input.nextLine();
            
            checkEmpty2=CheckUserInputs.CheckIfItIsEmpty(description);  // Εδώ γίνεται ο έλεγχος.
            //System.out.println(checkEmpty2);
            
            if(checkEmpty2==false){
                System.out.println("Το πεδίο είναι άδειο.");
            }
        }
        while(checkEmpty2==false);
        //------------------------------------------------------------------------------------------------------------------
        
        
        
        //3. Εισαγωγή Ημερομηνίας Υποβολής Assignment.
        //------------------------------------------------------------------------------------------------------------------
        // Ελέγχω αν ο χρήστης δεν πληκτρολόγησε τίποτα χρησιμοποιώντας την μέθοδο CheckIfItIsEmpty της κλάσης CheckUserInputs.
        // Ελέγχω αν ο χρήστης πληκτρολόγησε μόνο FULL ή PART χρησιμοποιώντας την μέθοδο CheckFullPart της κλάσης CheckUserInputs.
        boolean checkEmpty3=false;
        boolean a2=false;       
        do{
            
            System.out.println("\n4. Εισαγωγή Ημερομηνίας Υποβολής Assignment: DD-MM-YYYY HH:mm"); 
            SubDateTime=input.nextLine();
            
            // Ελεγχος αν ο χρήστης πληκτρολόγησε κάτι.
            checkEmpty3=CheckUserInputs.CheckIfItIsEmpty(SubDateTime);
            //System.out.println(checkEmpty4);
            
//            if(checkEmpty4==false  && a2==true){
//                System.out.println("Το πεδίο είναι άδειο.");
//            }   
            

            // Ελεγχος αν ο χρήστης πληκτρολόγησε σωστά την ημερομηνία.
            a2=CheckUserInputs.CheckStartDate(SubDateTime);  
            //System.out.println(a2);
            
            if(a2==false){
                System.out.println("Οχι σωστός τύπος ημερομηνίας.");
            } 
        }
        while(a2==false);
        //------------------------------------------------------------------------------------------------------------------        
        
               
        
        
        //7. Εισαγωγή Course του Assignment:   
        //------------------------------------------------------------------------------------------------------------------
        // Ελέγχω αν ο χρήστης δεν πληκτρολόγησε τίποτα χρησιμοποιώντας την μέθοδο CheckIfItIsEmpty της κλάσης CheckUserInputs.
        boolean checkEmptyCourse=false;       
        do{ 
            
            //Course show
            CoursesDAOInterface cDAOCourses=new CoursesDAOImplementation();
            //Το βάζω σε μία λίστα.
            List<Courses> allCourses2 = cDAOCourses.getAllCourses();       
            //System.out.println(allCourses2);
            ArrayList<String> tempListOfTitles = new ArrayList<>();
            
            for(Courses element:allCourses2){               
                tempListOfTitles.add(element.getCTitle());
            }
            System.out.println(tempListOfTitles);
            //System.out.println("--------ok");
            
            System.out.println("\n1. Εισαγωγή Course του Assignment: ");         
            assignmentCourse=input.next();
  
            
            
            //Αν ο πίνακας περιέχει αυτό που έγραψε ο χρήστης.
            boolean ans = tempListOfTitles.contains(assignmentCourse);  
            if(ans) { // Αν true,
            // βρες το index
            int indexOfTheElement=tempListOfTitles.indexOf(assignmentCourse);             
            

            


            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");        
            LocalDateTime AssignmentSubDate = LocalDateTime.parse(SubDateTime, formatter);
            
        

       
            
            //----------------------------------------------------------------------------------------------------
            // Insert Assignments
            System.out.println("--------- Insert Assignments ---------------");
            AssignmentsDAOInterface cDAOAssignments= new AssignmentsDAOImplementation();
            Assignments as=new Assignments(titleAssignment, description, AssignmentSubDate,assignmentCourse);
            cDAOAssignments.insertAssignments(as);            
            //--------------------------------------------------------------------------------------------------
            
            
            //----------------------------------------------------------------------------------------------------
            // Insert zfk_Courses_Assignments στον πίνακα ManyToMany
            
            // Courses: Το CB3 έχει CourseID 14
            //cDAOTrainers.getCourseIdFromString("CB3");
            cDAOAssignments.getCourseIdFromString(assignmentCourse);
            System.out.println("assignmentCourse: --> "+cDAOAssignments.getCourseIdFromString(assignmentCourse));    


            // Η τελευταία εγγραφή στον πίνακα Assignments.
            cDAOAssignments.FindLastAssignmentIDToPutItToManyToManyTable();
            System.out.println("Last AssignmentID: --> "+cDAOAssignments.FindLastAssignmentIDToPutItToManyToManyTable());
                                                        
                        
                            
//Εισαγωγή στον πίνακα ManyToMany zfk_Courses_Assignments
mTm_Assignments_Courses ac=new mTm_Assignments_Courses(cDAOAssignments.FindLastAssignmentIDToPutItToManyToManyTable(),cDAOAssignments.getCourseIdFromString(assignmentCourse));
cDAOAssignments.insertAssignmentCourses(ac);
            
            //----------------------------------------------------------------------------------------------------
            
            
            
            
            checkEmptyCourse=true; //βγες από την do while την μεγάλη.
            
            
                }else{
            // Αν δεν υπάρχει κάνε ξανά βόλτα στην μικρή do και ξαναρώτα.
                System.out.println("Δεν υπάρχει...");     
            checkEmptyCourse=false;
            }
            
  
            
            //checkEmptyCourse=true;

         }
        while(checkEmptyCourse==false);
        //------------------------------------------------------------------------------------------------------------------
        
    
    
    
    
        
        
        
        
        
        
        //------------------------------------------------------------------------------------------------------------------
        // Ελέγχω αν ο χρήστης πληκτρολόγησε μόνο YES ή ΝO χρησιμοποιώντας την μέθοδο CheckYesNo της κλάσης CheckUserInputs.
        boolean a=false;       
        do{
            System.out.println("\n Θέλεις να Εισάγεις άλλο Assignment; YES/NO :");
            answer=input.next();
            
            // Εδώ γίνεται ο έλεγχος. Αν πατήσει YES ή Νο θα επιστρέψει true άρα θα βγει και θα πάει παρακάτω.
            // Αν πατήσει κάτι άλλο θα επιστρέψει false. 
            a=CheckUserInputs.CheckYesNo(answer);  
            //System.out.println(a);
        }
        while(a==false);// για όσο είνα false κάνε loop
        //------------------------------------------------------------------------------------------------------------------
        
       
        
}while(answer.equalsIgnoreCase("YES"));
        
//System.out.println(Course.allCourses.get(0).getTitle()); // Δουλεύει. ok            
        
        
        
    



        
        
    }        
    
    
}

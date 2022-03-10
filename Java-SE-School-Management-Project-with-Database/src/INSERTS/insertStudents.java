package INSERTS;

import DAO.CoursesDAOImplementation;
import DAO.CoursesDAOInterface;
import DAO.StudentsDAOImplementation;
import DAO.StudentsDAOInterface;
import MODEL.Courses;
import MODEL.Students;
import MODEL.mTm_Students_Courses;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class insertStudents {
    public static void AddStudentsFromUserInput(){ 
        
        String answer;
        answer="";
        
        Scanner input = new Scanner(System.in);
        
        String studentFirstName;
        String studentLastName;
        String studentDateOfBirth;
        int studentTuitionFees;
        
        String studentCourse;
        int studentNumberOfCourses;
        
        
        
        System.out.println("Εισαγωγή στοιχείων ενός Student: ");
        
        
        do{ // Αυτό είναι του "}while(answer.equalsIgnoreCase("YES"));"
        
        //1. Εισαγωγή Ονόματος Μαθητή:   
        //------------------------------------------------------------------------------------------------------------------
        // Ελέγχω αν ο χρήστης δεν πληκτρολόγησε τίποτα χρησιμοποιώντας την μέθοδο CheckIfItIsEmpty της κλάσης CheckUserInputs.
        boolean checkEmpty1=false;       
        do{
            
            System.out.println("\n1. Εισαγωγή Ονόματος Μαθητή: ");         
            studentFirstName=input.nextLine();  
            
            checkEmpty1=CheckUserInputs.CheckIfItIsEmpty(studentFirstName);  // Εδώ γίνεται ο έλεγχος.
            //System.out.println(checkEmpty1);
            
            if(checkEmpty1==false){
                System.out.println("Το πεδίο είναι άδειο.");
            }
        }
        while(checkEmpty1==false);
        //------------------------------------------------------------------------------------------------------------------
        
        
        //2. Εισαγωγή Επίθετου Μαθητή:
        //------------------------------------------------------------------------------------------------------------------
        // Ελέγχω αν ο χρήστης δεν πληκτρολόγησε τίποτα χρησιμοποιώντας την μέθοδο CheckIfItIsEmpty της κλάσης CheckUserInputs.
        boolean checkEmpty2=false;       
        do{
            
            System.out.println("\n2. Εισαγωγή Επίθετου Μαθητή: "); 
            studentLastName=input.nextLine();
            
            checkEmpty2=CheckUserInputs.CheckIfItIsEmpty(studentLastName);  // Εδώ γίνεται ο έλεγχος.
            //System.out.println(checkEmpty2);
            
            if(checkEmpty2==false){
                System.out.println("Το πεδίο είναι άδειο.");
            }
        }
        while(checkEmpty2==false);
        //------------------------------------------------------------------------------------------------------------------
        
        
        //3. Εισαγωγή Ημερομηνία Γέννησης Μαθητή.
        //------------------------------------------------------------------------------------------------------------------
        // Ελέγχω αν ο χρήστης δεν πληκτρολόγησε τίποτα χρησιμοποιώντας την μέθοδο CheckIfItIsEmpty της κλάσης CheckUserInputs.
        // Ελέγχω αν ο χρήστης πληκτρολόγησε μόνο FULL ή PART χρησιμοποιώντας την μέθοδο CheckFullPart της κλάσης CheckUserInputs.
        boolean checkEmpty3=false;
        boolean a2=false;       
        do{
            
            System.out.println("\n4. Εισαγωγή Ημερομηνίας γέννησης του Μαθητή: DD-MM-YYYY: "); 
            studentDateOfBirth=input.nextLine();
            
            // Ελεγχος αν ο χρήστης πληκτρολόγησε κάτι.
            checkEmpty3=CheckUserInputs.CheckIfItIsEmpty(studentDateOfBirth);  
            //System.out.println(checkEmpty4);
            
//            if(checkEmpty4==false  && a2==true){
//                System.out.println("Το πεδίο είναι άδειο.");
//            }   
            

            // Ελεγχος αν ο χρήστης πληκτρολόγησε σωστά την ημερομηνία.
            a2=CheckUserInputs.CheckStartDate(studentDateOfBirth);  
            //System.out.println(a2);
            
            if(a2==false){
                System.out.println("Οχι σωστός τύπος ημερομηνίας.");
            } 
        }
        while(a2==false);
        //------------------------------------------------------------------------------------------------------------------ 
        
        
        
        
        //4. Εισαγωγή Δίδακτρα Μαθητή:   
        //------------------------------------------------------------------------------------------------------------------
        // Ελέγχω αν ο χρήστης δεν πληκτρολόγησε τίποτα χρησιμοποιώντας την μέθοδο CheckIfItIsEmpty της κλάσης CheckUserInputs.
        boolean checkEmptyDate=false;       
        do{
            
            System.out.println("\n1. Εισαγωγή Δίδακτρα Μαθητή: ");         
            studentTuitionFees=input.nextInt();
            
            //checkEmptyDate=CheckUserInputs.CheckIfItIsEmpty(studentTuitionFees);  // Εδώ γίνεται ο έλεγχος.
            //System.out.println(checkEmpty1);
            
//            if(checkEmpty1==false){
//                System.out.println("Το πεδίο είναι άδειο.");
//            }
            
            checkEmptyDate=true;

        }
        while(checkEmptyDate==false);
        //------------------------------------------------------------------------------------------------------------------
        
        
        
        
        //5. Σε ποιο Course θα συμμετέχει ο Μαθητής;
        //------------------------------------------------------------------------------------------------------------------
        // Ελέγχω αν ο χρήστης δεν πληκτρολόγησε τίποτα χρησιμοποιώντας την μέθοδο CheckIfItIsEmpty της κλάσης CheckUserInputs.
        boolean checkEmpty4=false;       
        do{
              
            // Βάζω όλους τους τίτλους σε έναν πίνακα, γιαυτό δημιουργώ έναν ArrayList με strings.    
            // Αυτό το κάνω για να εντοπίσω αν ο χρήστης πληκτρολόγησε σωστά το course.
//            ArrayList<String> tempListOfTitles = new ArrayList<>();
//            for(int k=0;k<=Course.allCourses.size()-1;k++){                
//                tempListOfTitles.add(Course.allCourses.get(k).getTitle());
//            }
//                
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
           
           
            
            
            System.out.println("\n4. Σε πόσα Courses θα συμμετέχει ο Μαθητής; : "); 
            studentNumberOfCourses=input.nextInt();
            
            
                     
            // loop 
            for (int numberOfCources=1;numberOfCources<=studentNumberOfCourses;numberOfCources++){
                
                
                boolean checkEmpty5=false;    
                do{   
                        System.out.println("\n5. Εισαγωγή το "+ numberOfCources +"ο  Course που θα διδάσκεται ο Μαθητής; : "); 
                        studentCourse=input.nextLine();
            
                        // Εδώ γίνεται ο έλεγχος, αν πάτησε κάτι άδειο.
                        checkEmpty5=CheckUserInputs.CheckIfItIsEmpty(studentCourse);                          

                        if(checkEmpty5==false){
                            System.out.println("Το πεδίο είναι άδειο.");
                        }
                                    

                                 
                       //Αν ο πίνακας περιέχει αυτό που έγραψε ο χρήστης.
                       boolean ans = tempListOfTitles.contains(studentCourse);  
                       if(ans) { // Αν true,
                           // βρες το index. /
                           int indexOfTheElement=tempListOfTitles.indexOf(studentCourse);                          

//                            // Δημουργία του αντικειμένου trainer με μία παράμετρο το object Course, Association. //************//
//                            Student s=new Student(studentFirstName, studentLastName, studentDateOfBirth, studentTuitionFees, Course.allCourses.get(indexOfTheElement));
//                            allStudents.add(s);
                            

                             DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                             LocalDate dob = LocalDate.parse(studentDateOfBirth, formatter);   


                            
                            // Insert Trainers
                            System.out.println("--------- Insert Trainers ---------------");
                            StudentsDAOInterface cDAOStudents= new StudentsDAOImplementation();
                            Students st=new Students(studentFirstName, studentLastName, dob, studentTuitionFees,studentCourse );
                            cDAOStudents.insertStudents(st);
                            
                            
                            
                            // Courses: Το CB3 έχει CourseID 14
                            //cDAOTrainers.getCourseIdFromString("CB3");
                            cDAOStudents.getCourseIdFromString(studentCourse);
                            System.out.println("studentCourse: --> "+cDAOStudents.getCourseIdFromString(studentCourse));
                            
                            // Η τελευταία εγγραφή στον πίνακα Trainers.
                            cDAOStudents.FindLastStudentIDToPutItToManyToManyTable();
                            System.out.println("Last StudentID: --> "+cDAOStudents.FindLastStudentIDToPutItToManyToManyTable());
                            
                            
                            
//Εισαγωγή στον πίνακα ManyToMany zfk_Courses_Trainers                           
mTm_Students_Courses sc=new mTm_Students_Courses(cDAOStudents.FindLastStudentIDToPutItToManyToManyTable(),cDAOStudents.getCourseIdFromString(studentCourse));
cDAOStudents.insertStudentsCourses(sc);   
                            
                            
                            
                           

                            checkEmpty4=true; //βγες από την do while την μεγάλη.
                       }else{
                           // Αν δεν υπάρχει κάνε ξανά βόλτα στην μικρή do και ξαναρώτα.
                           System.out.println("Δεν υπάρχει...");     
                           checkEmpty5=false;
                       }
                 }while(checkEmpty5==false);          

            } // end of: for 
                        
            
           checkEmpty4=true; //βγες από την do while την μεγάλη.
            
            
        }
        while(checkEmpty4==false);
        //------------------------------------------------------------------------------------------------------------------
        
        //------------------------------------------------------------------------------------------------------------------
        // Ελέγχω αν ο χρήστης πληκτρολόγησε μόνο YES ή ΝO χρησιμοποιώντας την μέθοδο CheckYesNo της κλάσης CheckUserInputs.
        boolean a=false;       
        do{
            System.out.println("\n Θέλεις να Εισάγεις άλλον Μαθητή; YES/NO :");
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
       // return allTrainers;
        
        
        
        
        
        
        
        
    }   
    
}

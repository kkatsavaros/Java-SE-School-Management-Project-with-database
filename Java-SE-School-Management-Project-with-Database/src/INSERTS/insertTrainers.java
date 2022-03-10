package INSERTS;

import DAO.CoursesDAOImplementation;
import DAO.CoursesDAOInterface;
import DAO.TrainersDAOImplementation;
import DAO.TrainersDAOInterface;
import MODEL.Courses;
import MODEL.Trainers;
import MODEL.mTm_Trainers_Courses;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class insertTrainers {
    
    
     public static void AddTrainersFromUserInput(){    
     
        String answer;
        answer="";
        
        Scanner input = new Scanner(System.in);
        
        String trainerFirstName;
        String trainerLastName;
        String trainerSubject;
        String trainerCourse;
        int trainerNumberOfCourses;
        
        
        
        System.out.println("Εισαγωγή στοιχείων ενός Trainer: ");
        
        
        do{ // Αυτό είναι του "}while(answer.equalsIgnoreCase("YES"));"
        
        //1. Εισαγωγή Ονόματος Καθηγητή:   
        //------------------------------------------------------------------------------------------------------------------
        // Ελέγχω αν ο χρήστης δεν πληκτρολόγησε τίποτα χρησιμοποιώντας την μέθοδο CheckIfItIsEmpty της κλάσης CheckUserInputs.
        boolean checkEmpty1=false;       
        do{
            
            System.out.println("\n1. Εισαγωγή Ονόματος Καθηγητή: ");         
            trainerFirstName=input.nextLine();  
            
            checkEmpty1=CheckUserInputs.CheckIfItIsEmpty(trainerFirstName);  // Εδώ γίνεται ο έλεγχος.
            //System.out.println(checkEmpty1);
            
            if(checkEmpty1==false){
                System.out.println("Το πεδίο είναι άδειο.");
            }
        }
        while(checkEmpty1==false);
        //------------------------------------------------------------------------------------------------------------------
        
        
        //2. Εισαγωγή Επίθετου Καθηγητή:
        //------------------------------------------------------------------------------------------------------------------
        // Ελέγχω αν ο χρήστης δεν πληκτρολόγησε τίποτα χρησιμοποιώντας την μέθοδο CheckIfItIsEmpty της κλάσης CheckUserInputs.
        boolean checkEmpty2=false;       
        do{
            
            System.out.println("\n2. Εισαγωγή Επίθετου Καθηγητή: "); 
            trainerLastName=input.nextLine();
            
            checkEmpty2=CheckUserInputs.CheckIfItIsEmpty(trainerLastName);  // Εδώ γίνεται ο έλεγχος.
            //System.out.println(checkEmpty2);
            
            if(checkEmpty2==false){
                System.out.println("Το πεδίο είναι άδειο.");
            }
        }
        while(checkEmpty2==false);
        //------------------------------------------------------------------------------------------------------------------
        
        //3. Εισαγωγή Μαθήματος Καθηγητή:
        //------------------------------------------------------------------------------------------------------------------
        // Ελέγχω αν ο χρήστης δεν πληκτρολόγησε τίποτα χρησιμοποιώντας την μέθοδο CheckIfItIsEmpty της κλάσης CheckUserInputs.
        boolean checkEmpty3=false;       
        do{
            
            System.out.println("\n3. Εισαγωγή Μαθήματος Καθηγητή: "); 
            trainerSubject=input.nextLine();
            
            checkEmpty3=CheckUserInputs.CheckIfItIsEmpty(trainerSubject);  // Εδώ γίνεται ο έλεγχος.
            //System.out.println(checkEmpty2);
            
            if(checkEmpty3==false){
                System.out.println("Το πεδίο είναι άδειο.");
            }
        }
        while(checkEmpty3==false);
        //------------------------------------------------------------------------------------------------------------------
        
        
        //4. Σε ποιο Course θα διδάσκει ο Καθηγητής;
        //------------------------------------------------------------------------------------------------------------------
        // Ελέγχω αν ο χρήστης δεν πληκτρολόγησε τίποτα χρησιμοποιώντας την μέθοδο CheckIfItIsEmpty της κλάσης CheckUserInputs.
        boolean checkEmpty4=false;       
        boolean checkEmpty41=false;       
        boolean checkEmpty42=false;       
        
        do{     
            
            // Courses show
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
          
           
            
            
            System.out.println("\n4. Σε πόσα Courses θα διδάσκει ο Καθηγητής; : "); 
            trainerNumberOfCourses=input.nextInt();          
            
        
            
            
                     
            // loop 
            for (int numberOfCources=1;numberOfCources<=trainerNumberOfCourses;numberOfCources++){
                
                
                boolean checkEmpty5=false;    
                do{   
                        System.out.println("\n5. Εισαγωγή το "+ numberOfCources +"ο  Course που θα διδάσκει ο Καθηγητής; : "); 
                        trainerCourse=input.nextLine();
            
                        // Εδώ γίνεται ο έλεγχος, αν πάτησε κάτι άδειο.
                        checkEmpty5=CheckUserInputs.CheckIfItIsEmpty(trainerCourse);                          

                        if(checkEmpty5==false){
                            System.out.println("Το πεδίο είναι άδειο.");
                        }
                                    

                                 
                       //Αν ο πίνακας περιέχει αυτό που έγραψε ο χρήστης.
                       boolean ans = tempListOfTitles.contains(trainerCourse);  
                       if(ans) { // Αν true,
                           // βρες το index
                           int indexOfTheElement=tempListOfTitles.indexOf(trainerCourse);                          

//                            // Δημουργία του αντικειμένου trainer με μία παράμετρο το object Course, Association. //************//
//                            Trainer t=new Trainer(trainerFirstName, trainerLastName, trainerSubject, Course.allCourses.get(indexOfTheElement));
//                            allTrainers.add(t);

                            
                            // Insert Trainers
                            System.out.println("--------- Insert Trainers ---------------");
                            TrainersDAOInterface cDAOTrainers= new TrainersDAOImplementation();
                            Trainers t=new Trainers(trainerFirstName, trainerLastName, trainerSubject,trainerCourse);
                            cDAOTrainers.insertTrainers(t);
                            
                         
                            
                            
                            // Courses: Το CB3 έχει CourseID 14
                            //cDAOTrainers.getCourseIdFromString("CB3");
                            cDAOTrainers.getCourseIdFromString(trainerCourse);
                            System.out.println("trainerCourse: --> "+cDAOTrainers.getCourseIdFromString(trainerCourse));    


                            // Η τελευταία εγγραφή στον πίνακα Trainers.
                            cDAOTrainers.FindLastTrainerIDToPutItToManyToManyTable();
                            System.out.println("Last TrainerID: --> "+cDAOTrainers.FindLastTrainerIDToPutItToManyToManyTable());
                                                        
                        
                            
//Εισαγωγή στον πίνακα ManyToMany zfk_Courses_Trainers                           
mTm_Trainers_Courses tc=new mTm_Trainers_Courses(cDAOTrainers.FindLastTrainerIDToPutItToManyToManyTable(),cDAOTrainers.getCourseIdFromString(trainerCourse));
cDAOTrainers.insertTrainersCourses(tc);                            
                        





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
            System.out.println("\n Θέλεις να Εισάγεις άλλον Καθηγητή; YES/NO :");
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
        //return allTrainers;
        
        
        
        
        
        
    } // τέλος μεθόδου.  
    //--------------------------------------------------------------------------------------------------- 
    
    
    
}

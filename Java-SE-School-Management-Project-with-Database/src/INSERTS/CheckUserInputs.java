package INSERTS;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;



class CheckUserInputs {
    
    public static boolean CheckIfItIsEmpty(String userAnswer){
        
        String nullVariable="";
        if("".equals(userAnswer)){
            return false;    //Τα βάζω αντίθετα για την μέθοδο.        
        }else{
            return true;
        }
        
    }
    
    public static boolean CheckIfItIsEmpty(int userAnswer){
        
        String nullVariable="";
        if("".equals(userAnswer)){
            return false;    //Τα βάζω αντίθετα για την μέθοδο.        
        }else{
            return true;
        }
        
    }
    
    
    public static boolean CheckIfItIsNumber(int userAnswer){
        
        
            
        return false;
    }
    
    
    
    
    
    
    // Ελεγχος αν ο χρήστης πληκτρολόγησε Yes ή No.
    public static boolean CheckYesNo(String userAnswer){
        
        if("YES".equals(userAnswer) || "NO".equals(userAnswer)){
            return true;            
        }else{
           return false; 
        }
    }
    
    
    // Ελεγχος αν ο χρήστης πληκτρολόγησε Full ή Part.
    public static boolean CheckFullPart(String userAnswer){        
        
        if("FULL".equals(userAnswer) || "PART".equals(userAnswer)){
            return true;            
        }else{
           return false; 
        }
        
    }
    
    
    
    // Ελεγχος αν ο χρήστης πληκτρολόγησε σωστά την Ημερομηνία start_date
    public static boolean CheckStartDate(String userAnswer){        
        
        // Μετατροπή ημερομηνίας από String σε Date.
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");        
        format.setLenient(false);
        //String date = "85/08/2017";
        String date = userAnswer;
        
        
            try {
                format.parse(date);
                //System.out.println(format.parse(date));
                //System.out.println("ok");
                return true;
                //tmpVariable=true;

            } catch (ParseException e) {
                //System.out.println("Date " + date + " is not valid according to " + ((SimpleDateFormat) format).toPattern() + " pattern.");
                //System.out.println("wrong");
                return false;
            }
            
    }
    
    
    
}

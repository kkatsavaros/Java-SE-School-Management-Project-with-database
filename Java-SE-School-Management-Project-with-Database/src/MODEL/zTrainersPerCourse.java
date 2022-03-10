package MODEL;

import DAO.CoursesDAOImplementation;
import DAO.CoursesDAOInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pkg054.playwithdao.DBUtilities;


public class zTrainersPerCourse {
    
      public static void TrainersPerCourse() {                
        
        System.out.println("Trainers Per Course:");        
        System.out.println("");
        
        CoursesDAOInterface cDAOCourses=new CoursesDAOImplementation();
        //Το βάζω σε μία λίστα.
        List<Courses> allCourses2 = cDAOCourses.getAllCourses();       
        //System.out.println(allCourses2);
        ArrayList<String> tempListOfTitles = new ArrayList<>();   
        
        
        
        for(Courses element:allCourses2){               
                    tempListOfTitles.add(element.getCTitle()); // [CB1, CB2, CB3, CB4, CB5, CB6, CB12]

                     String sql="SELECT * FROM trainers"+
                                " where TCourseTitle=?"; 
                       
                     Connection con=null; 
                     PreparedStatement ps=null;    

                 try{            
                     con=DBUtilities.getConnection();            
                     ps=con.prepareStatement(sql);
                     ps.setString(1,element.getCTitle());
                     ResultSet rs=ps.executeQuery();  //select           

                     System.out.println("Στο Course "+ element.getCTitle()+" υπάρχουν οι παρακάτω Trainers.");
                     while(rs.next()){ // Αν φέρεις έστω και μία εγγραφή, γίνε true και μπες μέσα.

                         System.out.println(
                                 rs.getString("TFirstName")+"  "+
                                 rs.getString("TLastName")+"  "+
                                 rs.getString("TSubject")+"  "+
                                 rs.getString("TCourseTitle")
                         );
                     }
                     System.out.println("");

                 }catch(SQLException ex){         
                     ex.printStackTrace();

                     }finally{
                         try {
                             ps.close();
                             con.close();
                         } catch (SQLException ex) {
                             ex.printStackTrace();                
                         }
                     }
                 }
        
                System.out.println(tempListOfTitles);        
        
    }    
    
}

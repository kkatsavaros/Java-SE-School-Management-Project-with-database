package DAO;

import MODEL.Trainers;
import MODEL.mTm_Trainers_Courses;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pkg054.playwithdao.DBUtilities;

public class TrainersDAOImplementation implements TrainersDAOInterface{
    
    
     private Connection con=null; 
    
    
    
    @Override
    public void insertTrainers(Trainers t) {
       
         String sql="INSERT INTO trainers (TFirstName,TLastName,TSubject,TCourseTitle) VALUES (?,?,?,?)";        
        //String sql="INSERT INTO test(a2) VALUES (?)";        
        PreparedStatement ps=null;        
        
        try{            
            con=DBUtilities.getConnection();            
            ps=con.prepareStatement(sql);     
            
            ps.setString(1,t.getFirstName());
            ps.setString(2,t.getLastName());
            ps.setString(3,t.getSubject());
            ps.setString(4,t.getTCourseTitle());
            
            ps.executeUpdate();            
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

    
    
    
    
    
    @Override
    public List<Trainers> getAllTrainers() {
          
        String sql="SELECT * FROM trainers"; 
        PreparedStatement ps=null;     
        
// To List είναι interface, και η μέθοδος getAllCourses() επιστρέφει ένα Interface. 
// Έτσι ώστε να μπορώ να παίζω στις λίστες μου. 
        //ArrayList<Trainers> result=new ArrayList<>();
        ArrayList<Trainers> result=new ArrayList<>();
        
        try{            
            con=DBUtilities.getConnection();            
            ps=con.prepareStatement(sql);                   
            ResultSet rs=ps.executeQuery();  //select                
         
            
            //TrainersDAOImplementation smdi= new TrainersDAOImplementation();
            
            //Διαβάζω το ResultSet και φτιάχνω Courses.
            while(rs.next()){
                //Για κάθε μία εγγραφή φτιάξε μου ένα αντικείμενο Trainers.
                Trainers t=new Trainers(
                        rs.getString("TFirstName"),
                        rs.getString("TLastName"),
                        rs.getString("TSubject"), 
                        rs.getString("TCourseTitle")
                );
                
                // Αφού το φτιάξω, πρέπει να το βάλω κάπου. 
                // Τι πρέπε να επιστρέψω? Μία Λίστα.
                
                result.add(t);                
            }
            
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
        
        return result; // Βασικό.        
    }
    
    
    
    
    
    
    
    
    
    @Override
    public String getTrainerById(int sid) {
         String sql = "SELECT * FROM trainers" +
                        " WHERE trainerid=?";
         
        PreparedStatement ps = null;
        //Trainer result = new Trainers();
        String result;
        result="";
        try{
            con = DBUtilities.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, sid);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                result=rs.getString(2);
                //result.setLastName(rs.getString(2));
                //result.getSubject(rs.getString(3));               
                
            }
        } catch (SQLException ex) {
            //Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
             try {
                 ps.close();
               //  con.close();
             } catch (SQLException ex) {
                // Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        return result;
        
    }

    
    
    
     @Override
     //Βάζω CB3 και θα μου βγάλει το 14
    public int getCourseIdFromString(String myString) {
         String sql = "SELECT * FROM courses" +
                        " WHERE CTitle=?";
         
        PreparedStatement ps = null;
        //Trainer result = new Trainers();
        int result;
        result=0;
        try{
            con = DBUtilities.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, myString);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                result=rs.getInt(1);
                //result.setLastName(rs.getString(2));
                //result.getSubject(rs.getString(3));               
                
            }
        } catch (SQLException ex) {
            //Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
             try {
                 ps.close();
               //  con.close();
             } catch (SQLException ex) {
                // Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        return result;
        
    }
   

    
    
    
    @Override
    public int FindLastTrainerIDToPutItToManyToManyTable() {
        
         String sql = "SELECT MAX(Trainerid) FROM schoolmanagement.trainers";
         
        PreparedStatement ps = null;
        //Trainer result = new Trainers();
        int result;
        result=0;
        try{
            con = DBUtilities.getConnection();
            ps = con.prepareStatement(sql);
            //ps.setString(1, myString);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                result=rs.getInt(1);
                //result.setLastName(rs.getString(2));
                //result.getSubject(rs.getString(3));               
                
            }
        } catch (SQLException ex) {
            //Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
             try {
                 ps.close();
               //  con.close();
             } catch (SQLException ex) {
                // Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        return result;
         
        
    }


@Override
    public void insertTrainersCourses(mTm_Trainers_Courses tc) {
       
         String sql="INSERT INTO zfk_courses_trainers (trainerid,courseid) VALUES (?,?)";        
        //String sql="INSERT INTO test(a2) VALUES (?)";        
        PreparedStatement ps=null;        
        
        try{            
            con=DBUtilities.getConnection();            
            ps=con.prepareStatement(sql);     
            
            ps.setInt(1,tc.getTrainerID());
            ps.setInt(2,tc.getCourseID());
            
            
            ps.executeUpdate();            
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
    
  
    
    
}
package DAO;

import MODEL.Assignments;
import MODEL.mTm_Assignments_Courses;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import pkg054.playwithdao.DBUtilities;

public class AssignmentsDAOImplementation implements AssignmentsDAOInterface{
    
    private Connection con=null;     
    
    
    @Override
    public void insertAssignments(Assignments as) {
       
         String sql="INSERT INTO assignments (ATitle,ADescription,AsubDataTime,ACourseTitle) VALUES (?,?,?,?)";        
        //String sql="INSERT INTO test(a2) VALUES (?)";        
        PreparedStatement ps=null;        
        
        try{            
            con=DBUtilities.getConnection();            
            ps=con.prepareStatement(sql);     
            
            ps.setString(1,as.getATitle());
            ps.setString(2,as.getADescription());
            //ps.setDate(3,as.getASubDateTime());
            ps.setTimestamp(3,Timestamp.valueOf(as.getASubDateTime()));
            ps.setString(4,as.getACourseTitle());
            
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
    public List<Assignments> getAllAssignments() {
          
        String sql="SELECT * FROM assignments"; 
        PreparedStatement ps=null;     
        
// To List είναι interface, και η μέθοδος getAllCourses() επιστρέφει ένα Interface. 
// Έτσι ώστε να μπορώ να παίζω στις λίστες μου. 
        //ArrayList<Trainers> result=new ArrayList<>();
        ArrayList<Assignments> result=new ArrayList<>();
        
        try{            
            con=DBUtilities.getConnection();            
            ps=con.prepareStatement(sql);                   
            ResultSet rs=ps.executeQuery();  //select                
         
            
            //TrainersDAOImplementation smdi= new TrainersDAOImplementation();
            
            //Διαβάζω το ResultSet και φτιάχνω Courses.
            while(rs.next()){
                //Για κάθε μία εγγραφή φτιάξε μου ένα αντικείμενο Trainers.
                Assignments as=new Assignments(
                        rs.getString("ATitle"),
                        rs.getString("ADescription"),
                        rs.getTimestamp("ASubDataTime").toLocalDateTime(), 
                        rs.getString("ACourseTitle")
                );
                
                // Αφού το φτιάξω, πρέπει να το βάλω κάπου. 
                // Τι πρέπε να επιστρέψω? Μία Λίστα.
                
                result.add(as);                
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
    public String getAssignmentById(int sid) {
         String sql = "SELECT * FROM assignments" +
                        " WHERE assignmentid=?";
         
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
    public int FindLastAssignmentIDToPutItToManyToManyTable() {
        
         String sql = "SELECT MAX(Assignmentid) FROM schoolmanagement.assignments";
         
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
    public void insertAssignmentCourses(mTm_Assignments_Courses ac) {
       
         String sql="INSERT INTO zfk_courses_assignments (assignmentid,courseid) VALUES (?,?)";        
        //String sql="INSERT INTO test(a2) VALUES (?)";        
        PreparedStatement ps=null;        
        
        try{            
            con=DBUtilities.getConnection();            
            ps=con.prepareStatement(sql);     
            
            ps.setInt(1,ac.getAssignmentID());
            ps.setInt(2,ac.getCourseID());
            
            
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

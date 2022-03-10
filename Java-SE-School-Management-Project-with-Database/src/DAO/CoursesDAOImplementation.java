package DAO;

import MODEL.Courses;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pkg054.playwithdao.DBUtilities;

public class CoursesDAOImplementation implements CoursesDAOInterface{    
    
    private Connection con=null; 
    
    
    
    
    @Override
    public void insertCourses(Courses c) {
        
        String sql="INSERT INTO Courses (CTitle,CStream,CType,CStart_Date,CEnd_Date) VALUES (?,?,?,?,?)";        
        //String sql="INSERT INTO test(a2) VALUES (?)";        
        PreparedStatement ps=null;        
        
        try{            
            con=DBUtilities.getConnection();            
            ps=con.prepareStatement(sql);     
            
            ps.setString(1,c.getCTitle());
            ps.setString(2,c.getCStream());
            ps.setString(3,c.getCType());            
            ps.setDate(4,Date.valueOf(c.getCStart_Date())); // Μετατροπή του LocalDate σε Date για να μπει στην MySQL.
            ps.setDate(5,Date.valueOf(c.getCEnd_Date()));   // Μετατροπή του LocalDate σε Date για να μπει στην MySQL.
            
            
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
    public List<Courses> getAllCourses() {//ok
    
        String sql="SELECT * FROM courses"; 
        PreparedStatement ps=null;     
        
// To List είναι interface, και η μέθοδος getAllCourses() επιστρέφει ένα Interface. 
// Έτσι ώστε να μπορώ να παίζω στις λίστες μου. 
        ArrayList<Courses> result=new ArrayList<>();
        
        try{            
            con=DBUtilities.getConnection();            
            ps=con.prepareStatement(sql);                   
            ResultSet rs=ps.executeQuery();  //select    
            
            //Διαβάζω το ResultSet και φτιάχνω Courses.
            while(rs.next()){
                //Για κάθε μία εγγραφή φτιάξε μου ένα αντικείμενο Courses.
                Courses c=new Courses(
                        rs.getString("CTitle"),
                        rs.getString("CStream"),
                        rs.getString("CType"),
                        rs.getDate("CStart_Date").toLocalDate(), // Μετατροπή του Date της MySQL, σε LocalDate.
                        rs.getDate("CEnd_Date").toLocalDate()    // Μετατροπή του Date της MySQL, σε LocalDate.
                );
                
                // Αφού το φτιάξω, πρέπει να το βάλω κάπου. 
                // Τι πρέπε να επιστρέψω? Μία Λίστα.
                
                result.add(c);
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
    
    
    
    
    //Students Per Course
    @Override
    public Courses showStudentsPerCourse() {    
        
        
        
        String sql="SELECT * FROM courses "+
                    "where CTitle='CB8' "; 
        PreparedStatement ps=null;    
        
// To List είναι interface, και η μέθοδος getAllCourses() επιστρέφει ένα Interface. 
// Έτσι ώστε να μπορώ να παίζω στις λίστες μου. 
        //ArrayList<Courses> result=new ArrayList<>();
        Courses result=new Courses(); // Δηλωνω ότι το result είναι Courses
        
        
        try{            
            con=DBUtilities.getConnection();            
            ps=con.prepareStatement(sql);     
            ResultSet rs=ps.executeQuery();  //select    
            
            //Διαβάζω το ResultSet και φτιάχνω Courses.
            if(rs.next()){ // Αν φέρεις έστω και μία εγγραφή, γίνε true και μπες μέσα.
                
                result.setCTitle(rs.getString("CTitle"));
                result.setCStream(rs.getString("CStream"));
                result.setCType(rs.getString("CType"));
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
    
    
}
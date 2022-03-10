package DAO;

import DTO.AssignmentsPerCoursePerStudentDTO;
import DTO.StudentsInMoreThanOneCourseDTO;
import MODEL.Students;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import MODEL.mTm_Students_Courses;
import java.util.ArrayList;
import java.util.List;
import pkg054.playwithdao.DBUtilities;



public class StudentsDAOImplementation implements StudentsDAOInterface{
    
    private Connection con=null; 



    
    @Override
    public void insertStudents(Students st) {
       
        String sql="INSERT INTO students (SFirstName,SLastName,SBirthday,STuitionFees,SCourseTitle) VALUES (?,?,?,?,?)";        
        //String sql="INSERT INTO test(a2) VALUES (?)";        
        PreparedStatement ps=null;        
        
        try{            
            con=DBUtilities.getConnection();            
            ps=con.prepareStatement(sql);     
            
            ps.setString(1,st.getSfirstName());
            ps.setString(2,st.getSLastName());
            ps.setDate(3,Date.valueOf(st.getSDateOfBirth()));
            ps.setInt(4,st.getSTuitionFees());
            ps.setString(5,st.getSCourseTitle());
            
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
    public List<Students> getAllStudents() {
        
        String sql="SELECT * FROM students"; 
        PreparedStatement ps=null;     
        
// To List είναι interface, και η μέθοδος getAllCourses() επιστρέφει ένα Interface. 
// Έτσι ώστε να μπορώ να παίζω στις λίστες μου. 
        //ArrayList<Trainers> result=new ArrayList<>();
        ArrayList<Students> result=new ArrayList<>();
        
        try{            
            con=DBUtilities.getConnection();            
            ps=con.prepareStatement(sql);                   
            ResultSet rs=ps.executeQuery();  //select                
         
            
            //TrainersDAOImplementation smdi= new TrainersDAOImplementation();
            
            //Διαβάζω το ResultSet και φτιάχνω Courses.
            while(rs.next()){
                //Για κάθε μία εγγραφή φτιάξε μου ένα αντικείμενο Trainers.
                Students st=new Students(
                        rs.getString("SFirstName"),
                        rs.getString("SLastName"),
                        rs.getDate("SBirthday").toLocalDate(),
                        rs.getInt("STuitionFees"),
                        rs.getInt("SOralMark"),
                        rs.getInt("SWriteMark"),                        
                        rs.getInt("STotalMark"),
                        rs.getString("SCourseTitle")
                );
                
                // Αφού το φτιάξω, πρέπει να το βάλω κάπου. 
                // Τι πρέπε να επιστρέψω? Μία Λίστα.
                
                result.add(st);                
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
    public String getStudentById(int sid) {
         String sql = "SELECT * FROM students" +
                        " WHERE studentid=?";
         
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
    public int FindLastStudentIDToPutItToManyToManyTable() {
        
         String sql = "SELECT MAX(Studentid) FROM schoolmanagement.students";
         
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
    public void insertStudentsCourses(mTm_Students_Courses sc) {
       
         String sql="INSERT INTO zfk_courses_students (studentid,courseid) VALUES (?,?)";        
        //String sql="INSERT INTO test(a2) VALUES (?)";        
        PreparedStatement ps=null;        
        
        try{            
            con=DBUtilities.getConnection();            
            ps=con.prepareStatement(sql);     
            
            ps.setInt(1,sc.getStudentID());
            ps.setInt(2,sc.getCourseID());
            
            
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
    public List<AssignmentsPerCoursePerStudentDTO> fetchAssignmentsPerCoursePerStudent (){
        
         String sql="SELECT students.SLastName, courses.CTitle, assignments.ATitle" +
                    " FROM students, courses, assignments" +
                    " WHERE students.SCourseTitle=courses.CTitle" +
                    " AND assignments.ACourseTitle=courses.CTitle";
         
        // System.out.println(sql);
         
         
        List<AssignmentsPerCoursePerStudentDTO> result=new ArrayList();        
        PreparedStatement ps=null;        
        
        try{            
            con=DBUtilities.getConnection();            
            ps=con.prepareStatement(sql);     
            ResultSet rs=ps.executeQuery();            
            
            while(rs.next()){
                //Για κάθε μία εγγραφή φτιάξε μου ένα αντικείμενο Trainers.
                //DTO
                AssignmentsPerCoursePerStudentDTO temp=new AssignmentsPerCoursePerStudentDTO();
                
                temp.setStudentName(rs.getString(1));
                temp.setCourseTitle(rs.getString(2));
                temp.setAssignmentTitle(rs.getString(3));                
                
                result.add(temp);                
            }
            
            
            //ps.executeUpdate();            
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
        
        
        return result;
    }
    
    
    
    
    
    
    @Override
    public List<StudentsInMoreThanOneCourseDTO> fetchStudentsThatBelongToMoreThanOneCourse(){
        
         String sql2="SELECT students.SLastName,students.SFirstName, COUNT(*)" +
                    " FROM students" +
                    " group by students.SLastName" +
                    " HAVING COUNT(*)>1";
         
        // System.out.println(sql);
         
         
        List<StudentsInMoreThanOneCourseDTO> result2=new ArrayList();        
        PreparedStatement ps2=null;        
        
        try{            
            con=DBUtilities.getConnection();            
            ps2=con.prepareStatement(sql2);     
            ResultSet rs2=ps2.executeQuery();            
            
            while(rs2.next()){
                //Για κάθε μία εγγραφή φτιάξε μου ένα αντικείμενο Trainers.
                //DTO
                StudentsInMoreThanOneCourseDTO temp2=new StudentsInMoreThanOneCourseDTO();
                
                temp2.setStudentLastName(rs2.getString(1));
                temp2.setStudentFirstName(rs2.getString(2));
                temp2.setStudentCourses(rs2.getInt(3));                
                
                result2.add(temp2);                
            }
            
            
            //ps.executeUpdate();            
        }catch(SQLException ex){         
            ex.printStackTrace();
        }finally{
            try {
                ps2.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();                
            }
        }       
        
        
        return result2;
    }
 
    
    
    
    
    
    
    
    
}
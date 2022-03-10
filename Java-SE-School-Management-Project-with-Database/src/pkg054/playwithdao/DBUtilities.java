package pkg054.playwithdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtilities {   

    
     private static final String MYSQLURL="jdbc:mysql://localhost:3306/schoolmanagement?" +
"zeroDateTimeBehavior=CONVERT_TO_NULL" +
"&useUnicode=true" +
"&useJDBCCompliantTimezoneShift=true" +
"&useLegacyDatetimeCode=false" +
"&serverTimezone=UTC" +
"&allowPublicKeyRetrieval=true" +
"&useSSL=false";
    
    
    private static String username="root";
    private static String password="12345678";
    
    
    // Αν δεν την κάνω static για να τρέξω την getConnection() χρειάζομαι ένα object, δηλ:
    //   DBUtilities dbu=new DBUtilities();
    //   dbu.getConnection();
    // Οσα αντικείμενα και να φτιάξω  συμπεριφορά της μεθόδου δεν εξαρτάται από το object, 
    // γιαυτό την κάνω static.
    
    // Επίσης κάνω throws Exception έτσι ώστε αν κάτι δεν πάει καλά το πετάει σε 
    // αυτόν που την κάλεσε. Και θα μπει αυτός που την κάλεσε σε tru, catch.
    public static Connection getConnection() throws SQLException{
        
        Connection con=null;        
        con=DriverManager.getConnection(MYSQLURL, username, password);  
        return con;
        
    }
    
        

    
}
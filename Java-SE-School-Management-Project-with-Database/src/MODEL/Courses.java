package MODEL;

import java.time.LocalDate;
import java.util.ArrayList;

public class Courses {
    
    /* private int courseID;*/
    private String CTitle;
    private String CStream;
    private String CType;    
    private LocalDate CStart_Date;    
    private LocalDate CEnd_Date;    


    
    //Constructor
    public Courses(String CTitle, String CStream, String CType, LocalDate CStart_Date, LocalDate CEnd_Date) {
        this.CTitle = CTitle;
        this.CStream = CStream;
        this.CType = CType;
        this.CStart_Date = CStart_Date;
        this.CEnd_Date = CEnd_Date;
    }

    public Courses(String CTitle) {
        this.CTitle = CTitle;
    }
    
    
    
    
    
    public Courses() {
    }

    

        
    
    //Getters,Setters
    public String getCTitle() {
        return CTitle;
    }

    public void setCTitle(String CTitle) {
        this.CTitle = CTitle;
    }

    public String getCStream() {
        return CStream;
    }

    public void setCStream(String CStream) {
        this.CStream = CStream;
    }

    public String getCType() {
        return CType;
    }

    public void setCType(String CType) {
        this.CType = CType;
    }

    public LocalDate getCStart_Date() {
        return CStart_Date;
    }

    public void setCStart_Date(LocalDate CStart_Date) {
        this.CStart_Date = CStart_Date;
    }

    public LocalDate getCEnd_Date() {
        return CEnd_Date;
    }

    public void setCEnd_Date(LocalDate CEnd_Date) {
        this.CEnd_Date = CEnd_Date;
    }
    
    
    
    
    
    // Was ist das?
    public Courses fetchCB8Courses() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
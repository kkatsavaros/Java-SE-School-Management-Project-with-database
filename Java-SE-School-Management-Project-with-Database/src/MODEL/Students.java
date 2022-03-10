package MODEL;

import java.time.LocalDate;

public class Students {
    
    private String SfirstName;
    private String SLastName;
    private LocalDate SDateOfBirth;
    private int STuitionFees;
    private int SOralMark;
    private int SWriteMark;
    private int STotalMark;
    private String SCourseTitle;
    
    
    //Constructor
    public Students(String SfirstName, String SLastName, LocalDate SDateOfBirth, int STuitionFees, int SOralMark, int SWriteMark, int STotalMark, String SCourseTitle) {
        this.SfirstName = SfirstName;
        this.SLastName = SLastName;
        this.SDateOfBirth = SDateOfBirth;
        this.STuitionFees = STuitionFees;
        this.SOralMark = SOralMark;
        this.SWriteMark = SWriteMark;
        this.STotalMark = STotalMark;
        this.SCourseTitle = SCourseTitle;
    }

    public Students(String SfirstName, String SLastName, LocalDate SDateOfBirth, int STuitionFees, String SCourseTitle) {
        this.SfirstName = SfirstName;
        this.SLastName = SLastName;
        this.SDateOfBirth = SDateOfBirth;
        this.STuitionFees = STuitionFees;
        this.SCourseTitle = SCourseTitle;
    }

    public Students(String SfirstName) {
        this.SfirstName = SfirstName;
    }

    public Students(String SfirstName, String SLastName) {
        this.SfirstName = SfirstName;
        this.SLastName = SLastName;
    }

    public Students(String SfirstName, String SLastName, LocalDate SDateOfBirth) {
        this.SfirstName = SfirstName;
        this.SLastName = SLastName;
        this.SDateOfBirth = SDateOfBirth;
    }
    
    
    
        
    public Students() {
    }
    
    
    
    //Getters,Setters
    public String getSfirstName() {
        return SfirstName;
    }

    public void setSfirstName(String SfirstName) {
        this.SfirstName = SfirstName;
    }

    public String getSLastName() {
        return SLastName;
    }

    public void setSLastName(String SLastName) {
        this.SLastName = SLastName;
    }

    public LocalDate getSDateOfBirth() {
        return SDateOfBirth;
    }

    public void setSDateOfBirth(LocalDate SDateOfBirth) {
        this.SDateOfBirth = SDateOfBirth;
    }

    public int getSTuitionFees() {
        return STuitionFees;
    }

    public void setSTuitionFees(int STuitionFees) {
        this.STuitionFees = STuitionFees;
    }

    public int getSOralMark() {
        return SOralMark;
    }

    public void setSOralMark(int SOralMark) {
        this.SOralMark = SOralMark;
    }

    public int getSWriteMark() {
        return SWriteMark;
    }

    public void setSWriteMark(int SWriteMark) {
        this.SWriteMark = SWriteMark;
    }

    public int getSTotalMark() {
        return STotalMark;
    }

    public void setSTotalMark(int STotalMark) {
        this.STotalMark = STotalMark;
    }

    public String getSCourseTitle() {
        return SCourseTitle;
    }

    public void setSCourseTitle(String SCourseTitle) {
        this.SCourseTitle = SCourseTitle;
    }
    
    
    
    
}

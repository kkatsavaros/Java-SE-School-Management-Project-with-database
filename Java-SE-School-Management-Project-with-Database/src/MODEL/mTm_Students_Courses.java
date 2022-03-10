package MODEL;

public class mTm_Students_Courses {
    
    private int StudentID;
    private int CourseID;
    
    
    //Constructor
    public mTm_Students_Courses(int StudentID, int CourseID) {
        this.StudentID = StudentID;
        this.CourseID = CourseID;
    }

    public mTm_Students_Courses() {
    }
    
    
    //Getters,Setters
    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    
    
    
    
    
    
}

package MODEL;

public class mTm_Assignments_Courses {
    
    private int AssignmentID;
    private int CourseID;
    
    //Constructor

    public mTm_Assignments_Courses(int AssignmentID, int CourseID) {
        this.AssignmentID = AssignmentID;
        this.CourseID = CourseID;
    }

    public mTm_Assignments_Courses() {
    }
    
    
    //Getters, Setters
    public int getAssignmentID() {
        return AssignmentID;
    }

    public void setAssignmentID(int AssignmentID) {
        this.AssignmentID = AssignmentID;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }
    
    
}

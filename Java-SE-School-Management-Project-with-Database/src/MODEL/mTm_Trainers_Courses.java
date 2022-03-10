package MODEL;

public class mTm_Trainers_Courses {
    
    private int TrainerID;
    private int CourseID;
    
    
    //Constructor
    public mTm_Trainers_Courses(int TrainerID, int CourseID) {
        this.TrainerID = TrainerID;
        this.CourseID = CourseID;
    }

    public mTm_Trainers_Courses() {
    }
    
    
    //Getters, Setters
    public int getTrainerID() {
        return TrainerID;
    }

    public void setTrainerID(int TrainerID) {
        this.TrainerID = TrainerID;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }
    
    
}

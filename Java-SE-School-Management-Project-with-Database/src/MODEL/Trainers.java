package MODEL;

public class Trainers {
    
    private String firstName;
    private String lastName;
    private String subject;  // Τι μάθημα κάνει ο καθηγητής.     
    private String TCourseTitle;
    
    //Courses courses;         // Association
    
    
    //Constructor
    public Trainers(String firstName, String lastName, String subject, String TCourseTitle) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
        this.TCourseTitle = TCourseTitle;
    }    

    public Trainers() {
    }
    
    
    
    
    
    //Getters, Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTCourseTitle() {
        return TCourseTitle;
    }

    public void setTCourseTitle(String TCourseTitle) {
        this.TCourseTitle = TCourseTitle;
    }

    
}

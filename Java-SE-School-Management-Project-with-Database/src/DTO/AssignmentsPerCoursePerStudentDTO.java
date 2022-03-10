package DTO;

public class AssignmentsPerCoursePerStudentDTO {
    
    private String studentName;
    private String courseTitle;
    private String assignmentTitle;
    
    
    //Constructo
    public AssignmentsPerCoursePerStudentDTO(String studentName, String courseTitle, String assignmentTitle) {
        this.studentName = studentName;
        this.courseTitle = courseTitle;
        this.assignmentTitle = assignmentTitle;
    }    

    public AssignmentsPerCoursePerStudentDTO() {
    }
    
    
    
    //Getters, Setters
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getAssignmentTitle() {
        return assignmentTitle;
    }

    public void setAssignmentTitle(String assignmentTitle) {
        this.assignmentTitle = assignmentTitle;
    }
    
    
    
    
    
    
    
    
    
    
}

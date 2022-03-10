package DTO;

public class StudentsInMoreThanOneCourseDTO {
    
    private String studentLastName;
    private String studentFirstName;
    private int studentCourses;
    
    
    //Constructors

    public StudentsInMoreThanOneCourseDTO(String studentLastName, String studentFirstName, int studentCourses) {
        this.studentLastName = studentLastName;
        this.studentFirstName = studentFirstName;
        this.studentCourses = studentCourses;
    }    
    

    public StudentsInMoreThanOneCourseDTO() {
    }
    
    
    
    //Getters, Setters
    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public int getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(int studentCourses) {
        this.studentCourses = studentCourses;
    }
    
    
    
}
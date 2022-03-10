package MODEL;

import java.time.LocalDateTime;

public class Assignments {
    
    private String ATitle;
    private String ADescription;
    private LocalDateTime ASubDateTime;
    private String ACourseTitle;
    
    
    //Constructor
    public Assignments(String ATitle, String ADescription, LocalDateTime ASubDateTime, String ACourseTitle) {
        this.ATitle = ATitle;
        this.ADescription = ADescription;
        this.ASubDateTime = ASubDateTime;
        this.ACourseTitle = ACourseTitle;
    }
    
    
    public Assignments() {
    }
    
    
    
    //Getters, Setters
    public String getATitle() {
        return ATitle;
    }

    public void setATitle(String ATitle) {
        this.ATitle = ATitle;
    }

    public String getADescription() {
        return ADescription;
    }

    public void setADescription(String ADescription) {
        this.ADescription = ADescription;
    }

    public LocalDateTime getASubDateTime() {
        return ASubDateTime;
    }

    public void setASubDateTime(LocalDateTime ASubDateTime) {
        this.ASubDateTime = ASubDateTime;
    }

    public String getACourseTitle() {
        return ACourseTitle;
    }

    public void setACourseTitle(String ACourseTitle) {
        this.ACourseTitle = ACourseTitle;
    }
    
    
    
    
}

package dto;

import entities.Course;


/**
 *
 * @author Yones
 */
public class CourseDTO {

    private String courseName;
    private String description;



    public CourseDTO(Course course) {
        this.courseName = course.getCourseName();
        this.description = course.getDescription();
    }

 

 



}

package dto;

import entities.Course;
import java.util.ArrayList;
import java.util.List;

public class CoursesDTO {
    
    List<CourseDTO> all = new ArrayList();

    public CoursesDTO(List<Course> courses) {
        courses.forEach((c) -> {
            all.add(new CourseDTO(c));
        });
    }
      public List<CourseDTO> getAll() {
        return all;
    }

    public void setAll(List<CourseDTO> all) {
        this.all = all;
    }
    
    
    
}
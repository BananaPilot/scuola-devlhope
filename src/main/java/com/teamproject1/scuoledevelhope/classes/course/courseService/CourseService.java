package com.teamproject1.scuoledevelhope.classes.course.courseService;
import com.teamproject1.scuoledevelhope.classes.course.Course;
import com.teamproject1.scuoledevelhope.classes.course.courseDAO.CourseDAO;
import com.teamproject1.scuoledevelhope.types.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.BaseResponseList;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service
public class CourseService {
    @Autowired
    CourseDAO courseDAO;



    public BaseResponseList<Course> findAll(){
        return new BaseResponseList<>(courseDAO.findAll());
    }
    public BaseResponseElement<Course> findById(UUID id){
        Optional<Course> result = courseDAO.findById(id);
        if(result.isEmpty()){
            throw new SQLException("Course was not present");
        }
        return new BaseResponseElement<>(result.get());
    }

    public BaseResponseElement<Course> save(Course course) {
        return new BaseResponseElement<>(courseDAO.save(course));
    }

    public BaseResponseElement<Course> deleteById(UUID id){
        Optional<Course> temp = courseDAO.findById(id);

        if(temp.isEmpty()){
            throw new SQLException("Course was not present");
        }
        courseDAO.deleteById(id);

        return new BaseResponseElement<>(temp.get());
    }
}

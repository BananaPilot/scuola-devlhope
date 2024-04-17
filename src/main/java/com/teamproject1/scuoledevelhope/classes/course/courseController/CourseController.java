package com.teamproject1.scuoledevelhope.classes.course.courseController;

import com.teamproject1.scuoledevelhope.classes.classP.Classes;
import com.teamproject1.scuoledevelhope.classes.classP.classService.ClassService;
import com.teamproject1.scuoledevelhope.classes.course.Course;
import com.teamproject1.scuoledevelhope.classes.course.courseService.CourseService;
import com.teamproject1.scuoledevelhope.types.BaseResponseElement;
import com.teamproject1.scuoledevelhope.types.BaseResponseList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;


    @GetMapping("/get-all")
    public BaseResponseList<Course> findAll(){
        return courseService.findAll();
    }

    @GetMapping("/get-by-id")
    public BaseResponseElement<Course> findById(@RequestParam UUID id){
        return courseService.findById(id);
    }

    @PostMapping("/save")
    public BaseResponseElement<Course> save(@RequestBody Course course){
        return courseService.save(course);
    }

    @DeleteMapping("/delete-by-id")
    public BaseResponseElement<Course> delete(@RequestParam UUID id){
        return courseService.deleteById(id);
    }
}

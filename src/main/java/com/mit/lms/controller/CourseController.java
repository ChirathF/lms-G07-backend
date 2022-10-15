package com.mit.lms.controller;

import com.mit.lms.model.Course;
import com.mit.lms.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/lms/lec")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("course/{lecturerId}")
    public List<Course> viewByLecId(String lecturerId){
        return courseService.viewByLecId (lecturerId);
    }
    @PostMapping("course/add")
    public Course addCourse(@RequestBody Course course){
        return courseService.addCourse (course);
    }
    @GetMapping("course/{courseId}")
    public Optional<Course> viewById(@PathVariable String courseId){
        return courseService.viewByCourseId (courseId);
    }
    @PutMapping("course/update/{courseId}")
    public Course updateCourse(@RequestBody Course course, @PathVariable String courseId){
        return courseService.updateCourse (course, courseId);
    }
    @DeleteMapping("course/delete/{courseId}")
    public String deleteCourse(@PathVariable String courseId){
        return courseService.deleteCourseById (courseId);
    }

}

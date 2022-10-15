package com.mit.lms.service;


import com.mit.lms.model.Course;
import com.mit.lms.model.User;
import com.mit.lms.repository.CourseRepository;
import com.mit.lms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;


    public List<Course> viewByLecId(String lecturerId){
        return courseRepository.findByLecturerId (lecturerId);
    }

    public Course addCourse(@RequestBody Course course){
        return courseRepository.save (course);
    }

    public Optional<Course> viewByCourseId(String courseId){
        return courseRepository.findById (courseId);
    }
    public Course updateCourse(Course course, String courseId){
        course.setCourseId (courseId);
        return courseRepository.save (course);
    }
    public String deleteCourseById(String courseId){
        courseRepository.deleteById (courseId);
        return "Successfully Deleted";
    }

}

package com.mit.lms.controller;

import com.mit.lms.model.Enrollment;
import com.mit.lms.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.rmi.AlreadyBoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {

    @Autowired
    EnrollmentService enrollmentService;

    @PostMapping("/add")
    public Enrollment addEnrollment(@RequestBody Enrollment enrollment) throws AlreadyBoundException {
        return enrollmentService.addEnrollment(enrollment);
    }

    @PostMapping("/delete")
    public String deleteEnrollment(@RequestBody Enrollment enrollment){
        enrollmentService.deleteEnrollment(enrollment);
        return "Successfully Deleted";
    }

    @GetMapping("/{username}")
    public Optional<List<Enrollment>> getAllCoursesByStudent(@PathVariable String username){
        return enrollmentService.viewAllCourses(username);
    }

    @GetMapping("/{id}")
    public Optional<List<Enrollment>> getAllCoursesByStudent(@PathVariable int id){
        return enrollmentService.viewAllStudents(id);
    }
}

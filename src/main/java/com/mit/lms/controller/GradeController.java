package com.mit.lms.controller;

import com.mit.lms.model.Grade;
import com.mit.lms.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.rmi.AlreadyBoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/grade/")
public class GradeController {

    @Autowired
    GradeService gradeService;

    @PostMapping("/add")
    public Grade addGrade(@RequestBody Grade grade) throws AlreadyBoundException {
        return gradeService.addGrade(grade);
    }

    @PostMapping("/delete")
    public String deleteGrade(@RequestBody Grade grade){
        gradeService.deleteGrade(grade);
        return "Successfully Deleted";
    }

    @GetMapping("/{username}")
    public Optional<List<Grade>> getAllCoursesByStudent(@PathVariable String username){
        return gradeService.viewAllCourses(username);
    }

    @GetMapping("/{id}")
    public Optional<List<Grade>> getAllCoursesByStudent(@PathVariable int id){
        return gradeService.viewAllStudents(id);
    }

    @PutMapping("/edit")
    public Grade updateGrade(@Valid @RequestBody Grade grade){
        return gradeService.updateGrade(grade);
    }
}

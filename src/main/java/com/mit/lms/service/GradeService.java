package com.mit.lms.service;

import com.mit.lms.model.Grade;
import com.mit.lms.repository.GradeRepository;
import org.springframework.stereotype.Service;

import java.rmi.AlreadyBoundException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class GradeService {

    private final GradeRepository gradeRepository;

    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }
    public Grade addGrade(Grade model) throws AlreadyBoundException {
        if(gradeRepository.existsByUsernameAndCourseId(model.getUsername(), model.getCourseId())) throw new AlreadyBoundException("Grade Already exists!");

        return gradeRepository.save(model);
    }

    public void deleteGrade(Grade grade){
        gradeRepository.deleteByUsernameAndCourseId(grade.getUsername(),grade.getCourseId());
    }

    public Optional<List<Grade>> viewAllCourses(String username){
        return gradeRepository.findAllByUsername(username);
    }

    public Optional<List<Grade>> viewAllStudents(int courseId){
        return gradeRepository.findAllByCourseId(courseId);
    }

    public Grade updateGrade(Grade grade){
        if(gradeRepository.existsByUsernameAndCourseId(grade.getUsername(), grade.getCourseId())) throw new NoSuchElementException("No Grade found for " + grade.getUsername()+" and " + grade.getCourseId());
        Grade entity = gradeRepository.findByUsernameAndCourseId(grade.getUsername(), grade.getCourseId());
        entity.setGrade(grade.getGrade());
        return gradeRepository.save(entity);
    }
}

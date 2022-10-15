package com.mit.lms.service;

import com.mit.lms.model.Enrollment;
import com.mit.lms.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.AlreadyBoundException;
import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {

    @Autowired
    EnrollmentRepository enrollmentRepository;

    public Enrollment addEnrollment(Enrollment model) throws AlreadyBoundException {
        if(enrollmentRepository.existsByUsernameAndCourseId(model.getUsername(), model.getCourseId())) throw new AlreadyBoundException("Enrollment Already exists!");

        return enrollmentRepository.save(model);
    }

    public void deleteEnrollment(Enrollment enrollment){
        enrollmentRepository.deleteByUsernameAndCourseId(enrollment.getUsername(),enrollment.getCourseId());
    }

    public Optional<List<Enrollment>> viewAllCourses(String username){
        return enrollmentRepository.findAllByUsername(username);
    }

    public Optional<List<Enrollment>> viewAllStudents(int courseId){
        return enrollmentRepository.findAllByCourseId(courseId);
    }
}

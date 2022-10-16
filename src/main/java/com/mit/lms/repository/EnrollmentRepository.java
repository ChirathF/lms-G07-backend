package com.mit.lms.repository;

import com.mit.lms.model.Enrollment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnrollmentRepository extends MongoRepository<Enrollment, String> {

    boolean existsByUsernameAndCourseId(String userName, int courseId);

    Optional<List<Enrollment>> findAllByUsername(String userName);

    Optional<List<Enrollment>> findAllByCourseId(int courseId);

    void deleteByUsernameAndCourseId(String userName, int courseId);
}

package com.mit.lms.repository;

import com.mit.lms.model.Grade;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GradeRepository extends MongoRepository<Grade,String> {

    boolean existsByUsernameAndCourseId(String username, int id);

    Optional<List<Grade>> findAllByUsername(String username);

    Optional<List<Grade>> findAllByCourseId(int id);

    void deleteByUsernameAndCourseId(String username, int id);

    Grade findByUsernameAndCourseId(String username, int id);


}

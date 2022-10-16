package com.mit.lms.repository;

import com.mit.lms.model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CourseRepository extends MongoRepository<Course, String> {

    @Query("{lecturerId:'?0'}")
    List<Course> findByLecturerId(String lecturerId);
}

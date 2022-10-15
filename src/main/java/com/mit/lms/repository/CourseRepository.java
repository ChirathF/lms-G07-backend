package com.mit.lms.repository;

import com.mit.lms.model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CourseRepository extends MongoRepository<Course, String> {

    List<Course> findByLecturerId(String lecturerId);
}

package com.mit.lms.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString

@Document(collection= "course")
public class Course {
    @Id
    private String courseId;
    private int credits;
    private String lecturerId;
    private String title;
    private String description;

    public Course() {
    }

    public Course(String courseId, int credits, String lecturerId, String title, String description) {
        this.courseId = courseId;
        this.credits = credits;
        this.lecturerId = lecturerId;
        this.title = title;
        this.description = description;
    }
}

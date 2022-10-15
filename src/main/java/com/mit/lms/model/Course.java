package com.mit.lms.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection= "course")
public class Course {
    @Id
    private String courseId;
    private double credits;
    private String lecturerId;
    private String title;
    private String description;
}

package com.mit.lms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "grade")
public class Grade {

    private String username;
    private int courseId;

    @Pattern(regexp = "^[A-D]$", message = "Only A,B,C & D are allowed")
    private String grade;
}

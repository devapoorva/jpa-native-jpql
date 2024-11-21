package com.jpa.jpql.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Apoorva Raj
 * @email apoorvaraj47@gmail.com
 * @linkedin devapoorva
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentCourseDto {
    private Long studentId;
    private String studentName;
    private String courseName;
}

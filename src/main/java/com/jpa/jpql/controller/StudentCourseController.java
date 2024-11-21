package com.jpa.jpql.controller;

import com.jpa.jpql.service.StudentCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Apoorva Raj
 * @email apoorvaraj47@gmail.com
 * @linkedin devapoorva
 */
@RestController
@RequestMapping(path = "student-course")
@RequiredArgsConstructor
public class StudentCourseController {
    private final StudentCourseService service;

    @GetMapping
    public ResponseEntity<Object> index(
            @RequestParam(name = "page",defaultValue = "1",required = false) int page,
            @RequestParam(name = "size",defaultValue = "10",required = false) int size
    ){
        return ResponseEntity.ok(service.studentCourses(page-1,size));
    }
}

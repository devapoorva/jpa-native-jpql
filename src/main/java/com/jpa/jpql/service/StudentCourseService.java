package com.jpa.jpql.service;

import com.jpa.jpql.dto.StudentCourseProjection;
import com.jpa.jpql.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Apoorva Raj
 * @email apoorvaraj47@gmail.com
 * @linkedin devapoorva
 */
@Service
@RequiredArgsConstructor
public class StudentCourseService {
    private final StudentRepository studentRepository;

    public Page<StudentCourseProjection> studentCourses(int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        return studentRepository.findStudentCourseDetailsNative(pageable);
    }
}

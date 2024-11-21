package com.jpa.jpql.repository;

import com.jpa.jpql.dto.StudentCourseDto;
import com.jpa.jpql.dto.StudentCourseProjection;
import com.jpa.jpql.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Apoorva Raj
 * @email apoorvaraj47@gmail.com
 * @linkedin devapoorva
 */
public interface StudentRepository extends JpaRepository<Student,Long>, JpaSpecificationExecutor<Student> {
    @Query("SELECT new com.jpa.jpql.dto.StudentCourseDto(s.id, s.name, c.name) " +
            "FROM Student s JOIN s.courses c")
    Page<StudentCourseDto> findStudentCourseDetails(Pageable pageable);

    @Query(
            value = "SELECT s.id AS studentId, s.name AS studentName, c.name AS courseName " +
                    "FROM students s " +
                    "JOIN student_courses sc ON s.id = sc.student_id " +
                    "JOIN courses c ON sc.course_id = c.id",
            countQuery = "SELECT COUNT(*) FROM students s " +
                    "JOIN student_courses sc ON s.id = sc.student_id " +
                    "JOIN courses c ON sc.course_id = c.id",
            nativeQuery = true
    )
    Page<StudentCourseProjection> findStudentCourseDetailsNative(Pageable pageable);

}

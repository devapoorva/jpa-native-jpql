package com.jpa.jpql.repository;

import com.jpa.jpql.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Apoorva Raj
 * @email apoorvaraj47@gmail.com
 * @linkedin devapoorva
 */
@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    Course findByName(String name);
}

package com.jpa.jpql.initializer;

import com.jpa.jpql.entities.Course;
import com.jpa.jpql.entities.Student;
import com.jpa.jpql.repository.CourseRepository;
import com.jpa.jpql.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;
import java.util.Set;

/**
 * @author Apoorva Raj
 * @email apoorvaraj47@gmail.com
 * @linkedin devapoorva
 */
@Component
public class DatabaseInitializer implements CommandLineRunner {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void run(String... args) throws Exception {
        if (courseRepository.count() == 0) {
            List<Course> defaultCourses = List.of(
                    Course.of().name("Mathematics").createdAt(Instant.now()).updatedAt(Instant.now()).build(),
                    Course.of().name("Science").createdAt(Instant.now()).updatedAt(Instant.now()).build(),
                    Course.of().name("History").createdAt(Instant.now()).updatedAt(Instant.now()).build()
            );
            courseRepository.saveAll(defaultCourses);
        }

        if (studentRepository.count() == 0) {
            Course math = courseRepository.findByName("Mathematics");
            Course science = courseRepository.findByName("Science");

            List<Student> defaultStudents = List.of(
                    Student.of().name("John Doe").courses(Set.of(math,science)).createdAt(Instant.now()).updatedAt(Instant.now()).build(),
                    Student.of().name("Jane Smith").courses(Set.of(math)).createdAt(Instant.now()).updatedAt(Instant.now()).build()
            );
            studentRepository.saveAll(defaultStudents);
        }
    }
}

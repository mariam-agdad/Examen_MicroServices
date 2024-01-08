package com.example.course;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<com.example.course.Course, Integer> {
}

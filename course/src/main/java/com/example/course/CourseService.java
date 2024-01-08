package com.example.course;

import com.example.course.client.StudentClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository repository;
    private StudentClient client;

    public void saveCourse(Course course){
        repository.save(course);
    }

    public List<Course> findAllCourses(){
        return repository.findAll();
    }



    public FullCourseResponse findCoursesWithStudents(Integer courseId) {
        var course = repository.findById(courseId)
                .orElse(
                        com.example.course.Course.builder()
                                .name("NOT_FOUND")
                                .build()
                );
        var students = client.findAllStudentsByCourse(courseId);
        return FullCourseResponse.builder()
                .name(course.getName())
                .students(students)
                .build();
    }
}

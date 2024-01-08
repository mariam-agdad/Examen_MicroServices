package com.example.course;

import com.example.course.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(
            @RequestBody com.example.course.Course course
    ){
        service.saveCourse(course);
    }

    @GetMapping
    public ResponseEntity<List<com.example.course.Course>> findAllCourses(){
        return ResponseEntity.ok(service.findAllCourses());
    }

    @GetMapping("/with-students/{course-id}")
    public ResponseEntity<FullCourseResponse> findAllCourses(
            @PathVariable("course-id") Integer courseId
    ){
        return ResponseEntity.ok(service.findCoursesWithStudents(courseId));
    }


}

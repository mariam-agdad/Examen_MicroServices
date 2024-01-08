package com.example.course;

import lombok.*;
import lombok.*;


import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullCourseResponse {

        private String name;
        List<Student> students;
}



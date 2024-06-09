package az.task.EmployeeManagement.controllers;

import az.task.EmployeeManagement.models.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/employee")
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(List.of(
                Student.builder().name("Jack").surname("Doe").build(),
                Student.builder().name("Jack2").surname("Doe2").build(),
                Student.builder().name("Jack3").surname("Doe3").build()
        ));
    }
}

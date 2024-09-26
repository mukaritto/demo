package com.example.demo.web.rest;

import com.example.demo.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentResource {

    @PostMapping("/students")
    public ResponseEntity create(@RequestBody Student student){
        return ResponseEntity.ok(student);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity updateSecond(@RequestBody Student student, @PathVariable Long id){
        student.setId(id);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getOne(@PathVariable Long id){
        Student student = new Student();
        student.setId(id);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAll(@RequestParam Long id,
                                                @RequestParam String name,
                                                @RequestParam String lastName,
                                                @RequestParam int age){
        List<Student> students = new ArrayList<>();
        students.add(new Student(123, "name", "lastName", 17));
        students.add(new Student(id, name, lastName, age));
        return ResponseEntity.ok(students);
    }
}

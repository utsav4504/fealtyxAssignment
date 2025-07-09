package com.fealtyx.fealtyx.controller;

import com.fealtyx.fealtyx.model.Student;
import com.fealtyx.fealtyx.service.StudentService;
import com.fealtyx.fealtyx.service.OllamaService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    private final OllamaService ollamaService;

    public StudentController(StudentService studentService, OllamaService ollamaService) {
        this.studentService = studentService;
        this.ollamaService = ollamaService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
        return ResponseEntity.ok(studentService.createStudent(student));
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable int id, @Valid @RequestBody Student student) {
        return studentService.updateStudent(id, student)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
        if (studentService.deleteStudent(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/summary")
    public ResponseEntity<String> getStudentSummary(@PathVariable int id) {
        return studentService.getStudentById(id)
                .map(student -> ResponseEntity.ok(ollamaService.getSummary(student)))
                .orElse(ResponseEntity.notFound().build());
    }
}

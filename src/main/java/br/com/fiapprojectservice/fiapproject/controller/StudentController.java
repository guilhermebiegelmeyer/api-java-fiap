package br.com.fiapprojectservice.fiapproject.controller;

import br.com.fiapprojectservice.fiapproject.application.StudentApplication;
import br.com.fiapprojectservice.fiapproject.application.dto.StudentDTO;
import br.com.fiapprojectservice.fiapproject.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentApplication studentApplication;

    public StudentController(@Autowired StudentApplication studentApplication) {
        this.studentApplication = studentApplication;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateStudent(@PathVariable Long id, @RequestBody StudentDTO studentDTO) throws Exception {
        studentApplication.updateStudent(id, studentDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody StudentDTO studentDTO) throws Exception {
        studentApplication.createStudent(studentDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<List<Student>> getLista() {
        return ResponseEntity.ok(studentApplication.getStudents());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        try {
            studentApplication.deleteStudent(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
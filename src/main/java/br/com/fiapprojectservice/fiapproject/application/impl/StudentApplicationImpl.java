package br.com.fiapprojectservice.fiapproject.application.impl;

import br.com.fiapprojectservice.fiapproject.application.StudentApplication;
import br.com.fiapprojectservice.fiapproject.application.dto.StudentDTO;
import br.com.fiapprojectservice.fiapproject.model.Student;
import br.com.fiapprojectservice.fiapproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class StudentApplicationImpl implements StudentApplication {

    private StudentService studentService;

    public StudentApplicationImpl(@Autowired StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void updateStudent(Long id, StudentDTO studentDTO) throws Exception {
        Student student = studentService.getStudentById(id);

        if (student == null) {
            throw new Exception("Estudante não encontrado");
        }

        student.setName(studentDTO.getName());
        studentService.saveStudent(student);
    }

    @Override
    public void createStudent(StudentDTO studentDTO) throws Exception {
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setName(studentDTO.getName());

        this.studentService.saveStudent(student);

    }

    @Override
    public void deleteStudent(Long id) throws Exception {
        Student student = studentService.getStudentById(id);

        if (student == null) {
            throw new Exception("Estudante não encontrado");
        }

        // Deleta o estudante do banco de dados
        studentService.deleteStudent(student);
    }

    @Override
    public List<Student> getStudents() {
        return studentService.getStudentList();
    }
}
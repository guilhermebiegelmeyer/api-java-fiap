package br.com.fiapprojectservice.fiapproject.application.impl;

import br.com.fiapprojectservice.fiapproject.application.StudentApplication;
import br.com.fiapprojectservice.fiapproject.application.dto.StudentDTO;
import br.com.fiapprojectservice.fiapproject.model.Student;
import br.com.fiapprojectservice.fiapproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

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
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date birthDate = dateFormat.parse(studentDTO.getBirth_date());
        student.setBirth_date(birthDate);

        studentService.saveStudent(student);
    }

    @Override
    public void createStudent(StudentDTO studentDTO) throws Exception {
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setName(studentDTO.getName());

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date birthDate = dateFormat.parse(studentDTO.getBirth_date());
        student.setBirth_date(birthDate);

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
    public List<StudentDTO> getStudents() {
        List<Student> students = studentService.getStudentList();
        List<StudentDTO> studentDTOs = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        for (Student student : students) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setId(student.getId());
            studentDTO.setName(student.getName());
            
            String birthDateStr = dateFormat.format(student.getBirth_date());
            studentDTO.setBirth_date(birthDateStr);

            studentDTOs.add(studentDTO);
        }

        return studentDTOs;
    }
}
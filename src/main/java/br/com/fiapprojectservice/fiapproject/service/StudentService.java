package br.com.fiapprojectservice.fiapproject.service;

import br.com.fiapprojectservice.fiapproject.model.Student;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface StudentService {

    void saveStudent(Student student) throws Exception;
    void deleteStudent(Student student);
    Student getStudentById(Long id) throws Exception;
    List<Student> getStudentList();
}
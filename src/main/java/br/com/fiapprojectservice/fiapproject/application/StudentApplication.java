package br.com.fiapprojectservice.fiapproject.application;

import br.com.fiapprojectservice.fiapproject.application.dto.StudentDTO;
import java.util.List;

public interface StudentApplication {
    void createStudent(StudentDTO studentDTO) throws Exception;
    void updateStudent(Long id, StudentDTO studentDTO) throws Exception;
    void deleteStudent(Long id) throws Exception;
    List<StudentDTO> getStudents();
}
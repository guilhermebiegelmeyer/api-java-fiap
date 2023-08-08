package br.com.fiapprojectservice.fiapproject.application.dto;

import lombok.Data;

@Data
public class StudentDTO {
    private Long id;
    private String name;
    private String birth_date;
}
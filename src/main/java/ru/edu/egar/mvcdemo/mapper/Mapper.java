package ru.edu.egar.mvcdemo.mapper;

import ru.edu.egar.mvcdemo.dto.DtoStudent;
import ru.edu.egar.mvcdemo.entity.Student;

public class Mapper {
    public static Student getStudent(Student student, DtoStudent dtoStudent) {
        student.setAddress(dtoStudent.getAddress());
        student.setAge(dtoStudent.getAge());
        student.setEmail(dtoStudent.getEmail());
        student.setPhone(dtoStudent.getPhone());
        student.setPatronymic(dtoStudent.getPatronymic());
        student.setFirstName(dtoStudent.getFirstName());
        student.setLastName(dtoStudent.getLastName());
        return student;
    }

    public static DtoStudent getDtoStudent(Student student) {
        return DtoStudent.builder()
                .address(student.getAddress())
                .age(student.getAge())
                .email(student.getEmail())
                .phone(student.getPhone())
                .patronymic(student.getPatronymic())
                .firstName(student.getFirstName())
                .lastName(student.getLastName()).build();
    }
}

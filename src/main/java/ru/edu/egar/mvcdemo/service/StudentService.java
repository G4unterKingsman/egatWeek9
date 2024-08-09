package ru.edu.egar.mvcdemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.edu.egar.mvcdemo.dto.DtoStudent;
import ru.edu.egar.mvcdemo.entity.Student;
import ru.edu.egar.mvcdemo.mapper.Mapper;
import ru.edu.egar.mvcdemo.repo.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repository;

    public void saveStudent(DtoStudent dtoStudent) {

        Student student = Mapper.getStudent(new Student(),dtoStudent);
        repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }


    public Student findById(Long id){
        return repository.findById(id).orElseThrow();
    }


    public void editStudent(Student student, DtoStudent dtoStudent){
        repository.save(Mapper.getStudent(student, dtoStudent));
    }
}

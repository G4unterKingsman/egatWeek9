package ru.edu.egar.mvcdemo.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.edu.egar.mvcdemo.dto.DtoStudent;
import ru.edu.egar.mvcdemo.entity.Student;
import ru.edu.egar.mvcdemo.mapper.Mapper;
import ru.edu.egar.mvcdemo.service.StudentService;

@Controller
@RequiredArgsConstructor
public class StudentController {
    private final StudentService service;

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("students", service.getAllStudents());
        return "index";
    }

    @GetMapping("/add_student")
    public String getAddStudentForm(Model model) {
        model.addAttribute("student", new DtoStudent());
        return "add_student";
    }

    @PostMapping("/add_student")
    public String createStudent(@Valid @ModelAttribute DtoStudent dtoStudent, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add_student";
        }

        service.saveStudent(dtoStudent);
        return "redirect:/";
    }

    @GetMapping("/{id}/update")
    public String updateStudentForm(@PathVariable(value = "id") Long id, Model model) {
        Student student = service.findById(id);
        model.addAttribute("student", student);
        DtoStudent dtoStudent = Mapper.getDtoStudent(student);
        model.addAttribute("dtoStudent", dtoStudent);
        return "update";
    }



    @PostMapping("/{id}/update")
    public String updateStudent(@Valid @ModelAttribute DtoStudent dtoStudent, BindingResult bindingResult,
                                @PathVariable(value = "id") Long id, Model model){
        Student student = service.findById(id);
        model.addAttribute("student",student);
        if (bindingResult.hasErrors()) {
            return "update";
        }
        service.editStudent(student, dtoStudent);
        return "redirect:/";
    }
}

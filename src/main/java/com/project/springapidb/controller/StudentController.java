package com.project.springapidb.controller;

import com.project.springapidb.component.Student;
import com.project.springapidb.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/student")
public class StudentController {

    @Autowired
    private StudentRepo studentRepo;

    // add one student
    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return studentRepo.save(student);
    }

    // add more student
    @PostMapping("/batch")
    public List<Student>addStudents(@RequestBody List<Student> students){
        return studentRepo.saveAll(students);
    }
    // get all Students
    @GetMapping
    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }

    // get one student by Id
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User no found id: " + id));
    }

    // update Student
    @PutMapping("{id}")
    public Student updateStudent(@PathVariable Long id , @RequestBody Student student){
        Student exitingStudent = studentRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User no found id: " + id));
        exitingStudent.setName(student.getName());
        exitingStudent.setFacult(student.getFacult());
        exitingStudent.setSpecialization(student.getSpecialization());

        return studentRepo.save(exitingStudent);
    }

    // Delete Student func
    public void deleteStudent(@PathVariable Long id){
        Student existingStudent = studentRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
        studentRepo.delete(existingStudent);
    }


}

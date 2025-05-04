package com.repositorio.repositorioWeb.service;

import com.repositorio.repositorioWeb.model.Student;
import com.repositorio.repositorioWeb.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long idStudent) {
        return studentRepository.findById(idStudent)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with id: " + idStudent));
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long idStudent, Student updatedStudent) {
        Student student = getStudentById(idStudent);

        student.setDateOfBirth(updatedStudent.getDateOfBirth());
        student.setGradeLevel(updatedStudent.getGradeLevel());
        student.setUser(updatedStudent.getUser());
        student.setStudentCourses(updatedStudent.getStudentCourses());

        return studentRepository.save(student);
    }

    public void deleteStudent(Long idStudent) {
        if (!studentRepository.existsById(idStudent)) {
            throw new EntityNotFoundException("Student not found with id: " + idStudent);
        }
        studentRepository.deleteById(idStudent);
    }
}
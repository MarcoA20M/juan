package com.repositorio.repositorioWeb.service;

import com.repositorio.repositorioWeb.model.Teacher;
import com.repositorio.repositorioWeb.repository.TeacherRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(Long idTeacher) {
        return teacherRepository.findById(idTeacher)
                .orElseThrow(() -> new EntityNotFoundException("Teacher not found with id: " + idTeacher));
    }

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(Long idTeacher, Teacher updatedTeacher) {
        Teacher teacher = getTeacherById(idTeacher);

        teacher.setUser(updatedTeacher.getUser());
        teacher.setSpecialization(updatedTeacher.getSpecialization());

        return teacherRepository.save(teacher);
    }

    public void deleteTeacher(Long idTeacher) {
        if (!teacherRepository.existsById(idTeacher)) {
            throw new EntityNotFoundException("Teacher not found with id: " + idTeacher);
        }
        teacherRepository.deleteById(idTeacher);
    }
}

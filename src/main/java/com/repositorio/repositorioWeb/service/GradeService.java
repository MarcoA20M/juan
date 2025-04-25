package com.repositorio.repositorioWeb.service;

import com.repositorio.repositorioWeb.model.Grade;
import com.repositorio.repositorioWeb.repository.GradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {
    private final GradeRepository gradeRepository;

    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    public Optional<Grade> getGradeById(Long id) {
        return gradeRepository.findById(id);
    }

    public Grade createGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    public Optional<Grade> updateGrade(Long id, Grade gradeDetails) {
        return gradeRepository.findById(id).map(grade -> {
            grade.setScore(gradeDetails.getScore());
            grade.setFeedback(gradeDetails.getFeedback());
            return gradeRepository.save(grade);
        });
    }

    public boolean deleteGrade(Long id) {
        if (gradeRepository.existsById(id)) {
            gradeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
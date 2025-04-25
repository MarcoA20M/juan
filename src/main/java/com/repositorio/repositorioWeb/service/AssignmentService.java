package com.repositorio.repositorioWeb.service;

import com.repositorio.repositorioWeb.model.Assignment;
import com.repositorio.repositorioWeb.repository.AssignmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {
    private final AssignmentRepository assignmentRepository;

    public AssignmentService(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    public Optional<Assignment> getAssignmentById(Long id) {
        return assignmentRepository.findById(id);
    }

    public Assignment createAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public Optional<Assignment> updateAssignment(Long id, Assignment assignmentDetails) {
        return assignmentRepository.findById(id).map(assignment -> {
            assignment.setTitle(assignmentDetails.getTitle());
            assignment.setDescription(assignmentDetails.getDescription());
            assignment.setDueDate(assignmentDetails.getDueDate());
            return assignmentRepository.save(assignment);
        });
    }

    public boolean deleteAssignment(Long id) {
        if (assignmentRepository.existsById(id)) {
            assignmentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
package com.repositorio.repositorioWeb.service;

import com.repositorio.repositorioWeb.model.Submission;
import com.repositorio.repositorioWeb.repository.SubmissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubmissionService {
    private final SubmissionRepository submissionRepository;

    public SubmissionService(SubmissionRepository submissionRepository) {
        this.submissionRepository = submissionRepository;
    }

    public List<Submission> getAllSubmissions() {
        return submissionRepository.findAll();
    }

    public Optional<Submission> getSubmissionById(Long id) {
        return submissionRepository.findById(id);
    }

    public Submission createSubmission(Submission submission) {
        return submissionRepository.save(submission);
    }

    public Optional<Submission> updateSubmission(Long id, Submission submissionDetails) {
        return submissionRepository.findById(id).map(submission -> {
            submission.setSubmissionDate(submissionDetails.getSubmissionDate());
            submission.setFileUrl(submissionDetails.getFileUrl());
            return submissionRepository.save(submission);
        });
    }

    public boolean deleteSubmission(Long id) {
        if (submissionRepository.existsById(id)) {
            submissionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
package com.repositorio.repositorioWeb.service;

import com.repositorio.repositorioWeb.model.LearningMaterial;
import com.repositorio.repositorioWeb.repository.LearningMaterialRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LearningMaterialService {
    private final LearningMaterialRepository learningMaterialRepository;

    public LearningMaterialService(LearningMaterialRepository learningMaterialRepository) {
        this.learningMaterialRepository = learningMaterialRepository;
    }

    public List<LearningMaterial> getAllLearningMaterials() {
        return learningMaterialRepository.findAll();
    }

    public Optional<LearningMaterial> getLearningMaterialById(Long id) {
        return learningMaterialRepository.findById(id);
    }

    public LearningMaterial createLearningMaterial(LearningMaterial learningMaterial) {
        return learningMaterialRepository.save(learningMaterial);
    }

    public Optional<LearningMaterial> updateLearningMaterial(Long id, LearningMaterial learningMaterialDetails) {
        return learningMaterialRepository.findById(id).map(learningMaterial -> {
            learningMaterial.setName(learningMaterialDetails.getName());
            learningMaterial.setFileUrl(learningMaterialDetails.getFileUrl());
            return learningMaterialRepository.save(learningMaterial);
        });
    }

    public boolean deleteLearningMaterial(Long id) {
        if (learningMaterialRepository.existsById(id)) {
            learningMaterialRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
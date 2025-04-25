package com.repositorio.repositorioWeb.service;

import com.repositorio.repositorioWeb.model.Topic;
import com.repositorio.repositorioWeb.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    private final TopicRepository topicRepository;

    @Autowired
    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    // Crear un nuevo Tema
    public Topic createTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    // Obtener todos los temas
    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    // Obtener un tema por su ID
    public Optional<Topic> getTopicById(Long id) {
        return topicRepository.findById(id);
    }

    // Actualizar un tema
    public Topic updateTopic(Long id, Topic topicDetails) {
        if (topicRepository.existsById(id)) {
            topicDetails.setIdTopic(id);
            return topicRepository.save(topicDetails);
        }
        return null;  // O manejarlo con excepción si no se encuentra
    }

    // Eliminar un tema
    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }
}

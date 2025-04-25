package com.repositorio.repositorioWeb.controller;

import com.repositorio.repositorioWeb.model.Topic;
import com.repositorio.repositorioWeb.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/topics")
public class TopicController {

    private final TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    // Crear un nuevo Tema
    @PostMapping
    public ResponseEntity<Topic> createTopic(@RequestBody Topic topic) {
        Topic createdTopic = topicService.createTopic(topic);
        return new ResponseEntity<>(createdTopic, HttpStatus.CREATED);
    }

    // Obtener todos los temas
    @GetMapping
    public ResponseEntity<List<Topic>> getAllTopics() {
        List<Topic> topics = topicService.getAllTopics();
        return new ResponseEntity<>(topics, HttpStatus.OK);
    }

    // Obtener un tema por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Topic> getTopicById(@PathVariable Long id) {
        Optional<Topic> topic = topicService.getTopicById(id);
        return topic.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Actualizar un tema
    @PutMapping("/{id}")
    public ResponseEntity<Topic> updateTopic(@PathVariable Long id, @RequestBody Topic topicDetails) {
        Topic updatedTopic = topicService.updateTopic(id, topicDetails);
        return updatedTopic != null ? ResponseEntity.ok(updatedTopic) : ResponseEntity.notFound().build();
    }

    // Eliminar un tema
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
        return ResponseEntity.noContent().build();
    }
}

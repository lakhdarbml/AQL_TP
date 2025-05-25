package org.example.tp3;


import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task saveTask(Task task) {
        return repository.save(task);
    }

    public Optional<Task> findTaskById(Long id) {
        return repository.findById(id);
    }

    public void deleteTaskById(Long id) {
        repository.deleteById(id);
    }
}

package com.app.web.task_manager.task;

import com.app.web.task_manager.task.model.TaskCreate;
import com.app.web.task_manager.task.model.TaskUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskMapper taskMapper;
    private final TaskRepository taskRepository;

    public UUID deleteByUniqueId(String uniqueId) {
        UUID uuid = UUID.fromString(uniqueId);

        Task task = taskRepository.findByUniqueId(uuid).orElseThrow(TaskNotFoundException::new);

        taskRepository.delete(task);

        return uuid;
    }

    public UUID addNewTask(TaskCreate taskCreate) {
        Task task = taskMapper.toTask(taskCreate);

        return taskRepository.save(task).getUniqueId();
    }

    public UUID updateDoneOfTaskByUniqueId(TaskUpdate taskUpdate) {
        UUID uuid = taskUpdate.getUniqueId();

        Task task = taskRepository.findByUniqueId(uuid).orElseThrow(TaskNotFoundException::new);
        task.setDone(taskUpdate.isDone());
        taskRepository.save(task);

        return uuid;
    }

    public List<Task> getLatestTasks() {
        return taskRepository.findAll();
    }
}

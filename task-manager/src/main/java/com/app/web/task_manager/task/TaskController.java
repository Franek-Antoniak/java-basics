package com.app.web.task_manager.task;

import com.app.web.task_manager.free_marker.FreeMarkerService;
import com.app.web.task_manager.task.model.TaskCreate;
import com.app.web.task_manager.task.model.TaskDelete;
import com.app.web.task_manager.task.model.TaskRead;
import com.app.web.task_manager.task.model.TaskUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final FreeMarkerService freeMarkerService;

    @PostMapping(value = "/api/task/new")
    public ResponseEntity<String> addNewTask(@RequestBody TaskCreate taskCreate) {
        return ResponseEntity.ok("{" + "\"id\" : \"" + taskService.addNewTask(taskCreate) + "\"}");
    }

    @DeleteMapping(value = "/api/task/delete")
    public ResponseEntity<UUID> deleteTask(@RequestBody TaskDelete taskDelete) {
        return ResponseEntity.ok(taskService.deleteByUniqueId(taskDelete));
    }

    @PatchMapping(value = "/api/task/update")
    public ResponseEntity<UUID> updateStateOfTask(@RequestBody TaskUpdate taskUpdate) {
        return ResponseEntity.ok(taskService.updateDoneOfTaskByUniqueId(taskUpdate));
    }

    @GetMapping(value = "/api/task/get/task", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> getTaskByUUID(@RequestBody TaskRead taskRead) {
        return ResponseEntity.ok(taskService.getTaskByUUID(taskRead));
    }

    @GetMapping(value = "/home")
    public ResponseEntity<String> getLatestWeb() {
        return freeMarkerService.getResponseEntityHTML("TasksView.ftl", "listOfTasks", taskService.getLatestTasks());
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(TaskNotFoundException.class)
    public void onTaskNotFound() {

    }

}


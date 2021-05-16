package com.app.web.task_manager.task;

import com.app.web.task_manager.free_marker.FreeMarkerService;
import com.app.web.task_manager.task.model.TaskCreate;
import com.app.web.task_manager.task.model.TaskUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RequestMapping("/api/task")
@RestController()
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final FreeMarkerService freeMarkerService;

    @PostMapping(value = "/new")
    public ResponseEntity<String> addNewTask(@RequestBody TaskCreate taskCreate) {
        return ResponseEntity.ok("{" + "id : \"" + taskService.addNewTask(taskCreate) + "\"}");
    }

    @DeleteMapping(value = "/delete/{uuid}")
    public ResponseEntity<UUID> deleteTask(@PathVariable String uuid) {
        return ResponseEntity.ok(taskService.deleteByUniqueId(uuid));
    }

    @PatchMapping(value = "/update")
    public ResponseEntity<UUID> updateStateOfTask(@RequestBody TaskUpdate taskUpdate) {
        return ResponseEntity.ok(taskService.updateDoneOfTaskByUniqueId(taskUpdate));
    }

    @GetMapping("/latest")
    public ResponseEntity<String> getLatestWeb() {
        return freeMarkerService.getResponseEntityHTML("TasksView.ftl", "listOfTasks", taskService.getLatestTasks());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(TaskNotFoundException.class)
    public void onTaskNotFound() {

    }

}


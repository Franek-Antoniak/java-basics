package com.app.web.task_manager.task.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class TaskDelete {
    private UUID uniqueId;
}

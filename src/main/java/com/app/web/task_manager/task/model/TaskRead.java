package com.app.web.task_manager.task.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
public class TaskRead {
    private UUID uniqueId;
}

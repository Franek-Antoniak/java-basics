package com.app.web.task_manager.task.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
public class TaskCreate {

    private static final String DEFAULT_DESCRIPTION = "Nothing to do";

    private String description = DEFAULT_DESCRIPTION;
    private UUID uniqueId;
    private boolean done = false;

}

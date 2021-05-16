package com.app.web.task_manager.task.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.coyote.http11.filters.SavedRequestInputFilter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
public class TaskCreate {

    private static final String DEFAULT_DESCRIPTION = "Nothing to do";

    private String description = DEFAULT_DESCRIPTION;
    private boolean deleted = false;
    private UUID uniqueId;
    private boolean done = false;

}

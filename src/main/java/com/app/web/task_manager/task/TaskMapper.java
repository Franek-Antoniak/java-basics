package com.app.web.task_manager.task;

import com.app.web.task_manager.task.model.TaskCreate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public abstract class TaskMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true)
    })
    public abstract Task toTask(TaskCreate taskCreate);

}

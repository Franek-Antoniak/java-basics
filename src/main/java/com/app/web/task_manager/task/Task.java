package com.app.web.task_manager.task;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.UUID;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Entity
@Getter
@Setter
@Where(clause = "deleted = false")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private boolean deleted = false;
    private UUID uniqueId;
    private boolean done = false;

    @PrePersist
    private void onCreate() {
        uniqueId = UUID.randomUUID();
    }

}

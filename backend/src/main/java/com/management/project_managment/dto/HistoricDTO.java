package com.management.project_managment.dto;

import com.management.project_managment.entities.Historic;
import com.management.project_managment.entities.Project;
import com.management.project_managment.entities.Task;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class HistoricDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String description;
    private Instant date;
    private Long projectId;
    private Long taskId;

    public HistoricDTO(Historic entity) {
        description = entity.getDescription();
        date = entity.getDate();
    }
}

package br.com.tasknow.workitemcommandservice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@Entity(name = "workitems_tb")
@AllArgsConstructor
@NoArgsConstructor
public class WorkItem {
    @Id
    UUID id;
    String name;
    String description;
    UUID user_id;
    UUID board_id;
}

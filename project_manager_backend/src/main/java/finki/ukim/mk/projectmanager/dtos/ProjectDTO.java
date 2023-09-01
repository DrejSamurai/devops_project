package finki.ukim.mk.projectmanager.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {
    private Long id;

    private String name;

    private String description;

    private Timestamp dateBeginning;

    private Timestamp dateEnding;

    private Boolean isActive;
}

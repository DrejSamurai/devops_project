package finki.ukim.mk.projectmanager.models;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "pr_project")
public class Project extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "date_beginning")
    private Timestamp dateBeginning;

    @Column(name = "date_ending")
    private Timestamp dateEnding;

    @Column(name = "is_active")
    private Boolean isActive;
}

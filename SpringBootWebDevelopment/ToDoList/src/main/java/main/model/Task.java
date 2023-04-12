package main.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "creation_time")
    private LocalDateTime creationTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "is_done",columnDefinition = "enum('DONE','NOT_COMPLETED')")
    private TypeStatus isDone;

    private String title;

    private String description;
}

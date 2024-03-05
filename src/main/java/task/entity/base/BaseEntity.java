package task.entity.base;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
}


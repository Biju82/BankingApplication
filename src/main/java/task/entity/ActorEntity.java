package task.entity;

import jakarta.persistence.*;
import lombok.*;
import task.entity.base.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "actors")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true,exclude = "moviesWithActors")
@ToString
public class ActorEntity extends BaseEntity {

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "last_name")
    @NonNull
    private String lastName;

    @Column(name = "year_of_birth")
    @NonNull
    private Integer yearOfBirth;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "actors_to_movies",
            joinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"))
    private List<MovieEntity> moviesWithActors = new ArrayList<>();

}

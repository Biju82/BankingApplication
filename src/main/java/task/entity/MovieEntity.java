package task.entity;

import jakarta.persistence.*;
import lombok.*;
import task.entity.base.BaseEntity;

import java.util.ArrayList;
import java.util.List;

// Care e diferenta intre == si equals? (HINT: adrese de memorie)

@Entity(name = "movies")
@Data   // asigura getters/setters
@NoArgsConstructor // asigura constructorul neparametrizat
@RequiredArgsConstructor    // asigura toate variatiile nenule de constructori
@EqualsAndHashCode(callSuper = true, exclude = "actorsInMovies")
@ToString
public class MovieEntity extends BaseEntity {

    @Column(name = "title")
    @NonNull
    private String title;

    @Column(name = "year_of_release")
    @NonNull
    private Integer yearOfRelease;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private GenreEntity genre;

    @ManyToMany(mappedBy = "movies", fetch = FetchType.LAZY)
    private List<ActorEntity> actorsInMovies = new ArrayList<>();


}

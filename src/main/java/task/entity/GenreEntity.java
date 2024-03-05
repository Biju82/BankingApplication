package task.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.*;
import task.entity.base.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "genres")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = "moviesByGenre")
@ToString(exclude = "moviesByGenre")
public class GenreEntity extends BaseEntity {

    @Column(name = "name")
    @NonNull
    private String name;

    /* one-to-many relationship */
    @OneToMany
    @JoinColumn(name = "genre_id") //specificam coloana din tabela movies care face legatura cu tabela genres (foreign key)
    private List<MovieEntity> moviesByGenre = new ArrayList<>();
}

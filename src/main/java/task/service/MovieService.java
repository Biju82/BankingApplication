package task.service;

import task.entity.MovieEntity;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    // nu mai e nevoie de metode de create/drop table ptc avem proprietatea hbm2ddl (Hibernate Mapping to Data definition language)
    // care transforma toate clasele anotate de tipul entity in tabele sql
    // si se ocupa si de partea de clean-up (curatare)

    // save = insertValue si updateValue, ptc daca nu exista adauga in tabel elementul
    // daca exista, il actualizeaza pe baza id-ului
    MovieEntity save(MovieEntity movie); // odata ce elementul e actualizat sau adaugat in tabel (BE -> DB), se intoarce ca raspuns pt FE

    void deleteById(Integer id);
    /* delete se poate face pe mai multe considerente, orice coloana unica poate fi folosita pt stergere */

    Optional<MovieEntity> findById(Integer id);

    List<MovieEntity> findAll();
}

package task.service;

import task.entity.GenreEntity;
import task.entity.MovieEntity;

import java.util.List;
import java.util.Optional;

public interface GenreService {

    GenreEntity save(GenreEntity genre);

    void deleteById(Integer id);

    Optional<GenreEntity> findById(Integer id);

    List<GenreEntity> findAll();
}

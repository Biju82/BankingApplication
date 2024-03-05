package task.dao;

import task.entity.MovieEntity;

import java.util.List;
import java.util.Optional;

public interface MovieDAO {

    MovieEntity save(MovieEntity movie);

    void deleteById(Integer id);

    Optional<MovieEntity> findById(Integer id);

    List<MovieEntity> findAll();
}

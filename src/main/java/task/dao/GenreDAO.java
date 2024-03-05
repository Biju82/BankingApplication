package task.dao;

import task.entity.GenreEntity;

import java.util.List;
import java.util.Optional;

public interface GenreDAO {

    GenreEntity save(GenreEntity genre);

    void deleteById(Integer id);

    Optional<GenreEntity> findById(Integer id);

    List<GenreEntity> findAll();
}

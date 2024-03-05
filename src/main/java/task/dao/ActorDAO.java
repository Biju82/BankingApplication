package task.dao;

import task.entity.ActorEntity;

import java.util.List;
import java.util.Optional;

public interface ActorDAO {

    ActorEntity save(ActorEntity actor);

    void deleteById(Integer id);

    Optional<ActorEntity> findById(Integer id);

    List<ActorEntity> findAll();
}

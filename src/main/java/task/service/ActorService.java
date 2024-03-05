package task.service;

import task.entity.ActorEntity;
import task.entity.MovieEntity;

import java.util.List;
import java.util.Optional;

public interface ActorService {

    ActorEntity save(ActorEntity actor);

    void deleteById(Integer id);

    Optional<ActorEntity> findById(Integer id);

    List<ActorEntity> findAll();
}

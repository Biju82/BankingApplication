package task.service.impl;

import task.dao.ActorDAO;
import task.dao.impl.ActorDAOImpl;
import task.entity.ActorEntity;
import task.service.ActorService;
import task.service.base.BaseService;

import java.util.List;
import java.util.Optional;

public class ActorServiceImpl extends BaseService implements ActorService {

    private ActorDAO actorDAO;

    public ActorServiceImpl() {
        this.actorDAO = new ActorDAOImpl(sessionFactory.createEntityManager());
    }

    @Override
    public ActorEntity save(ActorEntity actor) {
        return this.actorDAO.save(actor);
    }

    @Override
    public void deleteById(Integer id) {
        this.actorDAO.deleteById(id);
    }

    @Override
    public Optional<ActorEntity> findById(Integer id) {
        return this.actorDAO.findById(id);
    }

    @Override
    public List<ActorEntity> findAll() {
        return this.actorDAO.findAll();
    }
}

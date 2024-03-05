package task.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import task.dao.ActorDAO;
import task.dao.base.BaseDAO;
import task.entity.ActorEntity;
import task.entity.MovieEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ActorDAOImpl extends BaseDAO implements ActorDAO {

    public ActorDAOImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public ActorEntity save(ActorEntity actor) {
        EntityTransaction transaction = null;
        try {
            // check transaction is in place
            transaction = entityManager.getTransaction();

            if (!transaction.isActive()) {
                transaction.begin();
            }

            // sql command
            entityManager.persist(actor); // in contextul hibernate, persist = save/update element in table

            // commit command
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        }

        return actor;
    }

    @Override
    public void deleteById(Integer id) {
        EntityTransaction transaction = null;
        try {
            // check transaction is in place
            transaction = entityManager.getTransaction();

            if (!transaction.isActive()) {
                transaction.begin();
            }

            // sql command
            Optional<ActorEntity> found = Optional.ofNullable(entityManager.find(ActorEntity.class, id));  // select * from movie where id = <id>
            if (found.isPresent()) {
                entityManager.remove(found.get());
            }

            // commit command
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public Optional<ActorEntity> findById(Integer id) {
        EntityTransaction transaction = null;
        Optional<ActorEntity> found = Optional.empty();

        try {
            // check transaction is in place
            transaction = entityManager.getTransaction();

            if (!transaction.isActive()) {
                transaction.begin();
            }

            // sql command
            found = Optional.ofNullable(entityManager.find(ActorEntity.class, id));

            // commit command
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return found;
    }

    @Override
    public List<ActorEntity> findAll() {
        EntityTransaction transaction = null;
        List<ActorEntity> resultList = new ArrayList<>();

        try {
            // check transaction is in place
            transaction = entityManager.getTransaction();

            if (!transaction.isActive()) {
                transaction.begin();
            }

            // sql command
            resultList = entityManager.createQuery("FROM actors", ActorEntity.class).getResultList();

            // commit command
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return resultList;
    }
}

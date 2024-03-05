package task.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import task.dao.MovieDAO;
import task.dao.base.BaseDAO;
import task.entity.MovieEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MovieDAOImpl extends BaseDAO implements MovieDAO {

    public MovieDAOImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public MovieEntity save(MovieEntity movie) {
        EntityTransaction transaction = null;
        try {
            // check transaction is in place
            transaction = entityManager.getTransaction();

            if(!transaction.isActive()) {
                transaction.begin();
            }

            // sql command
            entityManager.persist(movie); // in contextul hibernate, persist = save/update element in table

            // commit command
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            return null;
        }

        return movie;
    }

    @Override
    public void deleteById(Integer id) {
        EntityTransaction transaction = null;
        try {
            // check transaction is in place
            transaction = entityManager.getTransaction();

            if(!transaction.isActive()) {
                transaction.begin();
            }

            // sql command
            Optional<MovieEntity> found = Optional.ofNullable(entityManager.find(MovieEntity.class, id));  // select * from movie where id = <id>
            if(found.isPresent()) {
                entityManager.remove(found.get());
            }

            // commit command
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public Optional<MovieEntity> findById(Integer id) {
        EntityTransaction transaction = null;
        Optional<MovieEntity> found = Optional.empty();

        try {
            // check transaction is in place
            transaction = entityManager.getTransaction();

            if(!transaction.isActive()) {
                transaction.begin();
            }

            // sql command
            found = Optional.ofNullable(entityManager.find(MovieEntity.class, id));

            // commit command
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        }

        return found;
    }

    @Override
    public List<MovieEntity> findAll() {
        EntityTransaction transaction = null;
        List<MovieEntity> resultList = new ArrayList<>();

        try {
            // check transaction is in place
            transaction = entityManager.getTransaction();

            if(!transaction.isActive()) {
                transaction.begin();
            }

            // sql command
            resultList = entityManager.createQuery("FROM movies", MovieEntity.class).getResultList();

            // commit command
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        }

        return resultList;
    }
}

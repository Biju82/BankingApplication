package task.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import task.dao.GenreDAO;
import task.dao.MovieDAO;
import task.dao.base.BaseDAO;
import task.entity.GenreEntity;
import task.entity.MovieEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GenreDAOImpl extends BaseDAO implements GenreDAO {

    public GenreDAOImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public GenreEntity save(GenreEntity genre) {
        EntityTransaction transaction = null;
        try {
            // check transaction is in place
            transaction = entityManager.getTransaction();

            if(!transaction.isActive()) {
                transaction.begin();
            }

            // sql command
            entityManager.persist(genre); // in contextul hibernate, persist = save/update element in table

            // commit command
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            return null;
        }

        return genre;
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
            Optional<GenreEntity> found = Optional.ofNullable(entityManager.find(GenreEntity.class, id));  // select * from movie where id = <id>
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
    public Optional<GenreEntity> findById(Integer id) {
        EntityTransaction transaction = null;
        Optional<GenreEntity> found = Optional.empty();

        try {
            // check transaction is in place
            transaction = entityManager.getTransaction();

            if(!transaction.isActive()) {
                transaction.begin();
            }

            // sql command
            found = Optional.ofNullable(entityManager.find(GenreEntity.class, id));

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
    public List<GenreEntity> findAll() {
        EntityTransaction transaction = null;
        List<GenreEntity> resultList = new ArrayList<>();

        try {
            // check transaction is in place
            transaction = entityManager.getTransaction();

            if(!transaction.isActive()) {
                transaction.begin();
            }

            // sql command
            resultList = entityManager.createQuery("FROM genres", GenreEntity.class).getResultList();

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

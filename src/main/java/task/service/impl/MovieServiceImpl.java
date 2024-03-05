package task.service.impl;

import task.dao.MovieDAO;
import task.dao.impl.MovieDAOImpl;
import task.entity.MovieEntity;
import task.service.MovieService;
import task.service.base.BaseService;

import java.util.List;
import java.util.Optional;

public class MovieServiceImpl extends BaseService implements MovieService {

    private MovieDAO movieDAO;

    public MovieServiceImpl() {
        this.movieDAO = new MovieDAOImpl(sessionFactory.createEntityManager());
    }

    @Override
    public MovieEntity save(MovieEntity movie) {
        return this.movieDAO.save(movie);
    }

    @Override
    public void deleteById(Integer id) {
        this.movieDAO.deleteById(id);
    }

    @Override
    public Optional<MovieEntity> findById(Integer id) {
        return this.movieDAO.findById(id);
    }

    @Override
    public List<MovieEntity> findAll() {
        return this.movieDAO.findAll();
    }
}

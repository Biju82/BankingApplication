package task.service.impl;

import task.dao.GenreDAO;
import task.dao.MovieDAO;
import task.dao.impl.GenreDAOImpl;
import task.dao.impl.MovieDAOImpl;
import task.entity.GenreEntity;
import task.entity.MovieEntity;
import task.service.GenreService;
import task.service.MovieService;
import task.service.base.BaseService;

import java.util.List;
import java.util.Optional;

public class GenreServiceImpl extends BaseService implements GenreService {

    private GenreDAO genreDAO;

    public GenreServiceImpl() {
        this.genreDAO = new GenreDAOImpl(sessionFactory.createEntityManager());
    }

    @Override
    public GenreEntity save(GenreEntity genre) {
        return this.genreDAO.save(genre);
    }

    @Override
    public void deleteById(Integer id) {
        this.genreDAO.deleteById(id);
    }

    @Override
    public Optional<GenreEntity> findById(Integer id) {
        return this.genreDAO.findById(id);
    }

    @Override
    public List<GenreEntity> findAll() {
        return this.genreDAO.findAll();
    }
}

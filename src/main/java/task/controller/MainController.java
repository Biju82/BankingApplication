package task.controller;

import task.entity.ActorEntity;
import task.entity.GenreEntity;
import task.entity.MovieEntity;
import task.service.ActorService;
import task.service.GenreService;
import task.service.MovieService;
import task.service.impl.ActorServiceImpl;
import task.service.impl.GenreServiceImpl;
import task.service.impl.MovieServiceImpl;

public class MainController {

    public static void main(String[] args) {
        MovieService movieService = new MovieServiceImpl();
        ActorService actorService = new ActorServiceImpl();
        GenreService genreService = new GenreServiceImpl();

        /* MOVIE CRUD */
        movieService.save(new MovieEntity("Film1", 1922));
        movieService.save(new MovieEntity("Film2", 1911));
        movieService.save(new MovieEntity("Film3", 1933));
        System.out.println(movieService.findAll());

        System.out.println(movieService.findById(2));
        movieService.deleteById(2);
        System.out.println(movieService.findAll());
        System.out.println("\n----------------------------------------------------\n");

        /* ACTOR CRUD */
        actorService.save(new ActorEntity("Nume1", "Prenume1", 1922));
        actorService.save(new ActorEntity("Nume2", "Prenume2", 1922));
        actorService.save(new ActorEntity("Nume3", "Prenume3", 1922));
        System.out.println(actorService.findAll());

        System.out.println(actorService.findById(2));
        actorService.deleteById(2);
        System.out.println(actorService.findAll());
        System.out.println("\n----------------------------------------------------\n");

        /* GENRE CRUD */
        genreService.save(new GenreEntity("Gen1"));
        genreService.save(new GenreEntity("Gen2"));
        genreService.save(new GenreEntity("Gen3"));
        System.out.println(genreService.findAll());

        System.out.println(genreService.findById(2));
        genreService.deleteById(2);
        System.out.println(genreService.findAll());
        System.out.println("\n----------------------------------------------------\n");

    }
}

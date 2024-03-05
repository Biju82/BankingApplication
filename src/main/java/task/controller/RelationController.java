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

import java.util.List;

public class RelationController {
    public static void main(String[] args) {

        MovieService movieService = new MovieServiceImpl();
        ActorService actorService = new ActorServiceImpl();
        GenreService genreService = new GenreServiceImpl();

        MovieEntity movie1 = new MovieEntity("Film1", 1922);
        ActorEntity actor1 = new ActorEntity("Nume1", "Prenume1", 1922);
        GenreEntity genre1 = new GenreEntity("Gen1");

        movie1.getActorsInMovies().add(actor1);
        actor1.getMoviesWithActors().add(movie1);
        movie1.setGenre(genre1);

        List<MovieEntity> movies = movieService.findAll();
        List<ActorEntity> actors = actorService.findAll();

        for (MovieEntity itMovie : movies) {
            System.out.println("Movie " + itMovie.getTitle());
            System.out.println("Actors: " + itMovie.getActorsInMovies());
            for (ActorEntity itActor : actors) {
                System.out.println("Actor: " + itActor.getName() + " " + itActor.getLastName() + " " + itActor.getYearOfBirth());

                System.out.println("===================================================");
            }

            for (ActorEntity itActor : actors) {
                System.out.println("Actor " + itActor.getName() + " " + itActor.getLastName() + " " + itActor.getYearOfBirth());
                System.out.println("Movies: ");
                for (MovieEntity Moviess : movies) {
                    System.out.println(Moviess.getTitle());

                    System.out.println("===================================================");
                }

            }
        }
    }
}

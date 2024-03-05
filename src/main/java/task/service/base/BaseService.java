package task.service.base;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import task.entity.ActorEntity;
import task.entity.GenreEntity;
import task.entity.MovieEntity;

public abstract class BaseService {

    // atribut -> sessionFactory = este un obiect ce creeaza o sesiune de conexiune la baza de date pe baza cfg-ului definit
    protected final SessionFactory sessionFactory = new Configuration()
            .configure()    // incarca configuratia din resources -> hibernate.cfg.xml
            .addAnnotatedClass(MovieEntity.class)   // va adauga clasele de entitate ca standarde pt comenzile sql
            .addAnnotatedClass(ActorEntity.class)
            .addAnnotatedClass(GenreEntity.class)
            .buildSessionFactory(); // porneste sesiunea, echivalentul lui getConnection din JDBC

}

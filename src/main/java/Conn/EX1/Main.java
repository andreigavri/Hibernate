package Conn.EX1;

import Conn.ManyToMany.Client2;
import jakarta.persistence.EntityManager;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        final SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Actors.class)
                .addAnnotatedClass(Movies.class)
                .addAnnotatedClass(Genres.class)
                .buildSessionFactory();



        List<Movies> moviesList1 = new ArrayList<>();
        List<Movies> moviesList2 = new ArrayList<>();
        List<Actors> actorsList1 = new ArrayList<>();
        List<Actors> actorsList2 = new ArrayList<>();


        Movies movie1 = new Movies(1, "Ghost Rider", 2005, 10, actorsList1);
        Movies movie2 = new Movies(2, "Cercetatorul", 2004, 11, actorsList2);
        Movies movie3 = new Movies(3, "SuperMan ", 2010, 12, actorsList1);
        Movies movie4 = new Movies(4, "The Singer ", 2012, 14, actorsList2);
        moviesList1.add(movie1);
        moviesList1.add(movie2);
        moviesList2.add(movie2);
        moviesList2.add(movie4);


        final GenreRepository genreRepository = new GenreRepository(sessionFactory.createEntityManager());
        genreRepository.save(new Genres(1, "Horror"));


        Actors actor1 = new Actors(1, 1987, "Michael", "Summer", moviesList1);
        Actors actor2 = new Actors(2, 1988, "Morgan", "Freeman", moviesList2);
        actorsList1.add(actor1);
        actorsList1.add(actor2);


        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(actor1);
        entityManager.persist(actor2);
        entityManager.getTransaction().commit();


    }
}




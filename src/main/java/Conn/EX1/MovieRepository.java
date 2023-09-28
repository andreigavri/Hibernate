package Conn.EX1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class MovieRepository {

    private final EntityManager entityManager;

    public MovieRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public List<Movies> findAll() {
        return entityManager.createQuery("From Movies", Movies.class).getResultList();

    }

    public Optional<Movies> findById(int id) {
        return Optional.ofNullable(entityManager.find(Movies.class, id));

    }

    public List<Movies> findByTitle(String title) {
        return entityManager.createQuery("SELECT m FROM movies m WHERE m.title = :title", Movies.class)
                .setParameter("title", title)
                .getResultList();
    }

    public Optional<Movies> save(final Movies movie) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }

            entityManager.persist(movie);
            transaction.commit();
            return Optional.ofNullable(movie);
        } catch (final Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        }
    }

    public Optional<Movies> delete(final Movies movie) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }

            entityManager.remove(movie);
            transaction.commit();
            return Optional.ofNullable(movie);
        } catch (final Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        }

    }
    public List<Movies> findAllWithActors() {
        return entityManager.createQuery("SELECT m FROM movies m LEFT JOIN fetch m.actors", Movies.class)
                .getResultList();
    }
}




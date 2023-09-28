package Conn.EX1;

import jakarta.persistence.*;

import java.util.List;
import java.util.Optional;

public class GenreRepository {

    private final EntityManager entityManager;

    public GenreRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Genres save(final Genres genre) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }

            entityManager.persist(genre);
            transaction.commit();
            return genre;
        } catch (final Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        }
    }

    public Genres delete (final Genres genre) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }

            entityManager.remove(genre);
            transaction.commit();
            return genre;
        } catch (final Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        }
    }
    public Optional<Genres> findById(int id) {
        return Optional.ofNullable(entityManager.find(Genres.class, id));

    }

    public List<Genres> findByName(String name) {
        return entityManager.createQuery("SELECT g FROM genres g WHERE g.name = :name", Genres.class)
                .setParameter("name", name)
                .getResultList();
    }

    public List<Genres> findAll() {
        return entityManager.createQuery("From Genres", Genres.class)
                .getResultList();

    }

}
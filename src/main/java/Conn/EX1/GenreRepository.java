package Conn.EX1;

import jakarta.persistence.*;

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
}
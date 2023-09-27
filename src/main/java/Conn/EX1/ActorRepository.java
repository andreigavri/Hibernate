package Conn.EX1;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Id;

public class ActorRepository {

    private final EntityManager entityManager;

    public ActorRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public Actors save(final Actors actor) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }

            entityManager.persist(actor);
            transaction.commit();
            return actor;
        } catch (final Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        }
    }
}



package Conn.EX1;

import jakarta.persistence.EntityManager;

public class MovieRepository {

    private final EntityManager entityManager;

    public MoviesReposi(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


}

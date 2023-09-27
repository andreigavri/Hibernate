package Conn.MappedSuperclass;

import jakarta.persistence.EntityManager;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainMapped {
    public static void main(String[] args) {
        final SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(ComputerGame.class)
                .buildSessionFactory();

        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        ComputerGame computerGame= new ComputerGame("LeagueOfLegends", "Multiplayer game","MMRPG" );
        entityManager.persist(computerGame);
        entityManager.getTransaction().commit();


    }
}

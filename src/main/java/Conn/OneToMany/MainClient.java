package Conn.OneToMany;

import jakarta.persistence.EntityManager;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainClient {
    public static void main(String[] args) {
        final SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(OrderFastFood.class)
                .addAnnotatedClass(Client.class)
                .buildSessionFactory();

        Date date = new Date();
        OrderFastFood comanda1 = new OrderFastFood(1,50,"shaorma",date,null);
        OrderFastFood comanda2= new OrderFastFood(2,60,"Snitel",date,null);
        OrderFastFood comanda3= new OrderFastFood(3,70,"Gyros",date,null);

        List<OrderFastFood> comenziAlex = new ArrayList<>();
        comenziAlex.add(comanda1);
        comenziAlex.add(comanda2);
        Client alex= new Client(1,"Alex","Maxim",comenziAlex);
        comanda1.setClient(alex);
        comanda2.setClient(alex);
        EntityManager entityManager=sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(comanda1);
        entityManager.persist(comanda2);
        entityManager.persist(alex);
        entityManager.getTransaction().commit();




    }
}

package Conn.ManyToMany;

import Conn.OneToMany.OrderFastFood;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainClient2 {
    public static void main(String[] args) {
        final SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Client2.class)
                .addAnnotatedClass(Order2.class)
                .buildSessionFactory();

        Date date = new Date();
        List<Client2> clientiComanda1=new ArrayList<>();
        List<Client2> clientiComanda2=new ArrayList<>();

        Order2 comanda1 = new Order2(1,34,"Ciocolata",date,clientiComanda1);
        Order2 comanda2 = new Order2(2,35,"Ceai",date,clientiComanda2);
        Order2 comanda3 = new Order2(3,37,"Cafea",date,clientiComanda2);
        Order2 comanda4 = new Order2(4,39,"Bere",date,clientiComanda2);
        List<Order2>comenziAlex= new ArrayList<>();
        comenziAlex.add(comanda1);
        comenziAlex.add(comanda2);
        comenziAlex.add(comanda3);
        List<Order2> comenziRazvan = new ArrayList<>();
        comenziRazvan.add(comanda3);
        comenziRazvan.add(comanda4);
        comenziRazvan.add(comanda1);
        Client2 alex = new Client2(1,"Alex", "Maxim", comenziAlex);
        Client2 razvan = new Client2(2,"Razvan","Maxim", comenziRazvan);
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(razvan);
        entityManager.persist(alex);
        entityManager.getTransaction().commit();



    }
}

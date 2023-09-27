package Conn.CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        final SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Car.class)
                .buildSessionFactory();

        try(Session session = sessionFactory.openSession()){
            final Car car = new Car(2, "GLE","Mercedes",3.0);
            Transaction transaction = session.beginTransaction();
            //session.persist(car);
            //Car car1 = session.find(Car.class, 2);
            //System.out.println(car1);
            session.remove(car);
            transaction.commit();


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

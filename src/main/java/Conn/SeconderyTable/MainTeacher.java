package Conn.SeconderyTable;

import jakarta.persistence.EntityManager;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainTeacher {
    public static void main(String[] args) {
        final SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Teacher.class)
                .addAnnotatedClass(Specialization.class)
                .buildSessionFactory();

        EntityManager entityManager = sessionFactory.createEntityManager();
        TeacherId teacherId = new TeacherId(1234,"RO45");
        Person person = new Person("Alex","Maxim");
        Teacher teacher = new Teacher();
        teacher.setTeacherId(teacherId);
        teacher.setPerson(person);
        teacher.setType("Matematica");

        entityManager.getTransaction().begin();
        entityManager.persist(teacher);
        entityManager.getTransaction().commit();

    }
}

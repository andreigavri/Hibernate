package Conn.OneToOne;

import jakarta.persistence.EntityManager;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainStudent {
    public static void main(String[] args) {
        final SessionFactory sessionFactory= new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(StudentBook.class)
                .buildSessionFactory();

        Student student = new Student();
        student.setFirstName("Donald");
        student.setLastName("Duck");
        StudentBook studentBook = new StudentBook();
        studentBook.setNumber("SDA-60");
        student.setStudentBook(studentBook);
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(studentBook);
        entityManager.persist(student);
        entityManager.getTransaction().commit();

    }
}

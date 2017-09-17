package sample;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by X on 9/17/2017.
 */
public class Main {
    public static void main(String[] args) {
//        sample.SessionFactoryManager.getSessionFactory().openSession();
//        sample.SessionFactoryManager.getSessionFactory().close();
        // Use persistence.xml configuration
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
        EntityManager em = emf.createEntityManager(); // Retrieve an application managed entity manager
// Work with the EM

        em.getTransaction().begin();

        Book book = new Book();
        book.setTitle( "High-Performance Java Persistence" );
        book.setAuthor( "Vlad Mihalcea" );
        book.setIsbn( "978-9730228236" );
        em.persist(book);

        sample.Publication amazonUs = new sample.Publication();
        amazonUs.setPublisher( "amazon.com" );
        amazonUs.setBook( book );
        amazonUs.setPriceCents( 4599 );
        amazonUs.setCurrency( "$" );
        em.persist( amazonUs );

        sample.Publication amazonUk = new sample.Publication();
        amazonUk.setPublisher( "amazon.co.uk" );
        amazonUk.setBook( book );
        amazonUk.setPriceCents( 3545 );
        amazonUk.setCurrency( "&" );
        em.persist( amazonUk );

        em.getTransaction().commit();
        em.close();
        emf.close(); //close at application end
    }
}

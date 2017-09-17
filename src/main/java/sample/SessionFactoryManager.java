package sample;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class SessionFactoryManager {
    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            if (sessionFactory == null) {
                StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
                        .applySetting("hibernate.connection.url", "jdbc:mysql://localhost:3306/hibernate_test")
                        .applySetting("hibernate.connection.username", "root")
                        .applySetting("hibernate.connection.password", "password")
                        .applySetting("hibernate.connection.driver", "com.mysql.jdbc.Driver")
                        .applySetting("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect")
                        .applySetting("hibernate.dialect.storage_engine", "innodb")
                        .applySetting("hibernate.hbm2ddl.auto", "create")
                        .applySetting("hibernate.show_sql", "true")
                        .applySetting("hibernate.format_sql", "true")
                        .applySetting("hibernate.current_session_context_class", "thread")
                        .build();
                MetadataSources metadataSources = new MetadataSources(standardServiceRegistry)
                        .addAnnotatedClass(Post.class)
                        .addAnnotatedClass(PostComment.class)
                        .addAnnotatedClass(Book.class)
                        .addAnnotatedClass(Publication.class);

                Metadata metadata = metadataSources.buildMetadata();
                sessionFactory = metadata.buildSessionFactory();

            }
            return sessionFactory;
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
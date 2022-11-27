package Hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    // pole statyczne 1 instancja nikt go nie nadpisze
    //kazdy moze go uzywac wszedzie
    //wywolujemy prywatny konstruktor
    //konttruktora nie da sie wywolac nigdzie indziej
    public final static HibernateUtil INSTANCE = new HibernateUtil();
    private final SessionFactory sessionFactory;

    private HibernateUtil() {
        this.sessionFactory = loadConfigFile();
    }

    private SessionFactory loadConfigFile() {
        // Załaduj plik konfiguracyjny: hibernate.cfg.xml
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        // Metadane to dane które opisują dane
        Metadata metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();

        // Na podstawie metadanych z pliku konfiguracyjnego tworzymy fabrykę sesji
        return metadata.getSessionFactoryBuilder().build();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

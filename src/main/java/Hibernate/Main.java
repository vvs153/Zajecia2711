package Hibernate;

import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession();
    }
}

package Hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class MainADDStudent {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            Scanner scanner= new Scanner(System.in);
            System.out.println("Podaj imie");
            String name = scanner.nextLine();
            System.out.println("Podaj nazwisko");
            String nazwisko = scanner.nextLine();
            System.out.println("Podaj rok rozpoczecia");
            int year = scanner.nextInt();

            Student student = Student.builder()
                    .name(name)
                    .surname(nazwisko)
                    .year(year)
                    .build();
            session.persist(student);

            transaction.commit();
        } catch (Exception ioe) {
            System.err.println( "blad baza: " + ioe);

        }

    }
}

package Hibernate;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;

public class MainREAD {
    public static void main(String[] args) {
            Scanner scanner= new Scanner(System.in);
            System.out.println("Co wypisac (student/ocena)");
            String text = scanner.nextLine();
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
            if (text.equalsIgnoreCase("student")){
                TypedQuery<Student> zapytanie = session.createQuery("from Student", Student.class);
                List<Student> studentList = zapytanie.getResultList();
                studentList.forEach(System.out::println);
                }
            else if(text.equalsIgnoreCase("ocena")){
                TypedQuery<Ocena> zapytanie = session.createQuery("from Ocena", Ocena.class);
                List<Ocena> ocenaList = zapytanie.getResultList();
                ocenaList.forEach(System.out::println);
            } else {
                System.err.println("Nie ma takiej opcji");
            }

        } catch (Exception ioe) {
            System.err.println( "blad baza: " + ioe);

        }

    }
}

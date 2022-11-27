package Hibernate;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;

public class MainDELETE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Usunąć ocenę/studenta?");
        String text = scanner.nextLine();
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            if (text.equalsIgnoreCase("ocena")||text.equalsIgnoreCase("ocene")) {
                System.out.println("Podaj id oceny");
                Long id = scanner.nextLong();
                Ocena ocena = session.get(Ocena.class, id);
                if (ocena != null) {
                    session.remove(ocena);
                    transaction.commit();
                } else {
                    System.err.println("Nie ma takiej oceny");
                }
            } else if (text.equalsIgnoreCase("student")||text.equalsIgnoreCase("studenta")) {
                System.out.println("Podaj id studenta");
                Long id = scanner.nextLong();
                Student student = session.get(Student.class, id);
              //  Ocena ocena = session.get(Ocena.class, id);

                // jesli nie ma ocen to usuwamy, jesli mam to usuwamy najpierw oceny potem studenta
          if (student != null){
              if(!student.getGrades().isEmpty()){
                  for (Ocena ocena: student.getGrades()) {
                      session.remove(ocena);
                  }
              } session.remove(student);
              transaction.commit();
             }
            } else {
                System.err.println("Nie ma takiej opcji");
            }
        } catch (Exception ioe) {
            System.err.println("blad baza: " + ioe);

        }
    }
}

package Hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class MainADDGrade {
    public static void main(String[] args) {
            Scanner scanner= new Scanner(System.in);
            System.out.println("Podaj id studenta");
            String id = scanner.nextLine();
            Long studentId = Long.parseLong(id);
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            Student studentCheck = session.get(Student.class, studentId);
            if (studentCheck != null){
                System.out.println("Podaj ocene");
                String ocenaString = scanner.nextLine();
                Double ocenaValue = Double.parseDouble(ocenaString);
                Ocena ocena = Ocena.builder()
                        .student(studentCheck)
                        .value(ocenaValue)
                        .build();
                session.persist(ocena);

                transaction.commit();
                }
            else {
                System.err.println("Nie ma takiego studenta");
            }

        } catch (Exception ioe) {
            System.err.println( "blad baza: " + ioe);

        }

    }
}

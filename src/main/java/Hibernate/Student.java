package Hibernate;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import java.util.Set;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id // PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    private int year;

    // niechcemy aby to byla kolumna
    @Formula("(SELECT AVG(o.value) FROM ocena o WHERE o.student_id=id)")
    private Double avgGrade;
    //Relacje
    @OneToMany(mappedBy = "student") // nazwa pola
    private Set<Ocena> grades;

}

package Hibernate;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ocena {
    @Id // PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private Long id;

    private double value;
    @CreationTimestamp //odpowiednik SQL now()
    private LocalDateTime addTime;
    @Enumerated(value = EnumType.STRING)  //aby zachowac kolejnosc enuma
    private Przedmiot przedmiot;
//Relacje
    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Student student;

}

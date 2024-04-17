package aze.Abbasov.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "OWNERS")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private LocalDate birthDate;
    @Transient
    @Setter
    private List<Cat> cats;
    @Setter
    private String name;

    public Owner() {
        cats = new ArrayList<>();
    }

    public Owner(LocalDate birthDate, List<Cat> cats, String name) {
        this.birthDate = birthDate;
        this.cats = cats;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", birthDate=" + birthDate +
                ", cats=" + cats.toString() +
                "name=" + name +
                '}';
    }

}

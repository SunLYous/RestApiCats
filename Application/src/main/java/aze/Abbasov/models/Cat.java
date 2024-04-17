package aze.Abbasov.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "CATS")
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String name;
    @Setter
    private LocalDate birthDate;
    @Setter
    private String breed;
    @Setter
    @Enumerated(EnumType.STRING)
    private CatColor color;
    @Setter
    @Column(name = "owner_id")
    private Long owner;

    @ElementCollection
    @CollectionTable(name = "CatFriends", joinColumns = @JoinColumn(name = "cat_id"))
    @Column(name = "friend_cat_id")
    @Setter
    private List<Long> friends;

    public Cat() {
        friends = new ArrayList<>();
    }

    public Cat(String name,
               LocalDate birthDate,
               String breed,
               CatColor color,
               Long owner,
               List<Long> friends) {
        this.name = name;
        this.birthDate = birthDate;
        this.breed = breed;
        this.color = color;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", breed='" + breed + '\'' +
                ", color=" + color +
                ", owner=" + owner +
                ", friends=" + friends.toString() +
                '}';
    }
}

package aze.Abbasov.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "CatFriends")
public class CatFriends {
    @EmbeddedId
    private CatFriendsId id;
}

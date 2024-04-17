package aze.Abbasov.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
@Embeddable
public class CatFriendsId implements Serializable {
    @Column(name = "cat_id")
    private Long catId;

    @Column(name = "friend_cat_id")
    private Long friendCatId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatFriendsId that = (CatFriendsId) o;
        return Objects.equals(catId, that.catId) &&
                Objects.equals(friendCatId, that.friendCatId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(catId, friendCatId);
    }
}

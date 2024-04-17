package aze.Abbasov.abstractions;

import aze.Abbasov.models.Cat;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICatRepository extends JpaRepository<Cat, Long> {

    @Modifying
    @Query(value = "SELECT cf.id.friendCatId" +
            " FROM CatFriends cf" +
            " WHERE cf.id.catId = :catId")
    @Transactional
    List<Long> getFriend(Long catId);

    @Modifying
    @Query(value = "INSERT INTO CatFriends(cat_id, friend_cat_id)" +
            " VALUES(:catId, :friendCatId)",
            nativeQuery = true)
    @Transactional
    void addCatFriend(Long catId, Long friendCatId);

    @Transactional
    List<Cat> getCatsByOwner(Long ownerId);

}

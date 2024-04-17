package aze.Abbasov.contracts;

import aze.Abbasov.models.Cat;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICatService {
    Cat getCat(Long catId);

    Boolean addCat(Cat cat);

    Boolean addFriends(Long id, Long friendId);

    List<Cat> getCatsByOwner(Long ownerId);
}

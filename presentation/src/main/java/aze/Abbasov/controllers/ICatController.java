package aze.Abbasov.controllers;

import aze.Abbasov.CatDto;
import aze.Abbasov.FriendsDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICatController {
    ResponseEntity<?> addCat(CatDto catDto);

    ResponseEntity<CatDto> getCat(Long id);

    ResponseEntity<?> addFriends(FriendsDto friendsDto);

    ResponseEntity<List<CatDto>> getCatsByOwnerId(Long id);
}

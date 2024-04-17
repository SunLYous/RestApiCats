package aze.Abbasov.controllers;

import aze.Abbasov.CatDto;
import aze.Abbasov.contracts.ICatService;
import aze.Abbasov.DtoMapper;
import aze.Abbasov.FriendsDto;
import aze.Abbasov.models.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cat")
public class CatController implements ICatController {

    private final ICatService catService;
    private final DtoMapper dtoMapper;

    public CatController(ICatService catService, DtoMapper mapper) {
        this.catService = catService;
        this.dtoMapper = mapper;
    }

    @Override
    @PostMapping("/add")

    public ResponseEntity<?> addCat(@RequestBody CatDto catDto) {
        if (catService.addCat(dtoMapper.getCat(catDto))) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CatDto> getCat(@PathVariable Long id) {
        Cat cat = catService.getCat(id);
        if (cat != null) {
            CatDto catDto = dtoMapper.getCatDto(cat);
            return ResponseEntity.ok(catDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @Override
    @PostMapping("/addFriends")
    public ResponseEntity<?> addFriends(@RequestBody FriendsDto friends) {
        if(catService.addFriends(friends.firstFriend, friends.secondFriend))
            return ResponseEntity.status(HttpStatus.CREATED).build();
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @Override
    @GetMapping("getByOwnerId/{id}")
    public ResponseEntity<List<CatDto>> getCatsByOwnerId(@PathVariable Long id) {
        List<Cat> cats = catService.getCatsByOwner(id);
        if (cats != null) {
            List<CatDto> catDto = dtoMapper.getAllCatDto(cats);
            return ResponseEntity.ok(catDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}

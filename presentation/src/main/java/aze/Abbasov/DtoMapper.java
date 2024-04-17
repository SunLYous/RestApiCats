package aze.Abbasov;

import aze.Abbasov.models.Cat;
import aze.Abbasov.models.Owner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DtoMapper {

    public OwnerDto getOwnerDto(Owner owner) {
        var ownerDto = new OwnerDto();
        ownerDto.setName(owner.getName());
        ownerDto.setCats(getAllCatDto(owner.getCats()));
        ownerDto.setBirthDate(owner.getBirthDate());
        return ownerDto;
    }

    public CatDto getCatDto(Cat cat) {
        var catDto = new CatDto();
        catDto.setName(cat.getName());
        catDto.setBirthDate(cat.getBirthDate());
        catDto.setBreed(cat.getBreed());
        catDto.setColor(cat.getColor());
        catDto.setFriends(cat.getFriends());
        catDto.setOwner(cat.getOwner());
        return catDto;
    }

    public List<CatDto> getAllCatDto(List<Cat> cats) {
        var catsDto = new ArrayList<CatDto>();
        for (var cat : cats) {
            catsDto.add(getCatDto(cat));
        }
        return catsDto;
    }

    public Owner getOwner(OwnerDto ownerDto) {
        var owner = new Owner();
        owner.setName(ownerDto.getName());
        owner.setCats(getAllCat(ownerDto.getCats()));
        owner.setBirthDate(ownerDto.getBirthDate());
        return owner;
    }

    public List<Cat> getAllCat(List<CatDto> cats) {
        var catDto = new ArrayList<Cat>();
        for (var cat : cats) {
            catDto.add(getCat(cat));
        }
        return catDto;
    }

    public Cat getCat(CatDto catDto) {
        var cat = new Cat();
        cat.setName(catDto.getName());
        cat.setBirthDate(catDto.getBirthDate());
        cat.setBreed(catDto.getBreed());
        cat.setColor(catDto.getColor());
        cat.setFriends(catDto.getFriends());
        cat.setOwner(catDto.getOwner());
        return cat;
    }
}

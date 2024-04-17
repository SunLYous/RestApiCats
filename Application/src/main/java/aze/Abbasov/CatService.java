package aze.Abbasov;

import aze.Abbasov.abstractions.ICatRepository;
import aze.Abbasov.abstractions.IOwnerRepository;
import aze.Abbasov.contracts.ICatService;
import aze.Abbasov.models.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService implements ICatService {

    private final ICatRepository catRepository;
    private final IOwnerRepository ownerRepository;

    @Autowired
    public CatService(ICatRepository catRepository, IOwnerRepository ownerRepository) {
        this.catRepository = catRepository;
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Cat getCat(Long catId) {
        var cat = catRepository.findById(catId);
        if (cat.isPresent()) {
            var friends = catRepository.getFriend(catId);
            cat.get().setFriends(friends);
            return cat.get();
        } else {
            return null;
        }
    }

    @Override
    public Boolean
    addCat(Cat cat) {
        for (var friend : cat.getFriends()) {
            if (!catRepository.existsById(friend)) {
                return false;
            }
        }
        if (!catRepository.existsById(cat.getOwner())) {
            return false;
        }
        var savedCat = catRepository.save(cat);
        for (Long friendId : savedCat.getFriends()) {
            Cat friendCat = catRepository.findById(friendId).orElse(null);
            if (friendCat != null) {
                friendCat.getFriends().add(savedCat.getId());
                catRepository.save(friendCat);
            }
        }
        return true;
    }

    @Override
    public Boolean addFriends(Long id, Long friendId) {
        if (!catRepository.existsById(id) && !catRepository.existsById(friendId)) {
            return false;
        }
        catRepository.addCatFriend(id, friendId);
        catRepository.addCatFriend(friendId, id);
        return true;
    }

    @Override
    public List<Cat> getCatsByOwner(Long ownerId) {
        if (!ownerRepository.existsById(ownerId)) {
            return null;
        }
        return catRepository.getCatsByOwner(ownerId);
    }
}

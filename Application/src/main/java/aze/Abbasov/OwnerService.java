package aze.Abbasov;

import aze.Abbasov.abstractions.ICatRepository;
import aze.Abbasov.abstractions.IOwnerRepository;
import aze.Abbasov.contracts.IOwnerService;
import aze.Abbasov.models.Owner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OwnerService implements IOwnerService {

    private final IOwnerRepository ownerRepository;
    private final ICatRepository catRepository;

    public OwnerService(IOwnerRepository ownerRepository, ICatRepository catRepository) {
        this.ownerRepository = ownerRepository;
        this.catRepository = catRepository;
    }

    @Override
    public ResponseEntity<Owner> getOwner(Long id) {
        var owner = ownerRepository.findById(id);
        if (owner.isPresent()) {
            owner.get().setCats(catRepository.getCatsByOwner(id));
            return new ResponseEntity<>(owner.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @Override
    public Boolean addOwner(Owner owner) {
        for (var cat : owner.getCats()) {
            if (!catRepository.existsById(cat.getId())) {
                return false;
            }
        }
        ownerRepository.save(owner);
        return true;
    }
}

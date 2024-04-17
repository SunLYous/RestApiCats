package aze.Abbasov.contracts;

import aze.Abbasov.models.Owner;
import org.springframework.http.ResponseEntity;

public interface IOwnerService {
    ResponseEntity<Owner> getOwner(Long id);

    Boolean addOwner(Owner owner);
}

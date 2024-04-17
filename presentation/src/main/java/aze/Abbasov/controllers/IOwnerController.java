package aze.Abbasov.controllers;

import aze.Abbasov.OwnerDto;
import org.springframework.http.ResponseEntity;


public interface IOwnerController {
    public ResponseEntity<OwnerDto> getOwnerById(Long id);
    public ResponseEntity<Void> addOwner(OwnerDto dto);
}

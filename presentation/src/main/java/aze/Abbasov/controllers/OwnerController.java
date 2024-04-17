package aze.Abbasov.controllers;

import aze.Abbasov.contracts.IOwnerService;
import aze.Abbasov.DtoMapper;
import aze.Abbasov.models.Owner;
import aze.Abbasov.OwnerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/owner")
public class OwnerController implements IOwnerController {
    private final IOwnerService ownerService;
    private final DtoMapper dtoMapper;

    @Autowired
    public OwnerController(IOwnerService ownerService, DtoMapper dtoMapper) {
        this.ownerService = ownerService;
        this.dtoMapper = dtoMapper;
    }

    @Override
    @GetMapping("/get/{id}")
    public ResponseEntity<OwnerDto> getOwnerById(@PathVariable Long id) {
        ResponseEntity<Owner> response = ownerService.getOwner(id);
        HttpStatusCode statusCode = response.getStatusCode();
        if (statusCode.is2xxSuccessful()) {
            Owner owner = response.getBody();
            OwnerDto ownerDto = dtoMapper.getOwnerDto(owner);
            return ResponseEntity.ok(ownerDto);
        } else {
            return ResponseEntity.status(statusCode).body(null);
        }
    }

    @Override
    @PostMapping("/add")
    public ResponseEntity<Void> addOwner(@RequestBody OwnerDto dto) {
         if(ownerService.addOwner(dtoMapper.getOwner(dto)))
            return ResponseEntity.status(HttpStatus.CREATED).build();
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
}

package com.WpCorp.DsConcorcio.Controller;

import com.WpCorp.DsConcorcio.DTO.MotorDTO;
import com.WpCorp.DsConcorcio.DTO.RegisterMotorcycle;
import com.WpCorp.DsConcorcio.Service.MotorcycleService;
import jakarta.persistence.PrePersist;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Set;

@RestController
@Log4j2
@RequestMapping("/v1/motors")
public class MotorcycleController {
    @Autowired
    private MotorcycleService mtServ;

    @PostMapping@PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<RegisterMotorcycle> createNewMotorcycle
            (@RequestBody @Valid RegisterMotorcycle motorcycle) {
        log.info("Content: {}", motorcycle.toString());
        URI uri = mtServ.createNewMotorcycle(motorcycle);
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Set<MotorDTO>> getAllMotorcycles() {
        Set<MotorDTO> mts = mtServ.getAllMotorcycles();
        return ResponseEntity.ok(mts);
    }

}

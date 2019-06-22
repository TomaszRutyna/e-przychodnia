package pl.sda.eprzychodnia.infrastructure.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.eprzychodnia.infrastructure.client.PatientClient;
import pl.sda.eprzychodnia.infrastructure.client.patients.dto.PatientDto;

import java.util.List;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientClient client;


    @GetMapping("/{id}")
    public PatientDto getOne(@PathVariable Long id) {
        return client.get(id).orElse(null);
    }

    @GetMapping
    public List<PatientDto> getAll() {
        return client.getAll();
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody PatientDto patientDto) {
        client.create(patientDto);
        return ResponseEntity.status(201).build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody PatientDto patientDto) {
        client.update(patientDto);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        client.delete(id);
        return ResponseEntity.status(204).build();


    }
}

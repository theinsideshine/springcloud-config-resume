package com.theinsideshine.springcloud.msvc.sections.controllers;

import com.theinsideshine.springcloud.msvc.sections.models.Section;
import com.theinsideshine.springcloud.msvc.sections.services.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @GetMapping
    public ResponseEntity<List<Section>> list() {
        return ResponseEntity.ok(sectionService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detail(@PathVariable Long id) {
        Optional<Section> o = sectionService.findById(id);
        if (o.isPresent()) {
            return ResponseEntity.ok(o.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@Valid @RequestBody Section section, BindingResult result) {

        if (result.hasErrors()) {
            return validate(result);
        }
        Section sectionDb = sectionService.save(section);
        return ResponseEntity.status(HttpStatus.CREATED).body(sectionDb);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@Valid @RequestBody Section section, @PathVariable Long id, BindingResult result) {

        if (result.hasErrors()) {
            return validate(result);
        }
        Optional<Section> o = sectionService.findById(id);
        if (o.isPresent()) {
            Section sectionDb = o.get();
            sectionDb.setKey1(section.getKey1());
            sectionDb.setValue1(section.getValue1());
            sectionDb.setKey2(section.getKey2());
            sectionDb.setValue2(section.getValue2());
            sectionDb.setKey3(section.getKey3());
            sectionDb.setValue3(section.getValue3());
            sectionDb.setKey4(section.getKey4());
            sectionDb.setValue4(section.getValue4());
            sectionDb.setKey5(section.getKey5());
            sectionDb.setValue5(section.getValue5());
            sectionDb.setKey6(section.getKey6());
            sectionDb.setValue6(section.getValue6());
            sectionDb.setKey7(section.getKey7());
            sectionDb.setValue7(section.getValue7());
            sectionDb.setKey8(section.getKey8());
            sectionDb.setValue8(section.getValue8());
            sectionDb.setKey9(section.getKey9());
            sectionDb.setValue9(section.getValue9());
            sectionDb.setKey10(section.getKey10());
            sectionDb.setValue10(section.getValue10());


            return ResponseEntity.status(HttpStatus.CREATED).body(sectionService.save(sectionDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Section> o = sectionService.findById(id);
        if (o.isPresent()) {
            sectionService.delete(o.get().getId());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    private ResponseEntity<Map<String, String>> validate(BindingResult result) {
        Map<String, String> errores = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }

}

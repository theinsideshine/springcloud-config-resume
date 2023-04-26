package com.theinsideshine.springcloud.msvc.sections.controllers;

import com.google.gson.JsonObject;
import com.theinsideshine.springcloud.msvc.sections.models.entity.Testimonial;
import com.theinsideshine.springcloud.msvc.sections.services.TestimonialService;
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
import java.util.logging.Level;
import java.util.logging.Logger;

@CrossOrigin(origins = { "http://localhost:3000" , "https://react-config-resume-builder.web.app/"})
@RestController
@RequestMapping("/section/testimonial")
public class TestimonialController {

    private final static Logger LOGGER = Logger.getLogger("TestimonialController");

    @Autowired
    private TestimonialService testimonialService;

    @GetMapping
    public ResponseEntity<List<Testimonial>> list() {
        return ResponseEntity.ok(testimonialService.list());
    }



    @GetMapping("/data")
    public ResponseEntity<?> detailHero() {
        Optional<Testimonial> o = testimonialService.findById(1L);
        if (o.isPresent()) {
            JsonObject json = new JsonObject();
            json.addProperty(o.get().getKey1(),o.get().getValue1());
            json.addProperty(o.get().getKey2(),o.get().getValue2());
            json.addProperty(o.get().getKey3(),o.get().getValue3());
            json.addProperty(o.get().getKey4(),o.get().getValue4());

            LOGGER.log(Level.INFO, "GET testimonial");
            return ( new ResponseEntity<>(json.toString(), HttpStatus.OK));

        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@Valid @RequestBody Testimonial testimonial, BindingResult result) {

        if (result.hasErrors()) {
            return validate(result);
        }
        Testimonial testimonialDb = testimonialService.save(testimonial);
        return ResponseEntity.status(HttpStatus.CREATED).body(testimonialDb);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@Valid @RequestBody Testimonial testimonial, @PathVariable Long id, BindingResult result) {

        if (result.hasErrors()) {
            return validate(result);
        }
        Optional<Testimonial> o = testimonialService.findById(id);
        if (o.isPresent()) {
            Testimonial testimonialDb = o.get();
            testimonialDb.setKey1(testimonial.getKey1());
            testimonialDb.setValue1(testimonial.getValue1());
            testimonialDb.setKey2(testimonial.getKey2());
            testimonialDb.setValue2(testimonial.getValue2());
            testimonialDb.setKey3(testimonial.getKey3());
            testimonialDb.setValue3(testimonial.getValue3());
            testimonialDb.setKey4(testimonial.getKey4());
            testimonialDb.setValue4(testimonial.getValue4());

            return ResponseEntity.status(HttpStatus.CREATED).body(testimonialService.save(testimonialDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Testimonial> o = testimonialService.findById(id);
        if (o.isPresent()) {
            testimonialService.delete(o.get().getId());
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

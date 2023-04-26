package com.theinsideshine.springcloud.msvc.sections.controllers;

import com.google.gson.JsonObject;
import com.theinsideshine.springcloud.msvc.sections.models.User;
import com.theinsideshine.springcloud.msvc.sections.models.entity.About;
import com.theinsideshine.springcloud.msvc.sections.services.AboutService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@CrossOrigin(origins = { "http://localhost:3000" , "https://react-config-resume-builder.web.app/"})
@RestController
@RequestMapping("/section/about")
public class AboutController {

    private final static Logger LOGGER = Logger.getLogger("AboutController");

    @Autowired
    private AboutService aboutService;

    @GetMapping
    public ResponseEntity<List<About>> list() {
        return ResponseEntity.ok(aboutService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detail(@PathVariable Long id) {
        Optional<About> o = aboutService.findByIdWithUser(id);//heroService.findById(id);
        if (o.isPresent()) {
            return ResponseEntity.ok(o.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/data")
    public ResponseEntity<?> detaildata() {
        Optional<About> o = aboutService.findByIdWithUser(1L);
        if (o.isPresent()) {
            JsonObject json = new JsonObject();
            json.addProperty(o.get().getKey1(), o.get().getValue1());
            json.addProperty(o.get().getKey2(), o.get().getValue2());
            json.addProperty(o.get().getKey3(),o.get().getValue3());
            json.addProperty(o.get().getKey4(),o.get().getUsers().get(0).getLocation()+","+
                    o.get().getUsers().get(0).getCity()+","+
                    o.get().getUsers().get(0).getCountry());
            json.addProperty(o.get().getKey5(),o.get().getValue5());
            json.addProperty(o.get().getKey6(),o.get().getUsers().get(0).getAge());
            json.addProperty(o.get().getKey7(),o.get().getValue7());
            json.addProperty(o.get().getKey8(),o.get().getUsers().get(0).getNationality());
            json.addProperty(o.get().getKey9(),o.get().getValue9());
            json.addProperty(o.get().getKey10(),o.get().getUsers().get(0).getInterests());
            json.addProperty(o.get().getKey11(),o.get().getValue11());
            json.addProperty(o.get().getKey12(),o.get().getUsers().get(0).getStudy());
            json.addProperty(o.get().getKey13(),o.get().getValue13());
            json.addProperty(o.get().getKey14(),o.get().getUsers().get(0).getEmployment());


            LOGGER.log(Level.INFO, "GET About");
            return ( new ResponseEntity<>(json.toString(), HttpStatus.OK));

        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@Valid @RequestBody About about, BindingResult result) {

        if (result.hasErrors()) {
            return validate(result);
        }
        About aboutDb = aboutService.save(about);
        return ResponseEntity.status(HttpStatus.CREATED).body(aboutDb);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@Valid @RequestBody About about, @PathVariable Long id, BindingResult result) {

        if (result.hasErrors()) {
            return validate(result);
        }
        Optional<About> o = aboutService.findById(id);
        if (o.isPresent()) {
            About aboutDb = o.get();
            aboutDb.setKey1(about.getKey1());
            aboutDb.setValue1(about.getValue1());
            aboutDb.setKey2(about.getKey2());
            aboutDb.setValue2(about.getValue2());
            aboutDb.setKey3(about.getKey3());
            aboutDb.setValue3(about.getValue3());
            aboutDb.setKey4(about.getKey4());
            aboutDb.setValue4(about.getValue4());
            aboutDb.setKey5(about.getKey5());
            aboutDb.setValue5(about.getValue5());
            aboutDb.setKey6(about.getKey6());
            aboutDb.setValue6(about.getValue6());
            aboutDb.setKey7(about.getKey7());
            aboutDb.setValue7(about.getValue7());
            aboutDb.setKey8(about.getKey8());
            aboutDb.setValue8(about.getValue8());
            aboutDb.setKey9(about.getKey9());
            aboutDb.setValue9(about.getValue9());
            aboutDb.setKey10(about.getKey10());
            aboutDb.setValue10(about.getValue10());
            aboutDb.setKey11(about.getKey11());
            aboutDb.setValue11(about.getValue11());
            aboutDb.setKey12(about.getKey12());
            aboutDb.setValue12(about.getValue12());
            aboutDb.setKey13(about.getKey13());
            aboutDb.setValue13(about.getValue13());
            aboutDb.setKey14(about.getKey14());
            aboutDb.setValue14(about.getValue14());


            return ResponseEntity.status(HttpStatus.CREATED).body(aboutService.save(aboutDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<About> o = aboutService.findById(id);
        if (o.isPresent()) {
            aboutService.delete(o.get().getId());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/assign-user/{aboutId}")
    public ResponseEntity<?> assignUser(@RequestBody User user, @PathVariable Long aboutId) {
        Optional<User> o;
        try {
            o = aboutService.assignUser(user, aboutId );
        } catch (FeignException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("mensaje", "No existe el usuario por " +
                            "el id o error en la comunicacion: " + e.getMessage()));
        }
        if (o.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(o.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/create-user/{aboutId}")
    public ResponseEntity<?> createUser(@RequestBody User user, @PathVariable Long aboutId) {
        Optional<User> o;
        try {
            o = aboutService.createUser(user, aboutId);
        } catch (FeignException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("mensaje", "No se pudo crear el usuario " +
                            "o error en la comunicacion: " + e.getMessage()));
        }
        if (o.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(o.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete-user/{aboutId}")
    public ResponseEntity<?> deleteUser(@RequestBody User user, @PathVariable Long aboutId) {
        Optional<User> o;
        try {
            o = aboutService.deleteUser(user, aboutId);
        } catch (FeignException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("mensaje", "No existe el usuario por " +
                            "el id o error en la comunicacion: " + e.getMessage()));
        }
        if (o.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(o.get());
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

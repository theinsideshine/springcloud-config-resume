package com.theinsideshine.springcloud.msvc.sections.controllers;

import com.google.gson.JsonObject;
import com.theinsideshine.springcloud.msvc.sections.models.User;
import com.theinsideshine.springcloud.msvc.sections.models.entity.Hero;
import com.theinsideshine.springcloud.msvc.sections.services.HeroService;
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

@CrossOrigin(origins =  "http://localhost:3000")
@RestController
@RequestMapping("/section/hero")
public class HeroController {

    private final static Logger LOGGER = Logger.getLogger("HeroController");

    @Autowired
    private HeroService heroService;

    @GetMapping
    public ResponseEntity<List<Hero>> list() {
        return ResponseEntity.ok(heroService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detail(@PathVariable Long id) {
        Optional<Hero> o = heroService.findByIdWithUser(id);//heroService.findById(id);
        if (o.isPresent()) {
            return ResponseEntity.ok(o.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/data")
    public ResponseEntity<?> detailHero() {
        Optional<Hero> o = heroService.findByIdWithUser(1L);
        if (o.isPresent()) {
            JsonObject json = new JsonObject();
            json.addProperty(o.get().getKey1(), o.get().getValue1()+" "+o.get().getUsers().get(0).getName());
            json.addProperty(o.get().getKey2(), o.get().getValue2());
            json.addProperty(o.get().getKey3(),o.get().getUsers().get(0).getGraduation());
            json.addProperty(o.get().getKey4(),o.get().getValue4());
            json.addProperty(o.get().getKey5(),o.get().getValue5());
            json.addProperty(o.get().getKey6(),o.get().getValue6());
            json.addProperty(o.get().getKey7(),o.get().getValue7());
            json.addProperty(o.get().getKey8(),o.get().getValue8());
            json.addProperty(o.get().getKey9(),o.get().getValue9());
            json.addProperty(o.get().getKey10(),o.get().getValue10());
            json.addProperty(o.get().getKey11(),o.get().getUsers().get(0).getGithubLink());
            json.addProperty(o.get().getKey12(),o.get().getUsers().get(0).getYoutubeLink());
            json.addProperty(o.get().getKey13(),o.get().getUsers().get(0).getLinkedinLink());
            json.addProperty(o.get().getKey14(),o.get().getUsers().get(0).getIgLink());
            json.addProperty(o.get().getKey15(),o.get().getUsers().get(0).getFacebookLink());

            LOGGER.log(Level.INFO, "GET hero");
            return ( new ResponseEntity<>(json.toString(), HttpStatus.OK));

        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@Valid @RequestBody Hero hero, BindingResult result) {

        if (result.hasErrors()) {
            return validate(result);
        }
        Hero heroDb = heroService.save(hero);
        return ResponseEntity.status(HttpStatus.CREATED).body(heroDb);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@Valid @RequestBody Hero hero, @PathVariable Long id, BindingResult result) {

        if (result.hasErrors()) {
            return validate(result);
        }
        Optional<Hero> o = heroService.findById(id);
        if (o.isPresent()) {
            Hero heroDb = o.get();
            heroDb.setKey1(hero.getKey1());
            heroDb.setValue1(hero.getValue1());
            heroDb.setKey2(hero.getKey2());
            heroDb.setValue2(hero.getValue2());
            heroDb.setKey3(hero.getKey3());
            heroDb.setValue3(hero.getValue3());
            heroDb.setKey4(hero.getKey4());
            heroDb.setValue4(hero.getValue4());
            heroDb.setKey5(hero.getKey5());
            heroDb.setValue5(hero.getValue5());
            heroDb.setKey6(hero.getKey6());
            heroDb.setValue6(hero.getValue6());
            heroDb.setKey7(hero.getKey7());
            heroDb.setValue7(hero.getValue7());
            heroDb.setKey8(hero.getKey8());
            heroDb.setValue8(hero.getValue8());
            heroDb.setKey9(hero.getKey9());
            heroDb.setValue9(hero.getValue9());
            heroDb.setKey10(hero.getKey10());
            heroDb.setValue10(hero.getValue10());
            heroDb.setKey11(hero.getKey11());
            heroDb.setValue11(hero.getValue11());
            heroDb.setKey12(hero.getKey12());
            heroDb.setValue12(hero.getValue12());
            heroDb.setKey13(hero.getKey13());
            heroDb.setValue13(hero.getValue13());
            heroDb.setKey14(hero.getKey14());
            heroDb.setValue14(hero.getValue14());
            heroDb.setKey15(hero.getKey15());
            heroDb.setValue15(hero.getValue15());


            return ResponseEntity.status(HttpStatus.CREATED).body(heroService.save(heroDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Hero> o = heroService.findById(id);
        if (o.isPresent()) {
            heroService.delete(o.get().getId());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/assign-user/{heroId}")
    public ResponseEntity<?> assignUser(@RequestBody User user, @PathVariable Long heroId) {
        Optional<User> o;
        try {
            o = heroService.assignUser(user, heroId );
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

    @PostMapping("/create-user/{heroId}")
    public ResponseEntity<?> createUser(@RequestBody User user, @PathVariable Long heroId) {
        Optional<User> o;
        try {
            o = heroService.createUser(user, heroId);
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

    @DeleteMapping("/delete-user/{heroId}")
    public ResponseEntity<?> deleteUser(@RequestBody User user, @PathVariable Long heroId) {
        Optional<User> o;
        try {
            o = heroService.deleteUser(user, heroId);
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

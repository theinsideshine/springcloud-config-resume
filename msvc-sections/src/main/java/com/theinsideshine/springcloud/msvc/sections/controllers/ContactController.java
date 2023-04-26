package com.theinsideshine.springcloud.msvc.sections.controllers;

import com.google.gson.JsonObject;
import com.theinsideshine.springcloud.msvc.sections.models.User;
import com.theinsideshine.springcloud.msvc.sections.models.entity.Contact;
import com.theinsideshine.springcloud.msvc.sections.services.ContactService;
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
@RequestMapping("/section/contact")
public class ContactController {

    private final static Logger LOGGER = Logger.getLogger("ContactController");

    @Autowired
    private ContactService contactService;

    @GetMapping
    public ResponseEntity<List<Contact>> list() {
        return ResponseEntity.ok(contactService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detail(@PathVariable Long id) {
        Optional<Contact> o = contactService.findByIdWithUser(id);//heroService.findById(id);
        if (o.isPresent()) {
            return ResponseEntity.ok(o.get());
        }
        return ResponseEntity.notFound().build();
    }



    @GetMapping("/data")
    public ResponseEntity<?> detailHero() {
        Optional<Contact> o = contactService.findByIdWithUser(1L);
        if (o.isPresent()) {
            JsonObject json = new JsonObject();
            json.addProperty(o.get().getKey1(),o.get().getValue1());
            json.addProperty(o.get().getKey2(),o.get().getValue2());
            json.addProperty(o.get().getKey3(),o.get().getValue3());
            json.addProperty(o.get().getKey4(),o.get().getValue4());
            json.addProperty(o.get().getKey5(),o.get().getValue5());
            json.addProperty(o.get().getKey6(),o.get().getValue6());
            json.addProperty(o.get().getKey7(),o.get().getValue7());
            json.addProperty(o.get().getKey8(),o.get().getValue8());
            json.addProperty(o.get().getKey9(),o.get().getUsers().get(0).getEmail());
            json.addProperty(o.get().getKey10(),o.get().getUsers().get(0).getLocation()+","+
                    o.get().getUsers().get(0).getCity()+","+
                    o.get().getUsers().get(0).getCountry());
            json.addProperty(o.get().getKey11(),o.get().getUsers().get(0).getLocationLink());
            json.addProperty(o.get().getKey12(),o.get().getUsers().get(0).getIg());
            json.addProperty(o.get().getKey13(),o.get().getUsers().get(0).getIgLink());
            json.addProperty(o.get().getKey14(),o.get().getUsers().get(0).getGithub());
            json.addProperty(o.get().getKey15(),o.get().getUsers().get(0).getGithubLink());

            LOGGER.log(Level.INFO, "GET Contact");
            return ( new ResponseEntity<>(json.toString(), HttpStatus.OK));

        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@Valid @RequestBody Contact contact, BindingResult result) {

        if (result.hasErrors()) {
            return validate(result);
        }
        Contact contactDb = contactService.save(contact);
        return ResponseEntity.status(HttpStatus.CREATED).body(contactDb);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@Valid @RequestBody Contact contact, @PathVariable Long id, BindingResult result) {

        if (result.hasErrors()) {
            return validate(result);
        }
        Optional<Contact> o = contactService.findById(id);
        if (o.isPresent()) {
            Contact contactDb = o.get();
            contactDb.setKey1(contact.getKey1());
            contactDb.setValue1(contact.getValue1());
            contactDb.setKey2(contact.getKey2());
            contactDb.setValue2(contact.getValue2());
            contactDb.setKey3(contact.getKey3());
            contactDb.setValue3(contact.getValue3());
            contactDb.setKey4(contact.getKey4());
            contactDb.setValue4(contact.getValue4());
            contactDb.setKey5(contact.getKey5());
            contactDb.setValue5(contact.getValue5());
            contactDb.setKey6(contact.getKey6());
            contactDb.setValue6(contact.getValue6());
            contactDb.setKey7(contact.getKey7());
            contactDb.setValue7(contact.getValue7());
            contactDb.setKey8(contact.getKey8());
            contactDb.setValue8(contact.getValue8());
            contactDb.setKey9(contact.getKey9());
            contactDb.setValue9(contact.getValue9());
            contactDb.setKey10(contact.getKey10());
            contactDb.setValue10(contact.getValue10());
            contactDb.setKey11(contact.getKey11());
            contactDb.setValue11(contact.getValue11());
            contactDb.setKey12(contact.getKey12());
            contactDb.setValue12(contact.getValue12());
            contactDb.setKey13(contact.getKey13());
            contactDb.setValue13(contact.getValue13());
            contactDb.setKey14(contact.getKey14());
            contactDb.setValue14(contact.getValue14());
            contactDb.setKey15(contact.getKey15());
            contactDb.setValue15(contact.getValue15());


            return ResponseEntity.status(HttpStatus.CREATED).body(contactService.save(contactDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Contact> o = contactService.findById(id);
        if (o.isPresent()) {
            contactService.delete(o.get().getId());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/assign-user/{contactId}")
    public ResponseEntity<?> assignUser(@RequestBody User user, @PathVariable Long contactId) {
        Optional<User> o;
        try {
            o = contactService.assignUser(user, contactId );
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

    @PostMapping("/create-user/{contactId}")
    public ResponseEntity<?> createUser(@RequestBody User user, @PathVariable Long contactId) {
        Optional<User> o;
        try {
            o = contactService.createUser(user, contactId);
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

    @DeleteMapping("/delete-user/{contactId}")
    public ResponseEntity<?> deleteUser(@RequestBody User user, @PathVariable Long contactId) {
        Optional<User> o;
        try {
            o = contactService.deleteUser(user, contactId);
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

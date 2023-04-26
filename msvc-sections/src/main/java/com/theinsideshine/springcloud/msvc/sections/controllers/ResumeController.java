package com.theinsideshine.springcloud.msvc.sections.controllers;

import com.google.gson.JsonObject;
import com.theinsideshine.springcloud.msvc.sections.models.User;
import com.theinsideshine.springcloud.msvc.sections.models.entity.About;
import com.theinsideshine.springcloud.msvc.sections.models.entity.Resume;
import com.theinsideshine.springcloud.msvc.sections.services.AboutService;
import com.theinsideshine.springcloud.msvc.sections.services.ResumeService;
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
@RequestMapping("/section/resume")
public class ResumeController {

    private final static Logger LOGGER = Logger.getLogger("ResumeController");

    @Autowired
    private ResumeService resumeService;

    @GetMapping
    public ResponseEntity<List<Resume>> list() {
        return ResponseEntity.ok(resumeService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detail(@PathVariable Long id) {
        Optional<Resume> o = resumeService.findByIdWithUser(id);//heroService.findById(id);
        if (o.isPresent()) {
            return ResponseEntity.ok(o.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/data")
    public ResponseEntity<?> detaildata() {
        Optional<Resume> o = resumeService.findByIdWithUser(1L);
        if (o.isPresent()) {
            JsonObject json = new JsonObject();
            json.addProperty(o.get().getKey1(), o.get().getValue1()); //EDUCATION
            json.addProperty(o.get().getKey2(), o.get().getValue2());
            json.addProperty(o.get().getKey3(),o.get().getValue3());

            json.addProperty(o.get().getKey4(),o.get().getValue4());
            json.addProperty(o.get().getKey5(),o.get().getUsers().get(0).getStudy());
            json.addProperty(o.get().getKey6(),o.get().getValue6());
            json.addProperty(o.get().getKey7(),o.get().getValue7());

            json.addProperty(o.get().getKey8(),o.get().getValue8());
            json.addProperty(o.get().getKey9(),o.get().getUsers().get(0).getStudy());
            json.addProperty(o.get().getKey10(),o.get().getUsers().get(0).getTechniqueGraduation());
            json.addProperty(o.get().getKey11(),o.get().getValue11());

            json.addProperty(o.get().getKey12(),o.get().getValue12());
            json.addProperty(o.get().getKey13(),o.get().getUsers().get(0).getEmployment()); //CDT Soluciones Tecnologica
            json.addProperty(o.get().getKey14(),o.get().getValue14());
            json.addProperty(o.get().getKey15(),o.get().getValue15());

            json.addProperty(o.get().getKey16(), o.get().getValue16());
            json.addProperty(o.get().getKey17(), o.get().getValue17());
            json.addProperty(o.get().getKey18(),o.get().getValue18());
            json.addProperty(o.get().getKey19(),o.get().getValue19());

            json.addProperty(o.get().getKey20(), o.get().getValue20());
            json.addProperty(o.get().getKey21(), o.get().getValue21()); //Intelektron
            json.addProperty(o.get().getKey22(),o.get().getValue22());
            json.addProperty(o.get().getKey23(),o.get().getValue23());

            json.addProperty(o.get().getKey24(), o.get().getValue24()); //Languages
            json.addProperty(o.get().getKey25(), o.get().getValue25());
            json.addProperty(o.get().getKey26(),o.get().getValue26());
            json.addProperty(o.get().getKey27(),o.get().getValue27());
            json.addProperty(o.get().getKey28(),o.get().getValue28());

            json.addProperty(o.get().getKey29(), o.get().getValue29()); //Frontend development
            json.addProperty(o.get().getKey30(), o.get().getValue30());
            json.addProperty(o.get().getKey31(),o.get().getValue31());
            json.addProperty(o.get().getKey32(),o.get().getValue32());
            json.addProperty(o.get().getKey33(),o.get().getValue33());
            json.addProperty(o.get().getKey34(),o.get().getValue34());
            json.addProperty(o.get().getKey35(),o.get().getValue35());
            json.addProperty(o.get().getKey36(),o.get().getValue36());
            json.addProperty(o.get().getKey37(),o.get().getValue37());

            json.addProperty(o.get().getKey38(), o.get().getValue38()); //Backend development
            json.addProperty(o.get().getKey39(), o.get().getValue39());
            json.addProperty(o.get().getKey40(),o.get().getValue40());
            json.addProperty(o.get().getKey41(),o.get().getValue41());
            json.addProperty(o.get().getKey42(),o.get().getValue42());
            json.addProperty(o.get().getKey43(),o.get().getValue43());
            json.addProperty(o.get().getKey44(),o.get().getValue44());
            json.addProperty(o.get().getKey45(),o.get().getValue45());
            json.addProperty(o.get().getKey46(),o.get().getValue46());

            json.addProperty(o.get().getKey47(), o.get().getValue47()); //Data base
            json.addProperty(o.get().getKey48(), o.get().getValue48());
            json.addProperty(o.get().getKey49(),o.get().getValue49());
            json.addProperty(o.get().getKey50(),o.get().getValue50());
            json.addProperty(o.get().getKey51(),o.get().getValue51());
            json.addProperty(o.get().getKey52(),o.get().getValue52());
            json.addProperty(o.get().getKey53(),o.get().getValue53());

            json.addProperty(o.get().getKey54(), o.get().getValue54()); //Embedded electronics
            json.addProperty(o.get().getKey55(), o.get().getValue55());
            json.addProperty(o.get().getKey56(),o.get().getValue56());
            json.addProperty(o.get().getKey57(),o.get().getValue57());
            json.addProperty(o.get().getKey58(),o.get().getValue58());
            json.addProperty(o.get().getKey59(),o.get().getValue59());
            json.addProperty(o.get().getKey60(),o.get().getValue60());


            json.addProperty(o.get().getKey61(), o.get().getValue61()); //Compilator
            json.addProperty(o.get().getKey62(), o.get().getValue62());
            json.addProperty(o.get().getKey63(),o.get().getValue63());
            json.addProperty(o.get().getKey64(),o.get().getValue64());
            json.addProperty(o.get().getKey65(),o.get().getValue65());
            json.addProperty(o.get().getKey66(),o.get().getValue66());
            json.addProperty(o.get().getKey67(),o.get().getValue67());

            LOGGER.log(Level.INFO, "GET Resume");
            return ( new ResponseEntity<>(json.toString(), HttpStatus.OK));

        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@Valid @RequestBody Resume resume, BindingResult result) {

        if (result.hasErrors()) {
            return validate(result);
        }
        Resume resumeDb = resumeService.save(resume);
        return ResponseEntity.status(HttpStatus.CREATED).body(resumeDb);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@Valid @RequestBody Resume resume, @PathVariable Long id, BindingResult result) {

        if (result.hasErrors()) {
            return validate(result);
        }
        Optional<Resume> o = resumeService.findById(id);
        if (o.isPresent()) {
            Resume resumeDb = o.get();
            resumeDb.setKey1(resume.getKey1());
            resumeDb.setValue1(resume.getValue1());
            resumeDb.setKey2(resume.getKey2());
            resumeDb.setValue2(resume.getValue2());
            resumeDb.setKey3(resume.getKey3());
            resumeDb.setValue3(resume.getValue3());
            resumeDb.setKey4(resume.getKey4());
            resumeDb.setValue4(resume.getValue4());
            resumeDb.setKey5(resume.getKey5());
            resumeDb.setValue5(resume.getValue5());
            resumeDb.setKey6(resume.getKey6());
            resumeDb.setValue6(resume.getValue6());
            resumeDb.setKey7(resume.getKey7());
            resumeDb.setValue7(resume.getValue7());
            resumeDb.setKey8(resume.getKey8());
            resumeDb.setValue8(resume.getValue8());
            resumeDb.setKey9(resume.getKey9());
            resumeDb.setValue9(resume.getValue9());
            resumeDb.setKey10(resume.getKey10());
            resumeDb.setValue10(resume.getValue10());
            resumeDb.setKey11(resume.getKey11());
            resumeDb.setValue11(resume.getValue11());
            resumeDb.setKey12(resume.getKey12());
            resumeDb.setValue12(resume.getValue12());
            resumeDb.setKey13(resume.getKey13());
            resumeDb.setValue13(resume.getValue13());
            resumeDb.setKey14(resume.getKey14());
            resumeDb.setValue14(resume.getValue14());
            resumeDb.setKey15(resume.getKey15());
            resumeDb.setValue15(resume.getValue15());
            resumeDb.setKey16(resume.getKey16());
            resumeDb.setValue16(resume.getValue16());
            resumeDb.setKey17(resume.getKey17());
            resumeDb.setValue17(resume.getValue17());
            resumeDb.setKey18(resume.getKey18());
            resumeDb.setValue18(resume.getValue18());
            resumeDb.setKey19(resume.getKey19());
            resumeDb.setValue19(resume.getValue19());
            resumeDb.setKey20(resume.getKey20());
            resumeDb.setValue20(resume.getValue20());
            resumeDb.setKey21(resume.getKey21());
            resumeDb.setValue21(resume.getValue21());
            resumeDb.setKey22(resume.getKey22());
            resumeDb.setValue22(resume.getValue22());
            resumeDb.setKey23(resume.getKey23());
            resumeDb.setValue23(resume.getValue23());
            resumeDb.setKey24(resume.getKey24());
            resumeDb.setValue24(resume.getValue24());
            resumeDb.setKey25(resume.getKey25());
            resumeDb.setValue25(resume.getValue25());
            resumeDb.setKey26(resume.getKey26());
            resumeDb.setValue26(resume.getValue26());
            resumeDb.setKey27(resume.getKey27());
            resumeDb.setValue27(resume.getValue27());
            resumeDb.setKey28(resume.getKey28());
            resumeDb.setValue28(resume.getValue28());
            resumeDb.setKey29(resume.getKey29());
            resumeDb.setValue29(resume.getValue29());
            resumeDb.setKey30(resume.getKey30());
            resumeDb.setValue30(resume.getValue30());
            resumeDb.setKey31(resume.getKey31());
            resumeDb.setValue31(resume.getValue31());
            resumeDb.setKey32(resume.getKey32());
            resumeDb.setValue32(resume.getValue32());
            resumeDb.setKey33(resume.getKey33());
            resumeDb.setValue33(resume.getValue33());
            resumeDb.setKey34(resume.getKey34());
            resumeDb.setValue34(resume.getValue34());
            resumeDb.setKey35(resume.getKey35());
            resumeDb.setValue35(resume.getValue35());
            resumeDb.setKey36(resume.getKey36());
            resumeDb.setValue36(resume.getValue36());
            resumeDb.setKey37(resume.getKey37());
            resumeDb.setValue37(resume.getValue37());
            resumeDb.setKey38(resume.getKey38());
            resumeDb.setValue38(resume.getValue38());
            resumeDb.setKey39(resume.getKey39());
            resumeDb.setValue39(resume.getValue39());
            resumeDb.setKey40(resume.getKey40());
            resumeDb.setValue40(resume.getValue40());
            resumeDb.setKey41(resume.getKey41());
            resumeDb.setValue41(resume.getValue41());
            resumeDb.setKey42(resume.getKey42());
            resumeDb.setValue42(resume.getValue42());
            resumeDb.setKey43(resume.getKey43());
            resumeDb.setValue43(resume.getValue43());
            resumeDb.setKey44(resume.getKey44());
            resumeDb.setValue44(resume.getValue44());
            resumeDb.setKey45(resume.getKey45());
            resumeDb.setValue45(resume.getValue45());
            resumeDb.setKey46(resume.getKey46());
            resumeDb.setValue46(resume.getValue46());
            resumeDb.setKey47(resume.getKey47());
            resumeDb.setValue47(resume.getValue47());
            resumeDb.setKey48(resume.getKey48());
            resumeDb.setValue48(resume.getValue48());
            resumeDb.setKey49(resume.getKey49());
            resumeDb.setValue49(resume.getValue49());
            resumeDb.setKey50(resume.getKey50());
            resumeDb.setValue50(resume.getValue50());
            resumeDb.setKey51(resume.getKey51());
            resumeDb.setValue51(resume.getValue51());
            resumeDb.setKey52(resume.getKey52());
            resumeDb.setValue52(resume.getValue52());
            resumeDb.setKey53(resume.getKey53());
            resumeDb.setValue53(resume.getValue53());
            resumeDb.setKey54(resume.getKey54());
            resumeDb.setValue54(resume.getValue54());
            resumeDb.setKey55(resume.getKey55());
            resumeDb.setValue55(resume.getValue55());
            resumeDb.setKey56(resume.getKey56());
            resumeDb.setValue56(resume.getValue56());
            resumeDb.setKey57(resume.getKey57());
            resumeDb.setValue57(resume.getValue57());
            resumeDb.setKey58(resume.getKey58());
            resumeDb.setValue58(resume.getValue58());
            resumeDb.setKey59(resume.getKey59());
            resumeDb.setValue59(resume.getValue59());
            resumeDb.setKey60(resume.getKey60());
            resumeDb.setValue60(resume.getValue60());
            resumeDb.setKey61(resume.getKey61());
            resumeDb.setValue61(resume.getValue61());
            resumeDb.setKey62(resume.getKey62());
            resumeDb.setValue62(resume.getValue62());
            resumeDb.setKey63(resume.getKey63());
            resumeDb.setValue63(resume.getValue63());
            resumeDb.setKey64(resume.getKey64());
            resumeDb.setValue64(resume.getValue64());
            resumeDb.setKey65(resume.getKey65());
            resumeDb.setValue65(resume.getValue65());
            resumeDb.setKey66(resume.getKey66());
            resumeDb.setValue66(resume.getValue66());
            resumeDb.setKey67(resume.getKey67());
            resumeDb.setValue67(resume.getValue67());


            return ResponseEntity.status(HttpStatus.CREATED).body(resumeService.save(resumeDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Resume> o = resumeService.findById(id);
        if (o.isPresent()) {
            resumeService.delete(o.get().getId());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/assign-user/{resumeId}")
    public ResponseEntity<?> assignUser(@RequestBody User user, @PathVariable Long resumeId) {
        Optional<User> o;
        try {
            o = resumeService.assignUser(user, resumeId );
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

    @PostMapping("/create-user/{resumeId}")
    public ResponseEntity<?> createUser(@RequestBody User user, @PathVariable Long resumeId) {
        Optional<User> o;
        try {
            o = resumeService.createUser(user, resumeId);
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

    @DeleteMapping("/delete-user/{resumeId}")
    public ResponseEntity<?> deleteUser(@RequestBody User user, @PathVariable Long resumeId) {
        Optional<User> o;
        try {
            o = resumeService.deleteUser(user, resumeId);
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

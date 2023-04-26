package com.theinsideshine.springcloud.msvc.sections.controllers;

import com.google.gson.JsonObject;
import com.theinsideshine.springcloud.msvc.sections.models.entity.Portfolio;
import com.theinsideshine.springcloud.msvc.sections.services.PortfolioService;
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
@RequestMapping("/section/portfolio")
public class PortfolioController {

    private final static Logger LOGGER = Logger.getLogger("PortfolioController");

    @Autowired
    private PortfolioService portfolioService;

    @GetMapping
    public ResponseEntity<List<Portfolio>> list() {
        return ResponseEntity.ok(portfolioService.list());
    }



    @GetMapping("/data")
    public ResponseEntity<?> detailHero() {
        Optional<Portfolio> o = portfolioService.findById(1L);
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
            json.addProperty(o.get().getKey9(),o.get().getValue9());
            json.addProperty(o.get().getKey10(),o.get().getValue10());
            json.addProperty(o.get().getKey11(),o.get().getValue11());
            json.addProperty(o.get().getKey12(),o.get().getValue12());
            json.addProperty(o.get().getKey13(),o.get().getValue13());
            json.addProperty(o.get().getKey14(),o.get().getValue14());
            json.addProperty(o.get().getKey15(),o.get().getValue15());
            json.addProperty(o.get().getKey16(),o.get().getValue16());
            json.addProperty(o.get().getKey17(),o.get().getValue17());
            json.addProperty(o.get().getKey18(),o.get().getValue18());
            json.addProperty(o.get().getKey19(),o.get().getValue19());
            json.addProperty(o.get().getKey20(),o.get().getValue20());
            json.addProperty(o.get().getKey21(),o.get().getValue21());
            json.addProperty(o.get().getKey22(),o.get().getValue22());
            json.addProperty(o.get().getKey23(),o.get().getValue23());
            json.addProperty(o.get().getKey24(),o.get().getValue24());
            json.addProperty(o.get().getKey25(),o.get().getValue25());
            json.addProperty(o.get().getKey26(),o.get().getValue26());
            json.addProperty(o.get().getKey27(),o.get().getValue27());
            json.addProperty(o.get().getKey28(),o.get().getValue28());
            json.addProperty(o.get().getKey29(),o.get().getValue29());
            json.addProperty(o.get().getKey30(),o.get().getValue30());
            json.addProperty(o.get().getKey31(),o.get().getValue31());
            json.addProperty(o.get().getKey32(),o.get().getValue32());
            json.addProperty(o.get().getKey33(),o.get().getValue33());
            json.addProperty(o.get().getKey34(),o.get().getValue34());
            LOGGER.log(Level.INFO, "GET portfolio");
            return ( new ResponseEntity<>(json.toString(), HttpStatus.OK));

        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@Valid @RequestBody Portfolio portfolio, BindingResult result) {

        if (result.hasErrors()) {
            return validate(result);
        }
        Portfolio portfolioDb = portfolioService.save(portfolio);
        return ResponseEntity.status(HttpStatus.CREATED).body(portfolioDb);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@Valid @RequestBody Portfolio portfolio, @PathVariable Long id, BindingResult result) {

        if (result.hasErrors()) {
            return validate(result);
        }
        Optional<Portfolio> o = portfolioService.findById(id);
        if (o.isPresent()) {
            Portfolio portfolioDb = o.get();
            portfolioDb.setKey1(portfolio.getKey1());
            portfolioDb.setValue1(portfolio.getValue1());
            portfolioDb.setKey2(portfolio.getKey2());
            portfolioDb.setValue2(portfolio.getValue2());
            portfolioDb.setKey3(portfolio.getKey3());
            portfolioDb.setValue3(portfolio.getValue3());
            portfolioDb.setKey4(portfolio.getKey4());
            portfolioDb.setValue4(portfolio.getValue4());
            portfolioDb.setKey5(portfolio.getKey5());
            portfolioDb.setValue5(portfolio.getValue5());
            portfolioDb.setKey6(portfolio.getKey6());
            portfolioDb.setValue6(portfolio.getValue6());
            portfolioDb.setKey7(portfolio.getKey7());
            portfolioDb.setValue7(portfolio.getValue7());
            portfolioDb.setKey8(portfolio.getKey8());
            portfolioDb.setValue8(portfolio.getValue8());
            portfolioDb.setKey9(portfolio.getKey9());
            portfolioDb.setValue9(portfolio.getValue9());
            portfolioDb.setKey10(portfolio.getKey10());
            portfolioDb.setValue10(portfolio.getValue10());
            portfolioDb.setKey11(portfolio.getKey11());
            portfolioDb.setValue11(portfolio.getValue11());
            portfolioDb.setKey12(portfolio.getKey12());
            portfolioDb.setValue12(portfolio.getValue12());
            portfolioDb.setKey13(portfolio.getKey13());
            portfolioDb.setValue13(portfolio.getValue13());
            portfolioDb.setKey14(portfolio.getKey14());
            portfolioDb.setValue14(portfolio.getValue14());
            portfolioDb.setKey15(portfolio.getKey15());
            portfolioDb.setValue15(portfolio.getValue15());
            portfolioDb.setKey16(portfolio.getKey16());
            portfolioDb.setValue16(portfolio.getValue16());
            portfolioDb.setKey17(portfolio.getKey17());
            portfolioDb.setValue17(portfolio.getValue17());
            portfolioDb.setKey18(portfolio.getKey18());
            portfolioDb.setValue18(portfolio.getValue18());
            portfolioDb.setKey19(portfolio.getKey19());
            portfolioDb.setValue19(portfolio.getValue19());
            portfolioDb.setKey20(portfolio.getKey20());
            portfolioDb.setValue20(portfolio.getValue20());
            portfolioDb.setKey21(portfolio.getKey21());
            portfolioDb.setValue21(portfolio.getValue21());
            portfolioDb.setKey22(portfolio.getKey22());
            portfolioDb.setValue22(portfolio.getValue22());
            portfolioDb.setKey23(portfolio.getKey23());
            portfolioDb.setValue23(portfolio.getValue23());
            portfolioDb.setKey24(portfolio.getKey24());
            portfolioDb.setValue24(portfolio.getValue24());
            portfolioDb.setKey25(portfolio.getKey25());
            portfolioDb.setValue25(portfolio.getValue25());
            portfolioDb.setKey26(portfolio.getKey26());
            portfolioDb.setValue26(portfolio.getValue26());
            portfolioDb.setKey27(portfolio.getKey27());
            portfolioDb.setValue27(portfolio.getValue27());
            portfolioDb.setKey28(portfolio.getKey28());
            portfolioDb.setValue28(portfolio.getValue28());
            portfolioDb.setKey29(portfolio.getKey29());
            portfolioDb.setValue29(portfolio.getValue29());
            portfolioDb.setKey30(portfolio.getKey30());
            portfolioDb.setValue30(portfolio.getValue30());
            portfolioDb.setKey31(portfolio.getKey31());
            portfolioDb.setValue31(portfolio.getValue31());
            portfolioDb.setKey32(portfolio.getKey32());
            portfolioDb.setValue32(portfolio.getValue32());
            portfolioDb.setKey33(portfolio.getKey33());
            portfolioDb.setValue33(portfolio.getValue33());
            portfolioDb.setKey34(portfolio.getKey34());
            portfolioDb.setValue34(portfolio.getValue34());



            return ResponseEntity.status(HttpStatus.CREATED).body(portfolioService.save(portfolioDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Portfolio> o = portfolioService.findById(id);
        if (o.isPresent()) {
            portfolioService.delete(o.get().getId());
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

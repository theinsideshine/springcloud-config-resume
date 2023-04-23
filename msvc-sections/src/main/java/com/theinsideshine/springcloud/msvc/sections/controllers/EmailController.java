package com.theinsideshine.springcloud.msvc.sections.controllers;

import com.google.gson.JsonObject;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import com.theinsideshine.springcloud.msvc.sections.models.EmailMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;



@CrossOrigin(origins =  "http://localhost:3000")
@RestController
@RequestMapping("sendEmail")
public class EmailController {

    private final static Logger LOGGER = Logger.getLogger("SendemailController");

    @PutMapping
    public ResponseEntity<String> getSendEmail(@RequestBody EmailMessage emailMessage) throws IOException {
        JsonObject json = new JsonObject();

        LOGGER.log(Level.INFO, "SEND Email Email: "+ emailMessage.email+" name: "+emailMessage.name+" message: "+ emailMessage.message);

        Email from = new Email("pablo.tavolaro@gmail.com"); //desde aca manda a to
        String subject = "Message of : "+emailMessage.name +" email: "+ emailMessage.email;
        Email to = new Email("educacion.ta@gmail.com"); // lo manda a este mail
        Content content = new Content("text/plain", emailMessage.message);
        Mail mail = new Mail(from, subject, to, content);


        Properties prop = loadPropertiesFile("configuration.properties");
        String codeBytes = prop.getProperty("key.sengrid");

        byte[] decodedBytes = Base64.getDecoder().decode(codeBytes);
        String decodedString = new String(decodedBytes);

        SendGrid sg = new SendGrid(decodedString);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());

            if (response.getStatusCode() == 202 ){
                return ( new ResponseEntity<>(response.toString(),HttpStatus.OK));
            }
            else {
                return ( new ResponseEntity<>(response.toString(),HttpStatus.CONFLICT));
            }



        } catch (IOException ex) {
            throw ex;
        }

    }

    private Properties loadPropertiesFile(String filePath) {
        Properties prop = new Properties();
        try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(filePath)) {
            prop.load(resourceAsStream);
        } catch (IOException e) {
            System.err.println("Unable to load properties file : " + filePath);
        }
        return prop;
    }

}

package com.theinsideshine.springcloud.msvc.users;

import com.theinsideshine.springcloud.msvc.users.models.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class Datas {



    public static Optional<User> crearUser001() {
         User usuario = new User (1L, "Pepe", "Pepe.fernandez@gmail.com", "Caba", "Argentine",
                "Caballito", "https://goo.gl/maps/i4UvTVHGuZoH2X8r9", "Argentine", "Electronic Engineer",
                "Senior Electronics Technician", "Mercantile Marine University", "46", "Technology, Music",
                "CDT Soluciones Tecnologicas", "@educacion.ta", "https://www.instagram.com/educacion.ta/", "theinsideshine",
                "https://github.com/theinsideshine", "theinsideshine", "https://www.youtube.com/channel/UClLTMbxqK8LLSWm4bOdyx5Q",
                "https://linkedin.com/in/andres-fernandez", "https://www.facebook.com/andresFernandez");

         Optional<User> optionalUser = Optional.of(usuario);

         return (optionalUser);
   }


    public static Optional<User> crearUser002() {
        User usuario = new User (2L, "Pepa", "Pepa.fernandez@gmail.com", "Caba", "Argentine",
                "Caballito", "https://goo.gl/maps/i4UvTVHGuZoH2X8r9", "Argentine", "Electronic Engineer",
                "Senior Electronics Technician", "Mercantile Marine University", "46", "Technology, Music",
                "CDT Soluciones Tecnologicas", "@educacion.ta", "https://www.instagram.com/educacion.ta/", "theinsideshine",
                "https://github.com/theinsideshine", "theinsideshine", "https://www.youtube.com/channel/UClLTMbxqK8LLSWm4bOdyx5Q",
                "https://linkedin.com/in/andres-fernandez", "https://www.facebook.com/andresFernandez");

        Optional<User> optionalUser = Optional.of(usuario);

        return (optionalUser);
    }

    public static User crearUser003() {
        User usuario = new User (3L, "Blanca", "Blanca.fernandez@gmail.com", "Caba", "Argentine",
                "Caballito", "https://goo.gl/maps/i4UvTVHGuZoH2X8r9", "Argentine", "Electronic Engineer",
                "Senior Electronics Technician", "Mercantile Marine University", "46", "Technology, Music",
                "CDT Soluciones Tecnologicas", "@educacion.ta", "https://www.instagram.com/educacion.ta/", "theinsideshine",
                "https://github.com/theinsideshine", "theinsideshine", "https://www.youtube.com/channel/UClLTMbxqK8LLSWm4bOdyx5Q",
                "https://linkedin.com/in/andres-fernandez", "https://www.facebook.com/andresFernandez");



        return (usuario);
    }

    public static Iterable<User> crearListUser() {
        User usuario1 = new User (1L, "javier", "javier.fernandez@gmail.com", "Caba", "Argentine",
                "Caballito", "https://goo.gl/maps/i4UvTVHGuZoH2X8r9", "Argentine", "Electronic Engineer",
                "Senior Electronics Technician", "Mercantile Marine University", "46", "Technology, Music",
                "CDT Soluciones Tecnologicas", "@educacion.ta", "https://www.instagram.com/educacion.ta/", "theinsideshine",
                "https://github.com/theinsideshine", "theinsideshine", "https://www.youtube.com/channel/UClLTMbxqK8LLSWm4bOdyx5Q",
                "https://linkedin.com/in/andres-fernandez", "https://www.facebook.com/andresFernandez");

        User usuario2 = new User (2L, "jimena", "jimena.fernandez@gmail.com", "Caba", "Argentine",
                "Caballito", "https://goo.gl/maps/i4UvTVHGuZoH2X8r9", "Argentine", "Electronic Engineer",
                "Senior Electronics Technician", "Mercantile Marine University", "46", "Technology, Music",
                "CDT Soluciones Tecnologicas", "@educacion.ta", "https://www.instagram.com/educacion.ta/", "theinsideshine",
                "https://github.com/theinsideshine", "theinsideshine", "https://www.youtube.com/channel/UClLTMbxqK8LLSWm4bOdyx5Q",
                "https://linkedin.com/in/andres-fernandez", "https://www.facebook.com/andresFernandez");

        User usuario3 = new User (3L, "joe", "joe.fernandez@gmail.com", "Caba", "Argentine",
                "Caballito", "https://goo.gl/maps/i4UvTVHGuZoH2X8r9", "Argentine", "Electronic Engineer",
                "Senior Electronics Technician", "Mercantile Marine University", "46", "Technology, Music",
                "CDT Soluciones Tecnologicas", "@educacion.ta", "https://www.instagram.com/educacion.ta/", "theinsideshine",
                "https://github.com/theinsideshine", "theinsideshine", "https://www.youtube.com/channel/UClLTMbxqK8LLSWm4bOdyx5Q",
                "https://linkedin.com/in/andres-fernandez", "https://www.facebook.com/andresFernandez");

        List<User> users = new ArrayList<User>();
        users.add(usuario1);
        users.add(usuario2);
        users.add(usuario3);


        return ((Iterable)users);
    }




}

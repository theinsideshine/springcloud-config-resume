package com.theinsideshine.springcloud.msvc.users.models;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user;

    private TestInfo testInfo;
    private TestReporter testReporter;

    @BeforeEach
    void initMetodoTest(TestInfo testInfo, TestReporter testReporter) {
        this.user = new User(1L, "andres", "andres.fernandez@gmail.com", "Caba", "Argentine",
                "Caballito", "https://goo.gl/maps/i4UvTVHGuZoH2X8r9", "Argentine", "Electronic Engineer",
                "Senior Electronics Technician", "Mercantile Marine University", "46", "Technology, Music",
                "CDT Soluciones Tecnologicas", "@educacion.ta", "https://www.instagram.com/educacion.ta/", "theinsideshine",
                "https://github.com/theinsideshine", "theinsideshine", "https://www.youtube.com/channel/UClLTMbxqK8LLSWm4bOdyx5Q",
                "https://linkedin.com/in/andres-fernandez", "https://www.facebook.com/andresFernandez");
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        System.out.println("iniciando el metodo.");
        testReporter.publishEntry(" ejecutando: " + testInfo.getDisplayName() + " " + testInfo.getTestMethod().orElse(null).getName()
                + " con las etiquetas " + testInfo.getTags());
    }



    @BeforeAll
    static void beforeAll() {
        System.out.println("inicializando el test");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("finalizando el test");
    }

    @Tag("user")
    @Nested
    @DisplayName("probando atributos de user")
    class UserTestName {
        @Test
        @DisplayName("name!")
        void testNameUser() {

            String real = user.getName();
            assertNotNull(real, () -> "la cuenta no puede ser nula");
            assertTrue(real.equals("andres"), () -> "nombre cuenta esperada debe ser igual a la real");
        }

        @Test
        @DisplayName("email!")
        void testEmailUser() {

            String expected = "andres.fernandez@gmail.com";
            String real = user.getEmail();
            assertNotNull(real, () -> "la cuenta no puede ser nula");
            assertEquals(expected, real, () -> "el nombre de la cuenta no es el que se esperaba: se esperaba " + expected
                    + " sin embargo fue " + real);
        }

        @Test
        @DisplayName("city!")
        void testCityUser() {

            String expected = "Caba";
            String real = user.getCity();
            assertNotNull(real, () -> "la cuenta no puede ser nula");
            assertEquals(expected, real, () -> "el nombre de la cuenta no es el que se esperaba: se esperaba " + expected
                    + " sin embargo fue " + real);
        }

        @Test
        @DisplayName("country!")
        void testCountryUser() {

            String expected = "Argentine";
            String real = user.getCountry();
            assertNotNull(real, () -> "la cuenta no puede ser nula");
            assertEquals(expected, real, () -> "el nombre de la cuenta no es el que se esperaba: se esperaba " + expected
                    + " sin embargo fue " + real);
        }

        @Test
        @DisplayName("location!")
        void testLocationUser() {

            String expected = "Caballito";
            String real = user.getLocation();
            assertNotNull(real, () -> "la cuenta no puede ser nula");
            assertEquals(expected, real, () -> "el nombre de la cuenta no es el que se esperaba: se esperaba " + expected
                    + " sin embargo fue " + real);
        }

        @Test
        @DisplayName("locationLink!")
        void testLocationlinkUser() {

            String expected = "https://goo.gl/maps/i4UvTVHGuZoH2X8r9";
            String real = user.getLocationLink();
            assertNotNull(real, () -> "la cuenta no puede ser nula");
            assertEquals(expected, real, () -> "el nombre de la cuenta no es el que se esperaba: se esperaba " + expected
                    + " sin embargo fue " + real);
        }

        @Test
        @DisplayName("nationality!")
        void testNationalityUser() {

            String expected = "Argentine";
            String real = user.getNationality();
            assertNotNull(real, () -> "la cuenta no puede ser nula");
            assertEquals(expected, real, () -> "el nombre de la cuenta no es el que se esperaba: se esperaba " + expected
                    + " sin embargo fue " + real);
        }

        @Test
        @DisplayName("graduation!")
        void testGraduationUser() {

            String expected = "Electronic Engineer";
            String real = user.getGraduation();
            assertNotNull(real, () -> "la cuenta no puede ser nula");
            assertEquals(expected, real, () -> "el nombre de la cuenta no es el que se esperaba: se esperaba " + expected
                    + " sin embargo fue " + real);
        }


        @Test
        @DisplayName("techniquegraduation!")
        void testTechniqueGraduationUser() {

            String expected = "Senior Electronics Technician";
            String real = user.getTechniqueGraduation();
            assertNotNull(real, () -> "la cuenta no puede ser nula");
            assertEquals(expected, real, () -> "el nombre de la cuenta no es el que se esperaba: se esperaba " + expected
                    + " sin embargo fue " + real);
        }


        @Test
        @DisplayName("study!")
        void testStudyUser() {

            String expected = "Mercantile Marine University";
            String real = user.getStudy();
            assertNotNull(real, () -> "la cuenta no puede ser nula");
            assertEquals(expected, real, () -> "el nombre de la cuenta no es el que se esperaba: se esperaba " + expected
                    + " sin embargo fue " + real);
        }

        @Test
        @DisplayName("age!")
        void testAgeUser() {

            String expected = "46";
            String real = user.getAge();
            assertNotNull(real, () -> "la cuenta no puede ser nula");
            assertEquals(expected, real, () -> "el nombre de la cuenta no es el que se esperaba: se esperaba " + expected
                    + " sin embargo fue " + real);
        }

        @Test
        @DisplayName("interests!")
        void testInterestsUser() {

            String expected = "Technology, Music";
            String real = user.getInterests();
            assertNotNull(real, () -> "la cuenta no puede ser nula");
            assertEquals(expected, real, () -> "el nombre de la cuenta no es el que se esperaba: se esperaba " + expected
                    + " sin embargo fue " + real);
        }

        @Test
        @DisplayName("employment!")
        void testEmploymentUser() {

            String expected = "CDT Soluciones Tecnologicas";
            String real = user.getEmployment();
            assertNotNull(real, () -> "la cuenta no puede ser nula");
            assertEquals(expected, real, () -> "el nombre de la cuenta no es el que se esperaba: se esperaba " + expected
                    + " sin embargo fue " + real);
        }

        @Test
        @DisplayName("ig!")
        void testIgUser() {

            String expected = "@educacion.ta";
            String real = user.getIg();
            assertNotNull(real, () -> "la cuenta no puede ser nula");
            assertEquals(expected, real, () -> "el nombre de la cuenta no es el que se esperaba: se esperaba " + expected
                    + " sin embargo fue " + real);
        }

        @Test
        @DisplayName("iglink!")
        void testIgLinkUser() {

            String expected = "https://www.instagram.com/educacion.ta/";
            String real = user.getIgLink();
            assertNotNull(real, () -> "la cuenta no puede ser nula");
            assertEquals(expected, real, () -> "el nombre de la cuenta no es el que se esperaba: se esperaba " + expected
                    + " sin embargo fue " + real);
        }

        @Test
        @DisplayName("youtube!")
        void testYoutubeUser() {

            String expected = "theinsideshine";
            String real = user.getYoutube();
            assertNotNull(real, () -> "la cuenta no puede ser nula");
            assertEquals(expected, real, () -> "el nombre de la cuenta no es el que se esperaba: se esperaba " + expected
                    + " sin embargo fue " + real);
        }

        @Test
        @DisplayName("githubLink!")
        void testGithubLinkUser() {

            String expected = "https://github.com/theinsideshine";
            String real = user.getGithubLink();
            assertNotNull(real, () -> "la cuenta no puede ser nula");
            assertEquals(expected, real, () -> "el nombre de la cuenta no es el que se esperaba: se esperaba " + expected
                    + " sin embargo fue " + real);
        }

        @Test
        @DisplayName("github!")
        void testGithubUser() {

            String expected = "theinsideshine";
            String real = user.getGithub();
            assertNotNull(real, () -> "la cuenta no puede ser nula");
            assertEquals(expected, real, () -> "el nombre de la cuenta no es el que se esperaba: se esperaba " + expected
                    + " sin embargo fue " + real);
        }

        @Test
        @DisplayName("youtubelink!")
        void testYoutubeLinkUser() {

            String expected = "https://www.youtube.com/channel/UClLTMbxqK8LLSWm4bOdyx5Q";
            String real = user.getYoutubeLink();
            assertNotNull(real, () -> "la cuenta no puede ser nula");
            assertEquals(expected, real, () -> "el nombre de la cuenta no es el que se esperaba: se esperaba " + expected
                    + " sin embargo fue " + real);
        }

        @Test
        @DisplayName("linkedinlink!")
        void testLinkedinLinkUser() {

            String expected = "https://linkedin.com/in/andres-fernandez";
            String real = user.getLinkedinLink();
            assertNotNull(real, () -> "la cuenta no puede ser nula");
            assertEquals(expected, real, () -> "el nombre de la cuenta no es el que se esperaba: se esperaba " + expected
                    + " sin embargo fue " + real);
        }

        @Test
        @DisplayName("facebookLink!")
        void testFacebookLinkUser() {

            String expected = "https://www.facebook.com/andresFernandez";
            String real = user.getFacebookLink();
            assertNotNull(real, () -> "la cuenta no puede ser nula");
            assertEquals(expected, real, () -> "el nombre de la cuenta no es el que se esperaba: se esperaba " + expected
                    + " sin embargo fue " + real);
        }


    }


}

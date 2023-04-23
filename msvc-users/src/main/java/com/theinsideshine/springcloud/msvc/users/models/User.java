package com.theinsideshine.springcloud.msvc.users.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotEmpty
    @Email
    @Column(unique = true)
    private String email;


    @NotBlank
    private String city;

    @NotBlank
    private String country;


    @NotBlank
    private String location;

    @Column(name="location_link")
    @NotBlank
    private String locationLink;

    @NotBlank
    private String nationality;

    @NotBlank// no vacio y no en blanco
    private String graduation;

    @Column(name="technique_graduation")
    @NotBlank// no vacio y no en blanco
    private String techniqueGraduation;
    @NotBlank// no vacio y no en blanco
    private String study;

    @NotBlank// no vacio y no en blanco
    private String age;

    @NotBlank// no vacio y no en blanco
    private String interests;

    @NotBlank// no vacio y no en blanco
    private String employment;

    @NotBlank// no vacio y no en blanco
    private String ig;


    @Column(name="ig_link")
    @NotBlank
    private String igLink;
    @NotBlank// no vacio y no en blanco
    private String github;

    @Column(name="github_link")
    @NotBlank
    private String githubLink;

    @NotBlank// no vacio y no en blanco
    private String youtube;

    @Column(name="youtube_link")
    @NotBlank
    private String youtubeLink;

    @Column(name="linkedin_link")
    @NotBlank
    private String linkedinLink;

    @Column(name="facebook_link")
    @NotBlank
    private String facebookLink;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocationLink() {
        return locationLink;
    }

    public void setLocationLink(String locationLink) {
        this.locationLink = locationLink;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getGraduation() {
        return graduation;
    }

    public void setGraduation(String graduation) {
        this.graduation = graduation;
    }

    public String getTechniqueGraduation() {
        return techniqueGraduation;
    }

    public void setTechniqueGraduation(String techniqueGraduation) {
        this.techniqueGraduation = techniqueGraduation;
    }

    public String getStudy() {
        return study;
    }

    public void setStudy(String study) {
        this.study = study;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getEmployment() {
        return employment;
    }

    public void setEmployment(String employment) {
        this.employment = employment;
    }

    public String getIg() {
        return ig;
    }

    public void setIg(String ig) {
        this.ig = ig;
    }

    public String getIgLink() {
        return igLink;
    }

    public void setIgLink(String igLink) {
        this.igLink = igLink;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getGithubLink() {
        return githubLink;
    }

    public void setGithubLink(String githubLink) {
        this.githubLink = githubLink;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    public String getLinkedinLink() {
        return linkedinLink;
    }

    public void setLinkedinLink(String linkedinLink) {
        this.linkedinLink = linkedinLink;
    }

    public String getFacebookLink() {
        return facebookLink;
    }

    public void setFacebookLink(String facebookLink) {
        this.facebookLink = facebookLink;
    }
}

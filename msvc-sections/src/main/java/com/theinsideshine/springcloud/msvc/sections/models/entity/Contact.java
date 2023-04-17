package com.theinsideshine.springcloud.msvc.sections.models.entity;

import com.theinsideshine.springcloud.msvc.sections.models.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="contacts")
public class Contact {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "contact_id")
    private List<ContactUser> contactUsers;

    @Transient
    private List<User> users;

    public Contact() {
        contactUsers = new ArrayList<>();
        users = new ArrayList<>();
    }




    @NotBlank
    private String key1;

    @NotBlank
    private String value1;

    @NotBlank
    private String key2;

    @NotBlank
    private String value2;

    @NotBlank
    private String key3;

    @NotBlank
    private String value3;

    @NotBlank
    private String key4;

    @NotBlank
    private String value4;

    @NotBlank
    private String key5;

    @NotBlank
    private String value5;

    @NotBlank
    private String key6;

    @NotBlank
    private String value6;

    @NotBlank
    private String key7;

    @NotBlank
    private String value7;

    @NotBlank
    private String key8;

    @NotBlank
    private String value8;

    @NotBlank
    private String key9;

    @NotBlank
    private String value9;

    @NotBlank
    private String key10;

    @NotBlank
    private String value10;

    @NotBlank
    private String key11;

    @NotBlank
    private String value11;

    @NotBlank
    private String key12;

    @NotBlank
    private String value12;

    @NotBlank
    private String key13;

    @NotBlank
    private String value13;

    @NotBlank
    private String key14;

    @NotBlank
    private String value14;

    @NotBlank
    private String key15;

    @NotBlank
    private String value15;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getKey2() {
        return key2;
    }

    public void setKey2(String key2) {
        this.key2 = key2;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String getKey3() {
        return key3;
    }

    public void setKey3(String key3) {
        this.key3 = key3;
    }

    public String getValue3() {
        return value3;
    }

    public void setValue3(String value3) {
        this.value3 = value3;
    }

    public String getKey4() {
        return key4;
    }

    public void setKey4(String key4) {
        this.key4 = key4;
    }

    public String getValue4() {
        return value4;
    }

    public void setValue4(String value4) {
        this.value4 = value4;
    }

    public String getKey5() {
        return key5;
    }

    public void setKey5(String key5) {
        this.key5 = key5;
    }

    public String getValue5() {
        return value5;
    }

    public void setValue5(String value5) {
        this.value5 = value5;
    }

    public String getKey6() {
        return key6;
    }

    public void setKey6(String key6) {
        this.key6 = key6;
    }

    public String getValue6() {
        return value6;
    }

    public void setValue6(String value6) {
        this.value6 = value6;
    }

    public String getKey7() {
        return key7;
    }

    public void setKey7(String key7) {
        this.key7 = key7;
    }

    public String getValue7() {
        return value7;
    }

    public void setValue7(String value7) {
        this.value7 = value7;
    }

    public String getKey8() {
        return key8;
    }

    public void setKey8(String key8) {
        this.key8 = key8;
    }

    public String getValue8() {
        return value8;
    }

    public void setValue8(String value8) {
        this.value8 = value8;
    }

    public String getKey9() {
        return key9;
    }

    public void setKey9(String key9) {
        this.key9 = key9;
    }

    public String getValue9() {
        return value9;
    }

    public void setValue9(String value9) {
        this.value9 = value9;
    }

    public String getKey10() {
        return key10;
    }

    public void setKey10(String key10) {
        this.key10 = key10;
    }

    public String getValue10() {
        return value10;
    }

    public void setValue10(String value10) {
        this.value10 = value10;
    }

    public String getKey11() {
        return key11;
    }

    public void setKey11(String key11) {
        this.key11 = key11;
    }

    public String getValue11() {
        return value11;
    }

    public void setValue11(String value11) {
        this.value11 = value11;
    }

    public String getKey12() {
        return key12;
    }

    public void setKey12(String key12) {
        this.key12 = key12;
    }

    public String getValue12() {
        return value12;
    }

    public void setValue12(String value12) {
        this.value12 = value12;
    }

    public String getKey13() {
        return key13;
    }

    public void setKey13(String key13) {
        this.key13 = key13;
    }

    public String getValue13() {
        return value13;
    }

    public void setValue13(String value13) {
        this.value13 = value13;
    }

    public String getKey14() {
        return key14;
    }

    public void setKey14(String key14) {
        this.key14 = key14;
    }

    public String getValue14() {
        return value14;
    }

    public void setValue14(String value14) {
        this.value14 = value14;
    }

    public String getKey15() {
        return key15;
    }

    public void setKey15(String key15) {
        this.key15 = key15;
    }

    public String getValue15() {
        return value15;
    }

    public void setValue15(String value15) {
        this.value15 = value15;
    }

    public void addContactUser(ContactUser contactUser) {
        contactUsers.add(contactUser);
    }



    public void removeContactUser(ContactUser contactUser) {
        contactUsers.remove(contactUser); // aca use la comparacion sobreescribir en cursoUsers el equals
    }

    public List<ContactUser> getContactUsers() {
        return contactUsers;
    }

    public void setContactUsers(List<ContactUser> contactUsers) {
        this.contactUsers = contactUsers;
    }


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

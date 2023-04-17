package com.theinsideshine.springcloud.msvc.sections.models.entity;

import javax.persistence.*;

@Entity
@Table(name="contacts_users")
public class ContactUser {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_id", unique = true)
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContactUser)) {
            return false;
        }
        ContactUser o = (ContactUser) obj;
        return this.userId != null && this.userId.equals(o.userId);
    }
}

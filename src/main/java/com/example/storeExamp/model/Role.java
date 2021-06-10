package com.example.storeExamp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

    @Entity
    @Data
    @Table(name = "roles")
    public class Role {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "name")
        private String name;

        @ManyToMany
        @JoinTable(name = "users_roles",
                inverseJoinColumns = @JoinColumn(name = "user_id"),
                joinColumns = @JoinColumn(name = "role_id"))
        private Collection<User> users;
    }


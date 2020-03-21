package com.threadjava.models;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User extends BaseEntity {

    @Column(name = "email")
    public String email;

    @Column(name = "username")
    public String username;

    @Column(name = "password")
    public String password;

    @ManyToOne(optional = true, fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "avatars_id")
    public Image avatar;
}

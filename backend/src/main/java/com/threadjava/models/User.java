package com.threadjava.models;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "email")
    @Getter @Setter private String email;

    @Column(name = "username")
    @Getter @Setter private String username;

    @Column(name = "password")
    @Getter @Setter private String password;

    @ManyToOne(optional = true, fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "avatars_id")
    @Getter @Setter private Image avatar;
}

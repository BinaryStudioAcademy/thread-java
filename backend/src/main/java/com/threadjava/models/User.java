package com.threadjava.models;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "email")
    @Getter @Setter public String email;

    @Column(name = "username")
    @Getter @Setter public String username;

    @Column(name = "password")
    @Getter @Setter public String password;

    @ManyToOne(optional = true, fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "avatars_id")
    @Getter @Setter public Image avatar;
}

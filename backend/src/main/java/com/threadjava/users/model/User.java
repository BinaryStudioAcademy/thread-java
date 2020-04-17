package com.threadjava.users.model;

import com.threadjava.models.BaseEntity;
import com.threadjava.image.model.Image;
import lombok.*;
import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
@Table(name = "users")
public class User extends BaseEntity {
    @Column(name = "email", unique=true)
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @ManyToOne(optional = true, fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "avatars_id")
    private Image avatar;
}

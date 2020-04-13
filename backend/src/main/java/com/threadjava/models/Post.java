package com.threadjava.models;

import com.threadjava.comment.model.Comment;
import com.threadjava.image.model.Image;
import com.threadjava.users.model.User;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "post")
public class Post extends BaseEntity {

    @Column(name = "body")
    @Getter @Setter public String body;

    @ManyToOne(optional = true, fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "images_id")
    @Getter @Setter public Image image;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "users_id")
    @Getter @Setter public User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Getter @Setter public List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Getter @Setter public List<PostReaction> reactions = new ArrayList<>();
}
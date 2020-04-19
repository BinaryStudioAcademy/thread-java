package com.threadjava.post.model;

import com.threadjava.comment.model.Comment;
import com.threadjava.image.model.Image;
import com.threadjava.db.BaseEntity;
import com.threadjava.postReactions.model.PostReaction;
import com.threadjava.users.model.User;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
@Table(name = "post")
public class Post extends BaseEntity {

    @Column(name = "body", columnDefinition="TEXT")
    private String body;

    @ManyToOne(optional = true, fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "images_id")
    private Image image;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "users_id")
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PostReaction> reactions = new ArrayList<>();
}
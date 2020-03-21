package com.threadjava.post;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post {
    @Id
    public Long postId;
    public Long authorId;
    public String body;
}

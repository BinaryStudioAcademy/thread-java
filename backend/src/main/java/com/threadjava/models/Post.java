package com.threadjava.models;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post extends BaseEntity {

    public Long authorId;

    @Column(name = "body")
    public String body;
}

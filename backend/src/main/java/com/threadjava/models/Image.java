package com.threadjava.models;

import javax.persistence.*;

@Entity
@Table(name = "image")
public class Image extends BaseEntity {

    @Column(name = "URL")
    public String URL;
}

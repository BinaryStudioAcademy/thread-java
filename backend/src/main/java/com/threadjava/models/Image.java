package com.threadjava.models;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "image")
public class Image extends BaseEntity {

    @Column(name = "URL")
    @Getter @Setter public String URL;
}

package com.threadjava.models;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "image")
public class Image extends BaseEntity {

    @Column(name = "link", nullable = false)
    @Getter @Setter public String link;

    @Column(name = "delete_hash", nullable = false)
    @Getter @Setter public String deleteHash;
}

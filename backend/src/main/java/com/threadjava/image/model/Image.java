package com.threadjava.image.model;

import com.threadjava.models.BaseEntity;
import lombok.*;
import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
@Table(name = "image")
public class Image extends BaseEntity {

    @Column(name = "link", nullable = false)
    private String link;

    @Column(name = "delete_hash", nullable = false)
    private String deleteHash;
}

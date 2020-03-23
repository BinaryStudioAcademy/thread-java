package com.threadjava.models;

import lombok.*;
import javax.persistence.*;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="ID_SEQ")
    @SequenceGenerator(name="ID_SEQ", sequenceName="ID_SEQ",allocationSize=1)
    @Getter @Setter public Long id;

}

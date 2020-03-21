package com.threadjava.models;

import javax.persistence.*;

@MappedSuperclass
public class BaseEntity {
    private Long id;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="ID_SEQ")
    @SequenceGenerator(name="ID_SEQ", sequenceName="ID_SEQ",allocationSize=1)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}

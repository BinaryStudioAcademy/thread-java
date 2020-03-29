package com.threadjava.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    @Getter @Setter public UUID id;

    @Column(name = "`timestamp`")
    @CreationTimestamp
    @Getter @Setter public Date createdAt;

    @Column(name = "updated_on")
    @UpdateTimestamp
    @Getter @Setter public Date updatedAt;
}

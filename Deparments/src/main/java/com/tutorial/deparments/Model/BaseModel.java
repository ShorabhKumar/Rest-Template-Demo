package com.tutorial.deparments.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import lombok.Data;

@MappedSuperclass
@Getter
@Setter
public class BaseModel {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQ")
    @SequenceGenerator(name = "ID_SEQ", sequenceName = "id_seq", allocationSize = 1)
    private Long id;

    @Column(name="created_at")
    @CreationTimestamp
    private Date createdAt;

    @Column(name="updated_at")
    @UpdateTimestamp
    private Date updatedAt;

    @Column(name="is_deleted")
    private Boolean isDeleted;
}

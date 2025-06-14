package com.example.user.core.base.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseAbstractAuditableEntity implements Serializable {

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate;


    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime lastModifiedDate;

    @CreatedBy
    @Column(updatable = false)
    private Long createdBy;

    @LastModifiedBy
    private Long lastModifiedBy;

}

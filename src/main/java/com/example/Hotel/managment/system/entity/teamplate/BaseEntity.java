/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:14.10.2024
 * TIME:9:54
 */
package com.example.Hotel.managment.system.entity.teamplate;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
@MappedSuperclass
@EntityListeners(AutoCloseable.class)
public class BaseEntity {

    @OrderBy
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }


}


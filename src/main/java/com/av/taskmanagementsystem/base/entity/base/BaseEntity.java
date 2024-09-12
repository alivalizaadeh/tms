package com.av.taskmanagementsystem.base.entity.base;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Setter
@Getter
@NoArgsConstructor
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Version
    @NotNull
    @Column(name = "version", nullable = false)
    private Long version;

    @CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false)
    @Setter(value = AccessLevel.NONE)
    private Date createdDate;

    @LastModifiedDate
    @Column(name = "updated_date")
    @Setter(value = AccessLevel.NONE)
    private Date updatedDate;

    @Column(name = "IS_DELETED", nullable = false)
    private boolean isDeleted = false;

    @Column(name = "IS_ENABLED", nullable = false)
    private boolean isEnabled = true;

    @PrePersist
    public void prePersist() {
        this.createdDate = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedDate = new Date();
    }
}

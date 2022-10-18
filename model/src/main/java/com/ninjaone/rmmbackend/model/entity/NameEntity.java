package com.ninjaone.rmmbackend.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Data
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public abstract class NameEntity extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

}

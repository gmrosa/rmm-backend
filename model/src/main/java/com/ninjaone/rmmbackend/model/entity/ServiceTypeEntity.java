package com.ninjaone.rmmbackend.model.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@Entity(name = "SERVICE_TYPE")
@EqualsAndHashCode(callSuper = true)
public class ServiceTypeEntity extends NameEntity {

}


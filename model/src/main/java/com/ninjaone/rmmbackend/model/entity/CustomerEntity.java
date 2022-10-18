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
@Entity(name = "CUSTOMER")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class CustomerEntity extends NameEntity {

}


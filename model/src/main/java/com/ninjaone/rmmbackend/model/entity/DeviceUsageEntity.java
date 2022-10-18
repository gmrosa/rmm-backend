package com.ninjaone.rmmbackend.model.entity;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Entity(name = "DEVICE_USAGE")
@EqualsAndHashCode(callSuper = true)
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"customer_id", "device_id"})})
public class DeviceUsageEntity extends BaseEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
    @ManyToOne(optional = false)
    @JoinColumn(name = "device_id")
    private DeviceEntity device;
    @Column(nullable = false)
    private Integer quantity;

}


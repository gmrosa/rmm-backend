package com.ninjaone.rmmbackend.model.entity;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "SERVICE")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"service_type_id", "device_type_id"})})
public class ServiceEntity extends BaseEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "service_type_id")
    private ServiceTypeEntity serviceType;
    @ManyToOne
    @JoinColumn(name = "device_type_id")
    private DeviceTypeEntity deviceType;
    @Column(nullable = false)
    private Float price;

}


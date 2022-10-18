package com.ninjaone.rmmbackend.model.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@Entity(name = "SERVICE_USAGE")
@EqualsAndHashCode(callSuper = true)
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"device_usage_id", "service_id"})})
public class ServiceUsageEntity extends BaseEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "device_usage_id")
    private DeviceUsageEntity deviceUsage;
    @ManyToOne(optional = false)
    @JoinColumn(name = "service_id")
    private ServiceEntity service;

}


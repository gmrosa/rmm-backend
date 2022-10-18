package com.ninjaone.rmmbackend.model.entity;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "DEVICE")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DeviceEntity extends NameEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "device_type_id")
    private DeviceTypeEntity deviceType;

}


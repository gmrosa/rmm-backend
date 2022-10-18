package com.ninjaone.rmmbackend.app.mapper;

import com.ninjaone.rmmbackend.model.converter.UUIDConverter;
import com.ninjaone.rmmbackend.model.dto.ServiceTypeDTO;
import com.ninjaone.rmmbackend.model.entity.ServiceTypeEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class ServiceTypeMapperTest {

    @InjectMocks
    private ServiceTypeMapper mapper;

    @Test
    public void shouldConvertToDTO() {
        UUID uuid = UUID.randomUUID();
        String serviceTypeName = "ServiceType1";
        ServiceTypeEntity serviceType = ServiceTypeEntity.builder().id(uuid).name(serviceTypeName).build();

        ServiceTypeDTO actual = mapper.toDTO(serviceType);
        ServiceTypeDTO expected = ServiceTypeDTO.builder()
                .id(UUIDConverter.toString(uuid))
                .name(serviceTypeName)
                .build();

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldConvertToEntity() {
        UUID uuid = UUID.randomUUID();
        String serviceTypeName = "ServiceType1";

        ServiceTypeDTO dto = ServiceTypeDTO.builder()
                .id(UUIDConverter.toString(uuid))
                .name(serviceTypeName)
                .build();

        ServiceTypeEntity actual = mapper.toEntity(dto);
        ServiceTypeEntity expected = ServiceTypeEntity.builder().id(uuid).name(serviceTypeName).build();

        Assertions.assertThat(actual).isEqualTo(expected);
    }

}

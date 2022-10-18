package com.ninjaone.rmmbackend.app.mapper;

import com.ninjaone.rmmbackend.model.converter.UUIDConverter;
import com.ninjaone.rmmbackend.model.dto.CustomerDTO;
import com.ninjaone.rmmbackend.model.entity.CustomerEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class CustomerMapperTest {

    @InjectMocks
    private CustomerMapper mapper;

    @Test
    public void shouldConvertToDTO() {
        UUID uuid = UUID.randomUUID();
        String name = "Customer1";
        CustomerEntity customer = CustomerEntity.builder().id(uuid).name(name).build();

        CustomerDTO actual = mapper.toDTO(customer);
        CustomerDTO expected = CustomerDTO.builder().id(UUIDConverter.toString(uuid)).name(name).build();

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldConvertToEntity() {
        UUID uuid = UUID.randomUUID();
        String name = "Customer1";

        CustomerDTO dto = CustomerDTO.builder().id(UUIDConverter.toString(uuid)).name(name).build();

        CustomerEntity actual = mapper.toEntity(dto);
        CustomerEntity expected = CustomerEntity.builder().id(uuid).name(name).build();

        Assertions.assertThat(actual).isEqualTo(expected);
    }

}

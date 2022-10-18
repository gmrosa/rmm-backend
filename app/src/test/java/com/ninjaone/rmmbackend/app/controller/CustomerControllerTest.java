package com.ninjaone.rmmbackend.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.ninjaone.rmmbackend.app.RmmBackendApplication;
import com.ninjaone.rmmbackend.model.dto.CustomerDTO;
import com.ninjaone.rmmbackend.model.dto.CustomerMontlyCostDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@AutoConfigureMockMvc
@AutoConfigureDataJpa
@ActiveProfiles(profiles = "test")
@ExtendWith(SpringExtension.class)
@WebMvcTest(CustomerController.class)
@ContextConfiguration(classes = {RmmBackendApplication.class})
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;


    @Test
    @WithUserDetails("admin@company.com")
    public void shouldReturnMonthlyCost() throws Exception {
        ResultActions findCustomerByName = mockMvc.perform(MockMvcRequestBuilders.get("/customer/query?name=TBLU Technology"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
        String customerJson = findCustomerByName.andReturn().getResponse().getContentAsString();

        CustomerDTO customer = new Gson().fromJson(customerJson, CustomerDTO.class);

        CustomerMontlyCostDTO total = CustomerMontlyCostDTO.builder().total(71F).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/customer/monthly-cost/" + customer.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(objectMapper.writeValueAsString(total)));
    }

}

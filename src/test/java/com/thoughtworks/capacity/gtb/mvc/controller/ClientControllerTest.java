package com.thoughtworks.capacity.gtb.mvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.capacity.gtb.mvc.data.ClientData;
import com.thoughtworks.capacity.gtb.mvc.dto.ClientDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ClientControllerTest {

    @Resource
    MockMvc mockMvc;
    private ClientData clientData = ClientData.getInstance();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void shouldRegister() throws Exception {
        ClientDTO clientDTO = new ClientDTO("123", "123456", "123456789@qq.com");
        mockMvc.perform(
                    post("/clients/register")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(clientDTO)))
                .andExpect(status().isCreated());
        assertEquals(1, clientData.getClients().size());
    }
}

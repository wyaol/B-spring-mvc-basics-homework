package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.data.ClientData;
import com.thoughtworks.capacity.gtb.mvc.dto.ClientDTO;
import com.thoughtworks.capacity.gtb.mvc.entity.ClientEntity;

public class ClientService {

    private ClientData clientData = ClientData.getInstance();

    public void addClient(ClientDTO clientDTO) {
        clientData.addClient(new ClientEntity(clientDTO.getUsername(), clientDTO.getPassword(), clientDTO.getEmail()));
    }
}

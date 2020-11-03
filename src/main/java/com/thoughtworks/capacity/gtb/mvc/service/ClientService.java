package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.data.ClientData;
import com.thoughtworks.capacity.gtb.mvc.dto.ClientDTO;
import com.thoughtworks.capacity.gtb.mvc.entity.ClientEntity;
import com.thoughtworks.capacity.gtb.mvc.exceptions.CommonException;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private ClientData clientData = ClientData.getInstance();

    public void addClient(ClientDTO clientDTO) throws CommonException {
        if (clientData.getClientByUsername(clientDTO.getUsername()) != null) throw new CommonException("该用户已存在");
        clientData.addClient(new ClientEntity(clientDTO.getUsername(), clientDTO.getPassword(), clientDTO.getEmail()));
    }
}

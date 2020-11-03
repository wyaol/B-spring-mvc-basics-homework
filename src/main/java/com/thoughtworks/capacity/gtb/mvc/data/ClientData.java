package com.thoughtworks.capacity.gtb.mvc.data;

import com.thoughtworks.capacity.gtb.mvc.entity.ClientEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ClientData {

    private static ClientData instance;
    private List<ClientEntity> clients = new ArrayList<>();

    public static ClientData getInstance() {
        if (instance == null) {
            instance = new ClientData();
        }
        return instance;
    }

    public void addClient(ClientEntity clientEntity) {
        this.clients.add(clientEntity);
    }
}

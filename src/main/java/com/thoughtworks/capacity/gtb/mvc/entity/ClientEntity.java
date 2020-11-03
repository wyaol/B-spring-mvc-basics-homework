package com.thoughtworks.capacity.gtb.mvc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientEntity {
    private Integer id;
    private String username;
    private String password;
    private String email;
}

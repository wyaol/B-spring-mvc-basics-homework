package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.dto.ClientDTO;
import com.thoughtworks.capacity.gtb.mvc.entity.ClientEntity;
import com.thoughtworks.capacity.gtb.mvc.exceptions.CommonException;
import com.thoughtworks.capacity.gtb.mvc.service.ClientService;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@RestController
public class ClientController {

    @Resource
    ClientService clientService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody @Valid ClientDTO client) throws CommonException {
        clientService.addClient(client);
    }

    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ClientEntity register(
            @RequestParam("username")
            @NotBlank(message = "用户名不能为空")
            @Length(min = 3, max = 10, message = "用户名长度必须在3-10")
            @Pattern(regexp = "^\\w+$", message = "用户名只能包含字母，数字或下划线")
                    String username,
            @NotBlank(message = "密码不能为空")
            @Length(min = 5, max = 12, message = "密码必须在5-12")
            @RequestParam("password") String password
    ) throws CommonException {
        return clientService.login(new ClientDTO(username, password, null));
    }
}

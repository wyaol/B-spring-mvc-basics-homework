package com.thoughtworks.capacity.gtb.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
    @NotBlank
    @Min(3)
    @Max(10)
    @Pattern(regexp = "^\\w+$")
    private String username;
    @NotBlank
    @Min(5)
    @Max(12)
    private String password;
    @Email
    private String email;
}

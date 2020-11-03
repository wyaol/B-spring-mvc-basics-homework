package com.thoughtworks.capacity.gtb.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
    @NotBlank(message = "用户名不能为空")
    @Min(value = 3, message = "用户名最低为3位")
    @Max(value = 10, message = "用户名最高为10位")
    @Pattern(regexp = "^\\w+$", message = "用户名只能包含字母，数字或下划线")
    private String username;
    @NotBlank(message = "密码不能为空")
    @Min(value = 5, message = "密码最低为5位")
    @Max(value = 12, message = "密码最多为12位")
    private String password;
    @Email(message = "不符合邮箱格式")
    private String email;
}

package com.thoughtworks.capacity.gtb.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
    @NotBlank(message = "用户名不能为空")
    @Length(min = 3, max = 10, message = "用户名长度必须在3-10")
    @Pattern(regexp = "^\\w+$", message = "用户名只能包含字母，数字或下划线")
    private String username;
    @NotBlank(message = "密码不能为空")
    @Length(min = 5, max = 12, message = "密码必须在5-12")
    private String password;
    @Email(message = "不符合邮箱格式")
    private String email;
}

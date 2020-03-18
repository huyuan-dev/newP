package com.hy.it.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class User {
    private Integer id;
    private String userName;
    private String phone;
    private String email;
    private String remail;
    private String password;
}

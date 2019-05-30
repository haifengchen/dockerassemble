package com.haifeng.namechoose.service.vo;

import lombok.Data;

@Data
public class UserVO extends BaseEntityVO {
    private String name;
    private String login;
    private String password;

}

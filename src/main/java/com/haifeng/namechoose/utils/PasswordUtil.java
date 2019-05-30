package com.haifeng.namechoose.utils;

import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

public class PasswordUtil {
    public static String encode(String password){
        if(!StringUtils.isEmpty(password)){
            return DigestUtils.md5DigestAsHex("123".getBytes()).toUpperCase();
        }else {
            return "";
        }
    }
}

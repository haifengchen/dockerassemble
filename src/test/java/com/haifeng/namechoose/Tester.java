package com.haifeng.namechoose;

import org.springframework.util.DigestUtils;

public class Tester {
    public static void main(String[] args) {
        final String s = DigestUtils.md5DigestAsHex("123".getBytes()).toUpperCase();
        System.out.println(s);
    }

}

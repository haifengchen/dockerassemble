package com.haifeng.namechoose.controller;

import com.haifeng.namechoose.service.UserService;
import com.haifeng.namechoose.service.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(){
        return "hello";
    }

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/allUser", method = RequestMethod.GET)
    public List<UserVO> getAllUser(){
        List<UserVO> allUser = userService.findAllUser();
        return allUser;
    }
}

package com.haifeng.namechoose.service;

import com.haifeng.namechoose.service.vo.UserVO;

import java.util.List;

public interface UserService {
    List<UserVO> findAllUser();
}

package com.haifeng.namechoose.service.impl;

import com.haifeng.namechoose.model.User;
import com.haifeng.namechoose.repository.UserRepository;
import com.haifeng.namechoose.service.UserService;
import com.haifeng.namechoose.service.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserVO> findAllUser() {
        List<User> all = userRepository.findAll();

        return getVOs(all);
    }

    private List<UserVO> getVOs(List<User> users){
        return users.stream().map(user -> {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(user,userVO,"password");
            return userVO;
        }).collect(Collectors.toList());
    }
}

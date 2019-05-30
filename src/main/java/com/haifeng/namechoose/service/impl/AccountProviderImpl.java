package com.haifeng.namechoose.service.impl;

import com.haifeng.namechoose.model.User;
import com.haifeng.namechoose.repository.UserRepository;
import com.haifeng.namechoose.service.AccountProvider;
import com.haifeng.namechoose.utils.PasswordUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

@Component
@Slf4j
public class AccountProviderImpl implements AccountProvider {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void initAll() {
        initAdmin();
    }
    private void initAdmin(){
        User admin = userRepository.findByName("admin");
        if(admin == null){
            log.info("add admin");
            User user = new User();
            user.setLogin("admin");
            user.setName("admin");
            String password = PasswordUtil.encode("admin123@");
            user.setPassword(password);
            userRepository.save(user);
        }else {
            log.info("already have admin");
        }
    }

}

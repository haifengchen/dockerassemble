package com.haifeng.namechoose;

import com.haifeng.namechoose.service.AccountProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ApplicationInitializing implements InitializingBean {
    @Autowired
    private AccountProvider  accountProvider;

    @Override
    public void afterPropertiesSet() throws Exception {
        accountProvider.initAll();
    }
}

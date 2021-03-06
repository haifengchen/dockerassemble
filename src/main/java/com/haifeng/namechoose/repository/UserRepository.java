package com.haifeng.namechoose.repository;

import com.haifeng.namechoose.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, String> {
    User findByName(String name);
}

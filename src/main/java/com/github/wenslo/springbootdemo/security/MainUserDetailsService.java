package com.github.wenslo.springbootdemo.security;

import com.github.wenslo.springbootdemo.reposiroty.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年11月29日 上午11:34
 * @description
 */
@Service
public class MainUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> roles = new ArrayList<>();
        com.github.wenslo.springbootdemo.model.User user = userRepository.findByUsername(username);
        if (Objects.isNull(user)) {
            return null;
        }
        return new User(user.getUsername(), user.getPassword(), roles);
    }
}

package com.github.wenslo.springbootdemo.security.provider;

import com.github.wenslo.springbootdemo.model.User;
import com.github.wenslo.springbootdemo.reposiroty.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
        User user = userRepository.findByUsername(username);
        if (Objects.isNull(user)) {
            return null;
        }

//        List<GrantedAuthority> roles = user.getRoles().stream().map(Role::getRoleName).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roles);
        return user;
    }
}

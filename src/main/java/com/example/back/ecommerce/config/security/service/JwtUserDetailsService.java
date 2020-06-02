package com.example.back.ecommerce.config.security.service;

import java.util.ArrayList;
import java.util.List;

import com.example.back.ecommerce.entities.User;
import com.example.back.ecommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        List<User> list = userRepository.findByEmail(email);
        User user = list.get(0);
        if(user == null){
            throw new UsernameNotFoundException("User not found!");
        }
        return user;
    }
        /*if ("user".equals(username)) {
            return new User("user", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }*/
}
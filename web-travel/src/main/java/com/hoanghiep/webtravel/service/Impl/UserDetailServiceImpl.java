package com.hoanghiep.webtravel.service.Impl;

import com.hoanghiep.webtravel.model.Role;
import com.hoanghiep.webtravel.model.User;
import com.hoanghiep.webtravel.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by hoanghiep on 6/21/17.
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService{

    public static final Logger logger = LoggerFactory.getLogger(UserDetailServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("username: ", username);
//        User user = userRepository.findByEmail(username);
        User user = (User) entityManager.createQuery("from User where email = :email").setParameter("email", username).getSingleResult();
        logger.info("user: {}", user.getEmail());
        logger.info("before if");
        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }
        logger.info("after if");

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Set<Role> roles = user.getRoles();
        logger.info("role: {}", roles.iterator().next());
        for (Role role : roles){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        logger.info("password: {}", user.getPassword());
        logger.info("grantedAuthorities: {}", grantedAuthorities.iterator().next());

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);
    }
}

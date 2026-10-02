package com.canteen.canteenms.service;

// Required imports
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.canteen.canteenms.dao.UsersRepository;
import com.canteen.canteenms.model.CustomUserDetails;
import com.canteen.canteenms.model.Users;


// Service Layer Class for providing the service of user details to the authentication manager for authentication purposes
@Service
public class CustomUserDetailsService implements UserDetailsService{
    

    @Autowired(required = false)
    private UsersRepository usersRepository;
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        
        Optional<Users> user = usersRepository.findById(email);
        
        user.orElseThrow(()->
            new UsernameNotFoundException("User not Found :: "+email)
        );
        
        return new CustomUserDetails(user.get());
    }

}
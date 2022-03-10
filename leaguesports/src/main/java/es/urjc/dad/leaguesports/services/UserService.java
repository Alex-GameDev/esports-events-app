package es.urjc.dad.leaguesports.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import es.urjc.dad.leaguesports.model.User;
import es.urjc.dad.leaguesports.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired private UserRepository userRepository;

    public void addUser(User user) {

        userRepository.save(user);
    }

    public Optional<User> getUserbyName(String name){

        Optional<User> user = userRepository.findByUserName(name);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       
        Optional<User> u = userRepository.findByUserName(username);
        if(!u.isPresent()){
            throw new UsernameNotFoundException("User not found: " + username);            
        }
        User user = u.get(); 

        List<GrantedAuthority> roles = new ArrayList<>();
        for (String role : user.getRoles()) {
            roles.add(new SimpleGrantedAuthority(role));
        }

        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), roles);
   
    }
    
}

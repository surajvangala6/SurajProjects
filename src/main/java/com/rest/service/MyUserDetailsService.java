package com.rest.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rest.dao.UserRepository;
import com.rest.entity.UserDao;
import com.rest.entity.UserDto;

@Service
public class MyUserDetailsService  implements UserDetailsService{
            @Autowired
			private UserRepository userDao;

			@Autowired
			private PasswordEncoder bcryptEncoder;
	 public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
	        /*return new User("foo", "foo",
	                new ArrayList<>());*/
		 
		
		 UserDao user = userDao.findByUsername(s);
			if (user == null) {
				throw new UsernameNotFoundException("User not found with username: " + s);
			}
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
					new ArrayList<>());
		}
	 

		public UserDao save(UserDto user) {
			UserDao newUser = new UserDao();
			newUser.setUsername(user.getUsername());
			newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
			return userDao.save(newUser);
		}
	    

}

package com.rest.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.dao.demodao;
import com.rest.entity.*;
import com.rest.models.AuthenticationRequest;
import com.rest.entity.UserDto;
/*import com.rest.models.AuthenticationResponse;*/
import com.rest.service.*;
import com.rest.util.*;
import com.rest.util.JwtUtil;
 
//@Import(SecurityConfig.class)
 
@RestController
public class controller {
	@Autowired
	private demoservice demoservice;
	 
	@Autowired
	private demodao demodao;
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	 
    @Autowired
    private HttpServletRequest context;
    /*@Autowired 
    private EntityManagerUtils emUtils;*/

	@GetMapping("/hello" )
	public String firstPage() {
		return "Hello World";
	}
 
	/*@Autowired
	@Qualifier("postgresJdbcTemplate")
	private JdbcTemplate postgresTemplate;

	@Autowired
	@Qualifier("mysqlJdbcTemplate")
	private JdbcTemplate mysqlTemplate;*/
	 

	// Get All Notes
	  
	    @GetMapping("/student/{name}")
	    public List<entity> getLastName(@PathVariable("name")String name){
	    	//setRepository( context.getRequestURL().toString() );//
	    	return  demoservice.getPersonInfoByLastName(name);        
	    }
	    @RequestMapping(value = "/register", method = RequestMethod.POST)
		public ResponseEntity<?> saveUser(@RequestBody UserDto user) throws Exception {
			return ResponseEntity.ok(userDetailsService.save(user));
		}

	   /* private void setRepository(String url){
	        demoservice = emUtils.getJpaFactory(url).getRepository(demoservice.class);
	    }*/

	   @CrossOrigin(origins = "http://localhost:4200")
	    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
		public  String createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		   /*ResponseEntity<?>*/
			try {
				authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
				);
			}
			catch (BadCredentialsException e) {
				throw new Exception("Incorrect username or password", e);
			}


			final UserDetails userDetails = userDetailsService
					.loadUserByUsername(authenticationRequest.getUsername());

			/*final String jwt = jwtTokenUtil.generateToken(userDetails);*/
			return jwtTokenUtil.generateToken(userDetails);

			/*return ResponseEntity.ok(new AuthenticationResponse(jwt));*/
		}
	     
}

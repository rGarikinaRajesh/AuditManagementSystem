package com.cognizant.AuditAuthenticationMicroservice.Controller;

import java.util.List;

/**
 * 
 * This class is handling all the end points for Audit Checklist microservice. 
 * This controller has mappings as-
 * postmapping-authenticate,register
 * GetMapping-managers,validate
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.AuditAuthenticationMicroservice.Exception.LoginFailedException;
import com.cognizant.AuditAuthenticationMicroservice.Exception.TokenExpiredException;
import com.cognizant.AuditAuthenticationMicroservice.Model.AuthResponse;
import com.cognizant.AuditAuthenticationMicroservice.Model.ProjectManager;
import com.cognizant.AuditAuthenticationMicroservice.Model.UserCredentials;
import com.cognizant.AuditAuthenticationMicroservice.Repository.ProjectManagerRepository;
import com.cognizant.AuditAuthenticationMicroservice.Service.UserDetailsServiceClass;
import com.cognizant.AuditAuthenticationMicroservice.util.jwtUtil;

/**
 * 
 * This class is handling all the end points for Audit Authentication
 * microservice. This controller has mappings as-
 * postmapping-getAuthenticate(),login()
 *
 */

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationController {

	@Autowired
	UserDetailsServiceClass userservice;

	@Autowired
	ProjectManagerRepository repo;

	@Autowired
	jwtUtil util;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	PasswordEncoder bcrpyt;

	/**
	 * 
	 * @param userCredentials
	 * @return registering the new User
	 */
	@PostMapping("/register")
	public int register(@RequestBody UserCredentials userCredentials) {
		ProjectManager manage = new ProjectManager(userCredentials.getUsername(),
				bcrpyt.encode(userCredentials.getPassword()), " ");
		repo.save(manage);
		return 1;
	}

	/**
	 * 
	 * @return Managers printing list of managers
	 */
	@GetMapping("/managers")
	public List<ProjectManager> getManagers() {
		return repo.findAll();
	}

	/**
	 * 
	 * @param token
	 * @return Status code with AuthResponse validating the token
	 */
	@GetMapping(value = "/validate")
	public ResponseEntity<?> getValidity(@RequestHeader("Authorization") String token) {

		token = token.substring(7);
		AuthResponse res = new AuthResponse();
		ResponseEntity<?> response = null;
		try {
			if (util.validateToken(token) && token != null) {

				res.setUid(util.extractUsername(token));
				res.setValid(true);

			} else {
				res.setUid(util.extractUsername(token));
				res.setValid(false);
			}
		} catch (TokenExpiredException e) {
			res.setValid(false);
		}
		response = new ResponseEntity<AuthResponse>(res, HttpStatus.OK);

		return response;

	}

	/**
	 * 
	 * @param userLoginCredentials
	 * @return
	 * @throws LoginFailedException Authenticating the user
	 */
	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody UserCredentials userLoginCredentials) throws LoginFailedException {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					userLoginCredentials.getUsername(), userLoginCredentials.getPassword()));
		} catch (LoginFailedException ex) {
			throw new TokenExpiredException("invalid username/password");
		}
		String generateToken = jwtUtil.generateToken(userLoginCredentials.getUsername());
		ProjectManager projectManager = new ProjectManager(userLoginCredentials.getUsername(),
				userLoginCredentials.getPassword(), generateToken);
		return new ResponseEntity<>(projectManager, HttpStatus.OK);
	}

}

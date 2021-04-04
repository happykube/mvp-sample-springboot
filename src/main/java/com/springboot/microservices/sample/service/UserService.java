package com.springboot.microservices.sample.service;

/*
 * Service Layer: UserService
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.microservices.sample.domain.TestDomain;
import com.springboot.microservices.sample.domain.UserDomain;
import com.springboot.microservices.sample.model.UpdateUser;
import com.springboot.microservices.sample.model.User;

@Service
public class UserService {
	@Autowired
	private UserDomain userDomain;
	
	@Autowired
	private TestDomain testDomain;
	
	public ResponseEntity <List<User>> getUserList() { 
		return userDomain.getUserList();
	}
	
	public ResponseEntity <User> getUserById(String userId) { 
		return userDomain.getUserById(userId);
	}
	
	public ResponseEntity <String > setUserUpdate(String userId, UpdateUser sampleUser) throws Exception {
		return userDomain.setUserUpdate(userId, sampleUser);
	}
	
	public ResponseEntity <String > setUserInsert(User sampleUser) throws Exception { 
		return userDomain.setUserInsert(sampleUser);		
	}

	public ResponseEntity <String > setUserDelete(String userId) throws Exception { 
		return userDomain.setUserDelete(userId);
	}
	
	public ResponseEntity <String > createTestUsers(int startUserId, int userCount) throws Exception { 
		return testDomain.createTestUsers(startUserId, userCount);
	}
}

package com.springboot.microservices.sample.domain;

/*
 * Domain(Business) Layer: UserDomain
 */

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.microservices.sample.data.UserDao;
import com.springboot.microservices.sample.model.UpdateUser;
import com.springboot.microservices.sample.model.User;

@Service
public class UserDomain {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserDao sampleUserDao;
	
	/*
	 * getUserList: 유저 목록을 100개까지 리턴
	 */
	public ResponseEntity <List<User>> getUserList() { 
		
		List<User> list = null;
		try {
			log.info("Start db select");
			list = sampleUserDao.selectUser();
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.debug("user counts :"+list.size());
		
		return new ResponseEntity<List<User>> (list, HttpStatus.OK);
	}
	
	/*
	 * getUserById: userId에 해당하는 사용자정보 리턴 
	 */
	public ResponseEntity <User> getUserById(String userId) { 
		User re = null;
		try {
			log.info("Start db select");
			re = sampleUserDao.selectUserById(userId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<User> (re, HttpStatus.OK);
	}
	
	/*
	 * setUserUpdate: 사용자 정보 변경 
	 */
	public ResponseEntity <String > setUserUpdate(String userId, UpdateUser sampleUser) throws Exception { 
		log.info("Start db update==>"+userId);

		int re  = sampleUserDao.updateUser(sampleUser);
		log.debug("result :"+ re);
		
		return new ResponseEntity<String> (re+"", HttpStatus.OK);
	}

	/*
	 * setUserInsert: 사용자 추가 
	 */
	public ResponseEntity <String > setUserInsert(User sampleUser) throws Exception { 
		log.info("Start db insert");
		int re  = sampleUserDao.insertUser(sampleUser);
		log.debug("result :"+ re);
		
		return new ResponseEntity<String> (re+"", HttpStatus.OK);
	}
	
	/*
	 *  setUserDelete: 사용자 삭제 
	 */
	public ResponseEntity <String > setUserDelete(String userId) throws Exception { 
		log.info("Start db insert");
		int re  = sampleUserDao.deleteUser(userId);
		log.debug("result :"+ re);
		
		return new ResponseEntity<String> (re+"", HttpStatus.OK);
	}
	
}

package com.springboot.microservices.sample.data;

/*
 * Data(Persistent) Layer: UserDao
 */

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.microservices.sample.model.UpdateUser;
import com.springboot.microservices.sample.model.User;

@Mapper
public interface UserDao {

	/**
	 * 사용자 전체 정보 가져오기 
	 * @return
	 * @throws Exception
	 */
	List<User> selectUser() throws Exception;	
	
	/**
	 * 아이디로 사용자 정보 조회하
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	User selectUserById(String userId) throws Exception;	
	
	/**
	 * 사용자 정보 변경하
	 * @param sampleUser
	 * @return
	 * @throws Exception
	 */
	int updateUser(UpdateUser sampleUser) throws Exception;
	
	/**
	 * 사용자 등록하기 
	 * @param sampleUser
	 * @return
	 * @throws Exception
	 */
	int insertUser(User sampleUser) throws Exception;
	
	/**
	 * 사용자 정보 삭제하기 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	int deleteUser(String userId) throws Exception;		
	
	/**
	 * 테스트 사용자 등록하기 
	 * @param ArrayList<User> users
	 * @return
	 * @throws Exception
	 */
	int createTestUsers(ArrayList<User> users) throws Exception;	

}
			
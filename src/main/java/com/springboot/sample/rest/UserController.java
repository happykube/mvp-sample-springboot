package com.springboot.sample.rest;

/*
 * Presentation Layer: UserController
 */

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.sample.model.Hello;
import com.springboot.sample.model.UpdateUser;
import com.springboot.sample.model.User;
import com.springboot.sample.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@Api(value="User API")
@RestController
@RequiredArgsConstructor
public class UserController {
	private String msgTemplate = "%s 님 반갑습니다.";
	private final AtomicLong vistorCounter = new AtomicLong();
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "Hello API 입니다.")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "name", value = "이름", required = true, dataType = "String", paramType = "query", defaultValue = "홍길동") 
	})
	@GetMapping("/hello")
	public Hello getHelloMsg(@RequestParam(value = "name") String name) {
		return new Hello(vistorCounter.incrementAndGet(), String.format(msgTemplate, name));
	}
	
	@GetMapping("/users")	
	@ApiOperation(value="사용자 정보 가져오기", notes="사용자 정보를 제공합니다. ")
	public ResponseEntity <List<User>> getUserList() { 
		return userService.getUserList();
	}
	
	
	@GetMapping("/users/{userId}")
	@ApiOperation(value="아이디로 사용자 정보 가져오기 ")
	public ResponseEntity <User> getUserById(
				@PathVariable (name="userId", required = true) String userId
			) { 
		return userService.getUserById(userId);
	}
	
	@PutMapping("/users/{userId}")
	@ApiOperation(value="사용자 정보 변경하기 ")
	public ResponseEntity <String > setUserUpdate(
			@PathVariable(name="userId",required = true ) String userId, 
			@RequestBody UpdateUser sampleUser
		) throws Exception { 
		
		return userService.setUserUpdate(userId, sampleUser);
	}
	
	@PostMapping("/users")
	@ApiOperation(value="사용자 정보 등록하기 ")
	public ResponseEntity <String > setUserInsert(
			@RequestBody User sampleUser
		) throws Exception { 
		
		return userService.setUserInsert(sampleUser);
	}
	
	@DeleteMapping("/users/{userId}")
	@ApiOperation(value="사용자 정보 삭제하기 ")
	public ResponseEntity <String > setUserDelete(
			@PathVariable(name="userId",required = true ) String userId
		) throws Exception { 
		
		return userService.setUserDelete(userId);
	}

	@GetMapping("/createtestusers/{startUserId}/{userCount}")
	@ApiOperation(value="테스트 사용자를 userCount명 등록하기 ")
	public ResponseEntity <String > createTestUsers(
			@PathVariable (name="startUserId", required = true) int startUserId,
			@PathVariable (name="userCount", required = true) int userCount
		) throws Exception { 
		
		return userService.createTestUsers(startUserId, userCount);
	}	
}
package com.occamsrazor.web.uer;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.occamsrazor.web.util.Messenger;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired UserSevice userSevice;
	
	@PostMapping("/join")
	public Messenger add(@RequestBody User user) {
		System.out.println(user);
		userSevice.add(user);
		int count = userSevice.count();
		return (userSevice.count() == count +1)? Messenger.SUCCESS : Messenger.FAIL;
	}
	
	@PostMapping("/login")
	public Map<String, Object> login(@RequestBody User user) {
		Map<String, Object> retunMap= new HashMap<>();
		User loginUser = userSevice.login(user);
		
		if (loginUser != null) {
			retunMap.put("user", loginUser);
			retunMap.put("messenger", Messenger.SUCCESS);
		}else {
			retunMap.put("messenger", Messenger.FAIL);
		}
		return retunMap;
		
	}

}

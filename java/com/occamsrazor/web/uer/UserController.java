package com.occamsrazor.web.uer;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/detail/{userid}")
	public User detail(@PathVariable String userid) {
		System.out.println("detail 진입한 id ::: "+userid);
		return userSevice.detail(userid);
	}
	
	@PutMapping("/update")
	public Messenger update(@RequestBody User user) {
		System.out.println("update 정보: "+user);
		System.out.println(userSevice.update(user));
		return (userSevice.update(user))? Messenger.SUCCESS:Messenger.FAIL;
	}
	
	@DeleteMapping("/remove/{userid}")
	public Messenger remove(@PathVariable String userid) {
		System.out.println("delet 정보 :"+userid);
		return (userSevice.remove(userid))? Messenger.SUCCESS : Messenger.FAIL;
	}
}

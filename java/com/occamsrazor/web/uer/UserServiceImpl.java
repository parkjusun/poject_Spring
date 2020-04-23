package com.occamsrazor.web.uer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserSevice {
	private Map<String, Object> map;

	public UserServiceImpl() {
		map = new HashMap<>();
	}
	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		map.put(user.getUserId(), user);
		
	}
	
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		User returnUser = null;
		if (map.containsKey(user.getUserId())) {
			User u = detail(user.getUserId());
			if (user.getPassword().equals(u.getPassword())) {
				returnUser = u;
			}
		}
		return returnUser;
	}

	

	@Override
	public User detail(String userid) {
		// TODO Auto-generated method stub
		
		
		return (User) map.get(userid);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delet(User user) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return map.size();
	}


	
}

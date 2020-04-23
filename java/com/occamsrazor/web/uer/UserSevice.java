package com.occamsrazor.web.uer;

public interface UserSevice {
	public void add(User user);
	public User login(User user);
	public User detail(String userid);
	public void update(User user);
	public void delet(User user);
	public int count();
}

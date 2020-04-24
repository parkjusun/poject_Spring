package com.occamsrazor.web.uer;

public interface UserSevice {
	public void add(User user);
	public User login(User user);
	public int count();
	public User detail(String userid);
	public boolean update(User user);
	public void delet(User user);
	public boolean remove(String userid);
}


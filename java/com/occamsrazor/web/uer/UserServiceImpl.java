package com.occamsrazor.web.uer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserSevice {
	private Map<String, Object> map;
	public final static String FILE_PATH = "C:\\Users\\bit1\\spring-workspace\\occamsrazor\\src\\main\\resources\\static\\user\\";

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
	public boolean update(User user) {
		map.replace(user.getUserId(), user);

		return true;
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

	@Override
	public boolean remove(String userid) {
		// TODO Auto-generated method stub
		map.remove(userid);
		return true;
	}

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		List<User> list = new ArrayList<>();
		@SuppressWarnings("rawtypes")
		Set set = map.entrySet();

		@SuppressWarnings("rawtypes")
		Iterator it = set.iterator();

		while (it.hasNext()) {
			@SuppressWarnings("unchecked")
			Map.Entry<String, User> e = (Entry<String, User>) it.next();
			list.add(e.getValue());
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		return list;
	}

	@Override
	public void saveFile(User user) {
		try {
			File file = new File(FILE_PATH+"list.txt");
			@SuppressWarnings("resource")
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
					String message = user.toString();
					System.out.println(message);
					writer.write(message);
					writer.newLine();
					writer.flush();
		} catch(Exception e) {
			System.out.println("파일 입력 시 에러 발생");
		}

	}

	@Override
	public List<User> readFile() {

		
		List<User> userlist = new ArrayList<>();
		List<String> list = new ArrayList<>();
		try {
			File file = new File(FILE_PATH+"list.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String message = "";
			while((message = reader.readLine()) != null) {
				list.add(message); 
			}
			reader.close();
		} catch(Exception e) {
			System.out.println("파일 읽기에서 에러 발생");
		}
		User u = null;
		for(int i =0;i < list.size(); i++) {
			u = new User();
			String[] arr = list.get(i).split(",");
			u.setUserId(arr[0]);
			u.setPassword(arr[1]);
			u.setName(arr[2]);
			u.setSsn(arr[3]);
			u.setAddr(arr[4]);
			userlist.add(u);
		}
		return userlist;
	}

	@Override
	public boolean idCheck(String userid) {
		boolean check = false;
		List<User> list = readFile();
		for (int i = 0; i < list.size(); i++) {
			if (userid.equals(list.get(i).getUserId())) {
				check = true;
				break;
				
			}
		}
		
		return check;
	}

}

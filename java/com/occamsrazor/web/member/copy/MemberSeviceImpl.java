package com.occamsrazor.web.member.copy;

import org.springframework.stereotype.Service;

@Service
public class MemberSeviceImpl implements MemberService {
	public Member[] members;
	public int count;
	
	public MemberSeviceImpl() {
		// TODO Auto-generated constructor stub
		members = new Member[5];
		count = 0;

	}

	@Override
	public void add(Member member) {
		// TODO Auto-generated method stub
		members[count] = member;
		count++;
	}

	@Override
	public Member[] list() {
		// TODO Auto-generated method stub

		return members;
	}

	@Override
	public Member[] searchByName(String name) {

		int nameCount = samCount(name);
		Member[] membersName = null;

		int searchCount = samCount(name);
		if (searchCount != 0) {
			membersName = new Member[nameCount];
			int j = 0;
			for (int i = 0; i < count; i++) {
				if (name.equals(members[i].getName())) {
					membersName[j] = members[i];
					j++;
					if (searchCount == j) {
						break;
					}
				}
			}
		}
		return membersName;
	}

	@Override
	public Member searchByGender(String gender) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member detail(String userid) {
		Member userIdMember = new Member();

		for (int i = 0; i < members.length; i++) {
			if (userid.equals(members[i].getUserId())) {
				userIdMember = members[i];
			}
		}

		return userIdMember;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public int samCount(String name) {
		int countName = 0;

		// TODO Auto-generated method stub
		for (int i = 0; i < members.length; i++) {
			if (name.equals(members[i].getName())) {
				countName++;
			}
		}
		return countName;
	}

	@Override
	public int genderCount(String gender) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean login(Member member) {
		// TODO Auto-generated method stub
		boolean loginOk = true;
		for (int i = 0; i < members.length; i++) {
			if (member.getUserId().equals(members[i].getUserId()) 
					&& member.getPassword().equals(members[i].getPassword()))  {
				loginOk = true;
				break;
			}else {
				loginOk = false;
				break;
			}
		}
		
		
		return loginOk;
	}

	@Override
	public void update(Member member) {
		// TODO Auto-generated method stub
		for (int i = 0; i < count; i++) {
			if (member.getUserId().equals(members[i].getUserId())) {
				members[i].setPassword(member.getPassword());
				break;
			}

		}
	}

	@Override
	public void delete(Member member) {
		// TODO Auto-generated method stub
		for (int i = 0; i < count; i++) {
			if (member.getUserId().equals(members[i].getUserId())
					&& member.getPassword().equals(members[i].getPassword())) {
				members[i] = members[count - 1];
				members[count - 1] = null;
				count--;

			}

		}

	}

}

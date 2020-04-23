package com.occamsrazor.web.grade;

import org.springframework.stereotype.Service;

import com.occamsrazor.web.util.Credit;


@Service
public class GradeServiceImpl implements GradeService {
	private Grade[] grades;
	private Grade grade;
	public int count;

	
	public GradeServiceImpl() {
		// TODO Auto-generated constructor stub
		grades = new Grade[5];
		count = 0;
	}

	@Override
	public void add(Grade grade) {
		grades[count] = grade;
		count++;
	}
	
	
	@SuppressWarnings("static-access")
	@Override
	public Credit detail(String userid) {
		// TODO Auto-generated method stub
		Credit credit = null;
		
		switch (averege(userid)/10) {
		case 10:credit = Credit.A;break;
		case 9:credit = Credit.A;break;
		case 8:	credit = Credit.B;break;
		case 7:	credit = Credit.C;break;
		case 6:	credit = Credit.D;break;
		case 5:	credit = Credit.E;break;
		default:credit = Credit.F;break;

		
		}
		
		return credit;
	}

	

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return count;
	}

	
	private int total(String userid) {
		// TODO Auto-generated method stub
		int total = 0;
		for (int i = 0; i < count; i++) { 
			if (userid.equals(grades[i].getUserid())) {
				total = Integer.parseInt(grades[i].getKorean())+ 
						Integer.parseInt(grades[i].getEnglish())+ 
						Integer.parseInt(grades[i].getMath())+ 
						Integer.parseInt(grades[i].getJava());	
			}		
			
		}
		System.out.println("tortal");
		return total;
		
	}
	
	
	private int averege(String userid) {
		// TODO Auto-generated method stub
		

		return total(userid) / 4;
	}
	


	@Override
	public void updateGrade(Grade grade) {
		// TODO Auto-generated method stub

	}

	
	@Override
	public void deletGrade(Grade grade) {
		// TODO Auto-generated method stub

	}


	
		

}

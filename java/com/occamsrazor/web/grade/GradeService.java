package com.occamsrazor.web.grade;

import com.occamsrazor.web.util.Credit;

public interface GradeService  {
	public void add(Grade grade);
	public Credit detail(String userid);
	public int count();
	public void updateGrade(Grade grade);
	public void deletGrade(Grade grade);


	
	
}

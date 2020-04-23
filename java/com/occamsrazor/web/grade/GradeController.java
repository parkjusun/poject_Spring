package com.occamsrazor.web.grade;

import javax.imageio.spi.RegisterableService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.occamsrazor.web.util.Credit;
import com.occamsrazor.web.util.Messenger;


@RestController
@RequestMapping("/grade")
public class GradeController {
	@Autowired GradeService gradeService;
	
	@PostMapping("/register")
	public Messenger register(@RequestBody Grade grade) {
		Messenger messenger = null;
		int current = gradeService.count();
		gradeService.add(grade);
		System.out.println(grade);
		return (gradeService.count()==current+1)? messenger.SUCCESS: messenger.FAIL;
	}

	@PostMapping("/gradeInput")
	public Credit add(@RequestBody Grade grade) {
		
		gradeService.add(grade);
		return Credit.SUCCESS ;
	}
	
	
	
	@GetMapping("/result/{userid}")
	public Credit report(@PathVariable String userid)	{
		System.out.println("userid"+userid);
		 gradeService.detail(userid);

		return  gradeService.detail(userid);
	}
	
}

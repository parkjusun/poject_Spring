package com.occamsrazor.web.member.copy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.occamsrazor.web.util.Messenger;

@RestController
@RequestMapping("/member")
public class MemberController {
	@Autowired MemberService memberService;
	
	
	@PostMapping("/join")
	public Messenger add(@RequestBody Member member) {
		int current = memberService.count();
		
		
		memberService.add(member);
		
		return (memberService.count() == (current + 1))? Messenger.SUCCESS : Messenger.FAIL;
	}
	
	@PostMapping("/login")
	public Messenger login(@RequestBody Member member) {
		System.out.println(member);
		System.out.println(memberService.login(member));
		return (memberService.login(member))? Messenger.SUCCESS : Messenger.FAIL;
	}
	
	@GetMapping("/detali")
	public Member detail(@RequestBody String memberId) {
		Member memberDetali = new Member();
		memberDetali = memberService.detail(memberId);
		return memberDetali;
	}
	
	@GetMapping("/list")
	public Member[] detail() {
		Member[] memberlist = new Member[5];
		return memberlist;
	}
	
	@GetMapping("/count")
	public int count() {
		
		return memberService.count();
	}
	
	
	
	@PutMapping("/update")
	public Member update(@RequestBody Member member) {
		Member updteMember = new Member();
		
		return updteMember;
	}
	
	
	@DeleteMapping("/delet")
	public void delet(Member member) {
		memberService.delete(member);
	}
}

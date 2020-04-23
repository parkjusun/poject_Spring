package com.occamsrazor.web.lotto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.occamsrazor.web.util.Credit;
import com.occamsrazor.web.util.LottoCredit;
import com.occamsrazor.web.util.Messenger;

@RestController
@RequestMapping("/lotto")
public class LottoController {
	@Autowired LottoService lottoService;
	
	@GetMapping("/lottoUser/{lottoNumber}")
	public Messenger add(@PathVariable String lottoNumber) {
		System.out.println(lottoNumber);
		
		lottoService.add(lottoNumber);
		
		int current = lottoService.lottoCount();
		return (current < 7 && current > 5)? Messenger.SUCCESS:Messenger.FAIL;
		
	}
	
	@GetMapping("/result/{userid}")
	public LottoCredit result(String userid) {
		
		return lottoService.result(userid);
	}
}

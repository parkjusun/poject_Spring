package com.occamsrazor.web.lotto;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.occamsrazor.web.util.LottoCredit;

@Service
public class LottoServiceImp implements LottoService {
	public String[] lottoNumbers;
	public int count;

	public LottoServiceImp() {
		// TODO Auto-generated constructor stub
		count = 0;
	}

	@Override
	public void add(String lottoNumber) {
		// TODO Auto-generated method stub
		lottoNumbers = lottoNumber.split(",");

	}

	@Override
	public int lottoCount() {
		// TODO Auto-generated method stub
		return lottoNumbers.length;
	}

	@Override
	public LottoCredit result(String userid) {
		// TODO Auto-generated method stub
		
		
		LottoCredit lottoCredit = null;

		
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < lottoNumbers.length; j++) {
				if (lottoRan()[i] == Integer.valueOf(lottoNumbers[j])) {
					count++;
				}
			}
		}

		switch (count) {
		case 6:
			lottoCredit = LottoCredit.first;
			break;

		case 5:
			lottoCredit = LottoCredit.second;
			break;

		case 4:
			lottoCredit = LottoCredit.third;
			break;

		default:
			lottoCredit = LottoCredit.out;
			break;
		}

		return lottoCredit;
	}
	
	@Override
	public String[] detail(String lottoNumber) {
		// TODO Auto-generated method stub
		return lottoNumbers;
	}


	@Override
	public int[] lottoRan() {
		// TODO Auto-generated method stub
		Random lottoRan = new Random();
		int[] lottoResult = new int[7];
		
		
		for (int i = 0; i < lottoResult.length; i++) {
			lottoResult[i] = lottoRan.nextInt(45) + 1;
			for (int j = 0; j < i; j++) {
				if (lottoResult[i] == lottoResult[j]) {
					i--;
				}
			}
			
		}
		
		for (int j = 0; j < lottoResult.length; j++) {
			System.out.println("====================");
			System.out.println(lottoResult[j]);
		}
		
		

		return lottoResult;
	}

	
}

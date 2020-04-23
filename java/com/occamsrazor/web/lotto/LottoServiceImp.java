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
		System.out.println(lottoNumbers.length);

	}

	@Override
	public int lottoCount() {
		// TODO Auto-generated method stub
		return lottoNumbers.length;
	}

	@Override
	public LottoCredit result(String userid) {
		// TODO Auto-generated method stub
		Random lottoRan = new Random();
		int[] lottoResult = new int[6];
		LottoCredit lottoCredit = null;

		for (int i = 0; i < lottoResult.length; i++) {
			lottoResult[i] = lottoRan.nextInt(45) + 1;
			for (int j = 0; j < i; j++) {
				if (lottoResult[i] == lottoResult[j]) {
					i--;
				}
			}
		}

		for (int i = 0; i < lottoResult.length; i++) {
			for (int j = 0; j < lottoNumbers.length; j++) {
				if (lottoResult[i] == Integer.valueOf(lottoNumbers[j])) {
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

}

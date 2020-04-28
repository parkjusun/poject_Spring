package com.occamsrazor.web.lotto;

import com.occamsrazor.web.util.LottoCredit;


public interface LottoService {
	public void add(String lottoNumber);
	public int lottoCount();
	public String[] detail(String lottoNumber);
	public int[] lottoRan();
	public LottoCredit result(String userid);
}

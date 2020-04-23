package com.occamsrazor.web.lotto;

import com.occamsrazor.web.util.LottoCredit;


public interface LottoService {
	public void add(String lottoNumber);
	public int lottoCount();
	public LottoCredit result(String userid);
}

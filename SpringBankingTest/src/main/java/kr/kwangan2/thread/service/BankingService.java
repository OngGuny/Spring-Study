package kr.kwangan2.thread.service;

public interface BankingService {

	public void bankTransfer(Long money) throws Exception;
	

	public void bankLogger(String money, String stat) throws Exception;
}

package kr.kwangan2.thread.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kwangan2.thread.mapper.CSAMapper;
import kr.kwangan2.thread.mapper.LogMapper;
import kr.kwangan2.thread.mapper.YHAMapper;
import kr.kwangan2.thread.service.BankingService;
import lombok.Setter;

@Service
public class BankingServiceImpl implements BankingService{
	
	@Setter(onMethod_ = @Autowired)
	private CSAMapper csMapper;
	
	@Setter(onMethod_ = @Autowired)
	private YHAMapper yhMapper;
	
	@Setter(onMethod_ = @Autowired)
	private LogMapper logMapper;
	
	@Override
	public void bankTransfer(Long money) throws Exception {
		csMapper.insertCSBanking(money);
		yhMapper.insertYHBanking(money);
	}
	
	@Override
	public void bankLogger(String money, String stat) throws Exception {
		logMapper.insertLog(money, stat);
	}
	
}//class

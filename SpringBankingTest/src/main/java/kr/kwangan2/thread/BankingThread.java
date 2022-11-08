package kr.kwangan2.thread;

public class BankingThread extends Thread {
	Long CSaccount = 100000L;
	Long YHaccount = 50000L;

	@Override
	public void run() {
		while (CSaccount > 0L && YHaccount > 0L) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			int money = (int) ((Math.random() + 0.1) * 10) * 1000;
			
			if(this.CSaccount > money) {
			this.CSaccount = this.CSaccount - money;
			this.YHaccount = this.YHaccount + money;
			
			System.out.println("철수 잔액 : "+CSaccount);
			System.out.println("영희 잔액 : "+YHaccount);
			} else if(this.CSaccount < money){
				System.out.println("aop 처리해서 글 넣어주기. ");
			}
			
		} // while

	}// run()

}// class

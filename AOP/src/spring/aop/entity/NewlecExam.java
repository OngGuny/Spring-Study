package spring.aop.entity;

public class NewlecExam implements Exam {

	private int kor;
	private int eng;
	private int math;
	private int com;
	
	
	public NewlecExam() {
	}

	public NewlecExam(int kor, int eng, int math, int com) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.com = com;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getCom() {
		return com;
	}

	public void setCom(int com) {
		this.com = com;
	}

	@Override
	public int total() {//코어 코드랑   위 아래로 곁다리 업무 추가하려고 
		//long start = System.currentTimeMillis();
		
		int result = kor+eng+math+com; //사용자가 하는 업무  나머진 곁다리
//		try {
//			Thread.sleep(200);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		long end = System.currentTimeMillis();
//		String message = (end - start) +  "ms 시간이 걸렸습니다";
//		System.out.println(message);
		return result;
	}

	@Override
	public float avg() {
		
		float result = total() / 4.0f;
		
		return result;
	}

}

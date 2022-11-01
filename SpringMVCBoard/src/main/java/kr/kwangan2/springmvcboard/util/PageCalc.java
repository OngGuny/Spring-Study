package kr.kwangan2.springmvcboard.util;

import kr.kwangan2.springmvcboard.domain.Criteria;
import lombok.Getter;

@Getter
public class PageCalc { //얘ㅖ가 이제 PageDTO 역할 하게됨 
	public int total;	//전체 게시물 수 
	public int startPage; // 블럭 내 시작 페이지 번호
	public int endPage;// 블럭 내에서 끝페이지 번호
	public boolean prev;// 이전 블럭이 있는지
	public boolean next;// 다음 블럭이 있는지

	public Criteria criteria;

	public PageCalc(Criteria criteria, int total) {
		this.criteria = criteria;
		this.total = total;
	}

	public PageCalc calcPage() {
	//끝페이지 번호   단순히 한 블록에 10개 페이지라 가정한 끝번호.
			this.endPage = (int) (Math.ceil(criteria.getPageNum()/10.0))*10;
			//시작 페이지 번호 
			this.startPage = this.endPage - 9;
			
			int realEnd = (int)(Math.ceil(total*1.0)/criteria.getAmount());
														//여ㅑ긴 왜 this 없음?
			//블럭 내 페이지가 10개가 안될 때 끝페이지 번호 설정
			if(realEnd < this.endPage) {
				this.endPage = realEnd;
			}
			
			this.prev = this.startPage >1;
			this.next = this.endPage < realEnd;
			return this;
		}
}// class

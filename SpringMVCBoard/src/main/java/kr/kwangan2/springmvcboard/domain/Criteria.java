package kr.kwangan2.springmvcboard.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {

	private int pageNum;
	private int amount;
 
	private String type; //검색 조건
	private String keyword; // 검색어 
	
	public Criteria() { 
		this(1, 10);//얘는 왜 여기서? 다른데서 세팅하고 바꿀 수 있게 하는게 좋지.. properties 에 넣어두고 .
	}

	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}

	public String[] getTypeArr() {
		return type==null?new String[] {} : type.split("");
	}
	
	public String getListLink() {
	UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
			.queryParam("pageNum", this.pageNum)
			.queryParam("amount", this.getAmount())
			.queryParam("type", this.getType())
			.queryParam("keyword",this.getKeyword());
	return builder.toUriString();
	}
}//class

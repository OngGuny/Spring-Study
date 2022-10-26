package kr.kwangan2.domain;


import lombok.Data;

@Data
public class Comm {
	private int commId; //<id>
	private String commTitle; //<result>
	private String commContent;//<result>
	private int fkBlogId;//<result>
	
	public Comm(int fkblogId) {
		this.fkBlogId = fkblogId;
	}

	public Comm(int commId, String commTitle, String commContent, int fkBlogId) {
		super();
		this.commId = commId;
		this.commTitle = commTitle;
		this.commContent = commContent;
		this.fkBlogId = fkBlogId;
	}
	
	
}

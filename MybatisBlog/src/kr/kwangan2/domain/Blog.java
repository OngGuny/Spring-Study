package kr.kwangan2.domain;

import java.util.List;

import lombok.Data;

@Data
public class Blog {
	private int blogId;// <id>
	private String blogName;// <result>
	private String blogTitle;// <result>
	private Author author;// <result>
	private List<Comm> comms;// <result>
	private int fkAuthorId;// <result>

	public Blog(Integer blogId) {
		this.blogId = blogId;
	}
}

package blog;

import java.util.ArrayList;

public class Blog {
	private int id;
	private String title;
//	private String blog_author_id;
	//////////////////new
	private Author author;
	private ArrayList<Post> posts;
	
	
	public Blog() {
	}// g -nargs
	/////////////////////////new  블로그 아이디를 셋팅하는 애를 만들어줌 
	public Blog(int id) {
		this.id = id;
	}
	
}

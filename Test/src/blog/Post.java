package blog;

import java.util.ArrayList;

public class Post {
	private int id;
//	private int blog_id;
//	private int author_id;
//	private String created_on;
//	private String section;
	private String subject;
	private int draft;
//	private String body;
	private Author author;
	//////////////////////////// new 
	private ArrayList<Comment> comments;
	private ArrayList<Tag> tags;

	public Post() {
		super();
	}

}

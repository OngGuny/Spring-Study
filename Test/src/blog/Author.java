package blog;

public class Author { //자바에선 언더바 잘 안쓰니까 안써도된다. 나중에 맵핑할때 해주면된다.
	private int id;
	private String username;
	private String password;
	private String email;
	private String bio;
	private String favourite_Section;

	public Author(int id, String username, String password, String email, String bio, String favourite_Section) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.bio = bio;
		this.favourite_Section = favourite_Section;
	}

	public Author() {
	}

}

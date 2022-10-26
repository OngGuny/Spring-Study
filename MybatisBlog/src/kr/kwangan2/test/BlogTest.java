package kr.kwangan2.test;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kwangan2.domain.Author;
import kr.kwangan2.domain.Blog;
import kr.kwangan2.domain.Comm;
import kr.kwangan2.domain.CommSearcher;

public class BlogTest {
	public static void main(String[] args) {
		String resource = "kr/kwangan2/conf/sqlMapConfig.xml"; //이안에 드라이버 접속하는 유저 아이디 드라이버 등등 있음 
		Reader reader;
		SqlSession session = null;
		try {
			reader = Resources.getResourceAsReader(resource); //컨피그 읽어내려고 쓴거 
			SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);//리더를 빌딩하는것. 
			session = sqlMapper.openSession();
//			List<Blog> blogs = session.selectList("kr.kwangan2.conf.Blog.selectBlog");
//			
//			for(Blog blog : blogs) {
//				System.out.println("-----------------------------------");
//				System.out.println("blog id : " + blog.getBlogId());
//				Author author = blog.getAuthor();
//				System.out.println("\t"+author);
//				System.out.println("-----------------------------------");
//			  } 확인 
				
				
//		CommSearcher commsearcher = new CommSearcher();
//		commsearcher.setSearchKey("댓글");
//		commsearcher.setSearchValue("comm");
//		commsearcher.setFkblogId(68);
//		List<Comm> comms =
//				session.selectList("selectCommsByBlogId", commsearcher);
//		for(Comm comm:comms) {
//			System.out.println(comm);
//		}
//		
//		Comm comm = new Comm();
//		comm.setCommId(1);
//		comm.setCommTitle("update title");
//        comm.setCommContent("update content");
//        comm.setFkBlogId(1);
//        int result = session.update("updateComm", comm);
//        if (result > 0) {
//           System.out.println("업데이트 성공");
//        }
        ArrayList<Integer> commIdlist = new ArrayList<Integer>();
        commIdlist.add(68);// blog_id
        List<Comm> commList = session.selectList("selectCommsByCommIds", commIdlist);
        for (Comm comm2 : commList) {
           System.out.println(comm2);
        }
				session.commit();
			}catch(

	Exception e)
	{
				//session.rollback();
				e.printStackTrace();
			}finally
	{
		if (session != null)
			session.close();
	}
	}//main
}//class

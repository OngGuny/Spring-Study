package mybatis.test.main;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mybatis.test.dto.User;

public class UserTest {
	public static void main(String[] args) {
		String resource = "mybatis/test/sqlmapconfig/sqlMapConfig.xml"; //이안에 드라이버 접속하는 유저 아이디 드라이버 등등 있음 
		Reader reader;
		SqlSession session = null;
		try {
			reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			session = sqlMapper.openSession();
			/* insert */
			User user = new User();
			user.setEmail("a@a.com");
			user.setName("a");
			user.setPasswd("apass");
			int result = session.insert("insertUser", user);
			session.commit();
			if (result > 0) {
				System.out.println(user + "1번 성공 ");
			}

			// select
			List<User> list = session.selectList("selectAllUsers");
			for (User eachUser : list) {
				System.out.println("2번 성공" + eachUser);
			}
			// delete
			int result2 = session.delete("deleteUser", 4);
			session.commit();
			if (result2 > 0) {
				System.out.println("2번 삭제 성공");
			}

			// update
			User user2 = new User();
			user2.setSid(5);
			user2.setEmail("wdwd@wd.com");
			user2.setName("Dio");
			user2.setPasswd("muda");
			int result3 = session.update("updateUser", user2);
			session.commit();
			if (result3 > 0) {
				System.out.println("5번 수정 성공 ");
			}
		} catch (Exception e) { 
			e.printStackTrace();
		} finally {//자바일때만 이걸로 닫아줌 .스프링쓰면 안닫아줘도됨 알아서해줌 
			if(session!=null) session.close();
		}
	}// main
}// class

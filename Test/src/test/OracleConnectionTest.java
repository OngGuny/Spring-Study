package test;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleConnectionTest {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 이 클래스를 메모리에 로딩해주세요 하는것.
		} catch (Exception e) {
			e.printStackTrace();
		}

	}//static

	public static void main(String[] args) { 
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE",
					"book_ex",
					"book_ex"
					);
			System.out.println(conn);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}//main
}//class
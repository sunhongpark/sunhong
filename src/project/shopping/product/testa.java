package project.shopping.product;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

import javax.net.ssl.SSLContext;
public class testa {
	static String url="jdbc:mysql://localhost:3306";
	static String id="root";
	static String pw="tjsghd12";
	static Connection con=null;
	public static void main(String[] args) throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이버 연결 성공");
			con = DriverManager.getConnection(url,id,pw);
			System.out.println("DB연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 찾지 못함");
		}
	}

}

package project2;
import java.sql.*;
public class test {
	public static void main(String [] args) throws ClassNotFoundException,SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/java";
		String id="root";
		String pw="tjsghd12";
		Connection conn =DriverManager.getConnection(url,id,pw);
		if(conn==null){
			System.out.println("연결 실패");
		}
		
		String sql= "insert into test values(?)";
		PreparedStatement pstmt;
		Statement stmt;
		stmt=conn.createStatement();
		pstmt=conn.prepareStatement(sql);
		String st="aaa";
		pstmt.setString(1, st);
		
		
		conn.close();
	}
}

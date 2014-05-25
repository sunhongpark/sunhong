package project2.user;

import java.sql.*;

public class userDB {
	static PreparedStatement ps =null;
	static ResultSet re=null;
	static Statement st=null;
	static String sql;
	static String url="jdbc:mysql://localhost:3306/java";
	static String Did="root";
	static String Dpw="tjsghd12";
	public static boolean checkID(String id) throws ClassNotFoundException, SQLException{
		sql="select *from user where id=\""+id+"\"";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn =DriverManager.getConnection(url,Did,Dpw);
		st=conn.createStatement();
		re=st.executeQuery(sql);
		if(re.next()){
			return false;
		}
		else
		{
			conn.close();
			return true;
		}
		
	}
}

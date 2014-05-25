package project2.user;

import java.sql.*;

public class userDB {
	static PreparedStatement ps =null;
	static ResultSet re=null;
	static Statement st=null;
	static Connection conn=null;
	static String sql;
	static String url="jdbc:mysql://localhost:3306/java";
	static String Did="root";
	static String Dpw="tjsghd12";
	public static Connection access()throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn =DriverManager.getConnection(url,Did,Dpw);
		return conn;
	}
	public static boolean checkID(String id) throws ClassNotFoundException, SQLException{
		sql="select *from user where id=\""+id+"\"";
		Connection conn=access();
		st=conn.createStatement();
		re=st.executeQuery(sql);
		if(re.next()){
			conn.close();
			return false;
		}
		else
		{
			conn.close();
			return true;
		}
	}
	public static boolean checkNumber(String number,String number2) throws ClassNotFoundException, SQLException{
		sql="select *from user where number=\""+number+"\"&&number2=\""+number2+"\"";
		Connection conn=access();
		st=conn.createStatement();
		re=st.executeQuery(sql);
		if(re.next()){
			conn.close();
			return false;
		}
		else
		{
			conn.close();
			return true;
		}
	}
	public static boolean addUser(user u) throws ClassNotFoundException, SQLException{
		int x;
		sql="insert into user values(\""+u.getId()+"\","+u.type+",\""
				+u.getPw()+"\",\""+u.getName()+"\",\""+u.getNumber()+"\",\""
				+u.getNumber2()+"\","+u.getSex()+","+u.getGrade()+");";
		Connection conn=access();
		st=conn.createStatement();
		x=st.executeUpdate(sql);
		if(x>0)
		{
			conn.close();
			return true;
		}
		else{
			conn.close();
			return false;
		}
	}
	public static boolean addaddress(String id,String address,String type){
		return true;
	}
}

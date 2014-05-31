package project2.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import project2.user.user;

public class cartDB {
	static PreparedStatement ps =null;
	static ResultSet re=null;
	static Statement st=null;
	//static Connection conn=null;
	static String sql;
	static String url="jdbc:mysql://localhost:3306/java";
	static String Did="root";
	static String Dpw="tjsghd12";
	public static Connection access()throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn =DriverManager.getConnection(url,Did,Dpw);
		return conn;
	}
	public static boolean addlist(String id,int item) throws ClassNotFoundException, SQLException{
		int x;
		sql="insert into cartlist values(\""+id+"\","+item+");";
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
	public static ResultSet findcart(String id) throws ClassNotFoundException, SQLException{
		sql="select *from cartlist where user =\""+id+"\";";
		System.out.println(sql);
		Connection conn=access();
		st=conn.createStatement();
		re=st.executeQuery(sql);
		//conn.close();
		return re;
	}
	public static void deleteItem(String id,int valueAt) throws ClassNotFoundException, SQLException {
		sql="delete from cartlist where user =\""+id+"\" && item="+valueAt+";";
		System.out.println(sql);
		Connection conn=access();
		st=conn.createStatement();
		st.executeUpdate(sql);
		conn.close();
		
	}
	public static ResultSet Allcartlist() throws ClassNotFoundException, SQLException{
		sql="select *from cartlist;";
		System.out.println(sql);
		Connection conn=access();
		st=conn.createStatement();
		re=st.executeQuery(sql);
		//conn.close();
		return re;
		
	}
}

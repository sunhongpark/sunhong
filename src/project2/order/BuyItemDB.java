package project2.order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import project2.user.user;

public class BuyItemDB {
	static PreparedStatement ps =null;
	static ResultSet re=null;
	static Statement st=null;
	static String sql;
	static String url="jdbc:mysql://localhost:3306/java";
	static String Did="root";
	static String Dpw="tjsghd12";
	public static Connection access()throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn =DriverManager.getConnection(url,Did,Dpw);
		return conn;
	}
	public static boolean additem(buyitem i) throws ClassNotFoundException, SQLException{
		int x;
		sql="insert into buyitem values("+i.getNumber()+",\""
				+i.getSeller()+"\",\""+i.getUser()+"\","+i.getItemNumber()+","
				+i.getPay()+","+i.getState()+",\""+i.getAddress()+"\","+i.getNum()+");";
		System.out.println(sql);
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
	public static ResultSet findSeller(String id) throws ClassNotFoundException, SQLException {
		sql="select *from buyitem where seller =\""+id+"\";";
		System.out.println(sql);
		Connection conn=access();
		st=conn.createStatement();
		re=st.executeQuery(sql);
		//conn.close();
		return re;
	}
	public static ResultSet finduser(String id) throws ClassNotFoundException, SQLException {
		sql="select *from buyitem where user =\""+id+"\";";
		System.out.println(sql);
		Connection conn=access();
		st=conn.createStatement();
		re=st.executeQuery(sql);
		//conn.close();
		return re;
	}
	public static void shipItem(int valueAt) throws ClassNotFoundException, SQLException {
		sql="update buyitem set state =3 where inumber ="+valueAt+";";
		System.out.println(sql);
		Connection conn=access();
		st=conn.createStatement();
		st.executeUpdate(sql);
		conn.close();
		
	}
	public static void sucItem(int valueAt) throws ClassNotFoundException, SQLException {
		sql="update buyitem set state =5 where inumber ="+valueAt+";";
		System.out.println(sql);
		Connection conn=access();
		st=conn.createStatement();
		st.executeUpdate(sql);
		conn.close();
	}
	public static void payItem(int valueAt) throws ClassNotFoundException, SQLException {
		sql="update buyitem set state =2 where inumber ="+valueAt+";";
		System.out.println(sql);
		Connection conn=access();
		st=conn.createStatement();
		st.executeUpdate(sql);
		conn.close();
	}
	public static void recItem(int valueAt) throws ClassNotFoundException, SQLException {
		sql="update buyitem set state =4 where inumber ="+valueAt+";";
		System.out.println(sql);
		Connection conn=access();
		st=conn.createStatement();
		st.executeUpdate(sql);
		conn.close();
	}
	public static ResultSet Allbuyitem() throws ClassNotFoundException, SQLException{
		sql="select *from buyitem;";
		System.out.println(sql);
		Connection conn=access();
		st=conn.createStatement();
		re=st.executeQuery(sql);
		//conn.close();
		return re;
		
	}
}

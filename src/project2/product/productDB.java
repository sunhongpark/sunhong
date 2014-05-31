package project2.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import project2.user.user;

public class productDB {
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
	public static boolean addPorduct(String sql) throws ClassNotFoundException, SQLException{
		int x;
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
	public static ResultSet findproduct(String id) throws ClassNotFoundException, SQLException{
		sql="select *from product where seller =\""+id+"\";";
		System.out.println(sql);
		Connection conn=access();
		st=conn.createStatement();
		re=st.executeQuery(sql);
		//conn.close();
		return re;
		
	}
	public static void deleteP(int valueAt) throws ClassNotFoundException, SQLException {
		sql="delete from product where number="+valueAt+";";
		System.out.println(sql);
		Connection conn=access();
		st=conn.createStatement();
		st.executeUpdate(sql);
		conn.close();
		
	}
	public static void memberLeave(String id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int x;
		sql="delete from product where seller=\""+id+"\";";
		System.out.println(sql);
		Connection conn=access();
		st=conn.createStatement();
		x=st.executeUpdate(sql);
		conn.close();
		
	}
	public static void modifyState(int valueAt, int i) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		sql="update product set state ="+i+" where number ="+valueAt+";";
		System.out.println(sql);
		Connection conn=access();
		st=conn.createStatement();
		st.executeUpdate(sql);
		conn.close();
		
	}
	public static void modifynum(int valueAt, String text) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		sql="update product set num ="+text+" where number="+valueAt+";";
		System.out.println(sql);
		Connection conn=access();
		st=conn.createStatement();
		st.executeUpdate(sql);
		conn.close();
		
	}
	public static void modifypay(int valueAt, String text) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		sql="update product set pay ="+text+" where number="+valueAt+";";
		System.out.println(sql);
		Connection conn=access();
		st=conn.createStatement();
		st.executeUpdate(sql);
		conn.close();
		
	}
	public static ResultSet allProduct() throws ClassNotFoundException, SQLException {
		sql="select *from product;";
		System.out.println(sql);
		Connection conn=access();
		st=conn.createStatement();
		re=st.executeQuery(sql);
		//conn.close();
		return re;
	}
	public static void Decitem(int inumber,int inum) throws ClassNotFoundException, SQLException {
		int num = 0;
		sql="select *from product where number ="+inumber+";";
		System.out.println(sql);
		Connection conn=access();
		st=conn.createStatement();
		re=st.executeQuery(sql);
		while(re.next())
			 num=re.getInt(5);
		num-=inum;
		System.out.println(num);
		sql="update product set num ="+num+" where number ="+inumber+";";
		st.executeUpdate(sql);
		if(num<=0){
			sql="update product set state = 2 where number ="+inumber+";";
			st.executeUpdate(sql);
		}
		conn.close();
		
	}
	public static ResultSet findproduct(int i) throws ClassNotFoundException, SQLException{
		sql="select *from product where number ="+i+";";
		System.out.println(sql);
		Connection conn=access();
		st=conn.createStatement();
		re=st.executeQuery(sql);
		//conn.close();
		return re;
	}
	public static boolean addProduct(product p) throws ClassNotFoundException, SQLException{
		int x;
		sql="insert into product values("+p.getnumber()+",\""+p.getSeller()+"\",\""
				+p.getName()+"\","+p.getPay()+","+p.getNum()+","
				+p.getState()+");";
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
}

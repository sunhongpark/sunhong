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
	public static ResultSet findad(String id) throws ClassNotFoundException, SQLException{
		sql="select *from address where id=\""+id+"\";";
		System.out.println(sql);
		Connection conn=access();
		st=conn.createStatement();
		re=st.executeQuery(sql);
		conn.close();
		return re;
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
				+u.getNumber2()+"\","+u.getSex()+","+u.getGrade()+","+u.getState()+");";
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
	public static boolean addaddress(String id,String address,String type) throws ClassNotFoundException, SQLException{
		int x;
		sql="insert into address values(\""+id+"\",\""+address+"\",\""
				+type+"\");";
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
	public static boolean deleteAddress(String id,String type) throws ClassNotFoundException, SQLException{
		int x;
		sql="delete from address where id=\""+id+"\"&& type=\""+type+"\";";
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
	public static boolean memberLeave(String id) throws ClassNotFoundException, SQLException{
		int x;
		sql="delete from address where id=\""+id+"\";";
		System.out.println(sql);
		Connection conn=access();
		st=conn.createStatement();
		x=st.executeUpdate(sql);
		sql="delete from user where id=\""+id+"\";";
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
	public static boolean modifyAddress(String id,String address,String type) throws ClassNotFoundException, SQLException{
		int x;
		sql="update address set address =\""+address+"\" where id=\""+id+"\"&& type=\""+type+"\";";
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
	public static boolean modifyPw(String id,String pw) throws ClassNotFoundException, SQLException{
		int x;
		sql="update user set pw =\""+pw+"\" where id=\""+id+"\";";
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
	public static user login(String id,String pw) throws ClassNotFoundException, SQLException{
		sql="select *from user where id=\""+id+"\"&&pw=\""+pw+"\"";
		System.out.println(sql);
		Connection conn=access();
		st=conn.createStatement();
		re=st.executeQuery(sql);
		if(re.next()){
			System.out.println(re.getString(1)+" "+re.getString(3)+" "+re.getString(4)+" "+re.getInt(2)+" "+
					re.getString(5)+" "+re.getString(6)+" "+re.getInt(7)+" "+re.getInt(8)+" "+re.getInt(9));
			user u =new user(re.getString(1),re.getString(3),re.getString(4),re.getInt(2),
					re.getString(5),re.getString(6),re.getInt(7),re.getInt(8),re.getInt(9));
			System.out.println("DB ok");
			conn.close();
			return u;
		}
		else
		{
			conn.close();
			return null;
		}
	}
	public static ResultSet findAddress(String id) throws ClassNotFoundException, SQLException{
		sql="select *from address where id=\""+id+"\";";
		System.out.println(sql);
		Connection conn=access();
		st=conn.createStatement();
		re=st.executeQuery(sql);
		//conn.close();
		return re;
		
	}
	public static ResultSet findAlluser() throws ClassNotFoundException, SQLException{
		sql="select *from user;";
		System.out.println(sql);
		conn=access();
		st=conn.createStatement();
		re=st.executeQuery(sql);
		//conn.close();
		return re;
		
	}
	public static ResultSet findActivityuser() throws ClassNotFoundException, SQLException{
		sql="select *from user where state =\"1\";";
		System.out.println(sql);
		Connection conn=access();
		st=conn.createStatement();
		re=st.executeQuery(sql);
		//conn.close();
		return re;	
	}
	public static ResultSet findBlockuser() throws ClassNotFoundException, SQLException{
		sql="select *from user where state =\"2\";";
		System.out.println(sql);
		Connection conn=access();
		st=conn.createStatement();
		re=st.executeQuery(sql);
		//conn.close();
		return re;
		
	}
	public static ResultSet Alluser() throws ClassNotFoundException, SQLException{
		sql="select *from user;";
		System.out.println(sql);
		Connection conn=access();
		st=conn.createStatement();
		re=st.executeQuery(sql);
		//conn.close();
		return re;
		
	}
	public static ResultSet Alladdress() throws ClassNotFoundException, SQLException{
		sql="select *from address;";
		System.out.println(sql);
		Connection conn=access();
		st=conn.createStatement();
		re=st.executeQuery(sql);
		//conn.close();
		return re;
		
	}
	public static boolean modifyGrade(String id,int grade) throws ClassNotFoundException, SQLException{
		int x;
		sql="update user set grade ="+grade+" where id=\""+id+"\";";
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
	public static boolean modifyState(String id,int state) throws ClassNotFoundException, SQLException{
		int x;
		sql="update user set state ="+state+" where id=\""+id+"\";";
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
	
}

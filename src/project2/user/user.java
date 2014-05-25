package project2.user;
import java.sql.*;
public class user {
	protected String id;
	protected String pw;
	protected String name;
	protected int type;
	protected String number;
	protected String number2;
	protected int sex;
	protected int grade;
	
	public user(String id,String pw,String name,int type,String number,
			String number2,int sex,int grade){
		this.id=id;
		this.pw=pw;
		this.name=name;
		this.type=type;
		this.number=number;
		this.number2=number2;
		this.sex=sex;
		this.grade=grade;
	}
	public String getId(){return id;}
	public String getPw(){return pw;}
	public String getName(){return name;}
	public int getType(){return type;}
	public int getSex(){return sex;}
	public int getGrade(){return grade;}
	public String getNumber(){return number;}
	public String getNumber2(){return number2;}
}

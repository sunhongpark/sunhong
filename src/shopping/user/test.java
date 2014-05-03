package shopping.user;
import java.util.*;
/*
 * 
 */
public class test {
	static Scanner scan=new Scanner(System.in);
	static Cmanager u=new Cmanager();
	static String lid="null";
	static String nul="null";
	public static void join(){
		String id;
		String name;
		String pw;
		String ph;
		String addres;
		System.out.print("아이디 : ");
		id=scan.next();
		System.out.print("비밀번호 : ");
		pw=scan.next();
		System.out.print("이름 : ");
		name=scan.next();
		System.out.print("전화번호 : ");
		ph=scan.next();
		System.out.print("주소 : ");
		addres=scan.next();
		if(u.AddCustomer(id, pw, name, ph, addres))
			System.out.println("회원 가입 완료");
	}
	public static void change(){
		if(0==lid.compareTo(nul))
		{
			System.out.println("로그인 후 사용하세요");
			return;
		}
		u.Modify(lid);
	}
	public static void manager(){
		
	}
	public static void login(){
		String id;
		String pw;
		if(0==lid.compareTo(nul))
		{
			System.out.print("아이디 : ");
			id=scan.next();
			System.out.print("비밀번호 : ");
			pw=scan.next();
			if(u.Login(id, pw)){
				lid=id;
			}
		}
		else{
			if(u.Logout(lid))
			{
				System.out.println(lid+"님 이용해주셔서 감사합니다.");
				lid="null";
			}
			else System.out.println("err");
		}
			
	}
	public static void print(){
		u.print();
	}
	public static void main(String[] args){
		int cho = 0;
		while(cho!=5){
			System.out.print("(1)회원 가입 (2)로그인/로그아웃 (3)정보 수정 (4)출력 (5)종료 :");
			cho=scan.nextInt();
			switch(cho){
			case 1:
				join();
				break;
			case 2:
				login();
				break;
			case 3:
				change();
				break;
			case 4:
				print();
				break;
			}
		}
		
	}
}

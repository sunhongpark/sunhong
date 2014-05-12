package project.shopping.user;
import java.util.*;
/*
 * 판매자관련은 아직 물품 페키지를 구현 하지 않아 정확히 구현 하지 않음 차후 수정예정
 * 현제 구상중인 쇼핑몰은 옥션과 같은 느낌의 쇼핑몰
 * 다수의 사용자가 이용하며 다수의 판매자가 존재하고 그것을 관리하는 각각의 매니져가 존재
 * 그 매니져를 이용하여 admin이 사용자를 관리하는 형태의 user패키지를 구상중.
 * 사용자 등급은 따로 클래스로 만들지 않고 각 클래스 안에 속성으로 저장.
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

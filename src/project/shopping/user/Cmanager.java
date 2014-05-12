package project.shopping.user;
import java.util.*;
public class Cmanager {
	static Scanner scan=new Scanner(System.in);
	static int num=0;
	customer [] user =new customer[10];
	public boolean AddCustomer(String id, String pw, String name, String ph,String address){
		if(num<10){
			for(int i=0;i<num;i++)
			{
				if(user[i].CheckId(id)){
					System.out.println("아이디 중복");
					return false;
				}
			}
			user[num++]=new customer(id,pw,name,ph,address);
			return true;
		}
		else{
			System.out.println("회원가입 인원수 초과");
			return false;
		}
	}
	public boolean Login(String id, String pw){
		int i;
		for(i=0;i<num;i++)
		{
			if(user[i].CheckId(id)){
				if(user[i].CheckPw(pw))
				{
					user[i].login=true;
					System.out.println(user[i].GetId()+"님 환영합니다 .");
					user[i].print();
					return true;
				}
				else System.out.println("비밀번호가 일치하지 않습니다.");			}
		}
		if(i==num)
			System.out.println("해당 아이디가 존재하지 않습니다.");
		return false;
	}
	public boolean Logout(String id){
		for(int i=0;i<num;i++)
		{
			if(user[i].CheckId(id)){
				user[i].login=false;
				return true;
			}
		}
		return false;
	} 
	public void print(){
		for(int i=0;i<num;i++){
			user[i].Print();
		}
	}
	public void Modify(String id){
		int cho;
		int j=0;
		String pw;
		String mo;
		String adr;
		for(int i=0;i<num;i++)
		{
			if(user[i].CheckId(id))
				j=i;
		}
		System.out.println("비밀번호 : ");
		pw=scan.next();
		if(!user[j].CheckPw(pw)){
			System.out.println("비밀번호가 틀렸습니다.");
			return;
		}
		System.out.print("(1)비밀번호 (2)전화번호 (3)기본 주소 (4)주소 추가 (5)주소 삭제");
		cho=scan.nextInt();
		switch(cho){
		case 1:
			System.out.print("변경 내용 : ");
			mo=scan.next();
			user[j].ModifyPw(mo);
			break;
		case 2:
			System.out.print("변경 내용 : ");
			mo=scan.next();
			user[j].ModifyPh(mo);
			break;
		case 3:
			System.out.print("변경 내용 : ");
			mo=scan.next();
			user[j].ModifyAdr(mo);
			break;
		case 4:
			System.out.print("추가할 주소지 명칭 : ");
			mo=scan.next();
			System.out.print("주소 : ");
			adr=scan.next();
			user[j].AddAdres(mo, adr);
			break;
		case 5:
			user[j].ShowAdres();
			System.out.print("삭제할 주소명칭 : ");
			mo=scan.next();
			user[j].RemoveAdres(mo);
			break;
		}
	}
}

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
					System.out.println("���̵� �ߺ�");
					return false;
				}
			}
			user[num++]=new customer(id,pw,name,ph,address);
			return true;
		}
		else{
			System.out.println("ȸ������ �ο��� �ʰ�");
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
					System.out.println(user[i].GetId()+"�� ȯ���մϴ� .");
					user[i].print();
					return true;
				}
				else System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");			}
		}
		if(i==num)
			System.out.println("�ش� ���̵� �������� �ʽ��ϴ�.");
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
		System.out.println("��й�ȣ : ");
		pw=scan.next();
		if(!user[j].CheckPw(pw)){
			System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
			return;
		}
		System.out.print("(1)��й�ȣ (2)��ȭ��ȣ (3)�⺻ �ּ� (4)�ּ� �߰� (5)�ּ� ����");
		cho=scan.nextInt();
		switch(cho){
		case 1:
			System.out.print("���� ���� : ");
			mo=scan.next();
			user[j].ModifyPw(mo);
			break;
		case 2:
			System.out.print("���� ���� : ");
			mo=scan.next();
			user[j].ModifyPh(mo);
			break;
		case 3:
			System.out.print("���� ���� : ");
			mo=scan.next();
			user[j].ModifyAdr(mo);
			break;
		case 4:
			System.out.print("�߰��� �ּ��� ��Ī : ");
			mo=scan.next();
			System.out.print("�ּ� : ");
			adr=scan.next();
			user[j].AddAdres(mo, adr);
			break;
		case 5:
			user[j].ShowAdres();
			System.out.print("������ �ּҸ�Ī : ");
			mo=scan.next();
			user[j].RemoveAdres(mo);
			break;
		}
	}
}

package project.shopping.user;
import java.util.*;
/*
 * �Ǹ��ڰ����� ���� ��ǰ ��Ű���� ���� ���� �ʾ� ��Ȯ�� ���� ���� ���� ���� ��������
 * ���� �������� ���θ��� ���ǰ� ���� ������ ���θ�
 * �ټ��� ����ڰ� �̿��ϸ� �ټ��� �Ǹ��ڰ� �����ϰ� �װ��� �����ϴ� ������ �Ŵ����� ����
 * �� �Ŵ����� �̿��Ͽ� admin�� ����ڸ� �����ϴ� ������ user��Ű���� ������.
 * ����� ����� ���� Ŭ������ ������ �ʰ� �� Ŭ���� �ȿ� �Ӽ����� ����.
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
		System.out.print("���̵� : ");
		id=scan.next();
		System.out.print("��й�ȣ : ");
		pw=scan.next();
		System.out.print("�̸� : ");
		name=scan.next();
		System.out.print("��ȭ��ȣ : ");
		ph=scan.next();
		System.out.print("�ּ� : ");
		addres=scan.next();
		if(u.AddCustomer(id, pw, name, ph, addres))
			System.out.println("ȸ�� ���� �Ϸ�");
	}
	public static void change(){
		if(0==lid.compareTo(nul))
		{
			System.out.println("�α��� �� ����ϼ���");
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
			System.out.print("���̵� : ");
			id=scan.next();
			System.out.print("��й�ȣ : ");
			pw=scan.next();
			if(u.Login(id, pw)){
				lid=id;
			}
		}
		else{
			if(u.Logout(lid))
			{
				System.out.println(lid+"�� �̿����ּż� �����մϴ�.");
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
			System.out.print("(1)ȸ�� ���� (2)�α���/�α׾ƿ� (3)���� ���� (4)��� (5)���� :");
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

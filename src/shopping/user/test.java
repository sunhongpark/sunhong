package shopping.user;
import java.util.*;
public class test {
	static Scanner scan=new Scanner(System.in);
	static user [] u=new user[10];
	public static void join(){
		
	}
	public static void change(){
		
	}
	public static void manager(){
		
	}
	public static void main(String[] args){
		int cho = 0;
		while(cho!=4){
			System.out.print("(1)ȸ�� ���� (2)���� ���� (3)������ ����");
			cho=scan.nextInt();
			switch(cho){
			case 1:
				join();
				break;
			case 2:
				change();
				break;
			case 3:
				manager();
				break;
			}
		}
		
	}
}

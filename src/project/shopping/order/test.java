package project.shopping.order;
import project.shopping.product.*;
import java.util.*;
/*
 * ����ڴ� ī�� ȸ�翡 �����ؾ��ϸ�
 * ī�忡�� �̸��� ��й�ȣ ī�� ��ȣ�� ����
 * �ֹ��ÿ��� ��ǰ�� ������ Ȯ���ϰ� �ֹ��� ����.
 * ����� �ֹ���ȣ ī���ȣ�� �Է� �ް� ī�� ������ ��ġ�ϸ� ���� ����
 */
public class test {
	static product item;
	static creditcardcompany cards=new creditcardcompany("BC");//ī��� ����
	static lineitem orders =new lineitem();
	static Scanner scan=new Scanner(System.in);
	public static void main(String[] args){
		item=new product("��ǰ","123",500000,5);//��ǰ�� ���� �Ǿ��ٰ� �����ϰ� ���
		int ch=0;
		int num;
		int number;
		String name;
		String pw;
		order a;
		creditcard c;
		while(ch!=5){
			System.out.println("1.ī�� ���� 2.�ֹ� 3.����");
			ch=scan.nextInt();
			switch(ch){
			case 1:
				cards.CreateCard();
				break;
			case 2:
				orders.AddOrder(item);
				break;
			case 3:
				System.out.print("�ֹ���ȣ : ");
				num=scan.nextInt();
				a=orders.GetOrder(num);
				if(a==null)
				{
					System.out.println("�ֹ��� ����");
					break;
				}
				System.out.print("ī�� ��ȣ �Է� : ");
				number=scan.nextInt();
				c=cards.FindUser(number);
				System.out.print("����� : ");
				name=scan.next();
				System.out.print("��й�ȣ : ");
				pw=scan.next();
				if(a.payment())
				{
					if(c.payment(a.Getpay(), number, pw))
						/*
						 * ī�� ������ ��ġ�ϰ� �ֹ���� �����϶��� ����
						 */
						System.out.println("���� ����");
				}
				System.out.println(a.GetStatus());
				break;
			}
		}
		
	}
}

package project.shopping.order;
import java.util.*;
import project.shopping.product.product;
/*
 * �ֹ������� ����Ʈ
 * ��� �ֹ������� lineitem�� ����
 */
public class lineitem {
	Scanner scan=new Scanner(System.in);
	ArrayList<order> orders;
	int number=0;
	public lineitem(){
		orders=new ArrayList<order>();
	}
	public void AddOrder(product item){
		int num = 0;
		order a;
		System.out.print(item.GetName()+"�� ����");
		System.out.print("���� ���� : ");
		num=scan.nextInt();
		if(num<=0)
		{
			System.out.println("���� ����");
			return;
		}
		a=new order(item,num,number++);
		if(item.GetQuantity()>num)
		{
			System.out.println("�ֹ� ��ȣ : "+a.GetOrdernumber()+"\n����  : "+a.Getpay());
			a.ChangeStatus();
			orders.add(a);
		}
		else
		{
			System.out.println("��ǰ�� ������ �����մϴ�.");
		}
	}
	public order GetOrder(int number){
		Iterator<order> it = orders.iterator();
		order a;	
		while(it.hasNext())
		{
			a=it.next();
			if(a.GetOrdernumber()==number)
				return a;
		}
		return null;
	}
}

package project.shopping.order;
import java.util.*;
import project.shopping.product.product;
/*
 * 주문서들의 리스트
 * 모든 주문서들은 lineitem이 관리
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
		System.out.print(item.GetName()+"를 선택");
		System.out.print("수량 선택 : ");
		num=scan.nextInt();
		if(num<=0)
		{
			System.out.println("수량 오류");
			return;
		}
		a=new order(item,num,number++);
		if(item.GetQuantity()>num)
		{
			System.out.println("주문 번호 : "+a.GetOrdernumber()+"\n가격  : "+a.Getpay());
			a.ChangeStatus();
			orders.add(a);
		}
		else
		{
			System.out.println("물품의 수량이 부족합니다.");
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

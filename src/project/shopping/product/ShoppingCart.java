package project.shopping.product;
import java.util.*;
public class ShoppingCart {
	Scanner scan =new Scanner(System.in);
	protected product[] cart;
	protected int num;
	public ShoppingCart(){
		cart=new product[10];
		num=0;
	}
	public boolean AddShopping(product item){
		if(num<10){
			cart[num++]=item;
			return true;
		}
		else
			return false;
	}
	public void RemoveShopping(){
		int ch;
		System.out.print("�ɼ� ��ȣ ���� : ");
		ch=scan.nextInt();
		if(ch==num)
		{
			num--;
			return;
		}
		for(int i=ch-1;i<num;i++){
			cart[i]=cart[i+1];
		}
		num--;
	}
	public void print(){
		System.out.println("���� ���");
		for(int i=0;i<num;i++){
			System.out.println(i+1+".\n��ǰ�� : "+cart[i].GetName()+"\n���� : "+cart[i].GetPay()+"\nŸ�� :"+cart[i].type+"\n------------------");
		}
	}
}

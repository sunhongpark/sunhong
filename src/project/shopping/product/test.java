package project.shopping.product;
import java.util.*;
public class test {
	static int num=0;
	static productDetail [] item;
	static ShoppingCart cart=new ShoppingCart();
	static Scanner scan=new Scanner(System.in);
	static void remove(){
		int ch;
		System.out.print("옵션 번호 선택 : ");
		ch=scan.nextInt();
		if(ch==num)
		{
			num--;
			return;
		}
		for(int i=ch-1;i<num;i++){
			item[i]=item[i+1];
		}
		num--;
	}
	static boolean Additem(){
		String name;
		String number;
		int pay;
		int quantity;
		if(num>10)
			return false;
		System.out.print("상품명 : ");
		name=scan.next();
		System.out.print("상품번호 : ");
		number=scan.next();
		System.out.print("상품가격 : ");
		pay=scan.nextInt();
		System.out.print("상품수량 : ");
		quantity=scan.nextInt();
		item[num++]=new productDetail(name,number,pay,quantity);
		return true;
	}
	static void item(){
		int cho=0;
		int i;
		while(cho!=6){
			System.out.print("1.추가 2.옵션 추가 3.옵션 삭제 4.삭제 5.출력 : ");
			cho=scan.nextInt();
			switch(cho){
			case 1:
				Additem();
				break;
			case 2:
				System.out.print("상품 선택 : ");
				i=scan.nextInt();
				item[i-1].AddOption();
				break;
			case 3:
				System.out.print("상품 선택 : ");
				i=scan.nextInt();
				item[i-1].RemoveOption();
				break;
			case 4:
				remove();
				break;
			case 5:
				for(int j=0;j<num;j++)
					item[j].print();
				break;
			}
			
		}
	}
	static void shoppingcart(){
		int cho=0;
		int i=0;
		while(cho!=5){
			System.out.print("1.담기 2.삭제 3. 출력");
			cho=scan.nextInt();
			switch(cho){
			case 1:
				System.out.print("물건 번호 : ");
				i=scan.nextInt();
				cart.AddShopping(item[i-1].ReturnItem());
				break;
			case 2:
				cart.RemoveShopping();
				break;
			case 3:
				cart.print();
				break;
			}
		}
	}
	public static void main(String []  args){
		int cho=0;
		item=new productDetail[10];
		while(cho!=3){
			System.out.print("1.상품 2.쇼핑몰");
			cho=scan.nextInt();
			switch(cho){
			case 1:
				item();
				break;
			case 2:
				shoppingcart();
				break;
			}
		}
	}
}

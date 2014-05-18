package project.shopping.order;
import project.shopping.product.*;
import java.util.*;
/*
 * 사용자는 카드 회사에 가입해야하며
 * 카드에는 이름과 비밀번호 카드 번호가 존재
 * 주문시에는 물품의 개수를 확인하고 주문을 받음.
 * 결재시 주문번호 카드번호를 입력 받고 카드 정보가 일치하면 결제 성공
 */
public class test {
	static product item;
	static creditcardcompany cards=new creditcardcompany("BC");//카드사 생성
	static lineitem orders =new lineitem();
	static Scanner scan=new Scanner(System.in);
	public static void main(String[] args){
		item=new product("물품","123",500000,5);//물품은 선택 되었다고 가정하고 사용
		int ch=0;
		int num;
		int number;
		String name;
		String pw;
		order a;
		creditcard c;
		while(ch!=5){
			System.out.println("1.카드 생성 2.주문 3.결제");
			ch=scan.nextInt();
			switch(ch){
			case 1:
				cards.CreateCard();
				break;
			case 2:
				orders.AddOrder(item);
				break;
			case 3:
				System.out.print("주문번호 : ");
				num=scan.nextInt();
				a=orders.GetOrder(num);
				if(a==null)
				{
					System.out.println("주문이 없음");
					break;
				}
				System.out.print("카드 번호 입력 : ");
				number=scan.nextInt();
				c=cards.FindUser(number);
				System.out.print("사용자 : ");
				name=scan.next();
				System.out.print("비밀번호 : ");
				pw=scan.next();
				if(a.payment())
				{
					if(c.payment(a.Getpay(), number, pw))
						/*
						 * 카드 정보가 일치하고 주문대기 상태일때만 결제
						 */
						System.out.println("결제 성공");
				}
				System.out.println(a.GetStatus());
				break;
			}
		}
		
	}
}

package project.shopping.product;
import java.util.*;
public class productDetail{
	Scanner scan = new Scanner(System.in);
	protected product item;
	protected product [] options;
	protected int num=0;
	protected String name;
	protected String number;
	public productDetail(String name,String number,int pay,int quantity){
		this.name=name;
		this.number=number;
		item = new product(name,number,pay,quantity);
		options = new product[10];
		options[num++]=item;
	}
	public product ReturnItem(){
		int i=0;
		System.out.print("옵션 선택  : ");
		i=scan.nextInt();
		if(i>=num)
			return options[i-1];
		else return null;
	}
	public boolean AddOption(){
		String type;
		int pay;
		int quantity;
		if(num>10)
			return false;
		System.out.print("타입을 입력하세요 : ");
		type=scan.next();
		System.out.print("가격을 입력하세요 : ");
		pay=scan.nextInt();
		System.out.print("수량을 입력하세요 : ");
		quantity=scan.nextInt();
		options[num]=new product(name,number,pay,quantity);
		options[num++].SetType(type);
		return true;
	}
	public void RemoveOption(){
		int ch;
		System.out.print("옵션 번호 선택 : ");
		ch=scan.nextInt();
		if(ch==num)
		{
			num--;
			return;
		}
		for(int i=ch;i<num;i++){
			options[i]=options[i+1];
		}
		num--;
	}
	public boolean SellItem(){
		if(item.SellItem()){
			return true;
		}
		return false;
	}
	public void print(){
		for(int i=0;i<num;i++){
			if(i==0)
				System.out.println(i+1+"."+"\n상품명 : "+options[i].name+"\n상품 번호 : "+options[i].number+"\n타입 : "+options[i].type+
					"\n가격 : "+options[i].pay+"\n수량 : "+options[i].quantity+"\n상태 : "+options[i].state);
			else
				System.out.println("타입 : "+options[i].type+"\n가격 : "+options[i].pay+
						"\n수량 : "+options[i].quantity+"\n상태 : "+options[i].state);
		}
		System.out.println("---------------");
	}
	
}

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
		System.out.print("�ɼ� ����  : ");
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
		System.out.print("Ÿ���� �Է��ϼ��� : ");
		type=scan.next();
		System.out.print("������ �Է��ϼ��� : ");
		pay=scan.nextInt();
		System.out.print("������ �Է��ϼ��� : ");
		quantity=scan.nextInt();
		options[num]=new product(name,number,pay,quantity);
		options[num++].SetType(type);
		return true;
	}
	public void RemoveOption(){
		int ch;
		System.out.print("�ɼ� ��ȣ ���� : ");
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
				System.out.println(i+1+"."+"\n��ǰ�� : "+options[i].name+"\n��ǰ ��ȣ : "+options[i].number+"\nŸ�� : "+options[i].type+
					"\n���� : "+options[i].pay+"\n���� : "+options[i].quantity+"\n���� : "+options[i].state);
			else
				System.out.println("Ÿ�� : "+options[i].type+"\n���� : "+options[i].pay+
						"\n���� : "+options[i].quantity+"\n���� : "+options[i].state);
		}
		System.out.println("---------------");
	}
	
}

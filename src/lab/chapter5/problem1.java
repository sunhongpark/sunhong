package lab.chapter5;
import java.util.Scanner;
abstract class printer{
	String model;
	String company;
	int paper;
	int interF;
	public printer(){
		
	}
	public printer(String model,String company){
		this.model=model;
		this.company=company;
		paper=2;
		interF=1;
	}
	abstract void print();
	public void SetInterF(int interF){
		if(interF>2||interF<1){
			System.out.println("�߸��� ���� ���");
			return;
		}
		this.interF=interF;
		}
	public void AddPaper(int paper){this.paper+=paper;}
	public void Pdata(){
		System.out.println("�𵨸� : "+model+"\nȸ��� : "+company);
		if(interF==1)
			System.out.println("���� ���� : USB");
		if(interF==2)
			System.out.println("���� ���� : ���� �������̽�");
		System.out.println("���̷� : "+paper);
	}
}
class InkPrinter extends printer{
	int ink;
	public InkPrinter(String model,String company){
		super(model,company);
		ink=100;
	}
	public void print(){
		if(ink<=0){
			System.out.println("��ũ�� ���� �մϴ�.");
			return;
		}
		if(paper<=0){
			System.out.println("���̰� �����մϴ�.");
			return;
		}
		ink--;
		paper--;
		System.out.println(model+"\n���� ��ũ�� : "+ink+"\n���� �ܷ� : "+paper);
	}
	public void AddInk(int ink){this.ink+=ink;}
	public void ExtraInk(){
		System.out.println("���� ��ũ��: "+ink);
	}
	public void Pdata(){
		super.Pdata();
		this.ExtraInk();
	}
}
class LaserPrinter extends printer{
	int toner;
	public LaserPrinter(String model,String company){
		super(model,company);
		toner=100;
	}
	public void print(){
		if(toner<=0){
			System.out.println("��ʰ� ���� �մϴ�.");
			return;
		}
		if(paper<=0){
			System.out.println("���̰� �����մϴ�.");
			return;
		}
		toner--;
		paper--;
		System.out.println(model+"\n��ũ �ܷ� : "+toner+"\n���� �ܷ� : "+paper);
	}
	public void AddToner(int toner){this.toner+=toner;}
	public void ExtraToner(){
		System.out.println("���� ��ũ��: "+toner);
	}
	public void Pdata(){
		super.Pdata();
		this.ExtraToner();
	}
}
public class problem1 {
	public static void show(InkPrinter p){
		int x,num;
		Scanner scan =new Scanner(System.in);
		System.out.print("(1)����Ʈ (2)���� �ֱ� (3)��ũ ���� (4)���� (5)���� ��� ����");
		x=scan.nextInt();
		switch(x){
		case 1:
			p.print();
			break;
		case 2:
			System.out.print("���� ���̼� �Է� : ");
			num=scan.nextInt();
			p.AddPaper(num);
			break;
		case 3:
				p.AddInk(80);
			break;
		case 4:
			p.Pdata();
		case 5:
			System.out.print("���� ��� ���� (1) USB (2) ���� �������̽�");
			num=scan.nextInt();
			p.SetInterF(num);
			break;
		default :
			System.out.println("�߸��� �Է�");
		}
	}
	public static void show(LaserPrinter p){
		int x,num;
		Scanner scan =new Scanner(System.in);
		System.out.print("(1)����Ʈ (2)���� �ֱ� (3)��ũ ���� (4)���� (5)���� ��� ����");
		x=scan.nextInt();
		switch(x){
		case 1:
			p.print();
			break;
		case 2:
			System.out.print("���� ���̼� �Է� : ");
			num=scan.nextInt();
			p.AddPaper(num);
			break;
		case 3:
				p.AddToner(80);
			break;
		case 4:
			p.Pdata();
		case 5:
			System.out.print("���� ��� ���� (1) USB (2) ���� �������̽�");
			num=scan.nextInt();
			p.SetInterF(num);
			break;
		default :
			System.out.println("�߸��� �Է�");
		}
	}
	public static void main(String[] agrs){
		Scanner scan =new Scanner(System.in);
		int cho=1;
		InkPrinter i = new InkPrinter("INK-123","�缺");
		LaserPrinter l= new LaserPrinter("Laser-852","MG");
		while(cho!=3){
			System.out.print("����Ʈ�� �����͸� �����ϼ��� (1)��ũ (2)������ (3)���� : ");
			cho=scan.nextInt();
			switch(cho){
			case 1:
				show(i);
				break;
			case 2:
				show(l);
				break;
			case 3:
				System.out.print("���� �մϴ�.");
				break;
				default:
					System.out.print("�߸��� �Է�");
					
			}
		}
	}

}


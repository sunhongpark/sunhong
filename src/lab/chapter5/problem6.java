package lab.chapter5;
import java.util.Scanner;
class Dobject{
	public Dobject next;
	public Dobject(){next=null;}
	public void draw(){
		System.out.print("Dobject draw->");
	}
	public void delete(){
		next=null;
	}
}
	class line extends Dobject{
		public void draw(){
			System.out.print("line draw->");
		}
	}
	class rect extends Dobject{
		public void draw(){
			System.out.print("rect draw->");
		}
	}
	class circle extends Dobject{
		public void draw(){
			System.out.print("circle draw->");
		}
	}
public class problem6 {
	static void insert(Dobject s,int num){
		Dobject p;
		p=s;
		while(p.next != null){
			p=p.next;
		}
		switch(num){
		case 1:
			Dobject l =new line();
			p.next=l;
			break;
		case 2:
			p.next=new rect();
			break;
		case 3:
			p.next=new circle();
			break;
		}
	}
	public static void print(Dobject s){
		Dobject p;
		p=s;
		if(p.next==null)
			return;
		do{
			p=p.next;
			p.draw();
		}while(p.next!=null);
		System.out.print("\n");
	}
	public static void delete(Dobject s){
		Dobject p,d;
		d=p=s;
		while(p.next != null){
			d=p;
			p=p.next;
		}
		if(d!=p)
			d.next=null;
	}
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		Dobject start =new Dobject();
		int cho=0,num;
		while(cho!=4){
			System.out.print("(1)삽입 (2)삭제 (3)모두보기 (4)종료 : ");
			cho=scan.nextInt();
			switch(cho){
			case 1:
				System.out.print("(1)직선 (2)사각형 (3) 원 : ");
				num=scan.nextInt();
				insert(start,num);
				break;
			case 2:
				delete(start);
				break;
			case 3:
				print(start);
				break;
			case 4:
				System.out.println("종료");
				break;
				default:
					System.out.println("입력 범위 초과");
			}
		}
	}
}

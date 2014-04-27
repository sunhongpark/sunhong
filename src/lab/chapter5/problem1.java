package lab.chapter5;
import java.util.Scanner;
abstract class printer{//추상 클래스 프린트
	String model;
	String company;
	int paper;
	int interF;
	public printer(){
		
	}
	public printer(String model,String company){
		this.model=model;
		this.company=company;
		paper=20;
		interF=1;
		//초기화
	}
	abstract void print();//프린트 방식은 프린트마다 다르게
	public void SetInterF(int interF){//연결방식 설정
		if(interF>2||interF<1){
			System.out.println("잘못된 연결 방식");
			return;
		}
		this.interF=interF;
		}
	public void AddPaper(int paper){this.paper+=paper;}//용지 추가
	public void Pdata(){//프린터 정보 확인
		System.out.println("모델명 : "+model+"\n회사명 : "+company);
		if(interF==1)
			System.out.println("연결 종류 : USB");
		if(interF==2)
			System.out.println("연결 종류 : 병렬 인터페이스");
		System.out.println("종이량 : "+paper);
	}
}
class InkPrinter extends printer{//잉크 프린터 클래스 생성
	int ink;
	public InkPrinter(String model,String company){
		super(model,company);//슈퍼클래스 생성자 호출
		ink=100;
	}
	public void print(){
		if(ink<=0){
			System.out.println("잉크가 부족 합니다.");
			return;
		}
		if(paper<=0){
			System.out.println("종이가 부족합니다.");
			return;
		}
		//종이나 잉크가 부족할때 종료
		ink--;
		paper--;
		//프린트할때마다 잉크와 종이가 1개씩 감소
		System.out.println(model+"\n남은 잉크양 : "+ink+"\n종이 잔량 : "+paper);
	}
	public void AddInk(int ink){this.ink+=ink;}//잉크 충전
	public void ExtraInk(){//남은 잉크양 출력
		System.out.println("남은 잉크양: "+ink);
	}
	public void Pdata(){
		super.Pdata();
		this.ExtraInk();
		//프린트 정보 출력
	}
}
class LaserPrinter extends printer{//레이저 프린터 클래스 생성
	int toner;
	public LaserPrinter(String model,String company){
		super(model,company);
		toner=100;
	}
	public void print(){
		if(toner<=0){
			System.out.println("토너가 부족 합니다.");
			return;
		}
		if(paper<=0){
			System.out.println("종이가 부족합니다.");
			return;
		}
		toner--;
		paper--;
		System.out.println(model+"\n잉크 잔량 : "+toner+"\n종이 잔량 : "+paper);
	}
	public void AddToner(int toner){this.toner+=toner;}
	public void ExtraToner(){
		System.out.println("남은 잉크양: "+toner);
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
		System.out.print("(1)프린트 (2)용지 넣기 (3)잉크 충전 (4)정보 (5)연결 방식 선택");
		x=scan.nextInt();
		switch(x){
		case 1:
			p.print();
			break;
		case 2:
			System.out.print("넣을 종이수 입력 : ");
			num=scan.nextInt();
			p.AddPaper(num);
			break;
		case 3:
				p.AddInk(80);//잉크는 80씩 충전
			break;
		case 4:
			p.Pdata();
			break;
		case 5:
			System.out.print("연결 방식 선택 (1) USB (2) 병렬 인터페이스");
			num=scan.nextInt();
			p.SetInterF(num);
			break;
		default :
			System.out.println("잘못된 입력");
		}
	}
	public static void show(LaserPrinter p){
		int x,num;
		Scanner scan =new Scanner(System.in);
		System.out.print("(1)프린트 (2)용지 넣기 (3)잉크 충전 (4)정보 (5)연결 방식 선택");
		x=scan.nextInt();
		switch(x){
		case 1:
			p.print();
			break;
		case 2:
			System.out.print("넣을 종이수 입력 : ");
			num=scan.nextInt();
			p.AddPaper(num);
			break;
		case 3:
				p.AddToner(80);
			break;
		case 4:
			p.Pdata();
			break;
		case 5:
			System.out.print("연결 방식 선택 (1) USB (2) 병렬 인터페이스");
			num=scan.nextInt();
			p.SetInterF(num);
			break;
		default :
			System.out.println("잘못된 입력");
		}
	}
	public static void main(String[] agrs){
		Scanner scan =new Scanner(System.in);
		int cho=1;
		InkPrinter i = new InkPrinter("INK-123","사성");
		LaserPrinter l= new LaserPrinter("Laser-852","MG");
		while(cho!=3){
			System.out.print("프린트할 프린터를 선택하세요 (1)잉크 (2)레이저 (3)종료 : ");
			cho=scan.nextInt();
			switch(cho){
			case 1:
				show(i);
				break;
			case 2:
				show(l);
				break;
			case 3:
				System.out.print("종료 합니다.");
				break;
				default:
					System.out.print("잘못된 입력");
					
			}
		}
	}

}


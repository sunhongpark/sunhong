package quiz3;
import java.util.Scanner;
abstract class seat{//추상 클래스 seat
	public String customer[] =new String[10];//좌석 10개
	public String nul="___";//빈좌석
	public static int pos;//사용자가 선택한 위치를 저장하는 static 변수
	public seat(){
		for(int i=0;i<customer.length;i++)
			customer[i]="___";
	}
	public boolean scan(String name){
		for(int i=0;i<customer.length;i++){
			if(customer[i].compareTo(name)==0){//문자열 비교
				pos=i;//찾은 자리의 인덱스 저장
				return true;
			}
		}
			
		return false;
	}
	public void cancel(String name){
		if(scan(name)){
			customer[pos]="___";//좌석 초기화
		}
		else{
			System.out.println("없는 이름 입니다.");
		}
	}
	public void reservation(int x,String name){
		if(x>10||x<1)//범위가 초과시 true
		{
			System.out.println("없는 자리 입니다.");
			return;
		}
		if(customer[x-1].compareTo(nul)==0){//빈자리이면 예약
			customer[x-1]=name;
		}
		else{
			System.out.println("이미 예약된 자리 입니다.");
		}
	}
	abstract public void Print();
}
class S extends seat{//S좌석
	public void Print(){
		System.out.print("S>>");
		for(int i=0;i<customer.length;i++){
			System.out.print(customer[i]+" ");
		}
		System.out.print("\n");
	}
}
class A extends seat{//A좌석
	public void Print(){
		System.out.print("A>>");
		for(int i=0;i<customer.length;i++){
			System.out.print(customer[i]+" ");
		}
		System.out.print("\n");
	}
}
class B extends seat{//B좌석
	public void Print(){
		System.out.print("B>>");
		for(int i=0;i<customer.length;i++){
			System.out.print(customer[i]+" ");
		}
		System.out.print("\n");
	}
}
public class quiz3_2 {
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		int cho1=0,cho2=0,num;
		String name;
		seat customer[]=new seat[3];
		customer[0]=new S();
		customer[1]=new A();
		customer[2]=new B();
		while(cho1!=4){
			System.out.print("예약<1>, 조회<2>, 취소<3>, 끝내기<4> >>");
			cho1=scan.nextInt();
			switch(cho1){
			case 1:
				System.out.print("좌석 구분 S<1>,A<2>,B<3> >>");
				cho2=scan.nextInt();
				customer[cho2-1].Print();
				System.out.print("이름 >>");
				name=scan.next();
				System.out.print("번호 >>");
				num=scan.nextInt();
				customer[cho2-1].reservation(num,name);
				break;
			case 2:
				for(int i=0;i<customer.length;i++)
					customer[i].Print();
				break;
			case 3:
				System.out.print("좌석 구분 S<1>,A<2>,B<3> >>");
				cho2=scan.nextInt();
				customer[cho2-1].Print();
				System.out.print("이름 >>");
				name=scan.next();
				customer[cho2-1].cancel(name);
				break;
			case 4:
				System.out.print("공연 예약 시스템 종료 !");
				break;
			default:
					System.out.println("메뉴 입력 오류 다시 입력하세요 !");
			}
		}
	}
}

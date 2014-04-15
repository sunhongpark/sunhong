package quiz3;
import java.util.Scanner;
abstract class Calcu{
	int x;
	int y;
	public void setValue(int x,int y){
		this.x=x;
		this.y=y;
	}
	abstract int calcuate();
}
class Add extends Calcu{
	public int calcuate(){
		return x+y;
	}
}
class Sub extends Calcu{
	public int calcuate(){
		return x-y;
	}
	
}
class Mul extends Calcu{
	public int calcuate(){
		return x*y;
	}
	
}
class Div extends Calcu{
	public int calcuate(){
		return x/y;
	}
	
}
public class quiz3_4 {
	public static void main(String[] args){
		Calcu ca;
		int x,y;
		char op;
		String ch;
		Scanner scan =new Scanner(System.in);
		System.out.print("두 정수와 연산자를 입력하시오 : ");
		try{
			x=scan.nextInt();
			y=scan.nextInt();
			ch=scan.next();
			op=ch.charAt(0);
			switch(op){
			case '+' :
				ca=new Add();
				ca.setValue(x,y);
				System.out.println("값 : "+ca.calcuate());
				break;
			case '-' :
				ca=new Sub();
				ca.setValue(x,y);
				System.out.println("값 : "+ca.calcuate());
				break;
			case '*' :
				ca=new Mul();
				ca.setValue(x,y);
				System.out.println("값 : "+ca.calcuate());
				break;
			case '/' :
				ca=new Div();
				ca.setValue(x,y);
				System.out.println("값 : "+ca.calcuate());
				break;
				default:
					System.out.println("연산자 입력 오류");
			}
		}
		catch(Exception e){
			System.out.println("순서대로 입력하시오!");
		}
	}
}

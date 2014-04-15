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
class Sub{
	
}
class Mul{
	
}
class Div{
	
}
public class quiz3_4 {
	public static void main(String[] args){
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
			System.out.print(x+op+y);
		}
		catch(Exception e){
			System.out.println("순서대로 입력하시오!");
		}
	}
}

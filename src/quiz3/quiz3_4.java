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
		System.out.print("�� ������ �����ڸ� �Է��Ͻÿ� : ");
		try{
			x=scan.nextInt();
			y=scan.nextInt();
			ch=scan.next();
			op=ch.charAt(0);
			System.out.print(x+op+y);
		}
		catch(Exception e){
			System.out.println("������� �Է��Ͻÿ�!");
		}
	}
}

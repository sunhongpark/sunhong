package quiz3;
import java.util.Scanner;
abstract class Calcu{//�߻�Ŭ���� ����
	int x;
	int y;
	public void setValue(int x,int y){
		this.x=x;
		this.y=y;
	}
	abstract int calcuate();
}
class Add extends Calcu{//����
	public int calcuate(){
		return x+y;
	}
}
class Sub extends Calcu{//����
	public int calcuate(){
		return x-y;
	}
	
}
class Mul extends Calcu{//����
	public int calcuate(){
		return x*y;
	}
	
}
class Div extends Calcu{//������
	public int calcuate(){
		return x/y;
	}
	
}
public class quiz3_4 {
	public static void main(String[] args){
		Calcu ca;
		int x,y;
		char op;//������ ����
		String ch;
		Scanner scan =new Scanner(System.in);
		System.out.print("�� ������ �����ڸ� �Է��Ͻÿ� : ");
		try{
			x=scan.nextInt();
			y=scan.nextInt();
			ch=scan.next();
			op=ch.charAt(0);
			switch(op){
			case '+' :
				ca=new Add();//�� ĳ����
				ca.setValue(x,y);
				System.out.println("�� : "+ca.calcuate());
				break;
			case '-' :
				ca=new Sub();
				ca.setValue(x,y);
				System.out.println("�� : "+ca.calcuate());
				break;
			case '*' :
				ca=new Mul();
				ca.setValue(x,y);
				System.out.println("�� : "+ca.calcuate());
				break;
			case '/' :
				ca=new Div();
				ca.setValue(x,y);
				System.out.println("�� : "+ca.calcuate());
				break;
				default:
					System.out.println("������ �Է� ����");
			}
		}
		catch(Exception e){
			System.out.println("������� �Է��Ͻÿ�!");
		}
	}
}

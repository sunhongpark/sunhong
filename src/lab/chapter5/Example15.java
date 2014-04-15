package lab.chapter5;
abstract class Example15_A{
	int a;
	int b;
	public void setA(int i){
		a=i;
	}
	public void setB(int i){
		b=i;
	}
	public abstract int getA();
	public abstract int getB();
}
class Example15_B extends Example15_A{
	public int getA(){
		return a;
	}
	public int getB(){
		return b;
	}
}
public class Example15 {
	public static void main(String[] args){	
		Example15_B b= new Example15_B();
		b.setA(12);
		b.setB(15);
		System.out.println("A="+b.getA()+" B="+b.getB());
	}
}

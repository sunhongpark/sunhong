package lab.chapter5;
abstract class Example16_A{
	void f(){}
}
public class Example16 extends Example16_A {
	public void f(){
		System.out.println("aaaa");
	}
	public static void main(String[] args){
		//Example16_A a=new Example16_A();
		//a.f();
		Example16 b= new Example16();
		b.f();
	}
}

package lab.chapter5;
class Example8_A{
public Example8_A(){
	System.out.println("持失切 A");
}
public Example8_A(int x){
	System.out.println("持失切 A:"+x);
}
}
class Example8_B extends Example8_A{
public Example8_B(int x){
	System.out.println("持失切 B:"+x);
}
}
public class Example8 {
	public static void main(String[] args){
		Example8_A a =new Example8_A(10);
		Example8_B b =new Example8_B(11);
	}
}

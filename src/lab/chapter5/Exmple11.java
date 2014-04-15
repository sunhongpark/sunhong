package lab.chapter5;
class Example11_A{
	int i;
}
class Example11_B extends Example11_A{
	int j;
}
class Example11_C extends Example11_B{
	int k;
}
class Example11_D extends  Example11_B{
	int k;
}
public class Exmple11 {
	public static void main(String[] args){
		Example11_A a =new Example11_A();
		Example11_A b =new Example11_B();
		Example11_A c =new Example11_C();
		Example11_A d =new Example11_D();
		
		System.out.println(a instanceof Example11_B);
		System.out.println(a instanceof Example11_D);
		System.out.println(b instanceof Example11_A);
		System.out.println(b instanceof Example11_D);
		System.out.println(c instanceof Example11_B);
		System.out.println(c instanceof Example11_A);
		System.out.println(d instanceof Example11_B);
		System.out.println(d instanceof Example11_A);
	}
}

package lab.chapter5;
class Example14_A{
	protected String name;
	public void print(){
		show();
	}
	public void show(){
		System.out.println("Object A�� show");
	}
}
class Example14_B extends Example14_A{
	public void show(){
		System.out.println("Object B�� show");
	}
}

public class Example14 {

	public static void main(String[] args){
		Example14_A b=new Example14_B();
		b.print();
	}

}

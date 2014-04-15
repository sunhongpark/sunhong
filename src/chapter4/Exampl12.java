package chapter4;

public class Exampl12 {
	int num;
	String name;
	
	public Exampl12(int i, String s){
		num=i;
		name=s;
	}
	public Exampl12(int i){
		this(i,null);
	}
	public Exampl12(){
		this(0,null);
		System.out.println("생성자가 호출되었음");
	}
	public static void main(String[] args){
		Exampl12 obj1 =new Exampl12(1);
		Exampl12 obj2 =new Exampl12();
	}

}

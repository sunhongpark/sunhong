package lab.chapter5;

public class Example3_A {
	int data1;
	char data2;
	public int getData1(){
		return data1;
	}
	public char getData2(){
		return data2;
	}
	public static void main(String[] args){
		System.out.println("aaaa");
	}
}

class EXample3_B extends Example3_A{
	float field1;
	String field2;
	public float getField1(){
		return field1;
	}
	public String getField2(){
		return field2;
	}
}
package lab.chapter5;

public class Example4_A {
	private int n;
	public int getN(){
		return n;
	}
	public void setN(int i){
		n=i;
	}
	public static void main(String[] args){
		
	}
}
class Example4_B extends Example4_A{
	public String s;
	public int m;
	private char c;
	public char getC(){
		return c;
	}
	public void setC(char ch){
		c=ch;
	}
}
class Example4_C extends Example4_B{
	public double d;
}
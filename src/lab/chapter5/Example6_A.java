package lab.chapter5;

public class Example6_A {
	public int i;
	protected int j;
	public void setJ(int n){
		j=n;
	}
	public int getJ(){
		return j;
	}
}
class Example6_B extends Example6_A{
	private int n;
	public void setN(int i){
		n=i;
	}
	public int getN(){
		return n;
	}
	public int getSum(){
		return n+i+j;
	}
}

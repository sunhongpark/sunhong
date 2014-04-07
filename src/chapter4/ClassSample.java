package chapter4;

public class ClassSample {
	public int doAdd(int i,int j){
		return i+j;
	}
	public float doAdd(float i,float j){
		return i+j;
	}
	public static void main(String[] args)
	{
		int x;
		float y;
		ClassSample a =new ClassSample();
		x=a.doAdd(2, 3);
		y=a.doAdd(1.5f, 2.2f);
		System.out.println("x ="+x +"\ny ="+y);
	}
}

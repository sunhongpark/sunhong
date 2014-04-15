package chapter4;
class SmpleClass{
	public void addAndStore(int i,int j){
		i=i+j;
	}
}
public class Example8 extends SmpleClass{
	public static void main(String agrs[])
	{
		SmpleClass aClass = new SmpleClass();
		int num =15;
		aClass.addAndStore(num,10);
		System.out.println(num);
	}

}

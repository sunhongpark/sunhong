package chapter4;
class SampleClass2{
	private int id;
	public int getId()
	{
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
}
public class Example15 {
	public static void main(String[] agrs)
	{
		SampleClass2 obj = new SampleClass2();
		obj.setId(10);
		System.out.println(obj.getId());
	}

}

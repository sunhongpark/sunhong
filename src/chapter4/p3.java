package chapter4;

class Wine{
	protected String manufacture;
	protected String name;
	protected String country;
	protected String region;
	protected String kind;
	protected int year,grade;
	public Wine()
	{
		manufacture="�ڵ���";
		name="���";
	}
	public Wine(String manufacture,String name)
	{
		this.manufacture=manufacture;
		this.name=name;
	}
	public void print()
	{
		System.out.println(manufacture+", "+name);
	}
}
public class p3 extends Wine {

	public static void main(String[] args)
	{
		Wine line1 = new Wine();
		Wine line2 = new Wine("�Ｚ","����");
		line1.print();
		line2.print();
	}

}

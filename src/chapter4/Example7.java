package chapter4;


class Person {
	protected String name;
	protected int age;
	
	public Person(){
		
	}
	public Person(String name, int age)
	{
		this.name = name;
		this.age=age;
	}
	public void print()
	{
		System.out.println("�̸� : "+name+"\n���� :  "+age);
	}
	
}

public class Example7 extends Person{
	public static void main(String[] args)
	{
		Person aPerson = new Person("ȫ�浿",17);
		aPerson.print();
	}

}


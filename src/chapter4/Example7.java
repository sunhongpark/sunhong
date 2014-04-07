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
		System.out.println("이름 : "+name+"\n나이 :  "+age);
	}
	
}

public class Example7 extends Person{
	public static void main(String[] args)
	{
		Person aPerson = new Person("홍길동",17);
		aPerson.print();
	}

}


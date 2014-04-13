package quiz3;
class Person{
	static void x(){
		System.out.println("Person.x().....");
	}
}
class Student extends Person{
	static void x(){
		System.out.println("Student.x().....");
	}
}
public class quiz2 {
	public static void main(String[] args){
		Person p=new Student();
		p.x();
	}

}

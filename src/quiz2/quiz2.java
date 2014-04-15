package quiz2;

public class quiz2 {
	quiz2(){
		System.out.println(this);
	}
	static public void main(String[] args){
		quiz2 t= new quiz2();
		System.out.println(t);
		quiz2 t2= new quiz2();
		System.out.println(t2);
		t=t2;
		System.out.println(t);
		
	}
}

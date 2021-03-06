package lab.chapter5;
class Cpoint{
	int x,y;
	String color;
	public Cpoint(int x,int y){
		this.x=x;
		this.y=y;
	}
	public void show(){
		if(color==null)//컬러 값이 널이면 출력
			System.out.println("("+x+","+y+")");
		else//아니면 출력
			System.out.println("("+x+","+y+")"+color);
	}
	public String toString(){//6장 참고 
		return "("+x+","+y+") 입니다.";	
	}
}
class Ccolorproint extends Cpoint{
	public Ccolorproint(int x,int y,String color){
		super(x,y);
		this.color=color;//Ccolorproint에서만 color값을 가지고 있어서 show에서 else값 출력
	}
	public String toString(){
		return "("+x+","+y+") 입니다.";	
	}
}
public class problem4 {
	public static void main(String[] args){
		Cpoint a,b;
		a=new Cpoint(2,3);
		b=new Ccolorproint(3,4,"red");
		a.show();
		b.show();
		System.out.println(a);
		System.out.println(b);
	}
}

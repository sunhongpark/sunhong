package lab.chapter5;
abstract class Mypoint{
	int x,y;
	public Mypoint(int x,int y){
		this.x=x;
		this.y=y;
	}
	protected abstract void move(int x,int y);
	protected abstract void reverse();
	protected void show(){
		System.out.println(x+","+y);
	}
}
class Mycoloerpoint extends Mypoint{
	String color;
	public Mycoloerpoint(int x,int y,String color){
		super(x,y);
		this.color=color;
	}
	protected void move(int x,int y){
		this.x=x;
		this.y=y;
	}
	protected void reverse(){
		int temp;
		temp=x;
		x=y;
		y=temp;
	}
	protected void show(){
		System.out.println(x+","+y+color);
	}
}
public class problem5 {
	public static void main(String[] args){
		Mypoint p =new Mycoloerpoint(2,3,"blue");
		p.move(3,4);
		p.reverse();
		p.show();
	}

}

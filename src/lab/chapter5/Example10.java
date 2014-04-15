package lab.chapter5;
class LCD{
	int size;
	public LCD(int n){size=n;}
}
class  ColorLCD extends LCD{
	int colorSize;
	public ColorLCD(int colorSize, int size){
		super(size);
		this.colorSize=colorSize;
	}
}
public class Example10 {
	public static void main(String[] args){
		ColorLCD l = new ColorLCD(10,25);
		System.out.println(l.colorSize+" "+l.size);
	}
}

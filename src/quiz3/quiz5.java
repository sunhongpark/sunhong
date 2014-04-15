package quiz3;
public class quiz5 {
	public static void main(String[] args){
		Game ch= new Game(1);
		while(ch.GameOver())
		{
			ch.move();
		}
		ch.show();
	}
}

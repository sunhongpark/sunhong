package quiz3;
public class quiz5 {
	
	public static void main(String[] args){
		Game ch= new Game(1);//2번째 생성자 호출
		while(ch.GameOver())
		{
			ch.move();
		}
		ch.show();
	}
	
}

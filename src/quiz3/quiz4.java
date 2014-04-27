package quiz3;
abstract class Map{//추상 클래스 map 생성
	protected static final int width=15,len=15; // fianl로 처음에 map의 크기 지정 
	protected static char map[][] = new char[len][width];//map  생성
	protected static int x_pos,y_pos,num=0;//static 형태의 좌표 변수 
	public Map(){
		for(int i=0;i<map.length;i++)
		{
			for(int j=0;j<map[0].length;j++){
				map[i][j]='.';
			}
		}
		x_pos=map[0].length/2;
		y_pos=map.length/2;
		//중앙부터 시작
		map[y_pos][x_pos]='@';
		//map초기화 
	}
	public Map(int x){
		this();
		for(int i=2;i<10;i++)
			map[i][i]='X';
		if(map[y_pos][x_pos]=='X')
			x_pos++;
		map[y_pos][x_pos]='@';
		//문제 5번에서 사용
	}
	public void show(){//map의 상태 출력
		for(int i=0;i<map.length;i++)
		{
			for(int j=0;j<map[0].length;j++){
				System.out.print(map[i][j]+" ");
			}
			System.out.print("\n");
		}
	}
	public void set(int x, int y){
		x_pos=x;
		y_pos=y;
		//변수 값 변경
	}
}
class Game extends Map{//map을 상속 받은 game 생성
	private double r;//랜덤변수를 저장할 r생성
	static int count=0;//카운트 변수
	public Game(){
		super();//슈퍼 클래스 호출
	}
	public Game(int x){
		super(x);
	}
	public void move(){
		r=Math.random();//랜덤함수의 값에 따라 움직임
		if(r<0.25){
			if(Esc(x_pos+1,y_pos))//캐릭터가 map밖으로 나가는지 체크
			{
				map[y_pos][x_pos]='*';
				count=22;//나갔다면 *로 표시후 카운터를 올려줌
				return;
			}
			if(map[y_pos][x_pos+1]=='.')
				set(x_pos+1,y_pos);
		}
		else if(r<0.50){
			if(Esc(x_pos-1,y_pos))
			{
				map[y_pos][x_pos]='*';
				count=22;
				return;
			}
			if(map[y_pos][x_pos-1]=='.')
				set(x_pos-1,y_pos);
		}
		else if(r<0.75){
			if(Esc(x_pos,y_pos-1))
			{
				map[y_pos][x_pos]='*';
				count=22;
				return;
			}
			if(map[y_pos-1][x_pos]=='.')
				set(x_pos,y_pos-1);
		}
		else if(r<1.00){
			if(Esc(x_pos,y_pos+1))
			{
				map[y_pos][x_pos]='*';
				count=22;
				return;
			}
			if(map[y_pos+1][x_pos]=='.')
				set(x_pos,y_pos+1);
		}
		map[y_pos][x_pos]='@';
		if(count==20)
			map[y_pos][x_pos]='*';
		count++;
	}
	public boolean GameOver(){
		if(count<21)//카운터가 22이상이면 게임 종료
			return true;
		return false;
	}
	public boolean Esc(int x, int y){//탈출햇는지 확인
		if((x<0||x>=width)||(y<0||y>=len)){
			return true;
		}
		return false;
			
	}
}
public class quiz4 {	
	public static void main(String[] args){
		Game ch= new Game();
		while(ch.GameOver())
		{
			ch.move();
		}
		ch.show();
	}

}

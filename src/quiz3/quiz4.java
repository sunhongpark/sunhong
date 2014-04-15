package quiz3;
class Map{
	static final int width=15,len=20;
	static char map[][] = new char[len][width];
	static int x_pos,y_pos,num=0;
	public Map(){
		for(int i=0;i<map.length;i++)
		{
			for(int j=0;j<map[0].length;j++){
				map[i][j]='.';
			}
			x_pos=map[0].length/2;
			y_pos=map.length/2;
			map[y_pos][x_pos]='@';
		}
	}
	public void show(){
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
	}
}
class Game extends Map{
	private double r;
	static int count=0;
	public void move(){
		r=Math.random();
		if(r<0.25){
			if(Esc(x_pos+1,y_pos))
			{
				map[y_pos][x_pos]='*';
				count=22;
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
		if(count>20)
			map[y_pos][x_pos]='*';
		count++;
	}
	public boolean GameOver(){
		if(count<22)
			return true;
		return false;
	}
	public boolean Esc(int x, int y){
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

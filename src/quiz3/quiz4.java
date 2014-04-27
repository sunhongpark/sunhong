package quiz3;
abstract class Map{//�߻� Ŭ���� map ����
	protected static final int width=15,len=15; // fianl�� ó���� map�� ũ�� ���� 
	protected static char map[][] = new char[len][width];//map  ����
	protected static int x_pos,y_pos,num=0;//static ������ ��ǥ ���� 
	public Map(){
		for(int i=0;i<map.length;i++)
		{
			for(int j=0;j<map[0].length;j++){
				map[i][j]='.';
			}
		}
		x_pos=map[0].length/2;
		y_pos=map.length/2;
		//�߾Ӻ��� ����
		map[y_pos][x_pos]='@';
		//map�ʱ�ȭ 
	}
	public Map(int x){
		this();
		for(int i=2;i<10;i++)
			map[i][i]='X';
		if(map[y_pos][x_pos]=='X')
			x_pos++;
		map[y_pos][x_pos]='@';
		//���� 5������ ���
	}
	public void show(){//map�� ���� ���
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
		//���� �� ����
	}
}
class Game extends Map{//map�� ��� ���� game ����
	private double r;//���������� ������ r����
	static int count=0;//ī��Ʈ ����
	public Game(){
		super();//���� Ŭ���� ȣ��
	}
	public Game(int x){
		super(x);
	}
	public void move(){
		r=Math.random();//�����Լ��� ���� ���� ������
		if(r<0.25){
			if(Esc(x_pos+1,y_pos))//ĳ���Ͱ� map������ �������� üũ
			{
				map[y_pos][x_pos]='*';
				count=22;//�����ٸ� *�� ǥ���� ī���͸� �÷���
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
		if(count<21)//ī���Ͱ� 22�̻��̸� ���� ����
			return true;
		return false;
	}
	public boolean Esc(int x, int y){//Ż���޴��� Ȯ��
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

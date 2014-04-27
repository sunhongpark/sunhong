package lab.chapter6;
import java.util.Scanner;
class person{
	int x,y,z;
	public person(){
		x=(int)Math.round(Math.random()*10%3);
		y=(int)Math.round(Math.random()*10%3);
		z=(int)Math.round(Math.random()*10%3);
	}
	public void random(){//랜덤값 생성
		x=(int)Math.round(Math.random()*10%3);
		y=(int)Math.round(Math.random()*10%3);
		z=(int)Math.round(Math.random()*10%3);
	}
	public boolean find(int x,int y,int z){
		if(this.x==x&&this.y==y&&this.z==z){//값확인후 결과 리턴
			System.out.println("승리 ("+x+","+y+","+z+")");
			return true;
		}
		else
			return false;
	}
	public void print(){
		System.out.println(x+" "+y+" "+z);
	}
}
public class problem12 {
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		boolean p1=false,p2=false,g1=true,g2=false;
		int x,y,z;
		person user1 = new person();
		person user2 = new person();
		System.out.println("게임 시작");
		while(!p1&&!p2)
		{
			if(g1){	
				user2.random();
				user2.print();
				System.out.println("1번 플레이어 2번 플레이어의 숫자를 맞추세요 (0~3) 3개 : ");
				x=scan.nextInt();
				y=scan.nextInt();
				z=scan.nextInt();
				p1=user2.find(x,y,z);
				g1=false;
				g2=true;
			}
			else if(g2){
				System.out.println("2번 플레이어 1번 플레이어의 숫자를 맞추세요 (0~3) 3개 : ");
				x=scan.nextInt();
				y=scan.nextInt();
				z=scan.nextInt();
				user1.random();
				p2=user1.find(x,y,z);
				g1=true;
				g2=false;

			}
		}
	}
}

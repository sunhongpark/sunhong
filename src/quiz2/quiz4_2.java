package quiz2;
import java.util.Scanner;
public class quiz4_2 {
	public static void main(String[] args)
	{
		Scanner scan =new Scanner(System.in);
		int x1,x2,y1,y2;
		System.out.print("두점 (x1,y1), (x2,y2)의 좌표를 입력하시오 : ");
		x1=scan.nextInt();
		y1=scan.nextInt();
		x2=scan.nextInt();
		y2=scan.nextInt();
		System.out.println("입력한 사각형 : ("+x1+","+y1+")  ("+x2+","+y2+")");
		if((50<x1 && 100>x1)||(50<x2 && 100>x2))
		{
			if((50<y1 && 100>y1)||(50<y2 && 100>y2))
			{
			System.out.print("사각형이 겹칩니다.");
			}
		}
	}
}

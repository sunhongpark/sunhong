package quiz2;
import java.util.Scanner;
public class quiz4_3 {
	public static void main(String[] args)
	{
		int num,x=2,y=0,i=0;
		int bi[] = new int[10];
		Scanner scan =new Scanner(System.in);
		System.out.println("0���� ū ������ �Է��ϼ���");
		num = scan.nextInt();
		while(num!=1)
		{
			x=num%2;
			num=num/2;
			bi[i]=x;
			System.out.println(num+"  "+bi[i++]);
			if(num==1)
			{
				bi[i]=1;
			}
			//bi[i++]= num % 2;
		}
		System.out.print("������ : ");
		for(int j=i;j>=0;j--)
		{
			System.out.print(bi[j]);
			if(bi[j]==1)
				y++;
		}
		System.out.print("\n1�� ���� : "+y);
	}
}

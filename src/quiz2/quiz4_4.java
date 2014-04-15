package quiz2;
import java.util.Scanner;
public class quiz4_4 {
	public static void main(String[] args)
	{
		Scanner scan =new Scanner(System.in);
		int num[] =new int[10];
		//int num[] ={5,3,2,1,4,6,9,8,7,10};
		
		int a=0,min,j;
		
		for(int i=0;i<10;i++)
		{
			System.out.print(i+1+"번째 수를 입력하시오 : ");
			num[i]=scan.nextInt();
		}
		
		for(int i=0;i<10;i++)
		{
			min=num[i];
			for(j=i;j<10;j++)
			{
				if(num[j]<min)
				{
					min=num[j];
					a=j;
				}
			}
			for(j=a;j>i;j--)
			{
				num[j]=num[j-1];
			}
			num[i]=min;
		}
		for(int i=0;i<10;i++)
			System.out.print(num[i]+",");
	}

}

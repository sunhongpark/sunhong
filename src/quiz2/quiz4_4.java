package quiz2;
import java.util.Scanner;
public class quiz4_4 {
	public static void main(String[] args)
	{
		Scanner scan =new Scanner(System.in);
		int num[] =new int[10];
		int a=0,min,j;
		for(int i=0;i<10;i++)
		{
			System.out.print(i+1+"��° ���� �Է��Ͻÿ� : ");
			num[i]=scan.nextInt();
		}
		for(int i=0;i<10;i++)
		{
			min=num[i];
			System.out.print("min�� : "+min+"::::");
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
				if(num[i]==min){break;}
				num[j]=num[j-1];
			}
			num[i]=min;
			System.out.print(i+1+"��° ����");
			for(int z=0;z<10;z++)
				System.out.print(num[z]+",");
			System.out.print("\n");
		}
		for(int i=0;i<10;i++)
			System.out.print(num[i]+",");
	}

}

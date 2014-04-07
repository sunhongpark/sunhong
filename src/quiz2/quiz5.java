package quiz2;
import java.util.Scanner;
public class quiz5 {
	public static void gcd(int a,int b)
	{
		if(b==1)
			System.out.print("* ");
		else if(b==0)
			System.out.print("  ");
		else
			gcd(b,a%b);
	}
	public static void main(String[] args)
	{
		System.out.print("  1 2 3 4 5 6 7 8 9 10\n");
		for(int i=1;i<11;i++)
		{
			System.out.print(i+" ");
			for(int j=1;j<11;j++)
			{
				if(i>j)
					gcd(i,j);
				else if(i<=j)
					gcd(j,i);
			}
			System.out.print("\n");
		}
	}

}

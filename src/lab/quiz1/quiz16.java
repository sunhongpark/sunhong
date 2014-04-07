package lab.quiz1;

public class quiz16 {
	public static int Re(int i)
	{
		if(i==0)
		{
			System.out.print("a");
			return 0;
		}
		if(i==1)
			System.out.print("b");
		else
		{
		 Re(i-1); 
		 Re(i-2);
		}
		return Re(i-1);
	}
	public static void main(String[] args)
	{
		Re(11);
	}
}

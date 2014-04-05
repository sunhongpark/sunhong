package lab.quiz1;

public class quiz16 {
	public static void Re(int i)
	{
		if(i==0)
		{
			System.out.println("a");
			return;
		}
		if(i==1)
		{
			System.out.println("b");
			return;
		}
		else
		{
		 Re(i-1); 
		 Re(i-2);
		}
	}
	public static void main(String[] args)
	{
		Re(7);
	}
}

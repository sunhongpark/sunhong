package quiz2;
import java.util.Scanner;
public class quiz4_1 {
	public static void main(String[] args)
	{
		Scanner a = new Scanner(System.in);
		String ch;
		int c;
		System.out.println("���ڸ� �Է��Ͻÿ� : ");
		ch = a.next();
		c=ch.charAt(0);
		if('a'<=c&&c<='z')
		{
			c=c-32;
			System.out.println("�빮�ڷ� ���� : "+(char)c);
		}
		else if('A'<=c&&c<='Z')
		{
			c=c+32;
			System.out.println("�ҹ��ڷ� ���� : "+(char)c);
		}
		else 
			System.out.println("�����ڰ� �ƴմϴ�.");
	}

}

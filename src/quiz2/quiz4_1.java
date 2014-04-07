package quiz2;
import java.util.Scanner;
public class quiz4_1 {
	public static void main(String[] args)
	{
		Scanner a = new Scanner(System.in);
		String ch;
		int c;
		System.out.println("문자를 입력하시오 : ");
		ch = a.next();
		c=ch.charAt(0);
		if('a'<=c&&c<='z')
		{
			c=c-32;
			System.out.println("대문자로 변경 : "+(char)c);
		}
		else if('A'<=c&&c<='Z')
		{
			c=c+32;
			System.out.println("소문자로 변경 : "+(char)c);
		}
		else 
			System.out.println("영문자가 아닙니다.");
	}

}

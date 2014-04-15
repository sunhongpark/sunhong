package quiz2;
import java.util.Scanner;
public class quiz1 {
	public static void main(String[] args){
		Scanner sc =new Scanner(System.in);
		System.out.println("숫자 입력 : ");
		try{
			int i= Integer.parseInt(sc.next());
		}		
		catch(NumberFormatException e){
			System.out.println("Cannont conert to int");
		}
		catch(Exception e){
			System.out.println("Something wrong!!!");
		}

	}
}

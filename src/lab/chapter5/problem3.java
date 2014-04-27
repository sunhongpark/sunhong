package lab.chapter5;
import java.util.Scanner;
interface Stack{
	public int length();
	public Object pop();
	public boolean push(Object ob);
}
class StringStack implements Stack{
	int num;
	public String[] st;
	
	public StringStack(int x){
		st = new String[x];//생성자로 문자열저장 공간 초기화
		num=0;
	}
	public int length(){
		return st.length;//개수 리턴
	}
	public Object pop(){
		if(num==0)//개수가 0개이면 pop을 못함
			return null;
		else
			num--;//값 출력
		return st[num];
		
	}
	public boolean push(Object ob) {
		if(st.length>num){
			st[num++]=(String)ob;
			return true;//저장
		}
		else return false;
	}
}
public class problem3 {
	public static void main (String[] args) {
		int cho=0;
		Scanner scan= new Scanner(System.in);
		Stack s = new StringStack(10);
		while(cho!=3)
		{
			System.out.print("(1)push (2)pop (3)exit : ");
			cho=scan.nextInt();
			switch(cho){
			case 1:
				if(s.push(scan.next())){
					System.out.println("입력 완료");
				}
				else
					System.out.println("메모리 부족");
				break;
			case 2:
				System.out.println(s.pop());
				break;
			case 3:
				System.out.println("종료");
				break;
			default:
				System.out.println("잘못된 선택");
			}
		}
	}
}

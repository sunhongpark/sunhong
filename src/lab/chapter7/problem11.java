package lab.chapter7;
import java.util.*;
interface Stack<T>{
	public T pop();
	public boolean push(T ob);
}
class MyStack<T> implements Stack<T>{
	LinkedList<T> list =new LinkedList<T>();
	public T pop(){
		if(list.isEmpty())
			return null;
		else
			return (T)list.pop();
	}
	public boolean push(T ob){
		if(list.add(ob))
			return true;
		else return false;
	}
	public void print(){
		for(int i=0;i<list.size();i++)
			System.out.print(list.get(i)+"->");
		System.out.print("\n");
	}
}
public class problem11 {
	public static void main(String[] args){
		int cho=0,num;
		Scanner scan=new Scanner(System.in);
		MyStack<Integer> s =new MyStack<Integer>();
		while(cho!=4){
			System.out.print("(1) push (2) pop (3) print (4)exit : ");
			cho=scan.nextInt();
			switch(cho){
			case 1:
				System.out.print("숫자 입력 : ");
				num=scan.nextInt();
				s.push(num);
				break;
			case 2:
				System.out.println(s.pop());
				break;
			case 3:
				s.print();
				break;
			case 4:
				System.out.print("exit");
				break;
			default:
				System.out.print("입력 범위 초과");
			}
		}
		
	}
}

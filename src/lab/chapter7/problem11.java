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
			return (T)list.getLast();
	}
	public boolean push(T ob){
		if(list.add(ob))
			return true;
		else return false;
	}
	public void print(){
		
	}
}
public class problem11 {
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in)
		MyStack<Integer> s =new MyStack<Integer>();
		
		
	}
}

package lab.chapter7;
import java.util.*;
class student{
	String name;
	int id;
	String dep;
	int avg;
	student(final String name,final int id, final String dep,final int avg){
		this.name=name;
		this.id=id;
		this.dep=dep;
		this.avg=avg;
	}
	public void print(){
		System.out.println("이름 : "+name+"\n학번 :"+id+"\n학과 : "+dep+"\n평균 학점 :"+avg);
	}
	
}
public class problem5 {
	private static ArrayList<student> st;

	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		setSt(new ArrayList<student>());
		student a;
		String name;
		int id;
		String dep;
		int avg;
		for(int i=0;i<5;i++){
			System.out.print("이름,학번,학과,평균 학점 순으로 입력 하시오 : ");
			name=scan.next();
			id=scan.nextInt();
			dep=scan.next();
			avg=scan.nextInt();
			a=new student(name,id,dep,avg);
			st.add(a);
		}
		for(int i=0;i<st.size();i++){
			a=st.get(i);
			a.print();
		}
	}

	public static ArrayList<student> getSt() {
		return st;
	}

	public static void setSt(ArrayList<student> st) {
		problem5.st = st;
	}
}

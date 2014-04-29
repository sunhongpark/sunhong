package lab.chapter7;
import java.util.*;
class student2{
	String name;
	String dep;
	int avg;
	student2(final String name, final String dep,final int avg){
		this.name=name;
		this.dep=dep;
		this.avg=avg;
	}
	public void print(){
		System.out.println("이름 : "+name+"\n학과 : "+dep+"\n평균 학점 :"+avg);
	}
	
}
public class problem9 {
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		String id;
		HashMap<String,student2> dept =new HashMap<String,student2>();
		dept.put("20094052",new student2("박선홍", "컴공",4));
		dept.put("20094007",new student2("김민주", "컴공",1));
		dept.put("20094087",new student2("김아무개", "컴공",3));
		dept.put("20094158",new student2("홍개똥", "컴공",2));
		System.out.println("검색할 학번을 입력하세요 : ");
		id=scan.next();
		dept.get(id).print();
	}
}

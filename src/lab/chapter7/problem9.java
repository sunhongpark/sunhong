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
		System.out.println("�̸� : "+name+"\n�а� : "+dep+"\n��� ���� :"+avg);
	}
	
}
public class problem9 {
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		String id;
		HashMap<String,student2> dept =new HashMap<String,student2>();
		dept.put("20094052",new student2("�ڼ�ȫ", "�İ�",4));
		dept.put("20094007",new student2("�����", "�İ�",1));
		dept.put("20094087",new student2("��ƹ���", "�İ�",3));
		dept.put("20094158",new student2("ȫ����", "�İ�",2));
		System.out.println("�˻��� �й��� �Է��ϼ��� : ");
		id=scan.next();
		dept.get(id).print();
	}
}

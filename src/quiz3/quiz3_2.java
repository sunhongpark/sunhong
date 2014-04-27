package quiz3;
import java.util.Scanner;
abstract class seat{//�߻� Ŭ���� seat
	public String customer[] =new String[10];//�¼� 10��
	public String nul="___";//���¼�
	public static int pos;//����ڰ� ������ ��ġ�� �����ϴ� static ����
	public seat(){
		for(int i=0;i<customer.length;i++)
			customer[i]="___";
	}
	public boolean scan(String name){
		for(int i=0;i<customer.length;i++){
			if(customer[i].compareTo(name)==0){//���ڿ� ��
				pos=i;//ã�� �ڸ��� �ε��� ����
				return true;
			}
		}
			
		return false;
	}
	public void cancel(String name){
		if(scan(name)){
			customer[pos]="___";//�¼� �ʱ�ȭ
		}
		else{
			System.out.println("���� �̸� �Դϴ�.");
		}
	}
	public void reservation(int x,String name){
		if(x>10||x<1)//������ �ʰ��� true
		{
			System.out.println("���� �ڸ� �Դϴ�.");
			return;
		}
		if(customer[x-1].compareTo(nul)==0){//���ڸ��̸� ����
			customer[x-1]=name;
		}
		else{
			System.out.println("�̹� ����� �ڸ� �Դϴ�.");
		}
	}
	abstract public void Print();
}
class S extends seat{//S�¼�
	public void Print(){
		System.out.print("S>>");
		for(int i=0;i<customer.length;i++){
			System.out.print(customer[i]+" ");
		}
		System.out.print("\n");
	}
}
class A extends seat{//A�¼�
	public void Print(){
		System.out.print("A>>");
		for(int i=0;i<customer.length;i++){
			System.out.print(customer[i]+" ");
		}
		System.out.print("\n");
	}
}
class B extends seat{//B�¼�
	public void Print(){
		System.out.print("B>>");
		for(int i=0;i<customer.length;i++){
			System.out.print(customer[i]+" ");
		}
		System.out.print("\n");
	}
}
public class quiz3_2 {
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		int cho1=0,cho2=0,num;
		String name;
		seat customer[]=new seat[3];
		customer[0]=new S();
		customer[1]=new A();
		customer[2]=new B();
		while(cho1!=4){
			System.out.print("����<1>, ��ȸ<2>, ���<3>, ������<4> >>");
			cho1=scan.nextInt();
			switch(cho1){
			case 1:
				System.out.print("�¼� ���� S<1>,A<2>,B<3> >>");
				cho2=scan.nextInt();
				customer[cho2-1].Print();
				System.out.print("�̸� >>");
				name=scan.next();
				System.out.print("��ȣ >>");
				num=scan.nextInt();
				customer[cho2-1].reservation(num,name);
				break;
			case 2:
				for(int i=0;i<customer.length;i++)
					customer[i].Print();
				break;
			case 3:
				System.out.print("�¼� ���� S<1>,A<2>,B<3> >>");
				cho2=scan.nextInt();
				customer[cho2-1].Print();
				System.out.print("�̸� >>");
				name=scan.next();
				customer[cho2-1].cancel(name);
				break;
			case 4:
				System.out.print("���� ���� �ý��� ���� !");
				break;
			default:
					System.out.println("�޴� �Է� ���� �ٽ� �Է��ϼ��� !");
			}
		}
	}
}

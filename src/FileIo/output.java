package FileIo;
/*
 * file save
 */
import java.io.*;
import java.util.*;
public class output {
	static Scanner scan=new Scanner(System.in);
	static ArrayList<product> list;
	static ObjectOutputStream out=null;
	static public void add(){
		String name;
		int pay;
		int number;
		int num;
		System.out.print("상품명 : ");
		name=scan.next();
		System.out.print("상품 번호 : ");
		number=scan.nextInt();
		System.out.print("가격 : ");
		pay=scan.nextInt();
		System.out.print("개수 : ");
		num=scan.nextInt();
		list.add(new product(name,number,pay,num));
	}
	static void print(){
		product a;
		for(int i=0;i<list.size();i++){
			list.get(i).print();
		}
	}
	static void save(){
		product a;
		for(int i=0;i<list.size();i++){
			try {
				a=list.get(i);
				a.print();
				out.writeObject(a);
			} catch (IOException e) {
				System.out.println("저장 오류");
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args){
		list=new ArrayList();
		try {
			out = new ObjectOutputStream(new FileOutputStream("d:\\object.ser"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int ch=0;
		while(ch!=4){
			ch=scan.nextInt();
			switch(ch){
			case 1:
				add();
				break;
			case 2:
				print();
				break;
			case 3:
				save();
				break;
				
			}
		}
	}
	private static OutputStream FileOutputStream(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}

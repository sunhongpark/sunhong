package FileIo;
/*
 * file에서 읽어오기
 */
import java.io.*;
import java.util.*;
public class input {
	private static ObjectInputStream in;

	public static void main(String [] args) {
		try {
			in = new ObjectInputStream(new FileInputStream("d:\\object.ser"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<product> list=new ArrayList<product>();
		product c;
		try {
			while((c=(product) in.readObject()) != null)
			{
				list.add(c);
				System.out.print("1");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<list.size();i++)
			list.get(i).print();
	}

}

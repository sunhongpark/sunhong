package FileIo;
/*
 * file에서 읽어오기
 */
import java.io.*;
import java.util.*;
public class input {
	public static void main(String [] args) throws IOException, ClassNotFoundException{
		ObjectInputStream in = 
				new ObjectInputStream(new FileInputStream("c:\\object.text"));
		ArrayList<product> list=new ArrayList();
		product c;
		while((c=(product) in.readObject()) != null)
			list.add(c);
		for(int i=0;i<list.size();i++)
			list.get(i).print();
	}

}

package FileIo;
import java.io.*;

public class test2 {
	public static void main(String[] args) 
	 {
	 
	  ObjectInputStream in = null;
	  try
	  {
	   in = new ObjectInputStream(new FileInputStream("output.dat"));
	   while(true)
	   {
	   test t1 = (test)in.readObject();
	   int a = t1.a;
	   int b = t1.b;
	   System.out.println(a+"  "+b);
	   }
	  }
	 
	  
	  catch(IOException ioe)
	  {
	   System.out.println("������ ���� �� �����ϴ�");
	  }
	 
	  catch(ClassNotFoundException cnfe)
	  {
	   System.out.println("������ ã�� �� �����ϴ�");
	  }
	 
	 
	 

	  finally{
	 
	  try
	  {
	   in.close();
	  }
	  catch (Exception e)
	  {
	  }
	 
	  }
	 
	 
	 

	 }


}

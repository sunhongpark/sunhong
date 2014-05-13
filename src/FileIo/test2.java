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
	   System.out.println("파일을 읽을 수 없습니다");
	  }
	 
	  catch(ClassNotFoundException cnfe)
	  {
	   System.out.println("파일을 찾을 수 없습니다");
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

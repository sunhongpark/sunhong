package FileIo;
import java.io.*;

public class test implements java.io.Serializable {
	 int a;
	 int b;
	 public static void main(String[] args) 
	 {
	  test t1 = new test();
	  test t2 = new test();
	  test t3 = new test();
	   
	  t1.a = 1;
	  t1.b = 2;
	 
	  t2.a = 3;
	  t2.b = 4;
	 
	  t3.a = 5;
	  t3.b = 6;
	 
	  ObjectOutputStream out = null;
	  try
	  {
	   out = new ObjectOutputStream(new FileOutputStream("output.dat"));
	   out.writeObject(t1);
	   out.writeObject(t2);
	   out.writeObject(t3);
	  }
	 
	  
	  catch(IOException e)
	  {
	   System.out.println("파일에 쓸 수 없습니다");
	  }
	 
	 
	 
	  finally{
	 
	  try
	  {
	   out.close();
	  }
	  catch (Exception e)
	  {
	  }
	 
	  }
	 
	 
	 

	 }


}

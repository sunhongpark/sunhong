package quiz3;
public class quiz3_1 {
	public static boolean find(String ch){
		char c;
		for(int i=0;i<ch.length();i++){
			c=ch.charAt(i);
			if(!(Character.isDigit(c))){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args){
		int sum=0,n;
		for(int i=0;i<args.length;i++){
			if(find(args[i]))
			{
				n=Integer.parseInt(args[i]);
				sum+=n;
			}
		}
		System.out.print(sum);
		
	}
}

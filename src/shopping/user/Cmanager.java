package shopping.user;

public class Cmanager {
	static int num=0;
	customer [] user =new customer[10];
	public boolean addCustomer(String id, String pw, String name, String ph,String address){
		if(num<10){
			for(int i=0;i<num;i++)
			{
				if(user[i].checkid(id)){
					System.out.println("���̵� �ߺ�");
					return false;
				}
			}
			user[num++]=new customer(id,pw,name,ph,address);
			return true;
		}
		else{
			System.out.println("ȸ������ �ο��� �ʰ�");
			return false;
		}
	}
	public boolean login(String id, String pw){
		for(int i=0;i<num;i++)
		{
			if(user[i].checkid(id)){
				if(user[i].checkpw(pw))
				{
					user[i].login=true;
					return true;
				}
			}
		}
		return false;
	}
	public boolean logout(String id){
		for(int i=0;i<num;i++)
		{
			if(user[i].checkid(id)){
				user[i].login=false;
				return true;
			}
		}
		return false;
	} 
}

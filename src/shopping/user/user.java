package shopping.user;
enum state{fresh,active,blocked,banned}
public class user {
	enum state{fresh,active,blocked,banned}
	enum grade{Gold,Silver,Brone}
	private String id;
	private String pw;
	private String name;
	protected String ph;
	protected String address;
	protected state type;
	public grade gr;
	boolean login=false;
	user(String id,String pw,String name,String ph,String address){
		 this.id=id;
		 this.pw=pw;
		 this.name=name;
		 this.ph=ph;
		 this.address=address;
		 type=state.fresh;
	 }
	 
	 public boolean checkpw(String pw){
		if(this.pw.compareTo(pw)==0)
			return true;
		else return false;
	 }
	 public boolean checkid(String id){
		 if(this.pw.compareTo(id)==0)
			 return true;
		 else return false;
	 }
	 public String getid(){return id;}
	 public void setpw(String pw){
		 if(checkpw(pw))
			 this.pw=pw;
		 else System.out.println("��й�ȣ�� ��ġ ���� ����");
	 }
	 public void changeaddress(String address){this.address=address;}
	 public void print(){
		 System.out.println("���̵� : "+id+"\n�̸� : "+name+"\n��ȭ ��ȣ : "+ph+"\n�ּ� : "+address+"\n��� : "+type);
	 }
	
 }


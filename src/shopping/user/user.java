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
		 gr=grade.Silver;
	 }
	 public void ModifyPh(String ph){
		 this.ph=ph;
	 }
	 public void ModifyAdr(String adr){
		 this.address=adr;
	 }
	 public void ModifyPw(String pw){
		 this.pw=pw;
	 }
	 public boolean CheckPw(String pw){
		if(this.pw.compareTo(pw)==0)
			return true;
		else return false;
	 }
	 public boolean CheckId(String id){
		 if(this.id.compareTo(id)==0)
			 return true;
		 else return false;
	 }
	 public String GetId(){return id;}
	 public void Print(){
		 System.out.println("------------------------------");
		 System.out.println("���̵� : "+id+"\n�̸� : "+name+"\n��ȭ ��ȣ : "+ph+
				 "\n�ּ� : "+address+"\n���� : "+type+"\n��� :"+gr);
		 if(login)
			 System.out.println("�α��� ��");
		 else System.out.println("�α׿��� ��");
	 }
	
 }


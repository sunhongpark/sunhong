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
		 else System.out.println("비밀번호가 일치 하지 않음");
	 }
	 public void changeaddress(String address){this.address=address;}
	 public void print(){
		 System.out.println("아이디 : "+id+"\n이름 : "+name+"\n전화 번호 : "+ph+"\n주소 : "+address+"\n등급 : "+type);
	 }
	
 }


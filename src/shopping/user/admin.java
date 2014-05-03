package shopping.user;

import shopping.user.*;

public class admin extends user{
	//
	Cmanager c;
	Smanager s;
	admin(String id, String pw, String name, String ph, String address) {
		super(id, pw, name, ph, address);
	}
	public void SetAdmin(Cmanager c,Smanager s){
		this.c=c;
		this.s=s;
	}
	 public boolean ModifyType(int i,user u){
		 switch(i){
		 case 1:
			 u.type=state.fresh;
			 return true;
		 case 2:
			 u.type=state.active;
			 return true;
		 case 3:
			 u.type=state.banned;
			 return true;
		 case 4:
			 u.type=state.blocked;
			 return true;
		 default:
			 return false;	 
		 }
	 }
	 public boolean ModifyGrade(int i,user s){
		 switch(i){
		 case 1:
			 s.gr=grade.Brone;
			 return true;
		 case 2:
			 s.gr=grade.Silver;
			 return true;
		 case 3:
			 s.gr=grade.Gold;
			 return true;
		 default:
			 return false;	 
		 } 
	 }
}

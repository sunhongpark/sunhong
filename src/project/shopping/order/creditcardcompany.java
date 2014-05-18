package project.shopping.order;

import java.util.*;
/*
 * 카드사로
 * 카드사 이름이 있고 
 * 그에 가입한 회원 정보를 가지고 있는 리스트 존재
 */
public class creditcardcompany {
	Scanner scan=new Scanner(System.in);
	protected ArrayList<creditcard> card; 
	protected String company;
	protected int number=0;
	public creditcardcompany(String company){
		card=new ArrayList<creditcard>();
		this.company=company;
	}
	public void CreateCard(){
		String name;
		String pw;
		System.out.println(company+"사에 가입하시는것을 환영 합니다.");
		System.out.print("아이디 : ");
		name=scan.next();
		System.out.print("비밀번호: ");
		pw=scan.next();
		System.out.println("회원님의 카드 번호는 \""+number+"\" 입니다.");
		card.add(new creditcard(1000000,number,name,pw));
	}
	public creditcard FindUser(int number){
		Iterator<creditcard> it =card.iterator();
		creditcard u;
		while(it.hasNext()){
			u=it.next();
			if(u.GetNumber()==number)
			{
				return u;
			}
		}
		return null;
		
	}
}

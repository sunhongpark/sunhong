package project.shopping.order;

import java.util.*;
/*
 * ī����
 * ī��� �̸��� �ְ� 
 * �׿� ������ ȸ�� ������ ������ �ִ� ����Ʈ ����
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
		System.out.println(company+"�翡 �����Ͻô°��� ȯ�� �մϴ�.");
		System.out.print("���̵� : ");
		name=scan.next();
		System.out.print("��й�ȣ: ");
		pw=scan.next();
		System.out.println("ȸ������ ī�� ��ȣ�� \""+number+"\" �Դϴ�.");
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

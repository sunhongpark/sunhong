package FileIo;

import java.io.Serializable;

public class product implements Serializable {
	protected String name;
	protected int Pnumber;
	protected int pay;
	protected int num;
	public product (String name,int Pnumber,int pay,int num){
		this.name=name;
		this.Pnumber=Pnumber;
		this.pay=pay;
		this.num=num;
	}
	
	public void print(){
		System.out.println("��ǰ�� : "+name+"��ǰ ���� : "+pay);
	}
	
}

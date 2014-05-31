package project2.order;

import java.io.Serializable;

public class buyitem implements Serializable {
	int number;
	String seller;
	String user;
	int itemNumber;
	int pay;
	int state;
	String address;
	int num;
	public buyitem(int number,String seller,String user,int itemNumber,
			int pay,int state,String address,int num){
		this.number =number;
		this.seller=seller;
		this.user=user;
		this.itemNumber=itemNumber;
		this.pay=pay;
		this.state=state;
		this.address=address;
		this.num=num;
	}
	public int getNumber(){return number;}
	public String getSeller(){return seller;}
	public String getUser(){return user;}
	public int getItemNumber(){return itemNumber;}
	public int getPay(){return pay;}
	public int getState(){return state;}
	public String getAddress(){return address;}
	public int getNum(){return num;}
}

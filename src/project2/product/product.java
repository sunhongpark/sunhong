package project2.product;

import java.io.Serializable;

public class product  implements Serializable{
	String seller;
	String name;
	int pay;
	int num;
	int state;
	int number;
	
	public product(int number,String seller,String name, int pay,int num,int state){
		this.number=number;
		this.seller=seller;
		this.name= name;
		this.pay=pay;
		this.num=num;
		this.state=state;
	}
	public int getnumber(){return number;}
	public String getSeller(){return seller;}
	public String getName(){return name;}
	public int getPay(){return pay;}
	public int getNum(){return num;}
	public int getState(){return state;}
	

}

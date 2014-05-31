package project2.product;

import java.io.Serializable;

public class cart implements Serializable{
	int item;
	String user;
	public cart(String user,int item){
		this.user=user;
		this.item=item;
	}
	public String getId(){return user;}
	public int getItem(){return item;}
}

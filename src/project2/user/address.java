package project2.user;

import java.io.Serializable;

public class address implements Serializable {
	String id;
	String address;
	String type;
	public address(String id, String address, String type){
		this.id=id;
		this.address=address;
		this.type=type;
	}
	public String getId(){return id;}
	public String getAddress(){return address;}
	public String getType(){return type;}

}

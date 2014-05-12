package project.shopping.product;

public class product {
	enum state{InStock,OutOfStock,SoldOut}
	protected String name;
	protected String number;
	protected int pay;
	protected int quantity;
	protected state state;
	protected String type;
	public product(String name,String number,int pay,int quantity){
		this.name=name;
		this.number=number;
		this.pay=pay;
		this.quantity=quantity;
		this.state=state.InStock;
		this.type="±âº»";
	}
	public String GetName(){return name;}
	public String GetNumber(){return number;}
	public int GetPay(){return pay;}
	public void ModifyPay(int pay){
		this.pay=pay;
	}
	public int GetQuantity(){return quantity;}
	public void AddQuantity(int num){
		this.quantity+=num;
	}
	public boolean SellItem(){
		if(quantity>0)
		{
			quantity--;
			return true;
		}
		else if(quantity<=0){
			state=state.SoldOut;
			return false;
		}
		return false;
	}
	public void ReturnItem(){quantity++;}
	public void SetType(String type){this.type=type;}
}

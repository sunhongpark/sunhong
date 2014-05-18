package project.shopping.order;
/*
 * 계좌 이체는... 그냥 돈을 넣어주면 되는거라 더이상 어떻게 구현해야할지 모르겠습니다.
 */
public class wiretransfer {
	String name;
	String account;
	public wiretransfer(String name,String account){
		this.name=name;
		this.account=account;
	}
	public void deposit(int money){
		this.account+=money;
	}
}

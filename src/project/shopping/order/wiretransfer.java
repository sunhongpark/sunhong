package project.shopping.order;
/*
 * ���� ��ü��... �׳� ���� �־��ָ� �Ǵ°Ŷ� ���̻� ��� �����ؾ����� �𸣰ڽ��ϴ�.
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

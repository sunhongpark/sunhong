package project.shopping.order;
/*
 * ����ڰ� ī�带 �����Ҷ� ī�� ���� �� �������ִ� Ŭ����
 */
public class creditcard {
	protected int money;
	protected String name;
	protected int number;
	protected String pw;
	public creditcard(int money,int number,String name,String pw){
		this.money=money;
		this.name=name;
		this.number=number;
		this.pw=pw;
	}
	public boolean check(int number,String pw){
		if(this.number==number)
			if(this.pw.compareTo(pw)==0)
				return true;
		return false;
	}
	public boolean payment(int pay, int number,String pw){
		if(check(number,pw))
		{
			if(money>=pay)
			{
				this.money-=pay;
				System.out.println("���� �ݾ� : "+money);
				return true;
			}
			else{
				System.out.println("�ѵ� �ʰ�");
				return false;
			}
		}
		else
		{
			System.out.println("ī�� ���� ����");
			return false;
		}
		
	}
	public int GetNumber(){return number;}
	public void changelimit(int limit){
		int tmp;
		tmp=this.money;
		this.money=limit;
		this.money-=tmp;
		}
}

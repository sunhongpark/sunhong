package project.shopping.order;
/*
 * 사용자가 카드를 생성할때 카드 정보 를 가지고있는 클래스
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
				System.out.println("남은 금액 : "+money);
				return true;
			}
			else{
				System.out.println("한도 초과");
				return false;
			}
		}
		else
		{
			System.out.println("카드 정보 오류");
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

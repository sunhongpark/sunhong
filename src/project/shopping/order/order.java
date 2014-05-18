package project.shopping.order;
import project.shopping.product.*;
/*
 * �������� �ֹ��� 
 * �ֹ��� ���¿� ������ ǥ�� 
 */
public class order {
	enum status{New,Hold,Shipped,Deliverde,Closed};
	protected product item;
	protected int num;
	protected int pay;
	protected int step=0;
	protected boolean check;
	protected status st;
	protected int ordernumber;
	public order(product item,int num,int oredernumber){
		this.item=item;
		this.ordernumber=oredernumber;
		if(item.SellItem()){
			this.num=num;
			this.pay=item.GetPay()*num;
			this.check=true;
			st=status.New;
			step=0;
		}
		else
		{
			System.out.println("�ֹ� ����");
			this.check=false;
		}

	}
	public void ChangeStatus(){
		/*
		 * �� �Լ��� �����ڰ� ȣ���ϸ� ȣ���Ҷ����� �ܰ谡 ����
		 */
		step++;
		switch(step){
			case 0:
				this.st=status.New;
				break;
			case 1:
				this.st=status.Hold;
				break;
			case 2:
				this.st=status.Shipped;
				break;
			case 3:
				this.st=status.Deliverde;
				break;
			case 4:
				this.st=status.Closed;
				break;
		}
	}
	public boolean payment(){
		if(st==status.Hold)//���� ��� �����϶��� ����
		{
			ChangeStatus();
			return true;
		}
		return false;
	}
	public int GetOrdernumber(){return ordernumber;}
	public status GetStatus(){return st;}
	public boolean GetCheck(){return check;}
	public int Getpay(){return pay;}
}

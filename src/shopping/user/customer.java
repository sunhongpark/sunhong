package shopping.user;

import java.util.*;

public class customer<T> extends user {
	static int num=0;
	ArrayList<T> shopping =new ArrayList<T>();//����īƮ
	ArrayList<T> buy =new ArrayList<T>();//�ֹ� ���
	HashMap<String,String> adres= new HashMap<String,String>();//�����
	customer(String id, String pw, String name, String ph,String address) {
		super(id, pw, name, ph,address);
		adres.put("�⺻ �����",address);
	}
	public void AddAdres(String key,String adr){
		adres.put(key,adr);
	}
	public void RemoveAdres(String key){
		adres.remove(key);
	}
	public void ShowAdres(){
		Set<String> keys=adres.keySet();
		Iterator<String> i =keys.iterator();
		while(i.hasNext()){
			String key=i.next();
			System.out.println(key+" "+adres.get(key));
		}
	}
	public void print(){
		super.Print();
		this.ShowAdres();
	}
	public void AddShopping(Object ob){
		shopping.add((T)ob);
	}
	public void ShowShopping(){
		//�̱��� ��ǰ�� �ڼ��� ���� ���
	}
	public void RemoveShopping(int i){
		shopping.remove(i-1);
	}
	public void AddBuy(Object ob){
		buy.add((T)ob);
	}
	public void ShowBuy(){
		//�̱��� ��ǰ�� �ڼ��� ������ ��� ���¸� ���
	}
	public void RemoveBuy(){
		/*�̱���
		 * ����ڰ� ���� �ϷḦ �ϸ� �ڵ����� ���� 
		 * ��ǰ�� ���°� ���� �Ϸ����� Ȯ�� -> ����
		*/
	}
}

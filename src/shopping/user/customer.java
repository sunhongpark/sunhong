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
	public void addAdres(String key,String adr){
		adres.put(key,adr);
	}
	public void removeAdres(String key){
		adres.remove(key);
	}
	public void showAdres(){
		Set<String> keys=adres.keySet();
		Iterator<String> i =keys.iterator();
		while(i.hasNext()){
			String key=i.next();
			System.out.println(key+" "+adres.get(key));
		}
	}
	public void Addshopping(Object ob){
		shopping.add((T)ob);
	}
	public void showshopping(){
		//�̱��� ��ǰ�� �ڼ��� ���� ���
	}
	public void removeshopping(int i){
		shopping.remove(i-1);
	}
	public void AddBuy(Object ob){
		buy.add((T)ob);
	}
	public void showBuy(){
		//�̱��� ��ǰ�� �ڼ��� ������ ��� ���¸� ���
	}
	public void RemoveBuy(){
		/*�̱���
		 * ����ڰ� ���� �ϷḦ �ϸ� �ڵ����� ���� 
		 * ��ǰ�� ���°� ���� �Ϸ����� Ȯ�� -> ����
		*/
	}
}

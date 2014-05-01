package shopping.user;

import java.util.*;

public class customer<T> extends user {
	static int num=0;
	ArrayList<T> shopping =new ArrayList<T>();//쇼핑카트
	ArrayList<T> buy =new ArrayList<T>();//주문 목록
	HashMap<String,String> adres= new HashMap<String,String>();//배송지
	customer(String id, String pw, String name, String ph,String address) {
		super(id, pw, name, ph,address);
		adres.put("기본 배송지",address);
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
		//미구현 상품의 자세한 정보 출력
	}
	public void removeshopping(int i){
		shopping.remove(i-1);
	}
	public void AddBuy(Object ob){
		buy.add((T)ob);
	}
	public void showBuy(){
		//미구현 상품의 자세한 정보와 배송 상태를 출력
	}
	public void RemoveBuy(){
		/*미구현
		 * 사용자가 구매 완료를 하면 자동으로 종료 
		 * 상품의 상태가 구매 완료인지 확인 -> 삭제
		*/
	}
}

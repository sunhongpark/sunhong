package project.shopping.user;

import java.util.ArrayList;

public class seller<T> extends user{
	private int number;//판매자 번호
	private int point;
	ArrayList<T> product =new ArrayList<T>();//판매자 상품
	seller(String id, String pw, String name, String ph, String address) {
		super(id, pw, name, ph, address);
		point=0;
		gr=grade.Brone;
	}
	public void AddsProduct(Object ob){
		product.add((T)ob);
	}
	public void ShowProduct(){
		//미구현 상품의 자세한 정보 출력
	}
	public void RemoveProduct(int i){
		product.remove(i-1);
	}

}

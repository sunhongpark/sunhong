package project.shopping.user;

import java.util.ArrayList;

public class seller<T> extends user{
	private int number;//�Ǹ��� ��ȣ
	private int point;
	ArrayList<T> product =new ArrayList<T>();//�Ǹ��� ��ǰ
	seller(String id, String pw, String name, String ph, String address) {
		super(id, pw, name, ph, address);
		point=0;
		gr=grade.Brone;
	}
	public void AddsProduct(Object ob){
		product.add((T)ob);
	}
	public void ShowProduct(){
		//�̱��� ��ǰ�� �ڼ��� ���� ���
	}
	public void RemoveProduct(int i){
		product.remove(i-1);
	}

}

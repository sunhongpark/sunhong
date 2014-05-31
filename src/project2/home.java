package project2;
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import project2.order.*;
import project2.product.*;
import project2.user.*;
public class home extends JFrame{
	JLabel Lid,Lpw,Lloginid;
	JButton login,account,change,logout,amanager,backup,install;
	JButton Vitem,cart,addcard,Oitem;
	JButton Myitem,sellitem;
	JTextField Tid,Tpw,Tlogin;
	account manager = new account(this);
	Dimension size;
	user u;
	int x,y;
	int xpos;
	boolean check=false;
	String type,grade;
	public home(Dimension size){
		this.size=size;
		x=(int)((int)size.height*0.7);
		y=(int)((int)size.width*0.3);
		xpos=x;
		setTitle("오크션");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		loginMenu();
		setSize(x,y);
		setVisible(true);
	}
	public void loginMenu(){
		login = new JButton("로그인");
		login.addActionListener(new buttonlistener());
		login.setSize(80, 30);
		login.setLocation(xpos-210,30);
		add(login);
		Lid= new JLabel("ID : ");
		Lid.setSize(20,30);
		Lid.setLocation(xpos-460, 30);
		add(Lid);
		Tid= new JTextField();
		Tid.setSize(80,30);
		Tid.setLocation(xpos-430, 30);
		add(Tid);
		Lpw=new JLabel("PW : ");
		Lpw.setSize(30,30);
		Lpw.setLocation(xpos-340, 30);
		add(Lpw);
		Tpw= new JPasswordField();
		Tpw.setSize(80,30);
		Tpw.setLocation(xpos-300, 30);
		add(Tpw);
		account = new JButton("회원 가입");
		account.addActionListener(new buttonlistener());
		account.setSize(100, 30);
		account.setLocation(xpos-120,30);
		add(account);
		change= new JButton("정보 수정");
		change.addActionListener(new buttonlistener());
		change.setSize(100, 30);
		change.setLocation(xpos-120,30);
		change.setVisible(false);
		add(change);
		logout = new JButton("로그아웃");
		logout.addActionListener(new buttonlistener());
		logout.setSize(100, 30);
		logout.setLocation(xpos-230,30);
		logout.setVisible(false);
		add(logout);
		Lloginid=new JLabel("");
		Lloginid.setLocation(xpos-550, 30);
		Lloginid.setSize(300, 30);
		Lloginid.setVisible(false);
		add(Lloginid);
		amanager =new JButton("회원 관리");
		amanager.addActionListener(new buttonlistener());
		amanager.setSize(100,30);
		amanager.setLocation(xpos-600, 100);
		amanager.setVisible(false);
		add(amanager);
		backup = new JButton("DB 백업");
		backup.addActionListener(new buttonlistener());
		backup.setSize(100,30);
		backup.setLocation(xpos-400, 100);
		backup.setVisible(false);
		add(backup);
		install = new JButton("DB 셋팅");
		install.addActionListener(new buttonlistener());
		install.setSize(100,30);
		install.setLocation(xpos-600, 200);
		install.setVisible(false);
		add(install);
		Vitem =new JButton("상품 보기");
		Vitem.addActionListener(new buttonlistener());
		Vitem.setSize(100,30);
		Vitem.setLocation(xpos-600, 100);
		Vitem.setVisible(false);
		add(Vitem);
		cart = new JButton("장바구니");
		cart.addActionListener(new buttonlistener());
		cart.setSize(100,30);
		cart.setLocation(xpos-400, 100);
		cart.setVisible(false);
		add(cart);
		/*
		addcard = new JButton("카드 가입");
		addcard.addActionListener(new buttonlistener());
		addcard.setSize(100,30);
		addcard.setLocation(xpos-600, 200);
		addcard.setVisible(false);
		add(addcard);
		*/
		Oitem = new JButton("주문 배송");
		Oitem.addActionListener(new buttonlistener());
		Oitem.setSize(100,30);
		Oitem.setLocation(xpos-600, 200);
		Oitem.setVisible(false);
		add(Oitem);
		Myitem = new JButton("판매 리스트");
		Myitem.addActionListener(new buttonlistener());
		Myitem.setSize(120,30);
		Myitem.setLocation(xpos-600, 100);
		Myitem.setVisible(false);
		add(Myitem);
		sellitem = new JButton("주문 배송");
		sellitem.addActionListener(new buttonlistener());
		sellitem.setSize(100,30);
		sellitem.setLocation(xpos-400, 100);
		sellitem.setVisible(false);
		add(sellitem);
	}
	public void bClick(){
		login.setVisible(true);
		account.setVisible(true);
		Lid.setVisible(true);
		Lpw.setVisible(true);
		Tid.setVisible(true);
		Tpw.setVisible(true);
		logout.setVisible(false);
		change.setVisible(false);
		Lloginid.setVisible(false);
		Tid.setText("");
		Tpw.setText("");
	}
	private class buttonlistener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Object source = e.getSource();
			ResultSet re=null;
			if(source==login){
				try {
					if((u=manager.login(Tid.getText(),Tpw.getText()))!=null){
						if(u.getState()==1)
						{
							System.out.println("상태 : "+u.getState());
							login.setVisible(false);
							account.setVisible(false);
							Lid.setVisible(false);
							Lpw.setVisible(false);
							Tid.setVisible(false);
							Tpw.setVisible(false);
							logout.setVisible(true);
							change.setVisible(true);
							if(u.getType()==1){
								type="운영자";
								amanager.setVisible(true);
								backup.setVisible(true);
								install.setVisible(true);
								}
							else if(u.getType()==2){
								type="회원";
								Vitem.setVisible(true);
								cart.setVisible(true);
								//addcard.setVisible(true);
								Oitem.setVisible(true);
								}
							else if(u.getType()==3){
								type="판매자";
								Myitem.setVisible(true);
								sellitem.setVisible(true);
								}
							Lloginid.setText(u.getId()+"님 환영 합니다. 자격  : "+type);
							Lloginid.setVisible(true);
							repaint();
						}
						else
							JOptionPane.showMessageDialog(null, "사용 제한 회원 입니다 관리자에게 문의하세요");
					}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(source==logout){
				login.setVisible(true);
				account.setVisible(true);
				Lid.setVisible(true);
				Lpw.setVisible(true);
				Tid.setVisible(true);
				Tpw.setVisible(true);
				logout.setVisible(false);
				change.setVisible(false);
				Lloginid.setVisible(false);
				amanager.setVisible(false);
				backup.setVisible(false);
				install.setVisible(false);
				Vitem.setVisible(false);
				cart.setVisible(false);
				//addcard.setVisible(false);
				Oitem.setVisible(false);
				Myitem.setVisible(false);
				sellitem.setVisible(false);
				Tid.setText("");
				Tpw.setText("");
			}
			if(source==account){
				manager.addAccount();
			}
			if(source==change){
				manager.changeAccount(u);
			}
			if(source==amanager){
				Damanager dialog = new Damanager(manager);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
			if(source==Myitem){
				DIlist dialog1 = new DIlist(manager,u.getId());
				dialog1.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog1.setVisible(true);
			}
			if(source==Vitem){
				showItem dialog2 = new showItem(manager,u.getId());
				dialog2.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog2.setVisible(true);
			}
			if(source==cart){
				Dcart dialog3 = new Dcart(manager,u.getId());
				dialog3.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog3.setVisible(true);
			}
			if(source==sellitem){
				Dseller dialog4 = new Dseller(manager,u.getId());
				dialog4.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog4.setVisible(true);
			}
			if(source==Oitem){
				Duser dialog5 = new Duser(manager,u.getId());
				dialog5.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog5.setVisible(true);
			}
			if(source==backup){
				user su;
				address sad;
				cart scart;
				product spro;
				buyitem bi;
				try {
					ObjectOutputStream user = new ObjectOutputStream(new FileOutputStream("d:\\user.ser"));
					ObjectOutputStream address = new ObjectOutputStream(new FileOutputStream("d:\\address.ser"));
					ObjectOutputStream cartlist = new ObjectOutputStream(new FileOutputStream("d:\\cartlist.ser"));
					ObjectOutputStream product = new ObjectOutputStream(new FileOutputStream("d:\\product.ser"));
					ObjectOutputStream buyitem = new ObjectOutputStream(new FileOutputStream("d:\\buyitem.ser"));
					re=userDB.Alluser();
					while(re.next()){
						su=new user(re.getString(1),re.getString(3),re.getString(4),
								re.getInt(2),re.getString(5),re.getString(6),
								re.getInt(7),re.getInt(8),re.getInt(9));
						user.writeObject(su);
					}
					re=userDB.Alladdress();
					while(re.next()){
						sad=new address(re.getString(1),re.getString(2),re.getString(3));
						address.writeObject(sad);
					}
					re=cartDB.Allcartlist();
					while(re.next()){
						scart=new cart(re.getString(1),re.getInt(2));
						cartlist.writeObject(scart);
					}
					re=productDB.allProduct();
					while(re.next()){
						spro =new product(re.getInt(1),re.getString(2),
								re.getString(3),re.getInt(4),re.getInt(5),re.getInt(6));
						product.writeObject(spro);
					}
					re=BuyItemDB.Allbuyitem();
					while(re.next()){
						bi=new buyitem(re.getInt(1),re.getString(2),re.getString(3),
								re.getInt(4),re.getInt(5),re.getInt(6),re.getString(7),
								re.getInt(8));
						buyitem.writeObject(bi);
					}
				} catch (IOException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(source==install){
				try {
					user iu;
					ObjectInputStream iuser = new ObjectInputStream(new FileInputStream("d:\\user.ser"));
					while((iu=(user) iuser.readObject()) != null){
						userDB.addUser(iu);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					address iad;
					ObjectInputStream iaddress  = new ObjectInputStream(new FileInputStream("d:\\address.ser"));
					while((iad=(address) iaddress.readObject()) != null){
											userDB.addaddress(iad.getId(), iad.getAddress(),iad.getType());
										}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					cart icart;
					ObjectInputStream icartlist  = new ObjectInputStream(new FileInputStream("d:\\cartlist.ser"));
					while((icart=(cart) icartlist.readObject()) != null){
											cartDB.addlist(icart.getId(),icart.getItem());
										}
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					product ipro;
					ObjectInputStream iproduct  = new ObjectInputStream(new FileInputStream("d:\\product.ser"));
					while((ipro=(product) iproduct.readObject()) != null){
											productDB.addProduct(ipro);
										}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					buyitem ibi;
					ObjectInputStream ibuyitem  = new ObjectInputStream(new FileInputStream("d:\\buyitem.ser"));
					while((ibi=(buyitem) ibuyitem.readObject()) != null){
											BuyItemDB.additem(ibi);
										}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
}

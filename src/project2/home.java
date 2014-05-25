package project2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import project2.user.*;
public class home extends JFrame{
	JLabel Lid,Lpw,Lloginid;
	JButton login,account,change,logout;
	JTextField Tid,Tpw,Tlogin;
	account manager = new account();
	Dimension size;
	int x,y;
	int xpos;
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
		Tpw= new JTextField();
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
	}
	private class buttonlistener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Object source = e.getSource();
			if(source==login){
				login.setVisible(false);
				account.setVisible(false);
				Lid.setVisible(false);
				Lpw.setVisible(false);
				Tid.setVisible(false);
				Tpw.setVisible(false);
				logout.setVisible(true);
				change.setVisible(true);
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
			}
			if(source==account){
				manager.addAccount();
			}
		}
	}
}

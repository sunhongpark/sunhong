package project2;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

import project2.user.*;
public class home extends JFrame{
	JLabel Lid,Lpw,Lloginid;
	JButton login,account,change,logout;
	JTextField Tid,Tpw,Tlogin;
	account manager = new account();
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
		setTitle("��ũ��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		loginMenu();
		setSize(x,y);
		setVisible(true);
	}
	public void loginMenu(){
		login = new JButton("�α���");
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
		account = new JButton("ȸ�� ����");
		account.addActionListener(new buttonlistener());
		account.setSize(100, 30);
		account.setLocation(xpos-120,30);
		add(account);
		change= new JButton("���� ����");
		change.addActionListener(new buttonlistener());
		change.setSize(100, 30);
		change.setLocation(xpos-120,30);
		change.setVisible(false);
		add(change);
		logout = new JButton("�α׾ƿ�");
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
	}
	private class buttonlistener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Object source = e.getSource();
			if(source==login){
				try {
					if((u=manager.login(Tid.getText(),Tpw.getText()))!=null){
						login.setVisible(false);
						account.setVisible(false);
						Lid.setVisible(false);
						Lpw.setVisible(false);
						Tid.setVisible(false);
						Tpw.setVisible(false);
						logout.setVisible(true);
						change.setVisible(true);
						if(u.getType()==1){
							type="���";
						}
						else if(u.getType()==2){
							type="ȸ��";
						}
						else if(u.getType()==1){
							type="�Ǹ���";
						}
						Lloginid.setText(u.getId()+"�� ȯ�� �մϴ�. �ڰ�  : "+type);
						Lloginid.setVisible(true);
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
			}
			if(source==account){
				manager.addAccount();
			}
			if(source==change){
				manager.changeAccount(u);
			}
		}
	}
}

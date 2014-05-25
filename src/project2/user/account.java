package project2.user;
import project2.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
public class account extends JFrame{
	protected String url,Did,Dpw;
	protected String id;
	protected String pw;
	protected Dimension size;
	protected JTextField Tid,Tname,Tad,Tnumber1;
	protected JPasswordField Tpw,Tnumber2;
	protected ButtonGroup g1,g2;
	protected JRadioButton customer,seller,M,W;
	protected JButton ok,check;
	protected boolean checkID=false;
	protected Connection conn;
	protected userDB u =new userDB();
	public account() {
		size=Toolkit.getDefaultToolkit().getScreenSize();
	}
	public void addAccount(){
		int x=(int)((int)size.height*0.5);
		int y=(int)((int)size.width*0.3);
		setTitle("회원 가입");
		setSize(x,y);
		GridLayout Grid = new GridLayout(4,3);
		setLayout(null);
		g1=new ButtonGroup();
		customer = new JRadioButton("회 원",true);
		seller = new JRadioButton("판매자");
		g1.add(customer);
		g1.add(seller);
		ButtonGroup g2=new ButtonGroup();
		JLabel type =new JLabel("구분 : ");
		M = new JRadioButton("M",true);
		W = new JRadioButton("W");
		g2.add(M);
		g2.add(W);
		type.setLocation(10, 30);
		type.setSize(100,30);
		add(type);
		customer.setLocation(120, 30);
		customer.setSize(100,30);
		add(customer);
		seller.setLocation(230, 30);
		seller.setSize(120,30);
		add(seller);
		JLabel Lid= new JLabel("아이디 : ");
		Lid.setLocation(10, 70);
		Lid.setSize(100,30);
		add(Lid);
		Tid= new JTextField();
		Tid.setLocation(120,70);
		Tid.setSize(100,30);
		add(Tid);
		check =new JButton("중복 확인");
		check.setLocation(230, 70);
		check.setSize(100,30);
		check.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					if(u.checkID(Tid.getText()))
					{
						checkID=true;
					JOptionPane.showMessageDialog(null, Tid.getText()+"사용 가능합니다");
					}
					else{
						checkID=false;
						JOptionPane.showMessageDialog(null, Tid.getText()+"사용 불가능합니다");
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
			}
		});
		add(check);
		JLabel Lpw= new JLabel("비밀번호 : ");
		Lpw.setLocation(10, 110);
		Lpw.setSize(100,30);
		add(Lpw);
		Tpw= new JPasswordField();
		Tpw.setLocation(120,110);
		Tpw.setSize(100,30);
		Tpw.setEchoChar('*');
		Tpw.setDocument(new JTextFieldLimit(10));
		add(Tpw);
		JLabel Lname= new JLabel("이름 : ");
		Lname.setLocation(10, 150);
		Lname.setSize(100,30);
		add(Lname);
		Tname= new JTextField();
		Tname.setLocation(120,150);
		Tname.setSize(100,30);
		add(Tname);
		JLabel Lad= new JLabel("주소 : ");
		Lad.setLocation(10, 190);
		Lad.setSize(100,30);
		add(Lad);
		Tad= new JTextField();
		Tad.setLocation(120,190);
		Tad.setSize(100,30);
		add(Tad);
		JLabel Lnumber= new JLabel("주민번호 : ");
		Lnumber.setLocation(10, 230);
		Lnumber.setSize(100,30);
		add(Lnumber);
		Tnumber1= new JTextField();
		Tnumber1.setLocation(120,230);
		Tnumber1.setSize(100,30);
		Tnumber1.setDocument(new JTextFieldLimit(6));
		Tnumber1.setDocument(new checkint());
		add(Tnumber1);
		Tnumber2= new JPasswordField();
		Tnumber2.setLocation(230,230);
		Tnumber2.setSize(100,30);
		Tnumber2.setEchoChar('*');
		Tnumber2.setDocument(new JTextFieldLimit(7));
		Tnumber2.setDocument(new checkint());
		add(Tnumber2);
		JLabel Lsex= new JLabel("성별 : ");
		Lsex.setLocation(10, 270);
		Lsex.setSize(100,30);
		add(Lsex);
		M.setLocation(120, 270);
		M.setSize(100,30);
		add(M);
		W.setLocation(230, 270);
		W.setSize(100,30);
		add(W);
		ok =new JButton("확인");
		ok.setLocation(150, 310);
		ok.setSize(100,30);
		add(ok);
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(checkID)
				{
					id=Tid.getText();
					pw=Tpw.getText();
					setVisible(false);
					Tid.setText("");
					Tpw.setText("");
					Tname.setText("");
					Tad.setText("");
					Tnumber1.setText("");
					Tnumber2.setText("");
					customer.setSelected(true);
					M.setSelected(true);
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "중복확인 하세요!");
				}
			}
		});
		setVisible(true);
	}

}

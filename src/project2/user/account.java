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
	protected JButton ok,check,check2;
	protected boolean checkID=false,checknumber=false;
	protected Connection conn;
	protected userDB u =new userDB();
	protected user user;
	public account() {
		size=Toolkit.getDefaultToolkit().getScreenSize();
	}
	public void addAccount(){
		int x=(int)((int)size.height*0.5);
		int y=(int)((int)size.width*0.3);
		setTitle("ȸ�� ����");
		setSize(x,y);
		GridLayout Grid = new GridLayout(4,3);
		setLayout(null);
		g1=new ButtonGroup();
		customer = new JRadioButton("ȸ ��",true);
		seller = new JRadioButton("�Ǹ���");
		g1.add(customer);
		g1.add(seller);
		ButtonGroup g2=new ButtonGroup();
		JLabel type =new JLabel("���� : ");
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
		JLabel Lid= new JLabel("���̵� : ");
		Lid.setLocation(10, 70);
		Lid.setSize(100,30);
		add(Lid);
		Tid= new JTextField();
		Tid.setLocation(120,70);
		Tid.setSize(100,30);
		add(Tid);
		check =new JButton("�ߺ� Ȯ��");
		check.setLocation(230, 70);
		check.setSize(100,30);
		check.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String tmp="";
				try {
					if(u.checkID(Tid.getText())/*&&Tid.getText().compareTo(tmp)!=0*/)
					{
						checkID=true;
					JOptionPane.showMessageDialog(null, Tid.getText()+"��� �����մϴ�");
					}
					else{
						checkID=false;
						JOptionPane.showMessageDialog(null, Tid.getText()+"��� �Ұ����մϴ�");
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
		JLabel Lpw= new JLabel("��й�ȣ : ");
		Lpw.setLocation(10, 110);
		Lpw.setSize(100,30);
		add(Lpw);
		Tpw= new JPasswordField();
		Tpw.setLocation(120,110);
		Tpw.setSize(100,30);
		Tpw.setEchoChar('*');
		Tpw.setDocument(new JTextFieldLimit(10));
		add(Tpw);
		JLabel Lname= new JLabel("�̸� : ");
		Lname.setLocation(10, 150);
		Lname.setSize(100,30);
		add(Lname);
		Tname= new JTextField();
		Tname.setLocation(120,150);
		Tname.setSize(100,30);
		add(Tname);
		JLabel Lad= new JLabel("�ּ� : ");
		Lad.setLocation(10, 190);
		Lad.setSize(100,30);
		add(Lad);
		Tad= new JTextField();
		Tad.setLocation(120,190);
		Tad.setSize(350,30);
		add(Tad);
		JLabel Lnumber= new JLabel("�ֹι�ȣ : ");
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
		check2 =new JButton("�ߺ� Ȯ��");
		check2.setLocation(340, 230);
		check2.setSize(100,30);
		check2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String tmp="";
				try {
					if(userDB.checkNumber(Tnumber1.getText(),Tnumber2.getText())
							/*&&Tnumber1.getText().compareTo(tmp)!=0*/)
					{
						checknumber=true;
					JOptionPane.showMessageDialog(null, "��밡�� �մϴ�");
					}
					else{
						checknumber=false;
						JOptionPane.showMessageDialog(null, "�̹� ������� ȸ��");
					}
				} catch (HeadlessException | ClassNotFoundException
						| SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
			}
		});
		add(check2);
		JLabel Lsex= new JLabel("���� : ");
		Lsex.setLocation(10, 270);
		Lsex.setSize(100,30);
		add(Lsex);
		M.setLocation(120, 270);
		M.setSize(100,30);
		add(M);
		W.setLocation(230, 270);
		W.setSize(100,30);
		add(W);
		ok =new JButton("Ȯ��");
		ok.setLocation(150, 310);
		ok.setSize(100,30);
		add(ok);
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int sex,grade,type;
				if(checkID&&checknumber)
				{
					if(customer.isSelected())
						type=2;
					else
						type=3;
					if(M.isSelected())
						sex=1;
					else
						sex=2;
					grade=1;
					user = new user(Tid.getText(), Tpw.getText(), Tname.getText()
							, type, Tnumber1.getText(), Tnumber2.getText(), sex, grade);
					try {
						if(userDB.addUser(user)&&userDB.addaddress(Tid.getText(),Tad.getText(),"�⺻�ּ�")){
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
						else{
							JOptionPane.showMessageDialog(null, "���̵� ���� ����");
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "�ߺ�Ȯ�� �ϼ���!");
				}
			}
		});
		setVisible(true);
	}
	public user login(String id,String pw) throws ClassNotFoundException, SQLException{
		user tmp;
		if((tmp=userDB.login(id, pw))!=null)
		{
			System.out.println("account ok");
			return tmp;
		}
		else
			return null;
	}
	public void changeAccount(user user){
		Dmodify_user dialog = new Dmodify_user(this,user);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}

}

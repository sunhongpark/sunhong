package project2.order;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dseller extends JDialog {
	private JTable table;
	Object data[]=new Object[7];
	String calName[]={"주문번호","구매자","주소","물품번호","수량","상태","선택"};
	int row=-1;
	DefaultTableModel tableModel;
	ResultSet re;
	String id;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*
		try {
			Dseller dialog = new Dseller();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
	}

	/**
	 * Create the dialog.
	 */
	public Dseller(JFrame JFrame,String id) {
		super(JFrame,"판매 물품 관리",true);
		this.id=id;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 410, 179);
		getContentPane().add(scrollPane);
		
		tableModel=new DefaultTableModel(calName,0);
		table = new JTable(tableModel);
		try {
			conn();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				select();
			}
		});
		scrollPane.setViewportView(table);
		
		JButton button = new JButton("\uBC30\uC1A1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(row>=0)
				{
					if((String)tableModel.getValueAt(row, 5)=="배송중"){
						try {
							BuyItemDB.shipItem((int)tableModel.getValueAt(row, 0));
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else
						JOptionPane.showMessageDialog(null, "상태 오류");
				}
			}
		});
		button.setBounds(12, 229, 97, 23);
		getContentPane().add(button);
		
		JButton btnNewButton = new JButton("\uD310\uB9E4 \uC644\uB8CC");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(row>=0)
				{
					if((String)tableModel.getValueAt(row, 5)=="완료"){
						try {
							BuyItemDB.sucItem((int)tableModel.getValueAt(row, 0));
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else
						JOptionPane.showMessageDialog(null, "상태 오류");
				}
			}
		});
		btnNewButton.setBounds(161, 229, 97, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uD655\uC778");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(325, 229, 97, 23);
		getContentPane().add(btnNewButton_1);
	}
	public void select(){
		int Nrow = table.getSelectedRow();
		if(row<0){
			tableModel.setValueAt("선택", Nrow, 6);
			row=Nrow;
		}
		else{
			tableModel.setValueAt("", row, 6);
			tableModel.setValueAt("선택", Nrow, 6);
			row=Nrow;
		}
	}
	
	public void conn() throws ClassNotFoundException, SQLException{
				re=BuyItemDB.findSeller(id);
				while(re.next()){
					data[0]=re.getInt(1);
					data[1]=re.getString(3);
					data[2]=re.getString(7);
					data[3]=re.getInt(4);
					data[4]=re.getInt(8);
					switch(re.getInt(6))
					{
						case 1:
							data[5]="결제중";
							break;
						case 2:
							data[5]="배송중";
							break;
						case 3:
							data[5]="확인중";
							break;
						case 4:
							data[5]="확인 완료";
							break;
						case 5:
							data[5]="판매 완료";
							break;
					}
					tableModel.addRow(data);
				}
	}
}

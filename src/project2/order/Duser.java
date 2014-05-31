package project2.order;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Duser extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	Object data[]=new Object[7];
	String calName[]={"주문번호","판매자","주소","물품번호","수량","상태","선택"};
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
			Duser dialog = new Duser();
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
	public Duser(JFrame JFrame,String id) {
		super(JFrame,"주문 배송",true);
		this.id=id;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 10, 410, 190);
			contentPanel.add(scrollPane);
			{
				tableModel=new DefaultTableModel(calName,0);
				table = new JTable(tableModel);
				try {
					conn();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				table.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						select();
					}
				});
				scrollPane.setViewportView(table);
			}
		}
		{
			JButton btnNewButton = new JButton("\uACB0\uC81C");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(row>=0)
					{
						if((String)tableModel.getValueAt(row, 5)=="결제중"){
							try {
								BuyItemDB.payItem((int)tableModel.getValueAt(row, 0));
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
			btnNewButton.setBounds(12, 210, 97, 23);
			contentPanel.add(btnNewButton);
		}
		{
			JButton btnNewButton_1 = new JButton("\uC0C1\uD488\uC218\uB839");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(row>=0)
					{
						if((String)tableModel.getValueAt(row, 5)=="확인중"){
							try {
								BuyItemDB.recItem((int)tableModel.getValueAt(row, 0));
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
			btnNewButton_1.setBounds(172, 210, 97, 23);
			contentPanel.add(btnNewButton_1);
		}
		{
			JButton btnNewButton_2 = new JButton("\uD655\uC778");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			btnNewButton_2.setBounds(325, 210, 97, 23);
			contentPanel.add(btnNewButton_2);
		}
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
				re=BuyItemDB.finduser(id);
				while(re.next()){
					data[0]=re.getInt(1);
					data[1]=re.getString(2);
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

package project2.product;

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
import javax.swing.JSlider;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;

import project2.order.Dbuyitem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class showItem extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	Object data[]=new Object[7];
	String calName[]={"물품 번호","물품명","가격","개수","상태","판매자","선택"};
	int row=-1;
	DefaultTableModel tableModel;
	ResultSet re;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*
		try {
			showItem dialog = new showItem();
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
	public showItem(final JFrame JFrame,final String id) {
		super(JFrame,"상품 목록 확인 ",true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 10, 410, 208);
		contentPanel.add(scrollPane);
		
		tableModel=new DefaultTableModel(calName,0);
		table = new JTable(tableModel);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				select();
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("\uBB3C\uD488\uAD6C\uC785");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((String)tableModel.getValueAt(row,4)=="구입 가능"){
					int inumber=(int)tableModel.getValueAt(row, 0);
					int pay=(int)tableModel.getValueAt(row, 2);
					String seller=(String)tableModel.getValueAt(row, 5);
					Dbuyitem dialog = new Dbuyitem(JFrame,id,seller,inumber,pay);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(null, "구입 불가능 상태");
			}
		});
		btnNewButton.setBounds(147, 228, 97, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uC7A5\uBC14\uAD6C\uB2C8 \uCD94\uAC00");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(row>=0)
						cartDB.addlist(id,(int)tableModel.getValueAt(row, 0));
					else
						JOptionPane.showMessageDialog(null, "선택하세요");
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(256, 228, 120, 23);
		contentPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\uB9AC\uC2A4\uD2B8 \uCD9C\uB825");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableModel.setNumRows(0);
				try {
					re=productDB.allProduct();
					while(re.next()){
						data[0]=re.getInt(1);
						data[1]=re.getString(3);
						data[2]=re.getInt(4);
						data[3]=re.getInt(5);
						if(re.getInt(6)==1)
						{
							data[4]="구입 가능";
						}
						else if(re.getInt(6)==2)
						{
							data[4]="일시적 품절";
						}
						else{
							data[4]="품절";
						}
						data[5]=re.getString(2);
						tableModel.addRow(data);
					}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(10, 228, 125, 23);
		contentPanel.add(btnNewButton_2);
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
}

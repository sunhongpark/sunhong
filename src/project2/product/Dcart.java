package project2.product;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

import project2.order.Dbuyitem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dcart extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	Object data[]=new Object[7];
	String calName[]={"물품 번호","물품명","가격","개수","상태","판매자","선택"};
	int row=-1;
	DefaultTableModel tableModel;
	ResultSet re,re1;
	String id;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*
		try {
			Dcart dialog = new Dcart();
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
	public Dcart(final JFrame JFrame,final String id) {
		super(JFrame,"장바구니",true);
		this.id=id;
		setBounds(100, 100, 489, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 10, 449, 182);
			contentPanel.add(scrollPane);
			
			tableModel=new DefaultTableModel(calName,0);
			table = new JTable(tableModel);
			tableModel.setNumRows(0);
			try {
				addlist();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					select();
				}
			});
			scrollPane.setViewportView(table);
		}
		
		JButton btnNewButton = new JButton("\uC0AD\uC81C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(row>=0)
					{
						cartDB.deleteItem(id,(int)tableModel.getValueAt(row, 0));
						addlist();
						row=-1;
					}
					else
						JOptionPane.showMessageDialog(null, "선택 하세요");
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(12, 215, 97, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uAD6C\uB9E4");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(row>=0)
				{
					Dbuyitem dialog = new Dbuyitem(JFrame,id,
							(String)tableModel.getValueAt(row, 5),
							(int)tableModel.getValueAt(row, 0),
							(int)tableModel.getValueAt(row, 3));
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					
				}
				else
					JOptionPane.showMessageDialog(null, "선택 하세요");
			}
		});
		btnNewButton_1.setBounds(156, 215, 97, 23);
		contentPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\uD655\uC778");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(300, 215, 97, 23);
		contentPanel.add(btnNewButton_2);
	}
	public void select(){
		int Nrow = table.getSelectedRow();
		if(row<0){
			tableModel.setValueAt("선택", Nrow, 5);
			row=Nrow;
		}
		else{
			tableModel.setValueAt("", row, 5);
			tableModel.setValueAt("선택", Nrow, 5);
			row=Nrow;
		}
	}
	public void addlist() throws ClassNotFoundException, SQLException{
		re=cartDB.findcart(id);
		tableModel.setNumRows(0);
		while(re.next()){
			re1=productDB.findproduct(re.getInt(2));
			while(re1.next()){
				data[0]=re1.getInt(1);
				data[1]=re1.getString(3);
				data[2]=re1.getInt(4);
				data[3]=re1.getInt(5);
				data[4]=re1.getInt(6);
				data[5]=re1.getString(2);
				tableModel.addRow(data);
			}
		}
	}
}

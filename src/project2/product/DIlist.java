package project2.product;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;

public class DIlist extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	Object data[]=new Object[6];
	String calName[]={"물품 번호","물품명","가격","개수","상태","선택"};
	int row=-1;
	DefaultTableModel tableModel;
	ResultSet re;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*
		try {
			DIlist dialog = new DIlist();
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
	public DIlist(final JFrame JFrame,final String id) {
		super(JFrame,"판매자 상품 관리 ",true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 10, 410, 148);
			contentPanel.add(scrollPane);
			{
				tableModel=new DefaultTableModel(calName,0);
				table = new JTable(tableModel);
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						select();
					}
				});
				scrollPane.setViewportView(table);
			}
		}
		{
			JButton btnNewButton = new JButton("\uB9AC\uC2A4\uD2B8 \uCD9C\uB825");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						try {
							tableModel.setNumRows(0);
							re=productDB.findproduct(id);
							while(re.next()){
								data[0]=re.getInt(1);
								data[1]=re.getString(3);
								data[2]=re.getInt(4);
								data[3]=re.getInt(5);
								data[4]=re.getInt(6);
								tableModel.addRow(data);
							}
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}
			});
			btnNewButton.setBounds(12, 168, 107, 23);
			contentPanel.add(btnNewButton);
		}
		{
			JButton btnNewButton_1 = new JButton("\uC544\uC774\uD15C \uCD94\uAC00");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Ditem dialog1 = new Ditem(JFrame,id);
					dialog1.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog1.setVisible(true);
				}
			});
			btnNewButton_1.setBounds(12, 201, 107, 23);
			contentPanel.add(btnNewButton_1);
		}
		{
			JButton btnNewButton_2 = new JButton("\uC544\uC774\uD15C \uC0AD\uC81C");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						productDB.deleteP((int)tableModel.getValueAt(row,0));
						row=-1;
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnNewButton_2.setBounds(12, 234, 107, 23);
			contentPanel.add(btnNewButton_2);
		}
		{
			JLabel lblNewLabel = new JLabel("\uC218\uB7C9 : ");
			lblNewLabel.setBounds(131, 173, 57, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("\uAC00\uACA9 :");
			lblNewLabel_1.setBounds(131, 206, 57, 15);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("\uC0C1\uD0DC :");
			lblNewLabel_2.setBounds(131, 239, 57, 15);
			contentPanel.add(lblNewLabel_2);
		}
		
		textField = new JTextField();
		textField.setBounds(167, 169, 116, 21);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(167, 203, 116, 21);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uD310\uB9E4 \uAC00\uB2A5", "\uC77C\uC2DC\uC801 \uD488\uC808", "\uD488\uC808"}));
		comboBox.setBounds(167, 236, 116, 21);
		contentPanel.add(comboBox);
		{
			JButton btnNewButton_3 = new JButton("\uC218\uB7C9 \uC218\uC815");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//수량 수정
						try {
							System.out.println(textField.getText()+" "+tableModel.getValueAt(row,0)+"\";");
							productDB.modifynum((int)tableModel.getValueAt(row,0), 
									textField.getText());
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
			});
			btnNewButton_3.setBounds(306, 168, 97, 23);
			contentPanel.add(btnNewButton_3);
		}
		{
			JButton btnNewButton_4 = new JButton("\uAC00\uACA9 \uC218\uC815");
			btnNewButton_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//가격 수정
					try {
						productDB.modifypay((int)tableModel.getValueAt(row,0), 
								textField_1.getText());
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnNewButton_4.setBounds(306, 201, 97, 23);
			contentPanel.add(btnNewButton_4);
		}
		{
			JButton btnNewButton_5 = new JButton("\uC0C1\uD0DC \uC218\uC815");
			btnNewButton_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//상태 수정
					int index= comboBox.getSelectedIndex();
					try {
						productDB.modifyState((int)tableModel.getValueAt(row,0), 
									index+1);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnNewButton_5.setBounds(306, 234, 97, 23);
			contentPanel.add(btnNewButton_5);
		}
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
}

package project2.user;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JRadioButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
public class Damanager extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	JTextField selected=new JTextField();
	Object data[]=new Object[5];
	DefaultTableModel tableModel;
	JRadioButton rdbtnNewRadioButton,rdbtnNewRadioButton_1,rdbtnNewRadioButton_2;
	ResultSet re;
	String calName[]={"아이디","권한","등급","상태","선택"};
	int row=-1;
	int count=0;
	JComboBox comboBox_1,comboBox;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		/*
		try {
			Damanager dialog = new Damanager();
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
	public Damanager(JFrame JFrame) {
		super(JFrame,"회원 정보 관리 ",true);
		setBounds(100, 100, 564, 341);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				select();
			}
		});
		scrollPane.setBounds(12, 10, 363, 209);
		contentPanel.add(scrollPane);
		tableModel=new DefaultTableModel(calName,0);
		table = new JTable();
		table.setModel(tableModel);
		table.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				select();
			}
		});
		scrollPane.setViewportView(table);
		ButtonGroup select =new ButtonGroup();
		rdbtnNewRadioButton = new JRadioButton("\uC804\uCCB4 \uAC80\uC0C9",true);
		rdbtnNewRadioButton.setBounds(396, 13, 121, 23);
		select.add(rdbtnNewRadioButton);
		contentPanel.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("\uD65C\uC131 \uC544\uC774\uB514 \uAC80\uC0C9");
		rdbtnNewRadioButton_1.setBounds(396, 61, 121, 23);
		select.add(rdbtnNewRadioButton_1);
		contentPanel.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2 = new JRadioButton("\uBE14\uB7ED \uC544\uC774\uB514 \uAC80\uC0C9");
		rdbtnNewRadioButton_2.setBounds(396, 108, 121, 23);
		select.add(rdbtnNewRadioButton_2);
		contentPanel.add(rdbtnNewRadioButton_2);
		
		JButton btnNewButton = new JButton("\uAC80\uC0C9");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnNewRadioButton.isSelected()){
					try {
						tableModel.setNumRows(0);
						re=userDB.findAlluser();
						while(re.next()){
							data[0]=re.getString(1);
							data[1]=re.getInt(2);
							data[2]=re.getInt(8);
							data[3]=re.getInt(9);
							tableModel.addRow(data);
							count++;
						}
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(rdbtnNewRadioButton_1.isSelected()){
					try {
						tableModel.setNumRows(0);
						re=userDB.findActivityuser();
						while(re.next()){
							data[0]=re.getString(1);
							data[1]=re.getInt(2);
							data[2]=re.getInt(8);
							data[3]=re.getInt(9);
							tableModel.addRow(data);
							count++;
						}
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(rdbtnNewRadioButton_2.isSelected()){
					try {
						tableModel.setNumRows(0);
						re=userDB.findBlockuser();
						while(re.next()){
							data[0]=re.getString(1);
							data[1]=re.getInt(2);
							data[2]=re.getInt(8);
							data[3]=re.getInt(9);
							tableModel.addRow(data);
							count++;
						}
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		btnNewButton.setBounds(406, 137, 97, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uB4F1\uAE09 \uBCC0\uACBD");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//등급 변경
				int index= comboBox.getSelectedIndex();
				System.out.println(tableModel.getValueAt(row,0)+" "+index);
				try {
					userDB.modifyGrade((String)tableModel.getValueAt(row,0), index+1);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(12, 270, 97, 23);
		contentPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\uC0C1\uD0DC \uBCC0\uACBD");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//상태 변경
				int index= comboBox_1.getSelectedIndex();
				try {
					userDB.modifyState((String)tableModel.getValueAt(row,0), index+1);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(147, 270, 97, 23);
		contentPanel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\uBE44\uBC00\uBC88\uD638 \uBCC0\uACBD");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//비밀 번호 변경
				try {
					userDB.modifyPw((String)tableModel.getValueAt(row,0), passwordField.getText());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(281, 270, 121, 23);
		contentPanel.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("\uBE44\uBC00 \uBC88\uD638 :");
		lblNewLabel.setBounds(299, 241, 76, 15);
		contentPanel.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(385, 238, 151, 21);
		contentPanel.add(passwordField);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uBE0C\uB860\uC988", "\uC2E4\uBC84", "\uACE8\uB4DC"}));
		comboBox.setBounds(22, 238, 68, 21);
		contentPanel.add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"\uD65C\uC131", "\uBE14\uB85D"}));
		comboBox_1.setBounds(171, 238, 58, 21);
		contentPanel.add(comboBox_1);
	}
	
	public void select(){
		int Nrow = table.getSelectedRow();
		if(row<0){
			tableModel.setValueAt("선택", Nrow, 4);
			row=Nrow;
		}
		else{
			tableModel.setValueAt("", row, 4);
			tableModel.setValueAt("선택", Nrow, 4);
			row=Nrow;
		}
	}
}

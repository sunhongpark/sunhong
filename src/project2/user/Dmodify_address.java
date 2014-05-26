package project2.user;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JSpinner;

import net.miginfocom.swing.MigLayout;

import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Dmodify_address extends JDialog {
	private JTable table;
	userDB u =new userDB();
	int num=0;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			/*
			Dmodify_address dialog = new Dmodify_address();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings("null")
	public Dmodify_address(JFrame JFrame,final String id) {
		super(JFrame,"주소 변경 ",true);
		setBounds(100, 100, 450, 300);
		Object list[][] = new Object[10][3];
		try {
			ResultSet re=userDB.findAddress(id);
			while(re.next()){
				list[num][0]=(Object)re.getString(3);
				list[num++][1]=(Object)re.getString(2);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getContentPane().setLayout(new MigLayout("", "[434px,grow][][][]", "[33px,grow][][][]"));
		{
			table = new JTable();
			table.setModel(new DefaultTableModel(
				list,
				new String[] {
					"\uC8FC\uC18C\uBA85", "\uC8FC\uC18C"
				}
			));
			table.getColumnModel().getColumn(1).setPreferredWidth(250);
			JScrollPane pane=new JScrollPane(table);
			getContentPane().add(pane, "flowy,cell 0 0,grow");
			
		}
		{
			JButton btnNewButton = new JButton("\uC218\uC815");
			
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//수정
					try {
						userDB.modifyAddress(id, textField_1.getText(), textField.getText());
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					setVisible(false);
				}
			});
			{
				JLabel lblNewLabel = new JLabel("\uC8FC\uC18C\uBA85");
				getContentPane().add(lblNewLabel, "flowx,cell 0 1");
			}
			{
				textField = new JTextField();
				textField.setHorizontalAlignment(SwingConstants.LEFT);
				getContentPane().add(textField, "cell 0 1,growx");
				textField.setColumns(10);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("\uC8FC   \uC18C");
				getContentPane().add(lblNewLabel_1, "flowx,cell 0 2");
			}
			getContentPane().add(btnNewButton, "flowx,cell 0 3,alignx left");
		}
		{
			JButton btnNewButton_1 = new JButton("\uC0AD\uC81C");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//삭제
					if(num>1)
					{
					try {
						userDB.deleteAddress(id, textField.getText());
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
					else
						JOptionPane.showMessageDialog(null, "주소는 1개 이상 저장되어 있어야 합니다.");
					setVisible(false);
				}
			});
			getContentPane().add(btnNewButton_1, "cell 0 3,alignx right,aligny center");
		}
		{
			JButton btnNewButton_2 = new JButton("\uCD94\uAC00");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//추가
					if(num<6){
						try {
							userDB.addaddress(id, textField_1.getText(), textField.getText());
						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else
						JOptionPane.showMessageDialog(null, "더이상 주소를 추가할수 없습니다.");
					setVisible(false);
				}
			});
			getContentPane().add(btnNewButton_2, "cell 0 3,alignx center");
		}
		{
			textField_1 = new JTextField();
			textField_1.setHorizontalAlignment(SwingConstants.CENTER);
			getContentPane().add(textField_1, "cell 0 2,growx");
			textField_1.setColumns(10);
		}
	}

}

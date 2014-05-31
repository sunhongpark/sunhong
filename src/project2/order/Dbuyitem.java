package project2.order;

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
import javax.swing.JTable;
import javax.swing.JSlider;
import javax.swing.JLabel;

import project2.product.productDB;
import project2.user.userDB;

import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dbuyitem extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private String id,seller;
	private int pay,inumber,num;
	Object data[]=new Object[3];
	String calName[]={"주소명","주소","선택"};
	int row=-1;
	DefaultTableModel tableModel;
	ResultSet re;
	JSlider slider;
	JLabel lblNewLabel_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*
		try {
			Dbuyitem dialog = new Dbuyitem();
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
	public Dbuyitem(JFrame JFrame,final String id,final String seller,
			final int inumber,final int pay) {
		super(JFrame,"상품 구매 ",true);
		this.id=id;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		tableModel=new DefaultTableModel(calName,0);
		conn();
		slider = new JSlider();
		slider.setMinorTickSpacing(1);
		slider.setMajorTickSpacing(1);
		slider.setMinimum(1);
		slider.setMaximum(10);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setBounds(12, 150, 200, 46);
		contentPanel.add(slider);
		
		JButton btnNewButton = new JButton("\uC218\uB7C9 \uC120\uD0DD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				num=slider.getValue();
				lblNewLabel_1.setText(Integer.toString(num*pay));
			}
		});
		btnNewButton.setBounds(261, 157, 97, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uC644\uB8CC");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(pay*num);
				if(pay*num>0&&row>=0)
				{
					buyitem i= new buyitem(0,seller,id,inumber,pay*num,1,
							(String)tableModel.getValueAt(row,1),num);
					try {
						BuyItemDB.additem(i);
						productDB.Decitem(inumber,num);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					setVisible(false);
				}
				else
					JOptionPane.showMessageDialog(null, "선택 사항을 선택하세요");
			}
				
		});
		btnNewButton_1.setBounds(261, 214, 97, 23);
		contentPanel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("\uAC00\uACA9 : ");
		lblNewLabel.setBounds(25, 218, 57, 15);
		contentPanel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(79, 218, 57, 15);
		contentPanel.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 10, 398, 135);
		contentPanel.add(scrollPane);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				select();
			}
		});
	}
	public void select(){
		int Nrow = table.getSelectedRow();
		if(row<0){
			tableModel.setValueAt("선택", Nrow, 2);
			row=Nrow;
		}
		else{
			tableModel.setValueAt("", row, 2);
			tableModel.setValueAt("선택", Nrow, 2);
			row=Nrow;
		}
	}
	public void conn(){
			try {
				re=userDB.findAddress(id);
				while(re.next()){
					data[0]=re.getString(3);
					data[1]=re.getString(2);
					tableModel.addRow(data);
				}
			}catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}

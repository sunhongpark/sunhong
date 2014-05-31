package project2.product;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import project2.checkint;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class Ditem extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*
		try {
			Ditem dialog = new Ditem("abc");
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
	public Ditem(JFrame JFrame,final String id){
		super(JFrame,"판매자 상품 등록 ",true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		contentPanel.setLayout(new MigLayout("", "[][][][grow]", "[][][][][][][]"));
		{
			JLabel lblNewLabel_3 = new JLabel("\uD310\uB9E4\uC790 : ");
			contentPanel.add(lblNewLabel_3, "cell 1 0");
		}
		{
			JLabel lblNewLabel_4 = new JLabel(id);
			contentPanel.add(lblNewLabel_4, "cell 3 0");
		}
		{
			JLabel lblNewLabel = new JLabel("\uBB3C\uD488 \uC774\uB984 :");
			contentPanel.add(lblNewLabel, "cell 1 2");
		}
		{
			textField = new JTextField();
			contentPanel.add(textField, "cell 3 2,growx");
			textField.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("\uAC00\uACA9 : ");
			contentPanel.add(lblNewLabel_1, "cell 1 4");
		}
		{
			textField_1 = new JTextField();
			textField_1.setDocument(new checkint());
			contentPanel.add(textField_1, "cell 3 4,growx");
			textField_1.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("\uC218\uB7C9 :");
			contentPanel.add(lblNewLabel_2, "cell 1 6");
		}
		{
			textField_2 = new JTextField();
			textField_2.setDocument(new checkint());
			contentPanel.add(textField_2, "cell 3 6,growx");
			textField_2.setColumns(10);
		}
		{
			JButton btnNewButton = new JButton("\uB4F1\uB85D");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						String sql="insert into product values(0,\""+id+"\",\""
								+textField.getText()+"\","+textField_1.getText()+","+textField_2.getText()+",1);";
						System.out.println(sql);
						if(productDB.addPorduct(sql))
							setVisible(false);
						else
							JOptionPane.showMessageDialog(null, "상품 등록 오류");
					} catch (NumberFormatException | ClassNotFoundException
							| SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			getContentPane().add(btnNewButton, BorderLayout.SOUTH);
		}
	}

}

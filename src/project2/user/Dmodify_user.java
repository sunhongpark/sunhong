package project2.user;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class Dmodify_user extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Dmodify_user(final JFrame JFrame,final user user) {
		super(JFrame,"회원 정보 수정",true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.WEST);
		contentPanel.setLayout(new MigLayout("", "[97px][grow][][][][][][][][]", "[23px][][][][][][]"));
		{
			JLabel LLID = new JLabel("\uC544\uC774\uB514 : ");
			contentPanel.add(LLID, "cell 0 1,alignx center");
		}
		{
			JLabel LRID = new JLabel("abc");
			contentPanel.add(LRID, "cell 1 1");
		}
		{
			JLabel Lname = new JLabel("\uC774\uB984 : ");
			contentPanel.add(Lname, "cell 0 2,alignx center");
		}
		{
			JLabel LRname = new JLabel("\uBC15\uC120\uD64D");
			contentPanel.add(LRname, "cell 1 2");
		}
		{
			JLabel Lpw = new JLabel("\uBE44\uBC00\uBC88\uD638 : ");
			contentPanel.add(Lpw, "cell 0 3,alignx center");
		}
		{
			passwordField = new JPasswordField();
			contentPanel.add(passwordField, "cell 1 3,growx");
		}
		{
			JLabel Lnumber = new JLabel("\uC8FC\uBBFC \uBC88\uD638 : ");
			contentPanel.add(Lnumber, "cell 0 4,alignx center");
		}
		{
			JLabel lblNewLabel_1 = new JLabel("123456");
			contentPanel.add(lblNewLabel_1, "cell 1 4,alignx center,aligny center");
		}
		{
			JLabel lblNewLabel_3 = new JLabel("-");
			contentPanel.add(lblNewLabel_3, "cell 2 4");
		}
		{
			JLabel lblNewLabel_2 = new JLabel("*******");
			contentPanel.add(lblNewLabel_2, "cell 3 4");
		}
		{
			JLabel lblNewLabel = new JLabel("\uC8FC\uC18C  : ");
			contentPanel.add(lblNewLabel, "cell 0 5,alignx center");
		}
		{
			JButton btnNewButton = new JButton("\uC8FC\uC18C \uBCC0\uACBD");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Dmodify_address dialog = new Dmodify_address(JFrame,user.getId());
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
			});
			contentPanel.add(btnNewButton, "cell 1 5");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("\uC218\uC815");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							userDB.modifyPw(user.getId(),passwordField.getText());
						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						setVisible(false);
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("\uD68C\uC6D0 \uD0C8\uD1F4");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							userDB.memberLeave(user.getId());
						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						setVisible(false);
					}
				});
				buttonPane.add(cancelButton);
			}
		}
	}

}

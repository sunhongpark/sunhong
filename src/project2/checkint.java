package project2;

import javax.print.attribute.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
/*
 * Textfield���� int���� �����ְ� �ϴ� ���� ���̹� ����
 */
public class checkint extends PlainDocument{
	public checkint() {super();}
	public void insertString(int offset, String str, javax.swing.text.AttributeSet attr)
			throws BadLocationException{
		if (str == null)return;
		if(str.charAt(0) >= '0' && str.charAt(0) <= '9')
			super.insertString(offset, str, attr);
		///
		}
	}

package project2;

import javax.print.attribute.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
/*
 * 예외처리 JTextField에서 글자수 제한 네이버 참조
 */
public class JTextFieldLimit extends PlainDocument
{
    private int limit;
    private boolean toUppercase = false;

    public JTextFieldLimit(int limit)
    {
        super();
        this.limit = limit;
    }

    JTextFieldLimit(int limit, boolean upper)
    {
        super();
        this.limit = limit;
        this.toUppercase = upper;
    }

    public void insertString
        (int offset, String str, javax.swing.text.AttributeSet attr) throws BadLocationException
    {
        if (str == null)
        {
            return;
        }

        if ( (getLength() + str.length()) <= limit)
        {
            if (toUppercase)
            {
                str = str.toUpperCase();
            }
            super.insertString(offset, str, attr);
        }
    }
}


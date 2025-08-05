package App.Utils;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public abstract class IAStyle {
    public static final Color COLOR_FONT = new Color(220, 0, 0);
    public static final Color COLOR_FONT_LIGHT = new Color(100, 100, 100);
    public static final Color COLOR_BORDER = Color.BLACK;
    public static final Color COLOR_BORDER_LIGHT = Color.LIGHT_GRAY;

    public static final Font FONT = new Font("JetBrains Mono", Font.PLAIN, 14);
    public static final Font FONT_BOLD = new Font("JetBrains Mono", Font.BOLD, 14);
    public static final Font FONT_BIG = new Font("JetBrains Mono", Font.BOLD, 20);
    public static final Font FONT_SMALL = new Font("JetBrains Mono", Font.PLAIN, 10);

    public static final int ALIGNMENT_LEFT = SwingConstants.LEFT;
    public static final int ALIGNMENT_RIGHT = SwingConstants.RIGHT;
    public static final int ALIGNMENT_CENTER = SwingConstants.CENTER;

    public static final Cursor CURSOR_HAND = new Cursor(Cursor.HAND_CURSOR);
    public static final Cursor CURSOR_DEFAULT = new Cursor(Cursor.DEFAULT_CURSOR);

    public static final URL URL_INFO = IAStyle.class.getResource("/App/Assets/Img/images.png");
    public static final URL URL_LOGO = IAStyle.class.getResource("/App/Assets/Img/logo.png");
    public static final URL URL_SPLASH = IAStyle.class.getResource("/App/Assets/Img/splah.png");

    public static final CompoundBorder createBorderRect() {
        return BorderFactory.createCompoundBorder(
                new LineBorder(Color.lightGray),
                new EmptyBorder(5, 5, 5, 5));
    }

    public static final void showMsg(String msg) {
        JOptionPane.showMessageDialog(null, msg, "🤖 IABot", JOptionPane.INFORMATION_MESSAGE);
    }
        public static final void showMsgError(String msg) {
        JOptionPane.showMessageDialog(null, msg, " IABot murio ", JOptionPane.OK_OPTION);
    }
        public static final boolean showConfirmYesNo(String msg) {
        return  (JOptionPane.showConfirmDialog(null, msg, "🤖 IABot", JOptionPane.YES_NO_OPTION )== JOptionPane.YES_OPTION);
    }
}
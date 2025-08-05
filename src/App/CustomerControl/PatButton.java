package App.CustomerControl;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseListener;
import App.Utils.IAStyle;

public class PatButton extends JButton implements MouseListener {
    public PatButton(String text) {
        customizeComponent(text);
    }
    public PatButton(String text, String iconPath) {
        
        customizeComponent(text,iconPath);
    } 
public void customizeComponent(String text, String IconPath) {
    setSize(20, 70);
    addMouseListener(this);
    customizeComponent(text);
    setBounds(50, 30, 90, 20);

    setIcon(new ImageIcon(IconPath));
    setFont(IStyleUI.FONT);
}

public void customizeComponent(String text) {
    setText(text);
    setOpaque(false);
    setFocusPainted(false);
    setBorderPainted(false);
    setContentAreaFilled(false);
    setForeground(IStyleUI.COLOR_FONT);
    setHorizontalAlignment(IStyleUI.ALIGNMENT_LEFT);
    setFont(IStyleUI.FONT);

    setCursor(new Cursor(Cursor.HAND_CURSOR));
}

    // You can add more methods or properties specific to PatButton if needed

}

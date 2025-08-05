package App.CustomerControl;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class PatTextBox extends JTextField {

    public PatTextBox() {
        setOpaque(true);
        setForeground(Color.BLACK);
        setBackground(Color.WHITE);
        setBorderLine(); // Puedes definir un estilo por defecto
    }

    public void setBorderLine() {
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }
}

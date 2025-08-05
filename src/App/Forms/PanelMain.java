package App.Forms;
import App.Utils.IAStyle;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelMain extends JPanel{
    public PanelMain() {
       initComponents();

    }
    private void initComponents() {
        try {
            ImageIcon icon = new ImageIcon(IAStyle.URL_MAIN);
            add(new JLabel(icon), BorderLayout.CENTER);
        } catch ( Exception e) {
           IAStyle.showMsg("Error al cargar la imagen de fondo: " + e.getMessage());
        }
    }
}

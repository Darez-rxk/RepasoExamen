package App.Forms;

import App.CustomerControl.PatButton;
import App.CustomerControl.PatLabelText;
import App.Utils.IAStyle;
import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelMenu extends JPanel {
    private PatLabelText lblText;
    public PatButton 
            btnHome = new PatButton("Home"),
            btnLogin = new PatButton("Login"),
            btnTipoPersona = new PatButton("TipoPersona"),
            btnLocalidad = new PatButton("Localidad"),
            btnTest = new PatButton("Test");


    public PanelMenu() {
        initComponents();
    }

    private void initComponents() { 
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(250, getHeight()));
        try {
            Image logo = ImageIO.read(IAStyle.URL_LOGO);
            logo =logo.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            add(new JLabel(new ImageIcon(logo)));
    
        }catch (IOException e) {
            e.printStackTrace();
    }
        add(btnHome);
        add(btnLogin);
        add(btnTipoPersona);
        add(btnLocalidad);
        add(btnTest);
        add(new JLabel("\u22A0 2025 Darez-Rxk")); // Espacio vacío para separación

    }
    }

package App.Forms;

import App.Utils.*;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FormMain extends JFrame {

    PanelMenu pnlMenu = new PanelMenu();
    JPanel pnlMain = new PanelMain();

    public FormMain(String titleapp) {
        initComponents(titleapp);

        pnlMenu.btnHome.addActionListener          ((e) -> setPanel(new PanelMain()));
        pnlMenu.btnParlanteEsp.addActionListener   ((e) -> setPanel(new PParlanteEspanol()));
        pnlMenu.btnTest.addActionListener          (e -> IAStyle.showMsgError("Mensaje de error"));
        pnlMenu.btnTipoPersona.addActionListener   ((e) -> setPanel(new PanelPersonaTipo()));
    }
    public void setPanel(JPanel formularioPanel) {
        Container container = getContentPane();
        container.remove(pnlMain);
        pnlMain = formularioPanel;
        getContentPane().add(pnlMain, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
    private void initComponents(String titleapp) {
        setTitle(titleapp);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); // Center the form on the screen

        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        container.add(pnlMenu, BorderLayout.WEST);
        container.add(pnlMain, BorderLayout.CENTER);

        setVisible(true);
    }


}


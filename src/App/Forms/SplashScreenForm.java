package App.Forms;

import App.Utils.IAStyle;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class SplashScreenForm {
    
    private static JFrame frmSplash;
    private static JLabel lblSplash;
    private static JProgressBar progressBar;
    private static ImageIcon splashImage;
    public SplashScreenForm() {
        // Aquí podrías implementar la lógica para mostrar una pantalla de inicio
        // Por ejemplo, podrías usar un JFrame con un JLabel que muestre un logo o mensaje
        // y luego ocultarlo después de un tiempo o al iniciar la aplicación principal.
        initComponents();

    }
    
    private void initComponents() {
        splashImage = new ImageIcon(IAStyle.URL_LOGO);
        lblSplash = new JLabel(splashImage);
        progressBar = new JProgressBar(0,100);
        progressBar.setStringPainted(true);
        
        frmSplash = new JFrame();
        frmSplash.setUndecorated(true);
        frmSplash.getContentPane().add(lblSplash, BorderLayout.CENTER);
        frmSplash.add(progressBar, BorderLayout.SOUTH);
        frmSplash.setSize(splashImage.getIconWidth(), splashImage.getIconHeight());
        frmSplash.setLocationRelativeTo(null); // Centrar en la pantalla
        
        frmSplash.setVisible(true);
        
        for (int i = 0; i <= 100; i++) {
            try {
                Thread.sleep(50); // Espera por 50 milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            progressBar.setValue(i);
        }
    
        frmSplash.setVisible(false);
}

}

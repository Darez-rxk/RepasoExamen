package App.CustomerControl;

import App.Utils.IAStyle;
import java.awt.*;
import javax.swing.*;

public class PatLabelText extends JPanel {
    private PatLabel lblEtiqueta = new PatLabel();
    private PatTextBox txtContenido = new PatTextBox();

    public PatLabelText(String etiqueta) {
        setLayout(new BorderLayout());

        lblEtiqueta.setCustomizeComponent(
            etiqueta,
            IAStyle.FONT_SMALL,
            IAStyle.COLOR_FONT_LIGHT,
            IAStyle.ALIGNMENT_LEFT
        );

        // txtContenido.setBorder(txtContenido.createBorderLine());
        txtContenido.setBorderLine();

        add(lblEtiqueta, BorderLayout.NORTH);
        add(txtContenido, BorderLayout.CENTER);
    }
}

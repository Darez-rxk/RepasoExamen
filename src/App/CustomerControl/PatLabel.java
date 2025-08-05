    package App.CustomerControl;
    import App.Utils.IAStyle;
    import java.awt.Color;
    import java.awt.Font;
    import javax.swing.JLabel;
public class PatLabel extends JLabel {
    public PatLabel(){
        customizeComponent();
        
    }
    public PatLabel(String text) {
        setText(text);
        customizeComponent();
    }
    private void customizeComponent() {
        setCustomizeComponent(getText(),IAStyle.FONT,IAStyle.COLOR_FONT_LIGHT,IAStyle.ALIGNMENT_LEFT);
    }
    public void setCustomizeComponent(String text, Font font, Color color, int alignment) {
        setText (text);
        setFont(font);
        setOpaque(false); // Make the background transparent
        setBackground(null);
        setForeground (color);
        setHorizontalAlignment(alignment);
        // JLabel label = new JLabel(text);
        // label.setFont(font);
        // label.setForeground(color);
        // label.setHorizontalAlignment(alignment);
        // label.setOpaque(false); // Make the background transparent
        // label.setBounds(50, 30, 200, 30); // Set position and size
        // IABot.getInstancia(1).add(label); // Assuming IABot has a method to add components
    }
}

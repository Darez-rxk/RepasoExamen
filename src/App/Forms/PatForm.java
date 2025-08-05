package App.Forms;
import App.CustomerControl.PatButton;
import javax.swing.JButton;
import javax.swing.JFrame;
public class PatForm  extends JFrame{
    
    public PatForm(){
        setTitle("IABot form");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
    }
    public void initComponents(){
    PatButton patButton = new PatButton("Pat Button");
    patButton.setBounds(300, 300, 200, 50);
    patButton.addActionListener(e -> {
        // Action to perform when button is clicked
        System.out.println("Pat Button clicked!");
    });    
    JButton btnExample =new JButton("Example Button");
    btnExample.setBounds(50, 50, 200, 30);
    btnExample.addActionListener(e -> {
        // Action to perform when button is clicked
        System.out.println("Button clicked!");
    });
    add(patButton);
    add(btnExample); 
    setLayout(null); // Use null layout for absolute positioning
    setVisible(true);    
    }
    public void showForm()  {
        PatForm form = new PatForm();
        form.initComponents();
        form.setVisible(true);
    }
}

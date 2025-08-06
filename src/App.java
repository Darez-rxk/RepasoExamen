/*  -------------------------------------------------
 |  Copyright (c) 2k25 EPN-FIS. All Rights Reserved  |
 |  andresgalarraga7@outlook.es    Darez-rxk         |   
 |  pat_mic@hotmail.com            pat_mic           |       
 |  -------------------------------------------------|
 */
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;

import App.Forms.FormMain;
import BusinessLogic.Entities.Whiterun;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class App {
    public static void main(String[] args) {
        // Whiterun whiterun = new Whiterun();
        // whiterun.crearExobot();
        //new SplashScreenFor m();
        FlatLightLaf.setup();
        FlatLightLaf.supportsNativeWindowDecorations();
        try {
            UIManager.setLookAndFeel(new FlatCarbonIJTheme());
            }catch (UnsupportedLookAndFeelException e){
                e.printStackTrace();
            }
        FormMain mainForm = new FormMain("Exobot - IABot");
        mainForm.setVisible(true);

        //------------------------------------
        //Prueba de IABot 
        // IABot iaBot = IABot.getInstancia(1);
        // Exobot exobot = new Exobot(iaBot);
        // --------------------------------------
        // Tomar los datos de IABot, con sus metodos y el metodo por default
        // IABot iaBot = IABot.getInstancia();
        // System.out.println("IABot Version: " + IABot.getVersion());
        // IABot iaBot2 = IABot.getInstancia();
        // System.out.println("IABot2 Version: " + IABot.getVersion());
        // IABot iaBot3 = IABot.getInstancia(1);
        // System.out.println("IABot3 Version: " + IABot.getVersion());
        

    //     // Construccion por Bussiness Logic Factory, se hace asi por las relgas de arquitectura n tier
    
    //     BLFactory<DTOIABot> blfIABot = new BLFactory<>(DAOIABot::new);
    // BLFactory<DTOPersonaTipo> blfPersonaTipo = new BLFactory<>(DAOPersonaTipo::new);
    // // DAOIABot iaBotDAO = new DAOIABot();
    //      System.out.println("--------------------------------------------------");
    //      DTOIABot iaBot = new DTOIABot(3, "20x", null,null,null);
    //      blfIABot.upd(iaBot);
        
    // // DAOPersonaTipo personaTipoDAO = new DAOPersonaTipo();
    //      for (DTOPersonaTipo pt : blfPersonaTipo.getAll()) {
    //         System.out.println(pt.toString());
    //         System.out.println("--------------------------------------------------");
    //          }

    //      System.out.println("--------------------------------------------------");

   
    //     for (DTOIABot d : blfIABot.getAll()) {
    //         System.out.println(d.toString());
    //         System.out.println("--------------------------------------------------");
    //     }
    
             }
}
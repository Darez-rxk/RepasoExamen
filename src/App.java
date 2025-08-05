
import App.Forms.FormMain;
import BusinessLogic.Entities.Whiterun;

public class App {
    public static void main(String[] args) throws Exception {
        Whiterun whiterun = new Whiterun();
        whiterun.crearExobot();
        //new SplashScreenFor m();
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
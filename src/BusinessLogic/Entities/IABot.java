/*  -------------------------------------------------
 |  Copyright (c) 2k25 EPN-FIS. All Rights Reserved  |
 |  andresgalarraga7@outlook.es    Darez-rxk         |   
 |  pat_mic@hotmail.com            pat_mic           |       
 |  -------------------------------------------------|
 */

package BusinessLogic.Entities;


import BusinessLogic.BLFactory;
import BusinessLogic.Entities.Exo.Exobot;
import DataAccess.DAO.DAOIABot;
import DataAccess.DTO.DTOIABot;
import java.util.List;

public class IABot {
    private static  BLFactory<DTOIABot> blfIABot = new BLFactory<>(DAOIABot::new);
    private static IABot instancia;
    private static  String Version;

    private IABot() {
        // Constructor privado para evitar instanciación externa
    }

    protected IABot(IABot iABot) {
        if (iABot != null)
            
            instancia = iABot;
    }
    public static IABot getInstancia( ) throws Exception {

        if (instancia == null) {
            instancia = new IABot();
            IABot.setVersion("tmp 0.0"); 
        }
        return instancia;
    }
    public static IABot getInstancia(int idIABot) throws Exception {
        BLFactory<DTOIABot> blfIABot = new BLFactory<>(DAOIABot::new);
        String Version= blfIABot.getById(idIABot).getVersion();
        if (Version != null) {
            getInstancia();
            IABot.setVersion(Version); 
            return instancia;
        }
        return instancia;
    }
    public static String getVersion() {
        return Version;
    }
    public static void setVersion(String version) {
        IABot.Version = version.toUpperCase();
    }
    public List<Exobot> getExobots() {
        return null;
       // BLFactory<DTOExobot> blfIABot = new BLFactory<>(DAOExobot::new);
        //return blfIABot.getAll();
    }
}

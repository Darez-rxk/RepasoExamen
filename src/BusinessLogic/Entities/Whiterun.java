package BusinessLogic.Entities;


import DataAccess.DAO.DAOExaBot;
import DataAccess.DTO.DTOExaBot;
import java.util.ArrayList;
import java.util.List;

public class Whiterun {
    private int idIABot =1;
    public static IABot IABot;
    public List<DTOExaBot> lstExobot;

    public Whiterun() throws Exception {
        
        IABot     = IABot.getInstancia(1);
        lstExobot = new ArrayList<>();
    }

    public void crearExobot()throws Exception {
        DAOExaBot daoExaBot = new DAOExaBot();

        System.out.println("Creando un nuevo Exobot en Whiterun...");

        if (IABot == null) {
            throw new IllegalStateException(" xd xd IABot no está inicializado.");
        }
            lstExobot = daoExaBot.readAll(idIABot);
            for (DTOExaBot dtoExaBot : lstExobot) {
                System.out.println(dtoExaBot.toString());
            }
    }
}

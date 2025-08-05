package BusinessLogic.Exo;

import BusinessLogic.Entities.IABot;

public class Exobot extends IABot {
    private ExoFuentePoder         exoFuentePoder    ;
    private ExoTurboReactor        exoTurboReactor   ;
    private ExoBrazoDerecho        exoBrazoDerecho   ;
    private ExoBrazoIzquierdo      exoBrazoIzquierdo ;
    private ExoPierna              exoPiernaDerecha  ;
    private ExoPierna              exoPiernaIzquierda;
    public Exobot(IABot iABot) {
        super(iABot);
        exoTurboReactor          =new ExoTurboReactor   ();
        exoBrazoDerecho          =new ExoBrazoDerecho   ();
        exoBrazoIzquierdo        =new ExoBrazoIzquierdo ();
        exoPiernaDerecha         =new ExoPierna         ();
        exoPiernaIzquierda       =new ExoPierna         ();
    }

    public void ensamblar(ExoFuentePoder e){
        this.exoFuentePoder = e;
    }


    
    @Override
    public String toString() {
        return "Exobot Version: " + IABot.getVersion();
    }

}

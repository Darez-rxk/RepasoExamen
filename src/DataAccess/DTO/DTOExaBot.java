package DataAccess.DTO;

public class DTOExaBot {
    private Integer IdExaBot;
    private Integer IdIABot;
    private String Serie;
    private String Estado;
    private String FechaCreacion;
    private String FechaModifica;

    public DTOExaBot() {}

    public DTOExaBot(Integer idExaBot, Integer idIABot, String serie, String estado, String fechaCreacion, String fechaModifica) {
        this.IdExaBot = idExaBot;
        this.IdIABot = idIABot;
        this.Serie = serie;
        this.Estado = estado;
        this.FechaCreacion = fechaCreacion;
        this.FechaModifica = fechaModifica;
    }

    public Integer getIdExaBot() {
        return IdExaBot;
    }

    public void setIdExaBot(Integer idExaBot) {
        IdExaBot = idExaBot;
    }

    public Integer getIdIABot() {
        return IdIABot;
    }

    public void setIdIABot(Integer idIABot) {
        IdIABot = idIABot;
    }

    public String getSerie() {
        return Serie;
    }

    public void setSerie(String serie) {
        Serie = serie;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        FechaCreacion = fechaCreacion;
    }

    public String getFechaModifica() {
        return FechaModifica;
    }

    public void setFechaModifica(String fechaModifica) {
        FechaModifica = fechaModifica;
    }

    @Override
    public String toString() {
        return "[+] DTOExaBot\n"
             + " - IdExaBot: " + IdExaBot + "\n"
             + " - IdIABot: " + IdIABot + "\n"
             + " - Serie: " + Serie + "\n"
             + " - Estado: " + Estado + "\n"
             + " - FechaCreacion: " + FechaCreacion + "\n"
             + " - FechaModifica: " + FechaModifica;
    }
}

package DataAccess.DTO;

public class DTOIABot {
    private Integer IdIABot      ;
    private String  Version      ;   
    private String  Estado       ;   
    private String  FechaCreacion;
    private String  FechaModifica;
    public DTOIABot(Integer idIABot, String version, String estado, String fechaCreacion, String fechaModifica) {
        IdIABot = idIABot;
        Version = version;
        Estado = estado;
        FechaCreacion = fechaCreacion;
        FechaModifica = fechaModifica;
    }
    public DTOIABot() {   }
    


    public Integer getIdIABot() {
        return IdIABot;
    }
    public void setIdIABot(Integer idIABot) {
        IdIABot = idIABot;
    }
    public String getVersion() {
        return Version;
    }
    public void setVersion(String version) {
        Version = version;
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
    public String getFechaModificacion() {
        return FechaModifica;
    }
    public void setFechaModificacion(String fechaModificacion) {
        FechaModifica = fechaModificacion;
    }
    @Override
    public String toString() {
        return " [+] IABotDTO"
                + " \n -   IdIABot=" + getIdIABot() 
                + ",\n -   Version=" + getVersion()
                + ",\n -   Estado=" + getEstado()
                + ",\n -   FechaCreacion=" + getFechaCreacion() 
                + ",\n -   FechaModificacion=" + getFechaModificacion() ;
    }
}
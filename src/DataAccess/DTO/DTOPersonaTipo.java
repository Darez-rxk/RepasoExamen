package DataAccess.DTO;

public class DTOPersonaTipo {
    private Integer IdPersonaTipo;
    private String Tipo;
    private String Estado;
    private String FechaCreacion;
    private String FechaModificacion;
    public DTOPersonaTipo(String tipo){
        IdPersonaTipo = 0;
        Tipo = tipo;
        Estado = "A";
        FechaCreacion = "";
        FechaModificacion = "";
    }
    public DTOPersonaTipo(Integer idPersonaTipo,
                           String tipo,
                           String estado, 
                           String fechaCreacion,
                           String fechaModificacion) 
    {
        IdPersonaTipo = idPersonaTipo;
        Tipo = tipo;
        Estado = estado;
        FechaCreacion = fechaCreacion;
        FechaModificacion = fechaModificacion;
    }
    public DTOPersonaTipo() {
    }
    
    public Integer getIdPersonaTipo() {
        return IdPersonaTipo;
    }
    public void setIdPersonaTipo(Integer idPersonaTipo) {
        IdPersonaTipo = idPersonaTipo;
    }
    public String getTipo() {
        return Tipo;
    }
    public void setTipo(String tipo) {
        Tipo = tipo;
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
        return FechaModificacion;
    }
    public void setFechaModificacion(String fechaModificacion) {
        FechaModificacion = fechaModificacion;
    }
    @Override
    public String toString() {
        return " [+] PersonaTipoDTO"
                + " \n -   IdPersonaTipo=" + getIdPersonaTipo() 
                + ",\n -   tipo=" + getTipo()
                + ",\n -   Estado=" + getEstado()
                + ",\n -   FechaCreacion=" + getFechaCreacion() 
                + ",\n -   FechaModificacion=" + getFechaModificacion() ;
    }

}
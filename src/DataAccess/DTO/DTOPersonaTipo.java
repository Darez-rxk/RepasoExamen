package DataAccess.DTO;

public class DTOPersonaTipo {
    private Integer IdPersonaTipo;
    private String tipo;
    private String Estado;
    private String FechaCreacion;
    private String FechaModificacion;
    public DTOPersonaTipo(Integer idPersonaTipo, String tipo, String estado, String fechaCreacion,
            String fechaModificacion) {
        IdPersonaTipo = idPersonaTipo;
        this.tipo = tipo;
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
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
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
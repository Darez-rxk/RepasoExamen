
package DataAccess.DTO;

public class DTOPersona {
    private Integer IdPersona;
    private Integer IdPersonaTipo;
    private String Cedula;
    private String Nombre;
    private String Estado;
    private String FechaCreacion;
    private String FechaModifica;

    public DTOPersona() {}

    public DTOPersona(Integer idPersona, Integer idPersonaTipo, String cedula, String nombre,
                      String estado, String fechaCreacion, String fechaModifica) {
        this.IdPersona = idPersona;
        this.IdPersonaTipo = idPersonaTipo;
        this.Cedula = cedula;
        this.Nombre = nombre;
        this.Estado = estado;
        this.FechaCreacion = fechaCreacion;
        this.FechaModifica = fechaModifica;
    }

    public Integer getIdPersona() {
        return IdPersona;
    }

    public void setIdPersona(Integer idPersona) {
        IdPersona = idPersona;
    }

    public Integer getIdPersonaTipo() {
        return IdPersonaTipo;
    }

    public void setIdPersonaTipo(Integer idPersonaTipo) {
        IdPersonaTipo = idPersonaTipo;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String cedula) {
        Cedula = cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
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
        return "[+] DTOPersona\n"
             + " - IdPersona: " + IdPersona + "\n"
             + " - IdPersonaTipo: " + IdPersonaTipo + "\n"
             + " - Cedula: " + Cedula + "\n"
             + " - Nombre: " + Nombre + "\n"
             + " - Estado: " + Estado + "\n"
             + " - FechaCreacion: " + FechaCreacion + "\n"
             + " - FechaModifica: " + FechaModifica;
    }
}
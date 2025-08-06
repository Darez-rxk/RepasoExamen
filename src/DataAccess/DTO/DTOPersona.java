/*  -------------------------------------------------
 |  Copyright (c) 2k25 EPN-FIS. All Rights Reserved  |
 |  andresgalarraga7@outlook.es    Darez-rxk         |   
 |  pat_mic@hotmail.com            pat_mic           |       
 |  -------------------------------------------------|
 */
package DataAccess.DTO;

public class DTOPersona {
    private Integer IdPersona;
    private Integer IdPersonaTipo;
    private String Cedula;
    private String Nombre;
    private String Idioma;
    private String Estado;
    private String FechaCreacion;
    private String FechaModifica;
//Constuctor por defecto
    public DTOPersona() {}
//Constructor para crear el objeto con los atributos necesarios 
public DTOPersona(int idPersona, int idPersonaTipo, String cedula, String nombre, String idioma, String string3, String string4){
        IdPersona     = idPersona;
        IdPersonaTipo = idPersonaTipo;
        Cedula        = cedula;
        Nombre        = nombre;
        Idioma        = idioma;
        Estado        = "A";
        FechaCreacion = " ";
        FechaModifica = " ";
}
//Constructor para conectar con la base de datos, para hacer el CRUD
    public DTOPersona(Integer idPersona, Integer idPersonaTipo, String cedula, String nombre,
                      String idioma, String fechaCreacion, String fechaModifica) {
        IdPersona     = idPersona;
        IdPersonaTipo = idPersonaTipo;
        Cedula        = cedula;
        Nombre        = nombre;
        
        Idioma        = idioma;
        FechaCreacion = fechaCreacion;
        FechaModifica = fechaModifica;
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
             + " - Idioma: " + Idioma + "\n"
             + " - Estado: " + Estado + "\n"
             + " - FechaCreacion: " + FechaCreacion + "\n"
             + " - FechaModifica: " + FechaModifica;
    }

    public String getIdioma() {
        return Idioma;
    }

    public void setIdioma(String idioma) {
        Idioma = idioma;
    }
}
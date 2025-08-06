package BusinessLogic.Entities.Personas;

import BusinessLogic.BLFactory;
import DataAccess.DAO.DAOPersona;
import DataAccess.DTO.DTOPersona;
import java.util.List;

public abstract  class Persona {
    //Atributos
    private static  BLFactory<DTOPersona> blfPersona = new BLFactory<>(DAOPersona::new);
    public DTOPersona dto=  null;
    private DAOPersona daoPersona;
    public Persona (){
        
    }
    //Voy llenando los datos de persona, aqui tambien debo ejecutar el CRUD
 
    public List<DTOPersona> getAll() throws Exception {
        return daoPersona.readAll();

    }
    public DTOPersona getById(Integer id) throws Exception {
        return daoPersona.readBy(id);
    }
    public boolean add(DTOPersona oT) throws Exception {
        return daoPersona.create(oT);
    }
    public boolean upd(DTOPersona oT) throws Exception {
        return daoPersona.update(oT);
    }
    public boolean del(Integer id) throws Exception {
        return daoPersona.delete(id);
    }
    public Integer getMaxReg() throws Exception {
        return daoPersona.readAll().size();
    }
   

}

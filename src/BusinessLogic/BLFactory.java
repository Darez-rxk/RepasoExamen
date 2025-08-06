package BusinessLogic;

import DataAccess.DTO.IDAO;
import java.util.List;
import java.util.function.Supplier;
public class BLFactory <T > {
    private final IDAO<T> oDAO;
    //Constructor que usa un Supplier para crear la instancia de T
    //DAOPersonaTipo oDAOPersonaTipo= new DAOPersonaTipo();
    public BLFactory(Supplier<IDAO<T>> daoSupplier) {
        this.oDAO = daoSupplier.get();
    }
    public List<T> getAll() throws Exception {
        return oDAO.readAll();

    }
    public T getById(Integer id) throws Exception {
        return oDAO.readBy(id);
    }
    public boolean add(T oT) throws Exception {
        return oDAO.create(oT);
    }
    public boolean upd(T oT) throws Exception {
        return oDAO.update(oT);
    }
    public boolean del(Integer id) throws Exception {
        return oDAO.delete(id);
    }
    public Integer getMaxReg() throws Exception {
        return oDAO.readAll().size();
    }
   
}

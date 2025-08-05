package DataAccess.DTO;

import java.util.List;

public interface IDAO <T> { //Se hace obligarotio implementar los metodos de CRUD en los DAO
    T       readBy(Integer id) throws Exception;
    List<T> readAll( Integer idIABot) throws Exception; 
    boolean create(T entity) throws Exception;
    boolean update(T entity) throws Exception;
    boolean delete(Integer id) throws Exception;

}

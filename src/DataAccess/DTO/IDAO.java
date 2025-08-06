/*  -------------------------------------------------
 |  Copyright (c) 2k25 EPN-FIS. All Rights Reserved  |
 |  andresgalarraga7@outlook.es    Darez-rxk         |   
 |  pat_mic@hotmail.com            pat_mic           |       
 |  -------------------------------------------------|
 */
package DataAccess.DTO;

import java.util.List;

public interface IDAO <T> { //Se hace obligarotio implementar los metodos de CRUD en los DAO
    T       readBy(Integer id) throws Exception;
    List<T> readAll( ) throws Exception; 
    boolean create(T entity) throws Exception;
    boolean update(T entity) throws Exception;
    boolean delete(Integer id) throws Exception;
    Integer getMaxReg() throws Exception; //Para obtener el maximo de registros
}

package DataAccess.DAO;

import DataAccess.DTO.DTOPersonaTipo;
import DataAccess.DTO.DataHelperSQLite;
import DataAccess.DTO.IDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class DAOPersonaTipo extends DataHelperSQLite implements IDAO<DTOPersonaTipo> {


    /**
     * Método para leer un tipo de persona por su ID.
     * @param id Identificador del tipo de persona.
     * @return Un objeto TipoPersonaDTO con los datos del tipo de persona.
     * @throws Exception Si ocurre un error al acceder a la base de datos.
     */


    public DTOPersonaTipo readBy(Integer id) throws Exception {
    DTOPersonaTipo dto = new DTOPersonaTipo();

    String query = "SELECT IdPersonaTipo, Nombre, Estado, FechaCreacion,FechaModifica "
                 + "FROM PersonaTipo "
                 + "WHERE Estado = 'A' AND IdPersonaTipo = " + id.toString();

    try {
        Connection conn = openConnection();             // conectar a la DB
        Statement stmt = conn.createStatement();        // preparar consulta
        ResultSet rs = stmt.executeQuery(query);        // ejecutar SELECT

        while (rs.next()) {
            dto = new DTOPersonaTipo(
                rs.getInt(1),    // IdPersonaTipo
                rs.getString(2), // Nombre
                rs.getString(3), // Estado
                rs.getString(4),  // FechaCreacion
                rs.getString(5)   // FechaModificacion
            );
        }

    } catch (SQLException e) {
        throw e; // Podrías lanzar una excepción personalizada aquí
    }

    return dto;
}

    @Override
    public List<DTOPersonaTipo> readAll() throws Exception {
        List<DTOPersonaTipo> list = new ArrayList<>();
        String query = "SELECT IdPersonaTipo,"
                    +"Tipo," 
                    +"Estado,"
                    +"FechaCreacion,"
                    +"FechaModifica "
                    + "FROM PersonaTipo "
                    + "WHERE Estado = 'A'";
        try {
            Connection conn = openConnection(); // Conectar a la base de datos
            Statement stmt = conn.createStatement(); // Preparar la consulta
            ResultSet rs = stmt.executeQuery(query); // Ejecutar la consulta
            while (rs.next()) {
                DTOPersonaTipo dto = new DTOPersonaTipo(
                    rs.getInt(1),    // IdPersonaTipo
                    rs.getString(2), // Nombre
                    rs.getString(3), // Estado
                    rs.getString(4), // FechaCreacion
                    rs.getString(5)  // FechaModificacion
                );
                list.add(dto); // Añadir el DTO a la lista
            }
        } catch (SQLException e) {
            throw e; // Podrías lanzar una excepción personalizada aquí
        }
        return list; // Devolver la lista de tipos de persona
    }

    @Override
    public boolean create(DTOPersonaTipo entity) throws Exception {
        String query = "INSERT INTO PersonaTipo (Tipo) VALUES (?)"; 
        try {
            Connection conn = openConnection(); // Conectar a la base de datos
            PreparedStatement pstmt = conn.prepareStatement(query); // Preparar la consulta{
            pstmt.setString(1, entity.getTipo());
            pstmt.executeUpdate();
            return true; // Retorna true si se insertó al menos una fila
        } catch (SQLException e) {
            throw e; // Podrías lanzar una excepción personalizada aquí
        }
    }

    @Override
    public boolean update(DTOPersonaTipo entity) throws Exception {
        // Implementación del método update
        String query = "UPDATE PersonaTipo SET "
                + "Tipo = ?, "
                + "FechaModifica = ?, "
                + "WHERE IdPersonaTipo = ?"; 
        try {
            Connection conn = openConnection(); // Conectar a la base de datos
            PreparedStatement pstmt = conn.prepareStatement(query); // Preparar la consulta
            pstmt.setString(1, entity.getTipo());
            pstmt.setString(2, getDataTimeNow()); // Fecha de modificación actual
            pstmt.setInt(3, entity.getIdPersonaTipo());
            pstmt.executeUpdate();
            return true; // Retorna true si se actualizó al menos una fila
        } catch (SQLException e) {
            throw e; // Podrías lanzar una excepción personalizada aquí
        }
        
    }

    @Override
    public boolean delete(Integer id) throws Exception {

        String query= "UPDATE PersonaTipo SET Estado = ?, FechaModifica = ? WHERE IdPersonaTipo = ?";
        try {
            Connection conn = openConnection(); // Conectar a la base de datos
            PreparedStatement pstmt = conn.prepareStatement(query); // Preparar la consulta
            pstmt.setString(1, "X"); // Establecer el ID del tipo de persona a eliminar
            pstmt.setString(2,getDataTimeNow() ); // Establecer el ID del tipo de persona a eliminar
            pstmt.setInt(3, id); // Establecer el ID del tipo de persona a eliminar
            pstmt.executeUpdate(); // Ejecutar la consulta
            return true; // Retorna true si se eliminó al menos una fila
        } catch (SQLException e) {
            throw e; // Podrías lanzar una excepción personalizada aquí
        }
        
    }

   
}

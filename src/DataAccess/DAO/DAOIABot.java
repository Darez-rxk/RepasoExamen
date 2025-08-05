package DataAccess.DAO;

import DataAccess.DTO.DTOIABot;
import DataAccess.DTO.DataHelperSQLite;
import DataAccess.DTO.IDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOIABot extends DataHelperSQLite implements IDAO<DTOIABot> {

    public DAOIABot() {
        // Constructor por defecto
    }

@Override
public DTOIABot readBy(Integer id) throws Exception {
    DTOIABot dto = null;

    String query = "SELECT IdIABot, Version, Estado, FechaCreacion, FechaModifica "
                 + "FROM IABot WHERE Estado = 'A' AND IdIABot = ?";

    try (Connection conn = openConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            dto = new DTOIABot(
                rs.getInt("IdIABot"),
                rs.getString("Version"),
                rs.getString("Estado"),
                rs.getString("FechaCreacion"),
                rs.getString("FechaModifica")
            );
        }

    } catch (SQLException e) {
        throw e;
    }

    return dto;
}

    //@Override
    public List<DTOIABot> readAll() throws Exception {
        DTOIABot dto;
        List<DTOIABot> list = new ArrayList<>();
        String query =   "SELECT IdIABot"
                         +", Version"
                         +", Estado"
                         +", FechaCreacion"
                         +", FechaModifica "
                         +" FROM IABot " 
                         +" WHERE Estado = 'A'"; // Solo registros activos
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                dto = new DTOIABot(
                    rs.getInt(1), // IdIABot
                    rs.getString(2), // Version
                    rs.getString(3),  // Estado   
                    rs.getString(4),// FechaCreacion
                    rs.getString(5)); // FechaModificacion
                // Añadir el DTO a la lista
                list.add(dto); 
            }
        } catch (SQLException e) {
            throw e;
        }
        return list; // Placeholder, implement actual logic
    }

    @Override
    public boolean create(DTOIABot entity) throws Exception {
        String query = "INSERT INTO IABot (Version) VALUES (?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getVersion());
            pstmt.executeUpdate();
            return true; // Si la inserción fue exitosa
        } catch (SQLException e) {
            throw e;
        }

        
    }

    @Override
    public boolean update(DTOIABot entity) throws Exception {
        String query = "UPDATE IABot SET Version = ?, FechaModifica=? WHERE IdIABot = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getVersion());
            pstmt.setString(2, getDataTimeNow());
            pstmt.setInt(3, entity.getIdIABot());
            pstmt.executeUpdate();
            return true; // Si la actualización fue exitosa
        } catch (SQLException e) {
            throw e;
            }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
    String query= "UPDATE IABotDAO SET Estado = ?, FechaModifica = ? WHERE IdIABot = ?";
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

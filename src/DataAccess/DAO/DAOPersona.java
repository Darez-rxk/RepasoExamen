
package DataAccess.DAO;

import DataAccess.DTO.DTOPersona;
import DataAccess.DTO.DataHelperSQLite;
import DataAccess.DTO.IDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOPersona extends DataHelperSQLite implements IDAO<DTOPersona> {

    @Override
    public DTOPersona readBy(Integer id) throws Exception {
        DTOPersona dto = new DTOPersona();
        String query = "SELECT IdPersona, IdPersonaTipo, Cedula, Nombre, Estado, FechaCreacion, FechaModifica "
                     + "FROM Persona "
                     + "WHERE Estado = 'A' AND IdPersona = " + id.toString();
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                dto = new DTOPersona(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7)
                );
            }
        } catch (SQLException e) {
            throw e;
        }
        return dto;
    }

    @Override
    public List<DTOPersona> readAll() throws Exception {
        List<DTOPersona> list = new ArrayList<>();
        String query = "SELECT IdPersona, IdPersonaTipo, Cedula, Nombre, Estado, FechaCreacion, FechaModifica "
                     + "FROM Persona "
                     + "WHERE Estado = 'A'";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                DTOPersona dto = new DTOPersona(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7)
                );
                list.add(dto);
            }
        } catch (SQLException e) {
            throw e;
        }
        return list;
    }

    @Override
    public boolean create(DTOPersona entity) throws Exception {
        String query = "INSERT INTO Persona (IdPersonaTipo, Cedula, Nombre) VALUES (?, ?, ?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdPersonaTipo());
            pstmt.setString(2, entity.getCedula());
            pstmt.setString(3, entity.getNombre());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean update(DTOPersona entity) throws Exception {
        String query = "UPDATE Persona SET "
                     + "IdPersonaTipo = ?, "
                     + "Cedula = ?, "
                     + "Nombre = ?, "
                     + "FechaModifica = ? "
                     + "WHERE IdPersona = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdPersonaTipo());
            pstmt.setString(2, entity.getCedula());
            pstmt.setString(3, entity.getNombre());
            pstmt.setString(4, getDataTimeNow());
            pstmt.setInt(5, entity.getIdPersona());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE Persona SET Estado = ?, FechaModifica = ? WHERE IdPersona = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setString(2, getDataTimeNow());
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public Integer getMaxReg() throws Exception {
        String query = "SELECT COUNT(*) FROM Persona WHERE Estado='A'";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw e;
        }
        return 0;
    }
}
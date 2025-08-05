package DataAccess.DAO;

import DataAccess.DTO.DTOExaBot;
import DataAccess.DTO.DataHelperSQLite;
import DataAccess.DTO.IDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOExaBot extends DataHelperSQLite implements IDAO<DTOExaBot> {

    @Override
    public DTOExaBot readBy(Integer id) throws Exception {
        DTOExaBot dto = null;
        String query = "SELECT IdExaBot, IdIABot, Serie, Estado, FechaCreacion, FechaModifica "
                     + "FROM ExaBot WHERE Estado = 'A' AND IdExaBot = ?";

        try (Connection conn = openConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                dto = new DTOExaBot(
                    rs.getInt("IdExaBot"),
                    rs.getInt("IdIABot"),
                    rs.getString("Serie"),
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
    public List<DTOExaBot> readAll() throws Exception {
        return null;
        // List<DTOExaBot> lista = new ArrayList<>();
        // String query = "SELECT IdExaBot, IdIABot, Serie, Estado, FechaCreacion, FechaModifica "
        //              + "FROM ExaBot WHERE Estado = 'A'";

        // try (Connection conn = openConnection();
        //      PreparedStatement stmt = conn.prepareStatement(query);
        //      ResultSet rs = stmt.executeQuery()) {

        //     while (rs.next()) {
        //         DTOExaBot dto = new DTOExaBot(
        //             rs.getInt("IdExaBot"),
        //             rs.getInt("IdIABot"),
        //             rs.getString("Serie"),
        //             rs.getString("Estado"),
        //             rs.getString("FechaCreacion"),
        //             rs.getString("FechaModifica")
        //         );
        //         lista.add(dto);
        //     }

        // } catch (SQLException e) {
        //     throw e;
        // }

        // return lista;
    }

    
    public List<DTOExaBot> readAll(Integer idIABot) throws Exception {
        List<DTOExaBot> lista = new ArrayList<>();
        String query = "SELECT IdExaBot, IdIABot, Serie, Estado, FechaCreacion, FechaModifica "
                     + "FROM ExaBot WHERE Estado = 'A' AND IdIABot = ?";

        try (Connection conn = openConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idIABot);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                DTOExaBot dto = new DTOExaBot(
                    rs.getInt("IdExaBot"),
                    rs.getInt("IdIABot"),
                    rs.getString("Serie"),
                    rs.getString("Estado"),
                    rs.getString("FechaCreacion"),
                    rs.getString("FechaModifica")
                );
                lista.add(dto);
            }

        } catch (SQLException e) {
            throw e;
        }

        return lista;
    }

    @Override
    public boolean create(DTOExaBot dto) throws Exception {
        String query = "INSERT INTO ExaBot (IdIABot, Serie) VALUES (?, ?)";

        try (Connection conn = openConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, dto.getIdIABot());
            stmt.setString(2, dto.getSerie());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean update(DTOExaBot dto) throws Exception {
        String query = "UPDATE ExaBot SET Serie = ?, FechaModifica = ? WHERE IdExaBot = ?";

        try (Connection conn = openConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, dto.getSerie());
            stmt.setString(2, getDataTimeNow());
            stmt.setInt(3, dto.getIdExaBot());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE ExaBot SET Estado = 'X', FechaModifica = ? WHERE IdExaBot = ?";

        try (Connection conn = openConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, getDataTimeNow());
            stmt.setInt(2, id);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            throw e;
        }
    }
}

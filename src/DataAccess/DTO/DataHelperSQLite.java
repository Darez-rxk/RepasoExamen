package DataAccess.DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataHelperSQLite {
    private static final String DBPathConnection = "jdbc:sqlite:db/EXOBOT.sqlite";
    private static Connection conn = null;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private LocalDateTime now = LocalDateTime.now();

    protected static synchronized Connection openConnection() throws Exception {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(DBPathConnection);
            }
        } catch (SQLException e) {
            throw e;
        }
        return conn;
    }

    protected static void closeConnection() throws Exception {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            throw e;
        }
    }
    protected String getDataTimeNow() {
        return dtf.format(now).toString();
    }
}
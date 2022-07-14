package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {


    public Connection recuperarConexao() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/bluesupermarket?useTimezone=true&serverTimezone=UTC", "root", "Brita1234@");
    }


}
package game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD{
	public static Connection conexao;

	public static Connection createConnection() throws SQLException{
		String host = "jdbc:mysql://localhost:3306/game";
		String user = "root";
		String password = "";

		conexao = null;
		conexao = DriverManager.getConnection(host, user, password);

		return conexao;
	}
}

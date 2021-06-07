package game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD{

	public static Connection conexao;

	public static Connection createConnection() throws SQLException{
		String url = "jdbc:mysql://localhost:3306/game"; //Nome da base de dados
		String user = "root"; //nome do usuário do MySQL
		String password = ""; //senha do MySQL

		conexao = null;
		conexao = DriverManager.getConnection(url, user, password);

		return conexao;
	}
}
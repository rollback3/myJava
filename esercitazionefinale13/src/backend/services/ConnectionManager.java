package backend.services;

import java.sql.Connection;
import java.sql.SQLException;
import com.mysql.cj.jdbc.MysqlDataSource;

public class ConnectionManager {

	private static java.sql.Connection con;

	protected static Connection getConnection() throws SQLException {
		if (con == null) {
			MysqlDataSource dataSource = new MysqlDataSource();

			dataSource.setDatabaseName("gestionale");
			dataSource.setPortNumber(3306);
			dataSource.setServerName("localhost");
			dataSource.setUser("root");
			dataSource.setPassword("EnterInMySQL3");
			dataSource.setServerTimezone("UTC");
			dataSource.setUseSSL(false);
			

			con = dataSource.getConnection();
		}
		return con;

	}

}

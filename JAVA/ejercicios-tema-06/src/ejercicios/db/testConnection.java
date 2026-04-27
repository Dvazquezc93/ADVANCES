package ejercicios.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class testConnection {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String user = "programacion";
		String pass = "programacion";
		String url = "jdbc:oracle:thin:@//localhost:1521/XE";
		String driver = "oracle.jdbc.driver.OracleDriver";
		Class.forName(driver);

		Connection con = DriverManager.getConnection(url, user, pass);
		System.out.println(con);
		System.out.println("TODO OK!!!!");
		con.close();
		
	}

}

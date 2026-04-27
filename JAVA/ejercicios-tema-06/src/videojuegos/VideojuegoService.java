package videojuegos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VideojuegoService {
	private Connection openConnection() throws SQLException {
		String user = "programacion";
		String pass = "programacion";
		String url = "jdbc:oracle:thin:@//localhost:1521/XE";
		String driver = "oracle.jdbc.driver.OracleDriver";
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("El driver no esta bien configurado!!");
			throw new RuntimeException("El driver no esta bien configurado!!", e);
		}

		return DriverManager.getConnection(url, user, pass);
	}

	public void crear(Videojuego videojuego) throws VideojuegoException {
		System.out.println("Creando Videojuego..");
		// 1. Abrir conexión
		try (Connection con = openConnection()) {
			// 2. Escribir SQL
			String sql = "Insert into videojuegos values(?,?,?)";
			// 3. Crear PreparedStatement
			PreparedStatement statement = con.prepareStatement(sql);
			// 4. Dar Valores a los parámetros
			statement.setInt(1, videojuego.getId());
			statement.setString(2, videojuego.getNombre());
			statement.setBigDecimal(3, videojuego.getPrecio());
			// 5. Ejecutar
			statement.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new VideojuegoException("Error al insertar videojuego en BBDD",e);
		}
		System.out.println("Videojuego creado");
	}
}

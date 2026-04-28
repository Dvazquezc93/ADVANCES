package ejercicios.EjercicioR3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ejercicios.ejercicioR2.PlantaException;
import ejercicios.ejercicioR2.PlantaServiceException;

public class LibreriaService {
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
	public void insertarLibroNuevo(Libro libro) throws LibroException {
		try (Connection con = openConnection()){
			String sql = "insert into libros values(?,?,?,?)";
			// 3. Crear PreparedStatement
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, libro.getIsbn());
			statement.setString(2, libro.getTitulo());
			statement.setString(3, libro.getAutor());
			statement.setBigDecimal(4, libro.getPrecio());
			statement.execute();
		}catch (SQLException e) {
			e.printStackTrace();
			throw new LibroException("Error al insertar Libro en BBDD", e);
	}
}
	public Boolean actualizarPrecioLibroNuevo(Libro libro) throws PlantaException, PlantaServiceException {
		
		try (Connection con = openConnection()) {
			// 2. Escribir SQL
			String sql = "update Libros set precio= ? where isbn =? ";
			// 3. Crear PreparedStatement
			PreparedStatement statement = con.prepareStatement(sql);
			// 4. Dar Valores a los parámetros
			statement.setBigDecimal(1, libro.getPrecio());
			statement.setString(2, libro.getIsbn());
			return statement.executeUpdate() > 0;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PlantaException("Error al actualizar libro en BBDD", e);
		}

	}
}

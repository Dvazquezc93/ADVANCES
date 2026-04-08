package ejercicios.Ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class PersonaService {
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

	public Persona consultarPersonal(String dni) throws PersonaNotFoundException, PersonaException {
		try (Connection con = openConnection()) {
			// 2. Escribir SQL
			String sql = "select * from personas where dni =?";
			// 3. Crear PreparedStatement
			PreparedStatement statement = con.prepareStatement(sql);
			// 4. Dar Valores a los parámetros
			statement.setString(1, dni);
			;

			// 5. Ejecutar
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				Persona p = new Persona();
				p.setDni(dni);
				p.setNombre(rs.getString("nombre"));
				p.setApellidos(rs.getString("apellidos"));
				p.setFechaNacimiento(rs.getDate("Fecha_Nacimiento").toLocalDate());
				return p;
			} else {
				throw new PersonaNotFoundException("No existe persona con este dni " + dni);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersonaException("Error al consultar persona en BBDD", e);
		}

	}
}

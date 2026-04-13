
package ejercicios.Ejercicio1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

	public List<Persona> buscarPersonas(String filtro) throws PersonaNotFoundException, PersonaException {
		try (Connection con = openConnection()) {
			// 2. Escribir SQL
			String sql = "select * from personas where nombre like '%'||?||'%' or apellidos like '%'||?||'%'";
			// 3. Crear PreparedStatement
			PreparedStatement statement = con.prepareStatement(sql);
			// 4. Dar Valores a los parámetros
			statement.setString(1, filtro);
			statement.setString(2, filtro);
			List<Persona> lista = new ArrayList<>();
		
			// 5. Ejecutar
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Persona p = new Persona();
				p.setDni(rs.getString("dni"));
				p.setNombre(rs.getString("nombre"));
				p.setApellidos(rs.getString("apellidos"));
				p.setFechaNacimiento(rs.getDate("Fecha_Nacimiento").toLocalDate());
				lista.add(p);
			}
			if (!lista.isEmpty()) {
				return lista;
			} else {
				throw new PersonaNotFoundException("No existe persona que contenga en su nombre " + filtro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersonaException("Error al consultar persona en BBDD", e);
		}

	}
	public void insertarPersonas(String dni, String nombre, String apellidos, LocalDate fechaNacimiento) throws  PersonaException {
		System.out.println("Insertando persona...");
		try (Connection con = openConnection()) {
			// 2. Escribir SQL
			String sql = "insert into personas values(?,?,?,?)";
			// 3. Crear PreparedStatement
			PreparedStatement statement = con.prepareStatement(sql);
			// 4. Dar Valores a los parámetros
			statement.setString(1, dni);
			statement.setString(2, nombre);
			statement.setString(3,apellidos);
			statement.setDate(4, Date.valueOf(fechaNacimiento));
	
			 statement.execute();
			 System.out.println("Persona insertada...");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersonaException("Error al consultar persona en BBDD", e);
		}

	}
}

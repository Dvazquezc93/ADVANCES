
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

import oracle.sql.DATE;

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

	public void insertarPersona(Persona persona) throws PersonaException {
		System.out.println("Insertando persona...");
		try (Connection con = openConnection()) {
			// 2. Escribir SQL
			añadirPersona(persona, con);
			System.out.println("Persona insertada.");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersonaException("Error al insertar persona en BBDD", e);
		}

	}

	private void añadirPersona(Persona persona, Connection con) throws SQLException {
		String sql = "insert into personas values(?,?,?,?)";
		// 3. Crear PreparedStatement
		PreparedStatement statement = con.prepareStatement(sql);
		// 4. Dar Valores a los parámetros
		statement.setString(1, persona.getDni());
		statement.setString(2, persona.getNombre());
		statement.setString(3, persona.getApellidos());
		statement.setDate(4, Date.valueOf(persona.getFechaNacimiento()));

		statement.execute();
	}

	public void actualizarPersonas(Persona persona) throws PersonaException, PersonaNotFoundException {
		System.out.println("actulizando persona...");
		try (Connection con = openConnection()) {
			// 2. Escribir SQL
			String sql = "update personas set nombre=?, apellidos=?,fecha_Nacimiento =? where dni=? ";
			// 3. Crear PreparedStatement
			PreparedStatement statement = con.prepareStatement(sql);
			// 4. Dar Valores a los parámetros
			statement.setString(4, persona.getDni());
			statement.setString(1, persona.getNombre());
			statement.setString(2, persona.getApellidos());
			statement.setDate(3, Date.valueOf(persona.getFechaNacimiento()));

			Boolean up = statement.executeUpdate() > 0;
			if (!up) {
				throw new PersonaNotFoundException("Esas persona no esta dentro de la base de datos");

			}
			System.out.println("Persona actualizada");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersonaException("Error al actualizar persona en BBDD", e);
		}

	}

	public void borrarPersonas(String dni) throws PersonaException, PersonaNotFoundException {
		System.out.println("borrando persona...");
		try (Connection con = openConnection()) {
			// 2. Escribir SQL
			String sql = "delete from personas where dni =? ";
			// 3. Crear PreparedStatement
			PreparedStatement statement = con.prepareStatement(sql);
			// 4. Dar Valores a los parámetros
			statement.setString(1, dni);
			Boolean up = statement.executeUpdate() > 0;
			if (!up) {
				throw new PersonaNotFoundException("Esas persona no esta dentro de la base de datos");

			}
			System.out.println("Persona deleteada.");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersonaException("Error al deletear persona en BBDD", e);
		}

	}

	public void borrarPersonas(String dni,Connection con) throws PersonaException, PersonaNotFoundException {
		System.out.println("borrando persona...");
		try{
		  con = openConnection();
				  
			// 2. Escribir SQL
			String sql = "delete from personas where dni =? ";
			// 3. Crear PreparedStatement
			PreparedStatement statement = con.prepareStatement(sql);
			// 4. Dar Valores a los parámetros
			statement.setString(1, dni);
			Boolean up = statement.executeUpdate() > 0;
			if (!up) {
				throw new PersonaNotFoundException("Esas persona no esta dentro de la base de datos");

			}
			System.out.println("Persona deleteada.");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersonaException("Error al deletear persona en BBDD", e);
		}
		
	}

	public void insertarPersonas(List<Persona> lista) throws PersonaException {
		System.out.println("Insertando personas...");
		try (Connection con = openConnection()) {
			try {
				con.setAutoCommit(false);
				for (Persona persona : lista) {
					añadirPersona(persona, con);
				}
				con.commit();
				System.out.println("Personas insertadas.");
			} catch (SQLException e) {
				con.rollback();
				throw new PersonaException("Error al insertar las personas", e);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersonaException("Error al insertar persona en BBDD", e);
		}

	}

	public Integer borrarPersonasA() throws PersonaException, PersonaNotFoundException {
		Integer contador = 0;
		try (Connection con = openConnection()) {
			// 2. Escribir SQL

			List<Persona> lista = buscarPersonas("");
			try {
				con.setAutoCommit(false);
				for (Persona persona : lista) {
					if (persona.getFechaNacimiento().compareTo(LocalDate.now().minusYears(18)) < 0) {
						borrarPersonas(persona.getDni(), con);
						contador++;
					}
				}
				con.commit();
			} catch (SQLException e) {
				con.rollback();
				throw new PersonaException("Error al deletar las personas", e);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersonaException("Error al deletear persona en BBDD", e);
		}
		return contador;
	}
	public void borrarPersonasM() throws PersonaException, PersonaNotFoundException {
		System.out.println("borrando persona...");
		try (Connection con = openConnection()) {
			// 2. Escribir SQL
			
			String sql = "delete from personas where fecha_nacimiento <=? ";
			// 3. Crear PreparedStatement
			PreparedStatement statement = con.prepareStatement(sql);
			// 4. Dar Valores a los parámetros
			statement.setDate(1, Date.valueOf(LocalDate.now().minusYears(18)));
			Boolean up = statement.executeUpdate() > 0;
			if (!up) {
				throw new PersonaNotFoundException("Esas persona no esta dentro de la base de datos");

			}
			System.out.println("Persona deleteada.");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersonaException("Error al deletear persona en BBDD", e);
		}

	}
}

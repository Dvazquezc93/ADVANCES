package ejercicios.ejercicioR2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlantaService {
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

	private void insertarPlanta(Planta planta) throws PlantaException, PlantaAlturaException {
		if (!(planta.validarAltura())) {
			throw new PlantaAlturaException("La altura de la planta no es correcto");
		}
		System.out.println("Insertando planta...");
		try (Connection con = openConnection()) {
			String sql = "insert into plantas values(?,?,?,?,?)";
			// 3. Crear PreparedStatement
			PreparedStatement statement = con.prepareStatement(sql);
			// 4. Dar Valores a los parámetros
			statement.setLong(1, planta.getId());
			statement.setString(2, planta.getNombre());
			statement.setString(3, planta.getTipo());
			statement.setBigDecimal(4, planta.getAltura());
			statement.setDate(5, Date.valueOf(planta.getFechaPlantacion()));

			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PlantaException("Error al insertar Planta en BBDD", e);
		}
	}

	public void actualizarPlantasMedias() throws PlantaException, PlantaServiceException {
		System.out.println("actulizando plantas...");
		try (Connection con = openConnection()) {
			// 2. Escribir SQL
			String sql = "update plantas set tipo='Media Altura' where altura between '1' and 1.5' ";
			// 3. Crear PreparedStatement
			PreparedStatement statement = con.prepareStatement(sql);
			// 4. Dar Valores a los parámetros
			Boolean up = statement.executeUpdate() > 0;
			if (!up) {
				throw new PlantaServiceException("Esas plantas no esta dentro de la base de datos");

			}
			System.out.println("Plantas actualizada");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PlantaException("Error al insertar Planta en BBDD", e);
		}

	}

	public LocalDate actualizarFechaPlanta(Integer id, LocalDate fechaNueva)
			throws PlantaException, PlantaServiceException {
		System.out.println("actulizando plantas...");
		try (Connection con = openConnection()) {
			String sql = "select * from plantas where id=?";
			// 3. Crear PreparedStatement
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery();
			LocalDate fechaAnterior = LocalDate.now();
			if (rs.next()) {
				fechaAnterior = rs.getDate("Fecha_plantacion").toLocalDate();
			}else {
				throw new PlantaServiceException("No se encontró la planta  con id: " + id);

			}
			// 2. Escribir SQL
			sql = "update plantas set 'fecha_plantacion'= ? where id= ? ";
			// 3. Crear PreparedStatement
			statement = con.prepareStatement(sql);
			// 4. Dar Valores a los parámetros
			statement.setDate(1, Date.valueOf(LocalDate.now()));
			statement.setInt(2, id);
			Boolean up = statement.executeUpdate() > 0;
			if (!up) {
				throw new PlantaServiceException("No se encontró la planta  con id: " + id);

			}
			System.out.println("Plantas actualizada");
			return fechaAnterior;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PlantaException("Error al insertar Planta en BBDD", e);
		}

	}

	public Integer eliminarProductos(LocalDate fechaRecibida) throws PlantaException {
		System.out.println("borrando producto...");
		try (Connection con = openConnection()) {
			// 2. Escribir SQL
			String sql = "delete from plantas where id =? ";
			// 3. Crear PreparedStatement
			PreparedStatement statement = con.prepareStatement(sql);
			// 4. Dar Valores a los parámetros
			statement.setDate(1, Date.valueOf(fechaRecibida));
			return statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new PlantaException("Error al insertar producto en BBDD", e);
		}

	}
	public List<Planta> consultarPlantas(LocalDate fechaPlanta)  {
		try (Connection con = openConnection()) {
			// 2. Escribir SQL
			String sql = "select * from plantas";
			// 3. Crear PreparedStatement
			PreparedStatement statement = con.prepareStatement(sql);
			// 4. Dar Valores a los parámetros
			
			List<Planta>  lista = new ArrayList<>();
			// 5. Ejecutar
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Planta p = new Planta();
				p.setID(rs.getInteger("id"));
				p.setNombre(rs.getString("nombre"));
				p.setTipo(rs.getString("tipo"));
				p.setPrecio(rs.getInteger("precio"));
				p.setDisponible(rs.getInteger("disponible"));
				map.put(p.getId(), p);
			}
				return map;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PlantaException(("Error al comprobar productos en BBDD", e);
		}
}
}

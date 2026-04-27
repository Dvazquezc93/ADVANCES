package ejercicios.EjercicioFinalR1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductoService {
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

	private void insertarProducto(ProductoGourmet productogourmet, Connection con) throws SQLException {
		if (!(productogourmet.validarPrecio())) {
			throw new ProductoInvalidoException("El precio del producto no es correcto");
		}
		System.out.println("Insertando producto...");
		try (Connection con = openConnection()) {
			String sql = "insert into productos_gourmet values(?,?,?,?,?)";
			// 3. Crear PreparedStatement
			PreparedStatement statement = con.prepareStatement(sql);
			// 4. Dar Valores a los parámetros
			statement.setInteger(1, productogourmet.getId());
			statement.setString(2, productogourmet.getNombre());
			statement.setString(3, productogourmet.getTipo());
			statement.setBigDecimal(4, productogourmet.getPrecio());
			statement.setBoolean(5, productogourmet.getDisponible());

			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ProductoException("Error al insertar producto en BBDD", e);
		}
	}

	public void insertarProductos(List<ProductosGourmet> lista) throws PersonaException {
		System.out.println("Insertando productos...");
		try (Connection con = openConnection()) {
			try {
				con.setAutoCommit(false);
				for (ProductosGourmet producto : lista) {
					insertarProductos(producto, con);
				}
				con.commit();
				System.out.println("Personas insertadas.");
			} catch (Exception e) {
				con.rollback();
				e.printStackTrace();
				throw new ProductoException("Error al insertar producto en BBDD", e);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ProductoException("Error al insertar producto en BBDD", e);
		}

	}

	public List<PoductoGourmet> consultarTipoProductos(String tipo) throws PersonaNotFoundException, PersonaException {
		try (Connection con = openConnection()) {
			// 2. Escribir SQL
			String sql = "select * from productos_gourmet where tipo =?";
			// 3. Crear PreparedStatement
			PreparedStatement statement = con.prepareStatement(sql);
			// 4. Dar Valores a los parámetros
			statement.setString(1, tipo);
			List<PoductoGourmet> lista = new ArrayList<>();

			// 5. Ejecutar
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				ProductoGourmet p = new ProductoGourmet();
				p.setID(rs.getInteger("id"));
				p.setNombre(rs.getString("nombre"));
				p.setTipo(rs.getString("tipo"));
				p.setPrecio(rs.getInteger("precio"));
				p.setDisponibilidad(rs.getInteger("disponible"));
				lista.add(p);
			}
			if (!lista.isEmpty()) {
				return lista;
			} else {
				throw new ProductoNotFoundException("No existe producto que contenga ese tipo " + tipo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ProductoException("Error al insertar producto en BBDD", e);
		}

	}

	public void eliminarProductos(String id) throws PersonaException, PersonaNotFoundException {
		System.out.println("borrando producto...");
		try (Connection con = openConnection()) {
			// 2. Escribir SQL
			String sql = "delete from productos_gourmet where id =? ";
			// 3. Crear PreparedStatement
			PreparedStatement statement = con.prepareStatement(sql);
			// 4. Dar Valores a los parámetros
			statement.setString(1, id);
			Boolean up = statement.executeUpdate() > 0;
			if (!up) {
				throw new ProductoNotFoundException("No existe producto que contenga ese id " + id);

			}
			System.out.println("Producto deleteado.");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ProductoException("Error al insertar producto en BBDD", e);
		}

	}

	public Map<Integer,ProductoGourmet> consultarProductos(String tipo) throws PersonaNotFoundException, PersonaException {
		try (Connection con = openConnection()) {
			// 2. Escribir SQL
			String sql = "select * from productos_gourmet";
			// 3. Crear PreparedStatement
			PreparedStatement statement = con.prepareStatement(sql);
			// 4. Dar Valores a los parámetros
			Map<Integer,ProductoGourmet> map = new ArrayList<>();

			// 5. Ejecutar
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				ProductoGourmet p = new ProductoGourmet();
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
			throw new ProductoException("Error al insertar producto en BBDD", e);
		}
}
}

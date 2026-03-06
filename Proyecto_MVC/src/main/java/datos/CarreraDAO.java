/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

/**
 *
 * @author isaia
 */
import domain.Carrera;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class CarreraDAO {
    // Consulta para obtener todos los registros de la tabla carreras
    private static final String SQL_SELECT = "SELECT car_codigo, car_nombre, car_status FROM carreras";

    // Consulta para insertar una nueva carrera (el código es autogenerado)
    private static final String SQL_INSERT = "INSERT INTO carreras(car_nombre, car_status) VALUES(?, ?)";

    // Consulta para actualizar el nombre y status de una carrera según su código
    private static final String SQL_UPDATE = "UPDATE carreras SET car_nombre=?, car_status=? WHERE car_codigo=?";

    // Consulta para eliminar una carrera según su código
    private static final String SQL_DELETE = "DELETE FROM carreras WHERE car_codigo=?";

    // Consulta para buscar una carrera específica por su código
    private static final String SQL_QUERY = "SELECT car_codigo, car_nombre, car_status FROM carreras WHERE car_codigo=?";

    // Método que retorna una lista con todas las carreras registradas en la base de datos
    public List<Carrera> select() {
        Connection conn = null;          // Conexión a la base de datos
        PreparedStatement stmt = null;   // Sentencia SQL preparada
        ResultSet rs = null;             // Resultado de la consulta
        Carrera carrera = null;          // Objeto temporal para cada fila leída
        List<Carrera> carreras = new ArrayList<Carrera>(); // Lista que almacenará los resultados

        try {
            conn = ConexionCarreras.getConnection(); // Se obtiene la conexión
            stmt = conn.prepareStatement(SQL_SELECT); // Se prepara la consulta SELECT
            rs = stmt.executeQuery(); // Se ejecuta la consulta

            // Se recorre cada fila del resultado
            while (rs.next()) {
                int car_codigo = rs.getInt("car_codigo");       // Se lee el código de la carrera
                String car_nombre = rs.getString("car_nombre"); // Se lee el nombre de la carrera
                String car_status = rs.getString("car_status"); // Se lee el status de la carrera

                // Se crea un nuevo objeto Carrera y se asignan los valores leídos
                carrera = new Carrera(car_codigo, car_nombre, car_status);

                carreras.add(carrera); // Se agrega la carrera a la lista
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out); // Se imprime el error si ocurre una excepción SQL
        } finally {
            // Se cierran los recursos en orden inverso para liberar la conexión
            ConexionCarreras.close(rs);
            ConexionCarreras.close(stmt);
            ConexionCarreras.close(conn);
        }

        return carreras; // Se retorna la lista completa de carreras
    }

    // Método para insertar una nueva carrera en la base de datos
    // Retorna el número de filas afectadas (1 si fue exitoso, 0 si falló)
    public int insert(Carrera carrera) {
        Connection conn = null;        // Conexión a la base de datos
        PreparedStatement stmt = null; // Sentencia SQL preparada
        int rows = 0;                  // Contador de filas afectadas

        try {
            conn = ConexionCarreras.getConnection(); // Se obtiene la conexión
            stmt = conn.prepareStatement(SQL_INSERT); // Se prepara la consulta INSERT
            stmt.setString(1, carrera.getCar_nombre()); // Se asigna el nombre de la carrera
            stmt.setString(2, carrera.getCar_status()); // Se asigna el status de la carrera

            System.out.println("Ejecutando query: " + SQL_INSERT);
            rows = stmt.executeUpdate(); // Se ejecuta la inserción
            System.out.println("Registros afectados: " + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out); // Se imprime el error si ocurre una excepción SQL
        } finally {
            // Se cierran los recursos para liberar la conexión
            ConexionCarreras.close(stmt);
            ConexionCarreras.close(conn);
        }

        return rows; // Se retorna el número de filas insertadas
    }

    // Método para actualizar los datos de una carrera existente en la base de datos
    // Retorna el número de filas afectadas (1 si fue exitoso, 0 si no encontró el registro)
    public int update(Carrera carrera) {
        Connection conn = null;        // Conexión a la base de datos
        PreparedStatement stmt = null; // Sentencia SQL preparada
        int rows = 0;                  // Contador de filas afectadas

        try {
            conn = ConexionCarreras.getConnection(); // Se obtiene la conexión
            stmt = conn.prepareStatement(SQL_UPDATE); // Se prepara la consulta UPDATE
            stmt.setString(1, carrera.getCar_nombre()); // Se asigna el nuevo nombre
            stmt.setString(2, carrera.getCar_status()); // Se asigna el nuevo status
            stmt.setInt(3, carrera.getCar_codigo());    // Se asigna el código para identificar el registro

            System.out.println("Ejecutando query: " + SQL_UPDATE);
            rows = stmt.executeUpdate(); // Se ejecuta la actualización
            System.out.println("Registros actualizados: " + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out); // Se imprime el error si ocurre una excepción SQL
        } finally {
            // Se cierran los recursos para liberar la conexión
            ConexionCarreras.close(stmt);
            ConexionCarreras.close(conn);
        }

        return rows; // Se retorna el número de filas actualizadas
    }

    // Método para eliminar una carrera de la base de datos según su código
    // Retorna el número de filas afectadas (1 si fue exitoso, 0 si no encontró el registro)
    public int delete(Carrera carrera) {
        Connection conn = null;        // Conexión a la base de datos
        PreparedStatement stmt = null; // Sentencia SQL preparada
        int rows = 0;                  // Contador de filas afectadas

        try {
            conn = ConexionCarreras.getConnection(); // Se obtiene la conexión
            stmt = conn.prepareStatement(SQL_DELETE); // Se prepara la consulta DELETE
            stmt.setInt(1, carrera.getCar_codigo()); // Se asigna el código de la carrera a eliminar

            System.out.println("Ejecutando query: " + SQL_DELETE);
            rows = stmt.executeUpdate(); // Se ejecuta la eliminación
            System.out.println("Registros eliminados: " + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out); // Se imprime el error si ocurre una excepción SQL
        } finally {
            // Se cierran los recursos para liberar la conexión
            ConexionCarreras.close(stmt);
            ConexionCarreras.close(conn);
        }

        return rows; // Se retorna el número de filas eliminadas
    }

    // Método para buscar y retornar una carrera específica según su código
    // Retorna el objeto Carrera encontrado, o null si no existe
    public Carrera query(Carrera carrera) {
        Connection conn = null;        // Conexión a la base de datos
        PreparedStatement stmt = null; // Sentencia SQL preparada
        ResultSet rs = null;           // Resultado de la consulta

        try {
            conn = ConexionCarreras.getConnection(); // Se obtiene la conexión
            stmt = conn.prepareStatement(SQL_QUERY); // Se prepara la consulta de búsqueda
            stmt.setInt(1, carrera.getCar_codigo()); // Se asigna el código a buscar
            rs = stmt.executeQuery(); // Se ejecuta la consulta

            System.out.println("Ejecutando query: " + SQL_QUERY);

            // Se recorre el resultado (se espera como máximo un registro)
            while (rs.next()) {
                int car_codigo = rs.getInt("car_codigo");       // Se lee el código de la carrera
                String car_nombre = rs.getString("car_nombre"); // Se lee el nombre de la carrera
                String car_status = rs.getString("car_status"); // Se lee el status de la carrera

                // Se sobreescribe el objeto con los datos encontrados en la base de datos
                carrera = new Carrera(car_codigo, car_nombre, car_status);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out); // Se imprime el error si ocurre una excepción SQL
        } finally {
            // Se cierran los recursos en orden inverso para liberar la conexión
            ConexionCarreras.close(rs);
            ConexionCarreras.close(stmt);
            ConexionCarreras.close(conn);
        }

        return carrera; // Se retorna la carrera encontrada
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;
import domain.Jornada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author isaia
 */
public class JornadaDAO {
    // Consulta para obtener todos los registros de la tabla jornadas
    private static final String SQL_SELECT = "SELECT jor_codigo, jor_nombre FROM jornadas";

    // Consulta para insertar una nueva jornada (el código es autogenerado)
    private static final String SQL_INSERT = "INSERT INTO jornadas(jor_codigo, jor_nombre) VALUES(?, ?)";

    // Consulta para actualizar el nombre y status de una jornada según su código
    private static final String SQL_UPDATE = "UPDATE jornadas SET jor_nombre=? WHERE jor_codigo=?";

    // Consulta para eliminar una jornada según su código
    private static final String SQL_DELETE = "DELETE FROM jornadas WHERE jor_codigo=?";

    // Consulta para buscar una jornada específica por su código
    private static final String SQL_QUERY = "SELECT jor_codigo, jor_nombre FROM jornadas WHERE jor_codigo=?";

    // Método que retorna una lista con todas las jornadas registradas en la base de datos
    public List<Jornada> select() {
        Connection conn = null;          // Conexión a la base de datos
        PreparedStatement stmt = null;   // Sentencia SQL preparada
        ResultSet rs = null;             // Resultado de la consulta
        Jornada jornada = null;          // Objeto temporal para cada fila leída
        List<Jornada> jornadas = new ArrayList<Jornada>(); // Lista que almacenará los resultados

        try {
            conn = ConexionJornada.getConnection(); // Se obtiene la conexión
            stmt = conn.prepareStatement(SQL_SELECT); // Se prepara la consulta SELECT
            rs = stmt.executeQuery(); // Se ejecuta la consulta

            // Se recorre cada fila del resultado
            while (rs.next()) {
                int jor_codigo = rs.getInt("jor_codigo");       // Se lee el código de la jornada
                String jor_nombre = rs.getString("jor_nombre"); // Se lee el nombre de la jornada
                // Se crea un nuevo objeto Jornada y se asignan los valores leídos
                jornada = new Jornada(jor_codigo, jor_nombre);

                jornadas.add(jornada); // Se agrega la jornada a la lista
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out); // Se imprime el error si ocurre una excepción SQL
        } finally {
            // Se cierran los recursos en orden inverso para liberar la conexión
            ConexionJornada.close(rs);
            ConexionJornada.close(stmt);
            ConexionJornada.close(conn);
        }

        return jornadas; // Se retorna la lista completa de jornadas
    }

    // Método para insertar una nueva jornada en la base de datos
    // Retorna el número de filas afectadas (1 si fue exitoso, 0 si falló)
    public int insert(Jornada jornada) {
        Connection conn = null;        // Conexión a la base de datos
        PreparedStatement stmt = null; // Sentencia SQL preparada
        int rows = 0;                  // Contador de filas afectadas

        try {
            conn = ConexionJornada.getConnection(); // Se obtiene la conexión
            stmt = conn.prepareStatement(SQL_INSERT); // Se prepara la consulta INSERT
            stmt.setInt(1, jornada.getjor_codigo()); // Se asigna el nombre de la jornada
            stmt.setString(2, jornada.getjor_nombre());
            System.out.println("Ejecutando query: " + SQL_INSERT);
            rows = stmt.executeUpdate(); // Se ejecuta la inserción
            System.out.println("Registros afectados: " + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out); // Se imprime el error si ocurre una excepción SQL
        } finally {
            // Se cierran los recursos para liberar la conexión
            ConexionJornada.close(stmt);
            ConexionJornada.close(conn);
        }

        return rows; // Se retorna el número de filas insertadas
    }

    // Método para actualizar los datos de una jornada existente en la base de datos
    // Retorna el número de filas afectadas (1 si fue exitoso, 0 si no encontró el registro)
    public int update(Jornada jornada) {
        Connection conn = null;        // Conexión a la base de datos
        PreparedStatement stmt = null; // Sentencia SQL preparada
        int rows = 0;                  // Contador de filas afectadas

        try {
            conn = ConexionJornada.getConnection(); // Se obtiene la conexión
            stmt = conn.prepareStatement(SQL_UPDATE); // Se prepara la consulta UPDATE
            stmt.setInt(1, jornada.getjor_codigo()); // Se asigna el nuevo codigo
            stmt.setString(2, jornada.getjor_nombre());    // Se asigna el nombre 

            System.out.println("Ejecutando query: " + SQL_UPDATE);
            rows = stmt.executeUpdate(); // Se ejecuta la actualización
            System.out.println("Registros actualizados: " + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out); // Se imprime el error si ocurre una excepción SQL
        } finally {
            // Se cierran los recursos para liberar la conexión
            ConexionJornada.close(stmt);
            ConexionJornada.close(conn);
        }

        return rows; // Se retorna el número de filas actualizadas
    }

    // Método para eliminar una jornada de la base de datos según su código
    // Retorna el número de filas afectadas (1 si fue exitoso, 0 si no encontró el registro)
    public int delete(Jornada jornada) {
        Connection conn = null;        // Conexión a la base de datos
        PreparedStatement stmt = null; // Sentencia SQL preparada
        int rows = 0;                  // Contador de filas afectadas

        try {
            conn = ConexionJornada.getConnection(); // Se obtiene la conexión
            stmt = conn.prepareStatement(SQL_DELETE); // Se prepara la consulta DELETE
            stmt.setInt(1, jornada.getjor_codigo()); // Se asigna el código de la jornada a eliminar

            System.out.println("Ejecutando query: " + SQL_DELETE);
            rows = stmt.executeUpdate(); // Se ejecuta la eliminación
            System.out.println("Registros eliminados: " + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out); // Se imprime el error si ocurre una excepción SQL
        } finally {
            // Se cierran los recursos para liberar la conexión
            ConexionJornada.close(stmt);
            ConexionJornada.close(conn);
        }

        return rows; // Se retorna el número de filas eliminadas
    }

    // Método para buscar y retornar una jornada específica según su código
    // Retorna el objeto Jornada encontrado, o null si no existe
    public Jornada query(Jornada jornada) {
        Connection conn = null;        // Conexión a la base de datos
        PreparedStatement stmt = null; // Sentencia SQL preparada
        ResultSet rs = null;           // Resultado de la consulta

        try {
            conn = ConexionJornada.getConnection(); // Se obtiene la conexión
            stmt = conn.prepareStatement(SQL_QUERY); // Se prepara la consulta de búsqueda
            stmt.setInt(1, jornada.getjor_codigo()); // Se asigna el código a buscar
            rs = stmt.executeQuery(); // Se ejecuta la consulta

            System.out.println("Ejecutando query: " + SQL_QUERY);

            // Se recorre el resultado (se espera como máximo un registro)
            while (rs.next()) {
                int jor_codigo = rs.getInt("jor_codigo");       // Se lee el código de la jornada
                String jor_nombre = rs.getString("jor_nombre"); // Se lee el nombre de la jornada
                // Se sobreescribe el objeto con los datos encontrados en la base de datos
                jornada = new Jornada(jor_codigo, jor_nombre);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out); // Se imprime el error si ocurre una excepción SQL
        } finally {
            // Se cierran los recursos en orden inverso para liberar la conexión
            ConexionJornada.close(rs);
            ConexionJornada.close(stmt);
            ConexionJornada.close(conn);
        }

        return jornada; // Se retorna la jornada encontrada
    }
}

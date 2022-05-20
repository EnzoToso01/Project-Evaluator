package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Frames.ProjectEvaluator;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTable;

/**
 *
 * @author Enzo
 */
public class Conector {

    String url = "C:\\Project evaluator\\" + ProjectEvaluator.nombreproyecto_str + ".db";
    Connection connect;

    public void connect() throws ClassNotFoundException {
        try {
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection("jdbc:sqlite:" + url);
            if (connect != null) {
                System.out.println("Conectado");
            }
        } catch (SQLException ex) {
            System.err.println("No se ha podido conectar a la base de datos\n" + ex.getMessage());
        }
    }

    public void close() {
        try {
            connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveTabla(JTable tabla, String nombretabla) {
        try {
            ArrayList columnas = new ArrayList();
            columnas.addAll(Utilidad.Tabla.getarraylist_col(tabla));
            // System.out.println(columnas);
            //   PreparedStatement cr =connect.prepareStatement("create table if not exists ingresos(id integer primary key autoincrement)");      
            // cr.execute();   
            for (int i = 0; i <= tabla.getColumnCount() - 1; i++) {
                System.out.println(columnas.get(i).toString());
                PreparedStatement col = connect.prepareStatement("ALTER TABLE " + nombretabla + "+ ADD COLUMN " + columnas.get(i));
                col.execute();
            }

            /*    PreparedStatement st = connect.prepareStatement("insert into " +nombretabla+" values (?,?)");
            st.setString(1, alumno.getNombre());
            st.setString(2, alumno.getApellidos());
            st.execute();*/
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

}

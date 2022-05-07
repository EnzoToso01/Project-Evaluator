package Clases;

import Frames.IngVsGas;
import Frames.ProjectEvaluator;
import static Frames.ProjectEvaluator.nombreproyecto_str;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Utilidad {

    public static class Tabla {

        public static void inicializar(JTable tabla) {
            //Asigna los años del proyecto a las tablas
            //Se salta las columnas ya agregadas para no rehacerlas o resta las columnas cortadas
            DefaultTableModel tbl = get_modelo(tabla);
            for (int i = tbl.getColumnCount(); i <= ProjectEvaluator.longevidad; i++) {
                tbl.addColumn("Año " + i);
            }
        }

        public static void importar(File archivo, JTable tabla) {
            //IMPORTAR TXT A DATOS DE TABLA 

            if (archivo.exists()) {
                try {
                    FileReader fr = new FileReader(archivo);
                    BufferedReader br = new BufferedReader(fr);

                    DefaultTableModel model = (DefaultTableModel) tabla.getModel();
                    Object[] lines = br.lines().toArray();

                    for (int i = 0; i < lines.length; i++) {
                        String[] row = lines[i].toString().split("///");
                        model.addRow(row);
                    }

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(IngVsGas.class.getName()).log(Level.SEVERE, null, ex);

                }

            }
        }

        public static void exportar(File archivo, JTable tabla) {

            //EXPORTAR DATOS DE TABLA A TXT
            // crea el archivo si no existe
            if (!archivo.exists()) {
                try {

                    archivo.createNewFile();
                } catch (Exception ex) {
                    System.err.println("Error en exportar,Utilidad");
                    ex.printStackTrace();
                }
            }
            try {
                FileWriter fw = new FileWriter(archivo);
                BufferedWriter bw = new BufferedWriter(fw);

                for (int i = 0; i < tabla.getRowCount(); i++) {//filas
                    for (int j = 0; j < tabla.getColumnCount(); j++) {//columnas
                        if (tabla.getModel().getValueAt(i, j) != null) {
                            bw.write(tabla.getModel().getValueAt(i, j) + "///");
                        } else {
                            bw.write("///");
                        }
                    }
                    bw.newLine();
                }

                bw.close();
                fw.close();

            } catch (IOException ex) {
                Logger.getLogger(IngVsGas.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        public static void filas_defecto(JTable tabla, int num) {
            //añade filas si no hay ninguna en la tabla
            if (tabla.getRowCount() <= 2) {
                DefaultTableModel tblmodel = (DefaultTableModel) tabla.getModel();
                tblmodel.setRowCount(num);
            }
        }

        public static int buscar_fila(String nombre_fila, JTable tabla) {
            int num_fila = -1;
            for (int i = 0; i <= tabla.getRowCount() - 1; i++) {
                try {
                    if (tabla.getValueAt(i, 0).equals(nombre_fila)) {
                        num_fila = i;
                    }
                } catch (NullPointerException e) {
                    tabla.setValueAt("", i, 0);
                }
            }
            return num_fila;
        }

        public static DefaultTableModel get_modelo(JTable tabla) {
            DefaultTableModel tblmodel = (DefaultTableModel) tabla.getModel();
            return tblmodel;
        }

        public static ArrayList get_fila(JTable tabla, int num_fila) {
            ArrayList fila = new ArrayList();
            for (int i = 0; i < tabla.getColumnCount(); i++) {
                fila.add(tabla.getValueAt(num_fila, i));
            }
            return fila;
        }

    }

    public static class JtextField {

        public static void importar_jtf(File archivo, JTextField jtf) {
            //IMPORTAR TXT A DATOS DE Jtextfield

            if (archivo.exists()) {
                try {
                    FileReader fr = new FileReader(archivo);
                    BufferedReader br = new BufferedReader(fr);
                    String dato = br.readLine();
                    jtf.setText(dato);

                } catch (IOException ex) {
                    Logger.getLogger(IngVsGas.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

        public static void exportar_jtf(File archivo, JTextField jtf) {

            //EXPORTAR DATOS DE Jtextfield A TXT
            // crea el archivo si no existe
            if (!archivo.exists()) {
                try {
                    archivo.createNewFile();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            try {
                FileWriter fw = new FileWriter(archivo);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(jtf.getText());
                bw.close();
                fw.close();

            } catch (IOException ex) {
                Logger.getLogger(IngVsGas.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}

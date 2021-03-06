package Clases;

import Frames.IngVsGas;
import Frames.ProjectEvaluator;
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
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Utilidad {

    public static class Tabla {

        public static void inicializar_col(JTable tabla) {
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
                    ex.getMessage();
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

        public static int buscar_indice_fila(String nombre_fila, JTable tabla) {
            //Busca el num de indice de la fila
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
            //retorna el modelo de la tabla
            DefaultTableModel tblmodel = (DefaultTableModel) tabla.getModel();
            return tblmodel;
        }

        public static ArrayList get_fila(JTable tabla, int num_fila) {
            //devuelve en un arraylist la fila solicitada
            ArrayList fila = new ArrayList();
            for (int i = 0; i < tabla.getColumnCount(); i++) {
                fila.add(tabla.getValueAt(num_fila, i));
            }
            return fila;
        }

        public static void check_insert_fila(JTable tabla, int index, ArrayList arraylist) {
            //chequea si existe la fila, la reemplaza o añade una nueva según corresponda
            try {
                if (index > 0) {
                    if (tabla.getRowCount() >= index) {
                        Utilidad.Tabla.get_modelo(tabla).removeRow(index - 1);
                        Utilidad.Tabla.get_modelo(tabla).insertRow(index - 1, arraylist.toArray());
                    } else {
                        Utilidad.Tabla.get_modelo(tabla).addRow(arraylist.toArray());
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Error en check_insert_fila (Utilidad)");
            }
        }
    }
    //CLASS JTEXTFIELD

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
                    ex.getMessage();
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

    public static class Jcombobox {

        public static String importar_ult_tema(File archivo) {
            //importa el ultimo item seleccionado del combobox
            String dato = "";
            if (archivo.exists()) {
                try {
                    FileReader fr = new FileReader(archivo);
                    BufferedReader br = new BufferedReader(fr);
                    dato = br.readLine();
                } catch (IOException ex) {
                    Logger.getLogger(IngVsGas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return dato;
        }

        public static void exportar_jcombobox(File archivo, JComboBox jcombobox) {
            //exporta el ultimo item seleccionado del combobox
            // crea el archivo si no existe
            if (!archivo.exists()) {
                try {
                    archivo.createNewFile();
                } catch (Exception ex) {
                    ex.getMessage();
                }
            }
            try {
                FileWriter fw = new FileWriter(archivo);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(jcombobox.getSelectedItem().toString());
                bw.close();
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(IngVsGas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

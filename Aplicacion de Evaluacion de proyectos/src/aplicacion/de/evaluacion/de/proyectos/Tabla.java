/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.de.evaluacion.de.proyectos;

import Frames.Indicadores;
import Frames.IngVsGas;
import Frames.Principal;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Enzo
 */
public class Tabla {

    public Tabla() {
        
    }

    public static void inicializar(JTable tabla) {
        //Asigna los años del proyecto a las tablas
        //Se salta las columnas ya agregadas para no rehacerlas o resta las columnas cortadas
        DefaultTableModel tbl = get_modelo(tabla);

        System.out.println("------");

        if (Principal.longevidad > tbl.getColumnCount() - 1) {
            for (int i = tbl.getColumnCount(); i <= Principal.longevidad; i++) {
                tbl.addColumn("Año " + i);

            }
        } else if (Principal.longevidad < tbl.getColumnCount() - 1) {
            //remueve las ultimas columnas que ya no corresponden 
            for (int i = 1; i <= ((tbl.getColumnCount() - 1) - Principal.longevidad); i++) {
                TableColumn col = tabla.getColumnModel().getColumn(tabla.getColumnCount() - 1);
                tabla.getColumnModel().removeColumn(col);
            }
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

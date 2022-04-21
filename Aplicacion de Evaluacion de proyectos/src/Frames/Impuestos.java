/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Clases.Utilidad;
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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Enzo
 */
public class Impuestos extends javax.swing.JFrame {

    /**
     * Creates new form Impuestos
     */
    //declara el archivo a importar o exportar por los métodos de Tabla
    private File impuestos = new File("C:\\Project evaluator\\impuestos.txt");
    private File indimpuestos = new File("C:\\Project evaluator\\indicadores impuestos.txt");
    public static double tas_desc = 0.02;
    public static double tas_int = 0.97;
    public static double tas_pob = 0.02;
    public static double inf_men = 0.05;
    public static double inf_an = 0.34;
    public static double ing_b = 0.04;
    public static double iva = 0.21;
    public static double gan = 0.35;
    public static double cont_p = 0.26;
    public static double ob_s = 0.11;
    public static ArrayList iva_c = new ArrayList();
    public static ArrayList iva_v = new ArrayList();
    private ArrayList calc_total = new ArrayList();

    public Impuestos() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //determina el color del fondo
        Color a = new Color(40, 44, 52);
        getContentPane().setBackground(a);
        Color b = new Color(26, 29, 34);
        tabla_impuestos.getTableHeader().setBackground(b);
        tabla_indimpuestos.getTableHeader().setBackground(b);
    }

    public JTable getTabla_impuestos() {
        return tabla_impuestos;
    }

    public JTable getTabla_indimpuestos() {
        return tabla_indimpuestos;
    }

    public File getImpuestos() {
        return impuestos;
    }

    public File getIndimpuestos() {
        return indimpuestos;
    }

    public void filas_datos_impuestos(JTable tablaimp, JTable tablaindimp) {
        //inicializa los datos de las filas de la tabla
        if (tabla_impuestos.getRowCount() < 1) {

            String dato1[] = {"Impuesto a las ganancias"};
            String dato2[] = {"IVA Ventas"};
            String dato3[] = {"IVA Compras"};
            String dato4[] = {"Montotributo/RI"};
            String dato5[] = {"Ingresos Brutos"};
            String dato6[] = {"Total de impuestos"};
            Utilidad.Tabla.get_modelo(tabla_impuestos).addRow(dato1);
            Utilidad.Tabla.get_modelo(tabla_impuestos).addRow(dato2);
            Utilidad.Tabla.get_modelo(tabla_impuestos).addRow(dato3);
            Utilidad.Tabla.get_modelo(tabla_impuestos).addRow(dato4);
            Utilidad.Tabla.get_modelo(tabla_impuestos).addRow(dato5);
            Utilidad.Tabla.get_modelo(tabla_impuestos).addRow(dato6);

            Utilidad.Tabla.filas_defecto(tabla_impuestos, 10);
        }

        //inicializa los datos de las filas de la tabla
        if (tabla_indimpuestos.getRowCount() < 1) {

            DefaultTableModel tblmodel2 = (DefaultTableModel) tabla_indimpuestos.getModel();
            String dato1[] = {"Tasa de descuento", String.valueOf(tas_desc * 100)};
            String dato2[] = {"Tasa de interés", String.valueOf(tas_int * 100)};
            String dato3[] = {"Tasa de crecimiento de la población", String.valueOf(tas_pob * 100)};
            String dato4[] = {"Inflación Mensual", String.valueOf(inf_men * 100)};
            String dato5[] = {"Inflación Anual", String.valueOf(inf_an * 100)};
            String dato6[] = {"Ingresos Brutos", String.valueOf(ing_b * 100)};
            String dato7[] = {"IVA", String.valueOf(iva * 100)};
            String dato8[] = {"Ganancias", String.valueOf(gan * 100)};
            String dato9[] = {"Contribuciones patronales", String.valueOf(cont_p * 100)};
            String dato10[] = {"Obra Social", String.valueOf(ob_s * 100)};

            Utilidad.Tabla.get_modelo(tabla_indimpuestos).addRow(dato1);
            Utilidad.Tabla.get_modelo(tabla_indimpuestos).addRow(dato2);
            Utilidad.Tabla.get_modelo(tabla_indimpuestos).addRow(dato3);
            Utilidad.Tabla.get_modelo(tabla_indimpuestos).addRow(dato4);
            Utilidad.Tabla.get_modelo(tabla_indimpuestos).addRow(dato5);
            Utilidad.Tabla.get_modelo(tabla_indimpuestos).addRow(dato6);
            Utilidad.Tabla.get_modelo(tabla_indimpuestos).addRow(dato7);
            Utilidad.Tabla.get_modelo(tabla_indimpuestos).addRow(dato8);
            Utilidad.Tabla.get_modelo(tabla_indimpuestos).addRow(dato9);
            Utilidad.Tabla.get_modelo(tabla_indimpuestos).addRow(dato10);
            Utilidad.Tabla.filas_defecto(tabla_indimpuestos, 10);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtimpuestos = new javax.swing.JLabel();
        scroll_impuestos = new javax.swing.JScrollPane();
        tabla_impuestos = new javax.swing.JTable();
        btn_añadirfila_imp = new javax.swing.JButton();
        btn_quitarfila_imp = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        scroll_indimpuestos = new javax.swing.JScrollPane();
        tabla_indimpuestos = new javax.swing.JTable();
        btn_añadirfila_indimp = new javax.swing.JButton();
        btn_quitarfila_indimp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Impuestos");
        setBackground(new java.awt.Color(240, 255, 255));
        setLocation(new java.awt.Point(0, 0));
        setSize(new java.awt.Dimension(900, 690));

        txtimpuestos.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txtimpuestos.setForeground(new java.awt.Color(240, 255, 255));
        txtimpuestos.setText("Impuestos");

        tabla_impuestos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "impuesto"
            }
        ));
        tabla_impuestos.setShowGrid(true);
        scroll_impuestos.setViewportView(tabla_impuestos);

        btn_añadirfila_imp.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_añadirfila_imp.setText("añadir fila");
        btn_añadirfila_imp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_añadirfila_impActionPerformed(evt);
            }
        });

        btn_quitarfila_imp.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_quitarfila_imp.setText("quitar fila");
        btn_quitarfila_imp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quitarfila_impActionPerformed(evt);
            }
        });

        btn_guardar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        tabla_indimpuestos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Indicador", "Valor"
            }
        ));
        tabla_indimpuestos.setShowGrid(true);
        tabla_indimpuestos.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tabla_indimpuestosPropertyChange(evt);
            }
        });
        scroll_indimpuestos.setViewportView(tabla_indimpuestos);

        btn_añadirfila_indimp.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_añadirfila_indimp.setText("añadir fila");
        btn_añadirfila_indimp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_añadirfila_indimpActionPerformed(evt);
            }
        });

        btn_quitarfila_indimp.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_quitarfila_indimp.setText("quitar fila");
        btn_quitarfila_indimp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quitarfila_indimpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtimpuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(436, 436, 436)
                        .addComponent(btn_añadirfila_imp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_quitarfila_imp)
                        .addGap(87, 87, 87)
                        .addComponent(btn_guardar))
                    .addComponent(scroll_indimpuestos)
                    .addComponent(scroll_impuestos))
                .addGap(17, 17, 17))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_añadirfila_indimp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_quitarfila_indimp)
                .addGap(173, 173, 173))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_guardar)
                    .addComponent(btn_añadirfila_imp)
                    .addComponent(btn_quitarfila_imp)
                    .addComponent(txtimpuestos))
                .addGap(19, 19, 19)
                .addComponent(scroll_impuestos, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_añadirfila_indimp)
                    .addComponent(btn_quitarfila_indimp))
                .addGap(18, 18, 18)
                .addComponent(scroll_indimpuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_añadirfila_impActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añadirfila_impActionPerformed
        // TODO add your handling code here
        //Añade filas a imp  
        Vector<?> rowData = null;
        Utilidad.Tabla.get_modelo(tabla_impuestos).addRow(rowData);
    }//GEN-LAST:event_btn_añadirfila_impActionPerformed

    private void btn_quitarfila_impActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quitarfila_impActionPerformed
        // TODO add your handling code here:
        //Quita filas a imp, si no se selecciona una fila,se elimina la ultima

        if (tabla_impuestos.getSelectedRowCount() >= 1) {
            do {
                Utilidad.Tabla.get_modelo(tabla_impuestos).removeRow(tabla_impuestos.getSelectedRow());
            } while (tabla_impuestos.getSelectedRowCount() >= 1);

        } else {
            Utilidad.Tabla.get_modelo(tabla_impuestos).removeRow(tabla_impuestos.getRowCount() - 1);
        }
    }//GEN-LAST:event_btn_quitarfila_impActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // TODO add your handling code here:
        try {
            File impuestos = new File("C:\\Project evaluator\\impuestos.txt");
            File indimpuestos = new File("C:\\Project evaluator\\indicadores impuestos.txt");
            JTable tablaimp = getTabla_impuestos();
            JTable tablaindimp = getTabla_indimpuestos();
            Utilidad.Tabla.exportar(impuestos, tablaimp);
            Utilidad.Tabla.exportar(indimpuestos, tablaindimp);
            JOptionPane.showMessageDialog(null, "datos guardados");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al guardar los datos");
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void tabla_indimpuestosPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tabla_indimpuestosPropertyChange
        // TODO add your handling code here:
        if (tabla_indimpuestos.getRowCount() > 0) {

            tas_desc = Double.parseDouble((String) tabla_indimpuestos.getValueAt(0, 1)) / 100;
            tas_int = Double.parseDouble((String) tabla_indimpuestos.getValueAt(1, 1)) / 100;
            tas_pob = Double.parseDouble((String) tabla_indimpuestos.getValueAt(2, 1)) / 100;
            inf_men = Double.parseDouble((String) tabla_indimpuestos.getValueAt(3, 1)) / 100;
            inf_an = Double.parseDouble((String) tabla_indimpuestos.getValueAt(4, 1)) / 100;
            ing_b = Double.parseDouble((String) tabla_indimpuestos.getValueAt(5, 1)) / 100;
            iva = Double.parseDouble((String) tabla_indimpuestos.getValueAt(6, 1)) / 100;
            gan = Double.parseDouble((String) tabla_indimpuestos.getValueAt(7, 1)) / 100;
            cont_p = Double.parseDouble((String) tabla_indimpuestos.getValueAt(8, 1)) / 100;
            ob_s = Double.parseDouble((String) tabla_indimpuestos.getValueAt(9, 1)) / 100;
        }
    }//GEN-LAST:event_tabla_indimpuestosPropertyChange

    private void btn_añadirfila_indimpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añadirfila_indimpActionPerformed
        // TODO add your handling code here:
        //Añade filas a imp
        Vector<?> rowData = null;
        Utilidad.Tabla.get_modelo(tabla_indimpuestos).addRow(rowData);
    }//GEN-LAST:event_btn_añadirfila_indimpActionPerformed

    private void btn_quitarfila_indimpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quitarfila_indimpActionPerformed
        // TODO add your handling code here:
        if (tabla_indimpuestos.getSelectedRowCount() >= 1) {
            do {
                Utilidad.Tabla.get_modelo(tabla_indimpuestos).removeRow(tabla_indimpuestos.getSelectedRow());
            } while (tabla_indimpuestos.getSelectedRowCount() >= 1);

        } else {
            Utilidad.Tabla.get_modelo(tabla_indimpuestos).removeRow(tabla_indimpuestos.getRowCount() - 1);
        }
    }//GEN-LAST:event_btn_quitarfila_indimpActionPerformed

    public void iva_ventas(ArrayList ing_iva) {
        iva_v.clear();
        iva_v.add(0, "IVA Ventas");

        for (int i = 0; i < ProjectEvaluator.longevidad; i++) {
            iva_v.add((double) ing_iva.get(i) * iva);
        }

        if (tabla_impuestos.getRowCount() > 1) {
            Utilidad.Tabla.get_modelo(tabla_impuestos).removeRow(1);
            Utilidad.Tabla.get_modelo(tabla_impuestos).insertRow(1, iva_v.toArray());
        } else {
            Utilidad.Tabla.get_modelo(tabla_impuestos).addRow(iva_v.toArray());
        }
    }

    public void iva_compras(ArrayList eg_iva) {
        iva_c.clear();
        iva_c.add(0, "IVA Compras");

        for (int i = 0; i < ProjectEvaluator.longevidad; i++) {
            iva_c.add((double) eg_iva.get(i) * iva);
        }

        if (tabla_impuestos.getRowCount() > 2) {
            Utilidad.Tabla.get_modelo(tabla_impuestos).removeRow(2);
            Utilidad.Tabla.get_modelo(tabla_impuestos).insertRow(2, iva_c.toArray());
        } else {
            Utilidad.Tabla.get_modelo(tabla_impuestos).addRow(iva_c.toArray());
        }

    }

    public void ganancias() {

        if (tabla_impuestos.getRowCount() > 0) {
            Utilidad.Tabla.get_modelo(tabla_impuestos).removeRow(0);
            Utilidad.Tabla.get_modelo(tabla_impuestos).insertRow(0, EBITDA.arr_ganancias.toArray());
        } else {
            Utilidad.Tabla.get_modelo(tabla_impuestos).addRow(EBITDA.arr_ganancias.toArray());
        }

    }

    public void ing_b() {

        if (tabla_impuestos.getRowCount() > 4) {
            Utilidad.Tabla.get_modelo(tabla_impuestos).removeRow(4);
            Utilidad.Tabla.get_modelo(tabla_impuestos).insertRow(4, EBITDA.arr_ing_br.toArray());
        } else {
            Utilidad.Tabla.get_modelo(tabla_impuestos).addRow(EBITDA.arr_ing_br.toArray());
        }
    }

    public void calculo_total_imp() {
        double total = 0;
        calc_total.clear();
        calc_total.add(0, "Total de Impuestos");
        //acumula la suma de los valores
        try {
            for (int i = 1; i <= ProjectEvaluator.longevidad; i++) {
                for (int j = 0; j < tabla_impuestos.getRowCount(); j++) {
                    //convierte los datos null de la primera columna en string para evitar null exceptions 
                    if (tabla_impuestos.getValueAt(j, 0) == null) {
                        Utilidad.Tabla.get_modelo(tabla_impuestos).setValueAt("", j, 0);
                    }
                    if (tabla_impuestos.getValueAt(j, i) != null) {
                        if (!tabla_impuestos.getValueAt(j, i).equals("") && !tabla_impuestos.getValueAt(j, 0).equals("Total de Impuestos")) {
                            total = total + Double.parseDouble(tabla_impuestos.getValueAt(j, i).toString());
                        }
                    }
                }

                calc_total.add(total);
                total = 0;
            }
        } catch (IndexOutOfBoundsException e) {

        }

        if (tabla_impuestos.getRowCount() > 5) {
            Utilidad.Tabla.get_modelo(tabla_impuestos).removeRow(5);
            Utilidad.Tabla.get_modelo(tabla_impuestos).insertRow(5, calc_total.toArray());
        } else {
            Utilidad.Tabla.get_modelo(tabla_impuestos).addRow(calc_total.toArray());
        }
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_añadirfila_imp;
    private javax.swing.JButton btn_añadirfila_indimp;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_quitarfila_imp;
    private javax.swing.JButton btn_quitarfila_indimp;
    private javax.swing.JScrollPane scroll_impuestos;
    private javax.swing.JScrollPane scroll_indimpuestos;
    private javax.swing.JTable tabla_impuestos;
    private javax.swing.JTable tabla_indimpuestos;
    private javax.swing.JLabel txtimpuestos;
    // End of variables declaration//GEN-END:variables

}

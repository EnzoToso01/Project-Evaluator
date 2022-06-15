/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Clases.Utilidad;
import static Frames.ProjectEvaluator.direccion;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author Enzo
 */
public class Impuestos extends javax.swing.JFrame {

    //declara el archivo a importar o exportar por los métodos de Tabla
    private File impuestos_f;
    private File indimpuestos_f;
    public double tas_desc = 0.02;
    public double tas_int = 0.97;
    public double tas_pob = 0.02;
    public double inf_men = 0.05;
    public double inf_an = 0.34;
    public double ing_b = 0.04;
    public double iva = 0.21;
    public double gan = 0.35;
    public double cont_p = 0.26;
    public double ob_s = 0.11;
    private boolean imp_impuestos = false;
    private ArrayList arr_ing_br = new ArrayList();
    private ArrayList arr_iva = new ArrayList();
    private ArrayList arr_ganancias = new ArrayList();
    private ArrayList iva_c = new ArrayList();
    private ArrayList iva_v = new ArrayList();
    private ArrayList calc_total = new ArrayList();
    private EBITDA ebitda;
    private IngVsGas ingvsgas;

    public Impuestos() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //determina el color del fondo
        getContentPane().setBackground(ProjectEvaluator.fondo);
    }

    //Código autogenerado
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txttasasimpuestos = new javax.swing.JLabel();
        scroll_impuestos = new javax.swing.JScrollPane();
        tabla_impuestos = new javax.swing.JTable();
        scroll_indimpuestos = new javax.swing.JScrollPane();
        tabla_indimpuestos = new javax.swing.JTable();
        txtimpuestos = new javax.swing.JLabel();
        btn_añadirfila_imp = new javax.swing.JButton();
        btn_quitarfila_imp = new javax.swing.JButton();
        btn_añadirfila_indimp = new javax.swing.JButton();
        btn_quitarfila_indimp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Impuestos");
        setBackground(new java.awt.Color(240, 255, 255));
        setLocation(new java.awt.Point(0, 0));
        setSize(new java.awt.Dimension(900, 690));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        txttasasimpuestos.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txttasasimpuestos.setForeground(new java.awt.Color(240, 255, 255));
        txttasasimpuestos.setText("Tasas de impuestos");

        tabla_impuestos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "impuesto"
            }
        ));
        tabla_impuestos.setFocusable(false);
        tabla_impuestos.setShowGrid(true);
        tabla_impuestos.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tabla_impuestosPropertyChange(evt);
            }
        });
        scroll_impuestos.setViewportView(tabla_impuestos);

        tabla_indimpuestos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Indicador", "Valor"
            }
        ));
        tabla_indimpuestos.setFocusable(false);
        tabla_indimpuestos.setShowGrid(true);
        tabla_indimpuestos.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tabla_indimpuestosPropertyChange(evt);
            }
        });
        scroll_indimpuestos.setViewportView(tabla_indimpuestos);

        txtimpuestos.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txtimpuestos.setForeground(new java.awt.Color(240, 255, 255));
        txtimpuestos.setText("Impuestos");

        btn_añadirfila_imp.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_añadirfila_imp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_agregar_fila.png"))); // NOI18N
        btn_añadirfila_imp.setAutoscrolls(true);
        btn_añadirfila_imp.setDefaultCapable(false);
        btn_añadirfila_imp.setFocusable(false);
        btn_añadirfila_imp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_añadirfila_impActionPerformed(evt);
            }
        });

        btn_quitarfila_imp.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_quitarfila_imp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_quitar_fila.png"))); // NOI18N
        btn_quitarfila_imp.setDefaultCapable(false);
        btn_quitarfila_imp.setFocusable(false);
        btn_quitarfila_imp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quitarfila_impActionPerformed(evt);
            }
        });

        btn_añadirfila_indimp.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_añadirfila_indimp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_agregar_fila.png"))); // NOI18N
        btn_añadirfila_indimp.setAutoscrolls(true);
        btn_añadirfila_indimp.setDefaultCapable(false);
        btn_añadirfila_indimp.setFocusable(false);
        btn_añadirfila_indimp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_añadirfila_indimpActionPerformed(evt);
            }
        });

        btn_quitarfila_indimp.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_quitarfila_indimp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_quitar_fila.png"))); // NOI18N
        btn_quitarfila_indimp.setDefaultCapable(false);
        btn_quitarfila_indimp.setFocusable(false);
        btn_quitarfila_indimp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quitarfila_indimpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtimpuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 287, Short.MAX_VALUE)
                        .addComponent(btn_añadirfila_imp, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_quitarfila_imp, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txttasasimpuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_añadirfila_indimp, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_quitarfila_indimp, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scroll_indimpuestos)
                    .addComponent(scroll_impuestos))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtimpuestos)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn_añadirfila_imp)
                        .addComponent(btn_quitarfila_imp, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scroll_impuestos, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_añadirfila_indimp)
                            .addComponent(btn_quitarfila_indimp, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttasasimpuestos)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scroll_indimpuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Getters
    public JTable getTabla_impuestos() {
        return tabla_impuestos;
    }

    public JTable getTabla_indimpuestos() {
        return tabla_indimpuestos;
    }

    public File getImpuestos_f() {
        impuestos_f = new File(direccion + "\\Impuestos\\impuestos.txt");
        return impuestos_f;
    }

    public File getIndimpuestos_f() {
        indimpuestos_f = new File(direccion + "\\Impuestos\\indicadores impuestos.txt");
        return indimpuestos_f;
    }

    public void setEBITDA(EBITDA ebitda) {
        //Obtiene el acceso a objeto ebitda para ser manipulado por Impuestos
        this.ebitda = ebitda;
    }

    public void setIngVsGas(IngVsGas ingvsgas) {
        //Obtiene el acceso a objeto ingvsgas para ser manipulado por Impuestos
        this.ingvsgas = ingvsgas;
    }

    public JLabel getTxtimpuestos() {

        return txtimpuestos;
    }

    public JLabel getTxttasasimpuestos() {
        return txttasasimpuestos;
    }

    public ArrayList getArr_ing_br() {
        return arr_ing_br;
    }

    public ArrayList getArr_iva() {
        return arr_iva;
    }

    public ArrayList getArr_ganancias() {
        return arr_ganancias;
    }

    //Métodos
    public void filas_datos_impuestos(JTable tablaimp) {
        //Resetea e inicializa los datos de la tabla impuestos
        Utilidad.Tabla.get_modelo(tablaimp).setRowCount(0);
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

    public void filas_datos_indimpuestos(JTable tablaindimp) {

        //Resetea e inicializa los datos de la tabla indicadores de impuestos
        Utilidad.Tabla.get_modelo(tablaindimp).setRowCount(0);
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

    public void calculo_ing_brutos() {

        try {
            arr_ing_br.clear();
            if (arr_ing_br.isEmpty() == true) {
                arr_ing_br.add(0, "Ingresos Brutos");
            }
            for (int i = 0; i < ProjectEvaluator.longevidad; i++) {
                arr_ing_br.add(ingvsgas.getTotal_ing_iva().get(i) * ing_b);
            }
            Utilidad.Tabla.check_insert_fila(tabla_impuestos, 5, arr_ing_br);
            Utilidad.Tabla.check_insert_fila(ebitda.getTabla_ebitda(), 4, arr_ing_br);

        } catch (Exception e) {
            System.err.println("Error en calculo_ing_brutos (Impuestos)");
            e.getMessage();
        }
    }

    public void calculo_iva() {

        try {
            arr_iva.clear();
            if (arr_iva.isEmpty() == true) {
                arr_iva.add(0, "IVA");
            }
            for (int i = 1; i <= ProjectEvaluator.longevidad; i++) {
                arr_iva.add((double) iva_v.get(i) - (double) iva_c.get(i));
            }
            Utilidad.Tabla.check_insert_fila(ebitda.getTabla_ebitda(), 5, arr_iva);
        } catch (Exception e) {
            System.err.println("Error en calculo_iva (Impuestos)");
            e.getMessage();
        }
    }

    public void calculo_ganancias() {
        try {
            arr_ganancias.clear();
            if (arr_ganancias.isEmpty() == true) {
                arr_ganancias.add(0, "Impuesto a las ganancias");
            }

            for (int i = 1; i <= ProjectEvaluator.longevidad; i++) {
                if ((double) ebitda.getArr_sub_c_amort().get(i)> 0) {
                    arr_ganancias.add(((double) ebitda.getArr_sub_c_amort().get(i)) * gan);
                } else {
                    arr_ganancias.add(0.0);
                }
            }
            Utilidad.Tabla.check_insert_fila(tabla_impuestos, 1, arr_ganancias);
            Utilidad.Tabla.check_insert_fila(ebitda.getTabla_ebitda(), 10, arr_ganancias);

        } catch (Exception e) {
            System.err.println("Error en calculo_ganancias (Impuestos)");
            e.getMessage();

        }
    }

    private void tabla_indimpuestosPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tabla_indimpuestosPropertyChange
        // TODO add your handling code here:
        try {
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
                ingvsgas.setear_ingvsgas();
                ingvsgas.setear_ebitda_imp();
            }
            if (imp_impuestos == true) {
                File dir_indimp = new File(direccion + "\\Impuestos\\");
                if (!dir_indimp.exists()) {
                    dir_indimp.mkdirs();
                }
                indimpuestos_f = new File(direccion + "\\Impuestos\\indicadores impuestos.txt");
                Utilidad.Tabla.exportar(indimpuestos_f, tabla_indimpuestos);
            }

        } catch (Exception e) {
            System.err.println("Error en tabla_indimpuestosPropertyChange (Impuestos)");
            e.printStackTrace();
        }
    }//GEN-LAST:event_tabla_indimpuestosPropertyChange

    private void tabla_impuestosPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tabla_impuestosPropertyChange
        // TODO add your handling code here:
        try {
            if (imp_impuestos == true) {
                File dir_imp = new File(direccion + "\\Impuestos\\");
                if (!dir_imp.exists()) {
                    dir_imp.mkdirs();
                }
                impuestos_f = new File(direccion + "\\Impuestos\\impuestos.txt");
                Utilidad.Tabla.exportar(impuestos_f, tabla_impuestos);
            }
        } catch (Exception e) {
            System.err.println("Error en tabla_impuestosPropertyChange (Impuestos)");
            e.printStackTrace();
        }

    }//GEN-LAST:event_tabla_impuestosPropertyChange

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        imp_impuestos = true;

    }//GEN-LAST:event_formWindowOpened

    private void btn_añadirfila_impActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añadirfila_impActionPerformed
        // TODO add your handling code here
        //Añade filas a cred
        Vector<?> rowData = null;
        Utilidad.Tabla.get_modelo(tabla_impuestos).addRow(rowData);
    }//GEN-LAST:event_btn_añadirfila_impActionPerformed

    private void btn_quitarfila_impActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quitarfila_impActionPerformed
        // TODO add your handling code here:
        //Quita filas a cred, si no se selecciona una fila,se elimina la ultima
        if (tabla_impuestos.getSelectedRowCount() >= 1) {
            do {
                Utilidad.Tabla.get_modelo(tabla_impuestos).removeRow(tabla_impuestos.getSelectedRow());
            } while (tabla_impuestos.getSelectedRowCount() >= 1);
        } else {
            Utilidad.Tabla.get_modelo(tabla_impuestos).removeRow(tabla_impuestos.getRowCount() - 1);
        }
    }//GEN-LAST:event_btn_quitarfila_impActionPerformed

    private void btn_añadirfila_indimpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añadirfila_indimpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_añadirfila_indimpActionPerformed

    private void btn_quitarfila_indimpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quitarfila_indimpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_quitarfila_indimpActionPerformed

    public void iva_ventas(ArrayList ing_iva) {

        try {
            iva_v.clear();
            iva_v.add(0, "IVA Ventas");

            for (int i = 0; i < ProjectEvaluator.longevidad; i++) {
                iva_v.add((double) ing_iva.get(i) * iva);
            }

            Utilidad.Tabla.check_insert_fila(tabla_impuestos, 2, iva_v);
        } catch (Exception e) {
            System.err.println("Error en iva_ventas (Impuestos)");
            e.printStackTrace();
        }
    }

    public void iva_compras(ArrayList eg_iva) {

        try {
            iva_c.clear();
            iva_c.add(0, "IVA Compras");
            for (int i = 0; i < ProjectEvaluator.longevidad; i++) {
                iva_c.add((double) eg_iva.get(i) * iva);
            }

            Utilidad.Tabla.check_insert_fila(tabla_impuestos, 3, iva_c);
        } catch (Exception e) {
            System.err.println("Error en iva_compras (Impuestos)");
            e.printStackTrace();
        }
    }

    public void calculo_total_imp() {
        double total = 0;
        try {
            calc_total.clear();
            calc_total.add(0, "Total de Impuestos");
            //acumula la suma de los valores
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

        Utilidad.Tabla.check_insert_fila(tabla_impuestos, 6, calc_total);
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_añadirfila_imp;
    private javax.swing.JButton btn_añadirfila_indimp;
    private javax.swing.JButton btn_quitarfila_imp;
    private javax.swing.JButton btn_quitarfila_indimp;
    private javax.swing.JScrollPane scroll_impuestos;
    private javax.swing.JScrollPane scroll_indimpuestos;
    private javax.swing.JTable tabla_impuestos;
    private javax.swing.JTable tabla_indimpuestos;
    private javax.swing.JLabel txtimpuestos;
    private javax.swing.JLabel txttasasimpuestos;
    // End of variables declaration//GEN-END:variables

}

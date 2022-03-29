/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import aplicacion.de.evaluacion.de.proyectos.Tabla;
import java.awt.Color;
import java.io.File;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Enzo
 */
public class Empleados extends javax.swing.JFrame {

    /**
     * Creates new form Empleados
     */
    private File directorio = new File("C:\\Project evaluator\\sueldos");
    private File tasas = new File("C:\\Project evaluator\\sueldos\\tasas.txt");
    private boolean imp_tas = false;
    private double tas_jub;
    private double tas_ob;
    private double tas_ley;
    private double tas_sec;

    public Empleados() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //determina el color del fondo
        Color c = new Color(56, 80, 113);
        getContentPane().setBackground(c);
        directorio.mkdirs();

    }

    public boolean getImp_tas() {
        return imp_tas;
    }

    public void setImp_tas(boolean imp_tas) {
        this.imp_tas = imp_tas;
    }

    public JTable getTabla_sueldos() {
        return tabla_sueldos;
    }

    public File getTasas() {
        return tasas;
    }

    public JTable getTabla_tasas() {
        return tabla_tasas;
    }

    public double getTas_jub() {
        return tas_jub;
    }

    public double getTas_ob() {
        return tas_ob;
    }

    public double getTas_ley() {
        return tas_ley;
    }

    public double getTas_sec() {
        return tas_sec;
    }

    public void importar_emp() {
        Tabla.get_modelo(tabla_sueldos).setRowCount(0);
        //importa la tabla correspondiente al combo
        for (int i = 1; i <= Principal.longevidad; i++) {
            if (combo_años.getSelectedIndex() + 1 == i) {
                File sueldos = new File("C:\\Project evaluator\\sueldos\\sueldos " + i + ".txt");
                Tabla.importar(sueldos, tabla_sueldos);

            }
        }

    }

    public void total_sueldos() {
        for (int i = 0; i < tabla_sueldos.getRowCount(); i++) {
            try {
                double result = Double.valueOf(String.valueOf(Tabla.get_modelo(tabla_sueldos).getValueAt(i, 1))) + Double.valueOf(String.valueOf(Tabla.get_modelo(tabla_sueldos).getValueAt(i, 2)));
                Tabla.get_modelo(tabla_sueldos).setValueAt(result, i, 3);
            } catch (NullPointerException | NumberFormatException e) {

            }
        }
    }

    public void antiguedad() {
        for (int i = 0; i < tabla_sueldos.getRowCount(); i++) {
            try {
                double result = 84.64 * Double.valueOf(String.valueOf(Tabla.get_modelo(tabla_sueldos).getValueAt(i, 4)));
                Tabla.get_modelo(tabla_sueldos).setValueAt(result, i, 5);
            } catch (NullPointerException | NumberFormatException e) {

            }
        }
    }

    public void presentismo() {
        for (int i = 0; i < tabla_sueldos.getRowCount(); i++) {
            try {
                double result = 0.0833 * Double.parseDouble(String.valueOf(Tabla.get_modelo(tabla_sueldos).getValueAt(i, 3)));
                Tabla.get_modelo(tabla_sueldos).setValueAt(result, i, 6);
            } catch (NullPointerException | NumberFormatException e) {

            }
        }
    }

    public void bruto() {
        for (int i = 0; i < tabla_sueldos.getRowCount(); i++) {
            try {
                double result = Double.parseDouble(String.valueOf(Tabla.get_modelo(tabla_sueldos).getValueAt(i, 3))) + Double.parseDouble(String.valueOf(Tabla.get_modelo(tabla_sueldos).getValueAt(i, 5))) + Double.parseDouble(String.valueOf(Tabla.get_modelo(tabla_sueldos).getValueAt(i, 6)));
                Tabla.get_modelo(tabla_sueldos).setValueAt(result, i, 7);
            } catch (NullPointerException | NumberFormatException e) {

            }
        }
    }

    public void tasas(double tasa) {
        try {
            tas_jub = Double.parseDouble(String.valueOf(Tabla.get_modelo(tabla_tasas).getValueAt(0, 0))) / 100;
            tas_ob = Double.parseDouble(String.valueOf(Tabla.get_modelo(tabla_tasas).getValueAt(0, 1))) / 100;
            tas_ley = Double.parseDouble(String.valueOf(Tabla.get_modelo(tabla_tasas).getValueAt(0, 2))) / 100;
            tas_sec = Double.parseDouble(String.valueOf(Tabla.get_modelo(tabla_tasas).getValueAt(0, 3))) / 100;

            for (int i = 0; i < tabla_sueldos.getRowCount(); i++) {

                double result = Double.parseDouble(String.valueOf(Tabla.get_modelo(tabla_sueldos).getValueAt(i, 7))) * tasa;
                if (tasa == tas_jub) {
                    Tabla.get_modelo(tabla_sueldos).setValueAt(result, i, 8);
                } else if (tasa == tas_ob) {
                    Tabla.get_modelo(tabla_sueldos).setValueAt(result, i, 9);
                } else if (tasa == tas_ley) {
                    Tabla.get_modelo(tabla_sueldos).setValueAt(result, i, 10);
                } else if (tasa == tas_sec) {
                    Tabla.get_modelo(tabla_sueldos).setValueAt(result, i, 11);
                }
            }
        } catch (NullPointerException | NumberFormatException e) {
        }
    }

    public void total_desc() {

        for (int i = 0; i < tabla_sueldos.getRowCount(); i++) {
            try {
                double result = Double.parseDouble(String.valueOf(Tabla.get_modelo(tabla_sueldos).getValueAt(i, 8))) + Double.parseDouble(String.valueOf(Tabla.get_modelo(tabla_sueldos).getValueAt(i, 9))) + Double.parseDouble(String.valueOf(Tabla.get_modelo(tabla_sueldos).getValueAt(i, 10))) + Double.parseDouble(String.valueOf(Tabla.get_modelo(tabla_sueldos).getValueAt(i, 11)));
                Tabla.get_modelo(tabla_sueldos).setValueAt(result, i, 12);
            } catch (NullPointerException | NumberFormatException e) {

            }
        }

    }
    
     public void total_neto() {

        for (int i = 0; i < tabla_sueldos.getRowCount(); i++) {
            try {
                double result = Double.parseDouble(String.valueOf(Tabla.get_modelo(tabla_sueldos).getValueAt(i, 7))) - Double.parseDouble(String.valueOf(Tabla.get_modelo(tabla_sueldos).getValueAt(i, 12)));
                Tabla.get_modelo(tabla_sueldos).setValueAt(result, i, 13);
            } catch (NullPointerException | NumberFormatException e) {

            }
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

        txtsueldos = new javax.swing.JLabel();
        scroll_ebitda = new javax.swing.JScrollPane();
        tabla_sueldos = new javax.swing.JTable();
        total_sueldos = new javax.swing.JTextField();
        txttotalsueldos = new javax.swing.JLabel();
        btn_guardar = new javax.swing.JButton();
        combo_años = new javax.swing.JComboBox<>();
        btn_añadirfila_emp = new javax.swing.JButton();
        btn_quitarfila_emp = new javax.swing.JButton();
        scroll_ebitda1 = new javax.swing.JScrollPane();
        tabla_tasas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Empleados");
        setLocation(new java.awt.Point(0, 0));
        setSize(new java.awt.Dimension(900, 690));

        txtsueldos.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        txtsueldos.setForeground(new java.awt.Color(240, 255, 255));
        txtsueldos.setText("Sueldos");

        tabla_sueldos.setBackground(new java.awt.Color(255, 255, 255));
        tabla_sueldos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre y apellido", "Basico Jornada  Completa", "Comision  ", "Total Sueldo  ", "Antiguedad  ", "Ad/ Antiguedad  ", "Ad/Presentismo ", "Bruto  ", "Jubiliacion", "Obra Social ", "Ley 19032 ", "SEC ", "Total descuentos", "Total neto"
            }
        ));
        tabla_sueldos.setShowGrid(true);
        tabla_sueldos.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tabla_sueldosPropertyChange(evt);
            }
        });
        scroll_ebitda.setViewportView(tabla_sueldos);
        if (tabla_sueldos.getColumnModel().getColumnCount() > 0) {
            tabla_sueldos.getColumnModel().getColumn(0).setHeaderValue("Nombre y apellido");
            tabla_sueldos.getColumnModel().getColumn(1).setHeaderValue("Basico Jornada  Completa");
            tabla_sueldos.getColumnModel().getColumn(2).setHeaderValue("Comision  ");
            tabla_sueldos.getColumnModel().getColumn(3).setHeaderValue("Total Sueldo  ");
            tabla_sueldos.getColumnModel().getColumn(4).setHeaderValue("Antiguedad  ");
            tabla_sueldos.getColumnModel().getColumn(5).setHeaderValue("Ad/ Antiguedad  ");
            tabla_sueldos.getColumnModel().getColumn(6).setHeaderValue("Ad/Presentismo ");
            tabla_sueldos.getColumnModel().getColumn(7).setHeaderValue("Bruto  ");
            tabla_sueldos.getColumnModel().getColumn(8).setHeaderValue("Jubiliacion");
            tabla_sueldos.getColumnModel().getColumn(9).setHeaderValue("Obra Social ");
            tabla_sueldos.getColumnModel().getColumn(10).setHeaderValue("Ley 19032 ");
            tabla_sueldos.getColumnModel().getColumn(11).setHeaderValue("SEC ");
            tabla_sueldos.getColumnModel().getColumn(12).setHeaderValue("Total descuentos");
            tabla_sueldos.getColumnModel().getColumn(13).setHeaderValue("Total neto");
        }

        total_sueldos.setEditable(false);
        total_sueldos.setBackground(new java.awt.Color(255, 255, 255));

        txttotalsueldos.setBackground(new java.awt.Color(255, 255, 255));
        txttotalsueldos.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        txttotalsueldos.setForeground(new java.awt.Color(255, 255, 255));
        txttotalsueldos.setText("Total sueldos");

        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        combo_años.setMaximumRowCount(5);
        combo_años.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_añosItemStateChanged(evt);
            }
        });
        combo_años.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                combo_añosMouseClicked(evt);
            }
        });
        combo_años.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_añosActionPerformed(evt);
            }
        });

        btn_añadirfila_emp.setText("añadir fila");
        btn_añadirfila_emp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_añadirfila_empActionPerformed(evt);
            }
        });

        btn_quitarfila_emp.setText("quitar fila");
        btn_quitarfila_emp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quitarfila_empActionPerformed(evt);
            }
        });

        tabla_tasas.setBackground(new java.awt.Color(255, 255, 255));
        tabla_tasas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tasa Jubilación", "Tasa Obra Social", "Tasa Ley 19032", "Tasa SEC"
            }
        ));
        tabla_tasas.setShowGrid(true);
        tabla_tasas.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tabla_tasasPropertyChange(evt);
            }
        });
        scroll_ebitda1.setViewportView(tabla_tasas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(scroll_ebitda)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(txtsueldos, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(combo_años, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(total_sueldos, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttotalsueldos, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_añadirfila_emp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_quitarfila_emp)
                        .addGap(77, 77, 77)
                        .addComponent(btn_guardar)
                        .addGap(98, 98, 98))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scroll_ebitda1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(txttotalsueldos)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(total_sueldos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_años, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsueldos)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_añadirfila_emp)
                        .addComponent(btn_quitarfila_emp)
                        .addComponent(btn_guardar)))
                .addGap(40, 40, 40)
                .addComponent(scroll_ebitda1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(scroll_ebitda, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void combo_añosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_añosActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_combo_añosActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // TODO add your handling code here:  
        //exporta las tablas de sueldo a la carpeta
        try {
            for (int i = 1; i <= Principal.longevidad; i++) {
                if (combo_años.getSelectedIndex() + 1 == i) {
                    File sueldos = new File("C:\\Project evaluator\\sueldos\\sueldos " + i + ".txt");
                    Tabla.exportar(sueldos, tabla_sueldos);
                }
            }
            Tabla.exportar(tasas, tabla_tasas);
            JOptionPane.showMessageDialog(null, "datos guardados");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al guardar los datos");
        }


    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_añadirfila_empActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añadirfila_empActionPerformed
        // TODO add your handling code here
        //Añade filas a imp
        DefaultTableModel tblmodel = (DefaultTableModel) tabla_sueldos.getModel();
        Vector<?> rowData = null;
        tblmodel.addRow(rowData);
    }//GEN-LAST:event_btn_añadirfila_empActionPerformed

    private void btn_quitarfila_empActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quitarfila_empActionPerformed
        // TODO add your handling code here:
        //Quita filas a imp, si no se selecciona una fila,se elimina la ultima
        DefaultTableModel tblmodel = (DefaultTableModel) tabla_sueldos.getModel();
        if (tabla_sueldos.getSelectedRowCount() == 1) {
            tblmodel.removeRow(tabla_sueldos.getSelectedRow());
        } else {
            tblmodel.removeRow(tabla_sueldos.getRowCount() - 1);
        }
    }//GEN-LAST:event_btn_quitarfila_empActionPerformed

    private void combo_añosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo_añosMouseClicked
        // TODO add your handling code here:
        try {
            File sueldos = new File("C:\\Project evaluator\\sueldos\\sueldos " + (int) (combo_años.getSelectedIndex() + 1) + ".txt");
            Tabla.exportar(sueldos, tabla_sueldos);

        } catch (Exception e) {

        }

    }//GEN-LAST:event_combo_añosMouseClicked

    private void combo_añosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_añosItemStateChanged
        // TODO add your handling code here:

        //borra las filas de la tabla de la interfaz
        DefaultTableModel tblmodel = (DefaultTableModel) tabla_sueldos.getModel();
        tblmodel.setRowCount(0);

        //importa la nueva tabla
        importar_emp();
        if (tabla_sueldos.getRowCount() == 0) {
            tblmodel.setRowCount(30);
        }
    }//GEN-LAST:event_combo_añosItemStateChanged

    private void tabla_sueldosPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tabla_sueldosPropertyChange
        // TODO add your handling code here:

        try {
            for (int i = 1; i <= Principal.longevidad; i++) {
                if (combo_años.getSelectedIndex() + 1 == i) {
                    File sueldos = new File("C:\\Project evaluator\\sueldos\\sueldos " + i + ".txt");
                    Tabla.exportar(sueldos, tabla_sueldos);
                }
            }
        } catch (Exception e) {

        }

        total_sueldos();
        antiguedad();
        presentismo();
        bruto();
        Tabla.filas_defecto(tabla_tasas, 1);
        tasas(tas_jub);
        tasas(tas_ob);
        tasas(tas_ley);
        tasas(tas_sec);
        total_desc();
        total_neto();

    }//GEN-LAST:event_tabla_sueldosPropertyChange

    private void tabla_tasasPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tabla_tasasPropertyChange
        // TODO add your handling code here:
        Tabla.filas_defecto(tabla_tasas, 1);
        if (imp_tas == true) {
            Tabla.exportar(tasas, tabla_tasas);
        }
        tasas(tas_jub);
        tasas(tas_ob);
        tasas(tas_ley);
        tasas(tas_sec);
    }//GEN-LAST:event_tabla_tasasPropertyChange

    public void inicializar_combo() {

        for (int i = 1; i <= Principal.longevidad; i++) {
            combo_años.addItem("Año " + i);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Empleados.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Empleados.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Empleados.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Empleados.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Empleados().setVisible(true);
            }
        });

        //añade filas a la tabla si no tiene ninguna
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_añadirfila_emp;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_quitarfila_emp;
    private javax.swing.JComboBox<String> combo_años;
    private javax.swing.JScrollPane scroll_ebitda;
    private javax.swing.JScrollPane scroll_ebitda1;
    private javax.swing.JTable tabla_sueldos;
    private javax.swing.JTable tabla_tasas;
    private javax.swing.JTextField total_sueldos;
    private javax.swing.JLabel txtsueldos;
    private javax.swing.JLabel txttotalsueldos;
    // End of variables declaration//GEN-END:variables
}
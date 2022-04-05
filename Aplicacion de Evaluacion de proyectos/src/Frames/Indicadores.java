/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import aplicacion.de.evaluacion.de.proyectos.ProjectEvaluator;
import java.awt.Color;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.lang.Object;
import org.apache.poi.ss.formula.functions.Irr;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author Enzo
 */
public class Indicadores extends javax.swing.JFrame {

    /**
     * Creates new form Indicadores
     */
    private File indicadores = new File("C:\\Project evaluator\\indicadores.txt");
    private File interes = new File("C:\\Project evaluator\\interes.txt");
    private ArrayList van = new ArrayList();
    private ArrayList van_r = new ArrayList();
    private ArrayList ivan = new ArrayList();
    private ArrayList ivan_r = new ArrayList();
    private ArrayList tir = new ArrayList();
    private ArrayList tir_r = new ArrayList();
    private double tasa_interes;
    private EBITDA ebitda;
    private IngVsGas ingvsgas;

    public Indicadores() {
    }

    public Indicadores(EBITDA ebitda, IngVsGas ingvsgas) {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //determina el color del fondo
        Color c = new Color(56, 80, 113);
        getContentPane().setBackground(c);
        this.ebitda = ebitda;
        this.ingvsgas = ingvsgas;
    }

    public JTable getTabla_indicadores() {
        return tabla_indicadores;
    }

    public File getIndicadores() {
        return indicadores;
    }

    public File getInteres() {
        return interes;
    }

    public ArrayList getVan() {
        return van;
    }

    public ArrayList getVan_r() {
        return van_r;
    }

    public void setear_interes() {
        try {
            tasa_interes = Double.parseDouble(jtf_interes.getText());
        } catch (NumberFormatException e) {

        }
    }

    public JTextField getJtf_interes() {
        return jtf_interes;
    }

    public void calculo_van() {
        double acum = 0;
        van.clear();

        for (int t = 1; t <= Principal.longevidad; t++) {
            acum = acum + Double.parseDouble(String.valueOf(ebitda.getArr_total().get(t))) / Math.pow(1 + (tasa_interes / 100), t) - IngVsGas.inv;
            van.add(acum);
        }
        van.add(0, "VAN (Sin Riesgo)");
        if (ProjectEvaluator.Tabla.get_modelo(tabla_indicadores).getRowCount() >= 1) {
            ProjectEvaluator.Tabla.get_modelo(tabla_indicadores).removeRow(0);
            ProjectEvaluator.Tabla.get_modelo(tabla_indicadores).insertRow(0, van.toArray());
        } else {
            ProjectEvaluator.Tabla.get_modelo(tabla_indicadores).addRow(van.toArray());
        }

    }

    public void calculo_van_r() {
        double acum = 0;
        van_r.clear();
        for (int t = 1; t <= Principal.longevidad; t++) {
            acum = acum + Double.parseDouble(String.valueOf(ebitda.getArr_r_neto().get(t))) / Math.pow(1 + (tasa_interes / 100), t) - IngVsGas.inv;
            van_r.add(acum);
        }
        van_r.add(0, "VAN (Con Riesgo)");
        if (ProjectEvaluator.Tabla.get_modelo(tabla_indicadores).getRowCount() >= 2) {
            ProjectEvaluator.Tabla.get_modelo(tabla_indicadores).removeRow(1);
            ProjectEvaluator.Tabla.get_modelo(tabla_indicadores).insertRow(1, van_r.toArray());
        } else {
            ProjectEvaluator.Tabla.get_modelo(tabla_indicadores).addRow(van_r.toArray());
        }

    }

    public void calculo_ivan() {
        ivan.clear();
        for (int t = 1; t <= Principal.longevidad; t++) {
            ivan.add(Double.parseDouble(String.valueOf(van.get(t))) / IngVsGas.inv);
        }

        ivan.add(0, "IVAN (Sin Riesgo)");
        if (ProjectEvaluator.Tabla.get_modelo(tabla_indicadores).getRowCount() >= 3) {
            ProjectEvaluator.Tabla.get_modelo(tabla_indicadores).removeRow(2);
            ProjectEvaluator.Tabla.get_modelo(tabla_indicadores).insertRow(2, ivan.toArray());
        } else {
            ProjectEvaluator.Tabla.get_modelo(tabla_indicadores).addRow(ivan.toArray());
        }

    }

    public void calculo_ivan_r() {
        ivan_r.clear();
        for (int t = 1; t <= Principal.longevidad; t++) {
            ivan_r.add(Double.parseDouble(String.valueOf(van_r.get(t))) / IngVsGas.inv);
        }
        ivan_r.add(0, "IVAN (Con Riesgo)");
        if (ProjectEvaluator.Tabla.get_modelo(tabla_indicadores).getRowCount() >= 4) {
            ProjectEvaluator.Tabla.get_modelo(tabla_indicadores).removeRow(3);
            ProjectEvaluator.Tabla.get_modelo(tabla_indicadores).insertRow(3, ivan_r.toArray());
        } else {
            ProjectEvaluator.Tabla.get_modelo(tabla_indicadores).addRow(ivan_r.toArray());
        }
    }

    public void calculo_TIR() {
        tir.clear();
        double[] flujos = new double[ebitda.getArr_total().size()];
        //se inserta la inversion en los flujos
        flujos[0] = Double.parseDouble(String.valueOf(ingvsgas.getJtf_inv().getText())) * -1;
        for (int j = 1; j <= Principal.longevidad; j++) {
            for (int i = 1; i <= j; i++) {
                flujos[i] = Double.parseDouble(String.valueOf(ebitda.getArr_total().get(i)));
                  System.out.println(flujos[i]);
            }
            tir.add(Irr.irr(flujos, 0));
        }
        tir.add(0, "TIR (Sin Riesgo)");
        if (ProjectEvaluator.Tabla.get_modelo(tabla_indicadores).getRowCount() >= 5) {
            ProjectEvaluator.Tabla.get_modelo(tabla_indicadores).removeRow(4);
            ProjectEvaluator.Tabla.get_modelo(tabla_indicadores).insertRow(4, tir.toArray());
        } else {
            ProjectEvaluator.Tabla.get_modelo(tabla_indicadores).addRow(tir.toArray());
        }
    }

    public void calculo_TIR_r() {
        tir_r.clear();
        double[] flujos = new double[ebitda.getArr_r_neto().size()];
        //se inserta la inversion en los flujos
        flujos[0] = Double.parseDouble(String.valueOf(ingvsgas.getJtf_inv().getText())) * -1;
        for (int j = 1; j <= Principal.longevidad; j++) {
            for (int i = 1; i <= j; i++) {
                flujos[i] = Double.parseDouble(String.valueOf(ebitda.getArr_r_neto().get(i)));
              
            }
            tir_r.add(Irr.irr(flujos, 0));
        }
        tir_r.add(0, "TIR (Con Riesgo)");
        if (ProjectEvaluator.Tabla.get_modelo(tabla_indicadores).getRowCount() >= 6) {
            ProjectEvaluator.Tabla.get_modelo(tabla_indicadores).removeRow(5);
            ProjectEvaluator.Tabla.get_modelo(tabla_indicadores).insertRow(5, tir_r.toArray());
        } else {
            ProjectEvaluator.Tabla.get_modelo(tabla_indicadores).addRow(tir_r.toArray());
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

        txtindicadores = new javax.swing.JLabel();
        scroll_indicadores = new javax.swing.JScrollPane();
        tabla_indicadores = new javax.swing.JTable();
        btn_añadirfila_ind = new javax.swing.JButton();
        btn_quitarfila_ind = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        txtinteres = new javax.swing.JLabel();
        jtf_interes = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Indicadores");
        setBackground(new java.awt.Color(240, 255, 255));
        setSize(new java.awt.Dimension(900, 690));

        txtindicadores.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        txtindicadores.setForeground(new java.awt.Color(240, 255, 255));
        txtindicadores.setText("Indicadores");

        tabla_indicadores.setBackground(new java.awt.Color(255, 255, 255));
        tabla_indicadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Indicador"
            }
        ));
        tabla_indicadores.setShowGrid(true);
        scroll_indicadores.setViewportView(tabla_indicadores);

        btn_añadirfila_ind.setText("añadir fila");
        btn_añadirfila_ind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_añadirfila_indActionPerformed(evt);
            }
        });

        btn_quitarfila_ind.setText("quitar fila");
        btn_quitarfila_ind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quitarfila_indActionPerformed(evt);
            }
        });

        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        txtinteres.setBackground(new java.awt.Color(255, 255, 255));
        txtinteres.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        txtinteres.setForeground(new java.awt.Color(255, 255, 255));
        txtinteres.setText("Tasa de interés");

        jtf_interes.setBackground(new java.awt.Color(255, 255, 255));
        jtf_interes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_interesActionPerformed(evt);
            }
        });
        jtf_interes.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtf_interesPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtinteres)
                            .addComponent(jtf_interes, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scroll_indicadores)
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtindicadores, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(288, 288, 288)
                        .addComponent(btn_añadirfila_ind)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_quitarfila_ind)
                        .addGap(87, 87, 87)
                        .addComponent(btn_guardar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_guardar)
                    .addComponent(btn_añadirfila_ind)
                    .addComponent(btn_quitarfila_ind)
                    .addComponent(txtindicadores, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtinteres)
                .addGap(1, 1, 1)
                .addComponent(jtf_interes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll_indicadores, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btn_añadirfila_indActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añadirfila_indActionPerformed
        // TODO add your handling code here
        //Añade filas a ingresos
        Vector<?> rowData = null;
        ProjectEvaluator.Tabla.get_modelo(tabla_indicadores).addRow(rowData);
    }//GEN-LAST:event_btn_añadirfila_indActionPerformed

    private void btn_quitarfila_indActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quitarfila_indActionPerformed
        // TODO add your handling code here:
        //Quita filas a idicadores, si no se selecciona una fila,se elimina la ultima

        if (tabla_indicadores.getSelectedRowCount() >= 1) {
            do {
                ProjectEvaluator.Tabla.get_modelo(tabla_indicadores).removeRow(tabla_indicadores.getSelectedRow());
            } while (tabla_indicadores.getSelectedRowCount() >= 1);
        } else {
            ProjectEvaluator.Tabla.get_modelo(tabla_indicadores).removeRow(tabla_indicadores.getRowCount() - 1);
        }
    }//GEN-LAST:event_btn_quitarfila_indActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // TODO add your handling code here:

        // paso por parametro para el método exportar
        try {
            ProjectEvaluator.Tabla.exportar(indicadores, tabla_indicadores);
            JOptionPane.showMessageDialog(null, "datos guardados");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al guardar los datos");
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void jtf_interesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_interesActionPerformed
        // TODO add your handling code here:
        setear_interes();
        calculo_van();
        calculo_van_r();
        calculo_ivan();
        calculo_ivan_r();
        ProjectEvaluator.JtextField.exportar_jtf(interes, jtf_interes);
    }//GEN-LAST:event_jtf_interesActionPerformed

    private void jtf_interesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtf_interesPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_interesPropertyChange

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
            java.util.logging.Logger.getLogger(Indicadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Indicadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Indicadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Indicadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Indicadores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_añadirfila_ind;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_quitarfila_ind;
    private javax.swing.JTextField jtf_interes;
    private javax.swing.JScrollPane scroll_indicadores;
    private javax.swing.JTable tabla_indicadores;
    private javax.swing.JLabel txtindicadores;
    private javax.swing.JLabel txtinteres;
    // End of variables declaration//GEN-END:variables
}

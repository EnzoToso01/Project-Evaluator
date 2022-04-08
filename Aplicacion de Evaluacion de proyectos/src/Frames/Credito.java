/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import aplicacion.de.evaluacion.de.proyectos.ProjectEvaluator;
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
public class Credito extends javax.swing.JFrame {

    /**
     * Creates new form Crédito
     */
    //declara el archivo a importar o exportar por los métodos de Tabla
    private File pagcredito = new File("C:\\Project evaluator\\credito.txt");
    private File datcredito = new File("C:\\Project evaluator\\datos credito.txt");

    public Credito() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //determina el color del fondo
        Color c = new Color(56, 80, 113);
        getContentPane().setBackground(c);

    }

    public void filas_datos(JTable tabladatcred, JTable tablapagcred) {
        //inicializa los datos de las filas de la tabla
        if (tablapagcred.getRowCount() < 1) {
            ProjectEvaluator.Tabla.filas_defecto(tablapagcred, 15);
        }
        if (tabladatcred.getRowCount() < 1) {

            DefaultTableModel tblmodel = (DefaultTableModel) tabla_datcredito.getModel();
            String dato1[] = {"Monto del crédito"};
            String dato2[] = {"Tasa de interés (Anual)"};
            String dato3[] = {"Número de pagos (Mensuales)"};
            String dato4[] = {"Pago (Mensual)"};

            tblmodel.addRow(dato1);
            tblmodel.addRow(dato2);
            tblmodel.addRow(dato3);
            tblmodel.addRow(dato4);

            ProjectEvaluator.Tabla.filas_defecto(tabladatcred, 10);
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

        txtcredito = new javax.swing.JLabel();
        scrollcredito = new javax.swing.JScrollPane();
        tabla_pagcredito = new javax.swing.JTable();
        btn_añadirfila_cred = new javax.swing.JButton();
        btn_quitarfila_cred = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        scrolldatcredito = new javax.swing.JScrollPane();
        tabla_datcredito = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Crédito");
        setLocation(new java.awt.Point(0, 0));
        setSize(new java.awt.Dimension(900, 690));

        txtcredito.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txtcredito.setForeground(new java.awt.Color(240, 255, 255));
        txtcredito.setText("Crédito");

        scrollcredito.setBackground(new java.awt.Color(255, 255, 255));

        tabla_pagcredito.setBackground(new java.awt.Color(255, 255, 255));
        tabla_pagcredito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° Pago", "Pago interés", "Pago Capital", "Saldo"
            }
        ));
        tabla_pagcredito.setShowGrid(true);
        scrollcredito.setViewportView(tabla_pagcredito);
        if (tabla_pagcredito.getColumnModel().getColumnCount() > 0) {
            tabla_pagcredito.getColumnModel().getColumn(1).setHeaderValue("Pago interés");
            tabla_pagcredito.getColumnModel().getColumn(2).setHeaderValue("Pago Capital");
            tabla_pagcredito.getColumnModel().getColumn(3).setHeaderValue("Saldo");
        }

        btn_añadirfila_cred.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_añadirfila_cred.setText("añadir fila");
        btn_añadirfila_cred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_añadirfila_credActionPerformed(evt);
            }
        });

        btn_quitarfila_cred.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_quitarfila_cred.setText("quitar fila");
        btn_quitarfila_cred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quitarfila_credActionPerformed(evt);
            }
        });

        btn_guardar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        scrolldatcredito.setBackground(new java.awt.Color(255, 255, 255));

        tabla_datcredito.setBackground(new java.awt.Color(255, 255, 255));
        tabla_datcredito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dato", "Valor"
            }
        ));
        tabla_datcredito.setShowGrid(true);
        scrolldatcredito.setViewportView(tabla_datcredito);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtcredito)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 389, Short.MAX_VALUE)
                        .addComponent(btn_añadirfila_cred)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_quitarfila_cred)
                        .addGap(87, 87, 87)
                        .addComponent(btn_guardar)
                        .addGap(80, 80, 80))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(scrollcredito, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
                            .addComponent(scrolldatcredito, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(99, 99, 99))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_guardar)
                        .addComponent(btn_añadirfila_cred)
                        .addComponent(btn_quitarfila_cred))
                    .addComponent(txtcredito))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollcredito, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addGap(49, 49, 49)
                .addComponent(scrolldatcredito, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addGap(85, 85, 85))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public File getPagcredito() {
        return pagcredito;
    }

    public File getDatcredito() {
        return datcredito;
    }


    private void btn_añadirfila_credActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añadirfila_credActionPerformed
        // TODO add your handling code here
        //Añade filas a credito

        Vector<?> rowData = null;
        ProjectEvaluator.Tabla.get_modelo(tabla_pagcredito).addRow(rowData);
    }//GEN-LAST:event_btn_añadirfila_credActionPerformed

    private void btn_quitarfila_credActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quitarfila_credActionPerformed
        // TODO add your handling code here:
        //Quita filas a idicadores, si no se selecciona una fila,se elimina la ultima

        if (tabla_pagcredito.getSelectedRowCount() >= 1) {
            do {
                ProjectEvaluator.Tabla.get_modelo(tabla_pagcredito).removeRow(tabla_pagcredito.getSelectedRow());
            } while (tabla_pagcredito.getSelectedRowCount() >= 1);

        } else {
            ProjectEvaluator.Tabla.get_modelo(tabla_pagcredito).removeRow(tabla_pagcredito.getRowCount() - 1);
        }
    }//GEN-LAST:event_btn_quitarfila_credActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // TODO add your handling code here:
        try {
            File pagcredito = new File("C:\\Project evaluator\\credito.txt");
            File datcredito = new File("C:\\Project evaluator\\datos credito.txt");
            //Declaro la tabla para pasarla por parámetro a los métodos de Tabla
            JTable tablapagcred = getTabla_pagcredito();
            JTable tabladatcred = getTabla_datcredito();
            ProjectEvaluator.Tabla.exportar(pagcredito, tablapagcred);
            ProjectEvaluator.Tabla.exportar(datcredito, tabladatcred);
            JOptionPane.showMessageDialog(null, "datos guardados");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al guardar los datos");
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    public JTable getTabla_datcredito() {
        return tabla_datcredito;
    }

    public JTable getTabla_pagcredito() {
        return tabla_pagcredito;
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
            java.util.logging.Logger.getLogger(Credito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Credito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Credito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Credito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Credito().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_añadirfila_cred;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_quitarfila_cred;
    private javax.swing.JScrollPane scrollcredito;
    private javax.swing.JScrollPane scrolldatcredito;
    private javax.swing.JTable tabla_datcredito;
    private javax.swing.JTable tabla_pagcredito;
    private javax.swing.JLabel txtcredito;
    // End of variables declaration//GEN-END:variables
}

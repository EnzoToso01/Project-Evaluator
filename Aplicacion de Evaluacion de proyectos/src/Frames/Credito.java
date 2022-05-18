package Frames;

import Clases.Utilidad;
import java.awt.Color;
import java.io.File;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Enzo
 */
public class Credito extends javax.swing.JFrame {

    //declara el archivo a importar o exportar por los métodos de Tabla
    private File pagcredito = new File("C:\\Project evaluator\\credito.txt");
    private File datcredito = new File("C:\\Project evaluator\\datos credito.txt");

    public Credito() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //determina el color del fondo
        Color a = new Color(40, 44, 52);
        getContentPane().setBackground(a);
        Color b = new Color(26, 29, 34);
        tabla_datcredito.getTableHeader().setBackground(b);
        tabla_pagcredito.getTableHeader().setBackground(b);
    }

    //Código autogenerado
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtcredito = new javax.swing.JLabel();
        scrollcredito = new javax.swing.JScrollPane();
        tabla_pagcredito = new javax.swing.JTable();
        scrolldatcredito = new javax.swing.JScrollPane();
        tabla_datcredito = new javax.swing.JTable();
        txtdatcredito = new javax.swing.JLabel();
        btn_añadirfila_cred = new javax.swing.JButton();
        btn_quitarfila_cred = new javax.swing.JButton();
        btn_añadirfila_datcred = new javax.swing.JButton();
        btn_quitarfila_datcred = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Crédito");
        setLocation(new java.awt.Point(0, 0));
        setSize(new java.awt.Dimension(900, 690));

        txtcredito.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txtcredito.setForeground(new java.awt.Color(240, 255, 255));
        txtcredito.setText("Crédito");

        scrollcredito.setBackground(new java.awt.Color(255, 255, 255));

        tabla_pagcredito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° Pago", "Pago interés", "Pago Capital", "Saldo"
            }
        ));
        tabla_pagcredito.setFocusable(false);
        tabla_pagcredito.setShowGrid(true);
        scrollcredito.setViewportView(tabla_pagcredito);
        if (tabla_pagcredito.getColumnModel().getColumnCount() > 0) {
            tabla_pagcredito.getColumnModel().getColumn(1).setHeaderValue("Pago interés");
            tabla_pagcredito.getColumnModel().getColumn(2).setHeaderValue("Pago Capital");
            tabla_pagcredito.getColumnModel().getColumn(3).setHeaderValue("Saldo");
        }

        scrolldatcredito.setBackground(new java.awt.Color(255, 255, 255));

        tabla_datcredito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dato", "Valor"
            }
        ));
        tabla_datcredito.setFocusable(false);
        tabla_datcredito.setShowGrid(true);
        scrolldatcredito.setViewportView(tabla_datcredito);

        txtdatcredito.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txtdatcredito.setForeground(new java.awt.Color(240, 255, 255));
        txtdatcredito.setText("Datos de Crédito");

        btn_añadirfila_cred.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_añadirfila_cred.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar-fila.png"))); // NOI18N
        btn_añadirfila_cred.setAutoscrolls(true);
        btn_añadirfila_cred.setDefaultCapable(false);
        btn_añadirfila_cred.setFocusable(false);
        btn_añadirfila_cred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_añadirfila_credActionPerformed(evt);
            }
        });

        btn_quitarfila_cred.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_quitarfila_cred.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/quitar-fila.png"))); // NOI18N
        btn_quitarfila_cred.setDefaultCapable(false);
        btn_quitarfila_cred.setFocusable(false);
        btn_quitarfila_cred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quitarfila_credActionPerformed(evt);
            }
        });

        btn_añadirfila_datcred.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_añadirfila_datcred.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar-fila.png"))); // NOI18N
        btn_añadirfila_datcred.setAutoscrolls(true);
        btn_añadirfila_datcred.setDefaultCapable(false);
        btn_añadirfila_datcred.setFocusable(false);
        btn_añadirfila_datcred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_añadirfila_datcredActionPerformed(evt);
            }
        });

        btn_quitarfila_datcred.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_quitarfila_datcred.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/quitar-fila.png"))); // NOI18N
        btn_quitarfila_datcred.setDefaultCapable(false);
        btn_quitarfila_datcred.setFocusable(false);
        btn_quitarfila_datcred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quitarfila_datcredActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtdatcredito, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_añadirfila_datcred, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_quitarfila_datcred, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtcredito, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_añadirfila_cred, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_quitarfila_cred, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollcredito, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
                    .addComponent(scrolldatcredito))
                .addGap(99, 99, 99))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtcredito)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn_añadirfila_cred)
                        .addComponent(btn_quitarfila_cred, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollcredito, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtdatcredito)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn_añadirfila_datcred)
                        .addComponent(btn_quitarfila_datcred, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(18, 18, 18)
                .addComponent(scrolldatcredito, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Getters
    public JLabel getTxtcredito() {
        return txtcredito;
    }

    public JLabel getTxtdatcredito() {
        return txtdatcredito;
    }

    public File getPagcredito() {
        return pagcredito;
    }

    public File getDatcredito() {
        return datcredito;
    }

    public JTable getTabla_datcredito() {
        return tabla_datcredito;
    }

    public JTable getTabla_pagcredito() {
        return tabla_pagcredito;
    }

    //Métodos
    public void filas_datos(JTable tabladatcred, JTable tablapagcred) {
        //inicializa los datos de las filas de la tabla
        if (tablapagcred.getRowCount() < 1) {
            Utilidad.Tabla.filas_defecto(tablapagcred, 15);
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
            Utilidad.Tabla.filas_defecto(tabladatcred, 10);
        }
    }

    //Eventos
    private void btn_añadirfila_credActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añadirfila_credActionPerformed
        // TODO add your handling code here
        //Añade filas a cred
        Vector<?> rowData = null;
        Utilidad.Tabla.get_modelo(tabla_pagcredito).addRow(rowData);
    }//GEN-LAST:event_btn_añadirfila_credActionPerformed

    private void btn_quitarfila_credActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quitarfila_credActionPerformed
        // TODO add your handling code here:
        //Quita filas a cred, si no se selecciona una fila,se elimina la ultima
        if (tabla_pagcredito.getSelectedRowCount() >= 1) {
            do {
                Utilidad.Tabla.get_modelo(tabla_pagcredito).removeRow(tabla_pagcredito.getSelectedRow());
            } while (tabla_pagcredito.getSelectedRowCount() >= 1);
        } else {
            Utilidad.Tabla.get_modelo(tabla_pagcredito).removeRow(tabla_pagcredito.getRowCount() - 1);
        }
    }//GEN-LAST:event_btn_quitarfila_credActionPerformed

    private void btn_añadirfila_datcredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añadirfila_datcredActionPerformed
        // TODO add your handling code here:
        //Añade filas a datcred
        Vector<?> rowData = null;
        Utilidad.Tabla.get_modelo(tabla_datcredito).addRow(rowData);
    }//GEN-LAST:event_btn_añadirfila_datcredActionPerformed

    private void btn_quitarfila_datcredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quitarfila_datcredActionPerformed
        // TODO add your handling code here:
        //Quita filas a datcred, si no se selecciona una fila,se elimina la ultima
        if (tabla_datcredito.getSelectedRowCount() >= 1) {
            do {
                Utilidad.Tabla.get_modelo(tabla_datcredito).removeRow(tabla_pagcredito.getSelectedRow());
            } while (tabla_pagcredito.getSelectedRowCount() >= 1);
        } else {
            Utilidad.Tabla.get_modelo(tabla_datcredito).removeRow(tabla_datcredito.getRowCount() - 1);
        }

    }//GEN-LAST:event_btn_quitarfila_datcredActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_añadirfila_cred;
    private javax.swing.JButton btn_añadirfila_datcred;
    private javax.swing.JButton btn_quitarfila_cred;
    private javax.swing.JButton btn_quitarfila_datcred;
    private javax.swing.JScrollPane scrollcredito;
    private javax.swing.JScrollPane scrolldatcredito;
    private javax.swing.JTable tabla_datcredito;
    private javax.swing.JTable tabla_pagcredito;
    private javax.swing.JLabel txtcredito;
    private javax.swing.JLabel txtdatcredito;
    // End of variables declaration//GEN-END:variables
}

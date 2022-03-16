/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import aplicacion.de.evaluacion.de.proyectos.Tabla;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Enzo
 */
public class EBITDA extends javax.swing.JFrame {

    /**
     * Creates new form EBITDA
     */
    private File ebitda = new File("C:\\Project evaluator\\ebitda.txt");
    private ArrayList<Double> ingresos = new ArrayList();
    private ArrayList<Double> egresos = new ArrayList();
    private ArrayList Arr_ebitda = new ArrayList();
    private ArrayList Arr_ing_br = new ArrayList();
    private ArrayList Arr_intereses = new ArrayList();
    private ArrayList Arr_ganancias = new ArrayList();
    private ArrayList aux = new ArrayList();

    public EBITDA() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //determina el color del fondo
        Color c = new Color(56, 80, 113);
        getContentPane().setBackground(c);

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
            java.util.logging.Logger.getLogger(EBITDA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EBITDA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EBITDA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EBITDA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EBITDA().setVisible(true);

            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtebitda = new javax.swing.JLabel();
        scroll_ebitda = new javax.swing.JScrollPane();
        tabla_EBITDA = new javax.swing.JTable();
        btn_añadirfila_ebi = new javax.swing.JButton();
        btn_quitarfila_ebi = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EBITDA");
        setBackground(new java.awt.Color(240, 255, 255));
        setLocation(new java.awt.Point(0, 0));
        setSize(new java.awt.Dimension(900, 690));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        txtebitda.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        txtebitda.setForeground(new java.awt.Color(240, 255, 255));
        txtebitda.setText("EBITDA");

        tabla_EBITDA.setBackground(new java.awt.Color(255, 255, 255));
        tabla_EBITDA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Conceptos y Descripciones"
            }
        ));
        tabla_EBITDA.setShowGrid(true);
        tabla_EBITDA.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                tabla_EBITDAMouseMoved(evt);
            }
        });
        tabla_EBITDA.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tabla_EBITDAFocusGained(evt);
            }
        });
        tabla_EBITDA.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tabla_EBITDAPropertyChange(evt);
            }
        });
        scroll_ebitda.setViewportView(tabla_EBITDA);

        btn_añadirfila_ebi.setText("añadir fila");
        btn_añadirfila_ebi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_añadirfila_ebiActionPerformed(evt);
            }
        });

        btn_quitarfila_ebi.setText("quitar fila");
        btn_quitarfila_ebi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quitarfila_ebiActionPerformed(evt);
            }
        });

        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txtebitda, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(312, 312, 312)
                .addComponent(btn_añadirfila_ebi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_quitarfila_ebi)
                .addGap(87, 87, 87)
                .addComponent(btn_guardar)
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(scroll_ebitda, javax.swing.GroupLayout.DEFAULT_SIZE, 857, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtebitda, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_guardar)
                    .addComponent(btn_añadirfila_ebi)
                    .addComponent(btn_quitarfila_ebi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll_ebitda, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setIngresos(ArrayList ingresos) {

        ingresos.set(0, "Ingresos");
        System.out.println(ingresos);
        if (Tabla.get_modelo(tabla_EBITDA).getRowCount() > 0) {
            Tabla.get_modelo(tabla_EBITDA).insertRow(0, ingresos.toArray());
        } else {
            Tabla.get_modelo(tabla_EBITDA).addRow(ingresos.toArray());
        }
        ingresos.remove(0);
        this.ingresos = ingresos;

    }

    public void setEgresos(ArrayList egresos) {
        egresos.set(0, "Egresos");
        this.egresos.clear();
        if (Tabla.get_modelo(tabla_EBITDA).getRowCount() > 1) {
            Tabla.get_modelo(tabla_EBITDA).insertRow(1, egresos.toArray());
        } else {
            Tabla.get_modelo(tabla_EBITDA).addRow(egresos.toArray());
        }
        egresos.remove(0);
        this.egresos = egresos;
    }

    public File getEbitda() {
        return ebitda;
    }

    public JTable getTabla_ebitda() {
        return tabla_EBITDA;
    }
    
    

    public void filas_datos_ebitda() {

    }

    public void calculo_ebitda() {
       
        if (Arr_ebitda.isEmpty() == true) {
            Arr_ebitda.add(0, "EBITDA");
            for (int i = 1; i < Principal.longevidad; i++) {
                Arr_ebitda.add(ingresos.get(i) - egresos.get(i));
            }
        } else {
            for (int i = 1; i < Principal.longevidad; i++) {
                Arr_ebitda.set(i, ingresos.get(i) - egresos.get(i));
            }
        }

        if (tabla_EBITDA.getRowCount() > 2) {
            Tabla.get_modelo(tabla_EBITDA).removeRow(2);
            Tabla.get_modelo(tabla_EBITDA).insertRow(2, Arr_ebitda.toArray());
        } else {
            Tabla.get_modelo(tabla_EBITDA).addRow(Arr_ebitda.toArray());
        }
    }

    public void calculo_ing_brutos() {

        System.out.println(Impuestos.ing_b);
        if (Arr_ing_br.isEmpty() == true) {
            Arr_ing_br.add(0, "Ingresos Brutos");
        }
        for (int i = 0; i < Principal.longevidad; i++) {
            Arr_ing_br.add(ingresos.get(i) * Impuestos.ing_b);
        }

        if (tabla_EBITDA.getRowCount() > 3) {
            Tabla.get_modelo(tabla_EBITDA).removeRow(3);
            Tabla.get_modelo(tabla_EBITDA).insertRow(3, Arr_ing_br.toArray());
        } else {
            Tabla.get_modelo(tabla_EBITDA).addRow(Arr_ing_br.toArray());
        }

    }

    public void calculo_intereses() {

        Arr_intereses.add(0, "Intereses Préstamo");
        if (tabla_EBITDA.getRowCount() > 5) {
            Tabla.get_modelo(tabla_EBITDA).removeRow(5);
            Tabla.get_modelo(tabla_EBITDA).insertRow(5, Arr_intereses.toArray());
        } else {
            Tabla.get_modelo(tabla_EBITDA).addRow(Arr_intereses.toArray());
        }

    }

    public void calculo_ganancias() {

        Arr_ganancias.add(0, "Ganancias 35%");

        for (int i = 0; i < Principal.longevidad; i++) {

        }

        if (tabla_EBITDA.getRowCount() > 9) {
            Tabla.get_modelo(tabla_EBITDA).removeRow(9);
            Tabla.get_modelo(tabla_EBITDA).insertRow(9, Arr_ganancias.toArray());
        } else {
            Tabla.get_modelo(tabla_EBITDA).addRow(Arr_ganancias.toArray());
        }

    }


    private void btn_añadirfila_ebiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añadirfila_ebiActionPerformed
        // TODO add your handling code here
        //Añade filas a ebitda
        Vector<?> rowData = null;
        Tabla.get_modelo(tabla_EBITDA).addRow(rowData);
    }//GEN-LAST:event_btn_añadirfila_ebiActionPerformed

    private void btn_quitarfila_ebiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quitarfila_ebiActionPerformed
        // TODO add your handling code here:
        //Quita filas a idicadores, si no se selecciona una fila,se elimina la ultima

        if (tabla_EBITDA.getSelectedRowCount() == 1) {
            Tabla.get_modelo(tabla_EBITDA).removeRow(tabla_EBITDA.getSelectedRow());
        } else {
            Tabla.get_modelo(tabla_EBITDA).removeRow(tabla_EBITDA.getRowCount() - 1);
        }
    }//GEN-LAST:event_btn_quitarfila_ebiActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // TODO add your handling code here:
        try {
            Tabla.exportar(ebitda, tabla_EBITDA);
            JOptionPane.showMessageDialog(null, "datos guardados");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al guardar los datos");
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void tabla_EBITDAFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabla_EBITDAFocusGained
        // TODO add your handling code here:


    }//GEN-LAST:event_tabla_EBITDAFocusGained

    private void tabla_EBITDAPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tabla_EBITDAPropertyChange
        // TODO add your handling code here:


    }//GEN-LAST:event_tabla_EBITDAPropertyChange

    private void tabla_EBITDAMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_EBITDAMouseMoved
        // TODO add your handling code here:


    }//GEN-LAST:event_tabla_EBITDAMouseMoved

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        // TODO add your handling code here:

    }//GEN-LAST:event_formMouseMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_añadirfila_ebi;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_quitarfila_ebi;
    private javax.swing.JScrollPane scroll_ebitda;
    private javax.swing.JTable tabla_EBITDA;
    private javax.swing.JLabel txtebitda;
    // End of variables declaration//GEN-END:variables

}

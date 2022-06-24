package Frames;

import Clases.Utilidad;
import java.awt.Color;
import java.io.File;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author Enzo
 */
public class Riesgo extends javax.swing.JFrame {

    private File riesgos;
    private double prob;
    private double impacto;
    private double exposicion;
    private double valor;
    private boolean imp;

    public Riesgo() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //determina el color del fondo
        getContentPane().setBackground(ProjectEvaluator.fondo);
        imp = false;
    }

    //Código autogenerado
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll_riesg = new javax.swing.JScrollPane();
        tabla_riesgos = new javax.swing.JTable();
        txtriesgos = new javax.swing.JLabel();
        btn_añadirfila_riesg = new javax.swing.JButton();
        btn_quitarfila_riesg = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusable(false);
        setLocation(new java.awt.Point(0, 0));
        setSize(new java.awt.Dimension(900, 690));

        tabla_riesgos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Factor de Riesgo", "Categoría", "Probabilidad", "Impacto", "Exposición", "Efecto", "Valor", "Respuesta", "Valor Riesgo", "Contingencia", "Responsable", "Fecha Mitigación"
            }
        ));
        tabla_riesgos.setFocusable(false);
        tabla_riesgos.setShowGrid(true);
        tabla_riesgos.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tabla_riesgosPropertyChange(evt);
            }
        });
        scroll_riesg.setViewportView(tabla_riesgos);

        txtriesgos.setBackground(new java.awt.Color(56, 80, 113));
        txtriesgos.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txtriesgos.setForeground(new java.awt.Color(240, 255, 255));
        txtriesgos.setText("Riesgos");

        btn_añadirfila_riesg.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_añadirfila_riesg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_agregar_fila.png"))); // NOI18N
        btn_añadirfila_riesg.setAutoscrolls(true);
        btn_añadirfila_riesg.setDefaultCapable(false);
        btn_añadirfila_riesg.setFocusable(false);
        btn_añadirfila_riesg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_añadirfila_riesgActionPerformed(evt);
            }
        });

        btn_quitarfila_riesg.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_quitarfila_riesg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_quitar_fila.png"))); // NOI18N
        btn_quitarfila_riesg.setDefaultCapable(false);
        btn_quitarfila_riesg.setFocusable(false);
        btn_quitarfila_riesg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quitarfila_riesgActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtriesgos, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_añadirfila_riesg, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_quitarfila_riesg, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scroll_riesg, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(txtriesgos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_añadirfila_riesg)
                            .addComponent(btn_quitarfila_riesg, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(scroll_riesg, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Getters
    public JTable getTabla_riesgos() {
        return tabla_riesgos;
    }

    public File getRiesgos() {
        riesgos = new File(ProjectEvaluator.direccion + "riesgos.txt");
        return riesgos;
    }

    public JLabel getTxtriesgos() {
        return txtriesgos;
    }

    //Setters
    public void setImp(boolean imp) {
        this.imp = imp;
    }

    //Métodos
    public void valor_riesgo() {
        //Hace los calculos de valor_riesgo

            try {
                double result = Double.parseDouble(String.valueOf(tabla_riesgos.getValueAt(tabla_riesgos.getSelectedRow(), 5))) / 
                        100 * Double.parseDouble(String.valueOf(tabla_riesgos.getValueAt(tabla_riesgos.getSelectedRow(), 7)));
                tabla_riesgos.setValueAt(result, tabla_riesgos.getSelectedRow(), 9);
            } catch (IndexOutOfBoundsException | NumberFormatException e) {
              //  e.getMessage();
          }
    
    }

    //Eventos
    private void tabla_riesgosPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tabla_riesgosPropertyChange
        //guarda los riesgos
        if (imp == true) {
            try {
                valor_riesgo();
                Utilidad.Tabla.exportar(riesgos, tabla_riesgos);
            } catch (Exception e) {
                System.out.println("Error en guardado de datos (Riesgo)");
            }
        }
    }//GEN-LAST:event_tabla_riesgosPropertyChange

    private void btn_añadirfila_riesgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añadirfila_riesgActionPerformed
        // TODO add your handling code here
        //Añade filas a ing
        Vector<?> rowData = null;
        Utilidad.Tabla.get_modelo(tabla_riesgos).insertRow(0, rowData);
    }//GEN-LAST:event_btn_añadirfila_riesgActionPerformed

    private void btn_quitarfila_riesgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quitarfila_riesgActionPerformed
        //Quita filas a ing, si no se selecciona una fila,se elimina la ultima
        try{
        if (tabla_riesgos.getSelectedRowCount() >= 1) {
            do {
                Utilidad.Tabla.get_modelo(tabla_riesgos).removeRow(tabla_riesgos.getSelectedRow());
            } while (tabla_riesgos.getSelectedRowCount() >= 1);
        } else {
            Utilidad.Tabla.get_modelo(tabla_riesgos).removeRow(0);
        }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("No se pueden remover mas filas.");
            e.getMessage();
        }
    }//GEN-LAST:event_btn_quitarfila_riesgActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_añadirfila_riesg;
    private javax.swing.JButton btn_quitarfila_riesg;
    private javax.swing.JScrollPane scroll_riesg;
    private javax.swing.JTable tabla_riesgos;
    private javax.swing.JLabel txtriesgos;
    // End of variables declaration//GEN-END:variables
}

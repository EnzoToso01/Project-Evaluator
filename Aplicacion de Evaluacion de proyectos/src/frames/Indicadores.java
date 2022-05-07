/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Clases.Utilidad;
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
import javax.swing.JLabel;
import org.apache.poi.ss.formula.functions.Irr;

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
    private ArrayList vac = new ArrayList();
    private ArrayList razonbc = new ArrayList();
    private double tasa_interes;
    private EBITDA ebitda;
    private IngVsGas ingvsgas;
    private boolean imp = false;

    public Indicadores() {
    }

    public Indicadores(EBITDA ebitda, IngVsGas ingvsgas) {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //determina el color del fondo
        Color a = new Color(40, 44, 52);
        getContentPane().setBackground(a);
        this.ebitda = ebitda;
        this.ingvsgas = ingvsgas;
        jtf_interes.setText("0.0");
        Color b = new Color(26, 29, 34);
        tabla_indicadores.getTableHeader().setBackground(b);

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

    public void setImp(boolean imp) {
        this.imp = imp;
    }

    public JTextField getJtf_interes() {
        return jtf_interes;
    }

    public JLabel getTxtindicadores() {
        return txtindicadores;
    }

    

    public void calculo_van() {
        double acum = 0;
        van.clear();
        for (int i = 1; i <= ProjectEvaluator.longevidad; i++) {
            //suma todos los VA correspondiendo a la cantidad de años
            for (int t = 1; t <= i; t++) {
                acum = acum + Double.parseDouble(String.valueOf(ebitda.getArr_total().get(t))) / Math.pow(1 + (tasa_interes / 100), t);
            }
            //resta la inv
            acum = acum - IngVsGas.inv;
            van.add(acum);
            acum = 0;
        }
        van.add(0, "VAN (Sin Riesgo)");
        if (Utilidad.Tabla.get_modelo(tabla_indicadores).getRowCount() >= 1) {
            Utilidad.Tabla.get_modelo(tabla_indicadores).removeRow(0);
            Utilidad.Tabla.get_modelo(tabla_indicadores).insertRow(0, van.toArray());
        } else {
            Utilidad.Tabla.get_modelo(tabla_indicadores).addRow(van.toArray());
        }

    }

    public void calculo_van_r() {
        double acum = 0;
        van_r.clear();
        for (int i = 1; i <= ProjectEvaluator.longevidad; i++) {
            //suma todos los VA correspondiendo a la cantidad de años
            for (int t = 1; t <= i; t++) {
                acum = acum + Double.parseDouble(String.valueOf(ebitda.getArr_r_neto().get(t))) / Math.pow(1 + (tasa_interes / 100), t);
            }
            //resta la inv
            acum = acum - IngVsGas.inv;
            van_r.add(acum);
            acum = 0;
        }
        van_r.add(0, "VAN (Con Riesgo)");
        if (Utilidad.Tabla.get_modelo(tabla_indicadores).getRowCount() >= 2) {
            Utilidad.Tabla.get_modelo(tabla_indicadores).removeRow(1);
            Utilidad.Tabla.get_modelo(tabla_indicadores).insertRow(1, van_r.toArray());
        } else {
            Utilidad.Tabla.get_modelo(tabla_indicadores).addRow(van_r.toArray());
        }

    }

    public void calculo_ivan() {
        ivan.clear();
        for (int t = 1; t <= ProjectEvaluator.longevidad; t++) {
            ivan.add(Double.parseDouble(String.valueOf(van.get(t))) / IngVsGas.inv);
        }

        ivan.add(0, "IVAN (Sin Riesgo)");
        if (Utilidad.Tabla.get_modelo(tabla_indicadores).getRowCount() >= 3) {
            Utilidad.Tabla.get_modelo(tabla_indicadores).removeRow(2);
            Utilidad.Tabla.get_modelo(tabla_indicadores).insertRow(2, ivan.toArray());
        } else {
            Utilidad.Tabla.get_modelo(tabla_indicadores).addRow(ivan.toArray());
        }

    }

    public void calculo_ivan_r() {
        ivan_r.clear();
        for (int t = 1; t <= ProjectEvaluator.longevidad; t++) {
            ivan_r.add(Double.parseDouble(String.valueOf(van_r.get(t))) / IngVsGas.inv);
        }
        ivan_r.add(0, "IVAN (Con Riesgo)");
        if (Utilidad.Tabla.get_modelo(tabla_indicadores).getRowCount() >= 4) {
            Utilidad.Tabla.get_modelo(tabla_indicadores).removeRow(3);
            Utilidad.Tabla.get_modelo(tabla_indicadores).insertRow(3, ivan_r.toArray());
        } else {
            Utilidad.Tabla.get_modelo(tabla_indicadores).addRow(ivan_r.toArray());
        }
    }

    public void calculo_TIR() {
        try {
            tir.clear();
            double[] flujos = new double[ebitda.getArr_total().size()];
            //se inserta la inversion en los flujos
            flujos[0] = Double.parseDouble(String.valueOf(ingvsgas.getJtf_inv().getText())) * -1;
            for (int j = 1; j <= ProjectEvaluator.longevidad; j++) {
                for (int i = 1; i <= j; i++) {
                    flujos[i] = Double.parseDouble(String.valueOf(ebitda.getArr_total().get(i)));

                }
                tir.add(Irr.irr(flujos, 0));
            }
            tir.add(0, "TIR (Sin Riesgo)");
            if (Utilidad.Tabla.get_modelo(tabla_indicadores).getRowCount() >= 5) {
                Utilidad.Tabla.get_modelo(tabla_indicadores).removeRow(4);
                Utilidad.Tabla.get_modelo(tabla_indicadores).insertRow(4, tir.toArray());
            } else {
                Utilidad.Tabla.get_modelo(tabla_indicadores).addRow(tir.toArray());
            }
        } catch (Exception e) {

            System.err.println("Error en Calculo de TIR");
            e.printStackTrace();
        }
    }

    public void calculo_TIR_r() {
        tir_r.clear();
        double[] flujos = new double[ebitda.getArr_r_neto().size()];
        //se inserta la inversion en los flujos
        flujos[0] = Double.parseDouble(String.valueOf(ingvsgas.getJtf_inv().getText())) * -1;
        for (int j = 1; j <= ProjectEvaluator.longevidad; j++) {
            for (int i = 1; i <= j; i++) {
                flujos[i] = Double.parseDouble(String.valueOf(ebitda.getArr_r_neto().get(i)));

            }
            tir_r.add(Irr.irr(flujos, 0));
        }
        tir_r.add(0, "TIR (Con Riesgo)");
        if (Utilidad.Tabla.get_modelo(tabla_indicadores).getRowCount() >= 6) {
            Utilidad.Tabla.get_modelo(tabla_indicadores).removeRow(5);
            Utilidad.Tabla.get_modelo(tabla_indicadores).insertRow(5, tir_r.toArray());
        } else {
            Utilidad.Tabla.get_modelo(tabla_indicadores).addRow(tir_r.toArray());
        }
    }

    public void calculo_vac() {
        double acum = 0;
        vac.clear();
        for (int i = 1; i <= ProjectEvaluator.longevidad; i++) {
            //suma todos los VA correspondiendo a la cantidad de años
            for (int t = 1; t <= i; t++) {
                acum = acum + Double.parseDouble(String.valueOf(ingvsgas.getSuma_totales_eg().get(t))) / Math.pow(1 + (tasa_interes / 100), t);
            }
            //resta la inv
            acum = acum - IngVsGas.inv;
            vac.add(acum);
            acum = 0;
        }
        vac.add(0, "VAC");
        if (Utilidad.Tabla.get_modelo(tabla_indicadores).getRowCount() >= 7) {
            Utilidad.Tabla.get_modelo(tabla_indicadores).removeRow(6);
            Utilidad.Tabla.get_modelo(tabla_indicadores).insertRow(6, vac.toArray());
        } else {
            Utilidad.Tabla.get_modelo(tabla_indicadores).addRow(vac.toArray());
        }
    }

    public void calculo_razonBC() {
        razonbc.clear();
        for (int t = 1; t <= ProjectEvaluator.longevidad; t++) {
            razonbc.add(Double.parseDouble(String.valueOf(van.get(t))) / Double.parseDouble(String.valueOf(vac.get(t))));
        }
        razonbc.add(0, "Razón B/C");
        if (Utilidad.Tabla.get_modelo(tabla_indicadores).getRowCount() >= 8) {
            Utilidad.Tabla.get_modelo(tabla_indicadores).removeRow(7);
            Utilidad.Tabla.get_modelo(tabla_indicadores).insertRow(7, razonbc.toArray());
        } else {
            Utilidad.Tabla.get_modelo(tabla_indicadores).addRow(razonbc.toArray());
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
        txtinteres = new javax.swing.JLabel();
        jtf_interes = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Indicadores");
        setBackground(new java.awt.Color(240, 255, 255));
        setSize(new java.awt.Dimension(900, 690));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        txtindicadores.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txtindicadores.setForeground(new java.awt.Color(240, 255, 255));
        txtindicadores.setText("Indicadores");

        tabla_indicadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Indicador"
            }
        ));
        tabla_indicadores.setSelectionBackground(new java.awt.Color(0, 51, 102));
        tabla_indicadores.setShowGrid(true);
        tabla_indicadores.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tabla_indicadoresPropertyChange(evt);
            }
        });
        scroll_indicadores.setViewportView(tabla_indicadores);

        btn_añadirfila_ind.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_añadirfila_ind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar-fila.png"))); // NOI18N
        btn_añadirfila_ind.setAutoscrolls(true);
        btn_añadirfila_ind.setDefaultCapable(false);
        btn_añadirfila_ind.setFocusable(false);
        btn_añadirfila_ind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_añadirfila_indActionPerformed(evt);
            }
        });

        btn_quitarfila_ind.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_quitarfila_ind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/quitar-fila.png"))); // NOI18N
        btn_quitarfila_ind.setDefaultCapable(false);
        btn_quitarfila_ind.setFocusable(false);
        btn_quitarfila_ind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quitarfila_indActionPerformed(evt);
            }
        });

        txtinteres.setBackground(new java.awt.Color(255, 255, 255));
        txtinteres.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        txtinteres.setForeground(new java.awt.Color(255, 255, 255));
        txtinteres.setText("Tasa de interés");

        jtf_interes.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jtf_interes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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
                        .addComponent(scroll_indicadores)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtinteres)
                            .addComponent(jtf_interes, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_añadirfila_ind, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_quitarfila_ind, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtindicadores, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(281, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(txtindicadores, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_añadirfila_ind))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(txtinteres)
                        .addGap(1, 1, 1)
                        .addComponent(jtf_interes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_quitarfila_ind)))
                .addGap(19, 19, 19)
                .addComponent(scroll_indicadores, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btn_añadirfila_indActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añadirfila_indActionPerformed
        // TODO add your handling code here
        //Añade filas a ingresos
        Vector<?> rowData = null;
        Utilidad.Tabla.get_modelo(tabla_indicadores).addRow(rowData);
    }//GEN-LAST:event_btn_añadirfila_indActionPerformed

    private void btn_quitarfila_indActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quitarfila_indActionPerformed
        // TODO add your handling code here:
        //Quita filas a idicadores, si no se selecciona una fila,se elimina la ultima
        if (tabla_indicadores.getSelectedRowCount() >= 1) {
            do {
                Utilidad.Tabla.get_modelo(tabla_indicadores).removeRow(tabla_indicadores.getSelectedRow());
            } while (tabla_indicadores.getSelectedRowCount() >= 1);
        } else {
            Utilidad.Tabla.get_modelo(tabla_indicadores).removeRow(tabla_indicadores.getRowCount() - 1);
        }
    }//GEN-LAST:event_btn_quitarfila_indActionPerformed

    private void jtf_interesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_interesActionPerformed
        // TODO add your handling code here: 
        setear_interes();
        calculo_van();
        calculo_van_r();
        calculo_ivan();
        calculo_ivan_r();
        Utilidad.JtextField.exportar_jtf(interes, jtf_interes);
    }//GEN-LAST:event_jtf_interesActionPerformed

    private void jtf_interesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtf_interesPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_interesPropertyChange

    private void tabla_indicadoresPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tabla_indicadoresPropertyChange
        // TODO add your handling code here:
        //inicializa ingvsgas
        if (imp == true) {
            //inicializa indicadores
            Utilidad.JtextField.importar_jtf(interes, jtf_interes);
            setear_interes();
            Utilidad.JtextField.importar_jtf(IngVsGas.inversion, ingvsgas.getJtf_inv());
            //calculo van sin riesgo y con riesgo
            calculo_van();
            calculo_van_r();
            calculo_ivan();
            calculo_ivan_r();
            calculo_TIR();
            calculo_vac();
            calculo_razonBC();

            try {
                Utilidad.Tabla.exportar(indicadores, tabla_indicadores);
            } catch (Exception e) {
                System.err.println("Error al guardar los datos en Indicadores");
            }
        }
    }//GEN-LAST:event_tabla_indicadoresPropertyChange

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_añadirfila_ind;
    private javax.swing.JButton btn_quitarfila_ind;
    private javax.swing.JTextField jtf_interes;
    private javax.swing.JScrollPane scroll_indicadores;
    private javax.swing.JTable tabla_indicadores;
    private javax.swing.JLabel txtindicadores;
    private javax.swing.JLabel txtinteres;
    // End of variables declaration//GEN-END:variables
}
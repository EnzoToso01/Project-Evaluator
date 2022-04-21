/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Clases.Utilidad;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Enzo
 */
public class Empleados extends javax.swing.JFrame {

    /**
     * Creates new form Empleados
     */
    private File directorio = new File("C:\\Project evaluator\\sueldos.txt");
    private File tasas = new File("C:\\Project evaluator\\sueldos\\tasas.txt");
    private boolean imp_tas = false;
    private double tas_jub;
    private double tas_ob;
    private double tas_ley;
    private double tas_sec;
    private boolean imp = false;
    private IngVsGas ingvsgas;

    public Empleados(IngVsGas ingvsgas) {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //determina el color del fondo
        Color a = new Color(40, 44, 52);
        getContentPane().setBackground(a);
        Color b = new Color(26, 29, 34);
        tabla_sueldos.getTableHeader().setBackground(b);
        tabla_tasas.getTableHeader().setBackground(b);
        directorio.mkdirs();
        this.ingvsgas = ingvsgas;
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

    public JTextField getJtf_total_sueldos() {
        return jtf_total_sueldos;
    }

    public void setImp(boolean imp) {
        this.imp = imp;
    }

    public JComboBox<String> getCombo_años() {
        return combo_años;
    }

    public void importar_emp() {
        Utilidad.Tabla.get_modelo(tabla_sueldos).setRowCount(0);
        //importa la tabla correspondiente al combo
        for (int i = 1; i <= ProjectEvaluator.longevidad; i++) {
            if (combo_años.getSelectedIndex() + 1 == i) {
                File sueldos = new File("C:\\Project evaluator\\sueldos\\sueldos " + i + ".txt");
                Utilidad.Tabla.importar(sueldos, tabla_sueldos);

            }
        }

    }

    public void total_sueldos() {
        for (int i = 0; i < tabla_sueldos.getRowCount(); i++) {
            try {
                double result = Double.valueOf(String.valueOf(Utilidad.Tabla.get_modelo(tabla_sueldos).getValueAt(i, 1))) + Double.valueOf(String.valueOf(Utilidad.Tabla.get_modelo(tabla_sueldos).getValueAt(i, 2)));
                Utilidad.Tabla.get_modelo(tabla_sueldos).setValueAt(result, i, 3);
            } catch (NullPointerException | NumberFormatException e) {

            }
        }
    }

    public void antiguedad() {
        for (int i = 0; i < tabla_sueldos.getRowCount(); i++) {
            try {
                double result = 84.64 * Double.valueOf(String.valueOf(Utilidad.Tabla.get_modelo(tabla_sueldos).getValueAt(i, 4)));
                Utilidad.Tabla.get_modelo(tabla_sueldos).setValueAt(result, i, 5);
            } catch (NullPointerException | NumberFormatException e) {

            }
        }
    }

    public void presentismo() {
        for (int i = 0; i < tabla_sueldos.getRowCount(); i++) {
            try {
                double result = 0.0833 * Double.parseDouble(String.valueOf(Utilidad.Tabla.get_modelo(tabla_sueldos).getValueAt(i, 3)));
                Utilidad.Tabla.get_modelo(tabla_sueldos).setValueAt(result, i, 6);
            } catch (NullPointerException | NumberFormatException e) {

            }
        }
    }

    public void bruto() {
        for (int i = 0; i < tabla_sueldos.getRowCount(); i++) {
            try {
                double result = Double.parseDouble(String.valueOf(Utilidad.Tabla.get_modelo(tabla_sueldos).getValueAt(i, 3))) + Double.parseDouble(String.valueOf(Utilidad.Tabla.get_modelo(tabla_sueldos).getValueAt(i, 5))) + Double.parseDouble(String.valueOf(Utilidad.Tabla.get_modelo(tabla_sueldos).getValueAt(i, 6)));
                Utilidad.Tabla.get_modelo(tabla_sueldos).setValueAt(result, i, 7);
            } catch (NullPointerException | NumberFormatException e) {

            }
        }
    }

    public void tasas(double tasa) {
        try {
            tas_jub = Double.parseDouble(String.valueOf(Utilidad.Tabla.get_modelo(tabla_tasas).getValueAt(0, 0))) / 100;
            tas_ob = Double.parseDouble(String.valueOf(Utilidad.Tabla.get_modelo(tabla_tasas).getValueAt(0, 1))) / 100;
            tas_ley = Double.parseDouble(String.valueOf(Utilidad.Tabla.get_modelo(tabla_tasas).getValueAt(0, 2))) / 100;
            tas_sec = Double.parseDouble(String.valueOf(Utilidad.Tabla.get_modelo(tabla_tasas).getValueAt(0, 3))) / 100;

            for (int i = 0; i < tabla_sueldos.getRowCount(); i++) {

                double result = Double.parseDouble(String.valueOf(Utilidad.Tabla.get_modelo(tabla_sueldos).getValueAt(i, 7))) * tasa;
                if (tasa == tas_jub) {
                    Utilidad.Tabla.get_modelo(tabla_sueldos).setValueAt(result, i, 8);
                } else if (tasa == tas_ob) {
                    Utilidad.Tabla.get_modelo(tabla_sueldos).setValueAt(result, i, 9);
                } else if (tasa == tas_ley) {
                    Utilidad.Tabla.get_modelo(tabla_sueldos).setValueAt(result, i, 10);
                } else if (tasa == tas_sec) {
                    Utilidad.Tabla.get_modelo(tabla_sueldos).setValueAt(result, i, 11);
                }
            }
        } catch (NullPointerException | NumberFormatException e) {
        }
    }

    public void total_desc() {

        for (int i = 0; i < tabla_sueldos.getRowCount(); i++) {
            try {
                double result = Double.parseDouble(String.valueOf(Utilidad.Tabla.get_modelo(tabla_sueldos).getValueAt(i, 8))) + Double.parseDouble(String.valueOf(Utilidad.Tabla.get_modelo(tabla_sueldos).getValueAt(i, 9))) + Double.parseDouble(String.valueOf(Utilidad.Tabla.get_modelo(tabla_sueldos).getValueAt(i, 10))) + Double.parseDouble(String.valueOf(Utilidad.Tabla.get_modelo(tabla_sueldos).getValueAt(i, 11)));
                Utilidad.Tabla.get_modelo(tabla_sueldos).setValueAt(result, i, 12);
            } catch (NullPointerException | NumberFormatException e) {

            }
        }

    }

    public void total_neto() {

        for (int i = 0; i < tabla_sueldos.getRowCount(); i++) {
            try {
                double result = Double.parseDouble(String.valueOf(Utilidad.Tabla.get_modelo(tabla_sueldos).getValueAt(i, 7))) - Double.parseDouble(String.valueOf(Utilidad.Tabla.get_modelo(tabla_sueldos).getValueAt(i, 12)));
                Utilidad.Tabla.get_modelo(tabla_sueldos).setValueAt(result, i, 13);
            } catch (NullPointerException | NumberFormatException e) {

            }
        }

    }

    public double calculo_total_sueldos() {
        double total = 0;
        for (int i = 0; i < tabla_sueldos.getRowCount(); i++) {
            try {
                total = total + Double.parseDouble(String.valueOf(Utilidad.Tabla.get_modelo(tabla_sueldos).getValueAt(i, 7)));
            } catch (NullPointerException | NumberFormatException e) {

            }
        }
        return total;
    }

    public void arr_sueldos() {
        ArrayList sueldos = new ArrayList();
        for (int i = 1; i <= combo_años.getItemCount(); i++) {
            combo_años.setSelectedItem("Año " + i);
            Utilidad.Tabla.get_modelo(tabla_sueldos).setRowCount(0);
            importar_emp();
            sueldos.add(calculo_total_sueldos());
        }
        combo_años.setSelectedItem("Año 1");
        sueldos.add(0, "Sueldos");
        if (Utilidad.Tabla.get_modelo(ingvsgas.getTabla_egresos()).getRowCount() <= 2) {
            Utilidad.Tabla.get_modelo(ingvsgas.getTabla_egresos()).addRow(sueldos.toArray());
        } else {
            Utilidad.Tabla.get_modelo(ingvsgas.getTabla_egresos()).removeRow(0);
            Utilidad.Tabla.get_modelo(ingvsgas.getTabla_egresos()).insertRow(0, sueldos.toArray());
        }
        ingvsgas.calculo_total_eg(ingvsgas.getTabla_egresos());
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
        scroll_sueldos = new javax.swing.JScrollPane();
        tabla_sueldos = new javax.swing.JTable();
        jtf_total_sueldos = new javax.swing.JTextField();
        txttotalsueldos = new javax.swing.JLabel();
        btn_guardar = new javax.swing.JButton();
        combo_años = new javax.swing.JComboBox<>();
        btn_añadirfila_emp = new javax.swing.JButton();
        btn_quitarfila_emp = new javax.swing.JButton();
        scroll_tasas = new javax.swing.JScrollPane();
        tabla_tasas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Empleados");
        setLocation(new java.awt.Point(0, 0));
        setSize(new java.awt.Dimension(900, 690));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        txtsueldos.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txtsueldos.setForeground(new java.awt.Color(240, 255, 255));
        txtsueldos.setText("Sueldos");

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
        scroll_sueldos.setViewportView(tabla_sueldos);
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

        jtf_total_sueldos.setEditable(false);
        jtf_total_sueldos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txttotalsueldos.setBackground(new java.awt.Color(255, 255, 255));
        txttotalsueldos.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txttotalsueldos.setForeground(new java.awt.Color(255, 255, 255));
        txttotalsueldos.setText("Total sueldos");

        btn_guardar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        combo_años.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
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

        btn_añadirfila_emp.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_añadirfila_emp.setText("añadir fila");
        btn_añadirfila_emp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_añadirfila_empActionPerformed(evt);
            }
        });

        btn_quitarfila_emp.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_quitarfila_emp.setText("quitar fila");
        btn_quitarfila_emp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quitarfila_empActionPerformed(evt);
            }
        });

        tabla_tasas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tasa Jubilación", "Tasa Obra Social", "Tasa Ley 19032", "Tasa SEC"
            }
        ));
        tabla_tasas.setFocusable(false);
        tabla_tasas.setOpaque(false);
        tabla_tasas.setRequestFocusEnabled(false);
        tabla_tasas.setRowSelectionAllowed(false);
        tabla_tasas.setShowGrid(true);
        tabla_tasas.setUpdateSelectionOnSort(false);
        tabla_tasas.setVerifyInputWhenFocusTarget(false);
        tabla_tasas.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tabla_tasasPropertyChange(evt);
            }
        });
        scroll_tasas.setViewportView(tabla_tasas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(scroll_sueldos)
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
                            .addComponent(jtf_total_sueldos, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttotalsueldos, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                        .addGap(28, 28, 28)
                        .addComponent(btn_añadirfila_emp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_quitarfila_emp)
                        .addGap(77, 77, 77)
                        .addComponent(btn_guardar)
                        .addGap(76, 76, 76))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scroll_tasas, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(txttotalsueldos)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_añadirfila_emp)
                        .addComponent(btn_quitarfila_emp)
                        .addComponent(btn_guardar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtf_total_sueldos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(combo_años, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtsueldos)))
                .addGap(40, 40, 40)
                .addComponent(scroll_tasas, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(scroll_sueldos, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            for (int i = 1; i <= ProjectEvaluator.longevidad; i++) {
                if (combo_años.getSelectedIndex() + 1 == i) {
                    File sueldos = new File("C:\\Project evaluator\\sueldos\\sueldos " + i + ".txt");
                    Utilidad.Tabla.exportar(sueldos, tabla_sueldos);
                }
            }
            Utilidad.Tabla.exportar(tasas, tabla_tasas);
            JOptionPane.showMessageDialog(null, "datos guardados");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al guardar los datos");
        }


    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_añadirfila_empActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añadirfila_empActionPerformed
        // TODO add your handling code here
        //Añade filas a imp

        Vector<?> rowData = null;
        Utilidad.Tabla.get_modelo(tabla_sueldos).addRow(rowData);
    }//GEN-LAST:event_btn_añadirfila_empActionPerformed

    private void btn_quitarfila_empActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quitarfila_empActionPerformed
        // TODO add your handling code here:
        //Quita filas a imp, si no se selecciona una fila,se elimina la ultima

        if (tabla_sueldos.getSelectedRowCount() >= 1) {
            do {
                Utilidad.Tabla.get_modelo(tabla_sueldos).removeRow(tabla_sueldos.getSelectedRow());
            } while (tabla_sueldos.getSelectedRowCount() >= 1);

        } else {
            Utilidad.Tabla.get_modelo(tabla_sueldos).removeRow(tabla_sueldos.getRowCount() - 1);
        }
    }//GEN-LAST:event_btn_quitarfila_empActionPerformed

    private void combo_añosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo_añosMouseClicked
        // TODO add your handling code here:
        try {
            File sueldos = new File("C:\\Project evaluator\\sueldos\\sueldos " + (int) (combo_años.getSelectedIndex() + 1) + ".txt");
            Utilidad.Tabla.exportar(sueldos, tabla_sueldos);

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
        //establece valores de empleados
        total_sueldos();
        antiguedad();
        presentismo();
        bruto();
        Utilidad.Tabla.filas_defecto(tabla_tasas, 1);
        tasas(tas_jub);
        tasas(tas_ob);
        tasas(tas_ley);
        tasas(tas_sec);
        total_desc();
        total_neto();
        jtf_total_sueldos.setText(String.valueOf(calculo_total_sueldos()));
    }//GEN-LAST:event_combo_añosItemStateChanged

    private void tabla_sueldosPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tabla_sueldosPropertyChange
        // TODO add your handling code here:
        if (imp == true) {
            try {
                for (int i = 1; i <= ProjectEvaluator.longevidad; i++) {
                    if (combo_años.getSelectedIndex() + 1 == i) {
                        File sueldos = new File("C:\\Project evaluator\\sueldos\\sueldos " + i + ".txt");
                        Utilidad.Tabla.exportar(sueldos, tabla_sueldos);
                    }
                }
            } catch (Exception e) {

            }

            total_sueldos();
            antiguedad();
            presentismo();
            bruto();
            Utilidad.Tabla.filas_defecto(tabla_tasas, 1);
            tasas(tas_jub);
            tasas(tas_ob);
            tasas(tas_ley);
            tasas(tas_sec);
            total_desc();
            total_neto();
            jtf_total_sueldos.setText(String.valueOf(calculo_total_sueldos()));
            arr_sueldos();
        }
    }//GEN-LAST:event_tabla_sueldosPropertyChange

    private void tabla_tasasPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tabla_tasasPropertyChange
        // TODO add your handling code here:
        Utilidad.Tabla.filas_defecto(tabla_tasas, 1);
        if (imp_tas == true) {
            Utilidad.Tabla.exportar(tasas, tabla_tasas);
        }
        tasas(tas_jub);
        tasas(tas_ob);
        tasas(tas_ley);
        tasas(tas_sec);
    }//GEN-LAST:event_tabla_tasasPropertyChange

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowOpened

    public void inicializar_combo() {

        for (int i = 1; i <= ProjectEvaluator.longevidad; i++) {
            combo_años.addItem("Año " + i);
        }
    }

    private Empleados() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_añadirfila_emp;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_quitarfila_emp;
    private javax.swing.JComboBox<String> combo_años;
    private javax.swing.JTextField jtf_total_sueldos;
    private javax.swing.JScrollPane scroll_sueldos;
    private javax.swing.JScrollPane scroll_tasas;
    private javax.swing.JTable tabla_sueldos;
    private javax.swing.JTable tabla_tasas;
    private javax.swing.JLabel txtsueldos;
    private javax.swing.JLabel txttotalsueldos;
    // End of variables declaration//GEN-END:variables
}

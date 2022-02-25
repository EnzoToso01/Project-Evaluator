/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import aplicacion.de.evaluacion.de.proyectos.Tabla;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.System.out;
import javax.swing.JFrame;
import java.sql.*;
import java.util.Arrays;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 *
 * @author Enzo
 */
public class IngVsGas extends javax.swing.JFrame {

    /**
     * Creates new form IngVsGas
     */
    private String datos_ing[] = new String[50];
    private String datos_eg[] = new String[50];
    private File directorio = new File("C:\\Project evaluator\\IngVsGas");

    private File ingresos = new File("C:\\Project evaluator\\IngVsGas\\ingresos.txt");
    private File ingresosiva = new File("C:\\Project evaluator\\IngVsGas\\ingresos (IVA).txt");
    private File egresos = new File("C:\\Project evaluator\\IngVsGas\\egresos.txt");
    private File egresosiva = new File("C:\\Project evaluator\\IngVsGas\\egresos (IVA).txt");
    EBITDA ebitda = new EBITDA();

    public IngVsGas() {
    }

    public IngVsGas(EBITDA ebitda) {
        initComponents();
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //determina el color del fondo
        Color c = new Color(56, 80, 113);
        getContentPane().setBackground(c);
        //crea el directorio para ingvsgas
        directorio.mkdirs();
        //paso el objeto ebitda para poder modificar la tabla desde ingvsgas
        this.ebitda = ebitda;

    }

    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngVsGas().setVisible(true);
            }

        });

    }

    public String[] getDatos_ing() {
        return datos_ing;
    }

    public String[] getDatos_eg() {
        return datos_eg;
    }

    public File getIngresos() {
        return ingresos;
    }

    public File getIngresosiva() {
        return ingresosiva;
    }

    public File getEgresos() {
        return egresos;
    }

    public File getEgresosiva() {
        return egresosiva;
    }

    public JTable getTabla_egresos() {
        return tabla_egresos;
    }

    public JTable getTabla_ingresos() {
        return tabla_ingresos;
    }

    public void calculo_total(JTable tabla) {

        double total = 0;
        ArrayList datos = new ArrayList();
        datos.add("Total");

        try {
            //chequea si la row Total existe y la borra 
            for (int i = 0; i < tabla.getRowCount(); i++) {
                if (tabla.getValueAt(i, 0) != null && tabla.getValueAt(i, 0).equals("Total")) {
                    Tabla.get_modelo(tabla).removeRow(i);

                }
            }
            //acumula la suma de los valores

            for (int i = 1; i <= Principal.longevidad; i++) {
                for (int j = 0; j < tabla.getRowCount(); j++) {
                    //convierte los datos null de la primera columna en string para evitar null exceptions 
                    if (tabla.getValueAt(j, 0) == null) {
                        Tabla.get_modelo(tabla).setValueAt("", j, 0);

                    }
                    if (tabla.getValueAt(j, i) != null) {
                        if (!tabla.getValueAt(j, i).equals("") && !tabla.getValueAt(j, 0).equals("Total")) {
                            total = total + Double.parseDouble(tabla.getValueAt(j, i).toString());
                        }
                    }
                }

                datos.add(total);
                total = 0;
            }

            Tabla.get_modelo(tabla).addRow(datos.toArray());
        } catch (ArrayIndexOutOfBoundsException e) {

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

        txtingresos = new javax.swing.JLabel();
        txtegresos = new javax.swing.JLabel();
        scroll_ingresos = new javax.swing.JScrollPane();
        tabla_ingresos = new javax.swing.JTable();
        scroll_egresos = new javax.swing.JScrollPane();
        tabla_egresos = new javax.swing.JTable();
        btn_guardar = new javax.swing.JButton();
        btn_añadirfila_ing = new javax.swing.JButton();
        btn_quitarfila_ing = new javax.swing.JButton();
        btn_añadirfila_eg = new javax.swing.JButton();
        btn_quitarfila_eg = new javax.swing.JButton();
        jComboBoxivaing = new javax.swing.JComboBox<>();
        jComboBoxivaeg = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IngVsGas");
        setBackground(new java.awt.Color(56, 80, 113));
        setLocation(new java.awt.Point(0, 0));
        setSize(new java.awt.Dimension(900, 690));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        txtingresos.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        txtingresos.setForeground(new java.awt.Color(240, 255, 255));
        txtingresos.setText("Ingresos del Proyecto");

        txtegresos.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        txtegresos.setForeground(new java.awt.Color(240, 255, 255));
        txtegresos.setText("Egresos del Proyecto");

        tabla_ingresos.setBackground(new java.awt.Color(255, 255, 255));
        tabla_ingresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ingresos"
            }
        ));
        tabla_ingresos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabla_ingresos.setShowGrid(true);
        tabla_ingresos.setUpdateSelectionOnSort(false);
        tabla_ingresos.setVerifyInputWhenFocusTarget(false);
        tabla_ingresos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tabla_ingresosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tabla_ingresosFocusLost(evt);
            }
        });
        tabla_ingresos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_ingresosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tabla_ingresosMouseEntered(evt);
            }
        });
        tabla_ingresos.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tabla_ingresosPropertyChange(evt);
            }
        });
        tabla_ingresos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabla_ingresosKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tabla_ingresosKeyTyped(evt);
            }
        });
        scroll_ingresos.setViewportView(tabla_ingresos);

        tabla_egresos.setBackground(new java.awt.Color(255, 255, 255));
        tabla_egresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Egresos"
            }
        ));
        tabla_egresos.setShowGrid(true);
        tabla_egresos.setSurrendersFocusOnKeystroke(true);
        tabla_egresos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tabla_egresosFocusGained(evt);
            }
        });
        tabla_egresos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_egresosMouseClicked(evt);
            }
        });
        tabla_egresos.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tabla_egresosPropertyChange(evt);
            }
        });
        scroll_egresos.setViewportView(tabla_egresos);

        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        btn_añadirfila_ing.setText("añadir fila");
        btn_añadirfila_ing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_añadirfila_ingActionPerformed(evt);
            }
        });

        btn_quitarfila_ing.setText("quitar fila");
        btn_quitarfila_ing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quitarfila_ingActionPerformed(evt);
            }
        });

        btn_añadirfila_eg.setText("añadir fila");
        btn_añadirfila_eg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_añadirfila_egActionPerformed(evt);
            }
        });

        btn_quitarfila_eg.setText("quitar fila");
        btn_quitarfila_eg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quitarfila_egActionPerformed(evt);
            }
        });

        jComboBoxivaing.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin IVA", "Con IVA" }));
        jComboBoxivaing.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxivaingItemStateChanged(evt);
            }
        });
        jComboBoxivaing.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxivaingMouseClicked(evt);
            }
        });
        jComboBoxivaing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxivaingActionPerformed(evt);
            }
        });
        jComboBoxivaing.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboBoxivaingPropertyChange(evt);
            }
        });

        jComboBoxivaeg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin IVA", "Con IVA" }));
        jComboBoxivaeg.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxivaegItemStateChanged(evt);
            }
        });
        jComboBoxivaeg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxivaegMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll_ingresos)
                    .addComponent(scroll_egresos, javax.swing.GroupLayout.DEFAULT_SIZE, 873, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtegresos, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxivaeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(132, 132, 132)
                        .addComponent(btn_añadirfila_eg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_quitarfila_eg)
                        .addGap(200, 200, 200))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtingresos, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxivaing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(136, 136, 136)
                        .addComponent(btn_añadirfila_ing)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_quitarfila_ing)
                        .addGap(87, 87, 87)
                        .addComponent(btn_guardar)
                        .addGap(37, 37, 37)))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtingresos, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_guardar)
                    .addComponent(btn_añadirfila_ing)
                    .addComponent(btn_quitarfila_ing)
                    .addComponent(jComboBoxivaing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll_ingresos, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtegresos, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_añadirfila_eg)
                    .addComponent(btn_quitarfila_eg)
                    .addComponent(jComboBoxivaeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll_egresos, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        System.out.println("Seteando SIN IVA");
        jComboBoxivaing.setSelectedItem("Sin IVA");
        jComboBoxivaeg.setSelectedItem("Sin IVA");
    }//GEN-LAST:event_formWindowClosing


    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // TODO add your handling code here:

        //exp ing y eg
        try {
            if (jComboBoxivaing.getSelectedItem().equals("Sin IVA")) {
                Tabla.exportar(ingresos, tabla_ingresos);
            } else {
                Tabla.exportar(ingresosiva, tabla_ingresos);
            }
            if (jComboBoxivaeg.getSelectedItem().equals("Sin IVA")) {
                Tabla.exportar(egresos, tabla_egresos);

            } else {
                Tabla.exportar(egresosiva, tabla_egresos);

            }

            JOptionPane.showMessageDialog(null, "datos guardados");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al guardar los datos");
        }

    }//GEN-LAST:event_btn_guardarActionPerformed


    private void btn_añadirfila_ingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añadirfila_ingActionPerformed
        // TODO add your handling code here
        //Añade filas a ingresos
        Vector<?> rowData = null;
        Tabla.get_modelo(tabla_ingresos).addRow(rowData);

    }//GEN-LAST:event_btn_añadirfila_ingActionPerformed

    private void btn_quitarfila_ingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quitarfila_ingActionPerformed
        // TODO add your handling code here:
        //Quita filas a ingresos (se quita la ultima por defecto)

        if (tabla_ingresos.getSelectedRowCount() == 1) {
            Tabla.get_modelo(tabla_ingresos).removeRow(tabla_ingresos.getSelectedRow());
        } else {
            Tabla.get_modelo(tabla_ingresos).removeRow(tabla_ingresos.getRowCount() - 1);
        }
    }//GEN-LAST:event_btn_quitarfila_ingActionPerformed

    private void btn_añadirfila_egActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añadirfila_egActionPerformed
        // TODO add your handling code here:   
        Vector<?> rowData = null;
        Tabla.get_modelo(tabla_egresos).addRow(rowData);
    }//GEN-LAST:event_btn_añadirfila_egActionPerformed

    private void btn_quitarfila_egActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quitarfila_egActionPerformed
        // TODO add your handling code here:

        if (tabla_egresos.getSelectedRowCount() == 1) {
            Tabla.get_modelo(tabla_egresos).removeRow(tabla_egresos.getSelectedRow());
        } else {
            Tabla.get_modelo(tabla_egresos).removeRow(tabla_egresos.getRowCount() - 1);
        }
    }//GEN-LAST:event_btn_quitarfila_egActionPerformed

    private void jComboBoxivaingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxivaingActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBoxivaingActionPerformed

    private void jComboBoxivaingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxivaingMouseClicked
        // TODO add your handling code here:
        //exporta al cambiar de tabla con el combobox
        if (jComboBoxivaing.getSelectedIndex() == 0) {
            Tabla.exportar(ingresos, tabla_ingresos);
        } else {
            Tabla.exportar(ingresosiva, tabla_ingresos);
        }
    }//GEN-LAST:event_jComboBoxivaingMouseClicked


    private void jComboBoxivaingPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBoxivaingPropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBoxivaingPropertyChange

    private void jComboBoxivaingItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxivaingItemStateChanged
        // TODO add your handling code here:

        DefaultTableModel tblmodel = (DefaultTableModel) tabla_ingresos.getModel();
        tblmodel.setRowCount(0);

        //importa la nueva tabla
        if (jComboBoxivaing.getSelectedItem().equals("Sin IVA")) {
            Tabla.importar(ingresos, tabla_ingresos);
        } else {
            Tabla.importar(ingresosiva, tabla_ingresos);
        }
        Tabla.filas_defecto(tabla_ingresos, 30);
        calculo_total(tabla_ingresos);

    }//GEN-LAST:event_jComboBoxivaingItemStateChanged

    private void jComboBoxivaegItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxivaegItemStateChanged
        // TODO add your handling code here:
        DefaultTableModel tblmodel = (DefaultTableModel) tabla_egresos.getModel();
        tblmodel.setRowCount(0);
        //importa la nueva tabla
        if (jComboBoxivaeg.getSelectedItem().equals("Sin IVA")) {
            Tabla.importar(egresos, tabla_egresos);
        } else {
            Tabla.importar(egresosiva, tabla_egresos);
        }
        Tabla.filas_defecto(tabla_egresos, 30);
        calculo_total(tabla_egresos);
    }//GEN-LAST:event_jComboBoxivaegItemStateChanged

    private void jComboBoxivaegMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxivaegMouseClicked
        // TODO add your handling code here:
        if (jComboBoxivaeg.getSelectedIndex() == 0) {
            Tabla.exportar(egresos, tabla_egresos);
        } else {
            Tabla.exportar(egresosiva, tabla_egresos);
        }
    }//GEN-LAST:event_jComboBoxivaegMouseClicked

    private void tabla_ingresosPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tabla_ingresosPropertyChange
        // TODO add your handling code here:
        System.out.println("Propiedad de ingresos cambiada");
        calculo_total(tabla_ingresos);
        ebitda.set_ing(datos_ing);
        ebitda.filas_datos_ebitda();
    }//GEN-LAST:event_tabla_ingresosPropertyChange


    private void tabla_ingresosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabla_ingresosKeyPressed
        // TODO add your handling code here:


    }//GEN-LAST:event_tabla_ingresosKeyPressed

    private void tabla_ingresosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabla_ingresosKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_tabla_ingresosKeyTyped

    private void tabla_ingresosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_ingresosMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_tabla_ingresosMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_formMouseClicked

    private void tabla_egresosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_egresosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabla_egresosMouseClicked

    private void tabla_ingresosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_ingresosMouseEntered
        // TODO add your handling code here:


    }//GEN-LAST:event_tabla_ingresosMouseEntered

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        // TODO add your handling code here:


    }//GEN-LAST:event_formMouseEntered

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_formKeyTyped

    private void tabla_ingresosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabla_ingresosFocusLost
        // TODO add your handling code here:


    }//GEN-LAST:event_tabla_ingresosFocusLost

    private void tabla_ingresosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabla_ingresosFocusGained
        // TODO add your handling code here:


    }//GEN-LAST:event_tabla_ingresosFocusGained

    private void tabla_egresosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabla_egresosFocusGained
        // TODO add your handling code here:


    }//GEN-LAST:event_tabla_egresosFocusGained

    private void tabla_egresosPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tabla_egresosPropertyChange
        // TODO add your handling code here:
        System.out.println("Propiedad de egresos cambiada");
        calculo_total(tabla_egresos);
        ebitda.set_eg(datos_eg);
        ebitda.filas_datos_ebitda();
    }//GEN-LAST:event_tabla_egresosPropertyChange

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_añadirfila_eg;
    private javax.swing.JButton btn_añadirfila_ing;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_quitarfila_eg;
    private javax.swing.JButton btn_quitarfila_ing;
    private javax.swing.JComboBox<String> jComboBoxivaeg;
    private javax.swing.JComboBox<String> jComboBoxivaing;
    private javax.swing.JScrollPane scroll_egresos;
    private javax.swing.JScrollPane scroll_ingresos;
    private javax.swing.JTable tabla_egresos;
    private javax.swing.JTable tabla_ingresos;
    private javax.swing.JLabel txtegresos;
    private javax.swing.JLabel txtingresos;
    // End of variables declaration//GEN-END:variables

    private Object get_modelo(JTable tabla) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

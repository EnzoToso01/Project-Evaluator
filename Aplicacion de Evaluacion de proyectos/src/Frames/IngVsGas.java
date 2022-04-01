/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import aplicacion.de.evaluacion.de.proyectos.ProjectEvaluator;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
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
    private File directorio = new File("C:\\Project evaluator\\IngVsGas");
    private ArrayList<Double> total_ing = new ArrayList();
    private ArrayList<Double> total_ing_iva = new ArrayList();
    private ArrayList<Double> total_eg = new ArrayList();
    private ArrayList<Double> total_eg_iva = new ArrayList();
    private ArrayList suma_totales_ing = new ArrayList();
    private ArrayList suma_totales_eg = new ArrayList();
    private ArrayList arr_sueldos = new ArrayList();
    private File ingresos = new File("C:\\Project evaluator\\IngVsGas\\ingresos.txt");
    private File ingresosiva = new File("C:\\Project evaluator\\IngVsGas\\ingresos (IVA).txt");
    private File egresos = new File("C:\\Project evaluator\\IngVsGas\\egresos.txt");
    private File egresosiva = new File("C:\\Project evaluator\\IngVsGas\\egresos (IVA).txt");
    private EBITDA ebitda;
    private Impuestos impuestos;

    IngVsGas() {

    }

    public IngVsGas(EBITDA ebitda, Impuestos impuestos) {
        initComponents();
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //determina el color del fondo
        Color c = new Color(56, 80, 113);
        getContentPane().setBackground(c);
        //crea el directorio para ingvsgas
        directorio.mkdirs();
        this.ebitda = ebitda;
        this.impuestos = impuestos;
    }

    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngVsGas().setVisible(true);

            }

        });

    }

    public EBITDA getEbitda() {
        return ebitda;
    }

    public Impuestos getImpuestos() {
        return impuestos;
    }

    public JComboBox<String> getjComboBoxivaeg() {
        return jComboBoxivaeg;
    }

    public JComboBox<String> getjComboBoxivaing() {
        return jComboBoxivaing;
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

    public ArrayList getSuma_totales_ing() {
        return suma_totales_ing;
    }

    public ArrayList getSuma_totales_eg() {
        return suma_totales_eg;
    }

    public ArrayList<Double> getTotal_ing() {
        return total_ing;
    }

    public ArrayList<Double> getTotal_ing_iva() {
        return total_ing_iva;
    }

    public ArrayList<Double> getTotal_eg() {
        return total_eg;
    }

    public ArrayList<Double> getTotal_eg_iva() {
        return total_eg_iva;
    }

    public ArrayList calculo_datos(JTable tabla) {

        double total = 0;
        ArrayList datos = new ArrayList();
        //para evitar indexoutofbounds exceptions
        ProjectEvaluator.Tabla.inicializar(tabla_ingresos);
        ProjectEvaluator.Tabla.inicializar(tabla_egresos);
        try {
            //chequea si las rows Totales existen y las borra 
            for (int i = 0; i < tabla.getRowCount(); i++) {
                if (tabla.getValueAt(i, 0) != null && tabla.getValueAt(i, 0).equals("Total")) {
                    ProjectEvaluator.Tabla.get_modelo(tabla).removeRow(i);

                }
            }
            for (int i = 0; i < tabla.getRowCount(); i++) {
                if (tabla.getValueAt(i, 0) != null && tabla.getValueAt(i, 0).equals("Total Final")) {
                    ProjectEvaluator.Tabla.get_modelo(tabla).removeRow(i);

                }
            }
            //acumula la suma de los valores
            for (int i = 1; i <= Principal.longevidad; i++) {
                for (int j = 0; j < tabla.getRowCount(); j++) {
                    //convierte los datos null de la primera columna en string para evitar null exceptions 
                    if (tabla.getValueAt(j, 0) == null) {
                        ProjectEvaluator.Tabla.get_modelo(tabla).setValueAt("", j, 0);

                    }
                    if (tabla.getValueAt(j, i) != null) {
                        if (!tabla.getValueAt(j, i).equals("") && !tabla.getValueAt(j, 0).equals("Total")) {
                            total = total + Double.parseDouble(String.valueOf(tabla.getValueAt(j, i)));
                        }
                    }
                }

                datos.add(total);
                total = 0;
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error en Calculo Total");
        }
        return datos;
    }

    public void calculo_total_ing(JTable tabla) {

        ArrayList aux = new ArrayList();

        //añade valores por defecto a los arraylist de totales
        if (total_ing.isEmpty() == true && total_ing_iva.isEmpty() == true && suma_totales_ing.isEmpty() == true) {

            for (int i = 0; i <= Principal.longevidad; i++) {
                total_ing.add(0.0);
                total_ing_iva.add(0.0);
                suma_totales_ing.add(0.0);
            }
        }
        //iguala los arrays a el array datos segun corresponda
        if (jComboBoxivaing.getSelectedItem().equals("Sin IVA")) {
            total_ing = (ArrayList<Double>) calculo_datos(tabla).clone();
            aux.clear();
            aux.addAll(total_ing);
            aux.add(0, "Total");
            ProjectEvaluator.Tabla.get_modelo(tabla).addRow(aux.toArray());
        } else {
            total_ing_iva = (ArrayList<Double>) calculo_datos(tabla).clone();
            aux.clear();
            aux.addAll(total_ing_iva);
            aux.add(0, "Total");
            ProjectEvaluator.Tabla.get_modelo(tabla).addRow(aux.toArray());
        }
        // realiza la suma de los totales
        suma_totales_ing.set(0, "Total Final");
        //Si se produce una excepción de index se añaden valores con 0 por defecto. (Esto ocurre especialmente al añadir columnas)
        for (int i = 1; i <= Principal.longevidad; i++) {
            try {
                suma_totales_ing.set(i, total_ing.get(i - 1) + total_ing_iva.get(i - 1));
            } catch (IndexOutOfBoundsException e) {
                suma_totales_ing.add(0.0);
            }
        }
        //añade los totales a las tablas
        ProjectEvaluator.Tabla.get_modelo(tabla).addRow(suma_totales_ing.toArray());

    }

    public void calculo_total_eg(JTable tabla) {

        ArrayList aux = new ArrayList();

        //añade valores por defecto a los arraylist de totales
        if (total_eg.isEmpty() == true && total_eg_iva.isEmpty() == true && suma_totales_eg.isEmpty() == true) {

            for (int i = 0; i <= Principal.longevidad; i++) {
                total_eg.add(0.0);
                total_eg_iva.add(0.0);
                suma_totales_eg.add(0.0);
            }
        }
        //iguala los arrays a el array datos segun corresponda
        if (jComboBoxivaeg.getSelectedItem().equals("Sin IVA")) {
            total_eg = (ArrayList<Double>) calculo_datos(tabla).clone();
            aux.clear();
            aux.addAll(total_eg);
            aux.add(0, "Total");
            ProjectEvaluator.Tabla.get_modelo(tabla).addRow(aux.toArray());
        } else {
            total_eg_iva = (ArrayList<Double>) calculo_datos(tabla).clone();
            aux.clear();
            aux.addAll(total_eg_iva);
            aux.add(0, "Total");
            ProjectEvaluator.Tabla.get_modelo(tabla).addRow(aux.toArray());
        }
        // realiza la suma de los totales
        suma_totales_eg.set(0, "Total Final");
        //Si se produce una excepción de index se añaden valores con 0 por defecto. (Esto ocurre especialmente al añadir columnas)
        for (int i = 1; i <= Principal.longevidad; i++) {
            try {
                suma_totales_eg.set(i, total_eg.get(i - 1) + total_eg_iva.get(i - 1));
            } catch (IndexOutOfBoundsException e) {
                suma_totales_eg.add(0.0);
            }
        }
        //añade los totales a las tablas
        ProjectEvaluator.Tabla.get_modelo(tabla).addRow(suma_totales_eg.toArray());

    }

    public void setear_ebitda_imp() {

        //setea datos de Ebitda    
        ProjectEvaluator.Tabla.get_modelo(ebitda.getTabla_ebitda()).setRowCount(0);
        ebitda.setIngresos(suma_totales_ing);
        ebitda.setEgresos(suma_totales_eg);
        ebitda.calculo_ebitda();
        ebitda.calculo_ing_brutos();
        impuestos.iva_ventas(total_ing_iva);
        impuestos.iva_compras(total_eg_iva);
        ebitda.calculo_iva();
        ebitda.calculo_intereses();
        ebitda.calculo_subt_s_gan();
        ebitda.calculo_amortizaciones();
        ebitda.calculo_sub_c_amort();
        ebitda.calculo_ganancias();
        impuestos.ganancias();
        ebitda.calculo_total();
        ebitda.calculo_payback();
        ebitda.calculo_riesgo();
        impuestos.ing_b();
        impuestos.calculo_total_imp();

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
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
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
        tabla_ingresos.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tabla_ingresosPropertyChange(evt);
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

        jComboBoxivaeg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin IVA", "Con IVA" }));
        jComboBoxivaeg.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxivaegItemStateChanged(evt);
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

        jComboBoxivaing.setSelectedItem("Sin IVA");
        jComboBoxivaeg.setSelectedItem("Sin IVA");
    }//GEN-LAST:event_formWindowClosing


    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // TODO add your handling code here:

        //exp ing y eg
        try {
            if (jComboBoxivaing.getSelectedItem().equals("Sin IVA")) {
                ProjectEvaluator.Tabla.exportar(ingresos, tabla_ingresos);
            } else {
                ProjectEvaluator.Tabla.exportar(ingresosiva, tabla_ingresos);
            }
            if (jComboBoxivaeg.getSelectedItem().equals("Sin IVA")) {
                ProjectEvaluator.Tabla.exportar(egresos, tabla_egresos);

            } else {
                ProjectEvaluator.Tabla.exportar(egresosiva, tabla_egresos);

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
        ProjectEvaluator.Tabla.get_modelo(tabla_ingresos).insertRow(0, rowData);

    }//GEN-LAST:event_btn_añadirfila_ingActionPerformed

    private void btn_quitarfila_ingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quitarfila_ingActionPerformed
        // TODO add your handling code here:
        //Quita filas a ingresos (se quita la ultima por defecto)

        if (tabla_ingresos.getSelectedRowCount() >= 1) {
            do {
                ProjectEvaluator.Tabla.get_modelo(tabla_ingresos).removeRow(tabla_ingresos.getSelectedRow());
            } while (tabla_ingresos.getSelectedRowCount() >= 1);

        } else {
            ProjectEvaluator.Tabla.get_modelo(tabla_ingresos).removeRow(0);
        }
    }//GEN-LAST:event_btn_quitarfila_ingActionPerformed

    private void btn_añadirfila_egActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añadirfila_egActionPerformed
        // TODO add your handling code here:   
        Vector<?> rowData = null;
        ProjectEvaluator.Tabla.get_modelo(tabla_egresos).insertRow(0, rowData);
    }//GEN-LAST:event_btn_añadirfila_egActionPerformed

    private void btn_quitarfila_egActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quitarfila_egActionPerformed
        // TODO add your handling code here:

        if (tabla_egresos.getSelectedRowCount() >= 1) {
            do {
                ProjectEvaluator.Tabla.get_modelo(tabla_egresos).removeRow(tabla_egresos.getSelectedRow());
            } while (tabla_egresos.getSelectedRowCount() >= 1);

        } else {
            ProjectEvaluator.Tabla.get_modelo(tabla_egresos).removeRow(0);
        }
    }//GEN-LAST:event_btn_quitarfila_egActionPerformed


    private void jComboBoxivaingItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxivaingItemStateChanged
        // TODO add your handling code here:

        ProjectEvaluator.Tabla.get_modelo(tabla_ingresos).setRowCount(0);

        //importa la nueva tabla
        if (jComboBoxivaing.getSelectedItem().equals("Sin IVA")) {

            ProjectEvaluator.Tabla.importar(ingresos, tabla_ingresos);
        } else {
            ProjectEvaluator.Tabla.importar(ingresosiva, tabla_ingresos);
        }
        ProjectEvaluator.Tabla.filas_defecto(tabla_ingresos, 30);

        calculo_total_ing(tabla_ingresos);

    }//GEN-LAST:event_jComboBoxivaingItemStateChanged

    private void jComboBoxivaegItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxivaegItemStateChanged
        // TODO add your handling code here:
        DefaultTableModel tblmodel = (DefaultTableModel) tabla_egresos.getModel();
        tblmodel.setRowCount(0);
        //importa la nueva tabla
        if (jComboBoxivaeg.getSelectedItem().equals("Sin IVA")) {
            ProjectEvaluator.Tabla.importar(egresos, tabla_egresos);
        } else {
            ProjectEvaluator.Tabla.importar(egresosiva, tabla_egresos);
        }
        ProjectEvaluator.Tabla.filas_defecto(tabla_egresos, 30);

        calculo_total_eg(tabla_egresos);
    }//GEN-LAST:event_jComboBoxivaegItemStateChanged

    private void tabla_ingresosPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tabla_ingresosPropertyChange
        // TODO add your handling code here:
        //guarda al realizar cualquier cambio 
        if (Principal.import_ingeg == true) {

            if (jComboBoxivaing.getSelectedIndex() == 0) {
                ProjectEvaluator.Tabla.exportar(ingresos, tabla_ingresos);
            } else {
                ProjectEvaluator.Tabla.exportar(ingresosiva, tabla_ingresos);
            }

            calculo_total_ing(tabla_ingresos);
            setear_ebitda_imp();

        }
    }//GEN-LAST:event_tabla_ingresosPropertyChange


    private void tabla_egresosPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tabla_egresosPropertyChange
        // TODO add your handling code here:
        //guarda al realizar cualquier cambio
        if (Principal.import_ingeg == true) {
            if (jComboBoxivaeg.getSelectedIndex() == 0) {
                ProjectEvaluator.Tabla.exportar(egresos, tabla_egresos);
            } else {
                ProjectEvaluator.Tabla.exportar(egresosiva, tabla_egresos);
            }

            calculo_total_eg(tabla_egresos);
            setear_ebitda_imp();

        }
    }//GEN-LAST:event_tabla_egresosPropertyChange

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        // TODO adding
        calculo_total_ing(tabla_ingresos);
        calculo_total_eg(tabla_egresos);
        ebitda.setIngresos(suma_totales_ing);
        ebitda.setEgresos(suma_totales_eg);
    }//GEN-LAST:event_formWindowOpened

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

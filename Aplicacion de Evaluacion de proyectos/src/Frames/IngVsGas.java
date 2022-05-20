/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Clases.Utilidad;
import static Frames.ProjectEvaluator.direccion;
import static Frames.ProjectEvaluator.import_ingeg;
import java.awt.Color;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Enzo
 */
public class IngVsGas extends javax.swing.JFrame {

    /**
     * Creates new form IngVsGas
     */
    private ArrayList<Double> total_ing = new ArrayList();
    private ArrayList<Double> total_ing_iva = new ArrayList();
    private ArrayList<Double> total_eg = new ArrayList();
    private ArrayList<Double> total_eg_iva = new ArrayList();
    private ArrayList suma_totales_ing = new ArrayList();
    private ArrayList suma_totales_eg = new ArrayList();
    private ArrayList arr_sueldos = new ArrayList();
    private File directorio;
    private File ingresos;
    private File ingresosiva;
    private File egresos;
    private File egresosiva;
    private EBITDA ebitda;
    private Impuestos impuestos;
    private Indicadores indicadores;
    public File inversion;
    public double inv;

    public IngVsGas() {
    }

    public IngVsGas(EBITDA ebitda, Impuestos impuestos) {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(ProjectEvaluator.fondo);
        //crea el directorio para ingvsgas   
        this.ebitda = ebitda;
        this.impuestos = impuestos;
        jtf_inv.setText("0.0");
    }

    //Código autogenerado
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtingresos = new javax.swing.JLabel();
        txtegresos = new javax.swing.JLabel();
        scroll_ingresos = new javax.swing.JScrollPane();
        tabla_ingresos = new javax.swing.JTable();
        scroll_egresos = new javax.swing.JScrollPane();
        tabla_egresos = new javax.swing.JTable();
        jComboBoxivaing = new javax.swing.JComboBox<>();
        jComboBoxivaeg = new javax.swing.JComboBox<>();
        txtinv = new javax.swing.JLabel();
        jtf_inv = new javax.swing.JTextField();
        btn_añadirfila_ing = new javax.swing.JButton();
        btn_quitarfila_ing = new javax.swing.JButton();
        btn_añadirfila_eg = new javax.swing.JButton();
        btn_quitarfila_eg = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IngVsGas");
        setBackground(new java.awt.Color(0, 51, 102));
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

        txtingresos.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txtingresos.setForeground(new java.awt.Color(240, 255, 255));
        txtingresos.setText("Ingresos");

        txtegresos.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txtegresos.setForeground(new java.awt.Color(240, 255, 255));
        txtegresos.setText("Egresos");

        tabla_ingresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ingresos"
            }
        ));
        tabla_ingresos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabla_ingresos.setFocusable(false);
        tabla_ingresos.setShowGrid(true);
        tabla_ingresos.setUpdateSelectionOnSort(false);
        tabla_ingresos.setVerifyInputWhenFocusTarget(false);
        tabla_ingresos.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tabla_ingresosPropertyChange(evt);
            }
        });
        scroll_ingresos.setViewportView(tabla_ingresos);

        tabla_egresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Egresos"
            }
        ));
        tabla_egresos.setFocusable(false);
        tabla_egresos.setShowGrid(true);
        tabla_egresos.setSurrendersFocusOnKeystroke(true);
        tabla_egresos.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tabla_egresosPropertyChange(evt);
            }
        });
        scroll_egresos.setViewportView(tabla_egresos);

        jComboBoxivaing.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jComboBoxivaing.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin IVA", "Con IVA" }));
        jComboBoxivaing.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxivaingItemStateChanged(evt);
            }
        });

        jComboBoxivaeg.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jComboBoxivaeg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin IVA", "Con IVA" }));
        jComboBoxivaeg.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxivaegItemStateChanged(evt);
            }
        });

        txtinv.setBackground(new java.awt.Color(255, 255, 255));
        txtinv.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtinv.setForeground(new java.awt.Color(255, 255, 255));
        txtinv.setText("Inversión ");

        jtf_inv.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jtf_inv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtf_inv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_invActionPerformed(evt);
            }
        });

        btn_añadirfila_ing.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_añadirfila_ing.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar-fila.png"))); // NOI18N
        btn_añadirfila_ing.setAutoscrolls(true);
        btn_añadirfila_ing.setDefaultCapable(false);
        btn_añadirfila_ing.setFocusable(false);
        btn_añadirfila_ing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_añadirfila_ingActionPerformed(evt);
            }
        });

        btn_quitarfila_ing.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_quitarfila_ing.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/quitar-fila.png"))); // NOI18N
        btn_quitarfila_ing.setDefaultCapable(false);
        btn_quitarfila_ing.setFocusable(false);
        btn_quitarfila_ing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quitarfila_ingActionPerformed(evt);
            }
        });

        btn_añadirfila_eg.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_añadirfila_eg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar-fila.png"))); // NOI18N
        btn_añadirfila_eg.setAutoscrolls(true);
        btn_añadirfila_eg.setDefaultCapable(false);
        btn_añadirfila_eg.setFocusable(false);
        btn_añadirfila_eg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_añadirfila_egActionPerformed(evt);
            }
        });

        btn_quitarfila_eg.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_quitarfila_eg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/quitar-fila.png"))); // NOI18N
        btn_quitarfila_eg.setDefaultCapable(false);
        btn_quitarfila_eg.setFocusable(false);
        btn_quitarfila_eg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quitarfila_egActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtingresos, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(331, 561, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scroll_ingresos)
                            .addComponent(scroll_egresos)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtegresos, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxivaeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_añadirfila_eg, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_quitarfila_eg, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtf_inv, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtinv))
                                .addGap(378, 378, 378)
                                .addComponent(jComboBoxivaing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_añadirfila_ing, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_quitarfila_ing, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(txtingresos)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtinv)
                        .addGap(4, 4, 4)
                        .addComponent(jtf_inv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jComboBoxivaing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_añadirfila_ing)
                            .addComponent(btn_quitarfila_ing, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll_ingresos, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn_añadirfila_eg)
                        .addComponent(btn_quitarfila_eg, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtegresos)
                        .addComponent(jComboBoxivaeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scroll_egresos, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Getters
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

    public JTextField getJtf_inv() {
        return jtf_inv;
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

    public double getInv() {
        return inv;
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

    public JLabel getTxtegresos() {
        return txtegresos;
    }

    public JLabel getTxtingresos() {
        return txtingresos;
    }

    //Setters
    public void setIndicadores(Indicadores indicadores) {
        this.indicadores = indicadores;
    }

    //Métodos
    public ArrayList calculo_datos(JTable tabla) {
        //realiza la suma para el calculo total en una columna de ingresos o egresos
        double total = 0;
        ArrayList datos = new ArrayList();
        //para evitar indexoutofbounds exceptions
        Utilidad.Tabla.inicializar_col(tabla_ingresos);
        Utilidad.Tabla.inicializar_col(tabla_egresos);
        try {
            //chequea si las rows Totales existen y las borra 
            for (int i = 0; i < tabla.getRowCount(); i++) {
                if (tabla.getValueAt(i, 0) != null && tabla.getValueAt(i, 0).equals("Total")) {
                    Utilidad.Tabla.get_modelo(tabla).removeRow(i);
                }
            }
            for (int i = 0; i < tabla.getRowCount(); i++) {
                if (tabla.getValueAt(i, 0) != null && tabla.getValueAt(i, 0).equals("Total Final")) {
                    Utilidad.Tabla.get_modelo(tabla).removeRow(i);
                }
            }
            //acumula la suma de los valores
            for (int i = 1; i <= ProjectEvaluator.longevidad; i++) {
                for (int j = 0; j < tabla.getRowCount(); j++) {
                    //convierte los datos null de la primera columna en string para evitar null exceptions 
                    if (tabla.getValueAt(j, 0) == null) {
                        Utilidad.Tabla.get_modelo(tabla).setValueAt("", j, 0);
                    }
                    if (tabla.getValueAt(j, i) != null) {
                        if (!tabla.getValueAt(j, i).equals("") && !tabla.getValueAt(j, 0).equals("Total")) {
                            try {
                                total = total + Double.parseDouble(String.valueOf(tabla.getValueAt(j, i)));
                            } catch (NumberFormatException e) {
                                System.err.println("Error en Calculo Total");
                                System.err.println(e);
                            }
                        }
                    }
                }
                datos.add(total);
                total = 0;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error en Calculo_Total (IngVsGas)");
            System.err.println(e);
        }
        return datos;
    }

    public void calculo_totales(JTable tabla, ArrayList<Double> total, ArrayList<Double> total_iva, ArrayList suma_totales, JComboBox jcombobox) {
        //Realiza los diferentes arrays de calculo total para ingresos o egresos y los añade a sus respectivas tablas
        ArrayList aux = new ArrayList();
        try {
            //añade valores por defecto a los arraylist de totales
            if (total.isEmpty() == true && total_iva.isEmpty() == true && suma_totales.isEmpty() == true) {
                for (int i = 0; i <= ProjectEvaluator.longevidad; i++) {
                    total.add(0.0);
                    total_iva.add(0.0);
                    suma_totales.add(0.0);
                }
            }
            //iguala los arrays a el array datos segun corresponda
            if (jcombobox.getSelectedItem().equals("Sin IVA")) {
                total = (ArrayList<Double>) calculo_datos(tabla);
                aux.clear();
                aux.addAll(total);
                aux.add(0, "Total");
                Utilidad.Tabla.get_modelo(tabla).addRow(aux.toArray());
            } else {
                total_iva = (ArrayList<Double>) calculo_datos(tabla);
                aux.clear();
                aux.addAll(total_iva);
                aux.add(0, "Total");
                Utilidad.Tabla.get_modelo(tabla).addRow(aux.toArray());
            }
            // realiza la suma de los totales
            suma_totales.clear();
            suma_totales.add(0, "Total Final");
            //Si se produce una excepción de index se añaden valores con 0 por defecto. (Esto ocurre especialmente al añadir columnas)
            for (int i = 1; i <= ProjectEvaluator.longevidad; i++) {
                try {
                    suma_totales.add(total.get(i - 1) + total_iva.get(i - 1));
                } catch (IndexOutOfBoundsException e) {
                    suma_totales.add(0.0);
                }
            }
            //añade los totales a las tablas
            Utilidad.Tabla.get_modelo(tabla).addRow(suma_totales.toArray());
        } catch (Exception e) {
            System.err.println("Error en calculo_total (IngVsGas)");
            e.getMessage();
        }
    }

    public void setear_ingvsgas() {
        //Realiza o establece todos los valores para ingvsgas
        try {
            //para inicializar ingvsgas
            ((DefaultTableModel) getTabla_ingresos().getModel()).setRowCount(0);
            ((DefaultTableModel) getTabla_egresos().getModel()).setRowCount(0);
            //inicializa ing y eg
            Utilidad.Tabla.inicializar_col(getTabla_ingresos());
            Utilidad.Tabla.inicializar_col(getTabla_egresos());
            //imp ing eg con iva
            getjComboBoxivaing().setSelectedItem("Con IVA");
            getjComboBoxivaeg().setSelectedItem("Con IVA");
            ((DefaultTableModel) getTabla_ingresos().getModel()).setRowCount(0);
            ((DefaultTableModel) getTabla_egresos().getModel()).setRowCount(0);
            //imp ing y eg
            getjComboBoxivaing().setSelectedItem("Sin IVA");
            getjComboBoxivaeg().setSelectedItem("Sin IVA");
            //actualiza totales        
            calculo_totales(tabla_ingresos, total_ing, total_ing_iva, suma_totales_ing, jComboBoxivaing);
            calculo_totales(tabla_egresos, total_eg, total_eg_iva, suma_totales_eg, jComboBoxivaeg);
            import_ingeg = true;
            Utilidad.Tabla.filas_defecto(getTabla_ingresos(), 11);
            Utilidad.Tabla.filas_defecto(getTabla_egresos(), 11);
        } catch (Exception e) {
            System.err.println("Error en setear_ingvsgas (IngVsGas)");
            e.getMessage();
        }
    }

    public void setear_ebitda_imp() {
        //setea datos de Ebitda e impuestos 
        try {
            Utilidad.Tabla.get_modelo(ebitda.getTabla_ebitda()).setRowCount(0);
            ebitda.setIngresos(suma_totales_ing);
            ebitda.setEgresos(suma_totales_eg);
            ebitda.calculo_ebitda();
            impuestos.calculo_ing_brutos();
            impuestos.iva_ventas(total_ing_iva);
            impuestos.iva_compras(total_eg_iva);
            impuestos.calculo_iva();
            ebitda.calculo_intereses();
            ebitda.calculo_subt_s_gan();
            ebitda.calculo_amortizaciones();
            ebitda.calculo_sub_c_amort();
            impuestos.calculo_ganancias();
            ebitda.calculo_total();
            ebitda.calculo_payback();
            ebitda.calculo_riesgo();
            ebitda.calculo_r_neto();
            impuestos.calculo_total_imp();
        } catch (Exception e) {
            System.err.println("Error en setear_ebitda_imp (IngVsGas)");
            e.getMessage();
        }
    }

    public void setear_inv() {
        try {
            //establece que inv es el valor del jtf y añade a ingresos la inv
            inv = Double.parseDouble(jtf_inv.getText());
            Object[] arrinv = {"Inversión inicial", inv};
            //busca la fila inv y si no la encuentra la crea,si la encuentra la reemplaza
            int fila_inv = Utilidad.Tabla.buscar_indice_fila("Inversión inicial", tabla_ingresos);
            if (fila_inv == -1) {
                Utilidad.Tabla.get_modelo(tabla_ingresos).insertRow(0, arrinv);
            } else {
                Utilidad.Tabla.get_modelo(tabla_ingresos).removeRow(fila_inv);
                Utilidad.Tabla.get_modelo(tabla_ingresos).insertRow(fila_inv, arrinv);
            }
            saldo_caja_inicial();
        } catch (NumberFormatException | NullPointerException e) {
            System.err.println("Error en setear_inv (IngVsGas)");
            e.getMessage();
            //para evitar null exceptions
            Utilidad.Tabla.get_modelo(tabla_ingresos).setValueAt("", 1, 0);
        }
    }

    public void saldo_caja_inicial() {
        //añade el saldo inicial en los ingresos
        ArrayList saldo_caja = new ArrayList();
        saldo_caja.addAll(ebitda.getArr_total());
        saldo_caja.remove(0);
        saldo_caja.add(0, "Saldo inicial de caja disponible");
        saldo_caja.add(1, 0.0);
        int fila_caja = Utilidad.Tabla.buscar_indice_fila("Saldo inicial de caja disponible", tabla_ingresos);
        if (fila_caja == -1) {
            Utilidad.Tabla.get_modelo(tabla_ingresos).insertRow(0, saldo_caja.toArray());
        } else {
            Utilidad.Tabla.get_modelo(tabla_ingresos).removeRow(fila_caja);
            Utilidad.Tabla.get_modelo(tabla_ingresos).insertRow(fila_caja, saldo_caja.toArray());
        }
    }

    //Eventos
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //setea a sin iva los combobox al cerrar ventana
        jComboBoxivaing.setSelectedItem("Sin IVA");
        jComboBoxivaeg.setSelectedItem("Sin IVA");
    }//GEN-LAST:event_formWindowClosing


    private void jComboBoxivaingItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxivaingItemStateChanged
        //Importa la tabla correspondiente cuando se cambia de item 
        Utilidad.Tabla.get_modelo(tabla_ingresos).setRowCount(0);
        //importa la nueva tabla
        if (jComboBoxivaing.getSelectedItem().equals("Sin IVA")) {
            ingresos = new File(ProjectEvaluator.direccion + "IngVsGas\\ingresos.txt");
            Utilidad.Tabla.importar(ingresos, tabla_ingresos);
        } else {
            ingresosiva = new File(ProjectEvaluator.direccion + "IngVsGas\\ingresos (IVA).txt");
            Utilidad.Tabla.importar(ingresosiva, tabla_ingresos);
        }
        Utilidad.Tabla.filas_defecto(tabla_ingresos, 11);
        calculo_totales(tabla_ingresos, total_ing, total_ing_iva, suma_totales_ing, jComboBoxivaing);
    }//GEN-LAST:event_jComboBoxivaingItemStateChanged

    private void jComboBoxivaegItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxivaegItemStateChanged
        //Importa la tabla correspondiente cuando se cambia de item 
        DefaultTableModel tblmodel = (DefaultTableModel) tabla_egresos.getModel();
        tblmodel.setRowCount(0);
        //importa la nueva tabla
        if (jComboBoxivaeg.getSelectedItem().equals("Sin IVA")) {
            egresos = new File(ProjectEvaluator.direccion + "IngVsGas\\egresos.txt");
            Utilidad.Tabla.importar(egresos, tabla_egresos);
        } else {
            egresosiva = new File(ProjectEvaluator.direccion + "IngVsGas\\egresos (IVA).txt");
            Utilidad.Tabla.importar(egresosiva, tabla_egresos);
        }
        Utilidad.Tabla.filas_defecto(tabla_egresos, 11);
        calculo_totales(tabla_egresos, total_eg, total_eg_iva, suma_totales_eg, jComboBoxivaeg);
    }//GEN-LAST:event_jComboBoxivaegItemStateChanged


    private void tabla_ingresosPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tabla_ingresosPropertyChange
        //guarda al realizar cualquier cambio 
        try {
            if (ProjectEvaluator.import_ingeg == true) {
                if (jComboBoxivaing.getSelectedIndex() == 0) {
                    //  direccion = "C:\\Project evaluator\\" + nombreproyecto_str + "\\";
                    ingresos = new File(ProjectEvaluator.direccion + "IngVsGas\\ingresos.txt");
                    Utilidad.Tabla.exportar(ingresos, tabla_ingresos);
                } else {
                    //  direccion = "C:\\Project evaluator\\" + nombreproyecto_str + "\\";
                    ingresosiva = new File(ProjectEvaluator.direccion + "IngVsGas\\ingresos (IVA).txt");
                    Utilidad.Tabla.exportar(ingresosiva, tabla_ingresos);
                }
                //hace varias veces los seteos para actualizar total ebitda con saldo caja inicial en (CON IVA)
                if (jComboBoxivaing.getSelectedIndex() == 0) {
                    for (int i = 1; i <= ProjectEvaluator.longevidad; i++) {
                        calculo_totales(tabla_ingresos, total_ing, total_ing_iva, suma_totales_ing, jComboBoxivaing);
                        setear_ebitda_imp();
                        saldo_caja_inicial();
                    }
                }
                indicadores.añadir_indicadores();
            }
        } catch (Exception e) {
            System.err.println("Error en tabla_ingresosPropertyChange,IngVsGas");
            e.getMessage();
        }
    }//GEN-LAST:event_tabla_ingresosPropertyChange


    private void tabla_egresosPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tabla_egresosPropertyChange
        //guarda al realizar cualquier cambio
        try {
            if (ProjectEvaluator.import_ingeg == true) {
                if (jComboBoxivaeg.getSelectedIndex() == 0) {
                    egresos = new File(direccion + "\\IngVsGas\\egresos.txt");
                    Utilidad.Tabla.exportar(egresos, tabla_egresos);
                } else {
                    egresosiva = new File(direccion + "IngVsGas\\egresos (IVA).txt");
                    Utilidad.Tabla.exportar(egresosiva, tabla_egresos);
                }
                calculo_totales(tabla_egresos, total_eg, total_eg_iva, suma_totales_eg, jComboBoxivaeg);
                setear_ebitda_imp();
                saldo_caja_inicial();
                indicadores.añadir_indicadores();
            }
        } catch (Exception e) {
            System.err.println("Error en tabla_egresosPropertyChange,IngVsGas");
            e.getMessage();
        }
    }//GEN-LAST:event_tabla_egresosPropertyChange


    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //crea el directorio ingvsgas y setea ingvsgas
        directorio = new File(direccion + "\\IngVsGas\\");
        directorio.mkdirs();
        setear_ingvsgas();
    }//GEN-LAST:event_formWindowOpened

    private void jtf_invActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_invActionPerformed
        // setea la inversion y la guarda
        setear_inv();
        inversion = new File(ProjectEvaluator.direccion + "IngVsGas\\inversion.txt");
        Utilidad.JtextField.exportar_jtf(inversion, jtf_inv);
    }//GEN-LAST:event_jtf_invActionPerformed

    private void btn_añadirfila_ingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añadirfila_ingActionPerformed
        // TODO add your handling code here
        //Añade filas a ing
        Vector<?> rowData = null;
        Utilidad.Tabla.get_modelo(tabla_ingresos).insertRow(0, rowData);
    }//GEN-LAST:event_btn_añadirfila_ingActionPerformed

    private void btn_quitarfila_ingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quitarfila_ingActionPerformed
        //Quita filas a ing, si no se selecciona una fila,se elimina la ultima
        if (tabla_ingresos.getSelectedRowCount() >= 1) {
            do {
                Utilidad.Tabla.get_modelo(tabla_ingresos).removeRow(tabla_ingresos.getSelectedRow());
            } while (tabla_ingresos.getSelectedRowCount() >= 1);
        } else {
            Utilidad.Tabla.get_modelo(tabla_ingresos).removeRow(0);
        }
    }//GEN-LAST:event_btn_quitarfila_ingActionPerformed

    private void btn_añadirfila_egActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añadirfila_egActionPerformed
        // TODO add your handling code here:
        //Añade filas a ing
        Vector<?> rowData = null;
        Utilidad.Tabla.get_modelo(tabla_egresos).insertRow(0, rowData);
    }//GEN-LAST:event_btn_añadirfila_egActionPerformed

    private void btn_quitarfila_egActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quitarfila_egActionPerformed
        // TODO add your handling code here:
        //Quita filas a ing, si no se selecciona una fila,se elimina la ultima
        if (tabla_egresos.getSelectedRowCount() >= 1) {
            do {
                Utilidad.Tabla.get_modelo(tabla_egresos).removeRow(tabla_egresos.getSelectedRow());
            } while (tabla_egresos.getSelectedRowCount() >= 1);
        } else {
            Utilidad.Tabla.get_modelo(tabla_egresos).removeRow(0);
        }
    }//GEN-LAST:event_btn_quitarfila_egActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_añadirfila_eg;
    private javax.swing.JButton btn_añadirfila_ing;
    private javax.swing.JButton btn_quitarfila_eg;
    private javax.swing.JButton btn_quitarfila_ing;
    private javax.swing.JComboBox<String> jComboBoxivaeg;
    private javax.swing.JComboBox<String> jComboBoxivaing;
    private javax.swing.JTextField jtf_inv;
    private javax.swing.JScrollPane scroll_egresos;
    private javax.swing.JScrollPane scroll_ingresos;
    private javax.swing.JTable tabla_egresos;
    private javax.swing.JTable tabla_ingresos;
    private javax.swing.JLabel txtegresos;
    private javax.swing.JLabel txtingresos;
    private javax.swing.JLabel txtinv;
    // End of variables declaration//GEN-END:variables

    private Object get_modelo(JTable tabla) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

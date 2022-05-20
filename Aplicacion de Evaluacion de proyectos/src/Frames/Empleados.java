package Frames;

import Clases.Utilidad;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Enzo
 */
public class Empleados extends javax.swing.JFrame {

    private File directorio;
    public static File tasas;
    private boolean imp_tas = false;
    private double tas_jub;
    private double tas_ob;
    private double tas_ley;
    private double tas_sec;
    private boolean imp_s = false;
    private IngVsGas ingvsgas;

    public Empleados(IngVsGas ingvsgas) {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //determina el color del fondo
        getContentPane().setBackground(ProjectEvaluator.fondo);
        this.ingvsgas = ingvsgas;
    }

    //Código autogenerado
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtsueldos = new javax.swing.JLabel();
        scroll_sueldos = new javax.swing.JScrollPane();
        tabla_sueldos = new javax.swing.JTable();
        jtf_total_sueldos = new javax.swing.JTextField();
        txttotalsueldos = new javax.swing.JLabel();
        combo_años = new javax.swing.JComboBox<>();
        scroll_tasas = new javax.swing.JScrollPane();
        tabla_tasas = new javax.swing.JTable();
        btn_añadirfila_sueld = new javax.swing.JButton();
        btn_quitarfila_sueld = new javax.swing.JButton();

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

        tabla_sueldos.setAutoCreateRowSorter(true);
        tabla_sueldos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre y apellido", "Basico Jornada  Completa", "Comision  ", "Total Sueldo  ", "Antiguedad  ", "Ad/ Antiguedad  ", "Ad/Presentismo ", "Bruto  ", "Jubiliacion", "Obra Social ", "Ley 19032 ", "SEC ", "Total descuentos", "Total neto"
            }
        ));
        tabla_sueldos.setCellSelectionEnabled(true);
        tabla_sueldos.setFocusable(false);
        tabla_sueldos.setShowGrid(true);
        tabla_sueldos.setSurrendersFocusOnKeystroke(true);
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

        tabla_tasas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tasa Jubilación", "Tasa Obra Social", "Tasa Ley 19032", "Tasa SEC"
            }
        ));
        tabla_tasas.setFocusable(false);
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

        btn_añadirfila_sueld.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_añadirfila_sueld.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar-fila.png"))); // NOI18N
        btn_añadirfila_sueld.setAutoscrolls(true);
        btn_añadirfila_sueld.setDefaultCapable(false);
        btn_añadirfila_sueld.setFocusable(false);
        btn_añadirfila_sueld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_añadirfila_sueldActionPerformed(evt);
            }
        });

        btn_quitarfila_sueld.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_quitarfila_sueld.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/quitar-fila.png"))); // NOI18N
        btn_quitarfila_sueld.setDefaultCapable(false);
        btn_quitarfila_sueld.setFocusable(false);
        btn_quitarfila_sueld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quitarfila_sueldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(txtsueldos, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(149, 149, 149)
                .addComponent(combo_años, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtf_total_sueldos, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttotalsueldos, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scroll_tasas, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_añadirfila_sueld, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_quitarfila_sueld, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scroll_sueldos))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(txttotalsueldos)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_total_sueldos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_años, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsueldos))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scroll_tasas, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn_añadirfila_sueld)
                        .addComponent(btn_quitarfila_sueld, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(18, 18, 18)
                .addComponent(scroll_sueldos, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Getters
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

    public void setImp_sueldos(boolean imp_s) {
        this.imp_s = imp_s;
    }

    public JComboBox<String> getCombo_años() {
        return combo_años;
    }

    public JLabel getTxtsueldos() {
        return txtsueldos;
    }

    //Métodos
    public void importar_emp() {
        //importa empleados
        try {
            Utilidad.Tabla.get_modelo(tabla_sueldos).setRowCount(0);
            //importa la tabla correspondiente al combo
            for (int i = 1; i <= ProjectEvaluator.longevidad; i++) {
                if (combo_años.getSelectedIndex() + 1 == i) {
                    File sueldos = new File(ProjectEvaluator.direccion + "\\Sueldos\\sueldos año " + i + ".txt");
                    Utilidad.Tabla.importar(sueldos, tabla_sueldos);

                }
            }
        } catch (Exception e) {
            System.err.println("Error en importar_emp (Empleados)");
            e.getMessage();
        }
    }

    public void total_sueldos() {
        //calcula el total de sueldos
        try {
            for (int i = 0; i < tabla_sueldos.getRowCount(); i++) {
                try {
                    double result = Double.valueOf(String.valueOf(Utilidad.Tabla.get_modelo(tabla_sueldos).getValueAt(i, 1))) + Double.valueOf(String.valueOf(Utilidad.Tabla.get_modelo(tabla_sueldos).getValueAt(i, 2)));
                    Utilidad.Tabla.get_modelo(tabla_sueldos).setValueAt(result, i, 3);
                } catch (NullPointerException | NumberFormatException e) {

                }
            }
        } catch (Exception e) {
            System.err.println("Error en total_sueldos (Empleados)");
            e.getMessage();
        }
    }

    public void antiguedad() {
        //calcula la antiguedad
        for (int i = 0; i < tabla_sueldos.getRowCount(); i++) {
            try {
                double result = 84.64 * Double.valueOf(String.valueOf(Utilidad.Tabla.get_modelo(tabla_sueldos).getValueAt(i, 4)));
                Utilidad.Tabla.get_modelo(tabla_sueldos).setValueAt(result, i, 5);
            } catch (NullPointerException | NumberFormatException e) {
                e.getMessage();
            }
        }

    }

    public void presentismo() {
        //calcula el presentismo
        for (int i = 0; i < tabla_sueldos.getRowCount(); i++) {
            try {
                double result = 0.0833 * Double.parseDouble(String.valueOf(Utilidad.Tabla.get_modelo(tabla_sueldos).getValueAt(i, 3)));
                Utilidad.Tabla.get_modelo(tabla_sueldos).setValueAt(result, i, 6);
            } catch (NullPointerException | NumberFormatException e) {
                e.getMessage();
            }
        }

    }

    public void bruto() {
        //calcula el sueldo bruto
        for (int i = 0; i < tabla_sueldos.getRowCount(); i++) {
            try {
                double result = Double.parseDouble(String.valueOf(Utilidad.Tabla.get_modelo(tabla_sueldos).getValueAt(i, 3))) + Double.parseDouble(String.valueOf(Utilidad.Tabla.get_modelo(tabla_sueldos).getValueAt(i, 5))) + Double.parseDouble(String.valueOf(Utilidad.Tabla.get_modelo(tabla_sueldos).getValueAt(i, 6)));
                Utilidad.Tabla.get_modelo(tabla_sueldos).setValueAt(result, i, 7);
            } catch (NullPointerException | NumberFormatException e) {
                e.getMessage();
            }
        }

    }

    public void tasas(double tasa) {
        //Setea las tasas
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
            e.getMessage();
        }
    }

    public void total_desc() {

        for (int i = 0; i < tabla_sueldos.getRowCount(); i++) {
            try {
                double result = Double.parseDouble(String.valueOf(Utilidad.Tabla.get_modelo(tabla_sueldos).getValueAt(i, 8))) + Double.parseDouble(String.valueOf(Utilidad.Tabla.get_modelo(tabla_sueldos).getValueAt(i, 9))) + Double.parseDouble(String.valueOf(Utilidad.Tabla.get_modelo(tabla_sueldos).getValueAt(i, 10))) + Double.parseDouble(String.valueOf(Utilidad.Tabla.get_modelo(tabla_sueldos).getValueAt(i, 11)));
                Utilidad.Tabla.get_modelo(tabla_sueldos).setValueAt(result, i, 12);
            } catch (NullPointerException | NumberFormatException e) {
                e.getMessage();
            }
        }

    }

    public void total_neto() {

        for (int i = 0; i < tabla_sueldos.getRowCount(); i++) {
            try {
                double result = Double.parseDouble(String.valueOf(Utilidad.Tabla.get_modelo(tabla_sueldos).getValueAt(i, 7))) - Double.parseDouble(String.valueOf(Utilidad.Tabla.get_modelo(tabla_sueldos).getValueAt(i, 12)));
                Utilidad.Tabla.get_modelo(tabla_sueldos).setValueAt(result, i, 13);
            } catch (NullPointerException | NumberFormatException e) {
                e.getMessage();
            }
        }

    }

    public double calculo_total_sueldos() {
        //Realiza el calculo total de los sueldos
        double total = 0;
        for (int i = 0; i < tabla_sueldos.getRowCount(); i++) {
            try {
                total = total + Double.parseDouble(String.valueOf(Utilidad.Tabla.get_modelo(tabla_sueldos).getValueAt(i, 7)));
            } catch (NullPointerException | NumberFormatException e) {
                e.getMessage();
            }
        }
        return total;
    }

    public void arr_sueldos() {
        //crea un arraylist con los sueldos y lo añade a una fila de egresos de IngVsGas CREA WARNING DE SORTING
        try {
            ArrayList sueldos = new ArrayList();
            sueldos.add("Sueldos");
            int selecteditem = combo_años.getSelectedIndex();
            for (int i = 1; i <= combo_años.getItemCount(); i++) {
                combo_años.setSelectedItem("Año " + i);
                importar_emp();
                sueldos.add(calculo_total_sueldos());
            }

            if (Utilidad.Tabla.get_modelo(ingvsgas.getTabla_egresos()).getRowCount() <= 2) {
                //  Utilidad.Tabla.get_modelo(ingvsgas.getTabla_egresos()).addRow(sueldos.toArray());
            } else {
                Utilidad.Tabla.get_modelo(ingvsgas.getTabla_egresos()).removeRow(ingvsgas.getTabla_egresos().getRowCount() - 3);
                Utilidad.Tabla.get_modelo(ingvsgas.getTabla_egresos()).insertRow(ingvsgas.getTabla_egresos().getRowCount() - 2, sueldos.toArray());
            }
            ingvsgas.calculo_totales(ingvsgas.getTabla_egresos(), ingvsgas.getTotal_eg(), ingvsgas.getTotal_eg_iva(), ingvsgas.getSuma_totales_eg(), ingvsgas.getjComboBoxivaeg());
            combo_años.setSelectedIndex(selecteditem);
        } catch (Exception e) {
            System.err.println("Error en arr_sueldos (Empleados)");
            e.printStackTrace();
        }
    }

    public void inicializar_combo() {
        //setea el combo_años
        for (int i = 1; i <= ProjectEvaluator.longevidad; i++) {
            combo_años.addItem("Año " + i);
        }
    }

    //Eventos
    private void combo_añosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo_añosMouseClicked
        //exporta sueldos
        try {
            File sueldos = new File(ProjectEvaluator.direccion + "\\Sueldos\\sueldos año " + (int) (combo_años.getSelectedIndex() + 1) + ".txt");
            Utilidad.Tabla.exportar(sueldos, tabla_sueldos);
        } catch (Exception e) {
            e.getMessage();
        }
    }//GEN-LAST:event_combo_añosMouseClicked

    private void combo_añosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_añosItemStateChanged
        try {
            //importa la nueva tabla
            importar_emp();
            Utilidad.Tabla.filas_defecto(tabla_sueldos, 30);
            //establece valores de empleados
            total_sueldos();
            antiguedad();
            presentismo();
            bruto();
            tasas(tas_jub);
            tasas(tas_ob);
            tasas(tas_ley);
            tasas(tas_sec);
            total_desc();
            total_neto();
            jtf_total_sueldos.setText(String.valueOf(calculo_total_sueldos()));
        } catch (Exception e) {
            System.err.println("Error en combo_añosItemStateChanged (Empleados)");
            e.getMessage();
        }
    }//GEN-LAST:event_combo_añosItemStateChanged

    private void tabla_sueldosPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tabla_sueldosPropertyChange
        //guarda sueldos y luego realiza todos los calculos para la tabla sueldos
        try {
            if (imp_s == true) {
                try {
                    for (int i = 1; i <= ProjectEvaluator.longevidad; i++) {
                        if (combo_años.getSelectedIndex() + 1 == i) {
                            File sueldos = new File(ProjectEvaluator.direccion + "\\Sueldos\\sueldos año " + i + ".txt");
                            Utilidad.Tabla.exportar(sueldos, tabla_sueldos);
                        }
                    }

                } catch (Exception e) {
                    e.getMessage();
                }
                total_sueldos();
                antiguedad();
                presentismo();
                bruto();
                tasas(tas_jub);
                tasas(tas_ob);
                tasas(tas_ley);
                tasas(tas_sec);
                total_desc();
                total_neto();
                jtf_total_sueldos.setText(String.valueOf(calculo_total_sueldos()));
                arr_sueldos();
            }
        } catch (Exception e) {
            System.err.println("Error en tabla_sueldosPropertyChange (Empleados)");
            e.getMessage();
        }
    }//GEN-LAST:event_tabla_sueldosPropertyChange

    private void tabla_tasasPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tabla_tasasPropertyChange
        //guarda y actualiza las tasas
        try {
            Utilidad.Tabla.filas_defecto(tabla_tasas, 1);
            if (imp_tas == true) {
                File tasas = new File(ProjectEvaluator.direccion + "\\Sueldos\\tasas.txt");
                Utilidad.Tabla.exportar(tasas, tabla_tasas);
            }
            tasas(tas_jub);
            tasas(tas_ob);
            tasas(tas_ley);
            tasas(tas_sec);
        } catch (Exception e) {
            System.err.println("Error en tabla_tasasPropertyChange (Empleados)");
            e.getMessage();
        }
    }//GEN-LAST:event_tabla_tasasPropertyChange

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //crea el directorio sueldos
        directorio = new File(ProjectEvaluator.direccion + "\\Sueldos");
        directorio.mkdirs();

    }//GEN-LAST:event_formWindowOpened

    private void btn_añadirfila_sueldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añadirfila_sueldActionPerformed
        //Añade filas a sueldos
        Vector<?> rowData = null;
        Utilidad.Tabla.get_modelo(tabla_sueldos).addRow(rowData);
    }//GEN-LAST:event_btn_añadirfila_sueldActionPerformed

    private void btn_quitarfila_sueldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quitarfila_sueldActionPerformed
        //Quita filas a sueldos, si no se selecciona una fila,se elimina la ultima
        if (tabla_sueldos.getSelectedRowCount() >= 1) {
            do {
                Utilidad.Tabla.get_modelo(tabla_sueldos).removeRow(tabla_sueldos.getSelectedRow());
            } while (tabla_sueldos.getSelectedRowCount() >= 1);
        } else {
            Utilidad.Tabla.get_modelo(tabla_sueldos).removeRow(tabla_sueldos.getRowCount() - 1);
        }
    }//GEN-LAST:event_btn_quitarfila_sueldActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_añadirfila_sueld;
    private javax.swing.JButton btn_quitarfila_sueld;
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

package Frames;

import Clases.Utilidad;
import java.awt.Color;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author Enzo
 */
public class EBITDA extends javax.swing.JFrame {

    private File ebitda_f = new File("C:\\Project evaluator\\ebitda.txt");
    public ArrayList<Double> ingresos = new ArrayList();
    public ArrayList<Double> egresos = new ArrayList();
    private ArrayList arr_ebitda = new ArrayList();
    private ArrayList arr_intereses = new ArrayList();
    private ArrayList arr_sub_s_gan = new ArrayList();
    private ArrayList arr_amort = new ArrayList();
    private ArrayList arr_sub_c_amort = new ArrayList();
    private ArrayList arr_total = new ArrayList();
    private ArrayList arr_riesgo = new ArrayList();
    private ArrayList arr_r_neto = new ArrayList();
    private Riesgo riesgo;
    private Impuestos impuestos;
    private Indicadores indicadores;

    public EBITDA() {

    }

    public EBITDA(Riesgo riesgo, Impuestos impuestos) {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //determina el color del fondo
        getContentPane().setBackground(ProjectEvaluator.fondo);
        this.riesgo = riesgo;
        this.impuestos = impuestos;
    }

    /**
     * @param args the command line arguments
     */
    //Código autogenerado
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtebitda = new javax.swing.JLabel();
        scroll_ebitda = new javax.swing.JScrollPane();
        tabla_EBITDA = new javax.swing.JTable();
        btn_añadirfila_ebitda = new javax.swing.JButton();
        btn_quitarfila_ebitda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EBITDA");
        setBackground(new java.awt.Color(240, 255, 255));
        setLocation(new java.awt.Point(0, 0));
        setSize(new java.awt.Dimension(900, 690));

        txtebitda.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txtebitda.setForeground(new java.awt.Color(240, 255, 255));
        txtebitda.setText("EBITDA");

        tabla_EBITDA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Conceptos y Descripciones"
            }
        ));
        tabla_EBITDA.setFocusable(false);
        tabla_EBITDA.setShowGrid(true);
        scroll_ebitda.setViewportView(tabla_EBITDA);

        btn_añadirfila_ebitda.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_añadirfila_ebitda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_agregar_fila.png"))); // NOI18N
        btn_añadirfila_ebitda.setAutoscrolls(true);
        btn_añadirfila_ebitda.setDefaultCapable(false);
        btn_añadirfila_ebitda.setFocusable(false);
        btn_añadirfila_ebitda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_añadirfila_ebitdaActionPerformed(evt);
            }
        });

        btn_quitarfila_ebitda.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_quitarfila_ebitda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_quitar_fila.png"))); // NOI18N
        btn_quitarfila_ebitda.setDefaultCapable(false);
        btn_quitarfila_ebitda.setFocusable(false);
        btn_quitarfila_ebitda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quitarfila_ebitdaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtebitda, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_añadirfila_ebitda, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_quitarfila_ebitda, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scroll_ebitda, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn_añadirfila_ebitda)
                        .addComponent(btn_quitarfila_ebitda, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(txtebitda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll_ebitda, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Getters
    public File getEbitda() {
        return ebitda_f;
    }

    public JTable getTabla_ebitda() {
        return tabla_EBITDA;
    }

    public ArrayList getArr_total() {
        return arr_total;
    }

    public ArrayList getArr_r_neto() {
        return arr_r_neto;
    }

    public JLabel getTxtebitda() {
        return txtebitda;
    }

    public ArrayList getArr_ebitda() {
        return arr_ebitda;
    }

    public ArrayList getArr_intereses() {
        return arr_intereses;
    }

    public ArrayList getArr_sub_s_gan() {
        return arr_sub_s_gan;
    }

    public ArrayList getArr_amort() {
        return arr_amort;
    }

    public ArrayList getArr_sub_c_amort() {
        return arr_sub_c_amort;
    }

    public ArrayList getArr_riesgo() {
        return arr_riesgo;
    }

    //Setters
    public void setIngresos(ArrayList ingresos) {
        ArrayList aux = new ArrayList();
        this.ingresos.clear();
        this.ingresos.addAll(ingresos);
        this.ingresos.remove(0);
        aux = (ArrayList) this.ingresos.clone();
        aux.add(0, "Ingresos");
        Utilidad.Tabla.check_insert_fila(tabla_EBITDA, 1, aux);
    }

    public void setEgresos(ArrayList egresos) {
        ArrayList aux = new ArrayList();
        this.egresos.clear();
        this.egresos.addAll(egresos);
        this.egresos.remove(0);
        aux = (ArrayList) this.egresos.clone();
        aux.add(0, "Egresos");
        Utilidad.Tabla.check_insert_fila(tabla_EBITDA, 2, aux);
    }

    //Métodos
    public void calculo_ebitda() {
        try {
            //Hace el arraylist de ebitda y lo añade a la tabla
            arr_ebitda.clear();
            if (arr_ebitda.isEmpty() == true) {
                arr_ebitda.add(0, "EBITDA");
                for (int i = 1; i <= ProjectEvaluator.longevidad; i++) {
                    arr_ebitda.add(ingresos.get(i - 1) - egresos.get(i - 1));
                }
            } else {
                for (int i = 1; i <= ProjectEvaluator.longevidad; i++) {
                    arr_ebitda.set(i, ingresos.get(i - 1) - egresos.get(i - 1));
                }
            }
            Utilidad.Tabla.check_insert_fila(tabla_EBITDA, 3, arr_ebitda);
        } catch (Exception e) {
            System.err.println("Error en Calculo_EBITDA");
        }
    }

    public void calculo_intereses() {
        //Hace el arraylist de intereses y lo añade a la tabla
        arr_intereses.clear();
        if (arr_intereses.isEmpty() == true) {
            arr_intereses.add(0, "Intereses");
        }
        for (int i = 0; i < ProjectEvaluator.longevidad; i++) {
            arr_intereses.add(0.0);
        }
        Utilidad.Tabla.check_insert_fila(tabla_EBITDA, 6, arr_intereses);
    }

    public void calculo_subt_s_gan() {
        //Hace el arraylist de subtotal sin ganancias
        arr_sub_s_gan.clear();
        if (arr_sub_s_gan.isEmpty() == true) {
            arr_sub_s_gan.add(0, "Subtotal sin ganancias");
        }
        for (int i = 1; i <= ProjectEvaluator.longevidad; i++) {
            arr_sub_s_gan.add((double) arr_ebitda.get(i) - (double) impuestos.getArr_ing_br().get(i) - (double) impuestos.getArr_iva().get(i) - (double) arr_intereses.get(i));
        }
        Utilidad.Tabla.check_insert_fila(tabla_EBITDA, 7, arr_sub_s_gan);
    }

    public void calculo_amortizaciones() {
        //Hace el arraylist de amortizaciones
        arr_amort.clear();
        if (arr_amort.isEmpty() == true) {
            arr_amort.add(0, "Amortizaciones");
        }
        for (int i = 1; i <= ProjectEvaluator.longevidad; i++) {
            arr_amort.add(0.0);
        }
        Utilidad.Tabla.check_insert_fila(tabla_EBITDA, 8, arr_amort);
    }

    public void calculo_sub_c_amort() {
        //Hace el arraylist de subtotal con amortizaciones y lo añade a la tabla
        arr_sub_c_amort.clear();
        if (arr_sub_c_amort.isEmpty() == true) {
            arr_sub_c_amort.add(0, "Subtotal con Amortizacion");
        }
        for (int i = 1; i <= ProjectEvaluator.longevidad; i++) {
            arr_sub_c_amort.add((double) arr_sub_s_gan.get(i) - (double) arr_amort.get(i));
        }
        Utilidad.Tabla.check_insert_fila(tabla_EBITDA, 9, arr_sub_c_amort);
    }

    public void calculo_total() {
        //Hace el arraylist de calculo total y lo añade a la tabla
        arr_total.clear();
        if (arr_total.isEmpty() == true) {
            arr_total.add(0, "Total con Ing/Iva/interes/Gan");
        }
        for (int i = 1; i <= ProjectEvaluator.longevidad; i++) {
            arr_total.add((double) arr_sub_s_gan.get(i) - (double) impuestos.getArr_ganancias().get(i));
        }
        Utilidad.Tabla.check_insert_fila(tabla_EBITDA, 11, arr_total);
    }

    public void calculo_riesgo() {
        //Hace el arraylist de arr_riesgo y lo inserta en la tabla
        arr_riesgo.clear();
        double acum = 0;
        Utilidad.Tabla.inicializar_col(riesgo.getTabla_riesgos());
        Utilidad.Tabla.importar(riesgo.getRiesgos(), riesgo.getTabla_riesgos());
        Utilidad.Tabla.filas_defecto(riesgo.getTabla_riesgos(), 70);
        riesgo.setImp(true);
        riesgo.valor_riesgo();
        if (arr_riesgo.isEmpty() == true) {
            arr_riesgo.add(0, "Riesgo");
        }
        try {
            for (int i = 0; i < riesgo.getTabla_riesgos().getRowCount(); i++) {
                acum = acum + Double.parseDouble(String.valueOf(riesgo.getTabla_riesgos().getValueAt(i, 9)));
            }
        } catch (NumberFormatException e) {
            e.getMessage();
        }
        arr_riesgo.add(acum);
        for (int i = 1; i < ProjectEvaluator.longevidad; i++) {
            acum = acum * 1.1;
            arr_riesgo.add(acum);
        }
        Utilidad.Tabla.check_insert_fila(tabla_EBITDA, 13, arr_riesgo);
    }

    public void calculo_r_neto() {
        //Hace el arraylist de resultado neto y lo inserta en la tabla
        arr_r_neto.clear();
        if (arr_r_neto.isEmpty() == true) {
            arr_r_neto.add(0, "R.Neto Mitigado el Riesgo");
        }
        for (int i = 1; i <= ProjectEvaluator.longevidad; i++) {
            try {
                arr_r_neto.add(Double.parseDouble(String.valueOf(arr_total.get(i))) - Double.parseDouble(String.valueOf(arr_riesgo.get(i))));
            } catch (NumberFormatException e) {
                e.getMessage();
            }
        }
        Utilidad.Tabla.check_insert_fila(tabla_EBITDA, 14, arr_r_neto);
    }

    private void btn_añadirfila_ebitdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añadirfila_ebitdaActionPerformed
        //Añade filas a cred
        Vector<?> rowData = null;
        Utilidad.Tabla.get_modelo(tabla_EBITDA).addRow(rowData);
    }//GEN-LAST:event_btn_añadirfila_ebitdaActionPerformed

    private void btn_quitarfila_ebitdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quitarfila_ebitdaActionPerformed
        //Quita filas a cred, si no se selecciona una fila,se elimina la ultima
        try {
            if (tabla_EBITDA.getSelectedRowCount() >= 1) {
                do {
                    Utilidad.Tabla.get_modelo(tabla_EBITDA).removeRow(tabla_EBITDA.getSelectedRow());
                } while (tabla_EBITDA.getSelectedRowCount() >= 1);
            } else {
                Utilidad.Tabla.get_modelo(tabla_EBITDA).removeRow(tabla_EBITDA.getRowCount() - 1);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("No se pueden remover mas filas.");
            e.getMessage();
        }
    }//GEN-LAST:event_btn_quitarfila_ebitdaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_añadirfila_ebitda;
    private javax.swing.JButton btn_quitarfila_ebitda;
    private javax.swing.JScrollPane scroll_ebitda;
    private javax.swing.JTable tabla_EBITDA;
    private javax.swing.JLabel txtebitda;
    // End of variables declaration//GEN-END:variables

}

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
    private ArrayList vpi = new ArrayList();
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

    public ArrayList calculo_van(ArrayList flujos, String titulo) {

        ArrayList resultado = new ArrayList();
        try {
            double acum = 0;
            for (int i = 1; i <= ProjectEvaluator.longevidad; i++) {
                //suma todos los VA correspondiendo a la cantidad de años
                for (int t = 1; t <= i; t++) {
                    acum = acum + Double.parseDouble(String.valueOf(flujos.get(t))) / Math.pow(1 + (tasa_interes / 100), t);
                }
                //resta la inv
                acum = acum - ingvsgas.inv;
                resultado.add(acum);
                acum = 0;
            }
            resultado.add(0, titulo);
        } catch (Exception e) {
            System.err.println("Error en calculo_van (Indicadores)");
            e.printStackTrace();
        }
        return resultado;
    }

    public void añadir_indicadores() {
        try {
            //se añade el van sin riesgo
            van.clear();
            van.addAll(calculo_van(ebitda.getArr_total(), "VAN (Sin Riesgo)"));
            Utilidad.Tabla.check_insert_fila(tabla_indicadores, 1, van);

            //se añade el van con riesgo
            van_r.clear();
            van_r.addAll(calculo_van(ebitda.getArr_r_neto(), "VAN (Con Riesgo)"));
            Utilidad.Tabla.check_insert_fila(tabla_indicadores, 2, van_r);

            //se añade el ivan
            ivan.clear();
            ivan.addAll(calculo_ivan(van, "IVAN (Sin Riesgo)"));
            Utilidad.Tabla.check_insert_fila(tabla_indicadores, 3, ivan);

            //se añade el ivan con riesgo
            ivan_r.clear();
            ivan_r.addAll(calculo_ivan(van_r, "IVAN (Con Riesgo)"));
            Utilidad.Tabla.check_insert_fila(tabla_indicadores, 4, ivan_r);

            //se añade la TIR sin riesgo
            tir.clear();
            tir.addAll(calculo_TIR(ebitda.getArr_total(), "TIR (Sin Riesgo)"));
            Utilidad.Tabla.check_insert_fila(tabla_indicadores, 5, tir);

            //se añade la TIR con riesgo
            tir_r.clear();
            tir_r.addAll(calculo_TIR(ebitda.getArr_r_neto(), "TIR (Con Riesgo)"));
            Utilidad.Tabla.check_insert_fila(tabla_indicadores, 6, tir_r);

            //se añade el vpi
            vpi.clear();
            vpi.addAll(calculo_van(ingvsgas.getSuma_totales_ing(), "VPI"));
            Utilidad.Tabla.check_insert_fila(tabla_indicadores, 7, vpi);

            //se añade el vac
            vac.clear();
            vac.addAll(calculo_van(ingvsgas.getSuma_totales_eg(), "VAC"));
            Utilidad.Tabla.check_insert_fila(tabla_indicadores, 8, vac);

            //se añade razon b/c
            razonbc.clear();
            razonbc.addAll(calculo_razonBC());
            Utilidad.Tabla.check_insert_fila(tabla_indicadores, 9, razonbc);

            //se añade el payback
            Utilidad.Tabla.check_insert_fila(tabla_indicadores, 10, ebitda.getArr_payback());

            //se añade el payback (tiempo)
            payback_tiempo();

        } catch (Exception e) {
            System.err.println("Error en añadir_valores_actuales (Indicadores)");
            e.printStackTrace();
        }
    }

    public ArrayList calculo_ivan(ArrayList flujos, String titulo) {

        ArrayList resultado = new ArrayList();
        try {

            for (int t = 1; t <= ProjectEvaluator.longevidad; t++) {
                resultado.add(Double.parseDouble(String.valueOf(flujos.get(t))) / ingvsgas.inv);
            }
            resultado.add(0, titulo);

        } catch (Exception e) {
            System.err.println("Error en calculo_ivan (Indicadores)");
            e.printStackTrace();
        }
        return resultado;
    }

    public ArrayList calculo_TIR(ArrayList flujos_list, String titulo) {

        ArrayList resultado = new ArrayList();
        try {
            double[] flujos = new double[ebitda.getArr_total().size()];
            //se inserta la inversion en los flujos
            flujos[0] = Double.parseDouble(String.valueOf(ingvsgas.getJtf_inv().getText())) * -1;
            for (int j = 1; j <= ProjectEvaluator.longevidad; j++) {
                for (int i = 1; i <= j; i++) {
                    flujos[i] = Double.parseDouble(String.valueOf(flujos_list.get(i)));

                }
                resultado.add(Irr.irr(flujos, 0) * 100);
            }
            resultado.add(0, titulo);

        } catch (Exception e) {
            System.err.println("Error en Calculo_TIR (Indicadores)");
            e.printStackTrace();
        }
        return resultado;
    }

    public ArrayList calculo_razonBC() {

        ArrayList resultado = new ArrayList();
        try {
            for (int t = 1; t <= ProjectEvaluator.longevidad; t++) {
                resultado.add(Double.parseDouble(String.valueOf(vpi.get(t))) / Double.parseDouble(String.valueOf(vac.get(t))));
            }
            resultado.add(0, "Razón B/C");

        } catch (Exception e) {
            System.err.println("Error en calculo_razonBC (Indicadores)");
            e.printStackTrace();
        }
        return resultado;
    }

    public int buscar_periodo_payback() {
        //busca el periodo en el que el payback da 0 o positivo
        int periodo = -1;
        for (int i = 1; i <= ProjectEvaluator.longevidad; i++) {
            if ((double) ebitda.getArr_payback().get(i) >= 0) {
                periodo = i;
                break;
            }
        }
        return periodo;
    }

    public void payback_tiempo() {
        // se realiza el calculo en tiempo del payback
        int periodo = buscar_periodo_payback();
        int periodo_ant = 1;

        if (periodo != -1) {
            if (periodo > 1) {
                periodo_ant = periodo - 1;
            }
            double tiempo;
            double diferencia = -(double) ebitda.getArr_ebitda().get(periodo_ant) + (double) ebitda.getArr_ebitda().get(periodo);
            try {
                tiempo = 12 * -(double) ebitda.getArr_payback().get(periodo_ant) / diferencia;

                //Años
                String años;
                if (periodo == 1) {
                    años = "1 Año";
                } else {
                    años = periodo + " Años";
                }

                //calculo parte decimal del tiempo
                System.out.println(tiempo);
                double parteDecimal = tiempo % 1;
                System.out.println(parteDecimal);
                //calculo parte entera del tiempo
                int parteEntera = (int) (tiempo - parteDecimal);

                //Meses
                String meses;
                if (parteEntera == 1) {
                    meses = String.valueOf("1 Mes");

                } else {
                    meses = String.valueOf(parteEntera + " Meses");
                }

                //Días
                String dias;
                if (parteDecimal * 30 == 1) {
                    dias = "1 Día";
                } else {
                    //redondea a techo el decimal
                    dias = (int) Math.ceil(parteDecimal * 30) + " Días";
                }
                
                String payback= años+","+meses+" y "+dias;
                jtf_payback.setText(payback);
                
            } catch (Exception e) {
                e.getMessage();
            }
        }else{
          jtf_payback.setText("No se encontró el Payback.");
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
        txtpayback = new javax.swing.JLabel();
        jtf_payback = new javax.swing.JTextField();

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
        tabla_indicadores.setFocusable(false);
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

        txtpayback.setBackground(new java.awt.Color(255, 255, 255));
        txtpayback.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        txtpayback.setForeground(new java.awt.Color(255, 255, 255));
        txtpayback.setText("Payback (Tiempo)");

        jtf_payback.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jtf_payback.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtf_payback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_paybackActionPerformed(evt);
            }
        });
        jtf_payback.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtf_paybackPropertyChange(evt);
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
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtpayback)
                            .addComponent(jtf_payback, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btn_añadirfila_ind))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtpayback)
                                .addGap(1, 1, 1)
                                .addComponent(jtf_payback, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
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
        try {
            setear_interes();
            añadir_indicadores();
            /*    calculo_ivan();
            calculo_ivan_r(); */
            Utilidad.JtextField.exportar_jtf(interes, jtf_interes);
        } catch (Exception e) {
            System.err.println("Error en jtf_interesActionPerformed (Indicadores)");
            e.printStackTrace();
        }
    }//GEN-LAST:event_jtf_interesActionPerformed

    private void jtf_interesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtf_interesPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_interesPropertyChange

    private void tabla_indicadoresPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tabla_indicadoresPropertyChange
        // TODO add your handling code here:
        //inicializa ingvsgas
        try {
            if (imp == true) {
                //inicializa indicadores
                Utilidad.JtextField.importar_jtf(interes, jtf_interes);
                setear_interes();
                Utilidad.JtextField.importar_jtf(ingvsgas.inversion, ingvsgas.getJtf_inv());
                //calculo van 
                añadir_indicadores();
                /*   calculo_ivan();
                calculo_ivan_r();
                calculo_TIR();
                calculo_vac();
                calculo_razonBC(); */

                try {
                    Utilidad.Tabla.exportar(indicadores, tabla_indicadores);
                } catch (Exception e) {
                    System.err.println("Error al guardar los datos en Indicadores");
                }
            }
        } catch (Exception e) {
            System.err.println("Error en tabla_indicadoresPropertyChange (Indicadores)");
            e.printStackTrace();
        }
    }//GEN-LAST:event_tabla_indicadoresPropertyChange

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowOpened

    private void jtf_paybackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_paybackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_paybackActionPerformed

    private void jtf_paybackPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtf_paybackPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_paybackPropertyChange

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_añadirfila_ind;
    private javax.swing.JButton btn_quitarfila_ind;
    private javax.swing.JTextField jtf_interes;
    private javax.swing.JTextField jtf_payback;
    private javax.swing.JScrollPane scroll_indicadores;
    private javax.swing.JTable tabla_indicadores;
    private javax.swing.JLabel txtindicadores;
    private javax.swing.JLabel txtinteres;
    private javax.swing.JLabel txtpayback;
    // End of variables declaration//GEN-END:variables
}

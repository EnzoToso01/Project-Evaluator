package Frames;

import Clases.Utilidad;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import org.apache.poi.ss.formula.functions.Irr;

/**
 *
 * @author Enzo
 */
public class Indicadores extends javax.swing.JFrame {

    private File indicadores = new File(ProjectEvaluator.direccion + "\\indicadores.txt");
    ;
    private File interes = new File(ProjectEvaluator.direccion + "\\interes.txt");
    private ArrayList van = new ArrayList();
    private ArrayList van_r = new ArrayList();
    private ArrayList ivan = new ArrayList();
    private ArrayList ivan_r = new ArrayList();
    private ArrayList tir = new ArrayList();
    private ArrayList tir_r = new ArrayList();
    private ArrayList vpi = new ArrayList();
    private ArrayList vac = new ArrayList();
    private ArrayList razonbc = new ArrayList();
    private ArrayList arr_payback = new ArrayList();
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
        getContentPane().setBackground(ProjectEvaluator.fondo);
        this.ebitda = ebitda;
        this.ingvsgas = ingvsgas;
        jtf_interes.setText("0.0");

    }

    //Código autogenerado
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
        txtmensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Indicadores");
        setBackground(new java.awt.Color(240, 255, 255));
        setSize(new java.awt.Dimension(900, 690));

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
        tabla_indicadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_indicadoresMouseClicked(evt);
            }
        });
        tabla_indicadores.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tabla_indicadoresPropertyChange(evt);
            }
        });
        scroll_indicadores.setViewportView(tabla_indicadores);

        btn_añadirfila_ind.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_añadirfila_ind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_agregar_fila.png"))); // NOI18N
        btn_añadirfila_ind.setAutoscrolls(true);
        btn_añadirfila_ind.setDefaultCapable(false);
        btn_añadirfila_ind.setFocusable(false);
        btn_añadirfila_ind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_añadirfila_indActionPerformed(evt);
            }
        });

        btn_quitarfila_ind.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_quitarfila_ind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_quitar_fila.png"))); // NOI18N
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

        txtpayback.setBackground(new java.awt.Color(255, 255, 255));
        txtpayback.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        txtpayback.setForeground(new java.awt.Color(255, 255, 255));
        txtpayback.setText("Payback (Tiempo)");

        jtf_payback.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jtf_payback.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll_indicadores)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtinteres)
                                    .addComponent(jtf_interes, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtf_payback, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtpayback))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtmensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtindicadores, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(btn_añadirfila_ind, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_quitarfila_ind, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btn_añadirfila_ind)
                                .addComponent(btn_quitarfila_ind, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtindicadores, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtpayback)
                                        .addGap(25, 25, 25))
                                    .addComponent(txtmensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(txtinteres)
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtf_interes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_payback, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)))
                .addComponent(scroll_indicadores, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Getters
    public JTable getTabla_indicadores() {
        return tabla_indicadores;
    }

    public File getIndicadores() {
        indicadores = new File(ProjectEvaluator.direccion + "indicadores.txt");
        return indicadores;
    }

    public File getInteres() {
        interes = new File(ProjectEvaluator.direccion + "\\interes.txt");
        return interes;
    }

    public ArrayList getVan() {
        return van;
    }

    public ArrayList getVan_r() {
        return van_r;
    }

    public JTextField getJtf_interes() {
        return jtf_interes;
    }

    public JLabel getTxtindicadores() {
        return txtindicadores;
    }

    public ArrayList getArr_payback() {
        return arr_payback;
    }

    //Setters
    public void setear_interes() {
        try {
            tasa_interes = Double.parseDouble(jtf_interes.getText());
        } catch (NumberFormatException e) {

        }
    }

    public void setImp(boolean imp) {
        this.imp = imp;
    }

    //Métodos
    public void añadir_indicadores() {
        try {
            //Añade los indicadores a la tabla
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
            vpi.addAll(calculo_va(ingvsgas.getSuma_totales_ing(), "VPI"));
            Utilidad.Tabla.check_insert_fila(tabla_indicadores, 7, vpi);

            //se añade el vac
            vac.clear();
            vac.addAll(calculo_va(ingvsgas.getSuma_totales_eg(), "VAC"));
            Utilidad.Tabla.check_insert_fila(tabla_indicadores, 8, vac);

            //se añade razon b/c
            razonbc.clear();
            razonbc.addAll(calculo_razonBC());
            Utilidad.Tabla.check_insert_fila(tabla_indicadores, 9, razonbc);

            //se añade el payback descontado (tiempo)
            payback_tiempo();

        } catch (Exception e) {
            System.err.println("Error en añadir_valores_actuales (Indicadores)");
            e.getMessage();
            e.printStackTrace();
        }
    }

    public ArrayList calculo_va(ArrayList flujos, String titulo) {
        //hace los valores actuales de un arraylist
        ArrayList resultado = new ArrayList();
        for (int i = 1; i <= ProjectEvaluator.longevidad; i++) {
            resultado.add(Double.parseDouble(String.valueOf(flujos.get(i))) / Math.pow(1 + (tasa_interes / 100), i));
        }
        resultado.add(0, titulo);
        return resultado;
    }

    public ArrayList calculo_van(ArrayList flujos, String titulo) {
        //hace el calculo van
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
        } catch (NumberFormatException e) {
            System.err.println("Error en calculo_van (Indicadores)");
            e.getMessage();
        }
        return resultado;
    }

    public ArrayList calculo_ivan(ArrayList flujos, String titulo) {
        //Calcula el IVAN
        ArrayList resultado = new ArrayList();
        try {

            for (int t = 1; t <= ProjectEvaluator.longevidad; t++) {
                resultado.add(Double.parseDouble(String.valueOf(flujos.get(t))) / ingvsgas.inv);
            }
            resultado.add(0, titulo);

        } catch (Exception e) {
            System.err.println("Error en calculo_ivan (Indicadores)");
            e.getMessage();
        }
        return resultado;
    }

    public ArrayList calculo_TIR(ArrayList flujos_list, String titulo) {
        //Calcula la TIR
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
            e.getMessage();
        }
        return resultado;
    }

    public ArrayList calculo_razonBC() {
        //Calcula la RazonBC
        ArrayList resultado = new ArrayList();
        try {
            for (int t = 1; t <= ProjectEvaluator.longevidad; t++) {
                resultado.add(Double.parseDouble(String.valueOf(vpi.get(t))) / Double.parseDouble(String.valueOf(vac.get(t))));
            }
            resultado.add(0, "Razón B/C");

        } catch (Exception e) {
            System.err.println("Error en calculo_razonBC (Indicadores)");
            e.getMessage();
        }
        return resultado;
    }

    public int buscar_periodo_payback() {
        //busca el periodo en el que el payback da 0 o positivo
        int periodo = -1;
        for (int i = 1; i <= ProjectEvaluator.longevidad; i++) {
            if ((double) van.get(i) >= 0) {
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
            ArrayList va  = calculo_va(ebitda.getArr_total(), "VA");
            double diferencia = -(double) van.get(periodo_ant);
            try {
                tiempo = 12 * (diferencia / (double) va.get(periodo));
                //Años
                String años;
                if (periodo == 1) {
                    años = "1 Año";
                } else {
                    años = Math.abs(periodo) + " Años";
                }
                //calculo parte decimal del tiempo      
                double parteDecimal = tiempo % 1;
                //calculo parte entera del tiempo
                int parteEntera = (int) (tiempo - parteDecimal);
                //Meses
                String meses;
                if (parteEntera == 1) {
                    meses = String.valueOf("1 Mes");
                } else {
                    meses = String.valueOf(Math.abs(parteEntera) + " Meses");
                }
                //Días
                String dias;
                if (parteDecimal * 30 == 1) {
                    dias = "1 Día";
                } else {
                    //redondea a techo el decimal
                    dias = (int) Math.abs(Math.ceil(parteDecimal * 30)) + " Días";
                }
                String payback = años + "," + meses + " y " + dias;
                jtf_payback.setText(payback);
            } catch (Exception e) {
                e.getMessage();
            }
        } else {
            jtf_payback.setText("No se encontró el Payback.");
        }
    }

    public void setmensaje(int fila_selecionada) {
        // Establece la conclusión del indicador en un texto.
        switch (fila_selecionada) {
            case 0:
                if ((double) van.get(van.size() - 1) < 0) {
                    txtmensaje.setText("<HTML> Desde el punto de vista del VAN (Sin riesgo)<br>el proyecto no es recomendable.</HTML>");
                } else if ((double) van.get(van.size() - 1) == 0) {
                    txtmensaje.setText("<HTML> Desde el punto de vista del VAN (Sin riesgo)<br>el proyecto tiene el mismo beneficio que su alternativa.</HTML>");
                } else {
                    txtmensaje.setText("<HTML> Desde el punto de vista del VAN (Sin riesgo)<br>el proyecto es recomendable.</HTML>");
                }
                break;
            case 1:
                if ((double) van.get(van.size() - 1) < 0) {
                    txtmensaje.setText("<HTML> Desde el punto de vista del VAN (Con riesgo)<br>el proyecto no es recomendable,verifique los riesgos.</HTML>");
                } else if ((double) van.get(van.size() - 1) == 0) {
                    txtmensaje.setText("<HTML> Desde el punto de vista del VAN (Con riesgo)<br>el proyecto tiene el mismo beneficio que su alternativa.</HTML>");
                } else {
                    txtmensaje.setText("<HTML> Desde el punto de vista del VAN (Con riesgo)<br>el proyecto es recomendable.</HTML>");
                }
                break;
            case 2:
                if ((double) ivan.get(ivan.size() - 1) < 0) {
                    txtmensaje.setText("<HTML> Desde el punto de vista del IVAN (Sin riesgo)<br>el beneficio no compensa la inversión.</HTML>");
                } else if ((double) ivan.get(ivan.size() - 1) == 0) {
                    txtmensaje.setText("<HTML> El VAN (Sin riesgo) esta en 0,por lo tanto la relación es 0.</HTML>");
                } else {
                    txtmensaje.setText("<HTML> Desde el punto de vista del IVAN (Sin riesgo)<br>el beneficio si compensa la inversión.</HTML>");
                }
                break;
            case 3:
                if ((double) ivan_r.get(ivan_r.size() - 1) < 0) {
                    txtmensaje.setText("<HTML> Desde el punto de vista del IVAN (Con riesgo)<br>el beneficio no compensa la inversión,verifique los riesgos.</HTML>");
                } else if ((double) ivan.get(ivan_r.size() - 1) == 0) {
                    txtmensaje.setText("<HTML>El VAN (Con riesgo) esta en 0,por lo tanto la relación es 0.</HTML>");
                } else {
                    txtmensaje.setText("<HTML> Desde el punto de vista del IVAN (Con riesgo)<br>el beneficio si compensa la inversión.</HTML>");
                }
                break;
            case 4:
                if ((double) tir.get(tir.size() - 1) <= 0) {
                    txtmensaje.setText("<HTML> Desde el punto de vista de la TIR (Sin riesgo)<br>el proyecto no es rentable.</HTML>");
                } else {
                    txtmensaje.setText("<HTML> Desde el punto de vista de la TIR (Sin riesgo)<br>el proyecto si es rentable.</HTML>");
                }
                break;
            case 5:
                if ((double) tir_r.get(tir_r.size() - 1) <= 0) {
                    txtmensaje.setText("<HTML> Desde el punto de vista de la TIR (Con riesgo)<br>el proyecto no es rentable,verifique los riesgos.</HTML>");
                } else {
                    txtmensaje.setText("<HTML> Desde el punto de vista de la TIR (Con riesgo)<br>el proyecto si es rentable.</HTML>");
                }
                break;
            case 8:
                if ((double) razonbc.get(razonbc.size() - 1) <= 0) {
                    txtmensaje.setText("<HTML> Desde el punto de vista de la Razón B/C <br>el beneficio no compensa los costos.</HTML>");
                } else {
                    txtmensaje.setText("<HTML> Desde el punto de vista de la Razón B/C <br>el beneficio si compensa los costos.</HTML>");
                }
                break;
            default:
                txtmensaje.setText("");
                System.err.println("Fila selecionada invalida.");
                break;
        }

    }

    //Eventos
    private void btn_añadirfila_indActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añadirfila_indActionPerformed
        //Añade filas a ingresos
        Vector<?> rowData = null;
        Utilidad.Tabla.get_modelo(tabla_indicadores).addRow(rowData);
    }//GEN-LAST:event_btn_añadirfila_indActionPerformed

    private void btn_quitarfila_indActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quitarfila_indActionPerformed
        //Quita filas a idicadores, si no se selecciona una fila,se elimina la ultima
        try {
            if (tabla_indicadores.getSelectedRowCount() >= 1) {
                do {
                    Utilidad.Tabla.get_modelo(tabla_indicadores).removeRow(tabla_indicadores.getSelectedRow());
                } while (tabla_indicadores.getSelectedRowCount() >= 1);
            } else {
                Utilidad.Tabla.get_modelo(tabla_indicadores).removeRow(tabla_indicadores.getRowCount() - 1);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("No se pueden remover mas filas.");
            e.getMessage();
        }
    }//GEN-LAST:event_btn_quitarfila_indActionPerformed

    private void jtf_interesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_interesActionPerformed
        //setea intereses y indicadores,guarda intereses jtf, tambien setea el texto mensaje vacio
        try {
            setear_interes();
            añadir_indicadores();
            Utilidad.JtextField.exportar_jtf(interes, jtf_interes);
            txtmensaje.setText("");
        } catch (Exception e) {
            System.err.println("Error en jtf_interesActionPerformed (Indicadores)");
            e.getMessage();
        }
    }//GEN-LAST:event_jtf_interesActionPerformed

    private void tabla_indicadoresPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tabla_indicadoresPropertyChange
        //setea intereses,inversion,indicadores.
        try {
            if (imp == true) {
                //inicializa indicadores
                Utilidad.JtextField.importar_jtf(interes, jtf_interes);
                setear_interes();
                Utilidad.JtextField.importar_jtf(ingvsgas.inversion, ingvsgas.getJtf_inv());
                añadir_indicadores();
                try {
                    Utilidad.Tabla.exportar(indicadores, tabla_indicadores);
                } catch (Exception e) {
                    System.err.println("Error al guardar los datos en Indicadores");
                }
            }
        } catch (Exception e) {
            System.err.println("Error en tabla_indicadoresPropertyChange (Indicadores)");
            e.getMessage();
        }
    }//GEN-LAST:event_tabla_indicadoresPropertyChange

    private void tabla_indicadoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_indicadoresMouseClicked
        // TODO add your handling code here:
        setmensaje(tabla_indicadores.getSelectedRow());
    }//GEN-LAST:event_tabla_indicadoresMouseClicked

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
    private javax.swing.JLabel txtmensaje;
    private javax.swing.JLabel txtpayback;
    // End of variables declaration//GEN-END:variables
}

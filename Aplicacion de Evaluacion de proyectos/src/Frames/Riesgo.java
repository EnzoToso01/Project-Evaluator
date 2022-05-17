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

   
    private File riesgos = new File("C:\\Project evaluator\\riesgos.txt");
    private double prob;
    private double impacto;
    private double exposicion;
    private double valor;
    private boolean imp;

    public Riesgo() {
        initComponents();
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //determina el color del fondo
        Color a = new Color(40, 44, 52);
        getContentPane().setBackground(a);
        Color b = new Color(26, 29, 34);
        tabla_riesgos.getTableHeader().setBackground(b);
        imp = false;

    }

    //Código autogenerado
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll_riesg = new javax.swing.JScrollPane();
        tabla_riesgos = new javax.swing.JTable();
        txtriesgos = new javax.swing.JLabel();

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtriesgos, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scroll_riesg, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
                        .addGap(28, 28, 28))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(txtriesgos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
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
            for (int i = 0; i < tabla_riesgos.getRowCount(); i++) {
                double result = Double.valueOf(String.valueOf(tabla_riesgos.getValueAt(i, 5))) / 100 * Double.valueOf(String.valueOf(tabla_riesgos.getValueAt(i, 7)));
                tabla_riesgos.setValueAt(result, i, 9);
            }
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            for (int i = 0; i < tabla_riesgos.getRowCount(); i++) {
                tabla_riesgos.setValueAt("", i, 5);
                tabla_riesgos.setValueAt("", i, 7);
            }
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

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane scroll_riesg;
    private javax.swing.JTable tabla_riesgos;
    private javax.swing.JLabel txtriesgos;
    // End of variables declaration//GEN-END:variables
}

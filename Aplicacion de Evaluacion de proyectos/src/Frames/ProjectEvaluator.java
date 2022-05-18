package Frames;

import Clases.Utilidad;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkContrastIJTheme;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Enzo
 */
public class ProjectEvaluator extends javax.swing.JFrame {

    public static int longevidad = 5;
    public static boolean import_ingeg = false;
    private Credito credito;
    private Riesgo riesgo;
    private EBITDA ebitda;
    private Impuestos impuestos;
    private IngVsGas ingvsgas;
    private Empleados empleados;
    private Indicadores indicadores;
    private File nombredelproyecto_f;
    private File añosvidaproyecto_f;
    private File ult_proyecto;
    public static String direccion;

    public ProjectEvaluator() {
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/icono_app.png")));
        //crea los objetos de los demas jframes
        credito = new Credito();
        riesgo = new Riesgo();
        impuestos = new Impuestos();
        ebitda = new EBITDA(riesgo, impuestos);
        ingvsgas = new IngVsGas(ebitda, impuestos);
        empleados = new Empleados(ingvsgas);
        indicadores = new Indicadores(ebitda, ingvsgas);
    }

    public static void main(String args[]) {

        try {
            FlatAtomOneDarkContrastIJTheme.setup();
        } catch (Exception e) {
            e.getMessage();
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProjectEvaluator p = new ProjectEvaluator();
                p.setVisible(true);

            }

        });

    }

    //Código autogenerado
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtañosvida = new javax.swing.JLabel();
        txtnombreproyecto = new javax.swing.JLabel();
        jtf_nombreproyecto = new javax.swing.JTextField();
        jtf_añosvida = new javax.swing.JTextField();
        panel_negro = new javax.swing.JPanel();
        panel_IngVsGas = new javax.swing.JPanel();
        btn_IngVsGas = new javax.swing.JButton();
        panel_indicadores = new javax.swing.JPanel();
        btn_indicadores = new javax.swing.JButton();
        panel_empleados = new javax.swing.JPanel();
        btn_empleados = new javax.swing.JButton();
        panel_impuestos = new javax.swing.JPanel();
        btn_impuestos = new javax.swing.JButton();
        panel_credito = new javax.swing.JPanel();
        btn_credito = new javax.swing.JButton();
        panel_riesgo = new javax.swing.JPanel();
        btn_riesgo = new javax.swing.JButton();
        panel_EBITDA = new javax.swing.JPanel();
        btn_EBITDA = new javax.swing.JButton();
        panel_azul = new javax.swing.JPanel();
        txtTitulo = new javax.swing.JLabel();
        panel_azul_oscuro = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú Principal");
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);
        setSize(new java.awt.Dimension(773, 630));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtañosvida.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtañosvida.setForeground(new java.awt.Color(255, 255, 255));
        txtañosvida.setText("Longevidad del proyecto (años)");
        getContentPane().add(txtañosvida, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, -1, -1));

        txtnombreproyecto.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtnombreproyecto.setForeground(new java.awt.Color(255, 255, 255));
        txtnombreproyecto.setText("Nombre del proyecto");
        getContentPane().add(txtnombreproyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, -1, -1));

        jtf_nombreproyecto.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jtf_nombreproyecto.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtf_nombreproyecto.setText(" Ingrese el nombre de su proyecto...");
        jtf_nombreproyecto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtf_nombreproyecto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtf_nombreproyectoMousePressed(evt);
            }
        });
        jtf_nombreproyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_nombreproyectoActionPerformed(evt);
            }
        });
        getContentPane().add(jtf_nombreproyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 260, 30));

        jtf_añosvida.setText(" Ej:5");
        jtf_añosvida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtf_añosvida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtf_añosvidaMousePressed(evt);
            }
        });
        jtf_añosvida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_añosvidaActionPerformed(evt);
            }
        });
        getContentPane().add(jtf_añosvida, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 260, 30));

        panel_negro.setBackground(new java.awt.Color(0, 0, 0));

        panel_IngVsGas.setBackground(new java.awt.Color(0, 0, 0));

        btn_IngVsGas.setBackground(new java.awt.Color(0, 0, 0));
        btn_IngVsGas.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btn_IngVsGas.setForeground(new java.awt.Color(255, 255, 255));
        btn_IngVsGas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Ingresos_y_Egresos.png"))); // NOI18N
        btn_IngVsGas.setText("Ingresos y Egresos");
        btn_IngVsGas.setBorder(null);
        btn_IngVsGas.setBorderPainted(false);
        btn_IngVsGas.setContentAreaFilled(false);
        btn_IngVsGas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_IngVsGas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_IngVsGasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_IngVsGasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_IngVsGasMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_IngVsGasLayout = new javax.swing.GroupLayout(panel_IngVsGas);
        panel_IngVsGas.setLayout(panel_IngVsGasLayout);
        panel_IngVsGasLayout.setHorizontalGroup(
            panel_IngVsGasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_IngVsGasLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(btn_IngVsGas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_IngVsGasLayout.setVerticalGroup(
            panel_IngVsGasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_IngVsGas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        panel_indicadores.setBackground(new java.awt.Color(0, 0, 0));

        btn_indicadores.setBackground(new java.awt.Color(0, 0, 0));
        btn_indicadores.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btn_indicadores.setForeground(new java.awt.Color(255, 255, 255));
        btn_indicadores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Icono_indicadores.png"))); // NOI18N
        btn_indicadores.setText("Indicadores");
        btn_indicadores.setBorder(null);
        btn_indicadores.setBorderPainted(false);
        btn_indicadores.setContentAreaFilled(false);
        btn_indicadores.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_indicadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_indicadoresMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_indicadoresMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_indicadoresMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_indicadoresLayout = new javax.swing.GroupLayout(panel_indicadores);
        panel_indicadores.setLayout(panel_indicadoresLayout);
        panel_indicadoresLayout.setHorizontalGroup(
            panel_indicadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_indicadoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_indicadores, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_indicadoresLayout.setVerticalGroup(
            panel_indicadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_indicadores, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        panel_empleados.setBackground(new java.awt.Color(0, 0, 0));

        btn_empleados.setBackground(new java.awt.Color(0, 0, 0));
        btn_empleados.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btn_empleados.setForeground(new java.awt.Color(255, 255, 255));
        btn_empleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono empleados.png"))); // NOI18N
        btn_empleados.setText("Empleados");
        btn_empleados.setBorder(null);
        btn_empleados.setBorderPainted(false);
        btn_empleados.setContentAreaFilled(false);
        btn_empleados.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_empleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_empleadosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_empleadosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_empleadosMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_empleadosLayout = new javax.swing.GroupLayout(panel_empleados);
        panel_empleados.setLayout(panel_empleadosLayout);
        panel_empleadosLayout.setHorizontalGroup(
            panel_empleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_empleadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_empleados, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_empleadosLayout.setVerticalGroup(
            panel_empleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_empleados, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        panel_impuestos.setBackground(new java.awt.Color(0, 0, 0));

        btn_impuestos.setBackground(new java.awt.Color(0, 0, 0));
        btn_impuestos.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btn_impuestos.setForeground(new java.awt.Color(255, 255, 255));
        btn_impuestos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono impuestos.png"))); // NOI18N
        btn_impuestos.setText("Impuestos");
        btn_impuestos.setBorder(null);
        btn_impuestos.setBorderPainted(false);
        btn_impuestos.setContentAreaFilled(false);
        btn_impuestos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_impuestos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_impuestosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_impuestosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_impuestosMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_impuestosLayout = new javax.swing.GroupLayout(panel_impuestos);
        panel_impuestos.setLayout(panel_impuestosLayout);
        panel_impuestosLayout.setHorizontalGroup(
            panel_impuestosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_impuestosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_impuestos, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
        );
        panel_impuestosLayout.setVerticalGroup(
            panel_impuestosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_impuestos, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        panel_credito.setBackground(new java.awt.Color(0, 0, 0));

        btn_credito.setBackground(new java.awt.Color(0, 0, 0));
        btn_credito.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btn_credito.setForeground(new java.awt.Color(255, 255, 255));
        btn_credito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_credito.png"))); // NOI18N
        btn_credito.setBorder(null);
        btn_credito.setBorderPainted(false);
        btn_credito.setContentAreaFilled(false);
        btn_credito.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_credito.setLabel("Crédito");
        btn_credito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_creditoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_creditoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_creditoMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_creditoLayout = new javax.swing.GroupLayout(panel_credito);
        panel_credito.setLayout(panel_creditoLayout);
        panel_creditoLayout.setHorizontalGroup(
            panel_creditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_creditoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_credito, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_creditoLayout.setVerticalGroup(
            panel_creditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_credito, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        panel_riesgo.setBackground(new java.awt.Color(0, 0, 0));

        btn_riesgo.setBackground(new java.awt.Color(0, 0, 0));
        btn_riesgo.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btn_riesgo.setForeground(new java.awt.Color(255, 255, 255));
        btn_riesgo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono riesgo.png"))); // NOI18N
        btn_riesgo.setActionCommand("Riesgo");
        btn_riesgo.setBorder(null);
        btn_riesgo.setBorderPainted(false);
        btn_riesgo.setContentAreaFilled(false);
        btn_riesgo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_riesgo.setLabel("Riesgo");
        btn_riesgo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_riesgoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_riesgoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_riesgoMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_riesgoLayout = new javax.swing.GroupLayout(panel_riesgo);
        panel_riesgo.setLayout(panel_riesgoLayout);
        panel_riesgoLayout.setHorizontalGroup(
            panel_riesgoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 186, Short.MAX_VALUE)
            .addGroup(panel_riesgoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel_riesgoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btn_riesgo, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panel_riesgoLayout.setVerticalGroup(
            panel_riesgoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(panel_riesgoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btn_riesgo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
        );

        panel_EBITDA.setBackground(new java.awt.Color(0, 0, 0));

        btn_EBITDA.setBackground(new java.awt.Color(0, 0, 0));
        btn_EBITDA.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btn_EBITDA.setForeground(new java.awt.Color(255, 255, 255));
        btn_EBITDA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_Ebitda.png"))); // NOI18N
        btn_EBITDA.setText("EBITDA");
        btn_EBITDA.setAlignmentX(0.5F);
        btn_EBITDA.setBorder(null);
        btn_EBITDA.setBorderPainted(false);
        btn_EBITDA.setContentAreaFilled(false);
        btn_EBITDA.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_EBITDA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_EBITDAMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_EBITDAMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_EBITDAMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_EBITDALayout = new javax.swing.GroupLayout(panel_EBITDA);
        panel_EBITDA.setLayout(panel_EBITDALayout);
        panel_EBITDALayout.setHorizontalGroup(
            panel_EBITDALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_EBITDALayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_EBITDA, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_EBITDALayout.setVerticalGroup(
            panel_EBITDALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_EBITDA, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_negroLayout = new javax.swing.GroupLayout(panel_negro);
        panel_negro.setLayout(panel_negroLayout);
        panel_negroLayout.setHorizontalGroup(
            panel_negroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_empleados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_negroLayout.createSequentialGroup()
                .addGroup(panel_negroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_IngVsGas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel_negroLayout.createSequentialGroup()
                        .addGroup(panel_negroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel_credito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel_riesgo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel_impuestos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel_indicadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel_EBITDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel_negroLayout.setVerticalGroup(
            panel_negroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_negroLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(panel_IngVsGas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_EBITDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_indicadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_empleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_impuestos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_credito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_riesgo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
        );

        getContentPane().add(panel_negro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 180, 590));

        panel_azul.setBackground(new java.awt.Color(56, 80, 113));

        txtTitulo.setBackground(new java.awt.Color(204, 204, 204));
        txtTitulo.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        txtTitulo.setForeground(new java.awt.Color(85, 135, 184));
        txtTitulo.setText("Project Evaluator");

        panel_azul_oscuro.setBackground(new java.awt.Color(37, 53, 75));

        javax.swing.GroupLayout panel_azul_oscuroLayout = new javax.swing.GroupLayout(panel_azul_oscuro);
        panel_azul_oscuro.setLayout(panel_azul_oscuroLayout);
        panel_azul_oscuroLayout.setHorizontalGroup(
            panel_azul_oscuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        panel_azul_oscuroLayout.setVerticalGroup(
            panel_azul_oscuroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_azulLayout = new javax.swing.GroupLayout(panel_azul);
        panel_azul.setLayout(panel_azulLayout);
        panel_azulLayout.setHorizontalGroup(
            panel_azulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_azulLayout.createSequentialGroup()
                .addComponent(panel_azul_oscuro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(248, Short.MAX_VALUE))
        );
        panel_azulLayout.setVerticalGroup(
            panel_azulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_azulLayout.createSequentialGroup()
                .addComponent(panel_azul_oscuro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(panel_azul, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Getters
    public JTextField getJtf_añosvida() {
        return jtf_añosvida;
    }

    public JTextField getJtf_nombreproyecto() {
        return jtf_nombreproyecto;
    }

    //Métodos   
    private void importar_ult_p() {
        //importa el nombre y la longevidad del ultimo proyecto usado.
        try {
            File cache = new File("C:\\Project evaluator\\Cache\\");
            if (!cache.exists()) {
                cache.mkdirs();
            }
            ult_proyecto = new File("C:\\Project evaluator\\Cache\\Ultimo proyecto.txt");
            Utilidad.JtextField.importar_jtf(ult_proyecto, jtf_nombreproyecto);
            direccion = "C:\\Project evaluator\\" + jtf_nombreproyecto.getText() + "\\";
            nombredelproyecto_f = new File(direccion + "Nombre del proyecto.txt");
            añosvidaproyecto_f = new File(direccion + "Longevidad del proyecto.txt");
            Utilidad.JtextField.importar_jtf(añosvidaproyecto_f, jtf_añosvida);
        } catch (Exception e) {
            System.err.println("Error en importar_ult_p (ProjectEvaluator)");
            e.getMessage();
        }
    }

    private void setear_titulos() {
        //setea el nombre del proyecto en los titulos de los jframes
        try {
            riesgo.getTxtriesgos().setText("Riesgos de " + jtf_nombreproyecto.getText());
            ingvsgas.getTxtingresos().setText("Ingresos de " + jtf_nombreproyecto.getText());
            ingvsgas.getTxtegresos().setText("Egresos de " + jtf_nombreproyecto.getText());
            indicadores.getTxtindicadores().setText("Indicadores de " + jtf_nombreproyecto.getText());
            impuestos.getTxtimpuestos().setText("Impuestos de " + jtf_nombreproyecto.getText());
            impuestos.getTxttasasimpuestos().setText("Tasas de impuestos de " + jtf_nombreproyecto.getText());
            empleados.getTxtsueldos().setText("Sueldos de " + jtf_nombreproyecto.getText());
            ebitda.getTxtebitda().setText("EBITDA de " + jtf_nombreproyecto.getText());
            credito.getTxtcredito().setText("Crédito de " + jtf_nombreproyecto.getText());
            credito.getTxtdatcredito().setText("Datos de Crédito de " + jtf_nombreproyecto.getText());
        } catch (Exception e) {
            System.err.println("Error en setear_titutlos (ProjectEvaluator)");
            e.getMessage();
        }
    }

    private void reabrir_frames() {
        //reabre los frames en caso de cambiar el nombre del proyecto para cargar los nuevos datos.
        try {
            if (credito.isVisible() == true) {
                credito.dispatchEvent(new WindowEvent(credito, WindowEvent.WINDOW_CLOSING));
                credito.setVisible(true);
            }
            if (riesgo.isVisible() == true) {
                riesgo.dispatchEvent(new WindowEvent(riesgo, WindowEvent.WINDOW_CLOSING));
                riesgo.setVisible(true);
            }
            if (impuestos.isVisible() == true) {
                impuestos.dispatchEvent(new WindowEvent(impuestos, WindowEvent.WINDOW_CLOSING));
                impuestos.setVisible(true);
            }
            if (ebitda.isVisible() == true) {
                ebitda.dispatchEvent(new WindowEvent(impuestos, WindowEvent.WINDOW_CLOSING));
                ebitda.setVisible(true);
            }
            if (ingvsgas.isVisible() == true) {
                ingvsgas.dispatchEvent(new WindowEvent(impuestos, WindowEvent.WINDOW_CLOSING));
                if (!jtf_nombreproyecto.getText().equals(" Ingrese el nombre de su proyecto...") && jtf_nombreproyecto.getText().trim().length() > 0) {
                    //inicializa ingvsgas
                    ingvsgas.setear_ingvsgas();
                    //Realiza los valores para ebitda e impuestos
                    ingvsgas.setear_ebitda_imp();
                    //importa el jtextfield
                    ingvsgas.inversion = new File(direccion + "IngVsGas\\inversion.txt");
                    Utilidad.JtextField.importar_jtf(ingvsgas.inversion, ingvsgas.getJtf_inv());
                    ingvsgas.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese un nombre válido para su proyecto", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
                ingvsgas.setVisible(true);
            }
            if (empleados.isVisible() == true) {
                empleados.dispatchEvent(new WindowEvent(empleados, WindowEvent.WINDOW_CLOSING));
                empleados.setVisible(true);
            }
            if (indicadores.isVisible() == true) {
                indicadores.dispatchEvent(new WindowEvent(indicadores, WindowEvent.WINDOW_CLOSING));
                indicadores.setVisible(true);
            }
        } catch (Exception e) {
            System.err.println("Error en importar_ult_p (ProjectEvaluator)");
            e.getMessage();
        }
    }


    private void btn_IngVsGasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_IngVsGasMouseClicked
        // TODO add your handling code here:  
        try {
            if (!jtf_nombreproyecto.getText().equals(" Ingrese el nombre de su proyecto...") && jtf_nombreproyecto.getText().trim().length() > 0) {
                //inicializa ingvsgas
                ingvsgas.setear_ingvsgas();
                //Realiza los valores para ebitda e impuestos
                ingvsgas.setear_ebitda_imp();
                //importa el jtextfield
                ingvsgas.inversion = new File(direccion + "IngVsGas\\inversion.txt");
                Utilidad.JtextField.importar_jtf(ingvsgas.inversion, ingvsgas.getJtf_inv());
                ingvsgas.setIndicadores(indicadores);
                ingvsgas.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un nombre válido para su proyecto", "Advertencia", JOptionPane.WARNING_MESSAGE);

            }

        } catch (Exception e) {
            System.err.println("Error en btn_IngVsGasMouseClicked (ProjectEvaluator)");
            e.getMessage();
        }
    }//GEN-LAST:event_btn_IngVsGasMouseClicked

    private void btn_IngVsGasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_IngVsGasMouseEntered
        // TODO add your handling code here:
        //Pone el fondo blanco cuando se pasa el mouse encima
        btn_IngVsGas.setForeground(Color.BLACK);
        panel_IngVsGas.setBackground(Color.WHITE);

    }//GEN-LAST:event_btn_IngVsGasMouseEntered

    private void btn_IngVsGasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_IngVsGasMouseExited
        // TODO add your handling code here:
        //Pone el fondo por defecto cuando se quita el mouse de encima
        btn_IngVsGas.setForeground(Color.WHITE);
        panel_IngVsGas.setBackground(Color.BLACK);

    }//GEN-LAST:event_btn_IngVsGasMouseExited

    private void btn_indicadoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_indicadoresMouseClicked
        // TODO add your handling code here:
        //Inicializa el frame indicadores
        try {
            if (!jtf_nombreproyecto.getText().equals(" Ingrese el nombre de su proyecto...") && jtf_nombreproyecto.getText().trim().length() > 0) {

                ((DefaultTableModel) indicadores.getTabla_indicadores().getModel()).setRowCount(0);

                Utilidad.Tabla.inicializar_col(indicadores.getTabla_indicadores());
                Utilidad.Tabla.importar(indicadores.getIndicadores(), indicadores.getTabla_indicadores());
                //inicializa ingvsgas
                ingvsgas.setear_ingvsgas();
                //setea ebitda
                ingvsgas.setear_ebitda_imp();
                //inicializa indicadores
                Utilidad.JtextField.importar_jtf(indicadores.getInteres(), indicadores.getJtf_interes());
                indicadores.setear_interes();
                ingvsgas.inversion = new File(direccion + "IngVsGas\\inversion.txt");
                Utilidad.JtextField.importar_jtf(ingvsgas.inversion, ingvsgas.getJtf_inv());
                //calculo van sin riesgo y con riesgo
                ingvsgas.setear_inv();
                indicadores.añadir_indicadores();
                //añade filas por defecto si no hay ninguna en la tabla
                Utilidad.Tabla.filas_defecto(indicadores.getTabla_indicadores(), 5);
                indicadores.setImp(true);
                indicadores.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un nombre válido para su proyecto", "Advertencia", JOptionPane.WARNING_MESSAGE);

            }
        } catch (Exception e) {
            System.err.println("Error en btn_indicadoresMouseclicked (ProjectEvaluator)");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_indicadoresMouseClicked

    private void btn_indicadoresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_indicadoresMouseEntered
        // TODO add your handling code here:
        //Pone el fondo blanco cuando se pasa el mouse encima
        btn_indicadores.setForeground(Color.BLACK);
        panel_indicadores.setBackground(Color.WHITE);


    }//GEN-LAST:event_btn_indicadoresMouseEntered

    private void btn_indicadoresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_indicadoresMouseExited
        // TODO add your handling code here:
        //Pone el fondo por defecto cuando se quita el mouse de encima
        btn_indicadores.setForeground(Color.WHITE);
        panel_indicadores.setBackground(Color.BLACK);

    }//GEN-LAST:event_btn_indicadoresMouseExited


    private void btn_EBITDAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_EBITDAMouseClicked
        // TODO add your handling code here:
        //Inicializa el frame de EBITDA
        try {
            if (!jtf_nombreproyecto.getText().equals(" Ingrese el nombre de su proyecto...") && jtf_nombreproyecto.getText().trim().length() > 0) {
                //inicializa datos Ebitda y imp
                Utilidad.Tabla.get_modelo(ebitda.getTabla_ebitda()).setRowCount(0);
                Utilidad.Tabla.inicializar_col(ebitda.getTabla_ebitda());
                Utilidad.Tabla.importar(ebitda.getEbitda(), ebitda.getTabla_ebitda());
                //inicializa ingvsgas
                ingvsgas.setear_ingvsgas();
                try {
                    Utilidad.Tabla.get_modelo(ebitda.getTabla_ebitda()).setRowCount(0);
                    ingvsgas.setear_ebitda_imp();
                    ebitda.setVisible(true);
                } catch (Exception e) {
                    System.err.println("Error en calculo de EBITDA");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un nombre válido para su proyecto", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            System.err.println("Error en btn_EBITDAMouseClicked (ProjectEvaluator)");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_EBITDAMouseClicked

    private void btn_EBITDAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_EBITDAMouseEntered
        // TODO add your handling code here:
        //Pone el fondo blanco cuando se pasa el mouse encima
        btn_EBITDA.setForeground(Color.BLACK);
        panel_EBITDA.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_EBITDAMouseEntered

    private void btn_EBITDAMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_EBITDAMouseExited
        // TODO add your handling code here:
        //Pone el fondo por defecto cuando se quita el mouse de encima
        btn_EBITDA.setForeground(Color.WHITE);
        panel_EBITDA.setBackground(Color.BLACK);


    }//GEN-LAST:event_btn_EBITDAMouseExited

    private void btn_empleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_empleadosMouseClicked
        // TODO add your handling code here:
        //Inicializa el frame de Empleados
        try {
            if (!jtf_nombreproyecto.getText().equals(" Ingrese el nombre de su proyecto...") && jtf_nombreproyecto.getText().trim().length() > 0) {
                Utilidad.Tabla.get_modelo(empleados.getTabla_tasas()).setRowCount(0);
                Empleados.tasas = new File(ProjectEvaluator.direccion + "\\Sueldos\\tasas.txt");;
                Utilidad.Tabla.importar(Empleados.tasas, empleados.getTabla_tasas());
                Utilidad.Tabla.filas_defecto(empleados.getTabla_tasas(), 1);
                empleados.inicializar_combo();
                empleados.importar_emp();
                empleados.setImp_sueldos(true);
                empleados.total_sueldos();
                empleados.antiguedad();
                empleados.presentismo();
                empleados.bruto();
                empleados.setImp_tas(true);
                empleados.tasas(empleados.getTas_jub());
                empleados.tasas(empleados.getTas_ob());
                empleados.tasas(empleados.getTas_ley());
                empleados.tasas(empleados.getTas_sec());
                empleados.total_desc();
                empleados.total_neto();
                empleados.getJtf_total_sueldos().setText(String.valueOf(empleados.calculo_total_sueldos()));
                empleados.arr_sueldos();
                Utilidad.Tabla.filas_defecto(empleados.getTabla_sueldos(), 50);
                empleados.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un nombre válido para su proyecto", "Advertencia", JOptionPane.WARNING_MESSAGE);

            }
        } catch (Exception e) {
            System.err.println("Error en btn_empleadosMouseClicked (ProjectEvaluator)");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_empleadosMouseClicked

    private void btn_empleadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_empleadosMouseEntered
        // TODO add your handling code here:
        //Pone el fondo blanco cuando se pasa el mouse encima
        btn_empleados.setForeground(Color.BLACK);
        panel_empleados.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_empleadosMouseEntered

    private void btn_empleadosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_empleadosMouseExited
        // TODO add your handling code here:
        //Pone el fondo por defecto cuando se quita el mouse de encima
        btn_empleados.setForeground(Color.WHITE);
        panel_empleados.setBackground(Color.BLACK);

    }//GEN-LAST:event_btn_empleadosMouseExited

    private void btn_impuestosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_impuestosMouseClicked
        // TODO add your handling code here:
        //Inicializa el frame de impuestos
        try {
            if (!jtf_nombreproyecto.getText().equals(" Ingrese el nombre de su proyecto...") && jtf_nombreproyecto.getText().trim().length() > 0) {

                Utilidad.Tabla.inicializar_col(impuestos.getTabla_impuestos());
                Utilidad.Tabla.importar(impuestos.getImpuestos_f(), impuestos.getTabla_impuestos());
                Utilidad.Tabla.importar(impuestos.getImpuestos_f(), impuestos.getTabla_indimpuestos());
                //añade filas por defecto si no hay ninguna en la tabla
                impuestos.filas_datos_impuestos(impuestos.getTabla_impuestos());
                impuestos.filas_datos_indimpuestos(impuestos.getTabla_indimpuestos());
                impuestos.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un nombre válido para su proyecto", "Advertencia", JOptionPane.WARNING_MESSAGE);

            }
        } catch (Exception e) {
            System.err.println("Error en btn_impuestosMouseClicked (ProjectEvaluator)");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_impuestosMouseClicked

    private void btn_impuestosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_impuestosMouseEntered
        // TODO add your handling code here:
        //Pone el fondo blanco cuando se pasa el mouse encima
        btn_impuestos.setForeground(Color.BLACK);
        panel_impuestos.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_impuestosMouseEntered

    private void btn_impuestosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_impuestosMouseExited
        // TODO add your handling code here:
        //Pone el fondo por defecto cuando se quita el mouse de encima
        btn_impuestos.setForeground(Color.WHITE);
        panel_impuestos.setBackground(Color.BLACK);

    }//GEN-LAST:event_btn_impuestosMouseExited

    private void btn_creditoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_creditoMouseClicked
        // TODO add your handling code here:
        //Inicializa el frame de Crédito
        try {
            if (!jtf_nombreproyecto.getText().equals(" Ingrese el nombre de su proyecto...") && jtf_nombreproyecto.getText().trim().length() > 0) {

                credito.setVisible(true);
                Utilidad.Tabla.importar(credito.getPagcredito(), credito.getTabla_pagcredito());
                Utilidad.Tabla.importar(credito.getDatcredito(), credito.getTabla_datcredito());
                //añade filas por defecto si no hay ninguna en la tabla
                credito.filas_datos(credito.getTabla_datcredito(), credito.getTabla_pagcredito());
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un nombre válido para su proyecto", "Advertencia", JOptionPane.WARNING_MESSAGE);

            }
        } catch (Exception e) {
            System.err.println("Error en btn_creditoMouseClicked (ProjectEvaluator)");
            e.getMessage();
        }
    }//GEN-LAST:event_btn_creditoMouseClicked

    private void btn_creditoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_creditoMouseEntered
        // TODO add your handling code here:
        //Pone el fondo blanco cuando se pasa el mouse encima
        btn_credito.setForeground(Color.BLACK);
        panel_credito.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_creditoMouseEntered

    private void btn_creditoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_creditoMouseExited
        // TODO add your handling code here:
        //Pone el fondo por defecto cuando se quita el mouse de encima
        btn_credito.setForeground(Color.WHITE);
        panel_credito.setBackground(Color.BLACK);

    }//GEN-LAST:event_btn_creditoMouseExited


    private void jtf_añosvidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_añosvidaActionPerformed
        // TODO add your handling code here:
        // Se obtienen los años de vida del proyecto para las demas clases
        try {
            longevidad = Integer.parseInt(jtf_añosvida.getText());
            if (longevidad > 0) {
                new File("C:\\Project evaluator\\" + jtf_nombreproyecto.getText()).mkdirs();
                añosvidaproyecto_f = new File("C:\\Project evaluator\\" + jtf_nombreproyecto.getText() + "\\Longevidad del proyecto.txt");
                Utilidad.JtextField.exportar_jtf(añosvidaproyecto_f, jtf_añosvida);

                //Inicializa INGVSGAS
                Utilidad.Tabla.get_modelo(ingvsgas.getTabla_ingresos()).setColumnCount(1);
                Utilidad.Tabla.get_modelo(ingvsgas.getTabla_egresos()).setColumnCount(1);

                ((DefaultTableModel) ingvsgas.getTabla_ingresos().getModel()).setRowCount(0);
                ((DefaultTableModel) ingvsgas.getTabla_egresos().getModel()).setRowCount(0);

                //inicializa ing y eg
                Utilidad.Tabla.inicializar_col(ingvsgas.getTabla_ingresos());
                Utilidad.Tabla.inicializar_col(ingvsgas.getTabla_egresos());
                //imp ing eg con iva
                ingvsgas.getjComboBoxivaing().setSelectedItem("Con IVA");
                ingvsgas.getjComboBoxivaeg().setSelectedItem("Con IVA");
                ((DefaultTableModel) ingvsgas.getTabla_ingresos().getModel()).setRowCount(0);
                ((DefaultTableModel) ingvsgas.getTabla_egresos().getModel()).setRowCount(0);

                //imp ing y eg
                ingvsgas.getjComboBoxivaing().setSelectedItem("Sin IVA");
                ingvsgas.getjComboBoxivaeg().setSelectedItem("Sin IVA");

                import_ingeg = true;

                Utilidad.Tabla.filas_defecto(ingvsgas.getTabla_ingresos(), 11);
                Utilidad.Tabla.filas_defecto(ingvsgas.getTabla_egresos(), 11);

                //resetea combobox empleados
                empleados.getCombo_años().removeAllItems();
                empleados.inicializar_combo();
            } else {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un valor válido", "Error", JOptionPane.ERROR_MESSAGE);
            jtf_añosvida.setText(" Ej:5");
            Color c = new Color(151, 159, 173);
            jtf_añosvida.setForeground(c);
        }

    }//GEN-LAST:event_jtf_añosvidaActionPerformed

    private void btn_riesgoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_riesgoMouseClicked
        // TODO add your handling code here:
        //Incializa el frame riesgos
        try {
            if (!jtf_nombreproyecto.getText().equals(" Ingrese el nombre de su proyecto...") && jtf_nombreproyecto.getText().trim().length() > 0) {

                Utilidad.Tabla.inicializar_col(riesgo.getTabla_riesgos());
                Utilidad.Tabla.importar(riesgo.getRiesgos(), riesgo.getTabla_riesgos());
                Utilidad.Tabla.filas_defecto(riesgo.getTabla_riesgos(), 50);
                riesgo.setImp(true);
                riesgo.valor_riesgo();
                riesgo.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un nombre válido para su proyecto", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            System.err.println("Error en btn_riesgoMouseClicked (ProjectEvaluator)");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_riesgoMouseClicked

    private void btn_riesgoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_riesgoMouseEntered
        // TODO add your handling code here:
        //Pone el fondo blanco cuando se pasa el mouse encima
        btn_riesgo.setForeground(Color.BLACK);
        panel_riesgo.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_riesgoMouseEntered

    private void btn_riesgoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_riesgoMouseExited
        // TODO add your handling code here:
        //Pone el fondo por defecto cuando se quita el mouse de encima
        btn_riesgo.setForeground(Color.WHITE);
        panel_riesgo.setBackground(Color.BLACK);
    }//GEN-LAST:event_btn_riesgoMouseExited

    private void jtf_nombreproyectoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtf_nombreproyectoMousePressed
        // TODO add your handling code here:
        //cuando se presiona el mouse en nombreproyecto se pone el texto por defecto en vacio y en añosvida, Ej:5
        if (jtf_nombreproyecto.getText().equals(" Ingrese el nombre de su proyecto...")) {
            jtf_nombreproyecto.setText("");
            jtf_añosvida.setText(" Ej:5");
            Color c = new Color(151, 159, 173);
            jtf_añosvida.setForeground(c);
            jtf_nombreproyecto.setForeground(Color.WHITE);

        }
    }//GEN-LAST:event_jtf_nombreproyectoMousePressed

    private void jtf_añosvidaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtf_añosvidaMousePressed
        // TODO add your handling code here:
        //cuando se presiona el mouse en añosvida se pone el texto por defecto en vacio y en nombre proyecto, Ingrese el nombre de su proyecto
        if (jtf_añosvida.getText().equals(" Ej:5")) {
            jtf_añosvida.setText("");
            if (jtf_nombreproyecto.getText().trim().length() == 0) {
                jtf_nombreproyecto.setText(" Ingrese el nombre de su proyecto...");
                Color c = new Color(151, 159, 173);
                jtf_nombreproyecto.setForeground(c);
            }
            jtf_añosvida.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_jtf_añosvidaMousePressed

    private void jtf_nombreproyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_nombreproyectoActionPerformed
        // TODO add your handling code here:
        //Realiza la exportación de nombre proyecto y a su ves Ultimo proyecto utilizado
        try {
            if (!jtf_nombreproyecto.getText().equals(" Ingrese el nombre de su proyecto...") && jtf_nombreproyecto.getText().trim().length() > 0) {

                //cambia la direccion a la correspondiente y realiza las exportaciones
                direccion = "C:\\Project evaluator\\" + jtf_nombreproyecto.getText() + "\\";
                new File(direccion).mkdirs();
                new File("C:\\Project evaluator\\" + jtf_nombreproyecto.getText() + "\\IngVsGas").mkdirs();
                nombredelproyecto_f = new File(direccion + "Nombre del proyecto.txt");
                añosvidaproyecto_f = new File(direccion + "Longevidad del proyecto.txt");
                Utilidad.JtextField.exportar_jtf(nombredelproyecto_f, jtf_nombreproyecto);
                Utilidad.JtextField.exportar_jtf(ult_proyecto, jtf_nombreproyecto);
                //En caso de cambiar de proyecto, se importa la longevidad correspondiente
                Utilidad.JtextField.importar_jtf(añosvidaproyecto_f, jtf_añosvida);
                setear_titulos();
                ingvsgas.setear_ingvsgas();
                ingvsgas.setear_ebitda_imp();
                reabrir_frames();
            } else {
                jtf_nombreproyecto.setText(" Ingrese el nombre de su proyecto...");
                Color c = new Color(151, 159, 173);
                jtf_nombreproyecto.setForeground(c);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingrese un nombre válido", "Error", JOptionPane.ERROR_MESSAGE);
            e.getMessage();
        }
    }//GEN-LAST:event_jtf_nombreproyectoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        //hace la importación del nombre y longevidad o escribe valores por defecto.
        //se le otorga el objeto ebitda y ingvsgas a impuestos
        impuestos.setEBITDA(ebitda);
        impuestos.setIngVsGas(ingvsgas);
        try {
            importar_ult_p();

        } catch (Exception e) {
            e.getMessage();
        }
        if (!jtf_nombreproyecto.getText().equals(" Ingrese el nombre de su proyecto...") && jtf_nombreproyecto.getText().trim().length() > 0) {
            Color c = new Color(255, 255, 255);
            jtf_nombreproyecto.setForeground(c);
            setear_titulos();
        }
        if (!jtf_añosvida.getText().equals(" Ej:5")) {
            Color c = new Color(255, 255, 255);
            jtf_añosvida.setForeground(c);
        }  
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_EBITDA;
    private javax.swing.JButton btn_IngVsGas;
    private javax.swing.JButton btn_credito;
    private javax.swing.JButton btn_empleados;
    private javax.swing.JButton btn_impuestos;
    private javax.swing.JButton btn_indicadores;
    private javax.swing.JButton btn_riesgo;
    private javax.swing.JTextField jtf_añosvida;
    private javax.swing.JTextField jtf_nombreproyecto;
    private javax.swing.JPanel panel_EBITDA;
    private javax.swing.JPanel panel_IngVsGas;
    private javax.swing.JPanel panel_azul;
    private javax.swing.JPanel panel_azul_oscuro;
    private javax.swing.JPanel panel_credito;
    private javax.swing.JPanel panel_empleados;
    private javax.swing.JPanel panel_impuestos;
    private javax.swing.JPanel panel_indicadores;
    private javax.swing.JPanel panel_negro;
    private javax.swing.JPanel panel_riesgo;
    private javax.swing.JLabel txtTitulo;
    private javax.swing.JLabel txtañosvida;
    private javax.swing.JLabel txtnombreproyecto;
    // End of variables declaration//GEN-END:variables

}

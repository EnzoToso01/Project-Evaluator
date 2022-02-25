package aplicacion.de.evaluacion.de.proyectos;

import java.awt.Color;
import java.awt.Component;
import javax.swing.*;
import javax.swing.table.*;

public class ColorFilas extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean Selected, boolean hasFocus, int row, int col){
    
    super.getTableCellRendererComponent(table, value, Selected, hasFocus, row, col);
    
       if (table.getValueAt(1, 1).toString().equals("IVA")) {

            setBackground(Color.yellow);
        }
    
    return this;
    }

    public static void main(String[] args) {

    }
}

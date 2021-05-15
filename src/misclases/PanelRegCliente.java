/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misclases;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSpinner;

/**
 *
 * @author Hp
 */
public class PanelRegCliente extends JPanel {
    private JButton jButtonRegistrar;
    private JDateChooser jDateChooserSal;
    private ActionListener act;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBoxServBar;
    private javax.swing.JCheckBox jCheckBoxServCuarto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelCdOrigen;
    private javax.swing.JLabel jLabelCheckIn;
    private javax.swing.JLabel jLabelEscudo;
    private javax.swing.JLabel jLabelNomHuesped;
    private javax.swing.JLabel jLabelServicios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonPersonaExtr1,jRadioButtonPersonaExtr2;
    private JSpinner jSpinnerTotalHabi;
    private javax.swing.JTextField jTextFieldCdOrigen,jTextFieldFechaIngr,jTextFieldMostrarFechaIng,
            jTextFieldNomHuesped, jTextFieldPersonasExtr;

    public PanelRegCliente() {
        this.setBackground(Color.cyan);
        initComponents();
    }

    public PanelRegCliente(ActionListener evt) {
        act=evt;
        this.setBackground(Color.cyan);
        initComponents();
    }

    private void initComponents() {
        
    }
    
     @Override
    public void paint(Graphics g){
       
        Dimension dimensiones=this.getSize();
        //  System.out.println("hi");
           
         
        this.setOpaque(false);
        super.paint(g);
      
        
        
    }
    
}

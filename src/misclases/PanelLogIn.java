
package misclases;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import misframes.LogIn;
import misframes.MenuPrincipal;


public class PanelLogIn extends JPanel{

    private Font fuente,fuente2,fuente3,sizeFont,sizeFont_2,sizeFont_3,sizeFont_4;
    private File font = null,font_1 = null,font_2 = null;
    private JTextField jTextFieldUsuario;
    private JPasswordField jPasswordFieldContrasena;
    private JLabel jLabelUsuario,jLabelContrasena,jLabelNombreHot,jLabelSlogan;
    private JButton jButtonIniciar;
    private ActionListener act;
    public PanelLogIn(){
        
        initComponents();
        this.setBackground(Color.CYAN);
    }
    public PanelLogIn(ActionListener act){
        initComponents();
        this.act=act;
    }
    
    private void initComponents(){
           
        try {
            font=new File("src/fonts/Alba.ttf");
            fuente=Font.createFont(Font.TRUETYPE_FONT, font);
            sizeFont=fuente.deriveFont(18f);
            font_1= new File("src/fonts/Rose Cake.otf");
            fuente2=Font.createFont(Font.TRUETYPE_FONT, font_1);
            sizeFont_3=fuente2.deriveFont(100f);
            font_2= new File("src/fonts/Shelter.ttf");
            fuente3=Font.createFont(Font.TRUETYPE_FONT, font_2);
            sizeFont_4=fuente3.deriveFont(45f);
        } catch (FontFormatException ex) {
         
        } catch (IOException ex) {
              
        }catch(Exception ex){
              
        }
        
        jLabelNombreHot=new JLabel("HOTEL WOLFSBURG");
        jLabelNombreHot.setFont(sizeFont_3);
        jLabelNombreHot.setForeground(Color.MAGENTA);
        jLabelSlogan=new JLabel('"'+"El Arte De Cumplir Tu Más Altas Expectativas"+'"');
        jLabelSlogan.setFont(sizeFont_4);
        jLabelSlogan.setForeground(Color.red);
        jTextFieldUsuario=new JTextField("");
        jTextFieldUsuario.setBorder(new  BevelBorder(BevelBorder.LOWERED));
        jPasswordFieldContrasena=new  JPasswordField();
        jPasswordFieldContrasena.setBorder(new  BevelBorder(BevelBorder.LOWERED));
        jLabelUsuario=new JLabel("Usuario");
        jLabelUsuario.setBorder(new  BevelBorder(BevelBorder.LOWERED));
        jLabelUsuario.setFont(sizeFont);
        jLabelContrasena=new JLabel("Contraseña");
        jLabelContrasena.setBorder(new  BevelBorder(BevelBorder.LOWERED));
        jLabelContrasena.setFont(sizeFont);
        
        
        jButtonIniciar=new JButton("Iniciar Sesión");
        jButtonIniciar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //jButtonIniciar.addActionListener(act);
        jButtonIniciar.addActionListener(new ActionListener(){

              @Override
              public void actionPerformed(ActionEvent ae) {
                 
                  
                   ((PanelLogIn) ( (JButton) ae.getSource()).getParent()).cerrar();
               
                  
              }
              
            
            
            
        });
        
   
            
            
            
            
        
        
        
        this.add(this.jLabelNombreHot);
        this.add(this.jLabelSlogan);
        this.add(this.jLabelUsuario);
        this.add(this.jLabelContrasena);
        this.add(this.jTextFieldUsuario);
        this.add(this.jPasswordFieldContrasena);
        this.add(this.jButtonIniciar);
    }
    public JLabel getjLabelUsuario(){
        return this.jLabelUsuario;
    }
    public void cerrar(){
        
        if(this.jTextFieldUsuario.getText().equals("Cris")){
           SwingUtilities.getWindowAncestor(this).dispose();
           new MenuPrincipal().setVisible(true);
        }
        
    }
      @Override
    public void paint(Graphics g){
        Dimension dimensiones=getSize();
        
        this.jLabelUsuario.setBounds((dimensiones.width/2)-100,(dimensiones.height/2)-100 , 100, 30);
        this.jLabelContrasena.setBounds((dimensiones.width/2)+100,(dimensiones.height/2)-100 , 100, 30);
        this.jTextFieldUsuario.setBounds((dimensiones.width/2)-100,(dimensiones.height/2)-50 , 100, 30);
        this.jPasswordFieldContrasena.setBounds((dimensiones.width/2)+100,(dimensiones.height/2)-50 , 100, 30);
        this.jButtonIniciar.setBounds((dimensiones.width/2)-25,(dimensiones.height/2) , 150, 30);
        this.jLabelNombreHot.setBounds(225,15,570, 90);
        this.jLabelSlogan.setBounds(220,115, 680, 50);
//  this.setOpaque(false);
        super.paint(g);
        
    }
    
    
}

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
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import misframes.MenuConsultas;

public class PanelConsultaNombreHuesped extends JPanel {
    private JTextField jTextFieldNumero;
    private JLabel jLabelConsultaNombreHuesped, jLabelNumeroHabitacion, jLabelEstaNom;
    private JTextArea jTextAreaNombreHuesped;
    private JButton jButtonRegresar, jButtonBuscar, jButtonLimpiar;
    private ActionListener act;
    private BufferedImage habitacion,alberca, fondo;
    private Font font1, font2, font3, font4;
    private MySqlConn conn=new MySqlConn();
    
    public PanelConsultaNombreHuesped() {
        initComponents();
    }

    public PanelConsultaNombreHuesped(ActionListener evt) {
        this.act = evt;
        
        initComponents();
    }
    
    private void jButtonBuscarActionPerformed(ActionEvent evt) {                                                 
        // TODO add your handling code here:
        String num=this.jTextFieldNumero.getText().trim();
        try{
            int numero=Integer.parseInt(num);
            String query="select * from habitacion where numero = "+"'"+numero+"'";
            this.conn.Consult(query);
            try {
                String nombre = this.conn.rs.getString(14);
                this.jTextAreaNombreHuesped.setText("\n"+nombre);
                System.out.println(nombre);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this,"Habitación NO Ocupada...","Mensaje", ERROR_MESSAGE);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"No ingreso un numero...\nIngresa un número","Mensaje", ERROR_MESSAGE);
        }
        
    }
    
    private void jButtonLimpiarActionPerformed(ActionEvent evt){
        this.jTextAreaNombreHuesped.setText(null);
        this.jTextFieldNumero.setText("");
    }
    
    private void initComponents(){
        
        try{
            fondo=ImageIO.read(new File("src/imagenes/fondo.jpg"));
            habitacion=ImageIO.read(new File("src/imagenes/habitacion.jpg"));
            alberca=ImageIO.read(new File("src/imagenes/piscina.jpg"));
            
            font1=Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/Marlboro.ttf"));
            font1=font1.deriveFont(21f);
            
            font2=Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/Mick Caster.ttf"));
            font2=font2.deriveFont(24f);
            
            font3=Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/PublicSecret.otf"));
            font3=font3.deriveFont(30f);
            
            font4=Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/Bundhers.ttf"));
            font4=font4.deriveFont(36f);
            
            jTextFieldNumero=new JTextField();
            jTextFieldNumero.setFont(font1);
            
            jLabelNumeroHabitacion= new JLabel("Ingresa el número de la habitación: ");
            jLabelNumeroHabitacion.setFont(font2);
            jLabelNumeroHabitacion.setOpaque(true);
            jLabelNumeroHabitacion.setBackground(new Color(255,255,255));
            
            jLabelEstaNom=new JLabel("La habitacion esta a nombre de: ");
            jLabelEstaNom.setFont(font4);
            jLabelEstaNom.setOpaque(true);
            jLabelEstaNom.setBackground(Color.yellow);
            jLabelEstaNom.setForeground(new Color(204,0,0));
            
            jTextAreaNombreHuesped=new JTextArea();
            jTextAreaNombreHuesped.setFont(font2);
            jTextAreaNombreHuesped.setEditable(false);
            
            jLabelConsultaNombreHuesped=new JLabel("CONSULTA DEL NOMBRE A QUIEN ESTA LA HABITACION");
            jLabelConsultaNombreHuesped.setFont(font3);
            jLabelConsultaNombreHuesped.setForeground(new Color(255,255,0));
            
            ImageIcon iconoRegresar= new ImageIcon("src/imagenes/Regresa.png");
            jButtonRegresar=new JButton("Regresar",iconoRegresar);
            jButtonRegresar.setFont(font1);
            jButtonRegresar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jButtonRegresar.setFocusable(false);
            jButtonRegresar.addMouseListener(new MouseAdapter(){
           
           
                @Override
                public void mouseEntered(MouseEvent ev){

                    jButtonRegresar.setBackground(Color.GREEN);
                }
                public void mouseExited(MouseEvent ev){
                    jButtonRegresar.setBackground(Color.LIGHT_GRAY);

                }
                public void mouseReleased(MouseEvent evt){
                    cerrar();
                    
                }

            });
            
            ImageIcon iconoBuscar= new ImageIcon("src/imagenes/consulta.jpg");
            jButtonBuscar=new JButton("Buscar",iconoBuscar);
            jButtonBuscar.setFont(font1);
            jButtonBuscar.setBackground(new Color(153,255,255));
            jButtonBuscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jButtonBuscar.setFocusable(false);
            jButtonBuscar.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    jButtonBuscarActionPerformed(ae);
                }
                
            });
            jButtonBuscar.addMouseListener(new MouseAdapter(){
           
           
                @Override
                public void mouseEntered(MouseEvent ev){

                    jButtonBuscar.setBackground(new Color(153,255,255));
                }
                public void mouseExited(MouseEvent ev){
                    jButtonBuscar.setBackground(new Color(255,255,102));

                }
                public void mouseReleased(MouseEvent evt){
                    
                    
                }

            });
            jButtonLimpiar=new JButton("Limpiar");
            jButtonLimpiar.setFont(font1);
            jButtonLimpiar.setBackground(new Color(153,255,255));
            jButtonLimpiar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jButtonLimpiar.setFocusable(false);
            jButtonLimpiar.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    jButtonLimpiarActionPerformed(ae);
                }
                
            });
            jButtonLimpiar.addMouseListener(new MouseAdapter(){
           
           
                @Override
                public void mouseEntered(MouseEvent ev){

                    jButtonLimpiar.setBackground(new Color(153,255,255));
                }
                public void mouseExited(MouseEvent ev){
                    jButtonLimpiar.setBackground(new Color(255,255,102));

                }
                public void mouseReleased(MouseEvent evt){
                    
                    
                }

            });
            
        }catch (FontFormatException ex) {
           
        }catch (IOException ex) {
           
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error al cargar archivos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        this.add(this.jLabelNumeroHabitacion);
        this.add(this.jLabelConsultaNombreHuesped);
        this.add(this.jLabelEstaNom);
        this.add(this.jTextAreaNombreHuesped);
        this.add(this.jTextFieldNumero);
        this.add(this.jButtonRegresar);
        this.add(this.jButtonBuscar);
        this.add(this.jButtonLimpiar);
    }
    
    private void cerrarVentana(){
        SwingUtilities.getWindowAncestor(this).dispose();
        
    }
    
    private void cerrar(){
        SwingUtilities.getWindowAncestor(this).dispose();
        new MenuConsultas().setVisible(true);
    }
    
    @Override
    public void paint(Graphics g){
        Dimension dimensiones=getSize();
        g.drawImage(fondo,0, 0,dimensiones.width,dimensiones.height, null);
        g.drawImage(habitacion,0, 0,(dimensiones.width/2),(dimensiones.height/2), null);
        g.drawImage(alberca,(dimensiones.width/2),(dimensiones.height/2),(dimensiones.width/2),(dimensiones.height/2), null);
        
        jLabelNumeroHabitacion.setBounds((dimensiones.width/2)+5,(dimensiones.height/2)-180, 310, 30);
        jLabelConsultaNombreHuesped.setBounds((dimensiones.width/2)-330,(dimensiones.height/2)-280, 680,45);
        jLabelEstaNom.setBounds((dimensiones.width/2)-340,(dimensiones.height/2)+90, 342, 30);
        
        jTextFieldNumero.setBounds((dimensiones.width/2)+30,(dimensiones.height/2)-115, 150, 40);
        
        jButtonRegresar.setBounds((dimensiones.width/2)-320,(dimensiones.height/2)+215, 130, 50);
        jButtonBuscar.setBounds((dimensiones.width/2)+80,(dimensiones.height/2)-50, 115, 45);
        jButtonLimpiar.setBounds((dimensiones.width/2)+200,(dimensiones.height/2)-50, 115, 45);
        
        jTextAreaNombreHuesped.setBounds((dimensiones.width/2)-320,(dimensiones.height/2)+135, 300, 65);
        
        this.setOpaque(false);
        super.paint(g);
    }
    
}


package misclases;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import misframes.Cambios;
//<<<<<<< HEAD
import misframes.EstadoHabitaciones;
import misframes.MenuPrincipal;
//=======
import misframes.CheckIn;
import misframes.MenuConsultas;
//>>>>>>> JuanCarlos3


public class PanelMenuPrincipal extends JPanel{
    private JButton jButtonCheckIn,jButtonCheckOut,jButtonConsultas,jButtonCambios,jButtonRegresar,jButtonSalir;
    private Font fuente,sizeFont,sizeFont_2;
    private File font = null;
    private Dimension oldDimension;
    private boolean band=true;
    private  BufferedImage imagen,alegria,escudo;
    private ActionListener act;
    public PanelMenuPrincipal() {
        this.setBackground(Color.cyan);
        initComponents();
        
    }
    
    public PanelMenuPrincipal(ActionListener evt){
        act=evt;
         this.setBackground(Color.cyan);
        initComponents();
        
    }
    
   private void initComponents(){
       
        try {
            imagen=ImageIO.read(new File("src/imagenes/Playa.jpg"));
            alegria=ImageIO.read(new File("src/imagenes/Alegria_2.png"));
            escudo=ImageIO.read(new File("src/imagenes/hotel.jpg"));
            font=new File("src/fonts/Alba.ttf");
            fuente=Font.createFont(Font.TRUETYPE_FONT, font);
            sizeFont=fuente.deriveFont(18f);
            
            font=new File("src/fonts/Tabarra.otf");
            fuente=Font.createFont(Font.TRUETYPE_FONT, font);
            sizeFont_2=fuente.deriveFont(90f);
            
            ImageIcon icono= new ImageIcon("src/imagenes/Confirma.jpg");
            ImageIcon iconoSal= new ImageIcon("src/imagenes/cancel.jpg");
            ImageIcon iconoCons= new ImageIcon("src/imagenes/consulta.jpg");
            ImageIcon iconoOut= new ImageIcon("src/imagenes/out.jpg");
            ImageIcon iconoCam= new ImageIcon("src/imagenes/cambio.png");
            
            jButtonCheckIn=new JButton("Check in", icono);
            jButtonCheckIn.setForeground(Color.BLUE);
            jButtonCheckIn.setFont(sizeFont);
            
            jButtonCheckIn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jButtonCheckIn.setHorizontalTextPosition(SwingConstants.LEFT);
            jButtonCheckIn.setVerticalAlignment(SwingConstants.BOTTOM);
            //Agregamos eventos 
             jButtonCheckIn.setFocusable(false);
            jButtonCheckIn.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent evt) {
//<<<<<<< HEAD
                cerrarVentana();
                new EstadoHabitaciones().setVisible(true);
//=======
            
//>>>>>>> JuanCarlos3
                //JOptionPane.showMessageDialog(null, "Hi", "hi", JOptionPane.WARNING_MESSAGE);
                
            }
            public void mouseEntered(MouseEvent evt){
                jButtonCheckIn.setBackground(Color.yellow);
                
            }
            public void mouseExited(MouseEvent evt){
                jButtonCheckIn.setBackground(Color.LIGHT_GRAY);
            }
        });
        
            jButtonCheckOut=new JButton("Check out",iconoOut);
            jButtonCheckOut.setForeground(Color.BLUE);
            jButtonCheckOut.setFont(sizeFont);
            jButtonCheckOut.setHorizontalTextPosition(SwingConstants.LEFT);
            jButtonCheckOut.setVerticalAlignment(SwingConstants.BOTTOM);
            
            jButtonCheckOut.setCursor(new Cursor(Cursor.HAND_CURSOR));
             jButtonCheckOut.setFocusable(false);
            //Agregamos eventos 
            jButtonCheckOut.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent evt) {
                
                //JOptionPane.showMessageDialog(null, "Hi", "hi", JOptionPane.WARNING_MESSAGE);
                 
            }
            public void mouseEntered(MouseEvent evt){
                jButtonCheckOut.setBackground(Color.yellow);
                
            }
            public void mouseExited(MouseEvent evt){
                jButtonCheckOut.setBackground(Color.LIGHT_GRAY);
            }
        });
        
            
            
            jButtonConsultas=new JButton("Consultas",iconoCons);
             
            jButtonConsultas.setForeground(Color.BLUE);
            jButtonConsultas.setFont(sizeFont);
            jButtonConsultas.setHorizontalTextPosition(SwingConstants.LEFT);
            jButtonConsultas.setVerticalAlignment(SwingConstants.BOTTOM);
            
            jButtonConsultas.setCursor(new Cursor(Cursor.HAND_CURSOR));
             jButtonConsultas.setFocusable(false);
            //Agregamos eventos 
            jButtonConsultas.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent evt) {
                   cerrarVentana();
           
                new MenuConsultas().setVisible(true);
                //JOptionPane.showMessageDialog(null, "Hi", "hi", JOptionPane.WARNING_MESSAGE);
                 
            }
            public void mouseEntered(MouseEvent evt){
                jButtonConsultas.setBackground(Color.yellow);
                
            }
            public void mouseExited(MouseEvent evt){
                jButtonConsultas.setBackground(Color.LIGHT_GRAY);
            }
        });
            
            
            
            jButtonCambios=new JButton("Cambios",iconoCam);
            jButtonCambios.setForeground(Color.BLUE);
            jButtonCambios.setFont(sizeFont);
            jButtonCambios.setHorizontalTextPosition(SwingConstants.LEFT);
            jButtonCambios.setVerticalAlignment(SwingConstants.BOTTOM);
            
            jButtonCambios.setCursor(new Cursor(Cursor.HAND_CURSOR));
             jButtonCambios.setFocusable(false);
            //Agregamos eventos 
           
            // jButtonCambios.addActionListener(act);
            jButtonCambios.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent evt) {
                   //JOptionPane.showMessageDialog(null, "Hi", "hi", JOptionPane.WARNING_MESSAGE);
                 cerrarVentana();
                 new Cambios().setVisible(true);
            }
            public void mouseEntered(MouseEvent evt){
                jButtonCambios.setBackground(Color.yellow);
                
            }
            public void mouseExited(MouseEvent evt){
                jButtonCambios.setBackground(Color.LIGHT_GRAY);
            }
        });
            icono= new ImageIcon("src/imagenes/Regresa.png");
            jButtonRegresar=new JButton("Regresar",icono);
             jButtonRegresar.setForeground(Color.BLUE);
            jButtonRegresar.setFont(sizeFont);
            
            jButtonRegresar.setCursor(new Cursor(Cursor.HAND_CURSOR));
             jButtonRegresar.setFocusable(false);
            //Agregamos eventos 
            jButtonRegresar.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent evt) {
                
                //JOptionPane.showMessageDialog(null, "Hi", "hi", JOptionPane.WARNING_MESSAGE);
                 
            }
            public void mouseEntered(MouseEvent evt){
                jButtonRegresar.setBackground(Color.yellow);
                
            }
            public void mouseExited(MouseEvent evt){
                jButtonRegresar.setBackground(Color.LIGHT_GRAY);
            }
        });
            jButtonRegresar.addActionListener(act);
            jButtonRegresar.setBorder(new BevelBorder(BevelBorder.LOWERED));
            
            jButtonSalir=new JButton("Salir",iconoSal);
            jButtonSalir.setForeground(Color.BLUE);
            jButtonSalir.setFont(sizeFont);
            jButtonSalir.setHorizontalTextPosition(SwingConstants.LEFT);
            jButtonSalir.setVerticalAlignment(SwingConstants.BOTTOM);
            
            jButtonSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jButtonSalir.setFocusable(false);
            //Agregamos eventos 
            jButtonSalir.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent evt) {
                System.exit(0);//cierra la ventana
                
            }
            public void mouseEntered(MouseEvent evt){
                jButtonSalir.setBackground(Color.yellow);
                
            }
            public void mouseExited(MouseEvent evt){
               jButtonSalir.setBackground(Color.LIGHT_GRAY);
            }
        });
            
        } catch (FontFormatException ex) {
           
        } catch (IOException ex) {
           
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error al cargar archivos", "Error", JOptionPane.ERROR_MESSAGE);
        }
          
        
      
           
        
        
        this.add(this.jButtonCheckIn);
        this.add(this.jButtonCheckOut);
        this.add(this.jButtonConsultas);
        this.add(this.jButtonCambios);
        this.add(this.jButtonSalir);
        this.add(this.jButtonRegresar);
    }
    private void cerrarVentana(){
        SwingUtilities.getWindowAncestor(this).dispose();
        
    }
    @Override
    public void paint(Graphics g){
       
            Dimension dimensiones=this.getSize();
          //  System.out.println("hi");
           
            
            g.drawImage(imagen,0, 0, dimensiones.width, dimensiones.height, null);
            //g.drawImage(alegria, (dimensiones.width/2)+50, 100, 200, 200, null);
            g.drawImage(escudo, (dimensiones.width/2)-60, (dimensiones.height)-515, 200, 170, null);
            g.setFont(sizeFont_2);
            g.setColor(Color.BLACK);
            g.drawString("HOTEL WOLFSBURG", (dimensiones.width/2)-505, 80);
            
            jButtonCheckIn.setBounds((dimensiones.width/2)-60,(dimensiones.height)-350, 150, 50);
            jButtonCheckOut.setBounds((dimensiones.width/2)-60, (dimensiones.height)-280, 150, 50);
            jButtonConsultas.setBounds((dimensiones.width/2)-60, (dimensiones.height)-210, 150, 50);
            jButtonCambios.setBounds((dimensiones.width/2)-60, (dimensiones.height)-140, 150, 50);
            jButtonSalir.setBounds((dimensiones.width/2)-60, (dimensiones.height)-70, 150, 50);
            jButtonRegresar.setBounds(10, (dimensiones.height)-60, 150, 50);
            this.setOpaque(false);
            super.paint(g);
      
        
        
    }
}

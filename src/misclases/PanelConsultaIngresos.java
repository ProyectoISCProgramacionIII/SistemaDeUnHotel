
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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import misframes.MenuConsultas;

public class PanelConsultaIngresos extends JPanel {
    private JLabel jLabelIngre, jLabelIngresos, jLabelConsultaIngresos;
    private JButton jButtonRegresar;
    private ActionListener act;
    private BufferedImage hotel,dinero,signo;
    private Font font1, font2, font3, font4;
    private String ruta="src/archivos/ingresos.txt";
    
    public PanelConsultaIngresos() {
        initComponents();
    }

    public PanelConsultaIngresos(ActionListener evt) {
        this.act = evt;
        initComponents();
    }
    
    private void leerArchivo() {
        FileReader source = null;
        try {
            int ch;
            char carac;
            String ingre="";
            source = new FileReader(ruta);
            ch = source.read();
            /* read() regresa un caracter leido en el rango de 0 to 65535
            * o -1 si el fin del flujo es alcanzado */
            while ( ch != -1 ) {
                carac = (char)ch;
                ch = source.read(); // extrae el caracter
                ingre += carac;
            }   // cierra el flujo
            source.close();
            this.jLabelIngresos.setText("$"+ingre);
            //System.out.println("Igresos= $"+ingre);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PanelConsultaIngresos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PanelConsultaIngresos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                source.close();
            } catch (IOException ex) {
                Logger.getLogger(PanelConsultaIngresos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    private void initComponents(){
        
        try{
           hotel=ImageIO.read(new File("src/imagenes/hotel.jpg"));
           dinero=ImageIO.read(new File("src/imagenes/dinero.jpg"));
           signo=ImageIO.read(new File("src/imagenes/signo.png"));
           
           font1=Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/Marlboro.ttf"));
           font1=font1.deriveFont(18f);
           
           font2=Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/Mick Caster.ttf"));
           font2=font2.deriveFont(35f);
           
           font3=Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/3D.ttf"));
           font3=font3.deriveFont(40f);
           
           font4=Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/LittlePanda.otf"));
           font4=font4.deriveFont(80f);
           
           jLabelIngresos=new JLabel(/*"$1588745"*/);
           jLabelIngresos.setFont(font4);
           //jLabelIngresos.setForeground(new Color(51,204,255));
           leerArchivo();
           
           jLabelIngre=new JLabel("Los ingresos son: ");
           jLabelIngre.setFont(font2);
           jLabelIngre.setForeground(new Color(0,0,202));
           
           jLabelConsultaIngresos=new JLabel("CONSULTA DE INGRESOS HOTEL WOLFSBURG");
           jLabelConsultaIngresos.setFont(font3);
           jLabelConsultaIngresos.setForeground(new Color(255,51,51));
           
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
           
        /*}catch (FontFormatException ex) {
            System.out.println("FontFormatException");*/
        }catch (IOException ex) {
            System.out.println("IOException");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error al cargar archivos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
        this.add(this.jLabelConsultaIngresos);
        this.add(this.jLabelIngre);
        this.add(this.jLabelIngresos);
        this.add(this.jButtonRegresar);
    }
    
    @Override
    public void paint(Graphics g){
        Dimension dimensiones=getSize();
        g.drawImage(hotel,0, 0,(dimensiones.width/2),(dimensiones.height/2), null);
        g.drawImage(dinero,(dimensiones.width/2),(dimensiones.height/2),(dimensiones.width/2),(dimensiones.height/2), null);
        g.drawImage(signo,0,(dimensiones.height/2),(dimensiones.width/2),(dimensiones.height/2), null);
        
        this.jButtonRegresar.setBounds((dimensiones.width/2)-385, (dimensiones.height/2)+250, 130, 50);
        
        this.jLabelConsultaIngresos.setBounds((dimensiones.width/2)-390, (dimensiones.height/2)-310, 780, 55);
        this.jLabelIngre.setBounds((dimensiones.width/2)+110, (dimensiones.height/2)-180, 280, 55);
        this.jLabelIngresos.setBounds((dimensiones.width/2)+10, (dimensiones.height/2)-100, 400, 100);
        
        
        this.setOpaque(false);
        super.paint(g);
    }
    
    private void cerrarVentana(){
        SwingUtilities.getWindowAncestor(this).dispose();
        
    }
    
    private void cerrar(){
        SwingUtilities.getWindowAncestor(this).dispose();
        new MenuConsultas().setVisible(true);
    }
    
}

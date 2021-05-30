
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
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

    private Font fuente,fuente2,fuente3,fuente4,sizeFont,sizeFont_2,sizeFont_3,sizeFont_4,sizeFont_5;
    private File font = null,font_1 = null,font_2 = null,font_3=null;
    private JTextField jTextFieldUsuario;
    private JPasswordField jPasswordFieldContrasena;
    private JLabel jLabelUsuario,jLabelContrasena,jLabelNombreHot,jLabelSlogan;
    private JButton jButtonIniciar,jButtonPlay,jButtonStop;
    private BufferedImage escudo;
    private ActionListener act;
    private Clip clip;
    private String ruta="src/cancion/FondoPrin.wav";
    
    public PanelLogIn(){
        initComponents();
        iniciarMusic();
        this.setBackground(Color.CYAN);
    }
    public PanelLogIn(ActionListener act){
        initComponents();
        iniciarMusic();
        this.act=act;
    }
    
    private void iniciarMusic(){
        try{//se inicializa el audio pero aun no se a empezado a reproducir
            clip= AudioSystem.getClip();
            
            clip.open(AudioSystem.getAudioInputStream(new File(ruta)));
        }catch(Exception ex){
            System.out.println("Ex");
            AudioFileFormat.Type[] tipos=AudioSystem.getAudioFileTypes();
            for(AudioFileFormat.Type i:tipos)
                System.out.println(i.getExtension());
        }
    }
    
    private void initComponents(){
        
//<<<<<<< HEAD
         /* try {
               font=new File("src/fonts/Alba.ttf");
              fuente=Font.createFont(Font.TRUETYPE_FONT, font);
              sizeFont=fuente.deriveFont(18f);
          } catch (FontFormatException ex) {
          
          } catch (IOException ex) {
              
            //Logger.getLogger(PanelLogIn.class.getName()).log(Level.SEVERE, null, ex);
        }*/
//=======
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
            font_3=new File("src/fonts/Salacia.otf");
            fuente4=Font.createFont(Font.TRUETYPE_FONT, font);
            sizeFont_5=fuente4.deriveFont(34f);
            
            escudo=ImageIO.read(new File("src/imagenes/hotel.jpg"));
        } catch (FontFormatException ex2) {
//>>>>>>> JuanCarlos2
         
        } catch (IOException ex2) {
              
        }catch(Exception ex2){
        }   
        
        
        jLabelNombreHot=new JLabel("HOTEL WOLFSBURG");
        jLabelNombreHot.setFont(sizeFont_3);
        jLabelNombreHot.setForeground(Color.ORANGE);
        jLabelSlogan=new JLabel('"'+"El Arte De Cumplir Tu Más Altas Expectativas"+'"');
        jLabelSlogan.setFont(sizeFont_4);
        jLabelSlogan.setForeground(Color.red);
        jTextFieldUsuario=new JTextField("");
        jTextFieldUsuario.setBorder(new  BevelBorder(BevelBorder.LOWERED));
        jPasswordFieldContrasena=new  JPasswordField();
        jPasswordFieldContrasena.setBorder(new  BevelBorder(BevelBorder.LOWERED));
        jLabelUsuario=new JLabel("Usuario");
        jLabelUsuario.setForeground(Color.red);
        jLabelUsuario.setBorder(new  BevelBorder(BevelBorder.LOWERED));
        jLabelUsuario.setFont(sizeFont);
        jLabelContrasena=new JLabel("Contraseña");
        jLabelContrasena.setForeground(Color.red);
        jLabelContrasena.setBorder(new  BevelBorder(BevelBorder.LOWERED));
        jLabelContrasena.setFont(sizeFont);
        jButtonPlay=new JButton("Play");
        jButtonPlay.setBackground(Color.GREEN);
        jButtonPlay.setFont(sizeFont_5);
        jButtonPlay.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        jButtonPlay.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                FloatControl gainControl =
                (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-10.0f); // Reduce volumen a 10 decibeles.
                clip.start();//se reproduce la musica
            }  
        });
        
        jButtonPlay.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseEntered(MouseEvent ev){

                jButtonPlay.setBackground(Color.yellow);
            }
            public void mouseExited(MouseEvent ev){
                jButtonPlay.setBackground(Color.GREEN);

            }
            public void mouseReleased(MouseEvent evt){
                    
            }

        });
        
        jButtonStop=new JButton("Stop");
        jButtonStop.setBackground(Color.red);
        jButtonStop.setFont(sizeFont_5);
        jButtonStop.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButtonStop.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                clip.stop();//pone en pausa la reproducción
            }
        });
        jButtonStop.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent ev){
                jButtonStop.setBackground(Color.yellow);
            }
            public void mouseExited(MouseEvent ev){
                jButtonStop.setBackground(Color.red);

            }
            public void mouseReleased(MouseEvent evt){
                
            }

        });
        
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
        this.add(this.jButtonPlay);
        this.add(this.jButtonStop);
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
        g.drawImage(escudo,0, 0, (dimensiones.width), (dimensiones.height), null);
        
        this.jLabelUsuario.setBounds((dimensiones.width/2)-150,(dimensiones.height/2)-80 , 100, 30);
        this.jLabelContrasena.setBounds((dimensiones.width/2)+100,(dimensiones.height/2)-80 , 100, 30);
        this.jTextFieldUsuario.setBounds((dimensiones.width/2)-150,(dimensiones.height/2)-20 , 100, 30);
        this.jPasswordFieldContrasena.setBounds((dimensiones.width/2)+100,(dimensiones.height/2)-20 , 100, 30);
        this.jButtonIniciar.setBounds((dimensiones.width/2)-60,(dimensiones.height/2)+50 , 150, 30);
        this.jButtonPlay.setBounds((dimensiones.width/2)-425,(dimensiones.height/2), 100, 50);
        this.jButtonStop.setBounds((dimensiones.width/2)+325,(dimensiones.height/2), 100, 50);
        this.jLabelNombreHot.setBounds(150,8,570, 90);
        this.jLabelSlogan.setBounds(170,(dimensiones.height/2)+220, 680, 50);
        this.setOpaque(false);
        super.paint(g);
        
    }
    
    
}



package misclases;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import misframes.CheckIn;
import misframes.MenuPrincipal;


public class PanelEstadoHabitaciones extends JPanel{
    private MySqlConn conn;
    private ArrayList <JButton> hab;
    private JPanel jPanelArriba,jPanelCentro,jPanelCentroIzq,jPanelCentroDer,jPanelCentroIzqIzq,jPanelCentroDerDer,jPanelPiso1,jPanelPiso2,jPanelSeparador;
    private JLabel jLabelPiso1,jLabelPiso2,jLabelTitulo;
    private File font;
    private Font fuente,sizeFont;
    private JButton boton=null,jButtonRegresar=null;
    private BufferedImage fondo=null;
    int i;
    public PanelEstadoHabitaciones() {
      
        this.conn=new MySqlConn();
       initComponents();
        iniciaArray();
        inicializaArray();
       
       
    
    }
    
    class Evento implements ActionListener{
        
        private int tipo,pos;
        public Evento(int num,int pos){
            this.tipo=num;
            this.pos=pos;
        }
        
        @Override
        public void actionPerformed(ActionEvent ae) {
          
            //LLamar check in...
            
            //System.out.println("tipo: "+this.tipo+" pos "+this.pos);
            cerrarVentana2();
            new CheckIn(tipo,pos).setVisible(true);
            
        }
        
        
        
    }
    
    private void initComponents(){
       // new Hotel();//solo para pruebas al correr solo esta ventana
         this.hab=new ArrayList();
         try {
            this.font=new File("src/fonts/ALBA.ttf");
            fuente=Font.createFont(Font.TRUETYPE_FONT, font);
            sizeFont=fuente.deriveFont(25f);
        } catch (FontFormatException ex) {
              sizeFont=new Font("Arial",Font.BOLD,15);
        } catch (IOException ex) {
            sizeFont=new Font("Arial",Font.BOLD,15);
        }
        try {
            this.fondo=ImageIO.read(new File("src/imagenes/HojasTropicales.jpg"));
        } catch (IOException ex) {
            System.out.println("err");
        }
        Dimension dimboton=new Dimension();
        dimboton.setSize(120, 50);
        ImageIcon icono= new ImageIcon("src/imagenes/Regresa.png");
       this.jPanelArriba=new JPanel(new BorderLayout());
       this.jLabelTitulo=new JLabel("Habitaciones");
       this.jLabelTitulo.setFont(this.sizeFont);
       this.jLabelTitulo.setBackground(Color.yellow);
       this.jLabelTitulo.setOpaque(true);
       this.jLabelTitulo.setHorizontalAlignment(JLabel.CENTER);
       this.jButtonRegresar=new JButton("Regresar",icono);
       
       this.jButtonRegresar.setMaximumSize(dimboton);
       this.jButtonRegresar.setCursor(new Cursor(Cursor.HAND_CURSOR));
       this.jButtonRegresar.setFocusable(false);
       this.jButtonRegresar.setBorder(new BevelBorder(BevelBorder.LOWERED));
       this.jButtonRegresar.addMouseListener(new MouseAdapter(){
           
           
           @Override
           public void mouseEntered(MouseEvent ev){
               
               jButtonRegresar.setBackground(Color.GREEN);
           }
           public void mouseExited(MouseEvent ev){
               jButtonRegresar.setBackground(Color.LIGHT_GRAY);
               
           }
           public void mouseReleased(MouseEvent ev){
               cerrarVentana();
               
           }
           
       });
       
       this.jPanelArriba.add(this.jButtonRegresar,BorderLayout.WEST);
       this.jPanelArriba.add(this.jLabelTitulo,BorderLayout.CENTER);
       
       this.jPanelCentro=new JPanel();
        this.jPanelCentroDer=new JPanel(new BorderLayout());
       this.jPanelCentroIzq=new JPanel(new BorderLayout());
       this.jPanelPiso1=new JPanel(new FlowLayout(FlowLayout.CENTER));
       this.jPanelPiso2=new JPanel(new FlowLayout(FlowLayout.CENTER));
       
       this.jPanelCentroDerDer=new JPanel(){
           
           @Override
           public void paint(Graphics g){
               Dimension dim=this.getSize();
              
               g.drawImage(fondo, 0,0, (dim.width),(dim.height),this);
               this.setOpaque(false);
               super.paint(g);
               
           }
           
           
           
           
       };
       this.jPanelCentroIzqIzq=new JPanel(){
           @Override
           public void paint(Graphics g){
               Dimension dim=this.getSize();
               
               g.drawImage(fondo, 0,0, (dim.width),(dim.height),this);
               this.setOpaque(false);
               super.paint(g);
               
           }
           
       };
        
       this.jPanelCentroDerDer.setBackground(Color.yellow);
     //  this.jPanelCentroIzqIzq.setBackground(Color.BLUE);
       this.jPanelSeparador=new JPanel(new FlowLayout());
       this.jPanelSeparador.setBackground(Color.CYAN);
       
       this.jPanelCentroIzqIzq.setLayout(new GridLayout(5,3,10,10));
       this.jPanelCentroDerDer.setLayout(new GridLayout(5,3,10,10));
       
       this.setLayout(new BorderLayout());
       this.jPanelCentro.setLayout(new BoxLayout(this.jPanelCentro,BoxLayout.LINE_AXIS));
       
 
       
       
       
       this.jLabelPiso1=new JLabel("Piso 1");
       this.jLabelPiso1.setSize(100, 50);
       this.jLabelPiso1.setFont(this.sizeFont);
       this.jLabelPiso1.setHorizontalAlignment(JLabel.CENTER);
       this.jLabelPiso1.setBackground(Color.PINK);
       this.jLabelPiso1.setOpaque(true);
       
        this.jLabelPiso2=new JLabel("Piso 2");
        this.jLabelPiso2.setSize(100, 50);
        this.jLabelPiso2.setFont(this.sizeFont);
        this.jLabelPiso2.setHorizontalAlignment(JLabel.CENTER);
        this.jLabelPiso2.setBackground(Color.PINK);
        this.jLabelPiso2.setOpaque(true);
       
       
       
    }
    
    private void iniciaArray(){
        String query="select * from habitacion";
        
        try{
            this.conn.Consult(query);
            
            int n=0,pos=0;
            this.conn.rs.last();
            n=this.conn.rs.getRow();
            this.conn.rs.first();
            if(n>0){
                
                for (int j = 0; j < n; j++) {
                    
                    
                    pos=this.conn.rs.getInt(18);
                    Hotel.habitaciones.get(pos).setEstado(true);
                    this.conn.rs.next();
                    
                }
                
                
            }else{
                for (int j = 0; j < Hotel.habitaciones.size(); j++) {
                    
                    
                    Hotel.habitaciones.get(pos).setEstado(false);
                    
                    
                }
                
                
            }
            
            
        }catch(Exception ex){
            System.err.println("Error");
        }
        
        
        
    }
    
    private void cerrarVentana(){
         SwingUtilities.getWindowAncestor(this).dispose();
        new MenuPrincipal().setVisible(true);
    }
        private void cerrarVentana2(){
         SwingUtilities.getWindowAncestor(this).dispose();
        }
    private void inicializaArray(){
        String tipo="";
        for ( i = 0; i < Hotel.habitaciones.size(); i++) {
            tipo=Hotel.habitaciones.get(i).getTipo()==1?"Sencilla":Hotel.habitaciones.get(i).getTipo()==2?"Doble":"triple";
            this.boton=new JButton("No."+Hotel.habitaciones.get(i).getNumero()+" "+tipo);
            this.boton.setFont(this.sizeFont);
            this.hab.add(boton);
             this.hab.get(i).setCursor(new Cursor(Cursor.HAND_CURSOR));
            this.hab.get(i).addActionListener(new Evento(Hotel.habitaciones.get(i).getTipo(),i));
            if(Hotel.habitaciones.get(i).isEstado()){
                this.hab.get(i).setEnabled(false);
                
            } else{
                this.hab.get(i).setEnabled(true);
            }
            if(i>=15){
                
                hab.get(i).setBackground(Color.green);
                
               
               
                this.jPanelCentroDerDer.add(this.hab.get(i));
            }else{
               
                hab.get(i).setBackground(Color.GREEN);
                this.jPanelCentroIzqIzq.add(this.hab.get(i));
            }
          //  this.hab.get(i).setSize(100, 50);
            
        }
        
        this.jPanelCentroIzq.add(this.jLabelPiso1,BorderLayout.NORTH);
        this.jPanelCentroDer.add(this.jLabelPiso2,BorderLayout.NORTH);
       
        this.jPanelCentroIzqIzq.repaint();
        this.jPanelCentroIzq.add(this.jPanelCentroIzqIzq,BorderLayout.CENTER);
        this.jPanelCentroDer.add(this.jPanelCentroDerDer,BorderLayout.CENTER);
        
        
        
        //this.setOpaque(true);
       
       this.jPanelCentro.add(this.jPanelCentroIzq);
       this.jPanelCentro.add(this.jPanelSeparador);
       this.jPanelCentro.add(this.jPanelCentroDer);
       this.add(this.jPanelArriba,BorderLayout.NORTH);
       this.add(this.jPanelCentro,BorderLayout.CENTER);
        
        
        
    }
    @Override
    public void paint(Graphics g){
        
        Dimension dim=this.getSize();
        
        dim=this.jPanelCentroIzqIzq.getSize();
        
        
        
    
        
        
  
        super.paint(g);
        
        
        
        
    }
    
    
    
    
    
}

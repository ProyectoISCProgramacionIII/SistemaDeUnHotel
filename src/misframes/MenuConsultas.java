/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misframes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
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
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import misclases.MySqlConn;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class MenuConsultas extends javax.swing.JFrame {

    
    private JPanel panel;
    private JButton jButtonConsulta1,jButtonConsulta2,jButtonConsulta3,jButtonConsulta4,
            jButtonConsulta5,jButtonConsulta6,jButtonConsulta7,jButtonConsulta8,jButtonConsulta9,
                    jButtonConsulta10,jButtonConsulta11,jButtonConsulta12,jButtonReg;
    private BufferedImage fondo,icono,logo;
    Icon iconoreg;
    private File font,font2;
    private Font fuente,fuente2,sizeFont;
    private Dimension dim;
    /**
     * Creates new form MenuConsultas
     */
    public MenuConsultas() {
        initComponents();
       
        
        iniciaPanel();
        iniciaFuente();
        iniciaImagenes();
        iniciaBotones();
        this.panel.setLayout(null);
        this.getContentPane().add(this.panel,BorderLayout.CENTER);
        this.setTitle("Consultas");
         this.setSize(1020, 640);
           this.setMinimumSize(new Dimension(1020,640));
        this.setLocationRelativeTo(null);
    }
    
    private void iniciaFuente(){
        
        this.font=new File("src/fonts/ALBA.ttf");
        this.font2=new File("src/fonts/Hanged.ttf");
        try {
            this.fuente=Font.createFont(Font.TRUETYPE_FONT, font);
            this.fuente2=Font.createFont(Font.TRUETYPE_FONT, font2);
        } catch (FontFormatException ex) {
           
        } catch (IOException ex) {
            
        }
        this.sizeFont =this.fuente.deriveFont(18f);
        
    }
    private void iniciaImagenes(){
        
        
        
        try {
            fondo=ImageIO.read(new File("src/imagenes/HojasTropicales.jpg"));
             icono=ImageIO.read(new File("src/imagenes/ConsultasIcono.png"));
             logo=ImageIO.read(new File("src/imagenes/hotel.jpg"));
             iconoreg=new ImageIcon(getClass().getResource("/imagenes/Regresa.png"));
        } catch (IOException ex) {
            Logger.getLogger(MenuConsultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                    
        
    }
    private void iniciaBotones(){
        
        this.jButtonConsulta1=new JButton("Galeria");
        this.jButtonConsulta1.setBounds(50, 100, 300, 50);
        this.jButtonConsulta1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.jButtonConsulta1.setBorder(new BevelBorder(BevelBorder.LOWERED));
        this.jButtonConsulta1.setFont(this.sizeFont);
        this.jButtonConsulta1.addMouseListener(new MouseAdapter(){
        
            
            @Override
            public void mouseEntered(MouseEvent ev){
                
                jButtonConsulta1.setBackground(Color.GREEN);
                
                
            }
        
            public void mouseExited(MouseEvent ev){
                jButtonConsulta1.setBackground(Color.LIGHT_GRAY);
                
                
            }
        public void mouseReleased(MouseEvent ev){
            dispose();

            new Galeria().setVisible(true);

        }
        
    });
        
        ///////////////////////////////////
         this.jButtonConsulta2=new JButton("Ingresos");
        this.jButtonConsulta2.setBounds(50, 160, 300, 50);
        this.jButtonConsulta2.setCursor(new Cursor(Cursor.HAND_CURSOR));
          this.jButtonConsulta2.setBorder(new BevelBorder(BevelBorder.LOWERED));
           this.jButtonConsulta2.setFont(this.sizeFont);
        this.jButtonConsulta2.addMouseListener(new MouseAdapter(){
        
            
            @Override
            public void mouseEntered(MouseEvent ev){
                
                jButtonConsulta2.setBackground(Color.GREEN);
                
                
            }
        
            public void mouseExited(MouseEvent ev){
                jButtonConsulta2.setBackground(Color.LIGHT_GRAY);
                
                
            }
        public void mouseReleased(MouseEvent ev){
            dispose();
            new ConsultaIngresos().setVisible(true);
            
            
        }
        
    });
        
        ////////////////////////////////////////////////////////////////////////
         this.jButtonConsulta3=new JButton("Porcentaje por tipo de habitacion");
        this.jButtonConsulta3.setBounds(50, 220, 300, 50);
        this.jButtonConsulta3.setCursor(new Cursor(Cursor.HAND_CURSOR));
          this.jButtonConsulta3.setBorder(new BevelBorder(BevelBorder.LOWERED));
           this.jButtonConsulta3.setFont(this.sizeFont);
        this.jButtonConsulta3.addMouseListener(new MouseAdapter(){
        
            
            @Override
            public void mouseEntered(MouseEvent ev){
                
                jButtonConsulta3.setBackground(Color.GREEN);
                
                
            }
        
            public void mouseExited(MouseEvent ev){
                jButtonConsulta3.setBackground(Color.LIGHT_GRAY);
                
                
            }
        public void mouseReleased(MouseEvent ev){
            dispose();

            new HabPorcentajes(new MySqlConn()).setVisible(true);

        }
        
    });
        ////////////////////////////////////////////////////////////
         this.jButtonConsulta4=new JButton("Total de habitaciones en el Hotel");
        this.jButtonConsulta4.setBounds(50, 280, 300, 50);
        this.jButtonConsulta4.setCursor(new Cursor(Cursor.HAND_CURSOR));
          this.jButtonConsulta4.setBorder(new BevelBorder(BevelBorder.LOWERED));
           this.jButtonConsulta4.setFont(this.sizeFont);
        this.jButtonConsulta4.addMouseListener(new MouseAdapter(){
        
            
            @Override
            public void mouseEntered(MouseEvent ev){
                
                jButtonConsulta4.setBackground(Color.GREEN);
                
                
            }
        
            public void mouseExited(MouseEvent ev){
                jButtonConsulta4.setBackground(Color.LIGHT_GRAY);
                
                
            }
        public void mouseReleased(MouseEvent ev){
            dispose();

            new TotalHab(new MySqlConn()).setVisible(true);
            

          

        }
        
    });
        
        ///////////////////////////////////////////////////
         this.jButtonConsulta5=new JButton("Porcentaje de ocupacion en el Hotel");
        this.jButtonConsulta5.setBounds(50, 340, 300, 50);
        this.jButtonConsulta5.setCursor(new Cursor(Cursor.HAND_CURSOR));
          this.jButtonConsulta5.setBorder(new BevelBorder(BevelBorder.LOWERED));
         this.jButtonConsulta5.setFont(this.sizeFont);
          this.jButtonConsulta5.addMouseListener(new MouseAdapter(){
        
            
            @Override
            public void mouseEntered(MouseEvent ev){
                
                jButtonConsulta5.setBackground(Color.GREEN);
                
                
            }
        
            public void mouseExited(MouseEvent ev){
                jButtonConsulta5.setBackground(Color.LIGHT_GRAY);
                
                
            }
        public void mouseReleased(MouseEvent ev){

             dispose();
            new OcupacionTotalHab(new MySqlConn()).setVisible(true);

        }
        
    });
        //////////////////////////////////////////////////////////////////////////////////////////
         this.jButtonConsulta6=new JButton("Costos de las habitaciones");
        this.jButtonConsulta6.setBounds(50, 400, 300, 50);
        this.jButtonConsulta6.setCursor(new Cursor(Cursor.HAND_CURSOR));
          this.jButtonConsulta6.setBorder(new BevelBorder(BevelBorder.LOWERED));
           this.jButtonConsulta6.setFont(this.sizeFont);
        this.jButtonConsulta6.addMouseListener(new MouseAdapter(){
        
            
            @Override
            public void mouseEntered(MouseEvent ev){
                
                jButtonConsulta6.setBackground(Color.GREEN);
                
                
            }
        
            public void mouseExited(MouseEvent ev){
                jButtonConsulta6.setBackground(Color.LIGHT_GRAY);
                
                
            }
        public void mouseReleased(MouseEvent ev){
            dispose();

            new ConsultaPrecios().setVisible(true);

        }
        
    });
        
        //////////////////////////////////////////////////////////////
         this.jButtonConsulta7=new JButton("Buscar huesped");
        this.jButtonConsulta7.setBounds(650, 100, 300, 50);
        this.jButtonConsulta7.setCursor(new Cursor(Cursor.HAND_CURSOR));
          this.jButtonConsulta7.setBorder(new BevelBorder(BevelBorder.LOWERED));
         this.jButtonConsulta7.setFont(this.sizeFont);
          this.jButtonConsulta7.addMouseListener(new MouseAdapter(){
        
            
            @Override
            public void mouseEntered(MouseEvent ev){
                
                jButtonConsulta7.setBackground(Color.GREEN);
                
                
            }
        
            public void mouseExited(MouseEvent ev){
                jButtonConsulta7.setBackground(Color.LIGHT_GRAY);
                
                
            }
        public void mouseReleased(MouseEvent ev){
            dispose();
            new Consulta7().setVisible(true);
            
            
        }
        
    });
        /////////////////////////////////////////////////////////////////////////////
         this.jButtonConsulta8=new JButton("Consulta de habitacion");
        this.jButtonConsulta8.setBounds(650, 160, 300, 50);
        this.jButtonConsulta8.setCursor(new Cursor(Cursor.HAND_CURSOR));
          this.jButtonConsulta8.setBorder(new BevelBorder(BevelBorder.LOWERED));
        this.jButtonConsulta8.setFont(this.sizeFont);
          this.jButtonConsulta8.addMouseListener(new MouseAdapter(){
        
            
            @Override
            public void mouseEntered(MouseEvent ev){
                
                jButtonConsulta8.setBackground(Color.GREEN);
                
                
            }
        
            public void mouseExited(MouseEvent ev){
                jButtonConsulta8.setBackground(Color.LIGHT_GRAY);
                
                
            }
        public void mouseReleased(MouseEvent ev){
            
            dispose();
            new ConsultaNombreHuesped().setVisible(true);
            
        }
        
    });
        ////////////////////////////////////////////////////////////////////////////////////////////
         this.jButtonConsulta9=new JButton("Habitaciones libres en un piso");
        this.jButtonConsulta9.setBounds(650, 220, 300, 50);
        this.jButtonConsulta9.setCursor(new Cursor(Cursor.HAND_CURSOR));
          this.jButtonConsulta9.setBorder(new BevelBorder(BevelBorder.LOWERED));
        this.jButtonConsulta9.setFont(this.sizeFont);
          this.jButtonConsulta9.addMouseListener(new MouseAdapter(){
        
            
            @Override
            public void mouseEntered(MouseEvent ev){
                
                jButtonConsulta9.setBackground(Color.GREEN);
                
                
            }
        
            public void mouseExited(MouseEvent ev){
                jButtonConsulta9.setBackground(Color.LIGHT_GRAY);
                
                
            }
        public void mouseReleased(MouseEvent ev){
            
            dispose();
            new Consulta9().setVisible(true);
            
        }
        
    });
        ////////////////////////////////////////////////////////////////////////////
         this.jButtonConsulta10=new JButton("Huespedes registrados");
        this.jButtonConsulta10.setBounds(650, 280, 300, 50);
        this.jButtonConsulta10.setCursor(new Cursor(Cursor.HAND_CURSOR));
          this.jButtonConsulta10.setBorder(new BevelBorder(BevelBorder.LOWERED));
         this.jButtonConsulta10.setFont(this.sizeFont);
          this.jButtonConsulta10.addMouseListener(new MouseAdapter(){
        
            
            @Override
            public void mouseEntered(MouseEvent ev){
                
                jButtonConsulta10.setBackground(Color.GREEN);
                
                
            }
        
            public void mouseExited(MouseEvent ev){
                jButtonConsulta10.setBackground(Color.LIGHT_GRAY);
                
                
            }
        public void mouseReleased(MouseEvent ev){
            dispose();
            new Consulta10ListaPersonas().setVisible(true);
        }
        
    });
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
         this.jButtonConsulta11=new JButton("Restaurante");
        this.jButtonConsulta11.setBounds(650, 340, 300, 50);
        this.jButtonConsulta11.setCursor(new Cursor(Cursor.HAND_CURSOR));
          this.jButtonConsulta11.setBorder(new BevelBorder(BevelBorder.LOWERED));
        this.jButtonConsulta11.setFont(this.sizeFont);
          this.jButtonConsulta11.addMouseListener(new MouseAdapter(){
        
            
            @Override
            public void mouseEntered(MouseEvent ev){
                
                jButtonConsulta11.setBackground(Color.GREEN);
                
                
            }
        
            public void mouseExited(MouseEvent ev){
                jButtonConsulta11.setBackground(Color.LIGHT_GRAY);
                
                
            }
        public void mouseReleased(MouseEvent ev){
            
            dispose();
            new Consulta11Comida().setVisible(true);
            
        }
        
    });
        /////////////////////////////////////////////////////
           this.jButtonReg=new JButton("Regresar");
        this.jButtonReg.setBounds(0, 0, 150, 50);
        this.jButtonReg.setCursor(new Cursor(Cursor.HAND_CURSOR));
          this.jButtonReg.setBorder(new BevelBorder(BevelBorder.LOWERED));
        this.jButtonReg.setFont(this.sizeFont);
        this.jButtonReg.setIcon(this.iconoreg);
          this.jButtonReg.addMouseListener(new MouseAdapter(){
        
            
            @Override
            public void mouseEntered(MouseEvent ev){
                
                jButtonReg.setBackground(Color.GREEN);
                
                
            }
        
            public void mouseExited(MouseEvent ev){
                jButtonReg.setBackground(Color.LIGHT_GRAY);
                
                
            }
        public void mouseReleased(MouseEvent ev){
            dispose();
            new MenuPrincipal().setVisible(true);
            
        }
        
    });
        
        this.panel.add(this.jButtonConsulta1);
         this.panel.add(this.jButtonConsulta2);
          this.panel.add(this.jButtonConsulta3);
           this.panel.add(this.jButtonConsulta4);
            this.panel.add(this.jButtonConsulta5);
             this.panel.add(this.jButtonConsulta6);
              this.panel.add(this.jButtonConsulta7);
               this.panel.add(this.jButtonConsulta8);
                this.panel.add(this.jButtonConsulta9);
                 this.panel.add(this.jButtonConsulta10);
                  this.panel.add(this.jButtonConsulta11);
                    this.panel.add(this.jButtonReg);
        
        
    }
    private void iniciaPanel(){
        
        this.panel=new JPanel(){
            
       
            
           
         //   private BufferedImage fondo=null,icono=null;
           
           public Dimension dim;
            
             
           @Override
           public void paint(Graphics g){
               
                dim=getSize();
               jButtonConsulta7.setBounds(dim.width-350, 100, 300, 50);
                jButtonConsulta8.setBounds(dim.width-350, 160, 300, 50);
                jButtonConsulta9.setBounds(dim.width-350, 220, 300, 50);
                jButtonConsulta10.setBounds(dim.width-350, 280, 300, 50);
               jButtonConsulta11.setBounds(dim.width-350, 340, 300, 50);
               g.drawImage(fondo, 0,0,dim.width, dim.height, null);
               g.drawImage(icono, (dim.width/2)-50,(dim.height/2),150, 100, null);
             g.drawImage(logo, (dim.width/2)-80,(dim.height/2)-200,200, 150, null);
            sizeFont=fuente2.deriveFont(80f);
             g.setFont(sizeFont);
             g.setColor(Color.WHITE);
             g.drawString("CONSULTAS", (dim.width)/2-200, 80);
               this.setOpaque(false);
               super.paint(g);
               
               
           } 
            
            
            
        };
        
        
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuConsultas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

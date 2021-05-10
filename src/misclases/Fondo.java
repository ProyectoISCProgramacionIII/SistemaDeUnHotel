

package misclases;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Fondo extends JPanel{
 
   private Image gif_estrella,gif_bienvenida,gif_alegria=null;
   private URL url=null;
   private Dimension dimensiones=null;
   private BufferedImage imagen,imagen2,imagen3;
   private Font fuente,sizeFont;
   private File font;
   
   
    public Fondo() {
       
     initComponents();  
    }

 public void initComponents(){
       try {
           imagen=ImageIO.read(new File("src/imagenes/Portada.jpg"));
           imagen2=ImageIO.read(new File("src/imagenes/Gallo.png"));
           imagen3=ImageIO.read(new File("src/imagenes/Logo_UAA.png"));
       } catch (IOException ex) {
           JOptionPane.showMessageDialog(null, "Error al cargar archivos", "Error",JOptionPane.ERROR_MESSAGE);
       }
       
        try {
            font=new File("src/fonts/3D.ttf");
            fuente=Font.createFont(Font.TRUETYPE_FONT, font);
            sizeFont=fuente.deriveFont(30f);
            
        
        } catch (FontFormatException ex) {
            
            sizeFont=new Font("Arial",Font.BOLD,26);
        } catch (IOException ex) {
           
            sizeFont=new Font("Arial",Font.BOLD,26);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error al cargar archivos", "Error",JOptionPane.ERROR_MESSAGE);
            sizeFont=new Font("Arial",Font.BOLD,26);
        }
     
     
 }
 public void paint(Graphics grafico){
       
       
            dimensiones = getSize();
            
       
           //variables para cargar un gif...
       
   //        URL url=null;
//Cargamos un Font externo(tipo de letra)...Importante uso de rutas relativas...
  
       
                
           //cargamos imagenes...
         
          
          //carga de gifs
          url=this.getClass().getResource("/imagenes/Estrella.gif");
          gif_estrella=new ImageIcon(url).getImage();
  
          
      //drawImage ()pinta imagen en el panel, con ayuda de la clase Graphics
            
            grafico.drawImage(imagen,0, 0, dimensiones.width, dimensiones.height, null);
            grafico.drawImage(imagen2,dimensiones.width-150,26, 180, 80, null);
            grafico.drawImage(imagen3,0,26, 180, 100, null);
            
             grafico.drawImage(gif_estrella,(dimensiones.width/2)-90,350, 180, 150, this);
             url=this.getClass().getResource("/imagenes/Bienvenidos.gif");
              gif_bienvenida=new ImageIcon(url).getImage();
             grafico.drawImage(gif_bienvenida,(dimensiones.width/2)-450,350, 250, 200, this);
             url=this.getClass().getResource("/imagenes/Alegria.gif");
              gif_alegria=new ImageIcon(url).getImage();
            grafico.drawImage(gif_alegria,dimensiones.width-360,350, 250, 150, this);
            //antes de escribir agregamos tipo de fuente
            grafico.setFont(sizeFont);
            grafico.setColor(Color.blue);
            grafico.drawString("UNIVERSIDAD AUTONOMA DE AGUASCALIENTES UAA", (dimensiones.width/2)-260, 30);
             grafico.drawString("ISC(INGENIERIA EN SISTEMAS COMPUTACIONALES)", (dimensiones.width/2)-260, 66);
              grafico.drawString("EQUIPO 11", (dimensiones.width/2)-60, 99);
               grafico.drawString("PROYECTO FINAL PROGRAMACION III", (dimensiones.width/2)-260, 128);
             grafico.setColor(Color.BLACK);
               grafico.drawString("MAESTRA: Georgina Salazar Partida", (dimensiones.width/2)-260, 159);
              grafico.drawString("INTEGRANTES: Juan Carlos Alonso Bravo,", (dimensiones.width/2)-260, 189);
               grafico.drawString("Oscar Arath Thomason Blanco, Cristobal", (dimensiones.width/2)-260, 219);
                grafico.drawString("Rivera Moreno y Eli Celeste Martinez Sald-", (dimensiones.width/2)-260, 249);
                grafico.drawString("ivar", (dimensiones.width/2)-260, 279);
                    grafico.drawString("FECHA: 16 de Junio de 2021", (dimensiones.width/2)-260, 309);
            setOpaque(false);
            //metodo paint de la superclase
            super.paint(grafico);
            
            
       
  
        
        
    }
}

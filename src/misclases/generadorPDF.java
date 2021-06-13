/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misclases;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class generadorPDF {
 
   

    
 public void crea(String cad,int num) {
        
        Document documento = new Document(PageSize.LETTER_LANDSCAPE);//Se crea el documento PDF con parametro del tamaño de la hoja
        Font font1=new Font(FontFactory.getFont(FontFactory.TIMES_ITALIC, 36, Font.BOLDITALIC,BaseColor.RED));
        Font font2=new Font(FontFactory.getFont(FontFactory.TIMES_ITALIC, 22, Font.BOLDITALIC,BaseColor.BLACK));
        Font font3=new Font(Font.FontFamily.TIMES_ROMAN,25,Font.ITALIC,BaseColor.GRAY);
        Font font4=new Font(Font.FontFamily.UNDEFINED,12,Font.ITALIC,BaseColor.BLACK);
        Font font5=new Font(Font.FontFamily.TIMES_ROMAN,11,Font.BOLD,BaseColor.DARK_GRAY);
        Paragraph titulo = new Paragraph("-Hotel Wolfsburg-",font1);//Parrafo con lo que debe de contenner y con que tipo de letra el font
        String lema="-El arte de cumplir tus mas altas expectativas-";
        String ubicacion="Zona Dorada #204, Los Cabos San Lucas";
        String desgloce=cad;
        String despedida="Estamos a sus ordenes vuelva pronto...";
        Paragraph lema1=new Paragraph(lema,font2);
        Paragraph ubicacion1=new Paragraph(ubicacion,font4);
        Paragraph desgloce1=new Paragraph(desgloce,font5);
        Paragraph despedida1=new Paragraph(despedida,font3);
        Paragraph vacio=new Paragraph("                             ");
        Paragraph gerente=new Paragraph("Gerente de Hotel: Juan Carlos Alonso Bravo",font5);
        
        try{
            FileOutputStream archivo = new FileOutputStream("src/archivos/"+num+"Factura.pdf");
            PdfWriter writer = PdfWriter.getInstance(documento, archivo);
            Image logo = Image.getInstance("src/imagenes/hotelversioncircular.png");
            Image firma = Image.getInstance("src/imagenes/firma.png");
            
            documento.open();
            documento.addTitle("Hotel Wolfsburg");
            documento.addAuthor("hotel Wolfsburg");
            
            logo.scaleAbsolute(50f, 50f);//Los limites de largo y ancho de la imagen
            logo.setAlignment(3);//alinneacion del elemento en este caso logo
            documento.add(logo);//añade al documento PDF el eleento del parentesis
            
            titulo.setAlignment(1);
            documento.add(titulo);
            
            lema1.setAlignment(1);
            documento.add(lema1);
            
            documento.add(vacio);
            ubicacion1.setAlignment(1);
            documento.add(ubicacion1);
            
            desgloce1.setAlignment(0);
            documento.add(desgloce1);
            
            
            
            documento.add(vacio);
            despedida1.setAlignment(0);
            documento.add(despedida1);
            
          
            
            documento.add(vacio);
            
            firma.setAlignment(1);
            firma.scaleAbsolute(150f, 60f);//Los limites de largo y ancho de la imagen
            gerente.setAlignment(1);
            documento.add(firma);
            documento.add(vacio);
            documento.add(gerente);
            
            
            
            documento.close();//cierra el documento PDF
        }catch(FileNotFoundException e){
            System.err.println(e.getMessage());
        }catch(DocumentException e){
            System.err.println(e.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(generadorPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}

    

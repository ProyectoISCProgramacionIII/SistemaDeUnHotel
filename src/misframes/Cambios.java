/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misframes;

import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import misclases.Habitacion;
import misclases.Hotel;
import misclases.MySqlConn;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Cambios extends javax.swing.JFrame {
    private JPanel panel;
    private ImageIcon iconoreg,iconoacepta;
    private BufferedImage fondo;
    private JTextArea jTextAreaInfo;
    private JScrollPane scroll;
    private Font fuente;
    private MySqlConn conn;
    private JLabel jLabelaux,jLabelBusca,jLabelPerExtra,jLabelDiasAPasar,jLabelPerNorPorHab,jLabelPerNorPorHab2;
    private JTextField jTextFieldaux,jTextFieldBusca,jTextFieldPerExtra,jTextFieldDiasAPasar,jTextFieldPerNorPorHab;
    private ArrayList <JLabel>labels;
    private ArrayList <JTextField>textfields;
    private ArrayList <JCheckBox> botonescheck;
    private File fuente2;
    private Font font,sizefont,fuentetitulo;
    private JCheckBox checkaux;
    private JButton jButtonreg,jButtonAceptar;
    private JDateChooser jDateChooserFechaSal;
    private JSpinner jSpinnerPerExtra,jSpinnerDiasAPasar;
    private SpinnerNumberModel formatoSpinner1, formatoSpinner2;
    private int valant;
    /**
     * Creates new form Cambios
     */
    public Cambios() {
       
       this.conn=new MySqlConn();
        initComponents();
         iniciaPanel();
         cargaFuente();
        iniciaImagenes();
        iniciaComponentes();
        iniciaTextArea();
        this.panel.setLayout(null);
        this.getContentPane().add(this.panel,BorderLayout.CENTER);
        this.setSize(1020, 640);
       this.setMinimumSize(new Dimension(1020,640));
        this.setTitle("Cambios");
        this.setLocationRelativeTo(null);
    }
    
    private void cargaFuente(){
        
        try{
        this.fuente2=new File("src/fonts/ALBA.ttf");
        this.font=Font.createFont(Font.TRUETYPE_FONT, fuente2);
        this.fuentetitulo=Font.createFont(Font.TRUETYPE_FONT,new File("src/fonts/Hanged.ttf"));
        this.sizefont=font.deriveFont(18f);
        }catch(Exception ex){
            System.err.println("Error al cargar fuente");
        }
        
    }
    private void iniciaComponentes(){
        this.jLabelBusca=new JLabel("Ingresa numero de habitacion y presiona enter ");
        this.jTextFieldBusca=new JTextField();
        
        this.jLabelDiasAPasar=new JLabel("Dias a quedar");
        this.jLabelPerExtra=new JLabel("Personas extra");
        this.jLabelPerNorPorHab=new JLabel("Habitacion para");
        this.jLabelPerNorPorHab2=new JLabel("Personas");
        
        this.jTextFieldDiasAPasar=new JTextField();
        this.jTextFieldPerExtra=new JTextField();
        this.jTextFieldPerNorPorHab=new JTextField();
        
        this.jSpinnerPerExtra=new JSpinner();
        this.formatoSpinner1=new SpinnerNumberModel();
        this.jSpinnerDiasAPasar=new JSpinner();
        this.formatoSpinner2=new SpinnerNumberModel();
        
      /*  this.jDateChooserFechaSal=new JDateChooser();
        this.jDateChooserFechaSal.setDateFormatString("yyyy/MM/dd");
        this.jDateChooserFechaSal.setBounds(565, 540, 150, 50);
        this.jDateChooserFechaSal.setBorder(new BevelBorder(BevelBorder.LOWERED));
        this.jDateChooserFechaSal.setFont(new Font("Arial Black",Font.BOLD,14));
        this.panel.add(this.jDateChooserFechaSal);
        */
        this.labels=new ArrayList();
        this.textfields=new ArrayList();
        this.botonescheck=new ArrayList();
        String nombres[]={"Numero","Estado","Tipo","Costo","Total de personas","Piso","Nombre","CD origen","Fecha de ingreso","Fecha de salida"};
        String servicios[]={"Servicio al cuarto","Servicio de bar","Servicio spa","Servicio de niñera","Servicio de tintoreria","Servicio de antro","Servicio de carro"};
                
        int cory=300;
        int corx=10;
        
        int corx2=800;
        int cory2=300;
        this.jLabelBusca.setBounds(10,260,550,30);
        this.jLabelBusca.setFont(new Font("Arial Black",Font.BOLD,18));
        this.jLabelBusca.setBorder(new BevelBorder(BevelBorder.LOWERED));
        this.jLabelBusca.setBackground(Color.LIGHT_GRAY);
        this.jLabelBusca.setOpaque(true);
        this.panel.add(this.jLabelBusca);
        //textfield busca
        this.jTextFieldBusca.setBounds(570,260,150,30);
        this.jTextFieldBusca.addKeyListener(new KeyAdapter(){
        
            public void keyReleased(KeyEvent ev){
                
                if(ev.getKeyCode()==KeyEvent.VK_ENTER){
                    
                    
                    despliegaDatos();
                    jTextFieldBusca.setText("");
                }
                
            }
        
        
        });
        
        this.panel.add(this.jTextFieldBusca);
        
        ///////////////////////////////////////////////////////////////////////////////////
            this.jLabelPerExtra.setFont(this.sizefont);
            this.jLabelPerExtra.setBorder(new BevelBorder(BevelBorder.LOWERED));
            this.jLabelPerExtra.setBackground(Color.CYAN);
            this.jLabelPerExtra.setOpaque(true);
            this.jLabelPerExtra.setBounds(10, 500,150, 30);
           this.panel.add(this.jLabelPerExtra);
        //////////////////////////////////////////////////////////////////////
           
           this.jSpinnerPerExtra.setBounds(170,500,100,30);
           this.jSpinnerPerExtra.setModel(formatoSpinner1);
         jSpinnerPerExtra.addChangeListener(new ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                eventoSpinnerPerExtra(evt);
            }
        });
          
           
           this.panel.add(this.jSpinnerPerExtra);
           //////////////////////////////////////////////////////////////////////////////
           
            this.jTextFieldPerNorPorHab.setBorder(new BevelBorder(BevelBorder.LOWERED));
            this.jTextFieldPerNorPorHab.setEditable(false);
              this.jTextFieldPerNorPorHab.setFont(new Font("Arial Black",Font.BOLD,14));
            this.jTextFieldPerNorPorHab.setBounds(170,540,40,30);
            this.panel.add(this.jTextFieldPerNorPorHab);
           //////////////////////////////////////////////////////////////////////////////////
         this.jLabelPerNorPorHab.setFont(this.sizefont);
            this.jLabelPerNorPorHab.setBorder(new BevelBorder(BevelBorder.LOWERED));
            this.jLabelPerNorPorHab.setBackground(Color.CYAN);
            this.jLabelPerNorPorHab.setOpaque(true);
            this.jLabelPerNorPorHab.setBounds(10, 540,150, 30);
           this.panel.add(this.jLabelPerNorPorHab);
           
            this.jLabelPerNorPorHab2.setFont(this.sizefont);
            this.jLabelPerNorPorHab2.setBorder(new BevelBorder(BevelBorder.LOWERED));
            this.jLabelPerNorPorHab2.setBackground(Color.CYAN);
            this.jLabelPerNorPorHab2.setOpaque(true);
            this.jLabelPerNorPorHab2.setBounds(220, 540,100, 30);
           this.panel.add(this.jLabelPerNorPorHab2);
           
           /////////////////////////////////////////////////////////////////
             this.jLabelDiasAPasar.setFont(this.sizefont);
            this.jLabelDiasAPasar.setBorder(new BevelBorder(BevelBorder.LOWERED));
            this.jLabelDiasAPasar.setBackground(Color.CYAN);
            this.jLabelDiasAPasar.setOpaque(true);
            this.jLabelDiasAPasar.setBounds(220, 500,150, 30);
           this.panel.add(this.jLabelDiasAPasar);
           ////////////////////////////////////////////////////////////////////////////////////////////
           this.jSpinnerDiasAPasar.setBounds(170,500,100,30);
           this.jSpinnerDiasAPasar.setModel(formatoSpinner2);
            jSpinnerDiasAPasar.addChangeListener(new ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                eventoSpinnerDiasAPasar(evt);
            }
        });
          
           
           
           this.panel.add(this.jSpinnerDiasAPasar);
           /////////////////////////////////////////////////////////////
        
        //boton de regresa...
        this.jButtonreg=new JButton("Regresar");
        this.jButtonreg.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.jButtonreg.setBorder(new BevelBorder(BevelBorder.LOWERED));
        this.jButtonreg.setBounds(0, 0, 150, 50);
        this.jButtonreg.setFont(this.sizefont);
        this.jButtonreg.setIcon(iconoreg);
        this.jButtonreg.addMouseListener(new MouseAdapter(){
            
                @Override
                public void mouseEntered(MouseEvent ev){
                    jButtonreg.setBackground(Color.GREEN);
                }
        
                public void mouseExited(MouseEvent ev){
                    
                    jButtonreg.setBackground(Color.LIGHT_GRAY);
               
                }
                public void mouseReleased(MouseEvent ev){
                    dispose();
                    new MenuPrincipal().setVisible(true);
                    
                }
        
        });
        
        this.panel.add(this.jButtonreg);
        
        
        
        
        //BOTON DE ACEPTAR
        this.jButtonAceptar=new JButton("Aceptar");
        this.jButtonAceptar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.jButtonAceptar.setBorder(new BevelBorder(BevelBorder.LOWERED));
        this.jButtonAceptar.setBounds(0, 0, 150, 50);
         this.jButtonAceptar.setHorizontalTextPosition(SwingConstants.LEFT);
           // this.jButtonAceptar.setVerticalAlignment(SwingConstants.BOTTOM);
        this.jButtonAceptar.setFont(this.sizefont);
        this.jButtonAceptar.setIcon(iconoacepta);
        this.jButtonAceptar.addMouseListener(new MouseAdapter(){
            
                @Override
                public void mouseEntered(MouseEvent ev){
                    jButtonAceptar.setBackground(Color.GREEN);
                }
        
                public void mouseExited(MouseEvent ev){
                    
                    jButtonAceptar.setBackground(Color.LIGHT_GRAY);
               
                }
                public void mouseReleased(MouseEvent ev){
                    
                    eventoCambios();
                }
        
        });
        
        this.panel.add(this.jButtonAceptar);

        
        for (int i = 0; i < 10; i++) {
            if(i==5){
                cory=300;
                corx=400;
            }
            this.jLabelaux=new JLabel(nombres[i]);
            this.jLabelaux.setFont(this.sizefont);
            this.jLabelaux.setBorder(new BevelBorder(BevelBorder.LOWERED));
            this.jLabelaux.setBackground(Color.CYAN);
            this.jLabelaux.setOpaque(true);
            this.jLabelaux.setBounds(corx, cory, 150, 30);
            this.labels.add(this.jLabelaux);
            this.panel.add(this.labels.get(i));
            
            
            this.jTextFieldaux=new JTextField();
            this.jTextFieldaux.setBorder(new BevelBorder(BevelBorder.LOWERED));
              this.jTextFieldaux.setFont(new Font("Arial Black",Font.BOLD,14));
            this.jTextFieldaux.setBounds(corx+160,cory,150,30);
            if(i<=5 || i>=8){
                this.jTextFieldaux.setEditable(false);
            }
            this.textfields.add(jTextFieldaux);
              this.panel.add(this.textfields.get(i));
            
            //RadioButtons...
            if(i<7){
                    this.checkaux=new JCheckBox(servicios[i]);
                    this.checkaux.setBounds(corx2,cory2,200,25);
                    this.checkaux.setBackground(Color.cyan);
                    this.checkaux.setOpaque(true);
                    this.checkaux.setFont(new Font("Arial Black",Font.BOLD,14));
                  
                     this.botonescheck.add(checkaux);
       
                      this.panel.add(this.botonescheck.get(i));
       
            }
            
            cory+=40;
            cory2+=30;
            
          
             }
        
        
        
    }
    
    private void eventoSpinnerPerExtra(ChangeEvent evt){
        
        try{
            int num=Integer.parseInt(this.jTextFieldPerNorPorHab.getText().trim());
            num=(Integer)this.jSpinnerPerExtra.getValue()+num;
           
            this.textfields.get(4).setText(""+num);
            
        }catch(NumberFormatException ex){
             
            JOptionPane.showMessageDialog(this, "No hay datos aun, por favor ingresa primero el numero de una habitacion ocupada");
           // this.jSpinnerPerExtra.setValue((Integer)0);
        }
        
    }
    private void eventoSpinnerDiasAPasar(ChangeEvent evt){
        
         try{
             if(this.textfields.get(9).getText().trim().isEmpty()){
                 throw new NumberFormatException();
             }
             Calendar calendario=Calendar.getInstance();
             Date fechadate=new Date();
            String fecha=this.textfields.get(8).getText().trim();
             SimpleDateFormat aux=new SimpleDateFormat("yyyy-MM-dd");
             
             try {
                 
                 this.valant=(Integer)this.jSpinnerDiasAPasar.getValue();
                 int dias=(Integer)this.jSpinnerDiasAPasar.getValue();
                 fechadate=aux.parse(fecha);
                 
                 calendario.setTime(fechadate);
                 calendario.add(Calendar.DAY_OF_YEAR,dias);
                 
                 fechadate=calendario.getTime();
                 this.textfields.get(9).setText(aux.format(fechadate));
                 
                 
             } catch (ParseException ex) {
                
             }catch(NumberFormatException ex){
                 
             }catch (Exception ex){
                 
             }
            
             
             
        }catch(NumberFormatException ex){
             
            JOptionPane.showMessageDialog(this, "No hay datos aun, por favor ingresa primero el numero de una habitacion ocupada");
           // this.jSpinnerPerExtra.setValue((Integer)0);
        }
        
        
        
        
    }
    private void despliegaDatos(){
        int numero;
        SimpleDateFormat aux=new SimpleDateFormat("yyyy-MM-dd");
         String query;
         boolean band=true;
        try{
             numero=Integer.parseInt(this.jTextFieldBusca.getText().trim());
              query="select * from habitacion where numero='"+numero+"'";
               this.conn.Consult(query);
        }catch(NumberFormatException ex){
            
            JOptionPane.showMessageDialog(this, "Solo se permiten digitos del 0 al 9");
            band=false;
        }catch(Exception ex){
            band=false;
        }
         
        
        
        if(band){
        int n=0;
        
        try{
            this.conn.rs.last();
            n=this.conn.rs.getRow();
            this.conn.rs.first();
            if(n>0){
                
                this.textfields.get(0).setText(""+this.conn.rs.getInt(1));
                if(this.conn.rs.getBoolean(2)){
                    this.textfields.get(1).setText("Ocupada");
                
                }else{
                    
                }
                String aux2=this.conn.rs.getInt(10)==1?"Sencilla":this.conn.rs.getInt(10)==2?"Doble":"Sencilla";
                this.textfields.get(2).setText(""+aux2);
                this.textfields.get(3).setText(""+this.conn.rs.getDouble(11));
                 this.textfields.get(4).setText(""+this.conn.rs.getInt(12));
                 this.textfields.get(5).setText(""+this.conn.rs.getInt(13));
                   this.textfields.get(6).setText(""+this.conn.rs.getString(14));
                this.textfields.get(7).setText(""+this.conn.rs.getString(15));
                this.textfields.get(8).setText(""+this.conn.rs.getString(16));
               // this.jDateChooserFechaSal.setDate(aux.parse(this.conn.rs.getString(17)));
                this.textfields.get(9).setText(""+this.conn.rs.getString(17));
                 int liminf,limsup;
                 liminf=0;
                limsup=this.conn.rs.getInt(10);
                limsup=limsup==1?Habitacion.MAX_PER_1:limsup==2?Habitacion.MAX_PER_2:Habitacion.MAX_PER_3;
                this.jTextFieldPerExtra.setText(""+this.conn.rs.getString(12));
                 this.jTextFieldPerNorPorHab.setText(""+(limsup-2));
              
                
                Integer auxint=this.conn.rs.getInt(20);
                this.jSpinnerPerExtra.setValue(auxint);
                
                //limsup=2;
                this.formatoSpinner1.setMinimum(liminf);
                this.formatoSpinner1.setMaximum(2);
                
                this.jSpinnerDiasAPasar.setValue((Integer)this.conn.rs.getInt(19));
                this.formatoSpinner2.setMinimum(1);
                
               
                
                this.botonescheck.get(0).setSelected(this.conn.rs.getBoolean(3));
                this.botonescheck.get(1).setSelected(this.conn.rs.getBoolean(4));
                this.botonescheck.get(2).setSelected(this.conn.rs.getBoolean(5));
                this.botonescheck.get(3).setSelected(this.conn.rs.getBoolean(6));
                this.botonescheck.get(4).setSelected(this.conn.rs.getBoolean(7));
                this.botonescheck.get(5).setSelected(this.conn.rs.getBoolean(8));
                this.botonescheck.get(6).setSelected(this.conn.rs.getBoolean(9));
                
                
            }else{
                JOptionPane.showMessageDialog(null,"No existen habitaciones con ese numero o habitacion desocupada" );
            }
            
        }catch(Exception ex){
            
        }
        }
        
    }
    private void eventoCambios(){
        
        String nombre,fechain,fechasal,cdorigen;
        int totper=0,perextra=0,diasaquedar=0;
        boolean band=true;
        SimpleDateFormat fein=new SimpleDateFormat("yyyy-MM-dd"),fesal=new SimpleDateFormat("yyyy/MM/dd");
       int servcuarto,servbar,servspa,servantro,servtintoreria,servninera,servcarro;
        nombre=this.textfields.get(6).getText();
       fechain=this.textfields.get(8).getText();
        //fechasal=((JTextField)(this.jDateChooserFechaSal.getDateEditor().getUiComponent())).getText();
        fechasal=this.textfields.get(9).getText();
        cdorigen=this.textfields.get(7).getText();
           if(this.textfields.get(0).getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "No estan todos los datos");
            band=false;
        }
        /*try{
            totper=Integer.parseInt(this.textfields.get(4).getText());//que tipo de habitacion es....
             if(Integer.parseInt(this.textfields.get(2).getText().trim())==1){
            if(totper>Habitacion.MAX_PER_1){
                JOptionPane.showMessageDialog(this, "Excediste limite de personas en habitacion de tipo 1");
                band=false;
            }*/
            
        /*}else if(Integer.parseInt(this.textfields.get(2).getText().trim())==2){
            if(totper>Habitacion.MAX_PER_2){
                JOptionPane.showMessageDialog(this, "Excediste limite de personas en habitacion de tipo 2");
                band=false; 
            }*/
            
            
        /*}else{
            if(totper>Habitacion.MAX_PER_3){
                JOptionPane.showMessageDialog(this, "Excediste limite de personas en habitacion de tipo 3");
                band=false;
            }
            
        }*/
      /*  }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Solo digitos en el campo de total de personas");
                band=false;
            }*/
       
                

        //try{
        /*if(fesal.parse(fechasal).before(fein.parse(fechain)) || fesal.parse(fechasal).equals(fein.parse(fechain))){
            JOptionPane.showMessageDialog(this, "Fecha de salida invalida");
            band=false;
        }else {
       
        }
        }catch(Exception ex){

        }    */
     
    
           try{
               
               perextra=(Integer)this.jSpinnerPerExtra.getValue();
               diasaquedar=(Integer)this.jSpinnerDiasAPasar.getValue();
           }catch(Exception ex){
               JOptionPane.showMessageDialog(this, "Error en personas extra o en dias a quedarse.Solo se aceptan numeros");
               band=false;
           }
           
           
        if(band){
            servcuarto=this.botonescheck.get(0).isSelected()?1:0;
            servbar=this.botonescheck.get(1).isSelected()?1:0;
            servspa=this.botonescheck.get(2).isSelected()?1:0;
            servninera=this.botonescheck.get(3).isSelected()?1:0;
            servtintoreria=this.botonescheck.get(4).isSelected()?1:0;
            servantro=this.botonescheck.get(5).isSelected()?1:0;
            servcarro=this.botonescheck.get(6).isSelected()?1:0;
            totper=Integer.parseInt(this.jTextFieldPerNorPorHab.getText().trim());
            totper+=perextra;
            
            int numero=Integer.parseInt(this.textfields.get(0).getText().trim());
            String query="update habitacion set nombre='"+nombre+"',fechaingreso='"+fechain+"',fechasalida='"+fechasal+"',cdorigen='"+cdorigen+"'"
                    +",totpersonas='"+totper+"',servcuarto='"+servcuarto+"',servbar='"+servbar+"',servspa='"+servspa+"',"
                    + "servninera='"+servninera+"',servtintoreria='"+servtintoreria+"',servantro='"+servantro+"',servcarro='"
                    +servcarro+"',totDias='"+diasaquedar+"',personasExtr='"+perextra+"'"+" where numero='"+numero+"'";
            
            try{
                int n=this.conn.Update(query);
                if(n>0){
                    renuevaTextArea();
                    
                }
                
                
            }catch(Exception ex){
                
                
            }
            
            
            
        }else{
            
            
            
        }
        
        
    }
    
    private void renuevaTextArea(){
        String cadena="";
         String query="select * from habitacion ORDER BY numero ASC";
         try{
            this.conn.Consult(query);
        }catch(Exception ex){
            System.err.println("errrr");
        }
         
         
         int n;
        try{
            this.conn.rs.last();
            n=this.conn.rs.getRow();
            this.conn.rs.first();
            if(n>0){
                 cadena=String.format("%80s  \n", "DATOS DISPONIBLES");
                 cadena+=String.format("%80s  \n", "HABITACIONES");
                
                 for (int i = 0; i < n; i++) {
                     
                        cadena+=String.format("Numero: %-40s \n",this.conn.rs.getInt(1));
                        if(this.conn.rs.getBoolean(2)){
                            cadena+=String.format("Estado: %-40s \n","ocupada");
                        
                        }else{
                            cadena+=String.format("Estado: %-40s \n","desocupada");
                         
                        }
                        
                         if(this.conn.rs.getBoolean(3)){
                            cadena+=String.format("Servicio al cuarto: %-40s \n","si");
                             
                        }else{
                            cadena+=String.format("Servicio al cuarto: %-40s \n","no");
                            
                        }
                         if(this.conn.rs.getBoolean(4)){
                               cadena+=String.format("Servicio al bar: %-40s \n","si");
                         }else{
                                 cadena+=String.format("Servicio al bar: %-40s \n","no");
                         
                         }
                         
                          if(this.conn.rs.getBoolean(5)){
                              cadena+=String.format("Servicio spa: %-40s \n","si");
                        
                          }else{
                              cadena+=String.format("Servicio spa: %-40s \n","no");
                           
                         }
                          
                           if(this.conn.rs.getBoolean(6)){
                                cadena+=String.format("Servicio de niñera: %-40s \n","si");
                      
                        
                          }else{
                                 cadena+=String.format("Servicio de niñera: %-40s \n","no");
                          
                         }
                          if(this.conn.rs.getBoolean(7)){
                                cadena+=String.format("Servicio de tintoreria: %-40s \n","si");
                        
                          }else{
                              
                                cadena+=String.format("Servicio de tintoreria: %-40s \n","no");
                          }
                          
                          if(this.conn.rs.getBoolean(8)){
                                cadena+=String.format("Servicio antro: %-40s \n","si");
                        
                          }else{
                              cadena+=String.format("Servicio antro: %-40s \n","no");
                        
                          }
                          
                           if(this.conn.rs.getBoolean(9)){
                               cadena+=String.format("Servicio de carro: %-40s \n","si");
                        
                          }else{
                              cadena+=String.format("Servicio carro: %-40s \n","no");
                        
                          }
                       String aux=this.conn.rs.getInt(10)==1?"Sencilla":this.conn.rs.getInt(10)==2?"Doble":"Triple";
                       int habitacionpara=this.conn.rs.getInt(10);
           
                       habitacionpara=habitacionpara==1?1:habitacionpara==2?2:3;
                        cadena+=String.format("Tipo: %-40s \n",aux);
                        cadena+=String.format("Costo: %-40.3f \n",this.conn.rs.getDouble(11));
                        cadena+=String.format("Total de personas: %-40s \n",this.conn.rs.getInt(12));
                         cadena+=String.format("Personas extra: %-40s \n",this.conn.rs.getInt(20));
                         cadena+=String.format("Habitacion para %d Personas\n",habitacionpara);
                        cadena+=String.format("Piso: %-40s \n",this.conn.rs.getInt(13));
                        cadena+=String.format("Nombre: %-40s \n",this.conn.rs.getString(14));
                        cadena+=String.format("Ciudad origen: %-40s \n",this.conn.rs.getString(15));
                        cadena+=String.format("Fecha de ingreso: %-40s \n",this.conn.rs.getString(16));
                        cadena+=String.format("Fecha de salida: %-40s \n",this.conn.rs.getString(17));
                         cadena+=String.format("Dias que se quedara: %-40s \n",this.conn.rs.getInt(19));
                       // cadena+=String.format("Numero: %-40s \n",this.conn.rs.getInt(1));
                        cadena+=String.format("%-40s \n","_____________________________________________________");
                      
                        
                        this.conn.rs.next();
       
                }
            }else{
               cadena=String.format("%80s\n ", "NO HAY DATOS DISPONIBLES");
        
            }
            
        }catch (Exception ex){
            
           
        }
       
        
        
        
        
        
        this.jTextAreaInfo.setText(cadena);
         this.scroll.setSize(0, 0);
    }
    
    private void iniciaTextArea(){
        String query="select * from habitacion ORDER BY nombre ASC";
        String cadena="";
        this.fuente=new Font("Arial Black",Font.BOLD,14);
        this.jTextAreaInfo=new JTextArea(200,50);
        
        this.jTextAreaInfo.setLineWrap(true);
        this.jTextAreaInfo.setWrapStyleWord(true);
        this.jTextAreaInfo.setFont(fuente);
        this.jTextAreaInfo.setEditable(false);
   
      
        this.jTextAreaInfo.setText(cadena);
       this.jTextAreaInfo.setBackground(Color.PINK);
      // this.jTextAreaInfo.setBounds(0, 0,300, 100);
      
       this.scroll=new JScrollPane(this.jTextAreaInfo);
       this.scroll.setBounds(0,50,300,250);
       JLabel header=new JLabel("Datos disponibles");
       header.setHorizontalAlignment(JLabel.CENTER);
       header.setFont(new Font("Arial Black",Font.BOLD,14));
       this.scroll.setColumnHeaderView(header);
       this.scroll.setSize(0, 0);
      this.renuevaTextArea();
       
       this.panel.add(this.scroll);
        
        
    }
    private void iniciaImagenes(){
        
        try {
            this.fondo=ImageIO.read(new File("src/imagenes/Tropical.jpg"));
            this.iconoreg=new ImageIcon(getClass().getResource("/imagenes/Regresa.png"));
              this.iconoacepta=new ImageIcon(getClass().getResource("/imagenes/Confirma.jpg"));
        } catch (IOException ex) {
            System.err.println("Error");
        }
        
    }
    private void iniciaPanel(){
        
        
        this.panel=new JPanel(){
            
           
            @Override
            public void paint(Graphics g){
                Dimension dim=getSize();
                int corx=400,cory=300;
                for (int i = 5; i < 10; i++) {
                      
                    
                   labels.get(i).setBounds(dim.width/2-150,cory,150,30);
                   
                   textfields.get(i).setBounds(dim.width/2+10,cory,150,30);
                   
                     cory+=40;
                }
                cory=300;
                for (int i = 0; i < 7; i++) {
                    botonescheck.get(i).setBounds(dim.width-280, cory, 250, 25);
                    cory+=30;
                }
                jButtonAceptar.setBounds(dim.width-215, 520, 150, 50);
                scroll.setBounds(0,50,dim.width,200);
                jLabelDiasAPasar.setBounds(dim.width/2-150, 500,150, 30);
                jSpinnerDiasAPasar.setBounds(dim.width/2+10,500,100,30);
                //jDateChooserFechaSal.setBounds(dim.width/2+60, 540, 150, 50);
                g.drawImage(fondo, 0, 0,dim.width,dim.height, null);
                
                fuentetitulo=fuentetitulo.deriveFont(45f);
                g.setFont(fuentetitulo);
                g.setColor(Color.black);
                g.drawString("CAMBIOS", dim.width/2-100, 35);
                
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
            java.util.logging.Logger.getLogger(Cambios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cambios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cambios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cambios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cambios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

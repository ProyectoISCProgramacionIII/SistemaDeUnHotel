/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misframes;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import misclases.MySqlConn;
import misframes.MenuPrincipal;
import misclases.generadorPDF;

/**
 *
 * @author User
 */
public class CheckOut extends javax.swing.JFrame {

    /**
     * Creates new form Checkout
     */
    private static String linea;
    Integer num,totalfacturas;
    Double ingreso,pago,ingreso1,mostraringresos;
    MySqlConn conn;
    public CheckOut() {
        this.conn=new MySqlConn();
        initComponents();
        jButtonGenerarPDF.setEnabled(false);
        this.setSize(736,480);
        this.setMinimumSize(new Dimension(736,480));
        this.setMaximumSize(new Dimension(1020,640));
        this.setLocationRelativeTo(null);
        
    }
    public static String fechaActual(){
        Date fecha=new Date();
        SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/YYYY");
        return formatoFecha.format(fecha);
        
    }
    private void abrirarchivo(){
        FileWriter file = null;
        try {
            FileReader fr = null;
            try {
                fr = new FileReader ("src/Archivos/NoFactura.txt");
                BufferedReader br = new BufferedReader(fr);
                linea=br.readLine();//recupera una linea del archivo de texto
            
                 num=Integer.parseInt(linea);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fr.close();
                } catch (IOException ex) {
                    Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println(num);
            num++;
            String num1=Integer.toString(num);
            System.out.println(num1);
            file=new FileWriter("src/archivos/NoFactura.txt");
            BufferedWriter writer = new BufferedWriter(file);
            writer.write(num1);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
        } 
 
      }
     private void abrirIngresos(){
        FileWriter file = null;
        try {
            FileReader fr = null;
            try {
                fr = new FileReader ("src/Archivos/ingresos.txt");
                BufferedReader br = new BufferedReader(fr);
                linea=br.readLine();//recupera una linea del archivo de texto
            
                 ingreso=Double.parseDouble(linea);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fr.close();
                } catch (IOException ex) {
                    Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println(ingreso);
            ingreso=ingreso+pago;
            String ingreso1=Double.toString(ingreso);
            System.out.println(ingreso1);
            file=new FileWriter("src/archivos/ingresos.txt");
            BufferedWriter writer = new BufferedWriter(file);
            writer.write(ingreso1);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
        } 
 
      }
     private void mostraringresos(){
         FileWriter file = null;
        
            FileReader fr = null;
            try {
                fr = new FileReader ("src/Archivos/ingresos.txt");
                BufferedReader br = new BufferedReader(fr);
                linea=br.readLine();//recupera una linea del archivo de texto
            
                 mostraringresos=Double.parseDouble(linea);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fr.close();
                } catch (IOException ex) {
                    Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println(mostraringresos);
            
            
            try {
                fr = new FileReader ("src/Archivos/NoFactura.txt");
                BufferedReader br = new BufferedReader(fr);
                linea=br.readLine();//recupera una linea del archivo de texto
            
                 totalfacturas=Integer.parseInt(linea);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fr.close();
                } catch (IOException ex) {
                    Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println(totalfacturas);
            
            
     }
     private void eliminarregistro(){
         String query="delete from habitacion where numero="+"'"+Integer.parseInt(this.jTextFieldHabitacion.getText().trim())+"'"; 

            int j=this.conn.Update(query);
            if(j>0){
                JOptionPane.showMessageDialog(this,"Baja realizada","Exito!",PLAIN_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this,"La baja no se pudo realizar","Fallo", WARNING_MESSAGE );
            }

     }
    
     
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldHabitacion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldFechaIngreso = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldFechaSalida = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldTotalDias = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jButtonGenerarPDF = new javax.swing.JButton();
        jButtonRegresar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButtonIngresos = new javax.swing.JButton();
        FondoPantalla = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Check out");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(260, 10, 159, 44);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logominiatura.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(430, 20, 30, 30);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Numero de Habitacion:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 70, 129, 17);

        jTextFieldHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHabitacionActionPerformed(evt);
            }
        });
        jTextFieldHabitacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldHabitacionKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldHabitacion);
        jTextFieldHabitacion.setBounds(170, 70, 50, 24);

        jTable1.setBackground(new java.awt.Color(0, 0, 0));
        jTable1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Estado", "Nombre", "Piso", "Personas", "Costo", "Tipo", "S.Carro", "S.Antro", "S.Tintoreria", "S.Niñera", "S.Spa", "S.Bar", "S.aCuartp"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 140, 700, 50);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fecha de ingreso:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 210, 99, 17);

        jTextFieldFechaIngreso.setEditable(false);
        jTextFieldFechaIngreso.setBackground(new java.awt.Color(0, 0, 0));
        jTextFieldFechaIngreso.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextFieldFechaIngreso);
        jTextFieldFechaIngreso.setBounds(130, 210, 80, 24);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fecha de salida:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 254, 89, 30);

        jTextFieldFechaSalida.setEditable(false);
        jTextFieldFechaSalida.setBackground(new java.awt.Color(0, 0, 0));
        jTextFieldFechaSalida.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextFieldFechaSalida);
        jTextFieldFechaSalida.setBounds(130, 260, 80, 24);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Dias a cobrar:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(40, 310, 79, 17);

        jTextFieldTotalDias.setEditable(false);
        jTextFieldTotalDias.setBackground(new java.awt.Color(0, 0, 0));
        jTextFieldTotalDias.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextFieldTotalDias);
        jTextFieldTotalDias.setBounds(130, 310, 40, 24);

        jTextArea1.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(380, 210, 270, 160);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Corroborar datos");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(180, 110, 97, 17);

        jButtonGenerarPDF.setBackground(new java.awt.Color(204, 204, 204));
        jButtonGenerarPDF.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jButtonGenerarPDF.setText("Generar Factura");
        jButtonGenerarPDF.setEnabled(false);
        jButtonGenerarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerarPDFActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGenerarPDF);
        jButtonGenerarPDF.setBounds(480, 400, 125, 32);

        jButtonRegresar.setBackground(new java.awt.Color(102, 102, 102));
        jButtonRegresar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRegresar.setText("Regresar");
        jButtonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRegresar);
        jButtonRegresar.setBounds(40, 400, 83, 32);

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cambios");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(320, 103, 80, 30);

        jButtonIngresos.setBackground(new java.awt.Color(0, 0, 0));
        jButtonIngresos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ingresoslogo.jpg"))); // NOI18N
        jButtonIngresos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonIngresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIngresosActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonIngresos);
        jButtonIngresos.setBounds(650, 30, 40, 40);

        FondoPantalla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondonegro.jpg"))); // NOI18N
        getContentPane().add(FondoPantalla);
        FondoPantalla.setBounds(0, 0, 734, 480);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHabitacionActionPerformed
        // TODO add your handling code here:
        String fechasalida,fechaingreso;
        Double Totalsin,Totalcon,perextra;
         String query="select * from habitacion where numero='"+Integer.parseInt(this.jTextFieldHabitacion.getText().trim())+"'";
         this.conn.Consult(query);
         int n=0;
         try{
            this.conn.rs.last();
            n=this.conn.rs.getRow();
            this.conn.rs.first();
        }catch(Exception e){
            System.out.println("Error#1...");
        }
        if(n != 0){
            
            Object datos[][] = new Object[1][14];
                try{
                    
                    if(this.conn.rs.getBoolean(2)){
                            datos[0][0]=String.format("ocupada");
                        }else{
                            datos[0][0]=String.format("desocupada");
                        }
                    
                    datos[0][1]=this.conn.rs.getString(14);
                    datos[0][2]=this.conn.rs.getInt(13);
                    datos[0][3]=this.conn.rs.getInt(12);
                    datos[0][4]=this.conn.rs.getInt(11);
                    datos[0][5]=this.conn.rs.getInt(10);
                    if(this.conn.rs.getBoolean(9)){
                            datos[0][6]=String.format("SI");
                        }else{
                            datos[0][6]=String.format("NO");
                        }
                    if(this.conn.rs.getBoolean(9)){
                            datos[0][7]=String.format("SI");
                        }else{
                            datos[0][7]=String.format("NO");
                        }
                     if(this.conn.rs.getBoolean(7)){
                            datos[0][8]=String.format("SI");
                        }else{
                            datos[0][8]=String.format("NO");
                        }
                     if(this.conn.rs.getBoolean(6)){
                            datos[0][9]=String.format("SI");
                        }else{
                            datos[0][9]=String.format("NO");
                        }
                     if(this.conn.rs.getBoolean(5)){
                            datos[0][10]=String.format("SI");
                        }else{
                            datos[0][10]=String.format("NO");
                        }
                     if(this.conn.rs.getBoolean(4)){
                            datos[0][11]=String.format("SI");
                        }else{
                            datos[0][11]=String.format("NO");
                        }
                     if(this.conn.rs.getBoolean(3)){
                            datos[0][12]=String.format("SI");
                        }else{
                            datos[0][12]=String.format("NO");
                        }
                     
                  this.jTextFieldFechaIngreso.setText(""+this.conn.rs.getString(16));
                   this.jTextFieldFechaSalida.setText(""+this.conn.rs.getString(17));
                   this.jTextFieldTotalDias.setText(""+this.conn.rs.getString(19));
                    
                    
                    this.conn.rs.next();
                }
               catch(Exception e){
                    System.out.println("Error#2..."+e.getMessage());
                }
                
            
            String columnas[]={"Estado","Nombre","Piso","Personas","Costo",
                "Tipo","S.Carro","S.Antro","S.Tintoreria","S.Niñera","S.Spa","S.Bar","S.aCuarto"};
            jTable1.setModel(new DefaultTableModel(datos,columnas));
            System.out.println("tabla lista");
            
        }
        else{
            JOptionPane.showMessageDialog(this,"No existe ese dato"); 
           this.jTextFieldFechaIngreso.setText("");
                   this.jTextFieldFechaSalida.setText("");
                   this.jTextFieldTotalDias.setText("");
                   Object datos[][] = new Object[1][14];
              
                    
                    
                            datos[0][0]=String.format("");
                             datos[0][1]=String.format("");
                              datos[0][2]=String.format("");
                               datos[0][4]=String.format("");
                        datos[0][5]=String.format("");
                             datos[0][6]=String.format("");
                              datos[0][7]=String.format("");
                               datos[0][8]=String.format("");
                         datos[0][9]=String.format("");
                             datos[0][10]=String.format("");
                              datos[0][11]=String.format("");
                               datos[0][12]=String.format("");
                               String columnas[]={"Estado","Nombre","Piso","Personas","Costo",
                "Tipo","S.Carro","S.Antro","S.Tintoreria","S.Niñera","S.Spa","S.Bar","S.aCuarto"};
            jTable1.setModel(new DefaultTableModel(datos,columnas));
            System.out.println("tabla limpia");
             this.jTextArea1.setText(null);
        }         
                    
        
     String cadena="";
         
         try{
            this.conn.Consult(query);
        }catch(Exception ex){
            System.err.println("err");
        }
         
        try{
            this.conn.rs.last();
            n=this.conn.rs.getRow();
            this.conn.rs.first();
            if(n>0){
                 cadena+=String.format("%40s  \n", "FACTURA ");
                        cadena+=String.format("Fecha: %s \n",fechaActual());
                        cadena+=String.format("Numero: %-40s \n",this.conn.rs.getInt(1));
                        cadena+=String.format("Nombre: %-40s \n",this.conn.rs.getString(14));
                        cadena+=String.format("Ciudad origen: %-40s \n",this.conn.rs.getString(15));
                        cadena+=String.format("Fecha de ingreso: %-40s \n",this.conn.rs.getString(16));
                        cadena+=String.format("Fecha de salida: %-40s \n",this.conn.rs.getString(17));
                        cadena+=String.format("Tipo: %-40s \n",this.conn.rs.getInt(10));
                        cadena+=String.format("Costo: %-40.3f \n ",this.conn.rs.getDouble(11));
                        cadena+=String.format("Dias en estancia: %-40s \n",this.conn.rs.getInt(19));
                        Totalsin=this.conn.rs.getDouble(11)*this.conn.rs.getInt(19);
                        
                        
                        cadena+=String.format("Total sin Cargos: %-40.3f \n",Totalsin);
                        Totalcon=Totalsin;
                        //cadena+=String.format("Total con Cargos: %-40.3f \n");
                        cadena+=String.format("Servicios extras: \n");
                        
                         if(this.conn.rs.getBoolean(3)){
                            cadena+=String.format("Servicio al cuarto: %-40s \n","$140");
                             Totalcon=Totalcon+140;
                        }
                         if(this.conn.rs.getBoolean(4)){
                               cadena+=String.format("Servicio al bar: %-40s \n","$100");
                               Totalcon=Totalcon+100;
                         }
                         
                          if(this.conn.rs.getBoolean(5)){
                              cadena+=String.format("Servicio spa: %-40s \n","$240");
                              Totalcon=Totalcon+240;
                        
                          }
                          
                           if(this.conn.rs.getBoolean(6)){
                                cadena+=String.format("Servicio de niñera: %-40s \n","$250");
                                Totalcon=Totalcon+250;
                      
                        
                          }
                          if(this.conn.rs.getBoolean(7)){
                                cadena+=String.format("Servicio de tintoreria: %-40s \n","$120");
                                Totalcon=Totalcon+120;
                        
                          }
                          
                          if(this.conn.rs.getBoolean(8)){
                                cadena+=String.format("Servicio antro: %-40s \n","$200");
                                Totalcon=Totalcon+200;
                        
                          }
                          
                           if(this.conn.rs.getBoolean(9)){
                               cadena+=String.format("Servicio de carro: %-40s \n","$280");
                               Totalcon=Totalcon+280;
                        
                          }
                           if(this.conn.rs.getInt(20)==1){
                               perextra=this.conn.rs.getDouble(11)*0.15;
                               cadena+=String.format("1 Persona extra $%-40.2f",perextra);
                               Totalcon=Totalcon+perextra;
                           }
                           if(this.conn.rs.getInt(20)==2){
                               perextra=this.conn.rs.getDouble(11)*0.25;
                               cadena+=String.format("2 Persona extra $%-40.2f",perextra);
                               Totalcon=Totalcon+perextra;
                           }
                           
                           cadena+=String.format("\n TOTAL CON CARGOS: $ %-40.2f \n ",Totalcon);
                           jButtonGenerarPDF.setEnabled(true);
                           pago=Totalcon;
                       
                        
                        
                        
                        
                       
                      
                        
                        this.conn.rs.next();
       
                
            }else{
               cadena=String.format("%40s\n ", "NO HAY DATOS DISPONIBLES");
               jButtonGenerarPDF.setEnabled(false);
        
            }
            
        }catch (Exception ex){
            
           
        }
       
        this.jTextArea1.setText(cadena);
        
    
        
        
    }//GEN-LAST:event_jTextFieldHabitacionActionPerformed

    private void jButtonGenerarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerarPDFActionPerformed
        
        String cadena2;
        
       abrirarchivo();
       cadena2=this.jTextArea1.getText();
            
            JOptionPane.showMessageDialog(this,"Estas seguro de generar factura?","Check Out ", WARNING_MESSAGE);
            generadorPDF obj= new generadorPDF();
        obj.crea(cadena2,num);
        abrirIngresos();
           eliminarregistro();
          JOptionPane.showMessageDialog(this,"Factura genrada con exito","exito",PLAIN_MESSAGE);
          
    }//GEN-LAST:event_jButtonGenerarPDFActionPerformed

    private void jButtonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarActionPerformed
        // TODO add your handling code here:
        MenuPrincipal a=new MenuPrincipal();
        a.setVisible(true);
        this.setVisible(false);
        
        
    }//GEN-LAST:event_jButtonRegresarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       Cambios a= new Cambios();
       a.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonIngresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIngresosActionPerformed
    mostraringresos();
    
    JOptionPane.showMessageDialog(this,"Facturas Totales :"+totalfacturas+"\n Total ingresos :"+mostraringresos,"Ingresos",PLAIN_MESSAGE);       
        
    }//GEN-LAST:event_jButtonIngresosActionPerformed

    private void jTextFieldHabitacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldHabitacionKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(c<'0'||c>'9'){

            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldHabitacionKeyTyped

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
            java.util.logging.Logger.getLogger(CheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckOut().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FondoPantalla;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonGenerarPDF;
    private javax.swing.JButton jButtonIngresos;
    private javax.swing.JButton jButtonRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldFechaIngreso;
    private javax.swing.JTextField jTextFieldFechaSalida;
    private javax.swing.JTextField jTextFieldHabitacion;
    private javax.swing.JTextField jTextFieldTotalDias;
    // End of variables declaration//GEN-END:variables
}

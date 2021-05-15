/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misframes;

import com.toedter.calendar.JCalendar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.*;
import misclases.Cliente;

/**
 *
 * @author Hp
 */
public class RegClientes extends javax.swing.JFrame {
    private Font fuente,sizeFont;
    private File font;
    private BufferedImage escudo;
    private Calendar Ingre,salida;
    private String fechaIn,nom,fecIng,cd,fecSal;
    private Vector<String> service=new Vector();
    private int totOcu;
    private Date fechas;
    private SimpleDateFormat f;
    /**
     * Creates new form RegClientes
     */
    public RegClientes() {
        initComponents();
        this.setLocationRelativeTo(null);
        initComponents2();
    }

    private void initComponents2() {
        Ingre=Calendar.getInstance();
        if((Ingre.get(Calendar.MONTH)+1)<10){
            fechaIn=Ingre.get(Calendar.DAY_OF_MONTH)+"/0"+(Ingre.get(Calendar.MONTH)+1)+"/"+Ingre.get(Calendar.YEAR);
        }else{
            fechaIn=Ingre.get(Calendar.DAY_OF_MONTH)+"/"+(Ingre.get(Calendar.MONTH)+1)+"/"+Ingre.get(Calendar.YEAR);
            
        }
        this.jTextFieldMostrarFechaIng.setText(fechaIn);
        try {
            
            font=new File("src/fonts/3D.ttf");
            fuente=Font.createFont(Font.TRUETYPE_FONT, font);
            sizeFont=fuente.deriveFont(28f);
            this.jLabelCheckIn.setFont(sizeFont);
            //this.jLabelCheckIn.setForeground(Color.RED);
            

            
        } catch (FontFormatException ex) {
            Logger.getLogger(RegClientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RegClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    class EventoCerrar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            dispose();
            new MenuPrincipal().setVisible(true);
        }
        
        public void cerrarVentana(){
            dispose();
        }
        
    }
    
    private void llenarObj(){
        //se debe validar que los campos importantes deben de ser llenados
        if(jTextFieldNomHuesped.getText().isEmpty() && jTextFieldCdOrigen.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Campos Obligatorios NO llenados \nLlene TODOS los campos...","Check In Incorrecto", WARNING_MESSAGE);
            return;
        }else{
            nom=this.jTextFieldNomHuesped.getText();
            fecIng=this.fechaIn;
            cd=this.jTextFieldCdOrigen.getText();
        }
        
        fechas=this.jDateChooserSal.getDate();
        f=new SimpleDateFormat("dd/MM/yyyy");
        fecSal= f.format(fechas);
        salida=f.getCalendar();
        //validar que la fecha sea mayor a un dia
        if(salida.get(Calendar.YEAR)==Ingre.get(Calendar.YEAR)){
            if(salida.get(Calendar.MONTH)==Ingre.get(Calendar.MONTH)){
                if(salida.get(Calendar.DAY_OF_MONTH)>Ingre.get(Calendar.DAY_OF_MONTH)){
                    //sigue el codifgo va bien
                }else{
                    JOptionPane.showMessageDialog(this,"La fecha de salida es Erronea...","Check In Incorrecto", WARNING_MESSAGE);
                    return;
                }
            }else if(salida.get(Calendar.MONTH)>Ingre.get(Calendar.MONTH)){//si el mes es menor al mes que se ingreso eso esta mal
                //esta bien la fecha de salida
            }else{
                JOptionPane.showMessageDialog(this,"La fecha de salida es Erronea...","Check In Incorrecto", WARNING_MESSAGE);
                return;
            }
        }else if(salida.get(Calendar.YEAR)>Ingre.get(Calendar.YEAR)){
            //si el año es mayor no importa el mes ni el dia
        }else{//esta mal la fecha
            JOptionPane.showMessageDialog(this,"La fecha de salida es Erronea...","Check In Incorrecto", WARNING_MESSAGE);
            return;
        }
        
        
        int totHab=(int)this.jSpinnerTotalHabi.getValue();
        
        if(this.jCheckBoxServCuarto.isSelected()){
            this.service.add(this.jCheckBoxServCuarto.getText());
            
        }
        
        if(this.jCheckBoxServBar.isSelected()){
            this.service.add(this.jCheckBoxServBar.getText());
        }
        
        if(this.jCheckBoxServTintoreria.isSelected()){
            this.service.add(this.jCheckBoxServTintoreria.getText());
        }
        
        if(this.jCheckBoxServSPA.isSelected()){
           this.service.add(this.jCheckBoxServSPA.getText());
        }
        
        if(this.jCheckBoxServNiñera.isSelected()){
            this.service.add(this.jCheckBoxServNiñera.getText());
        }
        
        if(this.jCheckBoxServAntro.isSelected()){
            this.service.add(this.jCheckBoxServAntro.getText());
        }
        
        if(this.jCheckBoxServCarro.isSelected()){
            this.service.add(this.jCheckBoxServCarro.getText());
        }
        
        if(1==0){
            
            if(((int)this.jSpinnerTotalHabi.getValue())<=4 && ((int)this.jSpinnerTotalHabi.getValue())>0){
                if(((int)this.jSpinnerTotalHabi.getValue())<=2){
                    if(!this.jRadioButtonPersonaExtr1.isSelected() && !this.jRadioButtonPersonaExtr2.isSelected()){
                        totOcu=((int)this.jSpinnerTotalHabi.getValue());
                    }else{
                        JOptionPane.showMessageDialog(this,"Campo de total de Ocupantes \nNO marco los Extra Bien","Check In Incorrecto", WARNING_MESSAGE);
                        return;
                    }
                    
                }else{
                    if((((int)this.jSpinnerTotalHabi.getValue())-2)==1){
                        if(this.jRadioButtonPersonaExtr1.isSelected()){
                            totOcu=((int)this.jSpinnerTotalHabi.getValue())+1;
                        }else{
                            JOptionPane.showMessageDialog(this,"Campo de total de Ocupantes \nNO marco los Extra Bien","Check In Incorrecto", WARNING_MESSAGE);
                            return;
                        }
                    }else if((((int)this.jSpinnerTotalHabi.getValue())-2)==2){
                        if(this.jRadioButtonPersonaExtr2.isSelected()){
                            totOcu=((int)this.jSpinnerTotalHabi.getValue())+2;
                        }else{
                            JOptionPane.showMessageDialog(this,"Campo de total de Ocupantes \nNO marco los Extra Bien","Check In Incorrecto", WARNING_MESSAGE);
                            return;
                        }
                    }
                }
                JOptionPane.showMessageDialog(this,"Registro Exitoso...","Exitoso", PLAIN_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this,"Campo de total de Ocupantes de la Habitación","Check In Incorrecto", WARNING_MESSAGE);
                return;
            }
            
            
        }else if(2==1){
            if(((int)this.jSpinnerTotalHabi.getValue())<=6 && ((int)this.jSpinnerTotalHabi.getValue())>0){
                if(((int)this.jSpinnerTotalHabi.getValue())<=4){
                    if(!this.jRadioButtonPersonaExtr1.isSelected() && !this.jRadioButtonPersonaExtr2.isSelected()){
                        totOcu=((int)this.jSpinnerTotalHabi.getValue());
                    }else{
                        JOptionPane.showMessageDialog(this,"Campo de total de Ocupantes \nNO marco los Extra Bien","Check In Incorrecto", WARNING_MESSAGE);
                        return;
                    }
                }else{
                    if((((int)this.jSpinnerTotalHabi.getValue())-4)==1){
                        if(this.jRadioButtonPersonaExtr1.isSelected()){
                            totOcu=((int)this.jSpinnerTotalHabi.getValue())+1;
                        }else{
                            JOptionPane.showMessageDialog(this,"Campo de total de Ocupantes \nNO marco los Extra Bien","Check In Incorrecto", WARNING_MESSAGE);
                            return;
                        }
                    }else if((((int)this.jSpinnerTotalHabi.getValue())-4)==2){
                        if(this.jRadioButtonPersonaExtr2.isSelected()){
                            totOcu=((int)this.jSpinnerTotalHabi.getValue())+2;
                        }else{
                            JOptionPane.showMessageDialog(this,"Campo de total de Ocupantes \nNO marco los Extra Bien","Check In Incorrecto", WARNING_MESSAGE);
                            return;
                        }
                    }
                }
                JOptionPane.showMessageDialog(this,"Registro Exitoso...","Exitoso", PLAIN_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this,"Campo de total de Ocupantes de la Habitación","Check In Incorrecto", WARNING_MESSAGE);
                return;
            }
            
        }else if(3==3){
            if(((int)this.jSpinnerTotalHabi.getValue())<=8 && ((int)this.jSpinnerTotalHabi.getValue())>0){
                if(((int)this.jSpinnerTotalHabi.getValue())<=6){
                    if(!this.jRadioButtonPersonaExtr1.isSelected() && !this.jRadioButtonPersonaExtr2.isSelected()){
                        totOcu=((int)this.jSpinnerTotalHabi.getValue());
                    }else{
                        JOptionPane.showMessageDialog(this,"Campo de total de Ocupantes \nNO marco los Extra Bien","Check In Incorrecto", WARNING_MESSAGE);
                        return;
                    }
                }else{
                    if((((int)this.jSpinnerTotalHabi.getValue())-6)==1){
                        if(this.jRadioButtonPersonaExtr1.isSelected()){
                            totOcu=((int)this.jSpinnerTotalHabi.getValue())+1;
                        }else{
                            JOptionPane.showMessageDialog(this,"Campo de total de Ocupantes \nNO marco los Extra Bien","Check In Incorrecto", WARNING_MESSAGE);
                            return;
                        }
                    }else if((((int)this.jSpinnerTotalHabi.getValue())-6)==2){
                        if(this.jRadioButtonPersonaExtr2.isSelected()){
                            totOcu=((int)this.jSpinnerTotalHabi.getValue())+2;
                        }else{
                            JOptionPane.showMessageDialog(this,"Campo de total de Ocupantes \nNO marco los Extra Bien","Check In Incorrecto", WARNING_MESSAGE);
                            return;
                        }
                    }
                }
                JOptionPane.showMessageDialog(this,"Registro Exitoso...","Exitoso", PLAIN_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this,"Campo de total de Ocupantes de la Habitación","Check In Incorrecto", WARNING_MESSAGE);
                return;
            }
        }
        //Cliente(String nomHuesped, String cdOrigen, String fechaIng, String fechaSal, Vector<String> servExtr, Calendar actual)
        Cliente cliente=new Cliente(nom,cd,fechaIn, fecSal, service,Ingre);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupPersonExtras = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabelCheckIn = new javax.swing.JLabel();
        jLabelNomHuesped = new javax.swing.JLabel();
        jLabelCdOrigen = new javax.swing.JLabel();
        jTextFieldNomHuesped = new javax.swing.JTextField();
        jTextFieldCdOrigen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSpinnerTotalHabi = new javax.swing.JSpinner();
        jTextFieldPersonasExtr = new javax.swing.JTextField();
        jRadioButtonPersonaExtr1 = new javax.swing.JRadioButton();
        jRadioButtonPersonaExtr2 = new javax.swing.JRadioButton();
        jTextFieldFechaIngr = new javax.swing.JTextField();
        jDateChooserSal = new com.toedter.calendar.JDateChooser();
        jTextFieldMostrarFechaIng = new javax.swing.JTextField();
        jLabelServicios = new javax.swing.JLabel();
        jCheckBoxServBar = new javax.swing.JCheckBox();
        jCheckBoxServCuarto = new javax.swing.JCheckBox();
        jCheckBoxServTintoreria = new javax.swing.JCheckBox();
        jCheckBoxServSPA = new javax.swing.JCheckBox();
        jCheckBoxServNiñera = new javax.swing.JCheckBox();
        jCheckBoxServAntro = new javax.swing.JCheckBox();
        jCheckBoxServCarro = new javax.swing.JCheckBox();
        jButtonRegistrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro Huesped");

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabelCheckIn.setForeground(new java.awt.Color(204, 0, 102));
        jLabelCheckIn.setText("CHECK IN");

        jLabelNomHuesped.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        jLabelNomHuesped.setForeground(new java.awt.Color(255, 153, 51));
        jLabelNomHuesped.setText("Nombre del Huesped: ");

        jLabelCdOrigen.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        jLabelCdOrigen.setForeground(new java.awt.Color(255, 153, 51));
        jLabelCdOrigen.setText("Ciudad de Origen: ");

        jLabel4.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 51));
        jLabel4.setText("Total de Ocupantes de la Habitacion: ");

        jTextFieldPersonasExtr.setEditable(false);
        jTextFieldPersonasExtr.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        jTextFieldPersonasExtr.setForeground(new java.awt.Color(255, 153, 51));
        jTextFieldPersonasExtr.setText("Personas Extra(s): ");
        jTextFieldPersonasExtr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPersonasExtrActionPerformed(evt);
            }
        });

        buttonGroupPersonExtras.add(jRadioButtonPersonaExtr1);
        jRadioButtonPersonaExtr1.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jRadioButtonPersonaExtr1.setText("1 Persona Extra");

        buttonGroupPersonExtras.add(jRadioButtonPersonaExtr2);
        jRadioButtonPersonaExtr2.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jRadioButtonPersonaExtr2.setText("2 Personas Extra");

        jTextFieldFechaIngr.setEditable(false);
        jTextFieldFechaIngr.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        jTextFieldFechaIngr.setForeground(new java.awt.Color(255, 153, 51));
        jTextFieldFechaIngr.setText("Fecha de Ingreso: ");

        jDateChooserSal.setName("JDateChooserSal"); // NOI18N

        jTextFieldMostrarFechaIng.setEditable(false);

        jLabelServicios.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        jLabelServicios.setForeground(new java.awt.Color(255, 153, 51));
        jLabelServicios.setText("Servicios Extra: ");

        jCheckBoxServBar.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jCheckBoxServBar.setText("Servicio al Bar");

        jCheckBoxServCuarto.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jCheckBoxServCuarto.setText("Servicio al Cuarto");
        jCheckBoxServCuarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxServCuartoActionPerformed(evt);
            }
        });

        jCheckBoxServTintoreria.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jCheckBoxServTintoreria.setText("Servicio de Tintorería");

        jCheckBoxServSPA.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jCheckBoxServSPA.setText("Servicio de SPA");

        jCheckBoxServNiñera.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jCheckBoxServNiñera.setText("Servicio de Niñera");

        jCheckBoxServAntro.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jCheckBoxServAntro.setText("Servicio de Antro");

        jCheckBoxServCarro.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jCheckBoxServCarro.setText("Servicio Renta de Carro");

        jButtonRegistrar.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 12)); // NOI18N
        jButtonRegistrar.setText("Registar");
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 51));
        jLabel1.setText("Fecha de Salida:");

        buttonGroupPersonExtras.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jRadioButton1.setText("Ninguno Extra");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSpinnerTotalHabi, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextFieldPersonasExtr, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jRadioButtonPersonaExtr2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jRadioButtonPersonaExtr1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(jButtonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jTextFieldFechaIngr, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldMostrarFechaIng, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(51, 51, 51)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxServTintoreria)
                            .addComponent(jCheckBoxServCuarto)
                            .addComponent(jCheckBoxServBar)
                            .addComponent(jCheckBoxServSPA)
                            .addComponent(jCheckBoxServNiñera)
                            .addComponent(jCheckBoxServAntro)
                            .addComponent(jCheckBoxServCarro)
                            .addComponent(jLabelServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelCdOrigen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelNomHuesped))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldNomHuesped)
                            .addComponent(jTextFieldCdOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(88, 88, 88)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooserSal, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(217, 217, 217)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelNomHuesped, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldNomHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCdOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCdOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooserSal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBoxServCuarto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinnerTotalHabi, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBoxServBar)
                        .addGap(5, 5, 5)
                        .addComponent(jCheckBoxServTintoreria))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jRadioButtonPersonaExtr1)
                                    .addComponent(jRadioButton1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonPersonaExtr2))
                            .addComponent(jTextFieldPersonasExtr, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBoxServSPA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxServNiñera))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldFechaIngr, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldMostrarFechaIng, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxServAntro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxServCarro))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSpinnerTotalHabi.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldPersonasExtrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPersonasExtrActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextFieldPersonasExtrActionPerformed

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
        // TODO add your handling code here:
        this.llenarObj();//vamos a llenar los datos para andarlo al objeto de clientes
    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void jCheckBoxServCuartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxServCuartoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxServCuartoActionPerformed

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
            java.util.logging.Logger.getLogger(RegClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupPersonExtras;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JCheckBox jCheckBoxServAntro;
    private javax.swing.JCheckBox jCheckBoxServBar;
    private javax.swing.JCheckBox jCheckBoxServCarro;
    private javax.swing.JCheckBox jCheckBoxServCuarto;
    private javax.swing.JCheckBox jCheckBoxServNiñera;
    private javax.swing.JCheckBox jCheckBoxServSPA;
    private javax.swing.JCheckBox jCheckBoxServTintoreria;
    private com.toedter.calendar.JDateChooser jDateChooserSal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelCdOrigen;
    private javax.swing.JLabel jLabelCheckIn;
    private javax.swing.JLabel jLabelNomHuesped;
    private javax.swing.JLabel jLabelServicios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButtonPersonaExtr1;
    private javax.swing.JRadioButton jRadioButtonPersonaExtr2;
    private javax.swing.JSpinner jSpinnerTotalHabi;
    private javax.swing.JTextField jTextFieldCdOrigen;
    private javax.swing.JTextField jTextFieldFechaIngr;
    private javax.swing.JTextField jTextFieldMostrarFechaIng;
    private javax.swing.JTextField jTextFieldNomHuesped;
    private javax.swing.JTextField jTextFieldPersonasExtr;
    // End of variables declaration//GEN-END:variables
}

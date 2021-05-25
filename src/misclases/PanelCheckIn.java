
package misclases;

import com.toedter.calendar.JDateChooser;
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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class PanelCheckIn extends JPanel{
    private ButtonGroup buttonGroupPersonExtras;
    private JButton jButtonRegistrar;
    private JCheckBox jCheckBoxServAntro,jCheckBoxServBar,jCheckBoxServCarro,
        jCheckBoxServCuarto,jCheckBoxServNiñera,jCheckBoxServSPA,jCheckBoxServTintoreria;
    private JDateChooser jDateChooserSal;
    private JLabel jLabelFechaSal,jLabelCheck,jLabelCdOrigen,jLabelCheckIn,jLabelTotalOcu,
        jLabelNomHuesped,jLabelServicios,jLabelFechaIng,jLabelPersonasExtr,jPanel1;
    private JRadioButton jRadioButtonNinguno,jRadioButtonPersonaExtr1, jRadioButtonPersonaExtr2;
    private JSpinner jSpinnerTotalHabi;
    private JTextField jTextFieldCdOrigen,jTextFieldFechaIngr,jTextFieldNomHuesped;
    private ActionListener act;
    
    private Calendar Ingre,salida;
    private String fechaIn,nom,fecIng,cd,fecSal;
    private Vector<String> service=new Vector();
    private int totOcu;
    private Date fechas;
    private SimpleDateFormat f;
    
    private Font fuente,fuente1,fuente2,fuente3,sizeFont,sizeFont_1,sizeFont_2,sizeFont_3,fontt,fontt1,fontt2;
    private File font = null,font1=null,font2=null,font3;
    private BufferedImage playa,escudo,spa,bar;
    
    public PanelCheckIn() {
        this.setBackground(Color.cyan);
        initComponents();
        
    }
    
    public PanelCheckIn(ActionListener evt){
        act=evt;
        this.setBackground(Color.cyan);
        initComponents();
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
        
        if(1==1){
            
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
        Cliente cliente=new Cliente(nom,cd,fechaIn, fecSal, service,Ingre,totOcu);
        /*System.out.println("Clienete...");
        System.out.println("Nombre: "+cliente.getNomHuesped());
        System.out.println("Ciudad Origen: "+cliente.getCdOrigen());
        System.out.println("Fecha Ingreso: "+cliente.getFechaIng());
        System.out.println("Fecha Salida: "+cliente.getFechaSal());
        System.out.println("Total Ocupantes: "+cliente.getTotOcupantes());
        System.out.println("Fecha Servicios: "+cliente.getServExtr());*/
        
    }
    
    private void jButtonRegistrarActionPerformed(ActionEvent evt) {                                                 
        // TODO add your handling code here:
        this.llenarObj();//vamos a llenar los datos para andarlo al objeto de clientes
    } 

    private void initComponents() {
        Ingre=Calendar.getInstance();
        if((Ingre.get(Calendar.MONTH)+1)<10){
            fechaIn=Ingre.get(Calendar.DAY_OF_MONTH)+"/0"+(Ingre.get(Calendar.MONTH)+1)+"/"+Ingre.get(Calendar.YEAR);
        }else{
            fechaIn=Ingre.get(Calendar.DAY_OF_MONTH)+"/"+(Ingre.get(Calendar.MONTH)+1)+"/"+Ingre.get(Calendar.YEAR);
            
        }
        
        try{
            playa=ImageIO.read(new File("src/imagenes/playa2.jpg"));
            escudo=ImageIO.read(new File("src/imagenes/hotel.jpg"));
            spa=ImageIO.read(new File("src/imagenes/spa.jpg"));
            bar=ImageIO.read(new File("src/imagenes/bar.jpeg"));
            font=new File("src/fonts/PublicSecret.otf");
            fuente=Font.createFont(Font.TRUETYPE_FONT, font);
            sizeFont=fuente.deriveFont(34f);
            
            font1=new File("src/fonts/Tabarra.otf");
            fuente1=Font.createFont(Font.TRUETYPE_FONT, font1);
            sizeFont_1=fuente1.deriveFont(14f);
            
            jLabelCheckIn = new JLabel("CHECK IN");
            jLabelCheckIn.setFont(sizeFont);
            jLabelCheckIn.setForeground(Color.RED);
            jLabelCheckIn.setBorder(new  BevelBorder(BevelBorder.LOWERED));
            
            font2=new File("src/fonts/LittlePanda.otf");
            fuente2=Font.createFont(Font.TRUETYPE_FONT, font2);
            sizeFont_2=fuente2.deriveFont(19f);
            
            fontt=new Font("Leelawadee UI", 1, 16);
            jLabelNomHuesped = new JLabel("Nombre del Huesped: ");
            jLabelNomHuesped.setFont(fontt);
            jLabelNomHuesped.setForeground(new Color(102,255,102));
            
            jLabelCdOrigen = new JLabel("Ciudad de Origen: ");
            jLabelCdOrigen.setFont(fontt);
            jLabelCdOrigen.setForeground(new Color(102,255,102));
            
            jLabelServicios = new JLabel("Servicios Extra: ");
            jLabelServicios.setFont(fontt);
            
            
            jLabelFechaIng = new JLabel("Fecha de Ingreso: ");
            jLabelFechaIng.setFont(fontt);
            jLabelFechaIng.setForeground(new Color(52,255,0));
            
            jLabelPersonasExtr = new JLabel("Persona(s) Extra(s): ");
            jLabelPersonasExtr.setFont(fontt);
            jLabelPersonasExtr.setForeground(new Color(52,255,0));
            
            
            jLabelFechaSal = new JLabel("Fecha de Salida: ");
            jLabelFechaSal.setFont(fontt);
            jLabelFechaSal.setForeground(new Color(240,240,240));
            
            jLabelTotalOcu = new JLabel("Total de Ocupantes de la Habitcion: ");
            jLabelTotalOcu.setFont(fontt);
            jLabelTotalOcu.setForeground(new Color(102,255,102));
            
            ImageIcon iconoCheck= new ImageIcon("src/imagenes/registrar.png");
            jButtonRegistrar = new JButton("Registrar",iconoCheck);
            jButtonRegistrar.setForeground(Color.RED);
            jButtonRegistrar.setFont(sizeFont_1);
            jButtonRegistrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jButtonRegistrar.setHorizontalTextPosition(SwingConstants.LEFT);
            jButtonRegistrar.setVerticalAlignment(SwingConstants.BOTTOM);
            
            jButtonRegistrar.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    jButtonRegistrarActionPerformed(ae);
                }
                
            });
            jButtonRegistrar.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt){
                    jButtonRegistrar.setBackground(Color.yellow);

                }
                public void mouseExited(MouseEvent evt){
                    jButtonRegistrar.setBackground(Color.LIGHT_GRAY);
                }
        });
            
            jSpinnerTotalHabi = new JSpinner();
            jDateChooserSal = new JDateChooser();
            jDateChooserSal.setName("JDateChooserSal");
            
            buttonGroupPersonExtras = new ButtonGroup();
            
            fontt1=new Font("Consolas", 1, 15);
            jRadioButtonPersonaExtr1 = new JRadioButton();
            jRadioButtonPersonaExtr1.setFont(fontt1);
            jRadioButtonPersonaExtr1.setText("1 Persona Extra");
            jRadioButtonPersonaExtr1.setBackground(Color.yellow);
            jRadioButtonPersonaExtr1.setForeground(new Color(0,255,255));
            buttonGroupPersonExtras.add(jRadioButtonPersonaExtr1);
            
            jRadioButtonPersonaExtr2 =  new JRadioButton();
            jRadioButtonPersonaExtr2.setFont(fontt1);
            jRadioButtonPersonaExtr2.setText("2 Personas Extra");
            jRadioButtonPersonaExtr2.setBackground(Color.yellow);
            jRadioButtonPersonaExtr2.setForeground(new Color(0,255,255));
            buttonGroupPersonExtras.add(jRadioButtonPersonaExtr2);
            
            jRadioButtonNinguno = new JRadioButton();
            jRadioButtonNinguno.setFont(fontt1);
            jRadioButtonNinguno.setText("Ninguno Extra");
            jRadioButtonNinguno.setBackground(Color.yellow);
            jRadioButtonNinguno.setForeground(new Color(0,255,255));
            buttonGroupPersonExtras.add(jRadioButtonNinguno);
            
            fontt2 = new Font("Arial Black", 1, 15);
            
            jTextFieldNomHuesped = new JTextField("");
            jTextFieldNomHuesped.setFont(sizeFont_2);
            jTextFieldCdOrigen = new JTextField("");
            jTextFieldCdOrigen.setFont(sizeFont_2);
            jTextFieldFechaIngr = new JTextField();
            jTextFieldFechaIngr.setText(fechaIn);
            jTextFieldFechaIngr.setFont(sizeFont_2);
            jTextFieldFechaIngr.setEditable(false);
            
            font3=new File("src/fonts/Salacia.otf");
            fuente3=Font.createFont(Font.TRUETYPE_FONT, font3);
            sizeFont_3=fuente3.deriveFont(22.5f);
            
            jCheckBoxServCuarto = new JCheckBox();
            jCheckBoxServCuarto.setFont(sizeFont_3);
            jCheckBoxServCuarto.setText("Servico al Cuarto");
            
            jCheckBoxServAntro = new JCheckBox();
            jCheckBoxServAntro.setFont(sizeFont_3);
            jCheckBoxServAntro.setText("Servico de Antro");
                    
            jCheckBoxServBar = new JCheckBox();
            jCheckBoxServBar.setFont(sizeFont_3);
            jCheckBoxServBar.setText("Servicio de Bar");
            
            jCheckBoxServNiñera = new JCheckBox();
            jCheckBoxServNiñera.setFont(sizeFont_3);
            jCheckBoxServNiñera.setText("Servicio de Niniera");
            
            jCheckBoxServSPA = new JCheckBox();
            jCheckBoxServSPA.setFont(sizeFont_3);
            jCheckBoxServSPA.setText("Servicio de SPA");
            
            jCheckBoxServTintoreria = new JCheckBox();
            jCheckBoxServTintoreria.setFont(sizeFont_3);
            jCheckBoxServTintoreria.setText("Servicio de Tintoreria");
            
            jCheckBoxServCarro = new JCheckBox();
            jCheckBoxServCarro.setFont(sizeFont_3);
            jCheckBoxServCarro.setText("Servicio Renta de Carro");
                        
        }catch (FontFormatException ex) {
           
        }catch (IOException ex) {
           
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error al cargar archivos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        this.add(this.jLabelCheckIn);
        this.add(this.jLabelNomHuesped);
        this.add(this.jLabelCdOrigen);
        this.add(this.jLabelServicios);
        this.add(this.jLabelFechaIng);
        this.add(this.jLabelPersonasExtr);
        this.add(this.jLabelServicios);
        this.add(this.jLabelFechaSal);
        this.add(this.jLabelTotalOcu);
        this.add(this.jDateChooserSal);
        this.add(this.jSpinnerTotalHabi);
        this.add(this.jRadioButtonPersonaExtr1);
        this.add(this.jRadioButtonPersonaExtr2);
        this.add(this.jRadioButtonNinguno);
        this.add(this.jTextFieldNomHuesped);
        this.add(this.jTextFieldCdOrigen);
        this.add(this.jTextFieldFechaIngr);
        this.add(this.jCheckBoxServCuarto);
        this.add(this.jCheckBoxServAntro);
        this.add(this.jCheckBoxServBar);
        this.add(this.jCheckBoxServNiñera);
        this.add(this.jCheckBoxServSPA);
        this.add(this.jCheckBoxServTintoreria);
        this.add(this.jCheckBoxServCarro);
        this.add(this.jButtonRegistrar);
        
        jSpinnerTotalHabi.getAccessibleContext().setAccessibleName("");
    }
    
    @Override
    public void paint(Graphics g){
        Dimension dimensiones=getSize();
        g.drawImage(escudo,0, 0,(dimensiones.width/2),(dimensiones.height/2), null);
        g.drawImage(playa,(dimensiones.width/2),(dimensiones.height/2),(dimensiones.width/2),(dimensiones.height/2), null);
        g.drawImage(spa,0,(dimensiones.height/2),(dimensiones.width/2),(dimensiones.height/2), null);
        g.drawImage(bar,(dimensiones.width/2),0,(dimensiones.width/2),(dimensiones.height/2), null);
        //JButton
        this.jButtonRegistrar.setBounds((dimensiones.width/2)-360, (dimensiones.height/2)+235, 150, 50);
        //JRadioButton
        
        //JRadioGroup
        this.jRadioButtonPersonaExtr1.setBounds((dimensiones.width/2)-250, (dimensiones.height/2)+105,155, 30);
        this.jRadioButtonPersonaExtr2.setBounds((dimensiones.width/2)-250, (dimensiones.height/2)+125,155, 30);
        this.jRadioButtonNinguno.setBounds((dimensiones.width/2)-250, (dimensiones.height/2)+145,155, 30);
        //JLabel
        this.jLabelCheckIn.setBounds((dimensiones.width/2)-70, (dimensiones.height/2)-295, 140, 50);
        this.jLabelNomHuesped.setBounds((dimensiones.width/2)-410, (dimensiones.height/2)-190, 185, 30);
        this.jLabelCdOrigen.setBounds((dimensiones.width/2)-410, (dimensiones.height/2)-150, 185, 30);
        this.jLabelTotalOcu.setBounds((dimensiones.width/2)-410, (dimensiones.height/2)-50, 280, 30);
        this.jLabelPersonasExtr.setBounds((dimensiones.width/2)-410, (dimensiones.height/2)+85,150, 30);
        this.jLabelFechaIng.setBounds((dimensiones.width/2)-410, (dimensiones.height/2)+170, 160, 30);
        this.jLabelFechaSal.setBounds((dimensiones.width/2)+10, (dimensiones.height/2)-115, 160, 30);
        this.jLabelServicios.setBounds((dimensiones.width/2)+115, (dimensiones.height/2), 130, 30);
        //JSpinner
        this.jSpinnerTotalHabi.setBounds((dimensiones.width/2)-100, (dimensiones.height/2)-50, 70, 50);
        //JTextField
        jTextFieldNomHuesped.setBounds((dimensiones.width/2)-225, (dimensiones.height/2)-190, 250, 35);
        jTextFieldCdOrigen.setBounds((dimensiones.width/2)-225, (dimensiones.height/2)-150, 250, 35);
        jTextFieldFechaIngr.setBounds((dimensiones.width/2)-275, (dimensiones.height/2)+170, 175, 35);
        //JDateChooser
        jDateChooserSal.setBounds((dimensiones.width/2)+165, (dimensiones.height/2)-115, 109, 30);
        //JCheckBox
        this.jCheckBoxServCuarto.setBounds((dimensiones.width/2)+10, (dimensiones.height/2)+30, 200, 30);
        this.jCheckBoxServBar.setBounds((dimensiones.width/2)+10, (dimensiones.height/2)+60, 200, 30);
        this.jCheckBoxServSPA.setBounds((dimensiones.width/2)+10, (dimensiones.height/2)+90, 200, 30);
        this.jCheckBoxServNiñera.setBounds((dimensiones.width/2)+10, (dimensiones.height/2)+120, 200, 30);
        this.jCheckBoxServTintoreria.setBounds((dimensiones.width/2)+10, (dimensiones.height/2)+150, 250, 30);
        this.jCheckBoxServAntro.setBounds((dimensiones.width/2)+10, (dimensiones.height/2)+180, 200, 30);
        this.jCheckBoxServCarro.setBounds((dimensiones.width/2)+10, (dimensiones.height/2)+210, 250, 30);
        
        this.setOpaque(false);
        super.paint(g);
    }
    
}

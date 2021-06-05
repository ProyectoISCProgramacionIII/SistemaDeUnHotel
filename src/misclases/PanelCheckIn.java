
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
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import static misclases.Hotel.habitaciones;
import misframes.EstadoHabitaciones;

public class PanelCheckIn extends JPanel{
    private MySqlConn conn = new MySqlConn();
    private ButtonGroup buttonGroupPersonExtras;
    private JButton jButtonRegistrar,jButtonRegresar;
    private JCheckBox jCheckBoxServAntro,jCheckBoxServBar,jCheckBoxServCarro,
        jCheckBoxServCuarto,jCheckBoxServNiñera,jCheckBoxServSPA,jCheckBoxServTintoreria;
    private JDateChooser jDateChooserSal,jDateChooserEntrada;
    private JLabel jLabelFechaSal,jLabelCheck,jLabelCdOrigen,jLabelCheckIn,jLabelTotalOcu,
        jLabelNomHuesped,jLabelServicios,jLabelFechaIng,jLabelPersonasExtr,jLabelUbicacion,jPanel1;
    private JRadioButton jRadioButtonNinguno,jRadioButtonPersonaExtr1, jRadioButtonPersonaExtr2;
    private JSpinner jSpinnerTotalHabi;
    private JTextField jTextFieldCdOrigen,jTextFieldFechaIngr,jTextFieldNomHuesped;
    private ActionListener act;
    
    private Calendar Ingre,salida,entrada;
    private String fechaIn,nom,fecIng,cd,fechaSalida,fechaEntrada;
    private Vector<String> service=new Vector();
    private int totOcu;
    private Date fechasSal,fechasEntr;
    private SimpleDateFormat f,f2;
    
    private Font fuente,fuente1,fuente2,fuente3,sizeFont,sizeFont_1,sizeFont_2,sizeFont_3,fontt,fontt1,fontt2,fontt3;
    private File font = null,font1=null,font2=null,font3;
    private BufferedImage playa,escudo,spa,bar;
    
    private int tipo,pos;
    
    public PanelCheckIn(int ti, int po) {
        tipo=ti;
        pos=po;
        //System.out.println("tipo "+tipo+"  posicion: "+pos);
        this.setBackground(Color.cyan);
        initComponents();
        
    }
    
    public PanelCheckIn(ActionListener evt,int ti, int po){
        tipo=ti;
        pos=po;
        act=evt;
        System.out.println("tipo "+tipo+"  posicion: "+pos);
        this.setBackground(Color.cyan);
        initComponents();
    }
    
    private void llenarObj(){
        
        int totHab=(int)this.jSpinnerTotalHabi.getValue();
        //se debe validar que los campos importantes deben de ser llenados
        if(jTextFieldNomHuesped.getText().isEmpty() && jTextFieldCdOrigen.getText().isEmpty() && totHab>0){
            JOptionPane.showMessageDialog(this,"Campos Obligatorios NO llenados \nLlene TODOS los campos...","Check In Incorrecto", WARNING_MESSAGE);
            return;
        }else{
            nom=this.jTextFieldNomHuesped.getText();
            fecIng=this.fechaIn;
            cd=this.jTextFieldCdOrigen.getText();
        }
        if(this.jDateChooserEntrada.getDate()==null || this.jDateChooserSal.getDate()==null){
            JOptionPane.showMessageDialog(this,"Campos Obligatorios NO llenados \nLlene TODOS los campos...","Check In Incorrecto", WARNING_MESSAGE);
            return;
        }
        f2=new SimpleDateFormat("yyyy/MM/dd");
        //fechaIn=f2.format(Ingreso);
        fechasSal=this.jDateChooserSal.getDate();
        fechasEntr=this.jDateChooserEntrada.getDate();
        f=new SimpleDateFormat("dd/MM/yyyy");
        fechaEntrada=f.format(this.jDateChooserEntrada.getDate());
        fechaSalida=f2.format(this.jDateChooserSal.getDate());
        
        try{
            fechasEntr=f.parse(fechaEntrada);
            fechasSal=f2.parse(fechaSalida);
            if(fechasEntr.compareTo(fechasSal) < 0){
                //correcta la fecha
            }else{
                JOptionPane.showMessageDialog(this,"La fecha es Erronea la salida es menor a la de entrada...","Check In Incorrecto", WARNING_MESSAGE);
                return;
            }
        }catch(Exception e){
            System.out.println("Error -> "+e.getMessage());
        }
        
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
        
        if(tipo==1){
            
            if(((int)this.jSpinnerTotalHabi.getValue())<=1 && ((int)this.jSpinnerTotalHabi.getValue())>0){
                if(((int)this.jSpinnerTotalHabi.getValue())<=1){
                    if(!this.jRadioButtonPersonaExtr1.isSelected() && !this.jRadioButtonPersonaExtr2.isSelected()){
                        totOcu=((int)this.jSpinnerTotalHabi.getValue());
                    }else{
                        JOptionPane.showMessageDialog(this,"Campo de total de Ocupantes \nNO marco los Extra Bien","Check In Incorrecto", WARNING_MESSAGE);
                        return;
                    }
                    
                }else{
                    if((((int)this.jSpinnerTotalHabi.getValue())-1)==1){
                        if(this.jRadioButtonPersonaExtr1.isSelected()){
                            totOcu=((int)this.jSpinnerTotalHabi.getValue());
                        }else{
                            JOptionPane.showMessageDialog(this,"Campo de total de Ocupantes \nNO marco los Extra Bien","Check In Incorrecto", WARNING_MESSAGE);
                            return;
                        }
                    }else if((((int)this.jSpinnerTotalHabi.getValue())-2)==1){
                        if(this.jRadioButtonPersonaExtr2.isSelected()){
                            totOcu=((int)this.jSpinnerTotalHabi.getValue());
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
            
            
        }else if(tipo==2){
            if(((int)this.jSpinnerTotalHabi.getValue())<=2 && ((int)this.jSpinnerTotalHabi.getValue())>0){
                if(((int)this.jSpinnerTotalHabi.getValue())<=2){
                    if(!this.jRadioButtonPersonaExtr1.isSelected() && !this.jRadioButtonPersonaExtr2.isSelected()){
                        totOcu=((int)this.jSpinnerTotalHabi.getValue());
                    }else{
                        JOptionPane.showMessageDialog(this,"Campo de total de Ocupantes \nNO marco los Extra Bien","Check In Incorrecto", WARNING_MESSAGE);
                        return;
                    }
                }else{
                    if((((int)this.jSpinnerTotalHabi.getValue())-1)==2){
                        if(this.jRadioButtonPersonaExtr1.isSelected()){
                            totOcu=((int)this.jSpinnerTotalHabi.getValue());
                        }else{
                            JOptionPane.showMessageDialog(this,"Campo de total de Ocupantes \nNO marco los Extra Bien","Check In Incorrecto", WARNING_MESSAGE);
                            return;
                        }
                    }else if((((int)this.jSpinnerTotalHabi.getValue())-2)==2){
                        if(this.jRadioButtonPersonaExtr2.isSelected()){
                            totOcu=((int)this.jSpinnerTotalHabi.getValue());
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
            
        }else if(tipo==3){
            if(((int)this.jSpinnerTotalHabi.getValue())<=3 && ((int)this.jSpinnerTotalHabi.getValue())>0){
                if(((int)this.jSpinnerTotalHabi.getValue())<=3){
                    if(!this.jRadioButtonPersonaExtr1.isSelected() && !this.jRadioButtonPersonaExtr2.isSelected()){
                        totOcu=((int)this.jSpinnerTotalHabi.getValue());
                    }else{
                        JOptionPane.showMessageDialog(this,"Campo de total de Ocupantes \nNO marco los Extra Bien","Check In Incorrecto", WARNING_MESSAGE);
                        return;
                    }
                }else{
                    if((((int)this.jSpinnerTotalHabi.getValue())-1)==3){
                        if(this.jRadioButtonPersonaExtr1.isSelected()){
                            totOcu=((int)this.jSpinnerTotalHabi.getValue());
                        }else{
                            JOptionPane.showMessageDialog(this,"Campo de total de Ocupantes \nNO marco los Extra Bien","Check In Incorrecto", WARNING_MESSAGE);
                            return;
                        }
                    }else if((((int)this.jSpinnerTotalHabi.getValue())-2)==3){
                        if(this.jRadioButtonPersonaExtr2.isSelected()){
                            totOcu=((int)this.jSpinnerTotalHabi.getValue());
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
        System.out.println("Total ocupantes= "+totOcu);
        jDateChooserSal.setDateFormatString("yyyy/MM/dd");
        jDateChooserEntrada.setDateFormatString("yyyy/MM/dd");
        fechaSalida=((JTextField)(this.jDateChooserSal.getDateEditor().getUiComponent())).getText();
        fechaEntrada=((JTextField)(this.jDateChooserEntrada.getDateEditor().getUiComponent())).getText();
        //Cliente(String nomHuesped, String cdOrigen, String fechaIng, String fechaSal, Vector<String> servExtr, Calendar actual)
        Cliente cliente=new Cliente(nom,cd,fechaEntrada, fechaSalida, service,Ingre,totOcu);
        /*System.out.println("Clienete...");
        System.out.println("Nombre: "+cliente.getNomHuesped());
        System.out.println("Ciudad Origen: "+cliente.getCdOrigen());
        System.out.println("Fecha Ingreso: "+cliente.getFechaIng());
        System.out.println("Fecha Salida: "+cliente.getFechaSal());
        System.out.println("Total Ocupantes: "+cliente.getTotOcupantes());
        System.out.println("Servicios: "+cliente.getServExtr());*/
        insertar(cliente);
    }
    
    private void insertar(Cliente cl){
        int tintoreria=0,carro=0,spa=0,bar=0,antro=0,niniera=0,cuarto=0,estado=1;
        if(this.jCheckBoxServCuarto.isSelected()){
            cuarto=1;
        }
        if(this.jCheckBoxServAntro.isSelected()){
            antro=1; 
        }
        if(this.jCheckBoxServBar.isSelected()){
            bar=1;  
        }
        if(this.jCheckBoxServCarro.isSelected()){
            carro=1;    
        }
        if(this.jCheckBoxServNiñera.isSelected()){
            niniera=1;    
        }
        if(this.jCheckBoxServSPA.isSelected()){
            spa=1;    
        }
        if(this.jCheckBoxServTintoreria.isSelected()){
            tintoreria=1;   
        }
       
        String parte1 = "Insert into habitacion (numero, estado, servcuarto, servbar, servspa, servninera, servtintoreria, servantro, servcarro, tipo, costo, totpersonas, piso, nombre, cdorigen, fechaingreso, fechasalida) VALUES (";
        String parte2="'"+habitaciones.get(pos).getNumero()+"','"+estado+"','"+
                cuarto+"','"+bar+"','"+spa+"','"+niniera+"','"+tintoreria+"','"+antro+"','"+carro+"','"+habitaciones.get(pos).getTipo()+"','"+
                habitaciones.get(pos).getCosto()+"','"+cl.totOcupantes+"','"+habitaciones.get(pos).getPiso()+"','"+cl.getNomHuesped()+
                "','"+cl.getCdOrigen()+"','"+cl.getFechaIng()+"','"+cl.getFechaSal()+"')";
        String query=parte1+parte2;
        int j=this.conn.Update(query);//Ejecuta accion de registro en la BD hotel en la tabla habitacion
        System.out.println("Numero de registros afectados por la accion: "+j);
    }
    
    private void jButtonRegistrarActionPerformed(ActionEvent evt) {                                                 
        // TODO add your handling code here:
        this.llenarObj();//vamos a llenar los datos para andarlo al objeto de clientes
    } 

    private void initComponents() {
        
        /*Ingre=Calendar.getInstance();
        if((Ingre.get(Calendar.MONTH)+1)<10){
            fechaIn=Ingre.get(Calendar.DAY_OF_MONTH)+"/0"+(Ingre.get(Calendar.MONTH)+1)+"/"+Ingre.get(Calendar.YEAR);
        }else{
            fechaIn=Ingre.get(Calendar.DAY_OF_MONTH)+"/"+(Ingre.get(Calendar.MONTH)+1)+"/"+Ingre.get(Calendar.YEAR);
            
        }
        Ingreso=Ingre.getTime();
        //System.out.println(Ingreso);
        */
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
            
            fontt3=Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/KGHolocene.ttf"));
            fontt3=fontt3.deriveFont(14f);
            jLabelUbicacion=new JLabel("Av Tlahuac #1784, Colonia Churubusco, Delegación Coyoacan, CDMX");
            jLabelUbicacion.setFont(fontt3);
            jLabelUbicacion.setBackground(new Color(102,255,255));
            jLabelUbicacion.setOpaque(true);
            
            ImageIcon iconoReg= new ImageIcon("src/imagenes/Regresa.png");
            this.jButtonRegresar=new JButton("Regresar",iconoReg);
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
                public void mouseReleased(MouseEvent evt){
                    cerrarVentana();
                    new EstadoHabitaciones().setVisible(true);
                }

            });
            
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
            
            fontt2 = new Font("Consolas", 1, 14);
            
            jDateChooserEntrada = new JDateChooser();
            jDateChooserEntrada.setName("JDateChooserEntrada");
            jDateChooserEntrada.setFont(fontt2);
            jDateChooserSal = new JDateChooser();
            jDateChooserSal.setName("JDateChooserSal");
            jDateChooserSal.setFont(fontt2);
            
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
        this.add(this.jDateChooserEntrada);
        this.add(this.jSpinnerTotalHabi);
        this.add(this.jRadioButtonPersonaExtr1);
        this.add(this.jRadioButtonPersonaExtr2);
        this.add(this.jRadioButtonNinguno);
        this.add(this.jTextFieldNomHuesped);
        this.add(this.jTextFieldCdOrigen);
        this.add(this.jLabelUbicacion);
        this.add(this.jCheckBoxServCuarto);
        this.add(this.jCheckBoxServAntro);
        this.add(this.jCheckBoxServBar);
        this.add(this.jCheckBoxServNiñera);
        this.add(this.jCheckBoxServSPA);
        this.add(this.jCheckBoxServTintoreria);
        this.add(this.jCheckBoxServCarro);
        this.add(this.jButtonRegistrar);
        this.add(this.jButtonRegresar);
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
        this.jButtonRegresar.setBounds((dimensiones.width/2)+285, (dimensiones.height/2)-290, 130, 50);
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
        this.jLabelUbicacion.setBounds((dimensiones.width/2)-180, (dimensiones.height/2)+250, 580, 25);
        //JSpinner
        this.jSpinnerTotalHabi.setBounds((dimensiones.width/2)-100, (dimensiones.height/2)-50, 70, 50);
        //JTextField
        jTextFieldNomHuesped.setBounds((dimensiones.width/2)-225, (dimensiones.height/2)-190, 250, 35);
        jTextFieldCdOrigen.setBounds((dimensiones.width/2)-225, (dimensiones.height/2)-150, 250, 35);
        //JDateChooser
        jDateChooserEntrada.setBounds((dimensiones.width/2)-275, (dimensiones.height/2)+170, 120, 30);
        jDateChooserSal.setBounds((dimensiones.width/2)+165, (dimensiones.height/2)-115, 120, 30);
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
    private void cerrarVentana(){
        SwingUtilities.getWindowAncestor(this).dispose();
        
    }
    
    private void cerrar(){
        SwingUtilities.getWindowAncestor(this).dispose();
         new EstadoHabitaciones().setVisible(true);
    }
    
}

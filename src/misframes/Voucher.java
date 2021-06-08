/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misframes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import misclases.Cliente;
import static misclases.Hotel.habitaciones;

/**
 *
 * @author Hp
 */
public class Voucher extends javax.swing.JFrame {

    /**
     * Creates new form Voucher
     */
    private JTextArea jTextAreaVoucher;
    private JPanel jPanelBase, jPanelImagen;
    private BufferedImage logo;
    private Font font;
    private Cliente cliente=new Cliente();
    private int tipo,pos;
    
    public Voucher(Cliente cliente, int ti, int posi) {
        this.cliente = cliente;
        this.tipo=ti;
        this.pos=posi;
        initComponents();
        
        this.setTitle("Voucher Del Cliente");
        this.setMinimumSize(new Dimension(700,700));
        iniciarPaneles();
        iniciarComponentes();
        this.getContentPane().add(this.jPanelBase, BorderLayout.CENTER);
        this.setLocationRelativeTo(null);
        this.setSize(700, 700);
    }
    
    public Voucher() {
        initComponents();
        
        this.setTitle("Voucher Del Cliente");
        this.setMinimumSize(new Dimension(700,700));
        iniciarPaneles();
        iniciarComponentes();
        this.getContentPane().add(this.jPanelBase, BorderLayout.CENTER);
        this.setLocationRelativeTo(null);
        this.setSize(700, 700);
        
    }
    
    private void iniciarPaneles(){
        jPanelBase=new JPanel(){
            @Override
                public void paint(Graphics g){
                    Dimension dimensiones=getSize();
                    

                    g.drawString("VOUCHER", dimensiones.width/2-50,10);
                    
                    super.paint(g);
                }
        };
        jPanelBase.setOpaque(true);
        this.jPanelBase.setBackground(new Color(255,255,102));
        Dimension dim=this.jPanelBase.getSize();
        jPanelImagen=new JPanel(){
            @Override
                public void paint(Graphics g){
                    Dimension dimensiones=getSize();
                    try {
                        logo=ImageIO.read(new File("src/imagenes/hotel.jpg"));
                    } catch (IOException ex) {
                        Logger.getLogger(Voucher.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    g.drawImage(logo,0, 0,dimensiones.width,dimensiones.height, null);
                    
                    super.paint(g);
                }
        };
        font=new Font("Consolas", 1, 15);
        this.jPanelImagen.setPreferredSize(new Dimension(300,200));
        this.jPanelImagen.setOpaque(false);
        this.jPanelImagen.setBounds((dim.width/2)+150, (dim.height/2)-145, 300, 200);
        this.jTextAreaVoucher=new JTextArea();
        this.jTextAreaVoucher.setEditable(false);
        this.jTextAreaVoucher.setPreferredSize(new Dimension(600,420));
        this.jTextAreaVoucher.setBounds((dim.width/2)-345,(dim.height)-150, 600, 600);
        this.jTextAreaVoucher.setFont(font);
        this.jTextAreaVoucher.setBackground(new Color(255,255,153));
        this.jTextAreaVoucher.setForeground(new Color(0,0,153));
        llenarVoucher();
    }
    
    private void llenarVoucher(){
        String hotel="\t\t\t HOTEL WOLFSBURG\n";
        String lema="\t\tEl Arte De Cumplir Tu Más Altas Expectativas\n";
        String ubicacion="     Av Tlahuac #1784, Colonia Churubusco, Delegación Coyoacan, CDMX\n\n\n";
        String nombre="Nombre del huesped: "+cliente.getNomHuesped()+"\n\n";
        String cdOrigen="Ciudad de Origen: "+cliente.getCdOrigen()+"\n\n";
        String fechaIn="Fecha de Ingreso: "+cliente.getFechaIng()+"\n\n";
        String fechaSal="Fechas de Salida: "+cliente.getFechaSal()+"\n\n";
        String numeroHab="Número de Habitación: "+habitaciones.get(pos).getNumero();
        String piso="   Piso: "+habitaciones.get(pos).getPiso()+"\n\n";
        String tipo=" Tipo de Habitación: Tipo "+habitaciones.get(pos).getTipo();
        int lim=0,extra=0;
        if(habitaciones.get(pos).getTipo()==1){
            lim=3;
        }else if(habitaciones.get(pos).getTipo()==2){
            lim=4;
        }else if(habitaciones.get(pos).getTipo()==3){
            lim=5;
        }
        tipo+="  ( Limite "+lim+" huésped(es) )\n\n";
        String totOcupantes="Total de ocupantes de la habitación: "+cliente.getTotOcupantes();
        String extraPer="  Tiene "+cliente.getPersonasExtr()+" Personas Extra";
        
        String regCompleto="\n\nRegistro Completo";
        String info=hotel+lema+ubicacion+nombre+cdOrigen+fechaIn+fechaSal+
                numeroHab+piso+tipo+totOcupantes+extraPer+regCompleto;
        this.jTextAreaVoucher.setText(info);
    }
    
    private void iniciarComponentes(){
        Dimension dim=this.getSize();
        this.jPanelBase.add(this.jPanelImagen);
        this.jPanelBase.add(this.jTextAreaVoucher);
        
        
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
            java.util.logging.Logger.getLogger(Voucher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Voucher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Voucher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Voucher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Voucher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}

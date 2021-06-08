/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misframes;


import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import misclases.MySqlConn;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */

class Informacion implements Comparable{
    private String nombre;
    private int numero;

    public Informacion() {
    }

    public Informacion(String nombre, int numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Informacion{" + "nombre=" + nombre + ", numero=" + numero + '}';
    }

    @Override
    public int compareTo(Object t) {
        Informacion in=(Informacion)t;
        return this.getNombre().compareTo(in.getNombre());
    
    
    
    }
    
    
    
    
}
public class Consulta10ListaPersonas extends javax.swing.JFrame {
    private DefaultTableModel modelo=null;
    private MySqlConn conn;
    private ArrayList <Informacion>lista;
   
    /**
     * Creates new form Consulta10ListaPersonas
     */
    
    public Consulta10ListaPersonas() {
        this.conn=new MySqlConn();
        initComponents();
        iniciaArbol();
        iniciaTabla();
        this.setSize(1020, 640);
          this.setMinimumSize(new Dimension(1020,640));
        this.setLocationRelativeTo(null);
        
    }

    private void iniciaArbol(){
        this.lista=new ArrayList();
        String query="select * from habitacion";
        int n;
        
        try{
            this.conn.Consult(query);
            this.conn.rs.last();
            n=this.conn.rs.getRow(); 
            this.conn.rs.first();
          if(n>0){
            for (int i = 0; i < n; i++) {
                
                this.lista.add(new Informacion(this.conn.rs.getString(14),this.conn.rs.getInt(1)));
                
                this.conn.rs.next();
              
            }
            
          }else{
              JOptionPane.showMessageDialog(this, "No existen datos que mostrar");
          }
        }catch(Exception ex){
                    
             //       System.err.println("error");
                    
         }
        
        
    }
    private void iniciaTabla(){
        
        
     
        
            Collections.sort(lista);
            Object obj[][]=new Object [this.lista.size()][2];
            
            
            for (int i = 0; i < this.lista.size(); i++) {
                obj[i][0]=this.lista.get(i).getNumero();
                obj[i][1]=this.lista.get(i).getNombre();
                
            }
            
            String columnas[]={"Numero de habitación","Nombres"};
            this.jTableInformacion.setModel(new DefaultTableModel(obj,columnas));
            
        
        
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableInformacion = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabelTitulo.setBackground(new java.awt.Color(255, 255, 153));
        jLabelTitulo.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/hotelversioncircular.png"))); // NOI18N
        jLabelTitulo.setText("LISTA DE PERSONAS HOSPEDADAS EN EL HOTEL");
        jLabelTitulo.setAlignmentX(0.5F);
        jLabelTitulo.setOpaque(true);
        jPanel1.add(jLabelTitulo, java.awt.BorderLayout.PAGE_START);

        jTableInformacion.setBackground(new java.awt.Color(153, 255, 204));
        jTableInformacion.setForeground(new java.awt.Color(0, 0, 0));
        jTableInformacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Nombre", "Habitación"
            }
        ));
        jScrollPane1.setViewportView(jTableInformacion);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jButton1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Regresa.png"))); // NOI18N
        jButton1.setText("Regresar");
        jButton1.setAlignmentX(0.5F);
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });
        jPanel2.add(jButton1);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
        this.jButton1.setBackground(Color.GREEN);
        
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        // TODO add your handling code here:
        this.jButton1.setBackground(Color.LIGHT_GRAY);
        
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
        // TODO add your handling code here:
        dispose();
        new MenuConsultas().setVisible(true);
        
    }//GEN-LAST:event_jButton1MouseReleased

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
            java.util.logging.Logger.getLogger(Consulta10ListaPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consulta10ListaPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consulta10ListaPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consulta10ListaPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consulta10ListaPersonas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableInformacion;
    // End of variables declaration//GEN-END:variables
}
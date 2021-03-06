/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misframes;

import java.awt.Color;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import misclases.Hotel;
import misclases.MySqlConn;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Consulta9 extends javax.swing.JFrame {
    private MySqlConn conn;
    /**
     * Creates new form Consulta9
     */
    public Consulta9() {
        this.conn=new MySqlConn();
        initComponents();
        
        this.setTitle("Consultas...Habitaciones disponibles por piso");
        this.setSize(1020, 640);
        this.setMinimumSize(new Dimension(1020,640));
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFondo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabelIngresa = new javax.swing.JLabel();
        jComboBoxIngresa = new javax.swing.JComboBox();
        jButtonAceptar = new javax.swing.JButton();
        jPanelAbajo = new javax.swing.JPanel();
        jButtonRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelFondo.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabelTitulo.setBackground(new java.awt.Color(153, 153, 255));
        jLabelTitulo.setFont(new java.awt.Font("Elephant", 1, 18)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("HABITACIONES DISPONIBLES POR PISO");
        jLabelTitulo.setOpaque(true);
        jPanel1.add(jLabelTitulo, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(153, 255, 204));

        jLabelIngresa.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabelIngresa.setForeground(new java.awt.Color(0, 0, 0));
        jLabelIngresa.setText("Ingresa numero del piso a consultar");
        jPanel2.add(jLabelIngresa);

        jComboBoxIngresa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "1", "2" }));
        jComboBoxIngresa.setPreferredSize(new java.awt.Dimension(60, 26));
        jComboBoxIngresa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxIngresaItemStateChanged(evt);
            }
        });
        jPanel2.add(jComboBoxIngresa);

        jButtonAceptar.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jButtonAceptar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonAceptarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonAceptarMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButtonAceptarMouseReleased(evt);
            }
        });
        jPanel2.add(jButtonAceptar);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanelFondo.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanelAbajo.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jButtonRegresar.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jButtonRegresar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Regresa.png"))); // NOI18N
        jButtonRegresar.setText("Regresar");
        jButtonRegresar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonRegresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonRegresarMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButtonRegresarMouseReleased(evt);
            }
        });
        jPanelAbajo.add(jButtonRegresar);

        jPanelFondo.add(jPanelAbajo, java.awt.BorderLayout.PAGE_END);

        jTable1.setBackground(new java.awt.Color(153, 255, 153));
        jTable1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 0, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.Habitaci??n", "Piso", "Tipo"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanelFondo.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanelFondo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxIngresaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxIngresaItemStateChanged
        // TODO add your handling code here:
       
     
  
    }//GEN-LAST:event_jComboBoxIngresaItemStateChanged

    private void jButtonAceptarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAceptarMouseEntered
        // TODO add your handling code here:
        this.jButtonAceptar.setBackground(Color.GREEN);
    }//GEN-LAST:event_jButtonAceptarMouseEntered

    private void jButtonAceptarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAceptarMouseExited
        // TODO add your handling code here:
        this.jButtonAceptar.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButtonAceptarMouseExited

    private void jButtonAceptarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAceptarMouseReleased
        // TODO add your handling code here:
         if(this.jComboBoxIngresa.getSelectedItem().equals("-")){
           
            
        }else if(this.jComboBoxIngresa.getSelectedItem().equals("1")){
            
            agregaTabla(1);
        }else{
            agregaTabla(2);
        }
    }//GEN-LAST:event_jButtonAceptarMouseReleased

    private void jButtonRegresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRegresarMouseEntered
        // TODO add your handling code here:
        this.jButtonRegresar.setBackground(Color.GREEN);
    }//GEN-LAST:event_jButtonRegresarMouseEntered

    private void jButtonRegresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRegresarMouseExited
        // TODO add your handling code here:
        this.jButtonRegresar.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButtonRegresarMouseExited

    private void jButtonRegresarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRegresarMouseReleased
        // TODO add your handling code here:
        dispose();
        new MenuConsultas().setVisible(true);
    }//GEN-LAST:event_jButtonRegresarMouseReleased

    private void agregaTabla(int num){
        

        String query="select * from habitacion where piso='"+num+"'";
        
        try{
            this.conn.Consult(query);
            
            int n=0,j,sum=0;
            j=num==1?0:15;
            this.conn.rs.last();
            n=this.conn.rs.getRow();
            this.conn.rs.first();
            
            for (int i = 0; i < n; i++) {
                
               
                j=this.conn.rs.getInt(18);
                 
                Hotel.habitaciones.get(j).setEstado(true);
              
                 this.conn.rs.next();
            }
           
            int limite,inicio;
            limite=num==1?15:30;
            inicio=num==1?0:15;
           
            Object obj[][]=new Object[15-n][3];
            j=0;
            for (int i = inicio; i < limite; i++) {
                
                if(Hotel.habitaciones.get(i).isEstado()){
                    
                }else{
                    obj[j][0]=Hotel.habitaciones.get(i).getNumero();
                    obj[j][1]=Hotel.habitaciones.get(i).getPiso();
                    obj[j][2]=Hotel.habitaciones.get(i).getTipo()==1?"Sencilla":Hotel.habitaciones.get(i).getTipo()==2?"Doble":"Triple";
                    j++;
                    
                }
                
            }
            
            String columnas[]={"No.Habitaci??n","Piso","Tipo"};
            this.jTable1.setModel(new DefaultTableModel(obj,columnas));
            
        }catch(Exception ex){
            
        }
        
        
        
    }
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
            java.util.logging.Logger.getLogger(Consulta9.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consulta9.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consulta9.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consulta9.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consulta9().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonRegresar;
    private javax.swing.JComboBox jComboBoxIngresa;
    private javax.swing.JLabel jLabelIngresa;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelAbajo;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

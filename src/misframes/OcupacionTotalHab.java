/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misframes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Locale;
import misclases.MySqlConn;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author elimtzxd
 */
public class OcupacionTotalHab extends javax.swing.JFrame {
private MySqlConn conn;
 private double porcentaje[]=new double[2];
 private int contador=0;
 private int sencilla, doble, triple, tot;


    /**
     * Creates new form OcupacionTotalHab
     */
    public OcupacionTotalHab() {
        initComponents();
    }

    public OcupacionTotalHab(MySqlConn conn) {
        this.conn = conn;
        initComponents();
        mostrarGrafica();
    }
    
    public void mostrarGrafica(){
        ConsultaHab();
        ConsultaTotalHab();
        CalcularPorcentaje();
        DefaultPieDataset datos= new DefaultPieDataset();
        datos.setValue("Porcentaje de habitaciones ocupadas del hotel", this.porcentaje[0]);
        datos.setValue("Porcentaje de habitaciones desocupadas del hotel",this.porcentaje[1]);
        
        JFreeChart graficos=ChartFactory.createPieChart3D("PORCENTAJE DE OCUPACION EN TODO EL HOTEL", datos, true, true,false);
        ChartPanel mypanel=new ChartPanel(graficos);
        mypanel.setMouseWheelEnabled(true);
        mypanel.setPreferredSize(new Dimension(jPanel1.getSize().width,jPanel1.getSize().height));
        jPanel1.setLayout(new BorderLayout());
        jPanel1.add(mypanel,BorderLayout.NORTH);
        pack();
        repaint();
}
    
    private void ConsultaHab(){
        String query="select * from habitacion";
        this.conn.Consult(query);
        int n=0;
        
        try{
            this.conn.rs.last();
            n=this.conn.rs.getRow();
            this.conn.rs.first();
        }catch(Exception e){
            System.out.println("Error 1");
        }
        if (n!=0) {
            for (int i = 0; i < n; i++) {
            
                try{ 
                    contador++;
                    this.conn.rs.next();
                   
                    
                }catch(Exception e){
                    System.out.println("Error 2");
                }
            }
            }
    }
    
    private void ConsultaTotalHab(){
    String query="select * from contadoreshab where sencilla='" +9+"'";
        this.conn.Consult(query);
        int n=0;
        try{
            this.conn.rs.last();
            n=this.conn.rs.getRow();
            this.conn.rs.first();
        }catch(Exception e){
            System.out.println("Error 1");
        }
        
                try{
                   this.sencilla=conn.rs.getInt(1);
                   this.doble=conn.rs.getInt(2);
                   this.triple=conn.rs.getInt(3);
                   
                }catch(Exception e){
                    System.out.println("Error 2");
                
        }
                tot=sencilla+doble+triple;
}    
    
    
    private void CalcularPorcentaje(){
        
        this.porcentaje[0]=((double) this.contador * 100.0)/this.tot;
        this.porcentaje[1]=((double) (this.tot-this.contador) * 100.0)/this.tot;
        
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
        );

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
            java.util.logging.Logger.getLogger(OcupacionTotalHab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OcupacionTotalHab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OcupacionTotalHab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OcupacionTotalHab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OcupacionTotalHab(new MySqlConn()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}



package misclases;

import java.util.ArrayList;


public class Hotel {
    
    public static ArrayList <Habitacion> habitaciones=new ArrayList();
    
        public Hotel(){
            int num=100;
           int tipo=0;
           int piso=0;
           double costo=0;
            for (int i = 0; i < 30; i++) {
                  if(i==15) num=200;
                if(i<5 ){
                    tipo=Habitacion.TIPO_1;
                    piso=Habitacion.PISO_1;
                    costo=Habitacion.COSTO_1;
                }else if(i<11){
                    tipo=Habitacion.TIPO_2;
                    piso=Habitacion.PISO_1;
                    costo=Habitacion.COSTO_2;
                }else if(i<15){
                    tipo=Habitacion.TIPO_3;
                    piso=Habitacion.PISO_1;
                    costo=Habitacion.COSTO_3;
                }else if(i<19){
                    tipo=Habitacion.TIPO_1;
                    piso=Habitacion.PISO_2;
                    costo=Habitacion.COSTO_1;
                }else if(i<24){
                    tipo=Habitacion.TIPO_2;
                    piso=Habitacion.PISO_2;
                    costo=Habitacion.COSTO_2;
                }else{
                    tipo=Habitacion.TIPO_3;
                    piso=Habitacion.PISO_2;
                    costo=Habitacion.COSTO_3;
                }
                
                
                habitaciones.add(new Habitacion(false,num,tipo,costo,0,piso,null));
                num++;
              
            }
            extraeDatosMySql();
            
        }
        private void extraeDatosMySql(){
            MySqlConn conn=new MySqlConn();
            boolean estado,serviciocuarto,serviciobar,serviciotintoreria,serviciospa,servicioninera,servicioantro,serviciocarro;
            int numero,piso,tipo,total_personas;
            double costo;
            Cliente cliente;
            String nomHuesped,cdOrigen,fechaIng,fechaSal;
            Habitacion hab;
            String query="select * from habitacion";
            try{
                conn.Consult(query);
            }catch(Exception ex){
                
            }
                int n,pos;
            try{
                conn.rs.last();
                n=conn.rs.getRow();
                conn.rs.first();
                if(n>0){
                    for (int i = 0; i < n; i++) {
                        
                        pos=conn.rs.getInt(18);
                        Hotel.habitaciones.get(pos).setEstado(true);
                        conn.rs.next();
                    }
                    
                }else{
                    
                }
             
                
            }catch(Exception ex){
                
                
                
            }
            
            
            
        }
            
    public static void main(String[] args) {
       
        
    }
    
    
    
    
}

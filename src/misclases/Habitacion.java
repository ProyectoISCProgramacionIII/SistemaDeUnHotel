

package misclases;

public class Habitacion {
    public static final int TIPO_1=1,TIPO_2=2,TIPO_3=3,PISO_1=1,PISO_2=2;  
    public static final int MAX_PER_1=3,MAX_PER_2=4,MAX_PER_3=5;
    public static final double COSTO_1=500,COSTO_2=1000,COSTO_3=1500;
    private boolean estado;
    private boolean serviciocuarto,serviciobar,serviciotintoreria,serviciospa,servicioninera,servicioantro,serviciocarro;
    private int numero;
    private int tipo;
    private double costo;
    private int total_personas;
    private int piso;
    private Cliente cliente;
    public Habitacion() {
    }

    public Habitacion(boolean estado, int numero, int tipo, double costo, int total_personas, int piso, Cliente cliente) {
        this.estado = estado;
        this.numero = numero;
        this.tipo = tipo;
        this.costo = costo;
        this.total_personas = total_personas;
        this.piso = piso;
        this.cliente = cliente;
        this.serviciocuarto=false;
        this.serviciobar=false;
        this.serviciotintoreria=false;
        this.serviciospa=false;
        this.servicioninera=false;
        this.servicioantro=false;
        this.serviciocarro=false;
        
        
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getTotal_personas() {
        return total_personas;
    }

    public void setTotal_personas(int total_personas) {
        this.total_personas = total_personas;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isServiciocuarto() {
        return serviciocuarto;
    }

    public void setServiciocuarto(boolean serviciocuarto) {
        this.serviciocuarto = serviciocuarto;
    }

    public boolean isServiciobar() {
        return serviciobar;
    }

    public void setServiciobar(boolean serviciobar) {
        this.serviciobar = serviciobar;
    }

    public boolean isServiciotintoreria() {
        return serviciotintoreria;
    }

    public void setServiciotintoreria(boolean serviciotintoreria) {
        this.serviciotintoreria = serviciotintoreria;
    }

    public boolean isServiciospa() {
        return serviciospa;
    }

    public void setServiciospa(boolean serviciospa) {
        this.serviciospa = serviciospa;
    }

    public boolean isServicioninera() {
        return servicioninera;
    }

    public void setServicioninera(boolean servicioninera) {
        this.servicioninera = servicioninera;
    }

    public boolean isServicioantro() {
        return servicioantro;
    }

    public void setServicioantro(boolean servicioantro) {
        this.servicioantro = servicioantro;
    }

    public boolean isServiciocarro() {
        return serviciocarro;
    }

    public void setServiciocarro(boolean serviciocarro) {
        this.serviciocarro = serviciocarro;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "estado=" + estado + ", serviciocuarto=" + serviciocuarto + ", serviciobar=" + serviciobar + ", serviciotintoreria=" + serviciotintoreria + ", serviciospa=" + serviciospa + ", servicioninera=" + servicioninera + ", servicioantro=" + servicioantro + ", serviciocarro=" + serviciocarro + ", numero=" + numero + ", tipo=" + tipo + ", costo=" + costo + ", total_personas=" + total_personas + ", piso=" + piso + ", cliente=" + cliente + '}';
    }

    
    
    
    
   

  

    
    
    
}

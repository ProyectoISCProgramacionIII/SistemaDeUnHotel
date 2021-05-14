

package misclases;

public class Habitacion {
    public static final int TIPO_1=1,TIPO_2=2,TIPO_3=3,PISO_1=1,PISO_2=2;  
    public static final double COSTO_1=500,COSTO_2=1000,COSTO_3=1500;
    private boolean estado;
    private int numero;
    private int tipo;
    private double costo;
    private int total_personas;
    private int piso;
    public Habitacion() {
    }

    public Habitacion(boolean estado, int numero, int tipo, double costo, int total_personas,int piso) {
        this.estado = estado;
        this.numero = numero;
        this.tipo = tipo;
        this.costo = costo;
        this.total_personas = total_personas;
        this.piso=piso;
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

    @Override
    public String toString() {
        return "Habitacion{" + "estado=" + estado + ", numero=" + numero + ", tipo=" + tipo + ", costo=" + costo + ", total_personas=" + total_personas + ", piso=" + piso + '}';
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    

    
    

    
    
    
}

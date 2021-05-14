
package misclases;

public class Cliente {
    private String nomHuesped,cdOrigen,fechaIng,fechaSal;
    ;

    public Cliente() {
    }

    public Cliente(String nomHuesped, String cdOrigen, String fechaIng, String fechaSal, String nHuespedes, String nPiso, String tOcupantes, String huespExtra) {
        this.nomHuesped = nomHuesped;
        this.cdOrigen = cdOrigen;
        this.fechaIng = fechaIng;
        this.fechaSal = fechaSal;
    }

    public String getNomHuesped() {
        return nomHuesped;
    }

    public void setNomHuesped(String nomHuesped) {
        this.nomHuesped = nomHuesped;
    }

    public String getCdOrigen() {
        return cdOrigen;
    }

    public void setCdOrigen(String cdOrigen) {
        this.cdOrigen = cdOrigen;
    }

    public String getFechaIng() {
        return fechaIng;
    }

    public void setFechaIng(String fechaIng) {
        this.fechaIng = fechaIng;
    }

    public String getFechaSal() {
        return fechaSal;
    }

    public void setFechaSal(String fechaSal) {
        this.fechaSal = fechaSal;
    }
 
}

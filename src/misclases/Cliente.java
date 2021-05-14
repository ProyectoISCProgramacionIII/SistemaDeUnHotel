
package misclases;

public class Cliente {
    private String nomHuesped,cdOrigen,fechaIng,fechaSal,nHuespedes,nPiso,tOcupantes,huespExtra;
    private int numHab,piso,totalOcup,perExt=0,limHuesped;

    public Cliente() {
    }

    public Cliente(String nomHuesped, String cdOrigen, String fechaIng, String fechaSal, String nHuespedes, String nPiso, String tOcupantes, String huespExtra) {
        this.nomHuesped = nomHuesped;
        this.cdOrigen = cdOrigen;
        this.fechaIng = fechaIng;
        this.fechaSal = fechaSal;
        this.nHuespedes = nHuespedes;
        this.nPiso = nPiso;
        this.tOcupantes = tOcupantes;
        this.huespExtra = huespExtra;
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

    public String getnHuespedes() {
        return nHuespedes;
    }

    public void setnHuespedes(String nHuespedes) {
        this.nHuespedes = nHuespedes;
    }

    public String getnPiso() {
        return nPiso;
    }

    public void setnPiso(String nPiso) {
        this.nPiso = nPiso;
    }

    public String gettOcupantes() {
        return tOcupantes;
    }

    public void settOcupantes(String tOcupantes) {
        this.tOcupantes = tOcupantes;
    }

    public String getHuespExtra() {
        return huespExtra;
    }

    public void setHuespExtra(String huespExtra) {
        this.huespExtra = huespExtra;
    }

    public int getNumHab() {
        return numHab;
    }

    public void setNumHab(int numHab) {
        this.numHab = numHab;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getTotalOcup() {
        return totalOcup;
    }

    public void setTotalOcup(int totalOcup) {
        this.totalOcup = totalOcup;
    }

    public int getPerExt() {
        return perExt;
    }

    public void setPerExt(int perExt) {
        this.perExt = perExt;
    }

    public int getLimHuesped() {
        return limHuesped;
    }

    public void setLimHuesped(int limHuesped) {
        this.limHuesped = limHuesped;
    }
 
}

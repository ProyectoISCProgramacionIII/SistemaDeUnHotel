
package misclases;

import java.util.Calendar;
import java.util.Vector;

public class Cliente {
    private String nomHuesped,cdOrigen,fechaIng,fechaSal;
    private Vector <String> servExtr;
    private Calendar actual;
    int totOcupantes, totDias, personasExtr;
    public Cliente() {
    }

    public Cliente(String nomHuesped, String cdOrigen, String fechaIng, String fechaSal, Vector<String> servExtr, Calendar actual,int totOcupantes, int totDias, int perExt) {
        this.nomHuesped = nomHuesped;
        this.cdOrigen = cdOrigen;
        this.fechaIng = fechaIng;
        this.fechaSal = fechaSal;
        this.servExtr = servExtr;
        this.actual = actual;
        this.totOcupantes = totOcupantes;
        this.totDias = totDias;
        this.personasExtr=perExt;
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

    public Vector<String> getServExtr() {
        return servExtr;
    }

    public int getTotOcupantes() {
        return totOcupantes;
    }

    public void setTotOcupantes(int totOcupantes) {
        this.totOcupantes = totOcupantes;
    }
    
    public void setServExtr(Vector<String> servExtr) {
        this.servExtr = servExtr;
    }

    public Calendar getActual() {
        return actual;
    }

    public void setActual(Calendar actual) {
        this.actual = actual;
    }

    public int getTotDias() {
        return totDias;
    }

    public void setTotDias(int totDias) {
        this.totDias = totDias;
    }

    public int getPersonasExtr() {
        return personasExtr;
    }

    public void setPersonasExtr(int personasExtr) {
        this.personasExtr = personasExtr;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nomHuesped=" + nomHuesped + ", cdOrigen=" + cdOrigen + ", fechaIng=" + fechaIng + ", fechaSal=" + fechaSal + ", servExtr=" + servExtr + ", actual=" + actual + ", totOcupantes=" + totOcupantes + '}';
    }
    
    

}

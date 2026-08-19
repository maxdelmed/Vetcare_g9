package com.mycompany.proyectofinalveterinaria;

public class NodoDueno {

    private Dueno dueno;
    private NodoDueno anterior;
    private NodoDueno siguiente;

    public NodoDueno(Dueno dueno) {
        this.dueno = dueno;
        this.anterior = null;
        this.siguiente = null;
    }

    public Dueno getDueno() {
        return dueno;
    }

    public void setDueno(Dueno dueno) {
        this.dueno = dueno;
    }

    public NodoDueno getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDueno anterior) {
        this.anterior = anterior;
    }

    public NodoDueno getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDueno siguiente) {
        this.siguiente = siguiente;
    }
}
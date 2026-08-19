package com.mycompany.proyectofinalveterinaria;

public class NodoCita {

    private Cita cita;
    private NodoCita siguiente;

    public NodoCita(Cita cita) {
        this.cita = cita;
        this.siguiente = null;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public NodoCita getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCita siguiente) {
        this.siguiente = siguiente;
    }
}
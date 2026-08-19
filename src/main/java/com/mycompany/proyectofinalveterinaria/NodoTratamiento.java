package com.mycompany.proyectofinalveterinaria;

public class NodoTratamiento {

    private Tratamiento tratamiento;
    private NodoTratamiento siguiente;

    public NodoTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
        this.siguiente = null;
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }

    public NodoTratamiento getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoTratamiento siguiente) {
        this.siguiente = siguiente;
    }
}

package com.mycompany.proyectofinalveterinaria;

public class NodoConsulta {

    private Consulta consulta;
    private NodoConsulta siguiente;

    public NodoConsulta(Consulta consulta) {
        this.consulta = consulta;
        this.siguiente = null;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public NodoConsulta getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoConsulta siguiente) {
        this.siguiente = siguiente;
    }
}

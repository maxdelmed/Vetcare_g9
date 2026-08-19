package com.mycompany.proyectofinalveterinaria;

public class NodoMascota {

    private Mascota mascota;
    private NodoMascota izquierdo;
    private NodoMascota derecho;

    public NodoMascota(Mascota mascota) {
        this.mascota = mascota;
        this.izquierdo = null;
        this.derecho = null;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public NodoMascota getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoMascota izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoMascota getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoMascota derecho) {
        this.derecho = derecho;
    }
}
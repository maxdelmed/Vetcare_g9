package com.mycompany.proyectofinalveterinaria;

public class PilaEmergencias {

    private NodoEmergencia cima;

    public PilaEmergencias() {
        cima = null;
    }

    public boolean estaVacia() {
        return cima == null;
    }

    public void apilar(Emergencia emergencia) {

        NodoEmergencia nuevo = new NodoEmergencia(emergencia);

        nuevo.setSiguiente(cima);
        cima = nuevo;

        System.out.println("Emergencia registrada correctamente.");
    }

    public Emergencia desapilar() {

        if (estaVacia()) {
            return null;
        }

        Emergencia emergencia = cima.getEmergencia();

        cima = cima.getSiguiente();

        return emergencia;
    }

    public Emergencia verCima() {

        if (estaVacia()) {
            return null;
        }

        return cima.getEmergencia();
    }

    public void mostrarEmergencias() {

        if (estaVacia()) {
            System.out.println("No hay emergencias registradas.");
            return;
        }

        NodoEmergencia actual = cima;

        System.out.println("\n===== EMERGENCIAS =====");

        while (actual != null) {

            System.out.println(actual.getEmergencia());

            actual = actual.getSiguiente();
        }
    }
}
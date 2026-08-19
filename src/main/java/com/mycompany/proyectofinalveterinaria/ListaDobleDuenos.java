package com.mycompany.proyectofinalveterinaria;

public class ListaDobleDuenos {

    private NodoDueno primero;
    private NodoDueno ultimo;

    public ListaDobleDuenos() {
        primero = null;
        ultimo = null;
    }

    public boolean estaVacia() {
        return primero == null;
    }

    public boolean existeDueno(String identificacion) {

        NodoDueno actual = primero;

        while (actual != null) {

            if (actual.getDueno().getIdentificacion()
                    .equalsIgnoreCase(identificacion)) {

                return true;
            }

            actual = actual.getSiguiente();
        }

        return false;
    }

    public void insertar(Dueno dueno) {

        if (existeDueno(dueno.getIdentificacion())) {
            System.out.println("Ya existe un dueno con esa identificacion.");
            return;
        }

        NodoDueno nuevo = new NodoDueno(dueno);

        if (estaVacia()) {

            primero = nuevo;
            ultimo = nuevo;

        } else {

            ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(ultimo);
            ultimo = nuevo;
        }

        System.out.println("Dueno registrado correctamente.");
    }

    public Dueno buscar(String identificacion) {

        NodoDueno actual = primero;

        while (actual != null) {

            if (actual.getDueno().getIdentificacion()
                    .equalsIgnoreCase(identificacion)) {

                return actual.getDueno();
            }

            actual = actual.getSiguiente();
        }

        return null;
    }

    public void mostrarDuenos() {

        if (estaVacia()) {
            System.out.println("No hay duenos registrados.");
            return;
        }

        NodoDueno actual = primero;

        System.out.println("\n===== LISTA DE DUENOS =====");

        while (actual != null) {

            System.out.println(actual.getDueno());

            actual = actual.getSiguiente();
        }
    }

    public void mostrarDuenosReversa() {

        if (estaVacia()) {
            System.out.println("No hay duenos registrados.");
            return;
        }

        NodoDueno actual = ultimo;

        System.out.println("\n===== LISTA DE DUENOS EN REVERSA =====");

        while (actual != null) {

            System.out.println(actual.getDueno());

            actual = actual.getAnterior();
        }
    }
}
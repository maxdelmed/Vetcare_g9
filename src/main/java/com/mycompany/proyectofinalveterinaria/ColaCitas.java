package com.mycompany.proyectofinalveterinaria;

public class ColaCitas {

    private NodoCita frente;
    private NodoCita fin;

    public ColaCitas() {
        frente = null;
        fin = null;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public boolean existeCodigo(String codigoCita) {

        NodoCita actual = frente;

        while (actual != null) {

            if (actual.getCita().getCodigoCita()
                    .equalsIgnoreCase(codigoCita)) {

                return true;
            }

            actual = actual.getSiguiente();
        }

        return false;
    }

    public boolean existeCitaMismoDia(String codigoMascota, String fecha) {

        NodoCita actual = frente;

        while (actual != null) {

            Cita cita = actual.getCita();

            if (cita.getMascota().getCodigo()
                    .equalsIgnoreCase(codigoMascota)
                    && cita.getFecha().equalsIgnoreCase(fecha)
                    && cita.getEstado().equalsIgnoreCase("pendiente")) {

                return true;
            }

            actual = actual.getSiguiente();
        }

        return false;
    }

    public void encolar(Cita cita) {

        if (existeCodigo(cita.getCodigoCita())) {
            System.out.println("Ya existe una cita con ese codigo.");
            return;
        }

        if (existeCitaMismoDia(
                cita.getMascota().getCodigo(),
                cita.getFecha())) {

            System.out.println(
                    "La mascota ya tiene una cita pendiente para ese dia.");
            return;
        }

        NodoCita nuevo = new NodoCita(cita);

        if (estaVacia()) {

            frente = nuevo;
            fin = nuevo;

        } else {

            fin.setSiguiente(nuevo);
            fin = nuevo;
        }

        System.out.println("Cita registrada correctamente.");
    }

    public Cita desencolar() {

        if (estaVacia()) {
            return null;
        }

        Cita cita = frente.getCita();

        frente = frente.getSiguiente();

        if (frente == null) {
            fin = null;
        }

        return cita;
    }

    public Cita verPrimero() {

        if (estaVacia()) {
            return null;
        }

        return frente.getCita();
    }

    public void mostrarCitas() {

        if (estaVacia()) {
            System.out.println("No hay citas pendientes.");
            return;
        }

        NodoCita actual = frente;

        System.out.println("\n===== CITAS PENDIENTES =====");

        while (actual != null) {

            System.out.println(actual.getCita());

            actual = actual.getSiguiente();
        }
    }
}
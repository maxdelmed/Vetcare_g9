package com.mycompany.proyectofinalveterinaria;

public class ArbolMascotas {

    private NodoMascota raiz;

    public ArbolMascotas() {
        raiz = null;
    }

    public boolean estaVacio() {
        return raiz == null;
    }

    public void insertar(Mascota mascota) {

        if (buscar(mascota.getCodigo()) != null) {
            System.out.println("Ya existe una mascota con ese codigo.");
            return;
        }

        NodoMascota nuevo = new NodoMascota(mascota);

        if (raiz == null) {
            raiz = nuevo;
            System.out.println("Mascota registrada correctamente.");
            return;
        }

        NodoMascota actual = raiz;
        NodoMascota padre = null;

        while (actual != null) {

            padre = actual;

            if (mascota.getCodigo().compareToIgnoreCase(
                    actual.getMascota().getCodigo()) < 0) {

                actual = actual.getIzquierdo();

            } else {

                actual = actual.getDerecho();
            }
        }

        if (mascota.getCodigo().compareToIgnoreCase(
                padre.getMascota().getCodigo()) < 0) {

            padre.setIzquierdo(nuevo);

        } else {

            padre.setDerecho(nuevo);
        }

        System.out.println("Mascota registrada correctamente.");
    }

    public Mascota buscar(String codigo) {

        NodoMascota actual = raiz;

        while (actual != null) {

            int comparacion = codigo.compareToIgnoreCase(
                    actual.getMascota().getCodigo());

            if (comparacion == 0) {
                return actual.getMascota();
            }

            if (comparacion < 0) {
                actual = actual.getIzquierdo();
            } else {
                actual = actual.getDerecho();
            }
        }

        return null;
    }

    public NodoMascota buscarNodo(String codigo) {

        NodoMascota actual = raiz;

        while (actual != null) {

            int comparacion = codigo.compareToIgnoreCase(
                    actual.getMascota().getCodigo());

            if (comparacion == 0) {
                return actual;
            }

            if (comparacion < 0) {
                actual = actual.getIzquierdo();
            } else {
                actual = actual.getDerecho();
            }
        }

        return null;
    }

    public void agregarConsulta(String codigoMascota, Consulta consulta) {

        NodoMascota nodo = buscarNodo(codigoMascota);

        if (nodo == null) {
            System.out.println("La mascota no se encuentra registrada.");
            return;
        }

        if (nodo.getHistorial().existeConsulta(
                consulta.getCodigoCita())) {

            System.out.println(
                    "La consulta ya se encuentra en el historial.");
            return;
        }

        nodo.getHistorial().insertar(consulta);
        System.out.println("Consulta agregada al historial.");
    }

    public void mostrarHistorial(String codigoMascota,
            ListaTratamientos tratamientos) {

        NodoMascota nodo = buscarNodo(codigoMascota);

        if (nodo == null) {
            System.out.println("La mascota no se encuentra registrada.");
            return;
        }

        System.out.println("\n===== HISTORIAL MEDICO =====");
        System.out.println(nodo.getMascota());
        nodo.getHistorial().mostrarConsultas();
        tratamientos.mostrarTratamientosMascota(codigoMascota);
    }

    public void mostrarInorden() {

        if (estaVacio()) {
            System.out.println("No hay mascotas registradas.");
            return;
        }

        System.out.println("\n===== MASCOTAS - INORDEN =====");
        inorden(raiz);
    }

    private void inorden(NodoMascota nodo) {

        if (nodo != null) {
            inorden(nodo.getIzquierdo());
            System.out.println(nodo.getMascota());
            inorden(nodo.getDerecho());
        }
    }

    public void mostrarPreorden() {

        if (estaVacio()) {
            System.out.println("No hay mascotas registradas.");
            return;
        }

        System.out.println("\n===== MASCOTAS - PREORDEN =====");
        preorden(raiz);
    }

    private void preorden(NodoMascota nodo) {

        if (nodo != null) {
            System.out.println(nodo.getMascota());
            preorden(nodo.getIzquierdo());
            preorden(nodo.getDerecho());
        }
    }

    public void mostrarPostorden() {

        if (estaVacio()) {
            System.out.println("No hay mascotas registradas.");
            return;
        }

        System.out.println("\n===== MASCOTAS - POSTORDEN =====");
        postorden(raiz);
    }

    private void postorden(NodoMascota nodo) {

        if (nodo != null) {
            postorden(nodo.getIzquierdo());
            postorden(nodo.getDerecho());
            System.out.println(nodo.getMascota());
        }
    }
}

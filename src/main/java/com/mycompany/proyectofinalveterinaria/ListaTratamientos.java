package com.mycompany.proyectofinalveterinaria;

public class ListaTratamientos {

    private NodoTratamiento primero;
    private NodoTratamiento ultimo;

    public ListaTratamientos() {
        primero = null;
        ultimo = null;
    }

    public boolean estaVacia() {
        return primero == null;
    }

    public boolean existeCodigo(String codigo) {
        NodoTratamiento actual = primero;

        while (actual != null) {
            if (actual.getTratamiento().getCodigo()
                    .equalsIgnoreCase(codigo)) {
                return true;
            }

            actual = actual.getSiguiente();
        }

        return false;
    }

    public void insertar(Tratamiento tratamiento) {
        if (existeCodigo(tratamiento.getCodigo())) {
            System.out.println("Ya existe un tratamiento con ese codigo.");
            return;
        }

        NodoTratamiento nuevo = new NodoTratamiento(tratamiento);

        if (estaVacia()) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }

        System.out.println("Tratamiento registrado correctamente.");
    }

    public Tratamiento buscar(String codigo) {
        NodoTratamiento actual = primero;

        while (actual != null) {
            if (actual.getTratamiento().getCodigo()
                    .equalsIgnoreCase(codigo)) {
                return actual.getTratamiento();
            }

            actual = actual.getSiguiente();
        }

        return null;
    }

    public void mostrarTratamientosMascota(String codigoMascota) {
        NodoTratamiento actual = primero;
        boolean encontrado = false;

        System.out.println("\n===== TRATAMIENTOS =====");

        while (actual != null) {
            if (actual.getTratamiento().getMascota().getCodigo()
                    .equalsIgnoreCase(codigoMascota)) {

                System.out.println(actual.getTratamiento());
                encontrado = true;
            }

            actual = actual.getSiguiente();
        }

        if (!encontrado) {
            System.out.println("No hay tratamientos registrados.");
        }
    }
}

package com.mycompany.proyectofinalveterinaria;

public class ListaConsultas {

    private NodoConsulta primero;
    private NodoConsulta ultimo;

    public ListaConsultas() {
        primero = null;
        ultimo = null;
    }

    public boolean estaVacia() {
        return primero == null;
    }

    public boolean existeConsulta(String codigoCita) {
        NodoConsulta actual = primero;

        while (actual != null) {
            if (actual.getConsulta().getCodigoCita()
                    .equalsIgnoreCase(codigoCita)) {
                return true;
            }

            actual = actual.getSiguiente();
        }

        return false;
    }

    public void insertar(Consulta consulta) {
        if (existeConsulta(consulta.getCodigoCita())) {
            System.out.println("La consulta ya se encuentra en el historial.");
            return;
        }

        NodoConsulta nuevo = new NodoConsulta(consulta);

        if (estaVacia()) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }
    }

    public void mostrarConsultas() {
        if (estaVacia()) {
            System.out.println("No hay consultas registradas.");
            return;
        }

        NodoConsulta actual = primero;

        System.out.println("\n===== CONSULTAS REALIZADAS =====");

        while (actual != null) {
            System.out.println(actual.getConsulta());
            actual = actual.getSiguiente();
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinalveterinaria;

import javax.swing.JOptionPane;

/**
 *
 * @author maxde
 * Integrantes: Max De La Fuente Medina, Karen Malespin Alvarado, Jeff Ian Miranda Garro
 */
public class Menu {

    private ListaDobleDuenos listaDuenos;
    private ArbolMascotas arbolMascotas;
    private ColaCitas colaCitas;
    private PilaEmergencias pilaEmergencias;
    private ListaTratamientos listaTratamientos;

    public Menu() {
        listaDuenos = new ListaDobleDuenos();
        arbolMascotas = new ArbolMascotas();
        colaCitas = new ColaCitas();
        pilaEmergencias = new PilaEmergencias();
        listaTratamientos = new ListaTratamientos();
    }

    public void mostrarMenu() {
        String opcion = "";

        while (!opcion.equals("11")) {
            opcion = JOptionPane.showInputDialog(
                    "VETERINARIA VETCARE\n\n"
                    + "1. Registrar dueno\n"
                    + "2. Registrar mascota\n"
                    + "3. Crear cita\n"
                    + "4. Atender cita\n"
                    + "5. Registrar emergencia\n"
                    + "6. Atender emergencia\n"
                    + "7. Registrar tratamiento\n"
                    + "8. Ver historial medico\n"
                    + "9. Ver arbol de mascotas\n"
                    + "10. Ver citas pendientes\n"
                    + "11. Salir\n\n"
                    + "Digite una opcion:");

            if (opcion == null) {
                opcion = "11";
            } else {
                procesarOpcion(opcion.trim());
            }
        }
    }

    private void procesarOpcion(String opcion) {
        switch (opcion) {
            case "1":
                registrarDueno();
                break;
            case "2":
                registrarMascota();
                break;
            case "3":
                crearCita();
                break;
            case "4":
                atenderCita();
                break;
            case "5":
                registrarEmergencia();
                break;
            case "6":
                atenderEmergencia();
                break;
            case "7":
                registrarTratamiento();
                break;
            case "8":
                verHistorial();
                break;
            case "9":
                verArbol();
                break;
            case "10":
                verCitasPendientes();
                break;
            case "11":
                JOptionPane.showMessageDialog(null,
                        "Gracias por usar VetCare.");
                break;
            default:
                JOptionPane.showMessageDialog(null,
                        "La opcion ingresada no es valida.");
        }
    }

    private void registrarDueno() {
        String identificacion = pedirTexto("Identificacion del dueno:");

        if (identificacion == null) {
            return;
        }

        if (listaDuenos.existeDueno(identificacion)) {
            JOptionPane.showMessageDialog(null,
                    "Ya existe un dueno con esa identificacion.");
            return;
        }

        String nombre = pedirTexto("Nombre completo:");
        if (nombre == null) {
            return;
        }

        String telefono = pedirTexto("Telefono:");
        if (telefono == null) {
            return;
        }

        String direccion = pedirTexto("Direccion:");
        if (direccion == null) {
            return;
        }

        String correo = pedirTexto("Correo:");
        if (correo == null) {
            return;
        }

        Dueno dueno = new Dueno(identificacion, nombre,
                telefono, direccion, correo);

        listaDuenos.insertar(dueno);
        JOptionPane.showMessageDialog(null,
                "Dueno registrado correctamente.");
    }

    private void registrarMascota() {
        String codigo = pedirTexto("Codigo de la mascota:");

        if (codigo == null) {
            return;
        }

        if (arbolMascotas.buscar(codigo) != null) {
            JOptionPane.showMessageDialog(null,
                    "Ya existe una mascota con ese codigo.");
            return;
        }

        String identificacion = pedirTexto(
                "Identificacion del dueno de la mascota:");

        if (identificacion == null) {
            return;
        }

        Dueno dueno = listaDuenos.buscar(identificacion);

        if (dueno == null) {
            JOptionPane.showMessageDialog(null,
                    "Primero debe registrar al dueno.");
            return;
        }

        String nombre = pedirTexto("Nombre de la mascota:");
        if (nombre == null) {
            return;
        }

        String especie = pedirTexto("Especie:");
        if (especie == null) {
            return;
        }

        String raza = pedirTexto("Raza:");
        if (raza == null) {
            return;
        }

        Integer edad = pedirEdad();
        if (edad == null) {
            return;
        }

        String estadoMedico = pedirTexto("Estado medico:");
        if (estadoMedico == null) {
            return;
        }

        Mascota mascota = new Mascota(codigo, nombre, especie,
                raza, edad, dueno, estadoMedico);

        arbolMascotas.insertar(mascota);
        JOptionPane.showMessageDialog(null,
                "Mascota registrada correctamente.");
    }

    private void crearCita() {
        String codigoMascota = pedirTexto("Codigo de la mascota:");

        if (codigoMascota == null) {
            return;
        }

        Mascota mascota = arbolMascotas.buscar(codigoMascota);

        if (mascota == null) {
            JOptionPane.showMessageDialog(null,
                    "La mascota no se encuentra registrada.");
            return;
        }

        String codigoCita = pedirTexto("Codigo de la cita:");
        if (codigoCita == null) {
            return;
        }

        if (colaCitas.existeCodigo(codigoCita)) {
            JOptionPane.showMessageDialog(null,
                    "Ya existe una cita con ese codigo.");
            return;
        }

        String motivo = pedirTexto("Motivo de la cita:");
        if (motivo == null) {
            return;
        }

        String fecha = pedirTexto("Fecha de la cita:");
        if (fecha == null) {
            return;
        }

        if (colaCitas.existeCitaMismoDia(codigoMascota, fecha)) {
            JOptionPane.showMessageDialog(null,
                    "La mascota ya tiene una cita pendiente para ese dia.");
            return;
        }

        String hora = pedirTexto("Hora de la cita:");
        if (hora == null) {
            return;
        }

        Cita cita = new Cita(codigoCita, mascota, motivo,
                fecha, hora, "pendiente");

        colaCitas.encolar(cita);
        JOptionPane.showMessageDialog(null,
                "Cita registrada correctamente.");
    }

    private void atenderCita() {
        if (!pilaEmergencias.estaVacia()) {
            JOptionPane.showMessageDialog(null,
                    "Primero debe atender la emergencia pendiente.");
            return;
        }

        Cita cita = colaCitas.desencolar();

        if (cita == null) {
            JOptionPane.showMessageDialog(null,
                    "No hay citas pendientes.");
            return;
        }

        cita.setEstado("atendida");

        Consulta consulta = new Consulta(
                cita.getCodigoCita(),
                cita.getMotivo(),
                cita.getFecha(),
                cita.getHora());

        arbolMascotas.agregarConsulta(
                cita.getMascota().getCodigo(), consulta);

        JOptionPane.showMessageDialog(null,
                "Cita atendida correctamente.\n\n" + cita);
    }

    private void registrarEmergencia() {
        String codigoMascota = pedirTexto("Codigo de la mascota:");

        if (codigoMascota == null) {
            return;
        }

        Mascota mascota = arbolMascotas.buscar(codigoMascota);

        if (mascota == null) {
            JOptionPane.showMessageDialog(null,
                    "La mascota no se encuentra registrada.");
            return;
        }

        String sintomas = pedirTexto("Sintomas:");
        if (sintomas == null) {
            return;
        }

        String nivel = pedirTexto(
                "Nivel de urgencia (bajo, medio o alto):");
        if (nivel == null) {
            return;
        }

        while (!nivel.equalsIgnoreCase("bajo")
                && !nivel.equalsIgnoreCase("medio")
                && !nivel.equalsIgnoreCase("alto")) {

            JOptionPane.showMessageDialog(null,
                    "El nivel debe ser bajo, medio o alto.");

            nivel = pedirTexto(
                    "Nivel de urgencia (bajo, medio o alto):");

            if (nivel == null) {
                return;
            }
        }

        String hora = pedirTexto("Hora de ingreso:");
        if (hora == null) {
            return;
        }

        Emergencia emergencia = new Emergencia(
                mascota, sintomas, nivel, hora);

        pilaEmergencias.apilar(emergencia);
        JOptionPane.showMessageDialog(null,
                "Emergencia registrada correctamente.");
    }

    private void atenderEmergencia() {
        Emergencia emergencia = pilaEmergencias.desapilar();

        if (emergencia == null) {
            JOptionPane.showMessageDialog(null,
                    "No hay emergencias pendientes.");
            return;
        }

        JOptionPane.showMessageDialog(null,
                "Emergencia atendida correctamente.\n\n"
                + emergencia);
    }

    private void registrarTratamiento() {
        String codigoMascota = pedirTexto("Codigo de la mascota:");

        if (codigoMascota == null) {
            return;
        }

        Mascota mascota = arbolMascotas.buscar(codigoMascota);

        if (mascota == null) {
            JOptionPane.showMessageDialog(null,
                    "La mascota no se encuentra registrada.");
            return;
        }

        String codigo = pedirTexto("Codigo del tratamiento:");
        if (codigo == null) {
            return;
        }

        if (listaTratamientos.existeCodigo(codigo)) {
            JOptionPane.showMessageDialog(null,
                    "Ya existe un tratamiento con ese codigo.");
            return;
        }

        String medicamento = pedirTexto("Medicamento:");
        if (medicamento == null) {
            return;
        }

        String dosis = pedirTexto("Dosis:");
        if (dosis == null) {
            return;
        }

        String duracion = pedirTexto("Duracion:");
        if (duracion == null) {
            return;
        }

        String veterinario = pedirTexto("Veterinario responsable:");
        if (veterinario == null) {
            return;
        }

        Tratamiento tratamiento = new Tratamiento(
                codigo, mascota, medicamento, dosis,
                duracion, veterinario);

        listaTratamientos.insertar(tratamiento);
        JOptionPane.showMessageDialog(null,
                "Tratamiento registrado correctamente.");
    }

    private void verHistorial() {
        String codigoMascota = pedirTexto("Codigo de la mascota:");

        if (codigoMascota == null) {
            return;
        }

        if (arbolMascotas.buscar(codigoMascota) == null) {
            JOptionPane.showMessageDialog(null,
                    "La mascota no se encuentra registrada.");
            return;
        }

        arbolMascotas.mostrarHistorial(
                codigoMascota, listaTratamientos);

        JOptionPane.showMessageDialog(null,
                "El historial se mostro en la ventana Output.");
    }

    private void verArbol() {
        String opcion = JOptionPane.showInputDialog(
                "RECORRIDO DEL ARBOL\n\n"
                + "1. Inorden\n"
                + "2. Preorden\n"
                + "3. Postorden\n\n"
                + "Digite una opcion:");

        if (opcion == null) {
            return;
        }

        switch (opcion.trim()) {
            case "1":
                arbolMascotas.mostrarInorden();
                break;
            case "2":
                arbolMascotas.mostrarPreorden();
                break;
            case "3":
                arbolMascotas.mostrarPostorden();
                break;
            default:
                JOptionPane.showMessageDialog(null,
                        "La opcion ingresada no es valida.");
                return;
        }

        JOptionPane.showMessageDialog(null,
                "El recorrido se mostro en la ventana Output.");
    }

    private void verCitasPendientes() {
        colaCitas.mostrarCitas();
        JOptionPane.showMessageDialog(null,
                "Las citas se mostraron en la ventana Output.");
    }

    private String pedirTexto(String mensaje) {
        String dato = JOptionPane.showInputDialog(mensaje);

        while (dato != null && dato.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "El campo no puede quedar vacio.");
            dato = JOptionPane.showInputDialog(mensaje);
        }

        if (dato == null) {
            return null;
        }

        return dato.trim();
    }

    private Integer pedirEdad() {
        while (true) {
            String dato = pedirTexto("Edad de la mascota:");

            if (dato == null) {
                return null;
            }

            try {
                int edad = Integer.parseInt(dato);

                if (edad >= 0) {
                    return edad;
                }

                JOptionPane.showMessageDialog(null,
                        "La edad no puede ser negativa.");

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "La edad debe ser un numero entero.");
            }
        }
    }
}
